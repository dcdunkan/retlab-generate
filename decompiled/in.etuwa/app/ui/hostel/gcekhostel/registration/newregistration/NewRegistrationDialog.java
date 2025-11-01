package in.etuwa.app.ui.hostel.gcekhostel.registration.newregistration;

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
import in.etuwa.app.databinding.DialogNewRegistrationBinding;
import in.etuwa.app.helper.SemesterSpinnerAdapter;
import in.etuwa.app.ui.attendance.bydaynew.attendaceday.AttendanceDayDialogKt;
import in.etuwa.app.ui.base.BaseDialog;
import in.etuwa.app.ui.hostel.gcekhostel.registration.RegistrationFragment;
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

/* compiled from: NewRegistrationDialog.kt */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 D2\u00020\u0001:\u0002DEB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010'\u001a\u00020(H\u0014J\b\u0010)\u001a\u00020(H\u0002J\b\u0010*\u001a\u00020(H\u0002J\b\u0010+\u001a\u00020(H\u0002J\b\u0010,\u001a\u00020(H\u0002J\"\u0010-\u001a\u00020(2\u0006\u0010.\u001a\u00020\u00152\u0006\u0010/\u001a\u00020\u00152\b\u00100\u001a\u0004\u0018\u000101H\u0016J\u0012\u00102\u001a\u00020(2\b\u00103\u001a\u0004\u0018\u000104H\u0016J&\u00105\u001a\u0004\u0018\u0001062\u0006\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010:2\b\u00103\u001a\u0004\u0018\u000104H\u0016J\b\u0010;\u001a\u00020(H\u0016J\b\u0010<\u001a\u00020(H\u0016J\u001a\u0010=\u001a\u00020(2\u0006\u0010>\u001a\u0002062\b\u00103\u001a\u0004\u0018\u000104H\u0016J\u000e\u0010?\u001a\u00020(2\u0006\u0010@\u001a\u00020AJ\b\u0010B\u001a\u00020(H\u0015J\b\u0010C\u001a\u00020(H\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0011\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0011\u001a\u0004\b\u001f\u0010 R\u001b\u0010\"\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u0011\u001a\u0004\b$\u0010%¨\u0006F"}, d2 = {"Lin/etuwa/app/ui/hostel/gcekhostel/registration/newregistration/NewRegistrationDialog;", "Lin/etuwa/app/ui/base/BaseDialog;", "()V", "_binding", "Lin/etuwa/app/databinding/DialogNewRegistrationBinding;", "binding", "getBinding", "()Lin/etuwa/app/databinding/DialogNewRegistrationBinding;", "category", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/hostel/gcekhostel/registration/newregistration/NewRegistrationDialog$NewRegistrationListener;", "newRegistrationViewModel", "Lin/etuwa/app/ui/hostel/gcekhostel/registration/newregistration/NewRegistrationViewModel;", "getNewRegistrationViewModel", "()Lin/etuwa/app/ui/hostel/gcekhostel/registration/newregistration/NewRegistrationViewModel;", "newRegistrationViewModel$delegate", "Lkotlin/Lazy;", "pickFile", "Ljava/io/File;", "pos", "", "reAdmission", AttendanceDayDialogKt.ARG_SEM, "spinnerAdapter", "Lin/etuwa/app/ui/hostel/gcekhostel/registration/newregistration/CategorySpinnerAdapter;", "getSpinnerAdapter", "()Lin/etuwa/app/ui/hostel/gcekhostel/registration/newregistration/CategorySpinnerAdapter;", "spinnerAdapter$delegate", "spinnerAdapter2", "Lin/etuwa/app/helper/SemesterSpinnerAdapter;", "getSpinnerAdapter2", "()Lin/etuwa/app/helper/SemesterSpinnerAdapter;", "spinnerAdapter2$delegate", "spinnerAdapter3", "Lin/etuwa/app/ui/hostel/gcekhostel/registration/newregistration/ReAdmissionSpinnerAdapter;", "getSpinnerAdapter3", "()Lin/etuwa/app/ui/hostel/gcekhostel/registration/newregistration/ReAdmissionSpinnerAdapter;", "spinnerAdapter3$delegate", "hideProgress", "", "listenProgressResponse", "listenResponse", "listenSemResponse", "listenSpinnerResponse", "onActivityResult", "requestCode", "resultCode", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDetach", "onViewCreated", SvgConstants.Tags.VIEW, "setCallBack", "context", "Lin/etuwa/app/ui/hostel/gcekhostel/registration/RegistrationFragment;", "setUp", "showProgress", "Companion", "NewRegistrationListener", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NewRegistrationDialog extends BaseDialog {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private DialogNewRegistrationBinding _binding;
    private String category;
    private NewRegistrationListener listener;

    /* renamed from: newRegistrationViewModel$delegate, reason: from kotlin metadata */
    private final Lazy newRegistrationViewModel;
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

    /* compiled from: NewRegistrationDialog.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lin/etuwa/app/ui/hostel/gcekhostel/registration/newregistration/NewRegistrationDialog$NewRegistrationListener;", "", "onDismiss", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface NewRegistrationListener {
        void onDismiss();
    }

    /* compiled from: NewRegistrationDialog.kt */
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
    public static final NewRegistrationDialog newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void showProgress() {
    }

    public NewRegistrationDialog() {
        final NewRegistrationDialog newRegistrationDialog = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.newregistration.NewRegistrationDialog$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(newRegistrationDialog);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.newRegistrationViewModel = FragmentViewModelLazyKt.createViewModelLazy(newRegistrationDialog, Reflection.getOrCreateKotlinClass(NewRegistrationViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.newregistration.NewRegistrationDialog$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.newregistration.NewRegistrationDialog$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(NewRegistrationViewModel.class), qualifier, b, null, koinScope);
            }
        });
        this.category = "";
        this.semester = "";
        this.reAdmission = "";
        this.pos = 1;
        final NewRegistrationDialog newRegistrationDialog2 = this;
        final Function0<ParametersHolder> function02 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.newregistration.NewRegistrationDialog$spinnerAdapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(NewRegistrationDialog.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        this.spinnerAdapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<CategorySpinnerAdapter>() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.newregistration.NewRegistrationDialog$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.hostel.gcekhostel.registration.newregistration.CategorySpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final CategorySpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = newRegistrationDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(CategorySpinnerAdapter.class), b2, function02);
            }
        });
        final Function0<ParametersHolder> function03 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.newregistration.NewRegistrationDialog$spinnerAdapter2$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(NewRegistrationDialog.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b3 = 0 == true ? 1 : 0;
        this.spinnerAdapter2 = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<SemesterSpinnerAdapter>() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.newregistration.NewRegistrationDialog$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.helper.SemesterSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SemesterSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = newRegistrationDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SemesterSpinnerAdapter.class), b3, function03);
            }
        });
        final Function0<ParametersHolder> function04 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.newregistration.NewRegistrationDialog$spinnerAdapter3$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(NewRegistrationDialog.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode3 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        this.spinnerAdapter3 = LazyKt.lazy(lazyThreadSafetyMode3, (Function0) new Function0<ReAdmissionSpinnerAdapter>() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.newregistration.NewRegistrationDialog$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.hostel.gcekhostel.registration.newregistration.ReAdmissionSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final ReAdmissionSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = newRegistrationDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(ReAdmissionSpinnerAdapter.class), b4, function04);
            }
        });
    }

    private final NewRegistrationViewModel getNewRegistrationViewModel() {
        return (NewRegistrationViewModel) this.newRegistrationViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getBinding, reason: from getter */
    public final DialogNewRegistrationBinding get_binding() {
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

    /* compiled from: NewRegistrationDialog.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/hostel/gcekhostel/registration/newregistration/NewRegistrationDialog$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/hostel/gcekhostel/registration/newregistration/NewRegistrationDialog;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final NewRegistrationDialog newInstance() {
            NewRegistrationDialog newRegistrationDialog = new NewRegistrationDialog();
            newRegistrationDialog.setArguments(new Bundle());
            return newRegistrationDialog;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getArguments();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = DialogNewRegistrationBinding.inflate(inflater, container, false);
        DialogNewRegistrationBinding dialogNewRegistrationBinding = get_binding();
        if (dialogNewRegistrationBinding != null) {
            dialogNewRegistrationBinding.setNewRegistrationViewModel(getNewRegistrationViewModel());
        }
        DialogNewRegistrationBinding dialogNewRegistrationBinding2 = get_binding();
        if (dialogNewRegistrationBinding2 != null) {
            dialogNewRegistrationBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        DialogNewRegistrationBinding dialogNewRegistrationBinding3 = get_binding();
        if (dialogNewRegistrationBinding3 != null) {
            return dialogNewRegistrationBinding3.getRoot();
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
        DialogNewRegistrationBinding dialogNewRegistrationBinding = get_binding();
        Spinner spinner = dialogNewRegistrationBinding != null ? dialogNewRegistrationBinding.spinnerCatogory : null;
        if (spinner != null) {
            spinner.setAdapter((SpinnerAdapter) getSpinnerAdapter());
        }
        DialogNewRegistrationBinding dialogNewRegistrationBinding2 = get_binding();
        Spinner spinner2 = dialogNewRegistrationBinding2 != null ? dialogNewRegistrationBinding2.spinnerSemesterApplied : null;
        if (spinner2 != null) {
            spinner2.setAdapter((SpinnerAdapter) getSpinnerAdapter2());
        }
        DialogNewRegistrationBinding dialogNewRegistrationBinding3 = get_binding();
        Spinner spinner3 = dialogNewRegistrationBinding3 != null ? dialogNewRegistrationBinding3.spinnerReadmission : null;
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
        DialogNewRegistrationBinding dialogNewRegistrationBinding4 = get_binding();
        Spinner spinner4 = dialogNewRegistrationBinding4 != null ? dialogNewRegistrationBinding4.spinnerCatogory : null;
        if (spinner4 != null) {
            spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.newregistration.NewRegistrationDialog$setUp$1
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    CategorySpinnerAdapter spinnerAdapter;
                    NewRegistrationDialog newRegistrationDialog = NewRegistrationDialog.this;
                    spinnerAdapter = newRegistrationDialog.getSpinnerAdapter();
                    newRegistrationDialog.category = String.valueOf(spinnerAdapter.getType(position).getId());
                }
            });
        }
        DialogNewRegistrationBinding dialogNewRegistrationBinding5 = get_binding();
        Spinner spinner5 = dialogNewRegistrationBinding5 != null ? dialogNewRegistrationBinding5.spinnerSemesterApplied : null;
        if (spinner5 != null) {
            spinner5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.newregistration.NewRegistrationDialog$setUp$2
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    SemesterSpinnerAdapter spinnerAdapter2;
                    NewRegistrationDialog newRegistrationDialog = NewRegistrationDialog.this;
                    spinnerAdapter2 = newRegistrationDialog.getSpinnerAdapter2();
                    newRegistrationDialog.semester = spinnerAdapter2.getSemester(position).getId();
                }
            });
        }
        DialogNewRegistrationBinding dialogNewRegistrationBinding6 = get_binding();
        Spinner spinner6 = dialogNewRegistrationBinding6 != null ? dialogNewRegistrationBinding6.spinnerReadmission : null;
        if (spinner6 != null) {
            spinner6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.newregistration.NewRegistrationDialog$setUp$3
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    ReAdmissionSpinnerAdapter spinnerAdapter32;
                    NewRegistrationDialog newRegistrationDialog = NewRegistrationDialog.this;
                    spinnerAdapter32 = newRegistrationDialog.getSpinnerAdapter3();
                    newRegistrationDialog.reAdmission = spinnerAdapter32.getSemester(position);
                    NewRegistrationDialog.this.pos = position + 1;
                }
            });
        }
        DialogNewRegistrationBinding dialogNewRegistrationBinding7 = get_binding();
        if (dialogNewRegistrationBinding7 != null && (textView2 = dialogNewRegistrationBinding7.completionSelect) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.newregistration.NewRegistrationDialog$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NewRegistrationDialog.setUp$lambda$2(NewRegistrationDialog.this, view);
                }
            });
        }
        DialogNewRegistrationBinding dialogNewRegistrationBinding8 = get_binding();
        if (dialogNewRegistrationBinding8 == null || (textView = dialogNewRegistrationBinding8.registerBtn) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.newregistration.NewRegistrationDialog$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NewRegistrationDialog.setUp$lambda$3(NewRegistrationDialog.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$2(NewRegistrationDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", false);
        intent.setType("*/*");
        this$0.startActivityForResult(Intent.createChooser(intent, "Select a file"), 111);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$3(NewRegistrationDialog this$0, View view) {
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
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        File file3 = this$0.pickFile;
        if (file3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pickFile");
            file3 = null;
        }
        System.out.println((Object) ("================" + file3 + "=================="));
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
                    DialogNewRegistrationBinding dialogNewRegistrationBinding = this$0.get_binding();
                    if (Intrinsics.areEqual(String.valueOf((dialogNewRegistrationBinding == null || (textInputEditText10 = dialogNewRegistrationBinding.etAnnualIncome) == null) ? null : textInputEditText10.getText()), "")) {
                        DialogNewRegistrationBinding dialogNewRegistrationBinding2 = this$0.get_binding();
                        if (dialogNewRegistrationBinding2 == null || (textView4 = dialogNewRegistrationBinding2.completionSelect) == null) {
                            return;
                        }
                        ToastExtKt.showInfoToast(textView4, "Annual Income Cannot be empty");
                        return;
                    }
                    DialogNewRegistrationBinding dialogNewRegistrationBinding3 = this$0.get_binding();
                    if (Intrinsics.areEqual(String.valueOf((dialogNewRegistrationBinding3 == null || (textInputEditText9 = dialogNewRegistrationBinding3.etDistance) == null) ? null : textInputEditText9.getText()), "")) {
                        DialogNewRegistrationBinding dialogNewRegistrationBinding4 = this$0.get_binding();
                        if (dialogNewRegistrationBinding4 == null || (textView3 = dialogNewRegistrationBinding4.completionSelect) == null) {
                            return;
                        }
                        ToastExtKt.showInfoToast(textView3, "Distance cannot be empty");
                        return;
                    }
                    NewRegistrationViewModel newRegistrationViewModel = this$0.getNewRegistrationViewModel();
                    String str = this$0.reAdmission;
                    String str2 = this$0.category;
                    DialogNewRegistrationBinding dialogNewRegistrationBinding5 = this$0.get_binding();
                    String valueOf = String.valueOf((dialogNewRegistrationBinding5 == null || (textInputEditText8 = dialogNewRegistrationBinding5.etNameAddress) == null) ? null : textInputEditText8.getText());
                    DialogNewRegistrationBinding dialogNewRegistrationBinding6 = this$0.get_binding();
                    String valueOf2 = String.valueOf((dialogNewRegistrationBinding6 == null || (textInputEditText7 = dialogNewRegistrationBinding6.etPhone) == null) ? null : textInputEditText7.getText());
                    DialogNewRegistrationBinding dialogNewRegistrationBinding7 = this$0.get_binding();
                    String valueOf3 = String.valueOf((dialogNewRegistrationBinding7 == null || (textInputEditText6 = dialogNewRegistrationBinding7.etAnnualIncome) == null) ? null : textInputEditText6.getText());
                    DialogNewRegistrationBinding dialogNewRegistrationBinding8 = this$0.get_binding();
                    String valueOf4 = String.valueOf((dialogNewRegistrationBinding8 == null || (textInputEditText5 = dialogNewRegistrationBinding8.etDistance) == null) ? null : textInputEditText5.getText());
                    String str3 = this$0.semester;
                    File file6 = this$0.pickFile;
                    if (file6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("pickFile");
                        file2 = null;
                    } else {
                        file2 = file6;
                    }
                    newRegistrationViewModel.newHostelRegistrationApiCall(str, str2, valueOf, valueOf2, valueOf3, valueOf4, str3, file2);
                    DialogNewRegistrationBinding dialogNewRegistrationBinding9 = this$0.get_binding();
                    LinearLayout linearLayout = dialogNewRegistrationBinding9 != null ? dialogNewRegistrationBinding9.completionCard : null;
                    if (linearLayout != null) {
                        linearLayout.setVisibility(8);
                    }
                    DialogNewRegistrationBinding dialogNewRegistrationBinding10 = this$0.get_binding();
                    CardView cardView = dialogNewRegistrationBinding10 != null ? dialogNewRegistrationBinding10.progressView : null;
                    if (cardView == null) {
                        return;
                    }
                    cardView.setVisibility(0);
                    return;
                }
                DialogNewRegistrationBinding dialogNewRegistrationBinding11 = this$0.get_binding();
                if (dialogNewRegistrationBinding11 == null || (textView2 = dialogNewRegistrationBinding11.completionSelect) == null) {
                    return;
                }
                ToastExtKt.showInfoToast(textView2, "File Size Limit Is 500KB");
                return;
            }
            DialogNewRegistrationBinding dialogNewRegistrationBinding12 = this$0.get_binding();
            if (dialogNewRegistrationBinding12 == null || (textView = dialogNewRegistrationBinding12.completionSelect) == null) {
                return;
            }
            ToastExtKt.showInfoToast(textView, "Please Select A File");
        } catch (Exception unused) {
            NewRegistrationViewModel newRegistrationViewModel2 = this$0.getNewRegistrationViewModel();
            String str4 = this$0.reAdmission;
            String str5 = this$0.category;
            DialogNewRegistrationBinding dialogNewRegistrationBinding13 = this$0.get_binding();
            String valueOf5 = String.valueOf((dialogNewRegistrationBinding13 == null || (textInputEditText4 = dialogNewRegistrationBinding13.etNameAddress) == null) ? null : textInputEditText4.getText());
            DialogNewRegistrationBinding dialogNewRegistrationBinding14 = this$0.get_binding();
            String valueOf6 = String.valueOf((dialogNewRegistrationBinding14 == null || (textInputEditText3 = dialogNewRegistrationBinding14.etPhone) == null) ? null : textInputEditText3.getText());
            DialogNewRegistrationBinding dialogNewRegistrationBinding15 = this$0.get_binding();
            String valueOf7 = String.valueOf((dialogNewRegistrationBinding15 == null || (textInputEditText2 = dialogNewRegistrationBinding15.etAnnualIncome) == null) ? null : textInputEditText2.getText());
            DialogNewRegistrationBinding dialogNewRegistrationBinding16 = this$0.get_binding();
            String valueOf8 = String.valueOf((dialogNewRegistrationBinding16 == null || (textInputEditText = dialogNewRegistrationBinding16.etDistance) == null) ? null : textInputEditText.getText());
            String str6 = this$0.semester;
            File file7 = this$0.pickFile;
            if (file7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pickFile");
                file = null;
            } else {
                file = file7;
            }
            newRegistrationViewModel2.newHostelRegistrationApiCall(str4, str5, valueOf5, valueOf6, valueOf7, valueOf8, str6, file);
        }
    }

    private final void listenSpinnerResponse() {
        getNewRegistrationViewModel().getResponse().observe(getViewLifecycleOwner(), new NewRegistrationDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends CategoryTypeResponse>, Unit>() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.newregistration.NewRegistrationDialog$listenSpinnerResponse$1

            /* compiled from: NewRegistrationDialog.kt */
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
                DialogNewRegistrationBinding dialogNewRegistrationBinding;
                Spinner spinner;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i == 1) {
                    NewRegistrationDialog.this.hideProgress();
                    CategoryTypeResponse data = resource.getData();
                    if (data != null) {
                        try {
                            spinnerAdapter = NewRegistrationDialog.this.getSpinnerAdapter();
                            spinnerAdapter.addItems(data.getCategory());
                            return;
                        } catch (NullPointerException unused) {
                            return;
                        }
                    }
                    return;
                }
                if (i == 2) {
                    NewRegistrationDialog.this.showProgress();
                    return;
                }
                if (i == 3) {
                    NewRegistrationDialog.this.hideProgress();
                    return;
                }
                if (i != 4) {
                    return;
                }
                NewRegistrationDialog.this.hideProgress();
                dialogNewRegistrationBinding = NewRegistrationDialog.this.get_binding();
                if (dialogNewRegistrationBinding == null || (spinner = dialogNewRegistrationBinding.spinnerCatogory) == null) {
                    return;
                }
                String message = resource.getMessage();
                Intrinsics.checkNotNull(message);
                ToastExtKt.showErrorToast(spinner, message);
            }
        }));
    }

    private final void listenSemResponse() {
        getNewRegistrationViewModel().getSemResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.newregistration.NewRegistrationDialog$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                NewRegistrationDialog.listenSemResponse$lambda$5(NewRegistrationDialog.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenSemResponse$lambda$5(NewRegistrationDialog this$0, Resource resource) {
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
        DialogNewRegistrationBinding dialogNewRegistrationBinding = this$0.get_binding();
        if (dialogNewRegistrationBinding == null || (spinner = dialogNewRegistrationBinding.spinnerSemesterApplied) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(spinner, message);
    }

    private final void listenResponse() {
        getNewRegistrationViewModel().getUploadResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.newregistration.NewRegistrationDialog$$ExternalSyntheticLambda3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                NewRegistrationDialog.listenResponse$lambda$7(NewRegistrationDialog.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$7(NewRegistrationDialog this$0, Resource resource) {
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
            DialogNewRegistrationBinding dialogNewRegistrationBinding = this$0.get_binding();
            if (dialogNewRegistrationBinding != null && (textView = dialogNewRegistrationBinding.completionFileName) != null) {
                String message = resource.getMessage();
                Intrinsics.checkNotNull(message);
                ToastExtKt.showErrorToast(textView, message);
            }
            this$0.dismiss();
            NewRegistrationListener newRegistrationListener = this$0.listener;
            if (newRegistrationListener != null) {
                newRegistrationListener.onDismiss();
                return;
            }
            return;
        }
        this$0.hideProgress();
        SuccessResponse successResponse = (SuccessResponse) resource.getData();
        if (successResponse != null) {
            if (successResponse.getSuccess()) {
                DialogNewRegistrationBinding dialogNewRegistrationBinding2 = this$0.get_binding();
                if (dialogNewRegistrationBinding2 != null && (completionFileName2 = dialogNewRegistrationBinding2.completionFileName) != null) {
                    Intrinsics.checkNotNullExpressionValue(completionFileName2, "completionFileName");
                    ToastExtKt.showSuccessToast(completionFileName2, successResponse.getMessage());
                }
                NewRegistrationListener newRegistrationListener2 = this$0.listener;
                if (newRegistrationListener2 != null) {
                    newRegistrationListener2.onDismiss();
                }
                this$0.dismiss();
                return;
            }
            DialogNewRegistrationBinding dialogNewRegistrationBinding3 = this$0.get_binding();
            if (dialogNewRegistrationBinding3 != null && (completionFileName = dialogNewRegistrationBinding3.completionFileName) != null) {
                Intrinsics.checkNotNullExpressionValue(completionFileName, "completionFileName");
                ToastExtKt.showErrorToast(completionFileName, successResponse.getMessage());
            }
            NewRegistrationListener newRegistrationListener3 = this$0.listener;
            if (newRegistrationListener3 != null) {
                newRegistrationListener3.onDismiss();
            }
            this$0.dismiss();
        }
    }

    private final void listenProgressResponse() {
        getNewRegistrationViewModel().getProgressResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.newregistration.NewRegistrationDialog$$ExternalSyntheticLambda4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                NewRegistrationDialog.listenProgressResponse$lambda$9(NewRegistrationDialog.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenProgressResponse$lambda$9(NewRegistrationDialog this$0, Resource resource) {
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
            DialogNewRegistrationBinding dialogNewRegistrationBinding = this$0.get_binding();
            if (dialogNewRegistrationBinding == null || (textView = dialogNewRegistrationBinding.completionFileName) == null) {
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
            DialogNewRegistrationBinding dialogNewRegistrationBinding2 = this$0.get_binding();
            ProgressBar progressBar = dialogNewRegistrationBinding2 != null ? dialogNewRegistrationBinding2.uploadProgressbar : null;
            if (progressBar != null) {
                progressBar.setProgress((int) floatValue);
            }
            DialogNewRegistrationBinding dialogNewRegistrationBinding3 = this$0.get_binding();
            TextView textView2 = dialogNewRegistrationBinding3 != null ? dialogNewRegistrationBinding3.progressText : null;
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
                DialogNewRegistrationBinding dialogNewRegistrationBinding = get_binding();
                TextView textView = dialogNewRegistrationBinding != null ? dialogNewRegistrationBinding.completionFileName : null;
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