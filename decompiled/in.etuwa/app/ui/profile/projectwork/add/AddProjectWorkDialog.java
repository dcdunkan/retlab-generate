package in.etuwa.app.ui.profile.projectwork.add;

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
import com.google.firebase.messaging.Constants;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.profileasiet.publication.PublicationDropDownResponse;
import in.etuwa.app.databinding.DialogAddProjectWorkBinding;
import in.etuwa.app.ui.base.BaseDialog;
import in.etuwa.app.ui.examregistration.examsubjects.detaildialog.ExamSubjectDetailDialogKt;
import in.etuwa.app.ui.profile.projectwork.ProjectWorkFragment;
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
import org.bouncycastle.i18n.ErrorBundle;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.parameter.ParametersHolderKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: AddProjectWorkDialog.kt */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 ?2\u00020\u0001:\u0002>?B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001f\u001a\u00020 H\u0014J\b\u0010!\u001a\u00020 H\u0002J\b\u0010\"\u001a\u00020 H\u0002J\b\u0010#\u001a\u00020 H\u0002J\b\u0010$\u001a\u00020 H\u0002J\b\u0010%\u001a\u00020 H\u0002J\"\u0010&\u001a\u00020 2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(2\b\u0010*\u001a\u0004\u0018\u00010+H\u0017J\u0012\u0010,\u001a\u00020 2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J&\u0010/\u001a\u0004\u0018\u0001002\u0006\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u0001042\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\b\u00105\u001a\u00020 H\u0016J\b\u00106\u001a\u00020 H\u0016J\u001a\u00107\u001a\u00020 2\u0006\u00108\u001a\u0002002\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\u000e\u00109\u001a\u00020 2\u0006\u0010:\u001a\u00020;J\b\u0010<\u001a\u00020 H\u0015J\b\u0010=\u001a\u00020 H\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001a\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\n\u001a\u0004\b\u001b\u0010\u0018R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lin/etuwa/app/ui/profile/projectwork/add/AddProjectWorkDialog;", "Lin/etuwa/app/ui/base/BaseDialog;", "()V", "_binding", "Lin/etuwa/app/databinding/DialogAddProjectWorkBinding;", "addProjectWorkViewModel", "Lin/etuwa/app/ui/profile/projectwork/add/AddProjectWorkViewModel;", "getAddProjectWorkViewModel", "()Lin/etuwa/app/ui/profile/projectwork/add/AddProjectWorkViewModel;", "addProjectWorkViewModel$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lin/etuwa/app/databinding/DialogAddProjectWorkBinding;", ErrorBundle.DETAIL_ENTRY, "", "id", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/profile/projectwork/add/AddProjectWorkDialog$AddProjectListener;", "pickFile", "Ljava/io/File;", "spinnerAdapter", "Lin/etuwa/app/ui/profile/quality_publication/add/IndexSpinnerAdapter;", "getSpinnerAdapter", "()Lin/etuwa/app/ui/profile/quality_publication/add/IndexSpinnerAdapter;", "spinnerAdapter$delegate", "spinnerAdapter2", "getSpinnerAdapter2", "spinnerAdapter2$delegate", "type", "yearId", "hideProgress", "", "listenAddResponse", "listenAddResponse2", "listenProgressResponse", "listenSpinnerResponse", "listenUpdateResponse", "onActivityResult", "requestCode", "", "resultCode", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDetach", "onViewCreated", SvgConstants.Tags.VIEW, "setCallBack", "context", "Lin/etuwa/app/ui/profile/projectwork/ProjectWorkFragment;", "setUp", "showProgress", "AddProjectListener", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AddProjectWorkDialog extends BaseDialog {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private DialogAddProjectWorkBinding _binding;

    /* renamed from: addProjectWorkViewModel$delegate, reason: from kotlin metadata */
    private final Lazy addProjectWorkViewModel;
    private String details;
    private String id;
    private AddProjectListener listener;
    private File pickFile;

    /* renamed from: spinnerAdapter$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdapter;

    /* renamed from: spinnerAdapter2$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdapter2;
    private String type;
    private String yearId;

    /* compiled from: AddProjectWorkDialog.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lin/etuwa/app/ui/profile/projectwork/add/AddProjectWorkDialog$AddProjectListener;", "", "onDismiss", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface AddProjectListener {
        void onDismiss();
    }

    /* compiled from: AddProjectWorkDialog.kt */
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
    public static final AddProjectWorkDialog newInstance(String str, String str2) {
        return INSTANCE.newInstance(str, str2);
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void showProgress() {
    }

    public AddProjectWorkDialog() {
        final AddProjectWorkDialog addProjectWorkDialog = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.profile.projectwork.add.AddProjectWorkDialog$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(addProjectWorkDialog);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.addProjectWorkViewModel = FragmentViewModelLazyKt.createViewModelLazy(addProjectWorkDialog, Reflection.getOrCreateKotlinClass(AddProjectWorkViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.profile.projectwork.add.AddProjectWorkDialog$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.profile.projectwork.add.AddProjectWorkDialog$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(AddProjectWorkViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final AddProjectWorkDialog addProjectWorkDialog2 = this;
        final Function0<ParametersHolder> function02 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.profile.projectwork.add.AddProjectWorkDialog$spinnerAdapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(AddProjectWorkDialog.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        this.spinnerAdapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<IndexSpinnerAdapter>() { // from class: in.etuwa.app.ui.profile.projectwork.add.AddProjectWorkDialog$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.profile.quality_publication.add.IndexSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final IndexSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = addProjectWorkDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(IndexSpinnerAdapter.class), b2, function02);
            }
        });
        final Function0<ParametersHolder> function03 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.profile.projectwork.add.AddProjectWorkDialog$spinnerAdapter2$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(AddProjectWorkDialog.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b3 = 0 == true ? 1 : 0;
        this.spinnerAdapter2 = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<IndexSpinnerAdapter>() { // from class: in.etuwa.app.ui.profile.projectwork.add.AddProjectWorkDialog$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.profile.quality_publication.add.IndexSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final IndexSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = addProjectWorkDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(IndexSpinnerAdapter.class), b3, function03);
            }
        });
    }

    private final AddProjectWorkViewModel getAddProjectWorkViewModel() {
        return (AddProjectWorkViewModel) this.addProjectWorkViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getBinding, reason: from getter */
    public final DialogAddProjectWorkBinding get_binding() {
        return this._binding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IndexSpinnerAdapter getSpinnerAdapter() {
        return (IndexSpinnerAdapter) this.spinnerAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IndexSpinnerAdapter getSpinnerAdapter2() {
        return (IndexSpinnerAdapter) this.spinnerAdapter2.getValue();
    }

    /* compiled from: AddProjectWorkDialog.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¨\u0006\b"}, d2 = {"Lin/etuwa/app/ui/profile/projectwork/add/AddProjectWorkDialog$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/profile/projectwork/add/AddProjectWorkDialog;", "id", "", ErrorBundle.DETAIL_ENTRY, "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final AddProjectWorkDialog newInstance(String id, String details) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(details, "details");
            AddProjectWorkDialog addProjectWorkDialog = new AddProjectWorkDialog();
            Bundle bundle = new Bundle();
            bundle.putString("flag", id);
            bundle.putString(ExamSubjectDetailDialogKt.ARG_AMOUNT, details);
            addProjectWorkDialog.setArguments(bundle);
            return addProjectWorkDialog;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.id = arguments.getString("flag");
            this.details = arguments.getString(ExamSubjectDetailDialogKt.ARG_AMOUNT);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = DialogAddProjectWorkBinding.inflate(inflater, container, false);
        DialogAddProjectWorkBinding dialogAddProjectWorkBinding = get_binding();
        if (dialogAddProjectWorkBinding != null) {
            dialogAddProjectWorkBinding.setAddProjectWorkViewModel(getAddProjectWorkViewModel());
        }
        DialogAddProjectWorkBinding dialogAddProjectWorkBinding2 = get_binding();
        if (dialogAddProjectWorkBinding2 != null) {
            dialogAddProjectWorkBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        DialogAddProjectWorkBinding dialogAddProjectWorkBinding3 = get_binding();
        if (dialogAddProjectWorkBinding3 != null) {
            return dialogAddProjectWorkBinding3.getRoot();
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
        DialogAddProjectWorkBinding dialogAddProjectWorkBinding = get_binding();
        Spinner spinner = dialogAddProjectWorkBinding != null ? dialogAddProjectWorkBinding.spinnerSince : null;
        if (spinner != null) {
            spinner.setAdapter((SpinnerAdapter) getSpinnerAdapter());
        }
        DialogAddProjectWorkBinding dialogAddProjectWorkBinding2 = get_binding();
        Spinner spinner2 = dialogAddProjectWorkBinding2 != null ? dialogAddProjectWorkBinding2.spinnerType : null;
        if (spinner2 != null) {
            spinner2.setAdapter((SpinnerAdapter) getSpinnerAdapter2());
        }
        listenSpinnerResponse();
        listenProgressResponse();
        listenUpdateResponse();
        listenAddResponse();
        listenAddResponse2();
        getAddProjectWorkViewModel().getDropDownData();
        if (!Intrinsics.areEqual(this.id, "")) {
            DialogAddProjectWorkBinding dialogAddProjectWorkBinding3 = get_binding();
            TextView textView4 = dialogAddProjectWorkBinding3 != null ? dialogAddProjectWorkBinding3.addBtn : null;
            if (textView4 != null) {
                textView4.setVisibility(8);
            }
            DialogAddProjectWorkBinding dialogAddProjectWorkBinding4 = get_binding();
            TextView textView5 = dialogAddProjectWorkBinding4 != null ? dialogAddProjectWorkBinding4.updateBtn : null;
            if (textView5 != null) {
                textView5.setVisibility(0);
            }
        } else {
            DialogAddProjectWorkBinding dialogAddProjectWorkBinding5 = get_binding();
            TextView textView6 = dialogAddProjectWorkBinding5 != null ? dialogAddProjectWorkBinding5.addBtn : null;
            if (textView6 != null) {
                textView6.setVisibility(0);
            }
            DialogAddProjectWorkBinding dialogAddProjectWorkBinding6 = get_binding();
            TextView textView7 = dialogAddProjectWorkBinding6 != null ? dialogAddProjectWorkBinding6.updateBtn : null;
            if (textView7 != null) {
                textView7.setVisibility(8);
            }
        }
        DialogAddProjectWorkBinding dialogAddProjectWorkBinding7 = get_binding();
        if (dialogAddProjectWorkBinding7 != null && (textInputEditText = dialogAddProjectWorkBinding7.etDetails) != null) {
            textInputEditText.setText(this.details);
        }
        DialogAddProjectWorkBinding dialogAddProjectWorkBinding8 = get_binding();
        Spinner spinner3 = dialogAddProjectWorkBinding8 != null ? dialogAddProjectWorkBinding8.spinnerSince : null;
        if (spinner3 != null) {
            spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.profile.projectwork.add.AddProjectWorkDialog$setUp$1
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    IndexSpinnerAdapter spinnerAdapter;
                    AddProjectWorkDialog addProjectWorkDialog = AddProjectWorkDialog.this;
                    spinnerAdapter = addProjectWorkDialog.getSpinnerAdapter();
                    addProjectWorkDialog.yearId = String.valueOf(spinnerAdapter.getSemester(position).getId());
                }
            });
        }
        DialogAddProjectWorkBinding dialogAddProjectWorkBinding9 = get_binding();
        Spinner spinner4 = dialogAddProjectWorkBinding9 != null ? dialogAddProjectWorkBinding9.spinnerType : null;
        if (spinner4 != null) {
            spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.profile.projectwork.add.AddProjectWorkDialog$setUp$2
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    IndexSpinnerAdapter spinnerAdapter2;
                    AddProjectWorkDialog addProjectWorkDialog = AddProjectWorkDialog.this;
                    spinnerAdapter2 = addProjectWorkDialog.getSpinnerAdapter2();
                    addProjectWorkDialog.type = String.valueOf(spinnerAdapter2.getSemester(position).getId());
                }
            });
        }
        DialogAddProjectWorkBinding dialogAddProjectWorkBinding10 = get_binding();
        if (dialogAddProjectWorkBinding10 != null && (textView3 = dialogAddProjectWorkBinding10.completionSelect) != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.profile.projectwork.add.AddProjectWorkDialog$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AddProjectWorkDialog.setUp$lambda$2(AddProjectWorkDialog.this, view);
                }
            });
        }
        DialogAddProjectWorkBinding dialogAddProjectWorkBinding11 = get_binding();
        if (dialogAddProjectWorkBinding11 != null && (textView2 = dialogAddProjectWorkBinding11.addBtn) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.profile.projectwork.add.AddProjectWorkDialog$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AddProjectWorkDialog.setUp$lambda$3(AddProjectWorkDialog.this, view);
                }
            });
        }
        DialogAddProjectWorkBinding dialogAddProjectWorkBinding12 = get_binding();
        if (dialogAddProjectWorkBinding12 == null || (textView = dialogAddProjectWorkBinding12.updateBtn) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.profile.projectwork.add.AddProjectWorkDialog$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AddProjectWorkDialog.setUp$lambda$4(AddProjectWorkDialog.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$2(AddProjectWorkDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", false);
        intent.setType("*/*");
        this$0.startActivityForResult(Intent.createChooser(intent, "Select a file"), 111);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$3(AddProjectWorkDialog this$0, View view) {
        TextView textView;
        TextInputEditText textInputEditText;
        TextView textView2;
        TextInputEditText textInputEditText2;
        TextView textView3;
        TextInputEditText textInputEditText3;
        TextView textView4;
        TextInputEditText textInputEditText4;
        TextView textView5;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            DialogAddProjectWorkBinding dialogAddProjectWorkBinding = this$0.get_binding();
            if (String.valueOf((dialogAddProjectWorkBinding == null || (textView5 = dialogAddProjectWorkBinding.completionFileName) == null) ? null : textView5.getText()).length() > 0) {
                File file = this$0.pickFile;
                if (file == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pickFile");
                    file = null;
                }
                if (file.length() / 1024 <= 100) {
                    this$0.setCancelable(false);
                    DialogAddProjectWorkBinding dialogAddProjectWorkBinding2 = this$0.get_binding();
                    if (Intrinsics.areEqual(String.valueOf((dialogAddProjectWorkBinding2 == null || (textInputEditText4 = dialogAddProjectWorkBinding2.etDetails) == null) ? null : textInputEditText4.getText()), "")) {
                        DialogAddProjectWorkBinding dialogAddProjectWorkBinding3 = this$0.get_binding();
                        if (dialogAddProjectWorkBinding3 == null || (textView4 = dialogAddProjectWorkBinding3.completionSelect) == null) {
                            return;
                        }
                        ToastExtKt.showInfoToast(textView4, "Details Cannot be empty");
                        return;
                    }
                    AddProjectWorkViewModel addProjectWorkViewModel = this$0.getAddProjectWorkViewModel();
                    String str = this$0.type;
                    Intrinsics.checkNotNull(str);
                    String str2 = this$0.yearId;
                    Intrinsics.checkNotNull(str2);
                    DialogAddProjectWorkBinding dialogAddProjectWorkBinding4 = this$0.get_binding();
                    String valueOf = String.valueOf((dialogAddProjectWorkBinding4 == null || (textInputEditText3 = dialogAddProjectWorkBinding4.etDetails) == null) ? null : textInputEditText3.getText());
                    File file2 = this$0.pickFile;
                    if (file2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("pickFile");
                        file2 = null;
                    }
                    addProjectWorkViewModel.addProjectWorkData(str, str2, valueOf, file2);
                    DialogAddProjectWorkBinding dialogAddProjectWorkBinding5 = this$0.get_binding();
                    LinearLayout linearLayout = dialogAddProjectWorkBinding5 != null ? dialogAddProjectWorkBinding5.completionCard : null;
                    if (linearLayout != null) {
                        linearLayout.setVisibility(8);
                    }
                    DialogAddProjectWorkBinding dialogAddProjectWorkBinding6 = this$0.get_binding();
                    CardView cardView = dialogAddProjectWorkBinding6 != null ? dialogAddProjectWorkBinding6.progressView : null;
                    if (cardView == null) {
                        return;
                    }
                    cardView.setVisibility(0);
                    return;
                }
                DialogAddProjectWorkBinding dialogAddProjectWorkBinding7 = this$0.get_binding();
                if (dialogAddProjectWorkBinding7 == null || (textView3 = dialogAddProjectWorkBinding7.completionSelect) == null) {
                    return;
                }
                ToastExtKt.showInfoToast(textView3, "File Size Limit Is 100KB");
                return;
            }
            DialogAddProjectWorkBinding dialogAddProjectWorkBinding8 = this$0.get_binding();
            if (Intrinsics.areEqual(String.valueOf((dialogAddProjectWorkBinding8 == null || (textInputEditText2 = dialogAddProjectWorkBinding8.etDetails) == null) ? null : textInputEditText2.getText()), "")) {
                DialogAddProjectWorkBinding dialogAddProjectWorkBinding9 = this$0.get_binding();
                if (dialogAddProjectWorkBinding9 == null || (textView2 = dialogAddProjectWorkBinding9.completionSelect) == null) {
                    return;
                }
                ToastExtKt.showInfoToast(textView2, "Details Cannot be empty");
                return;
            }
            AddProjectWorkViewModel addProjectWorkViewModel2 = this$0.getAddProjectWorkViewModel();
            String str3 = this$0.type;
            Intrinsics.checkNotNull(str3);
            String str4 = this$0.yearId;
            Intrinsics.checkNotNull(str4);
            DialogAddProjectWorkBinding dialogAddProjectWorkBinding10 = this$0.get_binding();
            addProjectWorkViewModel2.addProjectWorkData(str3, str4, String.valueOf((dialogAddProjectWorkBinding10 == null || (textInputEditText = dialogAddProjectWorkBinding10.etDetails) == null) ? null : textInputEditText.getText()));
            DialogAddProjectWorkBinding dialogAddProjectWorkBinding11 = this$0.get_binding();
            LinearLayout linearLayout2 = dialogAddProjectWorkBinding11 != null ? dialogAddProjectWorkBinding11.completionCard : null;
            if (linearLayout2 == null) {
                return;
            }
            linearLayout2.setVisibility(8);
        } catch (Exception unused) {
            DialogAddProjectWorkBinding dialogAddProjectWorkBinding12 = this$0.get_binding();
            if (dialogAddProjectWorkBinding12 == null || (textView = dialogAddProjectWorkBinding12.addBtn) == null) {
                return;
            }
            ToastExtKt.showErrorToast(textView, "Something went wrong.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$4(AddProjectWorkDialog this$0, View view) {
        TextInputEditText textInputEditText;
        TextView textView;
        TextInputEditText textInputEditText2;
        TextView textView2;
        File file;
        TextInputEditText textInputEditText3;
        TextView textView3;
        TextInputEditText textInputEditText4;
        TextView textView4;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            DialogAddProjectWorkBinding dialogAddProjectWorkBinding = this$0.get_binding();
            Editable editable = null;
            editable = null;
            if (String.valueOf((dialogAddProjectWorkBinding == null || (textView4 = dialogAddProjectWorkBinding.completionFileName) == null) ? null : textView4.getText()).length() > 0) {
                File file2 = this$0.pickFile;
                if (file2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pickFile");
                    file2 = null;
                }
                if (file2.length() / 1024 <= 100) {
                    this$0.setCancelable(false);
                    DialogAddProjectWorkBinding dialogAddProjectWorkBinding2 = this$0.get_binding();
                    if (Intrinsics.areEqual(String.valueOf((dialogAddProjectWorkBinding2 == null || (textInputEditText4 = dialogAddProjectWorkBinding2.etDetails) == null) ? null : textInputEditText4.getText()), "")) {
                        DialogAddProjectWorkBinding dialogAddProjectWorkBinding3 = this$0.get_binding();
                        if (dialogAddProjectWorkBinding3 == null || (textView3 = dialogAddProjectWorkBinding3.completionSelect) == null) {
                            return;
                        }
                        ToastExtKt.showInfoToast(textView3, "Details Cannot be empty");
                        return;
                    }
                    AddProjectWorkViewModel addProjectWorkViewModel = this$0.getAddProjectWorkViewModel();
                    String str = this$0.id;
                    Intrinsics.checkNotNull(str);
                    String str2 = this$0.type;
                    Intrinsics.checkNotNull(str2);
                    String str3 = this$0.yearId;
                    Intrinsics.checkNotNull(str3);
                    DialogAddProjectWorkBinding dialogAddProjectWorkBinding4 = this$0.get_binding();
                    String valueOf = String.valueOf((dialogAddProjectWorkBinding4 == null || (textInputEditText3 = dialogAddProjectWorkBinding4.etDetails) == null) ? null : textInputEditText3.getText());
                    File file3 = this$0.pickFile;
                    if (file3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("pickFile");
                        file = null;
                    } else {
                        file = file3;
                    }
                    addProjectWorkViewModel.updateProjectWorkData(str, str2, str3, valueOf, file);
                    DialogAddProjectWorkBinding dialogAddProjectWorkBinding5 = this$0.get_binding();
                    LinearLayout linearLayout = dialogAddProjectWorkBinding5 != null ? dialogAddProjectWorkBinding5.completionCard : null;
                    if (linearLayout != null) {
                        linearLayout.setVisibility(8);
                    }
                    DialogAddProjectWorkBinding dialogAddProjectWorkBinding6 = this$0.get_binding();
                    CardView cardView = dialogAddProjectWorkBinding6 != null ? dialogAddProjectWorkBinding6.progressView : null;
                    if (cardView == null) {
                        return;
                    }
                    cardView.setVisibility(0);
                    return;
                }
                DialogAddProjectWorkBinding dialogAddProjectWorkBinding7 = this$0.get_binding();
                if (dialogAddProjectWorkBinding7 == null || (textView2 = dialogAddProjectWorkBinding7.completionSelect) == null) {
                    return;
                }
                ToastExtKt.showInfoToast(textView2, "File Size Limit Is 100KB");
                return;
            }
            DialogAddProjectWorkBinding dialogAddProjectWorkBinding8 = this$0.get_binding();
            if (Intrinsics.areEqual(String.valueOf((dialogAddProjectWorkBinding8 == null || (textInputEditText2 = dialogAddProjectWorkBinding8.etDetails) == null) ? null : textInputEditText2.getText()), "")) {
                DialogAddProjectWorkBinding dialogAddProjectWorkBinding9 = this$0.get_binding();
                if (dialogAddProjectWorkBinding9 == null || (textView = dialogAddProjectWorkBinding9.completionSelect) == null) {
                    return;
                }
                ToastExtKt.showInfoToast(textView, "Details Cannot be empty");
                return;
            }
            AddProjectWorkViewModel addProjectWorkViewModel2 = this$0.getAddProjectWorkViewModel();
            String str4 = this$0.id;
            Intrinsics.checkNotNull(str4);
            String str5 = this$0.type;
            Intrinsics.checkNotNull(str5);
            String str6 = this$0.yearId;
            Intrinsics.checkNotNull(str6);
            DialogAddProjectWorkBinding dialogAddProjectWorkBinding10 = this$0.get_binding();
            if (dialogAddProjectWorkBinding10 != null && (textInputEditText = dialogAddProjectWorkBinding10.etDetails) != null) {
                editable = textInputEditText.getText();
            }
            addProjectWorkViewModel2.updateProjectWorkData(str4, str5, str6, String.valueOf(editable));
        } catch (Exception unused) {
        }
    }

    private final void listenSpinnerResponse() {
        getAddProjectWorkViewModel().getResponse().observe(getViewLifecycleOwner(), new AddProjectWorkDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends PublicationDropDownResponse>, Unit>() { // from class: in.etuwa.app.ui.profile.projectwork.add.AddProjectWorkDialog$listenSpinnerResponse$1

            /* compiled from: AddProjectWorkDialog.kt */
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
                IndexSpinnerAdapter spinnerAdapter2;
                DialogAddProjectWorkBinding dialogAddProjectWorkBinding;
                Spinner spinner;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i == 1) {
                    AddProjectWorkDialog.this.hideProgress();
                    PublicationDropDownResponse data = resource.getData();
                    if (data != null) {
                        AddProjectWorkDialog addProjectWorkDialog = AddProjectWorkDialog.this;
                        try {
                            spinnerAdapter = addProjectWorkDialog.getSpinnerAdapter();
                            spinnerAdapter.addItems(data.getYears());
                            spinnerAdapter2 = addProjectWorkDialog.getSpinnerAdapter2();
                            spinnerAdapter2.addItems(data.getProject());
                            return;
                        } catch (NullPointerException unused) {
                            return;
                        }
                    }
                    return;
                }
                if (i == 2) {
                    AddProjectWorkDialog.this.showProgress();
                    return;
                }
                if (i == 3) {
                    AddProjectWorkDialog.this.hideProgress();
                    return;
                }
                if (i != 4) {
                    return;
                }
                AddProjectWorkDialog.this.hideProgress();
                dialogAddProjectWorkBinding = AddProjectWorkDialog.this.get_binding();
                if (dialogAddProjectWorkBinding == null || (spinner = dialogAddProjectWorkBinding.spinnerType) == null) {
                    return;
                }
                String message = resource.getMessage();
                Intrinsics.checkNotNull(message);
                ToastExtKt.showErrorToast(spinner, message);
            }
        }));
    }

    private final void listenAddResponse() {
        getAddProjectWorkViewModel().getAddResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.profile.projectwork.add.AddProjectWorkDialog$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AddProjectWorkDialog.listenAddResponse$lambda$6(AddProjectWorkDialog.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenAddResponse$lambda$6(AddProjectWorkDialog this$0, Resource resource) {
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
            DialogAddProjectWorkBinding dialogAddProjectWorkBinding = this$0.get_binding();
            if (dialogAddProjectWorkBinding != null && (textView = dialogAddProjectWorkBinding.completionFileName) != null) {
                String message = resource.getMessage();
                Intrinsics.checkNotNull(message);
                ToastExtKt.showErrorToast(textView, message);
            }
            this$0.dismiss();
            AddProjectListener addProjectListener = this$0.listener;
            if (addProjectListener != null) {
                addProjectListener.onDismiss();
                return;
            }
            return;
        }
        this$0.hideProgress();
        SuccessResponse successResponse = (SuccessResponse) resource.getData();
        if (successResponse != null) {
            if (successResponse.getSuccess()) {
                DialogAddProjectWorkBinding dialogAddProjectWorkBinding2 = this$0.get_binding();
                if (dialogAddProjectWorkBinding2 != null && (addBtn2 = dialogAddProjectWorkBinding2.addBtn) != null) {
                    Intrinsics.checkNotNullExpressionValue(addBtn2, "addBtn");
                    ToastExtKt.showSuccessToast(addBtn2, successResponse.getMessage());
                }
                AddProjectListener addProjectListener2 = this$0.listener;
                if (addProjectListener2 != null) {
                    addProjectListener2.onDismiss();
                }
                this$0.dismiss();
                return;
            }
            DialogAddProjectWorkBinding dialogAddProjectWorkBinding3 = this$0.get_binding();
            if (dialogAddProjectWorkBinding3 != null && (addBtn = dialogAddProjectWorkBinding3.addBtn) != null) {
                Intrinsics.checkNotNullExpressionValue(addBtn, "addBtn");
                ToastExtKt.showErrorToast(addBtn, successResponse.getMessage());
            }
            AddProjectListener addProjectListener3 = this$0.listener;
            if (addProjectListener3 != null) {
                addProjectListener3.onDismiss();
            }
            this$0.dismiss();
        }
    }

    private final void listenAddResponse2() {
        getAddProjectWorkViewModel().getAddResponse2().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.profile.projectwork.add.AddProjectWorkDialog$$ExternalSyntheticLambda4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AddProjectWorkDialog.listenAddResponse2$lambda$8(AddProjectWorkDialog.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenAddResponse2$lambda$8(AddProjectWorkDialog this$0, Resource resource) {
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
            DialogAddProjectWorkBinding dialogAddProjectWorkBinding = this$0.get_binding();
            if (dialogAddProjectWorkBinding != null && (textView = dialogAddProjectWorkBinding.completionFileName) != null) {
                String message = resource.getMessage();
                Intrinsics.checkNotNull(message);
                ToastExtKt.showErrorToast(textView, message);
            }
            this$0.dismiss();
            AddProjectListener addProjectListener = this$0.listener;
            if (addProjectListener != null) {
                addProjectListener.onDismiss();
                return;
            }
            return;
        }
        this$0.hideProgress();
        SuccessResponse successResponse = (SuccessResponse) resource.getData();
        if (successResponse != null) {
            if (successResponse.getSuccess()) {
                DialogAddProjectWorkBinding dialogAddProjectWorkBinding2 = this$0.get_binding();
                if (dialogAddProjectWorkBinding2 != null && (addBtn2 = dialogAddProjectWorkBinding2.addBtn) != null) {
                    Intrinsics.checkNotNullExpressionValue(addBtn2, "addBtn");
                    ToastExtKt.showSuccessToast(addBtn2, successResponse.getMessage());
                }
                AddProjectListener addProjectListener2 = this$0.listener;
                if (addProjectListener2 != null) {
                    addProjectListener2.onDismiss();
                }
                this$0.dismiss();
                return;
            }
            DialogAddProjectWorkBinding dialogAddProjectWorkBinding3 = this$0.get_binding();
            if (dialogAddProjectWorkBinding3 != null && (addBtn = dialogAddProjectWorkBinding3.addBtn) != null) {
                Intrinsics.checkNotNullExpressionValue(addBtn, "addBtn");
                ToastExtKt.showErrorToast(addBtn, successResponse.getMessage());
            }
            AddProjectListener addProjectListener3 = this$0.listener;
            if (addProjectListener3 != null) {
                addProjectListener3.onDismiss();
            }
            this$0.dismiss();
        }
    }

    private final void listenUpdateResponse() {
        getAddProjectWorkViewModel().getUpdateResponse2().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.profile.projectwork.add.AddProjectWorkDialog$$ExternalSyntheticLambda6
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AddProjectWorkDialog.listenUpdateResponse$lambda$10(AddProjectWorkDialog.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenUpdateResponse$lambda$10(AddProjectWorkDialog this$0, Resource resource) {
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
            DialogAddProjectWorkBinding dialogAddProjectWorkBinding = this$0.get_binding();
            if (dialogAddProjectWorkBinding != null && (textView = dialogAddProjectWorkBinding.completionFileName) != null) {
                String message = resource.getMessage();
                Intrinsics.checkNotNull(message);
                ToastExtKt.showErrorToast(textView, message);
            }
            this$0.dismiss();
            AddProjectListener addProjectListener = this$0.listener;
            if (addProjectListener != null) {
                addProjectListener.onDismiss();
                return;
            }
            return;
        }
        this$0.hideProgress();
        SuccessResponse successResponse = (SuccessResponse) resource.getData();
        if (successResponse != null) {
            if (successResponse.getSuccess()) {
                DialogAddProjectWorkBinding dialogAddProjectWorkBinding2 = this$0.get_binding();
                if (dialogAddProjectWorkBinding2 != null && (completionFileName2 = dialogAddProjectWorkBinding2.completionFileName) != null) {
                    Intrinsics.checkNotNullExpressionValue(completionFileName2, "completionFileName");
                    ToastExtKt.showSuccessToast(completionFileName2, successResponse.getMessage());
                }
                AddProjectListener addProjectListener2 = this$0.listener;
                if (addProjectListener2 != null) {
                    addProjectListener2.onDismiss();
                }
                this$0.dismiss();
                return;
            }
            DialogAddProjectWorkBinding dialogAddProjectWorkBinding3 = this$0.get_binding();
            if (dialogAddProjectWorkBinding3 != null && (completionFileName = dialogAddProjectWorkBinding3.completionFileName) != null) {
                Intrinsics.checkNotNullExpressionValue(completionFileName, "completionFileName");
                ToastExtKt.showErrorToast(completionFileName, successResponse.getMessage());
            }
            AddProjectListener addProjectListener3 = this$0.listener;
            if (addProjectListener3 != null) {
                addProjectListener3.onDismiss();
            }
            this$0.dismiss();
        }
    }

    private final void listenProgressResponse() {
        getAddProjectWorkViewModel().getProgressResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.profile.projectwork.add.AddProjectWorkDialog$$ExternalSyntheticLambda5
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AddProjectWorkDialog.listenProgressResponse$lambda$12(AddProjectWorkDialog.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenProgressResponse$lambda$12(AddProjectWorkDialog this$0, Resource resource) {
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
            DialogAddProjectWorkBinding dialogAddProjectWorkBinding = this$0.get_binding();
            if (dialogAddProjectWorkBinding == null || (textView = dialogAddProjectWorkBinding.completionFileName) == null) {
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
            DialogAddProjectWorkBinding dialogAddProjectWorkBinding2 = this$0.get_binding();
            ProgressBar progressBar = dialogAddProjectWorkBinding2 != null ? dialogAddProjectWorkBinding2.uploadProgressbar : null;
            if (progressBar != null) {
                progressBar.setProgress((int) floatValue);
            }
            DialogAddProjectWorkBinding dialogAddProjectWorkBinding3 = this$0.get_binding();
            TextView textView2 = dialogAddProjectWorkBinding3 != null ? dialogAddProjectWorkBinding3.progressText : null;
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
                    DialogAddProjectWorkBinding dialogAddProjectWorkBinding = get_binding();
                    if (dialogAddProjectWorkBinding == null || (completionFileName = dialogAddProjectWorkBinding.completionFileName) == null) {
                        return;
                    }
                    Intrinsics.checkNotNullExpressionValue(completionFileName, "completionFileName");
                    ToastExtKt.showErrorToast(completionFileName, "Please select a PDF or JPG file.");
                    return;
                }
                DialogAddProjectWorkBinding dialogAddProjectWorkBinding2 = get_binding();
                TextView textView = dialogAddProjectWorkBinding2 != null ? dialogAddProjectWorkBinding2.completionFileName : null;
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

    public final void setCallBack(ProjectWorkFragment context) {
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