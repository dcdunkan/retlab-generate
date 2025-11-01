package in.etuwa.app.ui.profile.scholarships.add;

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
import in.etuwa.app.databinding.DialogAddScholarshipBinding;
import in.etuwa.app.ui.base.BaseDialog;
import in.etuwa.app.ui.examregistration.examsubjects.detaildialog.ExamSubjectDetailDialogKt;
import in.etuwa.app.ui.profile.quality_publication.add.IndexSpinnerAdapter;
import in.etuwa.app.ui.profile.scholarships.ScholarshipFragment;
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

/* compiled from: AddScholarshipDialog.kt */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 ?2\u00020\u0001:\u0002>?B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001f\u001a\u00020 H\u0014J\b\u0010!\u001a\u00020 H\u0002J\b\u0010\"\u001a\u00020 H\u0002J\b\u0010#\u001a\u00020 H\u0002J\b\u0010$\u001a\u00020 H\u0002J\b\u0010%\u001a\u00020 H\u0002J\"\u0010&\u001a\u00020 2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(2\b\u0010*\u001a\u0004\u0018\u00010+H\u0017J\u0012\u0010,\u001a\u00020 2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J&\u0010/\u001a\u0004\u0018\u0001002\u0006\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u0001042\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\b\u00105\u001a\u00020 H\u0016J\b\u00106\u001a\u00020 H\u0016J\u001a\u00107\u001a\u00020 2\u0006\u00108\u001a\u0002002\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\u000e\u00109\u001a\u00020 2\u0006\u0010:\u001a\u00020;J\b\u0010<\u001a\u00020 H\u0015J\b\u0010=\u001a\u00020 H\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001a\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\n\u001a\u0004\b\u001b\u0010\u0018R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lin/etuwa/app/ui/profile/scholarships/add/AddScholarshipDialog;", "Lin/etuwa/app/ui/base/BaseDialog;", "()V", "_binding", "Lin/etuwa/app/databinding/DialogAddScholarshipBinding;", "addScholarshipViewModel", "Lin/etuwa/app/ui/profile/scholarships/add/AddScholarshipViewModel;", "getAddScholarshipViewModel", "()Lin/etuwa/app/ui/profile/scholarships/add/AddScholarshipViewModel;", "addScholarshipViewModel$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lin/etuwa/app/databinding/DialogAddScholarshipBinding;", ErrorBundle.DETAIL_ENTRY, "", "id", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/profile/scholarships/add/AddScholarshipDialog$AddScholarshipListener;", "pickFile", "Ljava/io/File;", "spinnerAdapter", "Lin/etuwa/app/ui/profile/quality_publication/add/IndexSpinnerAdapter;", "getSpinnerAdapter", "()Lin/etuwa/app/ui/profile/quality_publication/add/IndexSpinnerAdapter;", "spinnerAdapter$delegate", "spinnerAdapter2", "getSpinnerAdapter2", "spinnerAdapter2$delegate", "type", "yearId", "hideProgress", "", "listenAddResponse", "listenAddResponse2", "listenProgressResponse", "listenSpinnerResponse", "listenUpdateResponse", "onActivityResult", "requestCode", "", "resultCode", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDetach", "onViewCreated", SvgConstants.Tags.VIEW, "setCallBack", "context", "Lin/etuwa/app/ui/profile/scholarships/ScholarshipFragment;", "setUp", "showProgress", "AddScholarshipListener", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AddScholarshipDialog extends BaseDialog {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private DialogAddScholarshipBinding _binding;

    /* renamed from: addScholarshipViewModel$delegate, reason: from kotlin metadata */
    private final Lazy addScholarshipViewModel;
    private String details;
    private String id;
    private AddScholarshipListener listener;
    private File pickFile;

    /* renamed from: spinnerAdapter$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdapter;

    /* renamed from: spinnerAdapter2$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdapter2;
    private String type;
    private String yearId;

    /* compiled from: AddScholarshipDialog.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lin/etuwa/app/ui/profile/scholarships/add/AddScholarshipDialog$AddScholarshipListener;", "", "onDismiss", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface AddScholarshipListener {
        void onDismiss();
    }

    /* compiled from: AddScholarshipDialog.kt */
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
    public static final AddScholarshipDialog newInstance(String str, String str2) {
        return INSTANCE.newInstance(str, str2);
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void showProgress() {
    }

    public AddScholarshipDialog() {
        final AddScholarshipDialog addScholarshipDialog = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.profile.scholarships.add.AddScholarshipDialog$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(addScholarshipDialog);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.addScholarshipViewModel = FragmentViewModelLazyKt.createViewModelLazy(addScholarshipDialog, Reflection.getOrCreateKotlinClass(AddScholarshipViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.profile.scholarships.add.AddScholarshipDialog$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.profile.scholarships.add.AddScholarshipDialog$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(AddScholarshipViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final AddScholarshipDialog addScholarshipDialog2 = this;
        final Function0<ParametersHolder> function02 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.profile.scholarships.add.AddScholarshipDialog$spinnerAdapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(AddScholarshipDialog.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        this.spinnerAdapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<IndexSpinnerAdapter>() { // from class: in.etuwa.app.ui.profile.scholarships.add.AddScholarshipDialog$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.profile.quality_publication.add.IndexSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final IndexSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = addScholarshipDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(IndexSpinnerAdapter.class), b2, function02);
            }
        });
        final Function0<ParametersHolder> function03 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.profile.scholarships.add.AddScholarshipDialog$spinnerAdapter2$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(AddScholarshipDialog.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b3 = 0 == true ? 1 : 0;
        this.spinnerAdapter2 = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<IndexSpinnerAdapter>() { // from class: in.etuwa.app.ui.profile.scholarships.add.AddScholarshipDialog$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.profile.quality_publication.add.IndexSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final IndexSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = addScholarshipDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(IndexSpinnerAdapter.class), b3, function03);
            }
        });
    }

    private final AddScholarshipViewModel getAddScholarshipViewModel() {
        return (AddScholarshipViewModel) this.addScholarshipViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getBinding, reason: from getter */
    public final DialogAddScholarshipBinding get_binding() {
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

    /* compiled from: AddScholarshipDialog.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¨\u0006\b"}, d2 = {"Lin/etuwa/app/ui/profile/scholarships/add/AddScholarshipDialog$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/profile/scholarships/add/AddScholarshipDialog;", "id", "", ErrorBundle.DETAIL_ENTRY, "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final AddScholarshipDialog newInstance(String id, String details) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(details, "details");
            AddScholarshipDialog addScholarshipDialog = new AddScholarshipDialog();
            Bundle bundle = new Bundle();
            bundle.putString("flag", id);
            bundle.putString(ExamSubjectDetailDialogKt.ARG_AMOUNT, details);
            addScholarshipDialog.setArguments(bundle);
            return addScholarshipDialog;
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
        this._binding = DialogAddScholarshipBinding.inflate(inflater, container, false);
        DialogAddScholarshipBinding dialogAddScholarshipBinding = get_binding();
        if (dialogAddScholarshipBinding != null) {
            dialogAddScholarshipBinding.setAddScholarshipViewModel(getAddScholarshipViewModel());
        }
        DialogAddScholarshipBinding dialogAddScholarshipBinding2 = get_binding();
        if (dialogAddScholarshipBinding2 != null) {
            dialogAddScholarshipBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        DialogAddScholarshipBinding dialogAddScholarshipBinding3 = get_binding();
        if (dialogAddScholarshipBinding3 != null) {
            return dialogAddScholarshipBinding3.getRoot();
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
        DialogAddScholarshipBinding dialogAddScholarshipBinding = get_binding();
        Spinner spinner = dialogAddScholarshipBinding != null ? dialogAddScholarshipBinding.spinnerSince : null;
        if (spinner != null) {
            spinner.setAdapter((SpinnerAdapter) getSpinnerAdapter());
        }
        DialogAddScholarshipBinding dialogAddScholarshipBinding2 = get_binding();
        Spinner spinner2 = dialogAddScholarshipBinding2 != null ? dialogAddScholarshipBinding2.spinnerType : null;
        if (spinner2 != null) {
            spinner2.setAdapter((SpinnerAdapter) getSpinnerAdapter2());
        }
        listenSpinnerResponse();
        listenProgressResponse();
        listenUpdateResponse();
        listenAddResponse();
        listenAddResponse2();
        getAddScholarshipViewModel().getDropDownData();
        if (!Intrinsics.areEqual(this.id, "")) {
            DialogAddScholarshipBinding dialogAddScholarshipBinding3 = get_binding();
            TextView textView4 = dialogAddScholarshipBinding3 != null ? dialogAddScholarshipBinding3.addBtn : null;
            if (textView4 != null) {
                textView4.setVisibility(8);
            }
            DialogAddScholarshipBinding dialogAddScholarshipBinding4 = get_binding();
            TextView textView5 = dialogAddScholarshipBinding4 != null ? dialogAddScholarshipBinding4.updateBtn : null;
            if (textView5 != null) {
                textView5.setVisibility(0);
            }
        } else {
            DialogAddScholarshipBinding dialogAddScholarshipBinding5 = get_binding();
            TextView textView6 = dialogAddScholarshipBinding5 != null ? dialogAddScholarshipBinding5.addBtn : null;
            if (textView6 != null) {
                textView6.setVisibility(0);
            }
            DialogAddScholarshipBinding dialogAddScholarshipBinding6 = get_binding();
            TextView textView7 = dialogAddScholarshipBinding6 != null ? dialogAddScholarshipBinding6.updateBtn : null;
            if (textView7 != null) {
                textView7.setVisibility(8);
            }
        }
        DialogAddScholarshipBinding dialogAddScholarshipBinding7 = get_binding();
        if (dialogAddScholarshipBinding7 != null && (textInputEditText = dialogAddScholarshipBinding7.etName) != null) {
            textInputEditText.setText(this.details);
        }
        DialogAddScholarshipBinding dialogAddScholarshipBinding8 = get_binding();
        Spinner spinner3 = dialogAddScholarshipBinding8 != null ? dialogAddScholarshipBinding8.spinnerSince : null;
        if (spinner3 != null) {
            spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.profile.scholarships.add.AddScholarshipDialog$setUp$1
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    IndexSpinnerAdapter spinnerAdapter;
                    AddScholarshipDialog addScholarshipDialog = AddScholarshipDialog.this;
                    spinnerAdapter = addScholarshipDialog.getSpinnerAdapter();
                    addScholarshipDialog.yearId = String.valueOf(spinnerAdapter.getSemester(position).getId());
                }
            });
        }
        DialogAddScholarshipBinding dialogAddScholarshipBinding9 = get_binding();
        Spinner spinner4 = dialogAddScholarshipBinding9 != null ? dialogAddScholarshipBinding9.spinnerType : null;
        if (spinner4 != null) {
            spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.profile.scholarships.add.AddScholarshipDialog$setUp$2
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    IndexSpinnerAdapter spinnerAdapter2;
                    AddScholarshipDialog addScholarshipDialog = AddScholarshipDialog.this;
                    spinnerAdapter2 = addScholarshipDialog.getSpinnerAdapter2();
                    addScholarshipDialog.type = String.valueOf(spinnerAdapter2.getSemester(position).getId());
                }
            });
        }
        DialogAddScholarshipBinding dialogAddScholarshipBinding10 = get_binding();
        if (dialogAddScholarshipBinding10 != null && (textView3 = dialogAddScholarshipBinding10.completionSelect) != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.profile.scholarships.add.AddScholarshipDialog$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AddScholarshipDialog.setUp$lambda$2(AddScholarshipDialog.this, view);
                }
            });
        }
        DialogAddScholarshipBinding dialogAddScholarshipBinding11 = get_binding();
        if (dialogAddScholarshipBinding11 != null && (textView2 = dialogAddScholarshipBinding11.addBtn) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.profile.scholarships.add.AddScholarshipDialog$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AddScholarshipDialog.setUp$lambda$3(AddScholarshipDialog.this, view);
                }
            });
        }
        DialogAddScholarshipBinding dialogAddScholarshipBinding12 = get_binding();
        if (dialogAddScholarshipBinding12 == null || (textView = dialogAddScholarshipBinding12.updateBtn) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.profile.scholarships.add.AddScholarshipDialog$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AddScholarshipDialog.setUp$lambda$4(AddScholarshipDialog.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$2(AddScholarshipDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", false);
        intent.setType("*/*");
        this$0.startActivityForResult(Intent.createChooser(intent, "Select a file"), 111);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$3(AddScholarshipDialog this$0, View view) {
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
            DialogAddScholarshipBinding dialogAddScholarshipBinding = this$0.get_binding();
            if (String.valueOf((dialogAddScholarshipBinding == null || (textView5 = dialogAddScholarshipBinding.completionFileName) == null) ? null : textView5.getText()).length() > 0) {
                File file = this$0.pickFile;
                if (file == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pickFile");
                    file = null;
                }
                if (file.length() / 1024 <= 100) {
                    this$0.setCancelable(false);
                    DialogAddScholarshipBinding dialogAddScholarshipBinding2 = this$0.get_binding();
                    if (Intrinsics.areEqual(String.valueOf((dialogAddScholarshipBinding2 == null || (textInputEditText4 = dialogAddScholarshipBinding2.etName) == null) ? null : textInputEditText4.getText()), "")) {
                        DialogAddScholarshipBinding dialogAddScholarshipBinding3 = this$0.get_binding();
                        if (dialogAddScholarshipBinding3 == null || (textView4 = dialogAddScholarshipBinding3.completionSelect) == null) {
                            return;
                        }
                        ToastExtKt.showInfoToast(textView4, "Scholarship Name Cannot be empty");
                        return;
                    }
                    AddScholarshipViewModel addScholarshipViewModel = this$0.getAddScholarshipViewModel();
                    String str = this$0.type;
                    Intrinsics.checkNotNull(str);
                    DialogAddScholarshipBinding dialogAddScholarshipBinding4 = this$0.get_binding();
                    String valueOf = String.valueOf((dialogAddScholarshipBinding4 == null || (textInputEditText3 = dialogAddScholarshipBinding4.etName) == null) ? null : textInputEditText3.getText());
                    String str2 = this$0.yearId;
                    Intrinsics.checkNotNull(str2);
                    File file2 = this$0.pickFile;
                    if (file2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("pickFile");
                        file2 = null;
                    }
                    addScholarshipViewModel.addScholarshipData(str, valueOf, str2, file2);
                    DialogAddScholarshipBinding dialogAddScholarshipBinding5 = this$0.get_binding();
                    LinearLayout linearLayout = dialogAddScholarshipBinding5 != null ? dialogAddScholarshipBinding5.completionCard : null;
                    if (linearLayout != null) {
                        linearLayout.setVisibility(8);
                    }
                    DialogAddScholarshipBinding dialogAddScholarshipBinding6 = this$0.get_binding();
                    CardView cardView = dialogAddScholarshipBinding6 != null ? dialogAddScholarshipBinding6.progressView : null;
                    if (cardView == null) {
                        return;
                    }
                    cardView.setVisibility(0);
                    return;
                }
                DialogAddScholarshipBinding dialogAddScholarshipBinding7 = this$0.get_binding();
                if (dialogAddScholarshipBinding7 == null || (textView3 = dialogAddScholarshipBinding7.completionSelect) == null) {
                    return;
                }
                ToastExtKt.showInfoToast(textView3, "File Size Limit Is 100KB");
                return;
            }
            DialogAddScholarshipBinding dialogAddScholarshipBinding8 = this$0.get_binding();
            if (Intrinsics.areEqual(String.valueOf((dialogAddScholarshipBinding8 == null || (textInputEditText2 = dialogAddScholarshipBinding8.etName) == null) ? null : textInputEditText2.getText()), "")) {
                DialogAddScholarshipBinding dialogAddScholarshipBinding9 = this$0.get_binding();
                if (dialogAddScholarshipBinding9 == null || (textView2 = dialogAddScholarshipBinding9.completionSelect) == null) {
                    return;
                }
                ToastExtKt.showInfoToast(textView2, "Scholarship Name Cannot be empty");
                return;
            }
            AddScholarshipViewModel addScholarshipViewModel2 = this$0.getAddScholarshipViewModel();
            String str3 = this$0.type;
            Intrinsics.checkNotNull(str3);
            DialogAddScholarshipBinding dialogAddScholarshipBinding10 = this$0.get_binding();
            String valueOf2 = String.valueOf((dialogAddScholarshipBinding10 == null || (textInputEditText = dialogAddScholarshipBinding10.etName) == null) ? null : textInputEditText.getText());
            String str4 = this$0.yearId;
            Intrinsics.checkNotNull(str4);
            addScholarshipViewModel2.addScholarshipData(str3, valueOf2, str4);
            DialogAddScholarshipBinding dialogAddScholarshipBinding11 = this$0.get_binding();
            LinearLayout linearLayout2 = dialogAddScholarshipBinding11 != null ? dialogAddScholarshipBinding11.completionCard : null;
            if (linearLayout2 == null) {
                return;
            }
            linearLayout2.setVisibility(8);
        } catch (Exception unused) {
            DialogAddScholarshipBinding dialogAddScholarshipBinding12 = this$0.get_binding();
            if (dialogAddScholarshipBinding12 == null || (textView = dialogAddScholarshipBinding12.addBtn) == null) {
                return;
            }
            ToastExtKt.showErrorToast(textView, "Something went wrong.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$4(AddScholarshipDialog this$0, View view) {
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
            DialogAddScholarshipBinding dialogAddScholarshipBinding = this$0.get_binding();
            Editable editable = null;
            editable = null;
            if (String.valueOf((dialogAddScholarshipBinding == null || (textView4 = dialogAddScholarshipBinding.completionFileName) == null) ? null : textView4.getText()).length() > 0) {
                File file2 = this$0.pickFile;
                if (file2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pickFile");
                    file2 = null;
                }
                if (file2.length() / 1024 <= 100) {
                    this$0.setCancelable(false);
                    DialogAddScholarshipBinding dialogAddScholarshipBinding2 = this$0.get_binding();
                    if (Intrinsics.areEqual(String.valueOf((dialogAddScholarshipBinding2 == null || (textInputEditText4 = dialogAddScholarshipBinding2.etName) == null) ? null : textInputEditText4.getText()), "")) {
                        DialogAddScholarshipBinding dialogAddScholarshipBinding3 = this$0.get_binding();
                        if (dialogAddScholarshipBinding3 == null || (textView3 = dialogAddScholarshipBinding3.completionSelect) == null) {
                            return;
                        }
                        ToastExtKt.showInfoToast(textView3, "Scholarship Name Cannot be empty");
                        return;
                    }
                    AddScholarshipViewModel addScholarshipViewModel = this$0.getAddScholarshipViewModel();
                    String str = this$0.id;
                    Intrinsics.checkNotNull(str);
                    String str2 = this$0.type;
                    Intrinsics.checkNotNull(str2);
                    DialogAddScholarshipBinding dialogAddScholarshipBinding4 = this$0.get_binding();
                    String valueOf = String.valueOf((dialogAddScholarshipBinding4 == null || (textInputEditText3 = dialogAddScholarshipBinding4.etName) == null) ? null : textInputEditText3.getText());
                    String str3 = this$0.yearId;
                    Intrinsics.checkNotNull(str3);
                    File file3 = this$0.pickFile;
                    if (file3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("pickFile");
                        file = null;
                    } else {
                        file = file3;
                    }
                    addScholarshipViewModel.updateScholarshipData(str, str2, valueOf, str3, file);
                    DialogAddScholarshipBinding dialogAddScholarshipBinding5 = this$0.get_binding();
                    LinearLayout linearLayout = dialogAddScholarshipBinding5 != null ? dialogAddScholarshipBinding5.completionCard : null;
                    if (linearLayout != null) {
                        linearLayout.setVisibility(8);
                    }
                    DialogAddScholarshipBinding dialogAddScholarshipBinding6 = this$0.get_binding();
                    CardView cardView = dialogAddScholarshipBinding6 != null ? dialogAddScholarshipBinding6.progressView : null;
                    if (cardView == null) {
                        return;
                    }
                    cardView.setVisibility(0);
                    return;
                }
                DialogAddScholarshipBinding dialogAddScholarshipBinding7 = this$0.get_binding();
                if (dialogAddScholarshipBinding7 == null || (textView2 = dialogAddScholarshipBinding7.completionSelect) == null) {
                    return;
                }
                ToastExtKt.showInfoToast(textView2, "File Size Limit Is 100KB");
                return;
            }
            DialogAddScholarshipBinding dialogAddScholarshipBinding8 = this$0.get_binding();
            if (Intrinsics.areEqual(String.valueOf((dialogAddScholarshipBinding8 == null || (textInputEditText2 = dialogAddScholarshipBinding8.etName) == null) ? null : textInputEditText2.getText()), "")) {
                DialogAddScholarshipBinding dialogAddScholarshipBinding9 = this$0.get_binding();
                if (dialogAddScholarshipBinding9 == null || (textView = dialogAddScholarshipBinding9.completionSelect) == null) {
                    return;
                }
                ToastExtKt.showInfoToast(textView, "Scholarship Name Cannot be empty");
                return;
            }
            AddScholarshipViewModel addScholarshipViewModel2 = this$0.getAddScholarshipViewModel();
            String str4 = this$0.id;
            Intrinsics.checkNotNull(str4);
            String str5 = this$0.type;
            Intrinsics.checkNotNull(str5);
            DialogAddScholarshipBinding dialogAddScholarshipBinding10 = this$0.get_binding();
            if (dialogAddScholarshipBinding10 != null && (textInputEditText = dialogAddScholarshipBinding10.etName) != null) {
                editable = textInputEditText.getText();
            }
            String valueOf2 = String.valueOf(editable);
            String str6 = this$0.yearId;
            Intrinsics.checkNotNull(str6);
            addScholarshipViewModel2.updateScholarshipData(str4, str5, valueOf2, str6);
        } catch (Exception unused) {
        }
    }

    private final void listenSpinnerResponse() {
        getAddScholarshipViewModel().getResponse().observe(getViewLifecycleOwner(), new AddScholarshipDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends PublicationDropDownResponse>, Unit>() { // from class: in.etuwa.app.ui.profile.scholarships.add.AddScholarshipDialog$listenSpinnerResponse$1

            /* compiled from: AddScholarshipDialog.kt */
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
                DialogAddScholarshipBinding dialogAddScholarshipBinding;
                Spinner spinner;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i == 1) {
                    AddScholarshipDialog.this.hideProgress();
                    PublicationDropDownResponse data = resource.getData();
                    if (data != null) {
                        AddScholarshipDialog addScholarshipDialog = AddScholarshipDialog.this;
                        try {
                            spinnerAdapter = addScholarshipDialog.getSpinnerAdapter();
                            spinnerAdapter.addItems(data.getYears());
                            spinnerAdapter2 = addScholarshipDialog.getSpinnerAdapter2();
                            spinnerAdapter2.addItems(data.getScholarship());
                            return;
                        } catch (NullPointerException unused) {
                            return;
                        }
                    }
                    return;
                }
                if (i == 2) {
                    AddScholarshipDialog.this.showProgress();
                    return;
                }
                if (i == 3) {
                    AddScholarshipDialog.this.hideProgress();
                    return;
                }
                if (i != 4) {
                    return;
                }
                AddScholarshipDialog.this.hideProgress();
                dialogAddScholarshipBinding = AddScholarshipDialog.this.get_binding();
                if (dialogAddScholarshipBinding == null || (spinner = dialogAddScholarshipBinding.spinnerType) == null) {
                    return;
                }
                String message = resource.getMessage();
                Intrinsics.checkNotNull(message);
                ToastExtKt.showErrorToast(spinner, message);
            }
        }));
    }

    private final void listenAddResponse() {
        getAddScholarshipViewModel().getAddResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.profile.scholarships.add.AddScholarshipDialog$$ExternalSyntheticLambda4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AddScholarshipDialog.listenAddResponse$lambda$6(AddScholarshipDialog.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenAddResponse$lambda$6(AddScholarshipDialog this$0, Resource resource) {
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
            DialogAddScholarshipBinding dialogAddScholarshipBinding = this$0.get_binding();
            if (dialogAddScholarshipBinding != null && (textView = dialogAddScholarshipBinding.completionFileName) != null) {
                String message = resource.getMessage();
                Intrinsics.checkNotNull(message);
                ToastExtKt.showErrorToast(textView, message);
            }
            this$0.dismiss();
            AddScholarshipListener addScholarshipListener = this$0.listener;
            if (addScholarshipListener != null) {
                addScholarshipListener.onDismiss();
                return;
            }
            return;
        }
        this$0.hideProgress();
        SuccessResponse successResponse = (SuccessResponse) resource.getData();
        if (successResponse != null) {
            if (successResponse.getSuccess()) {
                DialogAddScholarshipBinding dialogAddScholarshipBinding2 = this$0.get_binding();
                if (dialogAddScholarshipBinding2 != null && (addBtn2 = dialogAddScholarshipBinding2.addBtn) != null) {
                    Intrinsics.checkNotNullExpressionValue(addBtn2, "addBtn");
                    ToastExtKt.showSuccessToast(addBtn2, successResponse.getMessage());
                }
                AddScholarshipListener addScholarshipListener2 = this$0.listener;
                if (addScholarshipListener2 != null) {
                    addScholarshipListener2.onDismiss();
                }
                this$0.dismiss();
                return;
            }
            DialogAddScholarshipBinding dialogAddScholarshipBinding3 = this$0.get_binding();
            if (dialogAddScholarshipBinding3 != null && (addBtn = dialogAddScholarshipBinding3.addBtn) != null) {
                Intrinsics.checkNotNullExpressionValue(addBtn, "addBtn");
                ToastExtKt.showErrorToast(addBtn, successResponse.getMessage());
            }
            AddScholarshipListener addScholarshipListener3 = this$0.listener;
            if (addScholarshipListener3 != null) {
                addScholarshipListener3.onDismiss();
            }
            this$0.dismiss();
        }
    }

    private final void listenAddResponse2() {
        getAddScholarshipViewModel().getAddResponse2().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.profile.scholarships.add.AddScholarshipDialog$$ExternalSyntheticLambda5
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AddScholarshipDialog.listenAddResponse2$lambda$8(AddScholarshipDialog.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenAddResponse2$lambda$8(AddScholarshipDialog this$0, Resource resource) {
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
            DialogAddScholarshipBinding dialogAddScholarshipBinding = this$0.get_binding();
            if (dialogAddScholarshipBinding != null && (textView = dialogAddScholarshipBinding.completionFileName) != null) {
                String message = resource.getMessage();
                Intrinsics.checkNotNull(message);
                ToastExtKt.showErrorToast(textView, message);
            }
            this$0.dismiss();
            AddScholarshipListener addScholarshipListener = this$0.listener;
            if (addScholarshipListener != null) {
                addScholarshipListener.onDismiss();
                return;
            }
            return;
        }
        this$0.hideProgress();
        SuccessResponse successResponse = (SuccessResponse) resource.getData();
        if (successResponse != null) {
            if (successResponse.getSuccess()) {
                DialogAddScholarshipBinding dialogAddScholarshipBinding2 = this$0.get_binding();
                if (dialogAddScholarshipBinding2 != null && (addBtn2 = dialogAddScholarshipBinding2.addBtn) != null) {
                    Intrinsics.checkNotNullExpressionValue(addBtn2, "addBtn");
                    ToastExtKt.showSuccessToast(addBtn2, successResponse.getMessage());
                }
                AddScholarshipListener addScholarshipListener2 = this$0.listener;
                if (addScholarshipListener2 != null) {
                    addScholarshipListener2.onDismiss();
                }
                this$0.dismiss();
                return;
            }
            DialogAddScholarshipBinding dialogAddScholarshipBinding3 = this$0.get_binding();
            if (dialogAddScholarshipBinding3 != null && (addBtn = dialogAddScholarshipBinding3.addBtn) != null) {
                Intrinsics.checkNotNullExpressionValue(addBtn, "addBtn");
                ToastExtKt.showErrorToast(addBtn, successResponse.getMessage());
            }
            AddScholarshipListener addScholarshipListener3 = this$0.listener;
            if (addScholarshipListener3 != null) {
                addScholarshipListener3.onDismiss();
            }
            this$0.dismiss();
        }
    }

    private final void listenUpdateResponse() {
        getAddScholarshipViewModel().getUpdateResponse2().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.profile.scholarships.add.AddScholarshipDialog$$ExternalSyntheticLambda6
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AddScholarshipDialog.listenUpdateResponse$lambda$10(AddScholarshipDialog.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenUpdateResponse$lambda$10(AddScholarshipDialog this$0, Resource resource) {
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
            DialogAddScholarshipBinding dialogAddScholarshipBinding = this$0.get_binding();
            if (dialogAddScholarshipBinding != null && (textView = dialogAddScholarshipBinding.completionFileName) != null) {
                String message = resource.getMessage();
                Intrinsics.checkNotNull(message);
                ToastExtKt.showErrorToast(textView, message);
            }
            this$0.dismiss();
            AddScholarshipListener addScholarshipListener = this$0.listener;
            if (addScholarshipListener != null) {
                addScholarshipListener.onDismiss();
                return;
            }
            return;
        }
        this$0.hideProgress();
        SuccessResponse successResponse = (SuccessResponse) resource.getData();
        if (successResponse != null) {
            if (successResponse.getSuccess()) {
                DialogAddScholarshipBinding dialogAddScholarshipBinding2 = this$0.get_binding();
                if (dialogAddScholarshipBinding2 != null && (completionFileName2 = dialogAddScholarshipBinding2.completionFileName) != null) {
                    Intrinsics.checkNotNullExpressionValue(completionFileName2, "completionFileName");
                    ToastExtKt.showSuccessToast(completionFileName2, successResponse.getMessage());
                }
                AddScholarshipListener addScholarshipListener2 = this$0.listener;
                if (addScholarshipListener2 != null) {
                    addScholarshipListener2.onDismiss();
                }
                this$0.dismiss();
                return;
            }
            DialogAddScholarshipBinding dialogAddScholarshipBinding3 = this$0.get_binding();
            if (dialogAddScholarshipBinding3 != null && (completionFileName = dialogAddScholarshipBinding3.completionFileName) != null) {
                Intrinsics.checkNotNullExpressionValue(completionFileName, "completionFileName");
                ToastExtKt.showErrorToast(completionFileName, successResponse.getMessage());
            }
            AddScholarshipListener addScholarshipListener3 = this$0.listener;
            if (addScholarshipListener3 != null) {
                addScholarshipListener3.onDismiss();
            }
            this$0.dismiss();
        }
    }

    private final void listenProgressResponse() {
        getAddScholarshipViewModel().getProgressResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.profile.scholarships.add.AddScholarshipDialog$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AddScholarshipDialog.listenProgressResponse$lambda$12(AddScholarshipDialog.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenProgressResponse$lambda$12(AddScholarshipDialog this$0, Resource resource) {
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
            DialogAddScholarshipBinding dialogAddScholarshipBinding = this$0.get_binding();
            if (dialogAddScholarshipBinding == null || (textView = dialogAddScholarshipBinding.completionFileName) == null) {
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
            DialogAddScholarshipBinding dialogAddScholarshipBinding2 = this$0.get_binding();
            ProgressBar progressBar = dialogAddScholarshipBinding2 != null ? dialogAddScholarshipBinding2.uploadProgressbar : null;
            if (progressBar != null) {
                progressBar.setProgress((int) floatValue);
            }
            DialogAddScholarshipBinding dialogAddScholarshipBinding3 = this$0.get_binding();
            TextView textView2 = dialogAddScholarshipBinding3 != null ? dialogAddScholarshipBinding3.progressText : null;
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
                    DialogAddScholarshipBinding dialogAddScholarshipBinding = get_binding();
                    if (dialogAddScholarshipBinding == null || (completionFileName = dialogAddScholarshipBinding.completionFileName) == null) {
                        return;
                    }
                    Intrinsics.checkNotNullExpressionValue(completionFileName, "completionFileName");
                    ToastExtKt.showErrorToast(completionFileName, "Please select a PDF or JPG file.");
                    return;
                }
                DialogAddScholarshipBinding dialogAddScholarshipBinding2 = get_binding();
                TextView textView = dialogAddScholarshipBinding2 != null ? dialogAddScholarshipBinding2.completionFileName : null;
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

    public final void setCallBack(ScholarshipFragment context) {
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