package in.etuwa.app.ui.profile.qualifiedexaminations.add;

import android.content.ComponentCallbacks;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.profileasiet.publication.PublicationDropDownResponse;
import in.etuwa.app.databinding.DialogAddQualifiedExaminationBinding;
import in.etuwa.app.ui.base.BaseDialog;
import in.etuwa.app.ui.examregistration.examsubjects.detaildialog.ExamSubjectDetailDialogKt;
import in.etuwa.app.ui.profile.qualifiedexaminations.QualifiedExaminationFragment;
import in.etuwa.app.ui.profile.quality_publication.add.IndexSpinnerAdapter;
import in.etuwa.app.utils.ResolvUtilKt;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.parameter.ParametersHolderKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: AddQualifiedExaminationDialog.kt */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 <2\u00020\u0001:\u0002;<B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0014J\b\u0010\u001e\u001a\u00020\u001dH\u0002J\b\u0010\u001f\u001a\u00020\u001dH\u0002J\b\u0010 \u001a\u00020\u001dH\u0002J\b\u0010!\u001a\u00020\u001dH\u0002J\b\u0010\"\u001a\u00020\u001dH\u0002J\"\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%2\b\u0010'\u001a\u0004\u0018\u00010(H\u0017J\u0012\u0010)\u001a\u00020\u001d2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J&\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u0001012\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\b\u00102\u001a\u00020\u001dH\u0016J\b\u00103\u001a\u00020\u001dH\u0016J\u001a\u00104\u001a\u00020\u001d2\u0006\u00105\u001a\u00020-2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u000e\u00106\u001a\u00020\u001d2\u0006\u00107\u001a\u000208J\b\u00109\u001a\u00020\u001dH\u0015J\b\u0010:\u001a\u00020\u001dH\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\n\u001a\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lin/etuwa/app/ui/profile/qualifiedexaminations/add/AddQualifiedExaminationDialog;", "Lin/etuwa/app/ui/base/BaseDialog;", "()V", "_binding", "Lin/etuwa/app/databinding/DialogAddQualifiedExaminationBinding;", "addQualifiedExaminationViewModel", "Lin/etuwa/app/ui/profile/qualifiedexaminations/add/AddQualifiedExaminationViewModel;", "getAddQualifiedExaminationViewModel", "()Lin/etuwa/app/ui/profile/qualifiedexaminations/add/AddQualifiedExaminationViewModel;", "addQualifiedExaminationViewModel$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lin/etuwa/app/databinding/DialogAddQualifiedExaminationBinding;", "id", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/profile/qualifiedexaminations/add/AddQualifiedExaminationDialog$AddQualifiedExaminationListener;", "name", "pickFile", "Ljava/io/File;", FirebaseAnalytics.Param.SCORE, "spinnerAdapter", "Lin/etuwa/app/ui/profile/quality_publication/add/IndexSpinnerAdapter;", "getSpinnerAdapter", "()Lin/etuwa/app/ui/profile/quality_publication/add/IndexSpinnerAdapter;", "spinnerAdapter$delegate", "yearId", "hideProgress", "", "listenAddResponse", "listenAddResponse2", "listenProgressResponse", "listenSpinnerResponse", "listenUpdateResponse", "onActivityResult", "requestCode", "", "resultCode", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDetach", "onViewCreated", SvgConstants.Tags.VIEW, "setCallBack", "context", "Lin/etuwa/app/ui/profile/qualifiedexaminations/QualifiedExaminationFragment;", "setUp", "showProgress", "AddQualifiedExaminationListener", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AddQualifiedExaminationDialog extends BaseDialog {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private DialogAddQualifiedExaminationBinding _binding;

    /* renamed from: addQualifiedExaminationViewModel$delegate, reason: from kotlin metadata */
    private final Lazy addQualifiedExaminationViewModel;
    private String id;
    private AddQualifiedExaminationListener listener;
    private String name;
    private File pickFile;
    private String score;

    /* renamed from: spinnerAdapter$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdapter;
    private String yearId;

    /* compiled from: AddQualifiedExaminationDialog.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lin/etuwa/app/ui/profile/qualifiedexaminations/add/AddQualifiedExaminationDialog$AddQualifiedExaminationListener;", "", "onDismiss", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface AddQualifiedExaminationListener {
        void onDismiss();
    }

    /* compiled from: AddQualifiedExaminationDialog.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Status.values().length];
            try {
                iArr[Status.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Status.LOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Status.ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Status.EXCEPTION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @JvmStatic
    public static final AddQualifiedExaminationDialog newInstance(String str, String str2, String str3) {
        return INSTANCE.newInstance(str, str2, str3);
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void showProgress() {
    }

    public AddQualifiedExaminationDialog() {
        final AddQualifiedExaminationDialog addQualifiedExaminationDialog = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.profile.qualifiedexaminations.add.AddQualifiedExaminationDialog$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(addQualifiedExaminationDialog);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.addQualifiedExaminationViewModel = FragmentViewModelLazyKt.createViewModelLazy(addQualifiedExaminationDialog, Reflection.getOrCreateKotlinClass(AddQualifiedExaminationViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.profile.qualifiedexaminations.add.AddQualifiedExaminationDialog$special$$inlined$viewModel$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) Function0.this.invoke()).getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.profile.qualifiedexaminations.add.AddQualifiedExaminationDialog$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(AddQualifiedExaminationViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final AddQualifiedExaminationDialog addQualifiedExaminationDialog2 = this;
        final Function0<ParametersHolder> function02 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.profile.qualifiedexaminations.add.AddQualifiedExaminationDialog$spinnerAdapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(AddQualifiedExaminationDialog.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        this.spinnerAdapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<IndexSpinnerAdapter>() { // from class: in.etuwa.app.ui.profile.qualifiedexaminations.add.AddQualifiedExaminationDialog$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.profile.quality_publication.add.IndexSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final IndexSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = addQualifiedExaminationDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(IndexSpinnerAdapter.class), b2, function02);
            }
        });
    }

    private final AddQualifiedExaminationViewModel getAddQualifiedExaminationViewModel() {
        return (AddQualifiedExaminationViewModel) this.addQualifiedExaminationViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getBinding, reason: from getter */
    public final DialogAddQualifiedExaminationBinding get_binding() {
        return this._binding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IndexSpinnerAdapter getSpinnerAdapter() {
        return (IndexSpinnerAdapter) this.spinnerAdapter.getValue();
    }

    /* compiled from: AddQualifiedExaminationDialog.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0007¨\u0006\t"}, d2 = {"Lin/etuwa/app/ui/profile/qualifiedexaminations/add/AddQualifiedExaminationDialog$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/profile/qualifiedexaminations/add/AddQualifiedExaminationDialog;", "id", "", "name", FirebaseAnalytics.Param.SCORE, "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final AddQualifiedExaminationDialog newInstance(String id, String name, String score) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(score, "score");
            AddQualifiedExaminationDialog addQualifiedExaminationDialog = new AddQualifiedExaminationDialog();
            Bundle bundle = new Bundle();
            bundle.putString("flag", id);
            bundle.putString(ExamSubjectDetailDialogKt.ARG_AMOUNT, name);
            bundle.putString("url", score);
            addQualifiedExaminationDialog.setArguments(bundle);
            return addQualifiedExaminationDialog;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.id = arguments.getString("flag");
            this.name = arguments.getString(ExamSubjectDetailDialogKt.ARG_AMOUNT);
            this.score = arguments.getString("url");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = DialogAddQualifiedExaminationBinding.inflate(inflater, container, false);
        DialogAddQualifiedExaminationBinding dialogAddQualifiedExaminationBinding = get_binding();
        if (dialogAddQualifiedExaminationBinding != null) {
            dialogAddQualifiedExaminationBinding.setAddQualifiedExaminationViewModel(getAddQualifiedExaminationViewModel());
        }
        DialogAddQualifiedExaminationBinding dialogAddQualifiedExaminationBinding2 = get_binding();
        if (dialogAddQualifiedExaminationBinding2 != null) {
            dialogAddQualifiedExaminationBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        DialogAddQualifiedExaminationBinding dialogAddQualifiedExaminationBinding3 = get_binding();
        if (dialogAddQualifiedExaminationBinding3 != null) {
            return dialogAddQualifiedExaminationBinding3.getRoot();
        }
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setUp();
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void setUp() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextInputEditText textInputEditText;
        TextInputEditText textInputEditText2;
        DialogAddQualifiedExaminationBinding dialogAddQualifiedExaminationBinding = get_binding();
        Spinner spinner = dialogAddQualifiedExaminationBinding != null ? dialogAddQualifiedExaminationBinding.spinnerYear : null;
        if (spinner != null) {
            spinner.setAdapter((SpinnerAdapter) getSpinnerAdapter());
        }
        listenSpinnerResponse();
        listenProgressResponse();
        listenUpdateResponse();
        listenAddResponse();
        listenAddResponse2();
        getAddQualifiedExaminationViewModel().getDropDownData();
        if (!Intrinsics.areEqual(this.id, "")) {
            DialogAddQualifiedExaminationBinding dialogAddQualifiedExaminationBinding2 = get_binding();
            TextView textView4 = dialogAddQualifiedExaminationBinding2 != null ? dialogAddQualifiedExaminationBinding2.addBtn : null;
            if (textView4 != null) {
                textView4.setVisibility(8);
            }
            DialogAddQualifiedExaminationBinding dialogAddQualifiedExaminationBinding3 = get_binding();
            TextView textView5 = dialogAddQualifiedExaminationBinding3 != null ? dialogAddQualifiedExaminationBinding3.updateBtn : null;
            if (textView5 != null) {
                textView5.setVisibility(0);
            }
        } else {
            DialogAddQualifiedExaminationBinding dialogAddQualifiedExaminationBinding4 = get_binding();
            TextView textView6 = dialogAddQualifiedExaminationBinding4 != null ? dialogAddQualifiedExaminationBinding4.addBtn : null;
            if (textView6 != null) {
                textView6.setVisibility(0);
            }
            DialogAddQualifiedExaminationBinding dialogAddQualifiedExaminationBinding5 = get_binding();
            TextView textView7 = dialogAddQualifiedExaminationBinding5 != null ? dialogAddQualifiedExaminationBinding5.updateBtn : null;
            if (textView7 != null) {
                textView7.setVisibility(8);
            }
        }
        DialogAddQualifiedExaminationBinding dialogAddQualifiedExaminationBinding6 = get_binding();
        if (dialogAddQualifiedExaminationBinding6 != null && (textInputEditText2 = dialogAddQualifiedExaminationBinding6.etName) != null) {
            textInputEditText2.setText(this.name);
        }
        DialogAddQualifiedExaminationBinding dialogAddQualifiedExaminationBinding7 = get_binding();
        if (dialogAddQualifiedExaminationBinding7 != null && (textInputEditText = dialogAddQualifiedExaminationBinding7.etScore) != null) {
            textInputEditText.setText(this.score);
        }
        DialogAddQualifiedExaminationBinding dialogAddQualifiedExaminationBinding8 = get_binding();
        Spinner spinner2 = dialogAddQualifiedExaminationBinding8 != null ? dialogAddQualifiedExaminationBinding8.spinnerYear : null;
        if (spinner2 != null) {
            spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.profile.qualifiedexaminations.add.AddQualifiedExaminationDialog$setUp$1
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    IndexSpinnerAdapter spinnerAdapter;
                    AddQualifiedExaminationDialog addQualifiedExaminationDialog = AddQualifiedExaminationDialog.this;
                    spinnerAdapter = addQualifiedExaminationDialog.getSpinnerAdapter();
                    addQualifiedExaminationDialog.yearId = String.valueOf(spinnerAdapter.getSemester(position).getId());
                }
            });
        }
        DialogAddQualifiedExaminationBinding dialogAddQualifiedExaminationBinding9 = get_binding();
        if (dialogAddQualifiedExaminationBinding9 != null && (textView3 = dialogAddQualifiedExaminationBinding9.completionSelect) != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.profile.qualifiedexaminations.add.AddQualifiedExaminationDialog$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AddQualifiedExaminationDialog.setUp$lambda$2(AddQualifiedExaminationDialog.this, view);
                }
            });
        }
        DialogAddQualifiedExaminationBinding dialogAddQualifiedExaminationBinding10 = get_binding();
        if (dialogAddQualifiedExaminationBinding10 != null && (textView2 = dialogAddQualifiedExaminationBinding10.addBtn) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.profile.qualifiedexaminations.add.AddQualifiedExaminationDialog$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AddQualifiedExaminationDialog.setUp$lambda$3(AddQualifiedExaminationDialog.this, view);
                }
            });
        }
        DialogAddQualifiedExaminationBinding dialogAddQualifiedExaminationBinding11 = get_binding();
        if (dialogAddQualifiedExaminationBinding11 == null || (textView = dialogAddQualifiedExaminationBinding11.updateBtn) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.profile.qualifiedexaminations.add.AddQualifiedExaminationDialog$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AddQualifiedExaminationDialog.setUp$lambda$4(AddQualifiedExaminationDialog.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$2(AddQualifiedExaminationDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", false);
        intent.setType("*/*");
        this$0.startActivityForResult(Intent.createChooser(intent, "Select a file"), 111);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$3(AddQualifiedExaminationDialog this$0, View view) {
        TextView textView;
        TextInputEditText textInputEditText;
        TextInputEditText textInputEditText2;
        TextView textView2;
        TextInputEditText textInputEditText3;
        TextView textView3;
        TextInputEditText textInputEditText4;
        TextView textView4;
        TextInputEditText textInputEditText5;
        TextInputEditText textInputEditText6;
        TextView textView5;
        TextInputEditText textInputEditText7;
        TextView textView6;
        TextInputEditText textInputEditText8;
        TextView textView7;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            DialogAddQualifiedExaminationBinding dialogAddQualifiedExaminationBinding = this$0.get_binding();
            if (String.valueOf((dialogAddQualifiedExaminationBinding == null || (textView7 = dialogAddQualifiedExaminationBinding.completionFileName) == null) ? null : textView7.getText()).length() > 0) {
                File file = this$0.pickFile;
                if (file == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pickFile");
                    file = null;
                }
                if (file.length() / 1024 <= 100) {
                    this$0.setCancelable(false);
                    DialogAddQualifiedExaminationBinding dialogAddQualifiedExaminationBinding2 = this$0.get_binding();
                    if (Intrinsics.areEqual(String.valueOf((dialogAddQualifiedExaminationBinding2 == null || (textInputEditText8 = dialogAddQualifiedExaminationBinding2.etName) == null) ? null : textInputEditText8.getText()), "")) {
                        DialogAddQualifiedExaminationBinding dialogAddQualifiedExaminationBinding3 = this$0.get_binding();
                        if (dialogAddQualifiedExaminationBinding3 == null || (textView6 = dialogAddQualifiedExaminationBinding3.completionSelect) == null) {
                            return;
                        }
                        ToastExtKt.showInfoToast(textView6, "Name of Exam cannot be empty");
                        return;
                    }
                    DialogAddQualifiedExaminationBinding dialogAddQualifiedExaminationBinding4 = this$0.get_binding();
                    if (Intrinsics.areEqual(String.valueOf((dialogAddQualifiedExaminationBinding4 == null || (textInputEditText7 = dialogAddQualifiedExaminationBinding4.etScore) == null) ? null : textInputEditText7.getText()), "")) {
                        DialogAddQualifiedExaminationBinding dialogAddQualifiedExaminationBinding5 = this$0.get_binding();
                        if (dialogAddQualifiedExaminationBinding5 == null || (textView5 = dialogAddQualifiedExaminationBinding5.completionSelect) == null) {
                            return;
                        }
                        ToastExtKt.showInfoToast(textView5, "Score/Grade cannot be empty");
                        return;
                    }
                    AddQualifiedExaminationViewModel addQualifiedExaminationViewModel = this$0.getAddQualifiedExaminationViewModel();
                    DialogAddQualifiedExaminationBinding dialogAddQualifiedExaminationBinding6 = this$0.get_binding();
                    String valueOf = String.valueOf((dialogAddQualifiedExaminationBinding6 == null || (textInputEditText6 = dialogAddQualifiedExaminationBinding6.etName) == null) ? null : textInputEditText6.getText());
                    DialogAddQualifiedExaminationBinding dialogAddQualifiedExaminationBinding7 = this$0.get_binding();
                    String valueOf2 = String.valueOf((dialogAddQualifiedExaminationBinding7 == null || (textInputEditText5 = dialogAddQualifiedExaminationBinding7.etScore) == null) ? null : textInputEditText5.getText());
                    String str = this$0.yearId;
                    Intrinsics.checkNotNull(str);
                    File file2 = this$0.pickFile;
                    if (file2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("pickFile");
                        file2 = null;
                    }
                    addQualifiedExaminationViewModel.addQualifiedExaminationData(valueOf, valueOf2, str, file2);
                    DialogAddQualifiedExaminationBinding dialogAddQualifiedExaminationBinding8 = this$0.get_binding();
                    LinearLayout linearLayout = dialogAddQualifiedExaminationBinding8 != null ? dialogAddQualifiedExaminationBinding8.completionCard : null;
                    if (linearLayout != null) {
                        linearLayout.setVisibility(8);
                    }
                    DialogAddQualifiedExaminationBinding dialogAddQualifiedExaminationBinding9 = this$0.get_binding();
                    CardView cardView = dialogAddQualifiedExaminationBinding9 != null ? dialogAddQualifiedExaminationBinding9.progressView : null;
                    if (cardView == null) {
                        return;
                    }
                    cardView.setVisibility(0);
                    return;
                }
                DialogAddQualifiedExaminationBinding dialogAddQualifiedExaminationBinding10 = this$0.get_binding();
                if (dialogAddQualifiedExaminationBinding10 == null || (textView4 = dialogAddQualifiedExaminationBinding10.completionSelect) == null) {
                    return;
                }
                ToastExtKt.showInfoToast(textView4, "File Size Limit Is 100KB");
                return;
            }
            DialogAddQualifiedExaminationBinding dialogAddQualifiedExaminationBinding11 = this$0.get_binding();
            if (Intrinsics.areEqual(String.valueOf((dialogAddQualifiedExaminationBinding11 == null || (textInputEditText4 = dialogAddQualifiedExaminationBinding11.etName) == null) ? null : textInputEditText4.getText()), "")) {
                DialogAddQualifiedExaminationBinding dialogAddQualifiedExaminationBinding12 = this$0.get_binding();
                if (dialogAddQualifiedExaminationBinding12 == null || (textView3 = dialogAddQualifiedExaminationBinding12.completionSelect) == null) {
                    return;
                }
                ToastExtKt.showInfoToast(textView3, "Name of Exam cannot be empty");
                return;
            }
            DialogAddQualifiedExaminationBinding dialogAddQualifiedExaminationBinding13 = this$0.get_binding();
            if (Intrinsics.areEqual(String.valueOf((dialogAddQualifiedExaminationBinding13 == null || (textInputEditText3 = dialogAddQualifiedExaminationBinding13.etScore) == null) ? null : textInputEditText3.getText()), "")) {
                DialogAddQualifiedExaminationBinding dialogAddQualifiedExaminationBinding14 = this$0.get_binding();
                if (dialogAddQualifiedExaminationBinding14 == null || (textView2 = dialogAddQualifiedExaminationBinding14.completionSelect) == null) {
                    return;
                }
                ToastExtKt.showInfoToast(textView2, "Score/Grade cannot be empty");
                return;
            }
            AddQualifiedExaminationViewModel addQualifiedExaminationViewModel2 = this$0.getAddQualifiedExaminationViewModel();
            DialogAddQualifiedExaminationBinding dialogAddQualifiedExaminationBinding15 = this$0.get_binding();
            String valueOf3 = String.valueOf((dialogAddQualifiedExaminationBinding15 == null || (textInputEditText2 = dialogAddQualifiedExaminationBinding15.etName) == null) ? null : textInputEditText2.getText());
            DialogAddQualifiedExaminationBinding dialogAddQualifiedExaminationBinding16 = this$0.get_binding();
            String valueOf4 = String.valueOf((dialogAddQualifiedExaminationBinding16 == null || (textInputEditText = dialogAddQualifiedExaminationBinding16.etScore) == null) ? null : textInputEditText.getText());
            String str2 = this$0.yearId;
            Intrinsics.checkNotNull(str2);
            addQualifiedExaminationViewModel2.addQualifiedExaminationData(valueOf3, valueOf4, str2);
            DialogAddQualifiedExaminationBinding dialogAddQualifiedExaminationBinding17 = this$0.get_binding();
            LinearLayout linearLayout2 = dialogAddQualifiedExaminationBinding17 != null ? dialogAddQualifiedExaminationBinding17.completionCard : null;
            if (linearLayout2 == null) {
                return;
            }
            linearLayout2.setVisibility(8);
        } catch (Exception unused) {
            DialogAddQualifiedExaminationBinding dialogAddQualifiedExaminationBinding18 = this$0.get_binding();
            if (dialogAddQualifiedExaminationBinding18 == null || (textView = dialogAddQualifiedExaminationBinding18.addBtn) == null) {
                return;
            }
            ToastExtKt.showErrorToast(textView, "Something went wrong.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$4(AddQualifiedExaminationDialog this$0, View view) {
        TextInputEditText textInputEditText;
        TextInputEditText textInputEditText2;
        TextView textView;
        TextInputEditText textInputEditText3;
        TextView textView2;
        TextInputEditText textInputEditText4;
        TextView textView3;
        File file;
        TextInputEditText textInputEditText5;
        TextInputEditText textInputEditText6;
        TextView textView4;
        TextInputEditText textInputEditText7;
        TextView textView5;
        TextInputEditText textInputEditText8;
        TextView textView6;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            DialogAddQualifiedExaminationBinding dialogAddQualifiedExaminationBinding = this$0.get_binding();
            Editable editable = null;
            editable = null;
            if (String.valueOf((dialogAddQualifiedExaminationBinding == null || (textView6 = dialogAddQualifiedExaminationBinding.completionFileName) == null) ? null : textView6.getText()).length() > 0) {
                File file2 = this$0.pickFile;
                if (file2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pickFile");
                    file2 = null;
                }
                if (file2.length() / 1024 <= 100) {
                    this$0.setCancelable(false);
                    DialogAddQualifiedExaminationBinding dialogAddQualifiedExaminationBinding2 = this$0.get_binding();
                    if (Intrinsics.areEqual(String.valueOf((dialogAddQualifiedExaminationBinding2 == null || (textInputEditText8 = dialogAddQualifiedExaminationBinding2.etName) == null) ? null : textInputEditText8.getText()), "")) {
                        DialogAddQualifiedExaminationBinding dialogAddQualifiedExaminationBinding3 = this$0.get_binding();
                        if (dialogAddQualifiedExaminationBinding3 == null || (textView5 = dialogAddQualifiedExaminationBinding3.completionSelect) == null) {
                            return;
                        }
                        ToastExtKt.showInfoToast(textView5, "Name of Exam cannot be empty");
                        return;
                    }
                    DialogAddQualifiedExaminationBinding dialogAddQualifiedExaminationBinding4 = this$0.get_binding();
                    if (Intrinsics.areEqual(String.valueOf((dialogAddQualifiedExaminationBinding4 == null || (textInputEditText7 = dialogAddQualifiedExaminationBinding4.etScore) == null) ? null : textInputEditText7.getText()), "")) {
                        DialogAddQualifiedExaminationBinding dialogAddQualifiedExaminationBinding5 = this$0.get_binding();
                        if (dialogAddQualifiedExaminationBinding5 == null || (textView4 = dialogAddQualifiedExaminationBinding5.completionSelect) == null) {
                            return;
                        }
                        ToastExtKt.showInfoToast(textView4, "Score/Grade cannot be empty");
                        return;
                    }
                    AddQualifiedExaminationViewModel addQualifiedExaminationViewModel = this$0.getAddQualifiedExaminationViewModel();
                    String str = this$0.id;
                    Intrinsics.checkNotNull(str);
                    DialogAddQualifiedExaminationBinding dialogAddQualifiedExaminationBinding6 = this$0.get_binding();
                    String valueOf = String.valueOf((dialogAddQualifiedExaminationBinding6 == null || (textInputEditText6 = dialogAddQualifiedExaminationBinding6.etName) == null) ? null : textInputEditText6.getText());
                    DialogAddQualifiedExaminationBinding dialogAddQualifiedExaminationBinding7 = this$0.get_binding();
                    String valueOf2 = String.valueOf((dialogAddQualifiedExaminationBinding7 == null || (textInputEditText5 = dialogAddQualifiedExaminationBinding7.etScore) == null) ? null : textInputEditText5.getText());
                    String str2 = this$0.yearId;
                    Intrinsics.checkNotNull(str2);
                    File file3 = this$0.pickFile;
                    if (file3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("pickFile");
                        file = null;
                    } else {
                        file = file3;
                    }
                    addQualifiedExaminationViewModel.updateQualifiedExaminationData(str, valueOf, valueOf2, str2, file);
                    DialogAddQualifiedExaminationBinding dialogAddQualifiedExaminationBinding8 = this$0.get_binding();
                    LinearLayout linearLayout = dialogAddQualifiedExaminationBinding8 != null ? dialogAddQualifiedExaminationBinding8.completionCard : null;
                    if (linearLayout != null) {
                        linearLayout.setVisibility(8);
                    }
                    DialogAddQualifiedExaminationBinding dialogAddQualifiedExaminationBinding9 = this$0.get_binding();
                    CardView cardView = dialogAddQualifiedExaminationBinding9 != null ? dialogAddQualifiedExaminationBinding9.progressView : null;
                    if (cardView == null) {
                        return;
                    }
                    cardView.setVisibility(0);
                    return;
                }
                DialogAddQualifiedExaminationBinding dialogAddQualifiedExaminationBinding10 = this$0.get_binding();
                if (dialogAddQualifiedExaminationBinding10 == null || (textView3 = dialogAddQualifiedExaminationBinding10.completionSelect) == null) {
                    return;
                }
                ToastExtKt.showInfoToast(textView3, "File Size Limit Is 100KB");
                return;
            }
            DialogAddQualifiedExaminationBinding dialogAddQualifiedExaminationBinding11 = this$0.get_binding();
            if (Intrinsics.areEqual(String.valueOf((dialogAddQualifiedExaminationBinding11 == null || (textInputEditText4 = dialogAddQualifiedExaminationBinding11.etName) == null) ? null : textInputEditText4.getText()), "")) {
                DialogAddQualifiedExaminationBinding dialogAddQualifiedExaminationBinding12 = this$0.get_binding();
                if (dialogAddQualifiedExaminationBinding12 == null || (textView2 = dialogAddQualifiedExaminationBinding12.completionSelect) == null) {
                    return;
                }
                ToastExtKt.showInfoToast(textView2, "Name of Exam cannot be empty");
                return;
            }
            DialogAddQualifiedExaminationBinding dialogAddQualifiedExaminationBinding13 = this$0.get_binding();
            if (Intrinsics.areEqual(String.valueOf((dialogAddQualifiedExaminationBinding13 == null || (textInputEditText3 = dialogAddQualifiedExaminationBinding13.etScore) == null) ? null : textInputEditText3.getText()), "")) {
                DialogAddQualifiedExaminationBinding dialogAddQualifiedExaminationBinding14 = this$0.get_binding();
                if (dialogAddQualifiedExaminationBinding14 == null || (textView = dialogAddQualifiedExaminationBinding14.completionSelect) == null) {
                    return;
                }
                ToastExtKt.showInfoToast(textView, "Score/Grade cannot be empty");
                return;
            }
            AddQualifiedExaminationViewModel addQualifiedExaminationViewModel2 = this$0.getAddQualifiedExaminationViewModel();
            String str3 = this$0.id;
            Intrinsics.checkNotNull(str3);
            DialogAddQualifiedExaminationBinding dialogAddQualifiedExaminationBinding15 = this$0.get_binding();
            String valueOf3 = String.valueOf((dialogAddQualifiedExaminationBinding15 == null || (textInputEditText2 = dialogAddQualifiedExaminationBinding15.etName) == null) ? null : textInputEditText2.getText());
            DialogAddQualifiedExaminationBinding dialogAddQualifiedExaminationBinding16 = this$0.get_binding();
            if (dialogAddQualifiedExaminationBinding16 != null && (textInputEditText = dialogAddQualifiedExaminationBinding16.etScore) != null) {
                editable = textInputEditText.getText();
            }
            String valueOf4 = String.valueOf(editable);
            String str4 = this$0.yearId;
            Intrinsics.checkNotNull(str4);
            addQualifiedExaminationViewModel2.updateQualifiedExaminationData(str3, valueOf3, valueOf4, str4);
        } catch (Exception unused) {
        }
    }

    private final void listenSpinnerResponse() {
        getAddQualifiedExaminationViewModel().getResponse().observe(getViewLifecycleOwner(), new AddQualifiedExaminationDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends PublicationDropDownResponse>, Unit>() { // from class: in.etuwa.app.ui.profile.qualifiedexaminations.add.AddQualifiedExaminationDialog$listenSpinnerResponse$1

            /* compiled from: AddQualifiedExaminationDialog.kt */
            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[Status.values().length];
                    try {
                        iArr[Status.SUCCESS.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[Status.LOADING.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[Status.ERROR.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[Status.EXCEPTION.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends PublicationDropDownResponse> resource) {
                invoke2((Resource<PublicationDropDownResponse>) resource);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<PublicationDropDownResponse> resource) {
                IndexSpinnerAdapter spinnerAdapter;
                DialogAddQualifiedExaminationBinding dialogAddQualifiedExaminationBinding;
                Spinner spinner;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i == 1) {
                    AddQualifiedExaminationDialog.this.hideProgress();
                    PublicationDropDownResponse data = resource.getData();
                    if (data != null) {
                        try {
                            spinnerAdapter = AddQualifiedExaminationDialog.this.getSpinnerAdapter();
                            spinnerAdapter.addItems(data.getYears());
                            return;
                        } catch (NullPointerException unused) {
                            return;
                        }
                    }
                    return;
                }
                if (i == 2) {
                    AddQualifiedExaminationDialog.this.showProgress();
                    return;
                }
                if (i == 3) {
                    AddQualifiedExaminationDialog.this.hideProgress();
                    return;
                }
                if (i != 4) {
                    return;
                }
                AddQualifiedExaminationDialog.this.hideProgress();
                dialogAddQualifiedExaminationBinding = AddQualifiedExaminationDialog.this.get_binding();
                if (dialogAddQualifiedExaminationBinding == null || (spinner = dialogAddQualifiedExaminationBinding.spinnerYear) == null) {
                    return;
                }
                String message = resource.getMessage();
                Intrinsics.checkNotNull(message);
                ToastExtKt.showErrorToast(spinner, message);
            }
        }));
    }

    private final void listenAddResponse() {
        getAddQualifiedExaminationViewModel().getAddResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.profile.qualifiedexaminations.add.AddQualifiedExaminationDialog$$ExternalSyntheticLambda3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AddQualifiedExaminationDialog.listenAddResponse$lambda$6(AddQualifiedExaminationDialog.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenAddResponse$lambda$6(AddQualifiedExaminationDialog this$0, Resource resource) {
        TextView addBtn;
        TextView addBtn2;
        TextView textView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i != 1) {
            if (i == 3) {
                this$0.hideProgress();
                return;
            }
            if (i != 4) {
                return;
            }
            this$0.hideProgress();
            DialogAddQualifiedExaminationBinding dialogAddQualifiedExaminationBinding = this$0.get_binding();
            if (dialogAddQualifiedExaminationBinding != null && (textView = dialogAddQualifiedExaminationBinding.completionFileName) != null) {
                String message = resource.getMessage();
                Intrinsics.checkNotNull(message);
                ToastExtKt.showErrorToast(textView, message);
            }
            this$0.dismiss();
            AddQualifiedExaminationListener addQualifiedExaminationListener = this$0.listener;
            if (addQualifiedExaminationListener != null) {
                addQualifiedExaminationListener.onDismiss();
                return;
            }
            return;
        }
        this$0.hideProgress();
        SuccessResponse successResponse = (SuccessResponse) resource.getData();
        if (successResponse != null) {
            if (successResponse.getSuccess()) {
                DialogAddQualifiedExaminationBinding dialogAddQualifiedExaminationBinding2 = this$0.get_binding();
                if (dialogAddQualifiedExaminationBinding2 != null && (addBtn2 = dialogAddQualifiedExaminationBinding2.addBtn) != null) {
                    Intrinsics.checkNotNullExpressionValue(addBtn2, "addBtn");
                    ToastExtKt.showSuccessToast(addBtn2, successResponse.getMessage());
                }
                AddQualifiedExaminationListener addQualifiedExaminationListener2 = this$0.listener;
                if (addQualifiedExaminationListener2 != null) {
                    addQualifiedExaminationListener2.onDismiss();
                }
                this$0.dismiss();
                return;
            }
            DialogAddQualifiedExaminationBinding dialogAddQualifiedExaminationBinding3 = this$0.get_binding();
            if (dialogAddQualifiedExaminationBinding3 != null && (addBtn = dialogAddQualifiedExaminationBinding3.addBtn) != null) {
                Intrinsics.checkNotNullExpressionValue(addBtn, "addBtn");
                ToastExtKt.showErrorToast(addBtn, successResponse.getMessage());
            }
            AddQualifiedExaminationListener addQualifiedExaminationListener3 = this$0.listener;
            if (addQualifiedExaminationListener3 != null) {
                addQualifiedExaminationListener3.onDismiss();
            }
            this$0.dismiss();
        }
    }

    private final void listenAddResponse2() {
        getAddQualifiedExaminationViewModel().getAddResponse2().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.profile.qualifiedexaminations.add.AddQualifiedExaminationDialog$$ExternalSyntheticLambda5
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AddQualifiedExaminationDialog.listenAddResponse2$lambda$8(AddQualifiedExaminationDialog.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenAddResponse2$lambda$8(AddQualifiedExaminationDialog this$0, Resource resource) {
        TextView addBtn;
        TextView addBtn2;
        TextView textView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i != 1) {
            if (i == 3) {
                this$0.hideProgress();
                return;
            }
            if (i != 4) {
                return;
            }
            this$0.hideProgress();
            DialogAddQualifiedExaminationBinding dialogAddQualifiedExaminationBinding = this$0.get_binding();
            if (dialogAddQualifiedExaminationBinding != null && (textView = dialogAddQualifiedExaminationBinding.completionFileName) != null) {
                String message = resource.getMessage();
                Intrinsics.checkNotNull(message);
                ToastExtKt.showErrorToast(textView, message);
            }
            this$0.dismiss();
            AddQualifiedExaminationListener addQualifiedExaminationListener = this$0.listener;
            if (addQualifiedExaminationListener != null) {
                addQualifiedExaminationListener.onDismiss();
                return;
            }
            return;
        }
        this$0.hideProgress();
        SuccessResponse successResponse = (SuccessResponse) resource.getData();
        if (successResponse != null) {
            if (successResponse.getSuccess()) {
                DialogAddQualifiedExaminationBinding dialogAddQualifiedExaminationBinding2 = this$0.get_binding();
                if (dialogAddQualifiedExaminationBinding2 != null && (addBtn2 = dialogAddQualifiedExaminationBinding2.addBtn) != null) {
                    Intrinsics.checkNotNullExpressionValue(addBtn2, "addBtn");
                    ToastExtKt.showSuccessToast(addBtn2, successResponse.getMessage());
                }
                AddQualifiedExaminationListener addQualifiedExaminationListener2 = this$0.listener;
                if (addQualifiedExaminationListener2 != null) {
                    addQualifiedExaminationListener2.onDismiss();
                }
                this$0.dismiss();
                return;
            }
            DialogAddQualifiedExaminationBinding dialogAddQualifiedExaminationBinding3 = this$0.get_binding();
            if (dialogAddQualifiedExaminationBinding3 != null && (addBtn = dialogAddQualifiedExaminationBinding3.addBtn) != null) {
                Intrinsics.checkNotNullExpressionValue(addBtn, "addBtn");
                ToastExtKt.showErrorToast(addBtn, successResponse.getMessage());
            }
            AddQualifiedExaminationListener addQualifiedExaminationListener3 = this$0.listener;
            if (addQualifiedExaminationListener3 != null) {
                addQualifiedExaminationListener3.onDismiss();
            }
            this$0.dismiss();
        }
    }

    private final void listenUpdateResponse() {
        getAddQualifiedExaminationViewModel().getUpdateResponse2().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.profile.qualifiedexaminations.add.AddQualifiedExaminationDialog$$ExternalSyntheticLambda6
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AddQualifiedExaminationDialog.listenUpdateResponse$lambda$10(AddQualifiedExaminationDialog.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenUpdateResponse$lambda$10(AddQualifiedExaminationDialog this$0, Resource resource) {
        TextView completionFileName;
        TextView completionFileName2;
        TextView textView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i != 1) {
            if (i == 3) {
                this$0.hideProgress();
                return;
            }
            if (i != 4) {
                return;
            }
            this$0.hideProgress();
            DialogAddQualifiedExaminationBinding dialogAddQualifiedExaminationBinding = this$0.get_binding();
            if (dialogAddQualifiedExaminationBinding != null && (textView = dialogAddQualifiedExaminationBinding.completionFileName) != null) {
                String message = resource.getMessage();
                Intrinsics.checkNotNull(message);
                ToastExtKt.showErrorToast(textView, message);
            }
            this$0.dismiss();
            AddQualifiedExaminationListener addQualifiedExaminationListener = this$0.listener;
            if (addQualifiedExaminationListener != null) {
                addQualifiedExaminationListener.onDismiss();
                return;
            }
            return;
        }
        this$0.hideProgress();
        SuccessResponse successResponse = (SuccessResponse) resource.getData();
        if (successResponse != null) {
            if (successResponse.getSuccess()) {
                DialogAddQualifiedExaminationBinding dialogAddQualifiedExaminationBinding2 = this$0.get_binding();
                if (dialogAddQualifiedExaminationBinding2 != null && (completionFileName2 = dialogAddQualifiedExaminationBinding2.completionFileName) != null) {
                    Intrinsics.checkNotNullExpressionValue(completionFileName2, "completionFileName");
                    ToastExtKt.showSuccessToast(completionFileName2, successResponse.getMessage());
                }
                AddQualifiedExaminationListener addQualifiedExaminationListener2 = this$0.listener;
                if (addQualifiedExaminationListener2 != null) {
                    addQualifiedExaminationListener2.onDismiss();
                }
                this$0.dismiss();
                return;
            }
            DialogAddQualifiedExaminationBinding dialogAddQualifiedExaminationBinding3 = this$0.get_binding();
            if (dialogAddQualifiedExaminationBinding3 != null && (completionFileName = dialogAddQualifiedExaminationBinding3.completionFileName) != null) {
                Intrinsics.checkNotNullExpressionValue(completionFileName, "completionFileName");
                ToastExtKt.showErrorToast(completionFileName, successResponse.getMessage());
            }
            AddQualifiedExaminationListener addQualifiedExaminationListener3 = this$0.listener;
            if (addQualifiedExaminationListener3 != null) {
                addQualifiedExaminationListener3.onDismiss();
            }
            this$0.dismiss();
        }
    }

    private final void listenProgressResponse() {
        getAddQualifiedExaminationViewModel().getProgressResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.profile.qualifiedexaminations.add.AddQualifiedExaminationDialog$$ExternalSyntheticLambda4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AddQualifiedExaminationDialog.listenProgressResponse$lambda$12(AddQualifiedExaminationDialog.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenProgressResponse$lambda$12(AddQualifiedExaminationDialog this$0, Resource resource) {
        TextView textView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i != 1) {
            if (i == 3) {
                this$0.hideProgress();
                return;
            }
            if (i != 4) {
                return;
            }
            this$0.hideProgress();
            DialogAddQualifiedExaminationBinding dialogAddQualifiedExaminationBinding = this$0.get_binding();
            if (dialogAddQualifiedExaminationBinding == null || (textView = dialogAddQualifiedExaminationBinding.completionFileName) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(textView, message);
            return;
        }
        this$0.hideProgress();
        Float f = (Float) resource.getData();
        if (f != null) {
            float floatValue = f.floatValue();
            DialogAddQualifiedExaminationBinding dialogAddQualifiedExaminationBinding2 = this$0.get_binding();
            ProgressBar progressBar = dialogAddQualifiedExaminationBinding2 != null ? dialogAddQualifiedExaminationBinding2.uploadProgressbar : null;
            if (progressBar != null) {
                progressBar.setProgress((int) floatValue);
            }
            DialogAddQualifiedExaminationBinding dialogAddQualifiedExaminationBinding3 = this$0.get_binding();
            TextView textView2 = dialogAddQualifiedExaminationBinding3 != null ? dialogAddQualifiedExaminationBinding3.progressText : null;
            if (textView2 != null) {
                textView2.setText(((int) floatValue) + " %");
            }
            if (((int) floatValue) == 100) {
                this$0.showProgress();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        String str;
        ContentResolver contentResolver;
        ContentResolver contentResolver2;
        ParcelFileDescriptor openFileDescriptor;
        File file;
        ContentResolver contentResolver3;
        String fileName;
        TextView completionFileName;
        ContentResolver contentResolver4;
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != -1 || data == null) {
            return;
        }
        try {
            Uri data2 = data.getData();
            if (data2 != null) {
                Context context = getContext();
                String type = (context == null || (contentResolver4 = context.getContentResolver()) == null) ? null : contentResolver4.getType(data2);
                if (!Intrinsics.areEqual(type, "application/pdf") && !Intrinsics.areEqual(type, "image/jpeg")) {
                    DialogAddQualifiedExaminationBinding dialogAddQualifiedExaminationBinding = get_binding();
                    if (dialogAddQualifiedExaminationBinding == null || (completionFileName = dialogAddQualifiedExaminationBinding.completionFileName) == null) {
                        return;
                    }
                    Intrinsics.checkNotNullExpressionValue(completionFileName, "completionFileName");
                    ToastExtKt.showErrorToast(completionFileName, "Please select a PDF or JPG file.");
                    return;
                }
                DialogAddQualifiedExaminationBinding dialogAddQualifiedExaminationBinding2 = get_binding();
                TextView textView = dialogAddQualifiedExaminationBinding2 != null ? dialogAddQualifiedExaminationBinding2.completionFileName : null;
                if (textView != null) {
                    Context context2 = getContext();
                    if (context2 == null || (contentResolver = context2.getContentResolver()) == null) {
                        str = null;
                    } else {
                        Intrinsics.checkNotNullExpressionValue(contentResolver, "contentResolver");
                        str = ResolvUtilKt.getFileName(contentResolver, data2);
                    }
                    textView.setText("File : " + str);
                }
                Context context3 = getContext();
                if (context3 != null && (contentResolver2 = context3.getContentResolver()) != null && (openFileDescriptor = contentResolver2.openFileDescriptor(data2, "r", null)) != null) {
                    Intrinsics.checkNotNullExpressionValue(openFileDescriptor, "context?.contentResolver…              ) ?: return");
                    Context context4 = getContext();
                    if (context4 == null || (contentResolver3 = context4.getContentResolver()) == null || (fileName = ResolvUtilKt.getFileName(contentResolver3, data2)) == null) {
                        file = null;
                    } else {
                        Context context5 = getContext();
                        file = new File(context5 != null ? context5.getCacheDir() : null, fileName);
                    }
                    ByteStreamsKt.copyTo$default(new FileInputStream(openFileDescriptor.getFileDescriptor()), new FileOutputStream(file), 0, 2, null);
                    if (file != null) {
                        this.pickFile = file;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void setCallBack(QualifiedExaminationFragment context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.listener = context;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.listener = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }
}