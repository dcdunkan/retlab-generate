package in.etuwa.app.ui.hostel.gcekhostel.registration.editregistration;

import android.content.ComponentCallbacks;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
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
import in.etuwa.app.data.model.Semester;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.hostel.gcekhostel.newregistration.CategoryTypeResponse;
import in.etuwa.app.databinding.DialogEditRegistrationBinding;
import in.etuwa.app.helper.SemesterSpinnerAdapter;
import in.etuwa.app.ui.attendance.bydaynew.attendaceday.AttendanceDayDialogKt;
import in.etuwa.app.ui.base.BaseDialog;
import in.etuwa.app.ui.hostel.gcekhostel.registration.RegistrationFragment;
import in.etuwa.app.ui.hostel.gcekhostel.registration.newregistration.CategorySpinnerAdapter;
import in.etuwa.app.ui.hostel.gcekhostel.registration.newregistration.ReAdmissionSpinnerAdapter;
import in.etuwa.app.utils.ResolvUtilKt;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
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

/* compiled from: EditRegistrationDialog.kt */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 E2\u00020\u0001:\u0002EFB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010(\u001a\u00020)H\u0014J\b\u0010*\u001a\u00020)H\u0002J\b\u0010+\u001a\u00020)H\u0002J\b\u0010,\u001a\u00020)H\u0002J\b\u0010-\u001a\u00020)H\u0002J\"\u0010.\u001a\u00020)2\u0006\u0010/\u001a\u00020\u00162\u0006\u00100\u001a\u00020\u00162\b\u00101\u001a\u0004\u0018\u000102H\u0016J\u0012\u00103\u001a\u00020)2\b\u00104\u001a\u0004\u0018\u000105H\u0016J&\u00106\u001a\u0004\u0018\u0001072\u0006\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010;2\b\u00104\u001a\u0004\u0018\u000105H\u0016J\b\u0010<\u001a\u00020)H\u0016J\b\u0010=\u001a\u00020)H\u0016J\u001a\u0010>\u001a\u00020)2\u0006\u0010?\u001a\u0002072\b\u00104\u001a\u0004\u0018\u000105H\u0016J\u000e\u0010@\u001a\u00020)2\u0006\u0010A\u001a\u00020BJ\b\u0010C\u001a\u00020)H\u0015J\b\u0010D\u001a\u00020)H\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u000f\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u000f\u001a\u0004\b \u0010!R\u001b\u0010#\u001a\u00020$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u000f\u001a\u0004\b%\u0010&¨\u0006G"}, d2 = {"Lin/etuwa/app/ui/hostel/gcekhostel/registration/editregistration/EditRegistrationDialog;", "Lin/etuwa/app/ui/base/BaseDialog;", "()V", "_binding", "Lin/etuwa/app/databinding/DialogEditRegistrationBinding;", "binding", "getBinding", "()Lin/etuwa/app/databinding/DialogEditRegistrationBinding;", "category", "", "editRegistrationViewModel", "Lin/etuwa/app/ui/hostel/gcekhostel/registration/editregistration/EditRegistrationViewModel;", "getEditRegistrationViewModel", "()Lin/etuwa/app/ui/hostel/gcekhostel/registration/editregistration/EditRegistrationViewModel;", "editRegistrationViewModel$delegate", "Lkotlin/Lazy;", "id", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/hostel/gcekhostel/registration/editregistration/EditRegistrationDialog$EditRegistrationListener;", "pickFile", "Ljava/io/File;", "pos", "", "reAdmission", AttendanceDayDialogKt.ARG_SEM, "spinnerAdapter", "Lin/etuwa/app/ui/hostel/gcekhostel/registration/newregistration/CategorySpinnerAdapter;", "getSpinnerAdapter", "()Lin/etuwa/app/ui/hostel/gcekhostel/registration/newregistration/CategorySpinnerAdapter;", "spinnerAdapter$delegate", "spinnerAdapter2", "Lin/etuwa/app/helper/SemesterSpinnerAdapter;", "getSpinnerAdapter2", "()Lin/etuwa/app/helper/SemesterSpinnerAdapter;", "spinnerAdapter2$delegate", "spinnerAdapter3", "Lin/etuwa/app/ui/hostel/gcekhostel/registration/newregistration/ReAdmissionSpinnerAdapter;", "getSpinnerAdapter3", "()Lin/etuwa/app/ui/hostel/gcekhostel/registration/newregistration/ReAdmissionSpinnerAdapter;", "spinnerAdapter3$delegate", "hideProgress", "", "listenProgressResponse", "listenResponse", "listenSemResponse", "listenSpinnerResponse", "onActivityResult", "requestCode", "resultCode", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDetach", "onViewCreated", SvgConstants.Tags.VIEW, "setCallBack", "context", "Lin/etuwa/app/ui/hostel/gcekhostel/registration/RegistrationFragment;", "setUp", "showProgress", "Companion", "EditRegistrationListener", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class EditRegistrationDialog extends BaseDialog {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private DialogEditRegistrationBinding _binding;
    private String category;

    /* renamed from: editRegistrationViewModel$delegate, reason: from kotlin metadata */
    private final Lazy editRegistrationViewModel;
    private String id;
    private EditRegistrationListener listener;
    private File pickFile;
    private int pos;
    private String reAdmission;
    private String semester;

    /* renamed from: spinnerAdapter$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdapter;

    /* renamed from: spinnerAdapter2$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdapter2;

    /* renamed from: spinnerAdapter3$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdapter3;

    /* compiled from: EditRegistrationDialog.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lin/etuwa/app/ui/hostel/gcekhostel/registration/editregistration/EditRegistrationDialog$EditRegistrationListener;", "", "onDismiss", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface EditRegistrationListener {
        void onDismiss();
    }

    /* compiled from: EditRegistrationDialog.kt */
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
    public static final EditRegistrationDialog newInstance(String str) {
        return INSTANCE.newInstance(str);
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void showProgress() {
    }

    public EditRegistrationDialog() {
        final EditRegistrationDialog editRegistrationDialog = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.editregistration.EditRegistrationDialog$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(editRegistrationDialog);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.editRegistrationViewModel = FragmentViewModelLazyKt.createViewModelLazy(editRegistrationDialog, Reflection.getOrCreateKotlinClass(EditRegistrationViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.editregistration.EditRegistrationDialog$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.editregistration.EditRegistrationDialog$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(EditRegistrationViewModel.class), qualifier, b, null, koinScope);
            }
        });
        this.category = "";
        this.semester = "";
        this.reAdmission = "";
        this.pos = 1;
        final EditRegistrationDialog editRegistrationDialog2 = this;
        final Function0<ParametersHolder> function02 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.editregistration.EditRegistrationDialog$spinnerAdapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(EditRegistrationDialog.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        this.spinnerAdapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<CategorySpinnerAdapter>() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.editregistration.EditRegistrationDialog$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.hostel.gcekhostel.registration.newregistration.CategorySpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final CategorySpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = editRegistrationDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(CategorySpinnerAdapter.class), b2, function02);
            }
        });
        final Function0<ParametersHolder> function03 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.editregistration.EditRegistrationDialog$spinnerAdapter2$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(EditRegistrationDialog.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b3 = 0 == true ? 1 : 0;
        this.spinnerAdapter2 = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<SemesterSpinnerAdapter>() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.editregistration.EditRegistrationDialog$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.helper.SemesterSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SemesterSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = editRegistrationDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SemesterSpinnerAdapter.class), b3, function03);
            }
        });
        final Function0<ParametersHolder> function04 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.editregistration.EditRegistrationDialog$spinnerAdapter3$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(EditRegistrationDialog.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode3 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        this.spinnerAdapter3 = LazyKt.lazy(lazyThreadSafetyMode3, (Function0) new Function0<ReAdmissionSpinnerAdapter>() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.editregistration.EditRegistrationDialog$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.hostel.gcekhostel.registration.newregistration.ReAdmissionSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final ReAdmissionSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = editRegistrationDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(ReAdmissionSpinnerAdapter.class), b4, function04);
            }
        });
    }

    private final EditRegistrationViewModel getEditRegistrationViewModel() {
        return (EditRegistrationViewModel) this.editRegistrationViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getBinding, reason: from getter */
    public final DialogEditRegistrationBinding get_binding() {
        return this._binding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CategorySpinnerAdapter getSpinnerAdapter() {
        return (CategorySpinnerAdapter) this.spinnerAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SemesterSpinnerAdapter getSpinnerAdapter2() {
        return (SemesterSpinnerAdapter) this.spinnerAdapter2.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ReAdmissionSpinnerAdapter getSpinnerAdapter3() {
        return (ReAdmissionSpinnerAdapter) this.spinnerAdapter3.getValue();
    }

    /* compiled from: EditRegistrationDialog.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lin/etuwa/app/ui/hostel/gcekhostel/registration/editregistration/EditRegistrationDialog$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/hostel/gcekhostel/registration/editregistration/EditRegistrationDialog;", "id", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final EditRegistrationDialog newInstance(String id) {
            EditRegistrationDialog editRegistrationDialog = new EditRegistrationDialog();
            Bundle bundle = new Bundle();
            bundle.putString("id", id);
            editRegistrationDialog.setArguments(bundle);
            return editRegistrationDialog;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.id = arguments.getString("id");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = DialogEditRegistrationBinding.inflate(inflater, container, false);
        DialogEditRegistrationBinding dialogEditRegistrationBinding = get_binding();
        if (dialogEditRegistrationBinding != null) {
            dialogEditRegistrationBinding.setEditRegistrationViewModel(getEditRegistrationViewModel());
        }
        DialogEditRegistrationBinding dialogEditRegistrationBinding2 = get_binding();
        if (dialogEditRegistrationBinding2 != null) {
            dialogEditRegistrationBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        DialogEditRegistrationBinding dialogEditRegistrationBinding3 = get_binding();
        if (dialogEditRegistrationBinding3 != null) {
            return dialogEditRegistrationBinding3.getRoot();
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
        DialogEditRegistrationBinding dialogEditRegistrationBinding = get_binding();
        Spinner spinner = dialogEditRegistrationBinding != null ? dialogEditRegistrationBinding.spinnerCatogory : null;
        if (spinner != null) {
            spinner.setAdapter((SpinnerAdapter) getSpinnerAdapter());
        }
        DialogEditRegistrationBinding dialogEditRegistrationBinding2 = get_binding();
        Spinner spinner2 = dialogEditRegistrationBinding2 != null ? dialogEditRegistrationBinding2.spinnerSemesterApplied : null;
        if (spinner2 != null) {
            spinner2.setAdapter((SpinnerAdapter) getSpinnerAdapter2());
        }
        DialogEditRegistrationBinding dialogEditRegistrationBinding3 = get_binding();
        Spinner spinner3 = dialogEditRegistrationBinding3 != null ? dialogEditRegistrationBinding3.spinnerReadmission : null;
        if (spinner3 != null) {
            spinner3.setAdapter((SpinnerAdapter) getSpinnerAdapter3());
        }
        ReAdmissionSpinnerAdapter spinnerAdapter3 = getSpinnerAdapter3();
        if (spinnerAdapter3 != null) {
            spinnerAdapter3.addItems(new String[]{"No", "Yes"});
        }
        listenSpinnerResponse();
        listenSemResponse();
        listenProgressResponse();
        listenResponse();
        DialogEditRegistrationBinding dialogEditRegistrationBinding4 = get_binding();
        Spinner spinner4 = dialogEditRegistrationBinding4 != null ? dialogEditRegistrationBinding4.spinnerCatogory : null;
        if (spinner4 != null) {
            spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.editregistration.EditRegistrationDialog$setUp$1
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    CategorySpinnerAdapter spinnerAdapter;
                    EditRegistrationDialog editRegistrationDialog = EditRegistrationDialog.this;
                    spinnerAdapter = editRegistrationDialog.getSpinnerAdapter();
                    editRegistrationDialog.category = String.valueOf(spinnerAdapter.getType(position).getId());
                }
            });
        }
        DialogEditRegistrationBinding dialogEditRegistrationBinding5 = get_binding();
        Spinner spinner5 = dialogEditRegistrationBinding5 != null ? dialogEditRegistrationBinding5.spinnerSemesterApplied : null;
        if (spinner5 != null) {
            spinner5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.editregistration.EditRegistrationDialog$setUp$2
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    SemesterSpinnerAdapter spinnerAdapter2;
                    EditRegistrationDialog editRegistrationDialog = EditRegistrationDialog.this;
                    spinnerAdapter2 = editRegistrationDialog.getSpinnerAdapter2();
                    editRegistrationDialog.semester = spinnerAdapter2.getSemester(position).getId();
                }
            });
        }
        DialogEditRegistrationBinding dialogEditRegistrationBinding6 = get_binding();
        Spinner spinner6 = dialogEditRegistrationBinding6 != null ? dialogEditRegistrationBinding6.spinnerReadmission : null;
        if (spinner6 != null) {
            spinner6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.editregistration.EditRegistrationDialog$setUp$3
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    ReAdmissionSpinnerAdapter spinnerAdapter32;
                    EditRegistrationDialog editRegistrationDialog = EditRegistrationDialog.this;
                    spinnerAdapter32 = editRegistrationDialog.getSpinnerAdapter3();
                    editRegistrationDialog.reAdmission = spinnerAdapter32.getSemester(position);
                    EditRegistrationDialog.this.pos = position + 1;
                }
            });
        }
        DialogEditRegistrationBinding dialogEditRegistrationBinding7 = get_binding();
        if (dialogEditRegistrationBinding7 != null && (textView2 = dialogEditRegistrationBinding7.completionSelect) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.editregistration.EditRegistrationDialog$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EditRegistrationDialog.setUp$lambda$2(EditRegistrationDialog.this, view);
                }
            });
        }
        DialogEditRegistrationBinding dialogEditRegistrationBinding8 = get_binding();
        if (dialogEditRegistrationBinding8 == null || (textView = dialogEditRegistrationBinding8.registerBtn) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.editregistration.EditRegistrationDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EditRegistrationDialog.setUp$lambda$5(EditRegistrationDialog.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$2(EditRegistrationDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", false);
        intent.setType("*/*");
        this$0.startActivityForResult(Intent.createChooser(intent, "Select a file"), 111);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$5(EditRegistrationDialog this$0, View view) {
        File file;
        TextInputEditText textInputEditText;
        TextInputEditText textInputEditText2;
        TextInputEditText textInputEditText3;
        TextInputEditText textInputEditText4;
        TextView textView;
        TextView textView2;
        File file2;
        TextInputEditText textInputEditText5;
        TextInputEditText textInputEditText6;
        TextInputEditText textInputEditText7;
        TextInputEditText textInputEditText8;
        TextView textView3;
        TextInputEditText textInputEditText9;
        TextView textView4;
        TextInputEditText textInputEditText10;
        TextView textView5;
        TextInputEditText textInputEditText11;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        File file3 = this$0.pickFile;
        if (file3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pickFile");
            file3 = null;
        }
        System.out.println((Object) ("================" + file3 + "=================="));
        System.out.println((Object) ("================" + this$0.id + "=================="));
        try {
            File file4 = this$0.pickFile;
            if (file4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pickFile");
                file4 = null;
            }
            if (file4.exists()) {
                File file5 = this$0.pickFile;
                if (file5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pickFile");
                    file5 = null;
                }
                if (file5.length() / 1024 <= 500) {
                    this$0.setCancelable(false);
                    DialogEditRegistrationBinding dialogEditRegistrationBinding = this$0.get_binding();
                    if (Intrinsics.areEqual(String.valueOf((dialogEditRegistrationBinding == null || (textInputEditText11 = dialogEditRegistrationBinding.etAnnualIncome) == null) ? null : textInputEditText11.getText()), "")) {
                        DialogEditRegistrationBinding dialogEditRegistrationBinding2 = this$0.get_binding();
                        if (dialogEditRegistrationBinding2 == null || (textView5 = dialogEditRegistrationBinding2.completionSelect) == null) {
                            return;
                        }
                        ToastExtKt.showInfoToast(textView5, "Annual Income Cannot be empty");
                        return;
                    }
                    DialogEditRegistrationBinding dialogEditRegistrationBinding3 = this$0.get_binding();
                    if (Intrinsics.areEqual(String.valueOf((dialogEditRegistrationBinding3 == null || (textInputEditText10 = dialogEditRegistrationBinding3.etDistance) == null) ? null : textInputEditText10.getText()), "")) {
                        DialogEditRegistrationBinding dialogEditRegistrationBinding4 = this$0.get_binding();
                        if (dialogEditRegistrationBinding4 == null || (textView4 = dialogEditRegistrationBinding4.completionSelect) == null) {
                            return;
                        }
                        ToastExtKt.showInfoToast(textView4, "Distance cannot be empty");
                        return;
                    }
                    DialogEditRegistrationBinding dialogEditRegistrationBinding5 = this$0.get_binding();
                    if (String.valueOf((dialogEditRegistrationBinding5 == null || (textInputEditText9 = dialogEditRegistrationBinding5.etPhone) == null) ? null : textInputEditText9.getText()).length() < 10) {
                        DialogEditRegistrationBinding dialogEditRegistrationBinding6 = this$0.get_binding();
                        if (dialogEditRegistrationBinding6 == null || (textView3 = dialogEditRegistrationBinding6.completionSelect) == null) {
                            return;
                        }
                        ToastExtKt.showInfoToast(textView3, "Phone Number should be atleast 10 numbers");
                        return;
                    }
                    String str = this$0.id;
                    if (str != null) {
                        EditRegistrationViewModel editRegistrationViewModel = this$0.getEditRegistrationViewModel();
                        String str2 = this$0.reAdmission;
                        String str3 = this$0.category;
                        DialogEditRegistrationBinding dialogEditRegistrationBinding7 = this$0.get_binding();
                        String valueOf = String.valueOf((dialogEditRegistrationBinding7 == null || (textInputEditText8 = dialogEditRegistrationBinding7.etNameAddress) == null) ? null : textInputEditText8.getText());
                        DialogEditRegistrationBinding dialogEditRegistrationBinding8 = this$0.get_binding();
                        String valueOf2 = String.valueOf((dialogEditRegistrationBinding8 == null || (textInputEditText7 = dialogEditRegistrationBinding8.etPhone) == null) ? null : textInputEditText7.getText());
                        DialogEditRegistrationBinding dialogEditRegistrationBinding9 = this$0.get_binding();
                        String valueOf3 = String.valueOf((dialogEditRegistrationBinding9 == null || (textInputEditText6 = dialogEditRegistrationBinding9.etAnnualIncome) == null) ? null : textInputEditText6.getText());
                        DialogEditRegistrationBinding dialogEditRegistrationBinding10 = this$0.get_binding();
                        String valueOf4 = String.valueOf((dialogEditRegistrationBinding10 == null || (textInputEditText5 = dialogEditRegistrationBinding10.etDistance) == null) ? null : textInputEditText5.getText());
                        String str4 = this$0.semester;
                        File file6 = this$0.pickFile;
                        if (file6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("pickFile");
                            file2 = null;
                        } else {
                            file2 = file6;
                        }
                        editRegistrationViewModel.newHostelRegistrationApiCall(str, str2, str3, valueOf, valueOf2, valueOf3, valueOf4, str4, file2);
                    }
                    DialogEditRegistrationBinding dialogEditRegistrationBinding11 = this$0.get_binding();
                    LinearLayout linearLayout = dialogEditRegistrationBinding11 != null ? dialogEditRegistrationBinding11.completionCard : null;
                    if (linearLayout != null) {
                        linearLayout.setVisibility(8);
                    }
                    DialogEditRegistrationBinding dialogEditRegistrationBinding12 = this$0.get_binding();
                    CardView cardView = dialogEditRegistrationBinding12 != null ? dialogEditRegistrationBinding12.progressView : null;
                    if (cardView == null) {
                        return;
                    }
                    cardView.setVisibility(0);
                    return;
                }
                DialogEditRegistrationBinding dialogEditRegistrationBinding13 = this$0.get_binding();
                if (dialogEditRegistrationBinding13 == null || (textView2 = dialogEditRegistrationBinding13.completionSelect) == null) {
                    return;
                }
                ToastExtKt.showInfoToast(textView2, "File Size Limit Is 500KB");
                return;
            }
            DialogEditRegistrationBinding dialogEditRegistrationBinding14 = this$0.get_binding();
            if (dialogEditRegistrationBinding14 == null || (textView = dialogEditRegistrationBinding14.completionSelect) == null) {
                return;
            }
            ToastExtKt.showInfoToast(textView, "Please Select A File");
        } catch (Exception unused) {
            String str5 = this$0.id;
            if (str5 != null) {
                EditRegistrationViewModel editRegistrationViewModel2 = this$0.getEditRegistrationViewModel();
                String str6 = this$0.reAdmission;
                String str7 = this$0.category;
                DialogEditRegistrationBinding dialogEditRegistrationBinding15 = this$0.get_binding();
                String valueOf5 = String.valueOf((dialogEditRegistrationBinding15 == null || (textInputEditText4 = dialogEditRegistrationBinding15.etNameAddress) == null) ? null : textInputEditText4.getText());
                DialogEditRegistrationBinding dialogEditRegistrationBinding16 = this$0.get_binding();
                String valueOf6 = String.valueOf((dialogEditRegistrationBinding16 == null || (textInputEditText3 = dialogEditRegistrationBinding16.etPhone) == null) ? null : textInputEditText3.getText());
                DialogEditRegistrationBinding dialogEditRegistrationBinding17 = this$0.get_binding();
                String valueOf7 = String.valueOf((dialogEditRegistrationBinding17 == null || (textInputEditText2 = dialogEditRegistrationBinding17.etAnnualIncome) == null) ? null : textInputEditText2.getText());
                DialogEditRegistrationBinding dialogEditRegistrationBinding18 = this$0.get_binding();
                String valueOf8 = String.valueOf((dialogEditRegistrationBinding18 == null || (textInputEditText = dialogEditRegistrationBinding18.etDistance) == null) ? null : textInputEditText.getText());
                String str8 = this$0.semester;
                File file7 = this$0.pickFile;
                if (file7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pickFile");
                    file = null;
                } else {
                    file = file7;
                }
                editRegistrationViewModel2.newHostelRegistrationApiCall(str5, str6, str7, valueOf5, valueOf6, valueOf7, valueOf8, str8, file);
            }
        }
    }

    private final void listenSpinnerResponse() {
        getEditRegistrationViewModel().getResponse().observe(getViewLifecycleOwner(), new EditRegistrationDialogKt$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends CategoryTypeResponse>, Unit>() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.editregistration.EditRegistrationDialog$listenSpinnerResponse$1

            /* compiled from: EditRegistrationDialog.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends CategoryTypeResponse> resource) {
                invoke2((Resource<CategoryTypeResponse>) resource);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<CategoryTypeResponse> resource) {
                CategorySpinnerAdapter spinnerAdapter;
                DialogEditRegistrationBinding dialogEditRegistrationBinding;
                Spinner spinner;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i == 1) {
                    EditRegistrationDialog.this.hideProgress();
                    CategoryTypeResponse data = resource.getData();
                    if (data != null) {
                        try {
                            spinnerAdapter = EditRegistrationDialog.this.getSpinnerAdapter();
                            spinnerAdapter.addItems(data.getCategory());
                            return;
                        } catch (NullPointerException unused) {
                            return;
                        }
                    }
                    return;
                }
                if (i == 2) {
                    EditRegistrationDialog.this.showProgress();
                    return;
                }
                if (i == 3) {
                    EditRegistrationDialog.this.hideProgress();
                    return;
                }
                if (i != 4) {
                    return;
                }
                EditRegistrationDialog.this.hideProgress();
                dialogEditRegistrationBinding = EditRegistrationDialog.this.get_binding();
                if (dialogEditRegistrationBinding == null || (spinner = dialogEditRegistrationBinding.spinnerCatogory) == null) {
                    return;
                }
                String message = resource.getMessage();
                Intrinsics.checkNotNull(message);
                ToastExtKt.showErrorToast(spinner, message);
            }
        }));
    }

    private final void listenSemResponse() {
        getEditRegistrationViewModel().getSemResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.editregistration.EditRegistrationDialog$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EditRegistrationDialog.listenSemResponse$lambda$7(EditRegistrationDialog.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenSemResponse$lambda$7(EditRegistrationDialog this$0, Resource resource) {
        Spinner spinner;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            ArrayList<Semester> arrayList = (ArrayList) resource.getData();
            if (arrayList != null) {
                this$0.getSpinnerAdapter2().addItems(arrayList);
                return;
            }
            return;
        }
        if (i == 2) {
            this$0.showProgress();
            return;
        }
        if (i == 3) {
            this$0.hideProgress();
            return;
        }
        if (i != 4) {
            return;
        }
        this$0.hideProgress();
        DialogEditRegistrationBinding dialogEditRegistrationBinding = this$0.get_binding();
        if (dialogEditRegistrationBinding == null || (spinner = dialogEditRegistrationBinding.spinnerSemesterApplied) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(spinner, message);
    }

    private final void listenResponse() {
        getEditRegistrationViewModel().getUploadResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.editregistration.EditRegistrationDialog$$ExternalSyntheticLambda3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EditRegistrationDialog.listenResponse$lambda$9(EditRegistrationDialog.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$9(EditRegistrationDialog this$0, Resource resource) {
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
            DialogEditRegistrationBinding dialogEditRegistrationBinding = this$0.get_binding();
            if (dialogEditRegistrationBinding != null && (textView = dialogEditRegistrationBinding.completionFileName) != null) {
                String message = resource.getMessage();
                Intrinsics.checkNotNull(message);
                ToastExtKt.showErrorToast(textView, message);
            }
            this$0.dismiss();
            EditRegistrationListener editRegistrationListener = this$0.listener;
            if (editRegistrationListener != null) {
                editRegistrationListener.onDismiss();
                return;
            }
            return;
        }
        this$0.hideProgress();
        SuccessResponse successResponse = (SuccessResponse) resource.getData();
        if (successResponse != null) {
            if (successResponse.getSuccess()) {
                DialogEditRegistrationBinding dialogEditRegistrationBinding2 = this$0.get_binding();
                if (dialogEditRegistrationBinding2 != null && (completionFileName2 = dialogEditRegistrationBinding2.completionFileName) != null) {
                    Intrinsics.checkNotNullExpressionValue(completionFileName2, "completionFileName");
                    ToastExtKt.showSuccessToast(completionFileName2, successResponse.getMessage());
                }
                EditRegistrationListener editRegistrationListener2 = this$0.listener;
                if (editRegistrationListener2 != null) {
                    editRegistrationListener2.onDismiss();
                }
                this$0.dismiss();
                return;
            }
            DialogEditRegistrationBinding dialogEditRegistrationBinding3 = this$0.get_binding();
            if (dialogEditRegistrationBinding3 != null && (completionFileName = dialogEditRegistrationBinding3.completionFileName) != null) {
                Intrinsics.checkNotNullExpressionValue(completionFileName, "completionFileName");
                ToastExtKt.showErrorToast(completionFileName, successResponse.getMessage());
            }
            EditRegistrationListener editRegistrationListener3 = this$0.listener;
            if (editRegistrationListener3 != null) {
                editRegistrationListener3.onDismiss();
            }
            this$0.dismiss();
        }
    }

    private final void listenProgressResponse() {
        getEditRegistrationViewModel().getProgressResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.editregistration.EditRegistrationDialog$$ExternalSyntheticLambda4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EditRegistrationDialog.listenProgressResponse$lambda$11(EditRegistrationDialog.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenProgressResponse$lambda$11(EditRegistrationDialog this$0, Resource resource) {
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
            DialogEditRegistrationBinding dialogEditRegistrationBinding = this$0.get_binding();
            if (dialogEditRegistrationBinding == null || (textView = dialogEditRegistrationBinding.completionFileName) == null) {
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
            DialogEditRegistrationBinding dialogEditRegistrationBinding2 = this$0.get_binding();
            ProgressBar progressBar = dialogEditRegistrationBinding2 != null ? dialogEditRegistrationBinding2.uploadProgressbar : null;
            if (progressBar != null) {
                progressBar.setProgress((int) floatValue);
            }
            DialogEditRegistrationBinding dialogEditRegistrationBinding3 = this$0.get_binding();
            TextView textView2 = dialogEditRegistrationBinding3 != null ? dialogEditRegistrationBinding3.progressText : null;
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
        ContentResolver contentResolver;
        ParcelFileDescriptor openFileDescriptor;
        String str;
        ContentResolver contentResolver2;
        String str2;
        ContentResolver contentResolver3;
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != -1 || data == null) {
            return;
        }
        try {
            Uri data2 = data.getData();
            if (data2 != null) {
                DialogEditRegistrationBinding dialogEditRegistrationBinding = get_binding();
                TextView textView = dialogEditRegistrationBinding != null ? dialogEditRegistrationBinding.completionFileName : null;
                if (textView != null) {
                    Context context = getContext();
                    if (context == null || (contentResolver3 = context.getContentResolver()) == null) {
                        str2 = null;
                    } else {
                        Intrinsics.checkNotNullExpressionValue(contentResolver3, "contentResolver");
                        str2 = ResolvUtilKt.getFileName(contentResolver3, data2);
                    }
                    textView.setText("File : " + str2);
                }
                Context context2 = getContext();
                if (context2 != null && (contentResolver = context2.getContentResolver()) != null && (openFileDescriptor = contentResolver.openFileDescriptor(data2, "r", null)) != null) {
                    Intrinsics.checkNotNullExpressionValue(openFileDescriptor, "context?.contentResolver…  it, \"r\", null)?: return");
                    Context context3 = getContext();
                    File cacheDir = context3 != null ? context3.getCacheDir() : null;
                    Context context4 = getContext();
                    if (context4 == null || (contentResolver2 = context4.getContentResolver()) == null) {
                        str = null;
                    } else {
                        Intrinsics.checkNotNullExpressionValue(contentResolver2, "contentResolver");
                        str = ResolvUtilKt.getFileName(contentResolver2, data2);
                    }
                    File file = new File(cacheDir, str);
                    ByteStreamsKt.copyTo$default(new FileInputStream(openFileDescriptor.getFileDescriptor()), new FileOutputStream(file), 0, 2, null);
                    this.pickFile = file;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void setCallBack(RegistrationFragment context) {
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