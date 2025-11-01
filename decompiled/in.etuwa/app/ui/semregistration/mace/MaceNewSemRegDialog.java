package in.etuwa.app.ui.semregistration.mace;

import android.content.ComponentCallbacks;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.Semester;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.semregistration.AcademicYearResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.DialogMaceSemRegBinding;
import in.etuwa.app.ui.base.BaseDialog;
import in.etuwa.app.ui.semregistration.sjcetpalai.PalaiSemesterRegFragment;
import in.etuwa.app.utils.AppConstant;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
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

/* compiled from: MaceNewSemRegDialog.kt */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 J2\u00020\u0001:\u0002IJB\u0005¢\u0006\u0002\u0010\u0002J\b\u00100\u001a\u000201H\u0014J\b\u00102\u001a\u000201H\u0002J\b\u00103\u001a\u000201H\u0002J\b\u00104\u001a\u000201H\u0002J&\u00105\u001a\u0004\u0018\u0001062\u0006\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010:2\b\u0010;\u001a\u0004\u0018\u00010<H\u0016J\b\u0010=\u001a\u000201H\u0016J\b\u0010>\u001a\u000201H\u0016J\u0010\u0010?\u001a\u0002012\u0006\u0010@\u001a\u00020AH\u0016J\u001a\u0010B\u001a\u0002012\u0006\u0010C\u001a\u0002062\b\u0010;\u001a\u0004\u0018\u00010<H\u0016J\u000e\u0010D\u001a\u0002012\u0006\u0010E\u001a\u00020FJ\b\u0010G\u001a\u000201H\u0014J\b\u0010H\u001a\u000201H\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001d\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u001c\u001a\u0004\b \u0010!R\u000e\u0010#\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010%\u001a\u00020&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u001c\u001a\u0004\b'\u0010(R\u001b\u0010*\u001a\u00020+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\u001c\u001a\u0004\b,\u0010-R\u000e\u0010/\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006K"}, d2 = {"Lin/etuwa/app/ui/semregistration/mace/MaceNewSemRegDialog;", "Lin/etuwa/app/ui/base/BaseDialog;", "()V", "_binding", "Lin/etuwa/app/databinding/DialogMaceSemRegBinding;", "back", "", "binding", "getBinding", "()Lin/etuwa/app/databinding/DialogMaceSemRegBinding;", "collegeLibrary", "deptLibrary", "examAttClicked", "", "feeConcession", "finalPage", "honor", "hostel", "id", "labOne", "labTwo", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/semregistration/mace/MaceNewSemRegDialog$AddCounsellingListener;", "maceNewSemRegViewModel", "Lin/etuwa/app/ui/semregistration/mace/MaceNewSemRegViewModel;", "getMaceNewSemRegViewModel", "()Lin/etuwa/app/ui/semregistration/mace/MaceNewSemRegViewModel;", "maceNewSemRegViewModel$delegate", "Lkotlin/Lazy;", "minor", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", "reg", "sem", "spinnerAdapter", "Lin/etuwa/app/ui/semregistration/mace/SemesterRegistrationSpinnerAdapter;", "getSpinnerAdapter", "()Lin/etuwa/app/ui/semregistration/mace/SemesterRegistrationSpinnerAdapter;", "spinnerAdapter$delegate", "spinnerYearList", "Lin/etuwa/app/ui/semregistration/mace/AcademicYearSpinnerAdapter;", "getSpinnerYearList", "()Lin/etuwa/app/ui/semregistration/mace/AcademicYearSpinnerAdapter;", "spinnerYearList$delegate", "year", "hideProgress", "", "listenRegisterResponse", "listenSemResponse", "listenSpinner", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onDetach", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onViewCreated", SvgConstants.Tags.VIEW, "setCallBack", "context", "Lin/etuwa/app/ui/semregistration/sjcetpalai/PalaiSemesterRegFragment;", "setUp", "showProgress", "AddCounsellingListener", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MaceNewSemRegDialog extends BaseDialog {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private DialogMaceSemRegBinding _binding;
    private String back;
    private String collegeLibrary;
    private String deptLibrary;
    private boolean examAttClicked;
    private String feeConcession;
    private boolean finalPage;
    private String honor;
    private String hostel;
    private String id;
    private String labOne;
    private String labTwo;
    private AddCounsellingListener listener;

    /* renamed from: maceNewSemRegViewModel$delegate, reason: from kotlin metadata */
    private final Lazy maceNewSemRegViewModel;
    private String minor;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;
    private String reg;
    private String sem;

    /* renamed from: spinnerAdapter$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdapter;

    /* renamed from: spinnerYearList$delegate, reason: from kotlin metadata */
    private final Lazy spinnerYearList;
    private String year;

    /* compiled from: MaceNewSemRegDialog.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lin/etuwa/app/ui/semregistration/mace/MaceNewSemRegDialog$AddCounsellingListener;", "", "dismiss", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface AddCounsellingListener {
        void dismiss();
    }

    @JvmStatic
    public static final MaceNewSemRegDialog newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void showProgress() {
    }

    public MaceNewSemRegDialog() {
        final MaceNewSemRegDialog maceNewSemRegDialog = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.semregistration.mace.MaceNewSemRegDialog$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(maceNewSemRegDialog);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.maceNewSemRegViewModel = FragmentViewModelLazyKt.createViewModelLazy(maceNewSemRegDialog, Reflection.getOrCreateKotlinClass(MaceNewSemRegViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.semregistration.mace.MaceNewSemRegDialog$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.semregistration.mace.MaceNewSemRegDialog$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(MaceNewSemRegViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final MaceNewSemRegDialog maceNewSemRegDialog2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.semregistration.mace.MaceNewSemRegDialog$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = maceNewSemRegDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b2, b3);
            }
        });
        this.sem = "";
        this.reg = "Yes";
        this.year = "";
        this.deptLibrary = "Yes";
        this.collegeLibrary = "Yes";
        this.labOne = "Yes";
        this.labTwo = "Yes";
        this.hostel = "Yes";
        this.back = "Yes";
        this.feeConcession = "Yes";
        this.honor = "Yes";
        this.minor = "Yes";
        final Function0<ParametersHolder> function02 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.semregistration.mace.MaceNewSemRegDialog$spinnerYearList$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(MaceNewSemRegDialog.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        this.spinnerYearList = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<AcademicYearSpinnerAdapter>() { // from class: in.etuwa.app.ui.semregistration.mace.MaceNewSemRegDialog$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.semregistration.mace.AcademicYearSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final AcademicYearSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = maceNewSemRegDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(AcademicYearSpinnerAdapter.class), b4, function02);
            }
        });
        final Function0<ParametersHolder> function03 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.semregistration.mace.MaceNewSemRegDialog$spinnerAdapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(MaceNewSemRegDialog.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode3 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b5 = 0 == true ? 1 : 0;
        this.spinnerAdapter = LazyKt.lazy(lazyThreadSafetyMode3, (Function0) new Function0<SemesterRegistrationSpinnerAdapter>() { // from class: in.etuwa.app.ui.semregistration.mace.MaceNewSemRegDialog$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.semregistration.mace.SemesterRegistrationSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SemesterRegistrationSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = maceNewSemRegDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SemesterRegistrationSpinnerAdapter.class), b5, function03);
            }
        });
    }

    private final MaceNewSemRegViewModel getMaceNewSemRegViewModel() {
        return (MaceNewSemRegViewModel) this.maceNewSemRegViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getBinding, reason: from getter */
    public final DialogMaceSemRegBinding get_binding() {
        return this._binding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AcademicYearSpinnerAdapter getSpinnerYearList() {
        return (AcademicYearSpinnerAdapter) this.spinnerYearList.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SemesterRegistrationSpinnerAdapter getSpinnerAdapter() {
        return (SemesterRegistrationSpinnerAdapter) this.spinnerAdapter.getValue();
    }

    /* compiled from: MaceNewSemRegDialog.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/semregistration/mace/MaceNewSemRegDialog$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/semregistration/mace/MaceNewSemRegDialog;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final MaceNewSemRegDialog newInstance() {
            return new MaceNewSemRegDialog();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = DialogMaceSemRegBinding.inflate(inflater, container, false);
        DialogMaceSemRegBinding dialogMaceSemRegBinding = get_binding();
        if (dialogMaceSemRegBinding != null) {
            dialogMaceSemRegBinding.setMaceNewSemRegViewModel(getMaceNewSemRegViewModel());
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding2 = get_binding();
        if (dialogMaceSemRegBinding2 != null) {
            dialogMaceSemRegBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding3 = get_binding();
        if (dialogMaceSemRegBinding3 != null) {
            return dialogMaceSemRegBinding3.getRoot();
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
        TextInputEditText textInputEditText;
        RadioGroup radioGroup;
        RadioGroup radioGroup2;
        RadioGroup radioGroup3;
        RadioGroup radioGroup4;
        RadioGroup radioGroup5;
        RadioGroup radioGroup6;
        RadioGroup radioGroup7;
        RadioGroup radioGroup8;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        TextView textView6;
        TextView textView7;
        TextView textView8;
        listenSpinner();
        listenSemResponse();
        listenRegisterResponse();
        getMaceNewSemRegViewModel().getYearList();
        getMaceNewSemRegViewModel().getSemester();
        DialogMaceSemRegBinding dialogMaceSemRegBinding = get_binding();
        Spinner spinner = dialogMaceSemRegBinding != null ? dialogMaceSemRegBinding.spinnerAcademicYear : null;
        if (spinner != null) {
            spinner.setAdapter((SpinnerAdapter) getSpinnerYearList());
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding2 = get_binding();
        Spinner spinner2 = dialogMaceSemRegBinding2 != null ? dialogMaceSemRegBinding2.spinnerSemesterLastAttended : null;
        if (spinner2 != null) {
            spinner2.setAdapter((SpinnerAdapter) getSpinnerAdapter());
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding3 = get_binding();
        if (dialogMaceSemRegBinding3 != null && (textView8 = dialogMaceSemRegBinding3.nextOne) != null) {
            textView8.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.mace.MaceNewSemRegDialog$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MaceNewSemRegDialog.setUp$lambda$0(MaceNewSemRegDialog.this, view);
                }
            });
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding4 = get_binding();
        if (dialogMaceSemRegBinding4 != null && (textView7 = dialogMaceSemRegBinding4.backTwo) != null) {
            textView7.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.mace.MaceNewSemRegDialog$$ExternalSyntheticLambda15
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MaceNewSemRegDialog.setUp$lambda$1(MaceNewSemRegDialog.this, view);
                }
            });
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding5 = get_binding();
        if (dialogMaceSemRegBinding5 != null && (textView6 = dialogMaceSemRegBinding5.backThree) != null) {
            textView6.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.mace.MaceNewSemRegDialog$$ExternalSyntheticLambda16
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MaceNewSemRegDialog.setUp$lambda$2(MaceNewSemRegDialog.this, view);
                }
            });
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding6 = get_binding();
        if (dialogMaceSemRegBinding6 != null && (textView5 = dialogMaceSemRegBinding6.nextTwo) != null) {
            textView5.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.mace.MaceNewSemRegDialog$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MaceNewSemRegDialog.setUp$lambda$3(MaceNewSemRegDialog.this, view);
                }
            });
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding7 = get_binding();
        if (dialogMaceSemRegBinding7 != null && (textView4 = dialogMaceSemRegBinding7.nextThree) != null) {
            textView4.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.mace.MaceNewSemRegDialog$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MaceNewSemRegDialog.setUp$lambda$4(MaceNewSemRegDialog.this, view);
                }
            });
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding8 = get_binding();
        if (dialogMaceSemRegBinding8 != null && (textView3 = dialogMaceSemRegBinding8.backFour) != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.mace.MaceNewSemRegDialog$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MaceNewSemRegDialog.setUp$lambda$5(MaceNewSemRegDialog.this, view);
                }
            });
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding9 = get_binding();
        if (dialogMaceSemRegBinding9 != null && (textView2 = dialogMaceSemRegBinding9.nextFour) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.mace.MaceNewSemRegDialog$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MaceNewSemRegDialog.setUp$lambda$6(MaceNewSemRegDialog.this, view);
                }
            });
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding10 = get_binding();
        if (dialogMaceSemRegBinding10 != null && (radioGroup8 = dialogMaceSemRegBinding10.examGroup) != null) {
            radioGroup8.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.etuwa.app.ui.semregistration.mace.MaceNewSemRegDialog$$ExternalSyntheticLambda5
                @Override // android.widget.RadioGroup.OnCheckedChangeListener
                public final void onCheckedChanged(RadioGroup radioGroup9, int i) {
                    MaceNewSemRegDialog.setUp$lambda$7(MaceNewSemRegDialog.this, radioGroup9, i);
                }
            });
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding11 = get_binding();
        if (dialogMaceSemRegBinding11 != null && (radioGroup7 = dialogMaceSemRegBinding11.backGroup) != null) {
            radioGroup7.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.etuwa.app.ui.semregistration.mace.MaceNewSemRegDialog$$ExternalSyntheticLambda6
                @Override // android.widget.RadioGroup.OnCheckedChangeListener
                public final void onCheckedChanged(RadioGroup radioGroup9, int i) {
                    MaceNewSemRegDialog.setUp$lambda$8(MaceNewSemRegDialog.this, radioGroup9, i);
                }
            });
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding12 = get_binding();
        if (dialogMaceSemRegBinding12 != null && (radioGroup6 = dialogMaceSemRegBinding12.libraryDue) != null) {
            radioGroup6.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.etuwa.app.ui.semregistration.mace.MaceNewSemRegDialog$$ExternalSyntheticLambda7
                @Override // android.widget.RadioGroup.OnCheckedChangeListener
                public final void onCheckedChanged(RadioGroup radioGroup9, int i) {
                    MaceNewSemRegDialog.setUp$lambda$9(MaceNewSemRegDialog.this, radioGroup9, i);
                }
            });
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding13 = get_binding();
        if (dialogMaceSemRegBinding13 != null && (radioGroup5 = dialogMaceSemRegBinding13.collegeLibraryGroup) != null) {
            radioGroup5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.etuwa.app.ui.semregistration.mace.MaceNewSemRegDialog$$ExternalSyntheticLambda8
                @Override // android.widget.RadioGroup.OnCheckedChangeListener
                public final void onCheckedChanged(RadioGroup radioGroup9, int i) {
                    MaceNewSemRegDialog.setUp$lambda$10(MaceNewSemRegDialog.this, radioGroup9, i);
                }
            });
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding14 = get_binding();
        if (dialogMaceSemRegBinding14 != null && (radioGroup4 = dialogMaceSemRegBinding14.labOneGroup) != null) {
            radioGroup4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.etuwa.app.ui.semregistration.mace.MaceNewSemRegDialog$$ExternalSyntheticLambda9
                @Override // android.widget.RadioGroup.OnCheckedChangeListener
                public final void onCheckedChanged(RadioGroup radioGroup9, int i) {
                    MaceNewSemRegDialog.setUp$lambda$11(MaceNewSemRegDialog.this, radioGroup9, i);
                }
            });
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding15 = get_binding();
        if (dialogMaceSemRegBinding15 != null && (radioGroup3 = dialogMaceSemRegBinding15.labTwoGroup) != null) {
            radioGroup3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.etuwa.app.ui.semregistration.mace.MaceNewSemRegDialog$$ExternalSyntheticLambda10
                @Override // android.widget.RadioGroup.OnCheckedChangeListener
                public final void onCheckedChanged(RadioGroup radioGroup9, int i) {
                    MaceNewSemRegDialog.setUp$lambda$12(MaceNewSemRegDialog.this, radioGroup9, i);
                }
            });
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding16 = get_binding();
        if (dialogMaceSemRegBinding16 != null && (radioGroup2 = dialogMaceSemRegBinding16.honourGroup) != null) {
            radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.etuwa.app.ui.semregistration.mace.MaceNewSemRegDialog$$ExternalSyntheticLambda11
                @Override // android.widget.RadioGroup.OnCheckedChangeListener
                public final void onCheckedChanged(RadioGroup radioGroup9, int i) {
                    MaceNewSemRegDialog.setUp$lambda$13(MaceNewSemRegDialog.this, radioGroup9, i);
                }
            });
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding17 = get_binding();
        if (dialogMaceSemRegBinding17 != null && (radioGroup = dialogMaceSemRegBinding17.minorGroup) != null) {
            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.etuwa.app.ui.semregistration.mace.MaceNewSemRegDialog$$ExternalSyntheticLambda12
                @Override // android.widget.RadioGroup.OnCheckedChangeListener
                public final void onCheckedChanged(RadioGroup radioGroup9, int i) {
                    MaceNewSemRegDialog.setUp$lambda$14(MaceNewSemRegDialog.this, radioGroup9, i);
                }
            });
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding18 = get_binding();
        if (dialogMaceSemRegBinding18 != null && (textInputEditText = dialogMaceSemRegBinding18.etLabTwo) != null) {
            textInputEditText.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.mace.MaceNewSemRegDialog$$ExternalSyntheticLambda13
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MaceNewSemRegDialog.setUp$lambda$15(MaceNewSemRegDialog.this, view);
                }
            });
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding19 = get_binding();
        Spinner spinner3 = dialogMaceSemRegBinding19 != null ? dialogMaceSemRegBinding19.spinnerSemesterLastAttended : null;
        if (spinner3 != null) {
            spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.semregistration.mace.MaceNewSemRegDialog$setUp$17
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    SemesterRegistrationSpinnerAdapter spinnerAdapter;
                    MaceNewSemRegDialog maceNewSemRegDialog = MaceNewSemRegDialog.this;
                    spinnerAdapter = maceNewSemRegDialog.getSpinnerAdapter();
                    maceNewSemRegDialog.sem = spinnerAdapter.getSemester(position).getId();
                }
            });
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding20 = get_binding();
        Spinner spinner4 = dialogMaceSemRegBinding20 != null ? dialogMaceSemRegBinding20.spinnerAcademicYear : null;
        if (spinner4 != null) {
            spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.semregistration.mace.MaceNewSemRegDialog$setUp$18
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    AcademicYearSpinnerAdapter spinnerYearList;
                    MaceNewSemRegDialog maceNewSemRegDialog = MaceNewSemRegDialog.this;
                    spinnerYearList = maceNewSemRegDialog.getSpinnerYearList();
                    maceNewSemRegDialog.year = String.valueOf(spinnerYearList.getType(position).getId());
                }
            });
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding21 = get_binding();
        if (dialogMaceSemRegBinding21 == null || (textView = dialogMaceSemRegBinding21.registerBtn) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.mace.MaceNewSemRegDialog$$ExternalSyntheticLambda14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MaceNewSemRegDialog.setUp$lambda$16(MaceNewSemRegDialog.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$0(MaceNewSemRegDialog this$0, View view) {
        TextView textView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DialogMaceSemRegBinding dialogMaceSemRegBinding = this$0.get_binding();
        LinearLayout linearLayout = dialogMaceSemRegBinding != null ? dialogMaceSemRegBinding.pageOne : null;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding2 = this$0.get_binding();
        LinearLayout linearLayout2 = dialogMaceSemRegBinding2 != null ? dialogMaceSemRegBinding2.pageTwo : null;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(0);
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding3 = this$0.get_binding();
        LinearLayout linearLayout3 = dialogMaceSemRegBinding3 != null ? dialogMaceSemRegBinding3.pageThree : null;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(8);
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding4 = this$0.get_binding();
        LinearLayout linearLayout4 = dialogMaceSemRegBinding4 != null ? dialogMaceSemRegBinding4.pageFour : null;
        if (linearLayout4 != null) {
            linearLayout4.setVisibility(8);
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding5 = this$0.get_binding();
        LinearLayout linearLayout5 = dialogMaceSemRegBinding5 != null ? dialogMaceSemRegBinding5.personalDetailsLyt : null;
        if (linearLayout5 != null) {
            linearLayout5.setVisibility(8);
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding6 = this$0.get_binding();
        LinearLayout linearLayout6 = dialogMaceSemRegBinding6 != null ? dialogMaceSemRegBinding6.universityPreviousLayout : null;
        if (linearLayout6 != null) {
            linearLayout6.setVisibility(0);
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding7 = this$0.get_binding();
        LinearLayout linearLayout7 = dialogMaceSemRegBinding7 != null ? dialogMaceSemRegBinding7.honorMinorLt : null;
        if (linearLayout7 != null) {
            linearLayout7.setVisibility(8);
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding8 = this$0.get_binding();
        LinearLayout linearLayout8 = dialogMaceSemRegBinding8 != null ? dialogMaceSemRegBinding8.duesLt : null;
        if (linearLayout8 != null) {
            linearLayout8.setVisibility(8);
        }
        if (this$0.finalPage) {
            DialogMaceSemRegBinding dialogMaceSemRegBinding9 = this$0.get_binding();
            textView = dialogMaceSemRegBinding9 != null ? dialogMaceSemRegBinding9.registerBtn : null;
            if (textView == null) {
                return;
            }
            textView.setVisibility(0);
            return;
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding10 = this$0.get_binding();
        textView = dialogMaceSemRegBinding10 != null ? dialogMaceSemRegBinding10.registerBtn : null;
        if (textView == null) {
            return;
        }
        textView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(MaceNewSemRegDialog this$0, View view) {
        TextView textView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DialogMaceSemRegBinding dialogMaceSemRegBinding = this$0.get_binding();
        LinearLayout linearLayout = dialogMaceSemRegBinding != null ? dialogMaceSemRegBinding.pageOne : null;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding2 = this$0.get_binding();
        LinearLayout linearLayout2 = dialogMaceSemRegBinding2 != null ? dialogMaceSemRegBinding2.pageTwo : null;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding3 = this$0.get_binding();
        LinearLayout linearLayout3 = dialogMaceSemRegBinding3 != null ? dialogMaceSemRegBinding3.pageThree : null;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(8);
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding4 = this$0.get_binding();
        LinearLayout linearLayout4 = dialogMaceSemRegBinding4 != null ? dialogMaceSemRegBinding4.pageFour : null;
        if (linearLayout4 != null) {
            linearLayout4.setVisibility(8);
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding5 = this$0.get_binding();
        LinearLayout linearLayout5 = dialogMaceSemRegBinding5 != null ? dialogMaceSemRegBinding5.personalDetailsLyt : null;
        if (linearLayout5 != null) {
            linearLayout5.setVisibility(0);
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding6 = this$0.get_binding();
        LinearLayout linearLayout6 = dialogMaceSemRegBinding6 != null ? dialogMaceSemRegBinding6.universityPreviousLayout : null;
        if (linearLayout6 != null) {
            linearLayout6.setVisibility(8);
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding7 = this$0.get_binding();
        LinearLayout linearLayout7 = dialogMaceSemRegBinding7 != null ? dialogMaceSemRegBinding7.honorMinorLt : null;
        if (linearLayout7 != null) {
            linearLayout7.setVisibility(8);
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding8 = this$0.get_binding();
        LinearLayout linearLayout8 = dialogMaceSemRegBinding8 != null ? dialogMaceSemRegBinding8.duesLt : null;
        if (linearLayout8 != null) {
            linearLayout8.setVisibility(8);
        }
        if (this$0.finalPage) {
            DialogMaceSemRegBinding dialogMaceSemRegBinding9 = this$0.get_binding();
            textView = dialogMaceSemRegBinding9 != null ? dialogMaceSemRegBinding9.registerBtn : null;
            if (textView == null) {
                return;
            }
            textView.setVisibility(0);
            return;
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding10 = this$0.get_binding();
        textView = dialogMaceSemRegBinding10 != null ? dialogMaceSemRegBinding10.registerBtn : null;
        if (textView == null) {
            return;
        }
        textView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$2(MaceNewSemRegDialog this$0, View view) {
        TextView textView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DialogMaceSemRegBinding dialogMaceSemRegBinding = this$0.get_binding();
        LinearLayout linearLayout = dialogMaceSemRegBinding != null ? dialogMaceSemRegBinding.pageOne : null;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding2 = this$0.get_binding();
        LinearLayout linearLayout2 = dialogMaceSemRegBinding2 != null ? dialogMaceSemRegBinding2.pageTwo : null;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(0);
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding3 = this$0.get_binding();
        LinearLayout linearLayout3 = dialogMaceSemRegBinding3 != null ? dialogMaceSemRegBinding3.pageThree : null;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(8);
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding4 = this$0.get_binding();
        LinearLayout linearLayout4 = dialogMaceSemRegBinding4 != null ? dialogMaceSemRegBinding4.pageFour : null;
        if (linearLayout4 != null) {
            linearLayout4.setVisibility(8);
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding5 = this$0.get_binding();
        LinearLayout linearLayout5 = dialogMaceSemRegBinding5 != null ? dialogMaceSemRegBinding5.personalDetailsLyt : null;
        if (linearLayout5 != null) {
            linearLayout5.setVisibility(8);
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding6 = this$0.get_binding();
        LinearLayout linearLayout6 = dialogMaceSemRegBinding6 != null ? dialogMaceSemRegBinding6.universityPreviousLayout : null;
        if (linearLayout6 != null) {
            linearLayout6.setVisibility(0);
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding7 = this$0.get_binding();
        LinearLayout linearLayout7 = dialogMaceSemRegBinding7 != null ? dialogMaceSemRegBinding7.honorMinorLt : null;
        if (linearLayout7 != null) {
            linearLayout7.setVisibility(8);
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding8 = this$0.get_binding();
        LinearLayout linearLayout8 = dialogMaceSemRegBinding8 != null ? dialogMaceSemRegBinding8.duesLt : null;
        if (linearLayout8 != null) {
            linearLayout8.setVisibility(8);
        }
        if (this$0.finalPage) {
            DialogMaceSemRegBinding dialogMaceSemRegBinding9 = this$0.get_binding();
            textView = dialogMaceSemRegBinding9 != null ? dialogMaceSemRegBinding9.registerBtn : null;
            if (textView == null) {
                return;
            }
            textView.setVisibility(0);
            return;
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding10 = this$0.get_binding();
        textView = dialogMaceSemRegBinding10 != null ? dialogMaceSemRegBinding10.registerBtn : null;
        if (textView == null) {
            return;
        }
        textView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$3(MaceNewSemRegDialog this$0, View view) {
        TextView textView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DialogMaceSemRegBinding dialogMaceSemRegBinding = this$0.get_binding();
        LinearLayout linearLayout = dialogMaceSemRegBinding != null ? dialogMaceSemRegBinding.pageOne : null;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding2 = this$0.get_binding();
        LinearLayout linearLayout2 = dialogMaceSemRegBinding2 != null ? dialogMaceSemRegBinding2.pageTwo : null;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding3 = this$0.get_binding();
        LinearLayout linearLayout3 = dialogMaceSemRegBinding3 != null ? dialogMaceSemRegBinding3.pageThree : null;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(0);
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding4 = this$0.get_binding();
        LinearLayout linearLayout4 = dialogMaceSemRegBinding4 != null ? dialogMaceSemRegBinding4.pageFour : null;
        if (linearLayout4 != null) {
            linearLayout4.setVisibility(8);
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding5 = this$0.get_binding();
        LinearLayout linearLayout5 = dialogMaceSemRegBinding5 != null ? dialogMaceSemRegBinding5.personalDetailsLyt : null;
        if (linearLayout5 != null) {
            linearLayout5.setVisibility(8);
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding6 = this$0.get_binding();
        LinearLayout linearLayout6 = dialogMaceSemRegBinding6 != null ? dialogMaceSemRegBinding6.universityPreviousLayout : null;
        if (linearLayout6 != null) {
            linearLayout6.setVisibility(8);
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding7 = this$0.get_binding();
        LinearLayout linearLayout7 = dialogMaceSemRegBinding7 != null ? dialogMaceSemRegBinding7.honorMinorLt : null;
        if (linearLayout7 != null) {
            linearLayout7.setVisibility(0);
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding8 = this$0.get_binding();
        LinearLayout linearLayout8 = dialogMaceSemRegBinding8 != null ? dialogMaceSemRegBinding8.duesLt : null;
        if (linearLayout8 != null) {
            linearLayout8.setVisibility(8);
        }
        if (this$0.finalPage) {
            DialogMaceSemRegBinding dialogMaceSemRegBinding9 = this$0.get_binding();
            textView = dialogMaceSemRegBinding9 != null ? dialogMaceSemRegBinding9.registerBtn : null;
            if (textView == null) {
                return;
            }
            textView.setVisibility(0);
            return;
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding10 = this$0.get_binding();
        textView = dialogMaceSemRegBinding10 != null ? dialogMaceSemRegBinding10.registerBtn : null;
        if (textView == null) {
            return;
        }
        textView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$4(MaceNewSemRegDialog this$0, View view) {
        TextView textView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.finalPage = true;
        DialogMaceSemRegBinding dialogMaceSemRegBinding = this$0.get_binding();
        LinearLayout linearLayout = dialogMaceSemRegBinding != null ? dialogMaceSemRegBinding.pageOne : null;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding2 = this$0.get_binding();
        LinearLayout linearLayout2 = dialogMaceSemRegBinding2 != null ? dialogMaceSemRegBinding2.pageTwo : null;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding3 = this$0.get_binding();
        LinearLayout linearLayout3 = dialogMaceSemRegBinding3 != null ? dialogMaceSemRegBinding3.pageThree : null;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(8);
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding4 = this$0.get_binding();
        LinearLayout linearLayout4 = dialogMaceSemRegBinding4 != null ? dialogMaceSemRegBinding4.pageFour : null;
        if (linearLayout4 != null) {
            linearLayout4.setVisibility(0);
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding5 = this$0.get_binding();
        LinearLayout linearLayout5 = dialogMaceSemRegBinding5 != null ? dialogMaceSemRegBinding5.personalDetailsLyt : null;
        if (linearLayout5 != null) {
            linearLayout5.setVisibility(8);
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding6 = this$0.get_binding();
        LinearLayout linearLayout6 = dialogMaceSemRegBinding6 != null ? dialogMaceSemRegBinding6.universityPreviousLayout : null;
        if (linearLayout6 != null) {
            linearLayout6.setVisibility(8);
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding7 = this$0.get_binding();
        LinearLayout linearLayout7 = dialogMaceSemRegBinding7 != null ? dialogMaceSemRegBinding7.honorMinorLt : null;
        if (linearLayout7 != null) {
            linearLayout7.setVisibility(8);
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding8 = this$0.get_binding();
        LinearLayout linearLayout8 = dialogMaceSemRegBinding8 != null ? dialogMaceSemRegBinding8.duesLt : null;
        if (linearLayout8 != null) {
            linearLayout8.setVisibility(0);
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding9 = this$0.get_binding();
        TextView textView2 = dialogMaceSemRegBinding9 != null ? dialogMaceSemRegBinding9.registerBtn : null;
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
        if (this$0.finalPage) {
            DialogMaceSemRegBinding dialogMaceSemRegBinding10 = this$0.get_binding();
            textView = dialogMaceSemRegBinding10 != null ? dialogMaceSemRegBinding10.registerBtn : null;
            if (textView == null) {
                return;
            }
            textView.setVisibility(0);
            return;
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding11 = this$0.get_binding();
        textView = dialogMaceSemRegBinding11 != null ? dialogMaceSemRegBinding11.registerBtn : null;
        if (textView == null) {
            return;
        }
        textView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$5(MaceNewSemRegDialog this$0, View view) {
        TextView textView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DialogMaceSemRegBinding dialogMaceSemRegBinding = this$0.get_binding();
        LinearLayout linearLayout = dialogMaceSemRegBinding != null ? dialogMaceSemRegBinding.pageOne : null;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding2 = this$0.get_binding();
        LinearLayout linearLayout2 = dialogMaceSemRegBinding2 != null ? dialogMaceSemRegBinding2.pageTwo : null;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding3 = this$0.get_binding();
        LinearLayout linearLayout3 = dialogMaceSemRegBinding3 != null ? dialogMaceSemRegBinding3.pageThree : null;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(0);
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding4 = this$0.get_binding();
        LinearLayout linearLayout4 = dialogMaceSemRegBinding4 != null ? dialogMaceSemRegBinding4.pageFour : null;
        if (linearLayout4 != null) {
            linearLayout4.setVisibility(8);
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding5 = this$0.get_binding();
        LinearLayout linearLayout5 = dialogMaceSemRegBinding5 != null ? dialogMaceSemRegBinding5.personalDetailsLyt : null;
        if (linearLayout5 != null) {
            linearLayout5.setVisibility(8);
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding6 = this$0.get_binding();
        LinearLayout linearLayout6 = dialogMaceSemRegBinding6 != null ? dialogMaceSemRegBinding6.universityPreviousLayout : null;
        if (linearLayout6 != null) {
            linearLayout6.setVisibility(8);
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding7 = this$0.get_binding();
        LinearLayout linearLayout7 = dialogMaceSemRegBinding7 != null ? dialogMaceSemRegBinding7.honorMinorLt : null;
        if (linearLayout7 != null) {
            linearLayout7.setVisibility(0);
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding8 = this$0.get_binding();
        LinearLayout linearLayout8 = dialogMaceSemRegBinding8 != null ? dialogMaceSemRegBinding8.duesLt : null;
        if (linearLayout8 != null) {
            linearLayout8.setVisibility(8);
        }
        if (this$0.finalPage) {
            DialogMaceSemRegBinding dialogMaceSemRegBinding9 = this$0.get_binding();
            textView = dialogMaceSemRegBinding9 != null ? dialogMaceSemRegBinding9.registerBtn : null;
            if (textView == null) {
                return;
            }
            textView.setVisibility(0);
            return;
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding10 = this$0.get_binding();
        textView = dialogMaceSemRegBinding10 != null ? dialogMaceSemRegBinding10.registerBtn : null;
        if (textView == null) {
            return;
        }
        textView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$6(MaceNewSemRegDialog this$0, View view) {
        TextView textView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DialogMaceSemRegBinding dialogMaceSemRegBinding = this$0.get_binding();
        LinearLayout linearLayout = dialogMaceSemRegBinding != null ? dialogMaceSemRegBinding.pageOne : null;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding2 = this$0.get_binding();
        LinearLayout linearLayout2 = dialogMaceSemRegBinding2 != null ? dialogMaceSemRegBinding2.pageTwo : null;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding3 = this$0.get_binding();
        LinearLayout linearLayout3 = dialogMaceSemRegBinding3 != null ? dialogMaceSemRegBinding3.pageThree : null;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(8);
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding4 = this$0.get_binding();
        LinearLayout linearLayout4 = dialogMaceSemRegBinding4 != null ? dialogMaceSemRegBinding4.pageFour : null;
        if (linearLayout4 != null) {
            linearLayout4.setVisibility(8);
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding5 = this$0.get_binding();
        LinearLayout linearLayout5 = dialogMaceSemRegBinding5 != null ? dialogMaceSemRegBinding5.personalDetailsLyt : null;
        if (linearLayout5 != null) {
            linearLayout5.setVisibility(0);
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding6 = this$0.get_binding();
        LinearLayout linearLayout6 = dialogMaceSemRegBinding6 != null ? dialogMaceSemRegBinding6.universityPreviousLayout : null;
        if (linearLayout6 != null) {
            linearLayout6.setVisibility(8);
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding7 = this$0.get_binding();
        LinearLayout linearLayout7 = dialogMaceSemRegBinding7 != null ? dialogMaceSemRegBinding7.honorMinorLt : null;
        if (linearLayout7 != null) {
            linearLayout7.setVisibility(8);
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding8 = this$0.get_binding();
        LinearLayout linearLayout8 = dialogMaceSemRegBinding8 != null ? dialogMaceSemRegBinding8.duesLt : null;
        if (linearLayout8 != null) {
            linearLayout8.setVisibility(8);
        }
        if (this$0.finalPage) {
            DialogMaceSemRegBinding dialogMaceSemRegBinding9 = this$0.get_binding();
            textView = dialogMaceSemRegBinding9 != null ? dialogMaceSemRegBinding9.registerBtn : null;
            if (textView == null) {
                return;
            }
            textView.setVisibility(0);
            return;
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding10 = this$0.get_binding();
        textView = dialogMaceSemRegBinding10 != null ? dialogMaceSemRegBinding10.registerBtn : null;
        if (textView == null) {
            return;
        }
        textView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$7(MaceNewSemRegDialog this$0, RadioGroup radioGroup, int i) {
        TextInputLayout textInputLayout;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(radioGroup, "radioGroup");
        if (radioGroup.getCheckedRadioButtonId() == R.id.exam_yes) {
            DialogMaceSemRegBinding dialogMaceSemRegBinding = this$0.get_binding();
            textInputLayout = dialogMaceSemRegBinding != null ? dialogMaceSemRegBinding.mtMonthYear : null;
            if (textInputLayout != null) {
                textInputLayout.setVisibility(0);
            }
            String string = this$0.getString(R.string.yes);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.yes)");
            this$0.reg = string;
            return;
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding2 = this$0.get_binding();
        textInputLayout = dialogMaceSemRegBinding2 != null ? dialogMaceSemRegBinding2.mtMonthYear : null;
        if (textInputLayout != null) {
            textInputLayout.setVisibility(8);
        }
        String string2 = this$0.getString(R.string.no);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.no)");
        this$0.reg = string2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$8(MaceNewSemRegDialog this$0, RadioGroup radioGroup, int i) {
        TextInputLayout textInputLayout;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(radioGroup, "radioGroup");
        if (radioGroup.getCheckedRadioButtonId() == R.id.back_yes) {
            DialogMaceSemRegBinding dialogMaceSemRegBinding = this$0.get_binding();
            textInputLayout = dialogMaceSemRegBinding != null ? dialogMaceSemRegBinding.mtBackPapers : null;
            if (textInputLayout != null) {
                textInputLayout.setVisibility(0);
            }
            String string = this$0.getString(R.string.yes);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.yes)");
            this$0.back = string;
            return;
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding2 = this$0.get_binding();
        textInputLayout = dialogMaceSemRegBinding2 != null ? dialogMaceSemRegBinding2.mtBackPapers : null;
        if (textInputLayout != null) {
            textInputLayout.setVisibility(8);
        }
        String string2 = this$0.getString(R.string.no);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.no)");
        this$0.back = string2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$9(MaceNewSemRegDialog this$0, RadioGroup radioGroup, int i) {
        TextInputLayout textInputLayout;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(radioGroup, "radioGroup");
        if (radioGroup.getCheckedRadioButtonId() == R.id.library_yes) {
            DialogMaceSemRegBinding dialogMaceSemRegBinding = this$0.get_binding();
            textInputLayout = dialogMaceSemRegBinding != null ? dialogMaceSemRegBinding.mtDeptLib : null;
            if (textInputLayout != null) {
                textInputLayout.setVisibility(0);
            }
            String string = this$0.getString(R.string.yes);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.yes)");
            this$0.deptLibrary = string;
            return;
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding2 = this$0.get_binding();
        textInputLayout = dialogMaceSemRegBinding2 != null ? dialogMaceSemRegBinding2.mtDeptLib : null;
        if (textInputLayout != null) {
            textInputLayout.setVisibility(8);
        }
        String string2 = this$0.getString(R.string.no);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.no)");
        this$0.deptLibrary = string2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$10(MaceNewSemRegDialog this$0, RadioGroup radioGroup, int i) {
        TextInputLayout textInputLayout;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(radioGroup, "radioGroup");
        if (radioGroup.getCheckedRadioButtonId() == R.id.college_library_yes) {
            DialogMaceSemRegBinding dialogMaceSemRegBinding = this$0.get_binding();
            textInputLayout = dialogMaceSemRegBinding != null ? dialogMaceSemRegBinding.mtLibraryDetails : null;
            if (textInputLayout != null) {
                textInputLayout.setVisibility(0);
            }
            String string = this$0.getString(R.string.yes);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.yes)");
            this$0.collegeLibrary = string;
            return;
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding2 = this$0.get_binding();
        textInputLayout = dialogMaceSemRegBinding2 != null ? dialogMaceSemRegBinding2.mtLibraryDetails : null;
        if (textInputLayout != null) {
            textInputLayout.setVisibility(8);
        }
        String string2 = this$0.getString(R.string.no);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.no)");
        this$0.collegeLibrary = string2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$11(MaceNewSemRegDialog this$0, RadioGroup radioGroup, int i) {
        TextInputLayout textInputLayout;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(radioGroup, "radioGroup");
        if (radioGroup.getCheckedRadioButtonId() == R.id.lab_one_yes) {
            DialogMaceSemRegBinding dialogMaceSemRegBinding = this$0.get_binding();
            textInputLayout = dialogMaceSemRegBinding != null ? dialogMaceSemRegBinding.mtLabOneDetails : null;
            if (textInputLayout != null) {
                textInputLayout.setVisibility(0);
            }
            String string = this$0.getString(R.string.yes);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.yes)");
            this$0.labOne = string;
            return;
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding2 = this$0.get_binding();
        textInputLayout = dialogMaceSemRegBinding2 != null ? dialogMaceSemRegBinding2.mtLabOneDetails : null;
        if (textInputLayout != null) {
            textInputLayout.setVisibility(8);
        }
        String string2 = this$0.getString(R.string.no);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.no)");
        this$0.labOne = string2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$12(MaceNewSemRegDialog this$0, RadioGroup radioGroup, int i) {
        TextInputLayout textInputLayout;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(radioGroup, "radioGroup");
        if (radioGroup.getCheckedRadioButtonId() == R.id.lab_two_yes) {
            DialogMaceSemRegBinding dialogMaceSemRegBinding = this$0.get_binding();
            textInputLayout = dialogMaceSemRegBinding != null ? dialogMaceSemRegBinding.mtLabTwoDetails : null;
            if (textInputLayout != null) {
                textInputLayout.setVisibility(0);
            }
            String string = this$0.getString(R.string.yes);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.yes)");
            this$0.labTwo = string;
            return;
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding2 = this$0.get_binding();
        textInputLayout = dialogMaceSemRegBinding2 != null ? dialogMaceSemRegBinding2.mtLabTwoDetails : null;
        if (textInputLayout != null) {
            textInputLayout.setVisibility(8);
        }
        String string2 = this$0.getString(R.string.no);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.no)");
        this$0.labTwo = string2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$13(MaceNewSemRegDialog this$0, RadioGroup radioGroup, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(radioGroup, "radioGroup");
        if (radioGroup.getCheckedRadioButtonId() == R.id.honour_yes) {
            String string = this$0.getString(R.string.yes);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.yes)");
            this$0.honor = string;
        } else {
            String string2 = this$0.getString(R.string.no);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.no)");
            this$0.honor = string2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$14(MaceNewSemRegDialog this$0, RadioGroup radioGroup, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(radioGroup, "radioGroup");
        if (radioGroup.getCheckedRadioButtonId() == R.id.minor_yes) {
            String string = this$0.getString(R.string.yes);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.yes)");
            this$0.minor = string;
        } else {
            String string2 = this$0.getString(R.string.no);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.no)");
            this$0.minor = string2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$15(MaceNewSemRegDialog this$0, View view) {
        TextInputLayout textInputLayout;
        TextInputEditText textInputEditText;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DialogMaceSemRegBinding dialogMaceSemRegBinding = this$0.get_binding();
        if (Intrinsics.areEqual(String.valueOf((dialogMaceSemRegBinding == null || (textInputEditText = dialogMaceSemRegBinding.etLabTwo) == null) ? null : textInputEditText.getText()), "")) {
            DialogMaceSemRegBinding dialogMaceSemRegBinding2 = this$0.get_binding();
            TextView textView = dialogMaceSemRegBinding2 != null ? dialogMaceSemRegBinding2.duesTv : null;
            if (textView != null) {
                textView.setVisibility(8);
            }
            DialogMaceSemRegBinding dialogMaceSemRegBinding3 = this$0.get_binding();
            RadioGroup radioGroup = dialogMaceSemRegBinding3 != null ? dialogMaceSemRegBinding3.labTwoGroup : null;
            if (radioGroup != null) {
                radioGroup.setVisibility(8);
            }
            DialogMaceSemRegBinding dialogMaceSemRegBinding4 = this$0.get_binding();
            textInputLayout = dialogMaceSemRegBinding4 != null ? dialogMaceSemRegBinding4.mtLabTwoDetails : null;
            if (textInputLayout == null) {
                return;
            }
            textInputLayout.setVisibility(8);
            return;
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding5 = this$0.get_binding();
        TextView textView2 = dialogMaceSemRegBinding5 != null ? dialogMaceSemRegBinding5.duesTv : null;
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding6 = this$0.get_binding();
        RadioGroup radioGroup2 = dialogMaceSemRegBinding6 != null ? dialogMaceSemRegBinding6.labTwoGroup : null;
        if (radioGroup2 != null) {
            radioGroup2.setVisibility(0);
        }
        DialogMaceSemRegBinding dialogMaceSemRegBinding7 = this$0.get_binding();
        textInputLayout = dialogMaceSemRegBinding7 != null ? dialogMaceSemRegBinding7.mtLabTwoDetails : null;
        if (textInputLayout == null) {
            return;
        }
        textInputLayout.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$16(MaceNewSemRegDialog this$0, View view) {
        TextInputEditText textInputEditText;
        TextInputEditText textInputEditText2;
        TextInputEditText textInputEditText3;
        TextInputEditText textInputEditText4;
        TextInputEditText textInputEditText5;
        TextInputEditText textInputEditText6;
        TextInputEditText textInputEditText7;
        TextInputEditText textInputEditText8;
        TextInputEditText textInputEditText9;
        TextInputEditText textInputEditText10;
        TextInputEditText textInputEditText11;
        TextInputEditText textInputEditText12;
        TextInputEditText textInputEditText13;
        TextInputEditText textInputEditText14;
        TextInputEditText textInputEditText15;
        TextInputEditText textInputEditText16;
        TextInputEditText textInputEditText17;
        TextInputEditText textInputEditText18;
        TextInputEditText textInputEditText19;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Editable editable = null;
        if (Intrinsics.areEqual(this$0.reg, "Yes")) {
            DialogMaceSemRegBinding dialogMaceSemRegBinding = this$0.get_binding();
            if (Intrinsics.areEqual(String.valueOf((dialogMaceSemRegBinding == null || (textInputEditText19 = dialogMaceSemRegBinding.etMonthYear) == null) ? null : textInputEditText19.getText()), "")) {
                DialogMaceSemRegBinding dialogMaceSemRegBinding2 = this$0.get_binding();
                if (dialogMaceSemRegBinding2 == null || (textInputEditText18 = dialogMaceSemRegBinding2.etMonthYear) == null) {
                    return;
                }
                ToastExtKt.showErrorToast(textInputEditText18, "Please Fill Registered Month and year!!");
                return;
            }
        }
        if (Intrinsics.areEqual(this$0.back, "Yes")) {
            DialogMaceSemRegBinding dialogMaceSemRegBinding3 = this$0.get_binding();
            if (Intrinsics.areEqual(String.valueOf((dialogMaceSemRegBinding3 == null || (textInputEditText17 = dialogMaceSemRegBinding3.etBackPaperCount) == null) ? null : textInputEditText17.getText()), "")) {
                DialogMaceSemRegBinding dialogMaceSemRegBinding4 = this$0.get_binding();
                if (dialogMaceSemRegBinding4 == null || (textInputEditText16 = dialogMaceSemRegBinding4.etBackPaperCount) == null) {
                    return;
                }
                ToastExtKt.showErrorToast(textInputEditText16, "Please specify number of back papers!!");
                return;
            }
        }
        HashMap hashMap = new HashMap();
        DialogMaceSemRegBinding dialogMaceSemRegBinding5 = this$0.get_binding();
        hashMap.put("SemesterRegistration[mobile_no]", String.valueOf((dialogMaceSemRegBinding5 == null || (textInputEditText15 = dialogMaceSemRegBinding5.etPhoneNumber) == null) ? null : textInputEditText15.getText()));
        DialogMaceSemRegBinding dialogMaceSemRegBinding6 = this$0.get_binding();
        hashMap.put("SemesterRegistration[email]", String.valueOf((dialogMaceSemRegBinding6 == null || (textInputEditText14 = dialogMaceSemRegBinding6.etEmailId) == null) ? null : textInputEditText14.getText()));
        DialogMaceSemRegBinding dialogMaceSemRegBinding7 = this$0.get_binding();
        hashMap.put("SemesterRegistration[house_name]", String.valueOf((dialogMaceSemRegBinding7 == null || (textInputEditText13 = dialogMaceSemRegBinding7.etNameOfHouse) == null) ? null : textInputEditText13.getText()));
        DialogMaceSemRegBinding dialogMaceSemRegBinding8 = this$0.get_binding();
        hashMap.put("SemesterRegistration[phone_house]", String.valueOf((dialogMaceSemRegBinding8 == null || (textInputEditText12 = dialogMaceSemRegBinding8.etContactNum) == null) ? null : textInputEditText12.getText()));
        DialogMaceSemRegBinding dialogMaceSemRegBinding9 = this$0.get_binding();
        hashMap.put("SemesterRegistration[phone_parent]", String.valueOf((dialogMaceSemRegBinding9 == null || (textInputEditText11 = dialogMaceSemRegBinding9.etParentsMob) == null) ? null : textInputEditText11.getText()));
        DialogMaceSemRegBinding dialogMaceSemRegBinding10 = this$0.get_binding();
        hashMap.put("SemesterRegistration[address]", String.valueOf((dialogMaceSemRegBinding10 == null || (textInputEditText10 = dialogMaceSemRegBinding10.etAddress) == null) ? null : textInputEditText10.getText()));
        hashMap.put("SemesterRegistration[semester_id]", this$0.sem);
        hashMap.put("SemesterRegistration[exam_appear]", this$0.reg);
        hashMap.put("SemesterRegistration[backpaper]", this$0.back);
        DialogMaceSemRegBinding dialogMaceSemRegBinding11 = this$0.get_binding();
        hashMap.put("SemesterRegistration[earned_credits]", String.valueOf((dialogMaceSemRegBinding11 == null || (textInputEditText9 = dialogMaceSemRegBinding11.etCreditsEarned) == null) ? null : textInputEditText9.getText()));
        if (Intrinsics.areEqual(this$0.reg, "Yes")) {
            DialogMaceSemRegBinding dialogMaceSemRegBinding12 = this$0.get_binding();
            hashMap.put("SemesterRegistration[exam_month_year]", String.valueOf((dialogMaceSemRegBinding12 == null || (textInputEditText8 = dialogMaceSemRegBinding12.etMonthYear) == null) ? null : textInputEditText8.getText()));
        } else {
            hashMap.put("SemesterRegistration[exam_month_year]", "");
        }
        if (Intrinsics.areEqual(this$0.back, "Yes")) {
            DialogMaceSemRegBinding dialogMaceSemRegBinding13 = this$0.get_binding();
            hashMap.put("SemesterRegistration[backlogs_count]", String.valueOf((dialogMaceSemRegBinding13 == null || (textInputEditText7 = dialogMaceSemRegBinding13.etBackPaperCount) == null) ? null : textInputEditText7.getText()));
        } else {
            hashMap.put("SemesterRegistration[backlogs_count]", "");
        }
        hashMap.put("SemesterRegistration[honour]", this$0.honor);
        hashMap.put("SemesterRegistration[minor]", this$0.minor);
        hashMap.put("SemesterRegistration[dept_library_due]", this$0.deptLibrary);
        hashMap.put("SemesterRegistration[library_due]", this$0.collegeLibrary);
        hashMap.put("SemesterRegistration[lab1_due]", this$0.labOne);
        hashMap.put("SemesterRegistration[lab2_due]", this$0.labTwo);
        DialogMaceSemRegBinding dialogMaceSemRegBinding14 = this$0.get_binding();
        hashMap.put("SemesterRegistration[lab1]", String.valueOf((dialogMaceSemRegBinding14 == null || (textInputEditText6 = dialogMaceSemRegBinding14.etLabOne) == null) ? null : textInputEditText6.getText()));
        DialogMaceSemRegBinding dialogMaceSemRegBinding15 = this$0.get_binding();
        hashMap.put("SemesterRegistration[lab2]", String.valueOf((dialogMaceSemRegBinding15 == null || (textInputEditText5 = dialogMaceSemRegBinding15.etLabTwo) == null) ? null : textInputEditText5.getText()));
        DialogMaceSemRegBinding dialogMaceSemRegBinding16 = this$0.get_binding();
        hashMap.put("SemesterRegistration[dept_library_due_details]", String.valueOf((dialogMaceSemRegBinding16 == null || (textInputEditText4 = dialogMaceSemRegBinding16.etDeptLib) == null) ? null : textInputEditText4.getText()));
        DialogMaceSemRegBinding dialogMaceSemRegBinding17 = this$0.get_binding();
        hashMap.put("SemesterRegistration[library_due_details]", String.valueOf((dialogMaceSemRegBinding17 == null || (textInputEditText3 = dialogMaceSemRegBinding17.etLibraryDetails) == null) ? null : textInputEditText3.getText()));
        DialogMaceSemRegBinding dialogMaceSemRegBinding18 = this$0.get_binding();
        hashMap.put("SemesterRegistration[lab1_due_details]", String.valueOf((dialogMaceSemRegBinding18 == null || (textInputEditText2 = dialogMaceSemRegBinding18.etLabOneDetails) == null) ? null : textInputEditText2.getText()));
        DialogMaceSemRegBinding dialogMaceSemRegBinding19 = this$0.get_binding();
        if (dialogMaceSemRegBinding19 != null && (textInputEditText = dialogMaceSemRegBinding19.etLabTwoDetails) != null) {
            editable = textInputEditText.getText();
        }
        hashMap.put("SemesterRegistration[lab2_due_details]", String.valueOf(editable));
        this$0.getMaceNewSemRegViewModel().registerSemester(hashMap);
    }

    private final void listenRegisterResponse() {
        getMaceNewSemRegViewModel().getRegisterResponse().observe(getViewLifecycleOwner(), new MaceNewSemRegDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends SuccessResponse>, Unit>() { // from class: in.etuwa.app.ui.semregistration.mace.MaceNewSemRegDialog$listenRegisterResponse$1

            /* compiled from: MaceNewSemRegDialog.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends SuccessResponse> resource) {
                invoke2((Resource<SuccessResponse>) resource);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<SuccessResponse> resource) {
                DialogMaceSemRegBinding dialogMaceSemRegBinding;
                TextView registerBtn;
                DialogMaceSemRegBinding dialogMaceSemRegBinding2;
                TextView registerBtn2;
                DialogMaceSemRegBinding dialogMaceSemRegBinding3;
                TextView textView;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        MaceNewSemRegDialog.this.showProgress();
                        return;
                    }
                    if (i == 3) {
                        MaceNewSemRegDialog.this.hideProgress();
                        return;
                    }
                    if (i != 4) {
                        return;
                    }
                    MaceNewSemRegDialog.this.hideProgress();
                    dialogMaceSemRegBinding3 = MaceNewSemRegDialog.this.get_binding();
                    if (dialogMaceSemRegBinding3 == null || (textView = dialogMaceSemRegBinding3.registerBtn) == null) {
                        return;
                    }
                    String message = resource.getMessage();
                    Intrinsics.checkNotNull(message);
                    ToastExtKt.showErrorToast(textView, message);
                    return;
                }
                MaceNewSemRegDialog.this.hideProgress();
                SuccessResponse data = resource.getData();
                if (data != null) {
                    MaceNewSemRegDialog maceNewSemRegDialog = MaceNewSemRegDialog.this;
                    if (data.getSuccess()) {
                        dialogMaceSemRegBinding2 = maceNewSemRegDialog.get_binding();
                        if (dialogMaceSemRegBinding2 != null && (registerBtn2 = dialogMaceSemRegBinding2.registerBtn) != null) {
                            Intrinsics.checkNotNullExpressionValue(registerBtn2, "registerBtn");
                            ToastExtKt.showSuccessToast(registerBtn2, data.getMessage());
                        }
                        maceNewSemRegDialog.dismiss();
                        return;
                    }
                    dialogMaceSemRegBinding = maceNewSemRegDialog.get_binding();
                    if (dialogMaceSemRegBinding == null || (registerBtn = dialogMaceSemRegBinding.registerBtn) == null) {
                        return;
                    }
                    Intrinsics.checkNotNullExpressionValue(registerBtn, "registerBtn");
                    ToastExtKt.showErrorToast(registerBtn, AppConstant.ERROR_MSG);
                }
            }
        }));
    }

    private final void listenSemResponse() {
        getMaceNewSemRegViewModel().getSemResponse().observe(getViewLifecycleOwner(), new MaceNewSemRegDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends ArrayList<Semester>>, Unit>() { // from class: in.etuwa.app.ui.semregistration.mace.MaceNewSemRegDialog$listenSemResponse$1

            /* compiled from: MaceNewSemRegDialog.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends ArrayList<Semester>> resource) {
                invoke2(resource);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<? extends ArrayList<Semester>> resource) {
                SemesterRegistrationSpinnerAdapter spinnerAdapter;
                SemesterRegistrationSpinnerAdapter spinnerAdapter2;
                SharedPrefManager preference;
                SemesterRegistrationSpinnerAdapter spinnerAdapter3;
                DialogMaceSemRegBinding dialogMaceSemRegBinding;
                Spinner spinner;
                DialogMaceSemRegBinding dialogMaceSemRegBinding2;
                Spinner spinner2;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        MaceNewSemRegDialog.this.showProgress();
                        return;
                    }
                    if (i == 3) {
                        MaceNewSemRegDialog.this.hideProgress();
                        return;
                    }
                    if (i != 4) {
                        return;
                    }
                    MaceNewSemRegDialog.this.hideProgress();
                    dialogMaceSemRegBinding2 = MaceNewSemRegDialog.this.get_binding();
                    if (dialogMaceSemRegBinding2 == null || (spinner2 = dialogMaceSemRegBinding2.spinnerAcademicYear) == null) {
                        return;
                    }
                    String message = resource.getMessage();
                    Intrinsics.checkNotNull(message);
                    ToastExtKt.showErrorToast(spinner2, message);
                    return;
                }
                MaceNewSemRegDialog.this.hideProgress();
                ArrayList<Semester> data = resource.getData();
                if (data != null) {
                    MaceNewSemRegDialog maceNewSemRegDialog = MaceNewSemRegDialog.this;
                    spinnerAdapter = maceNewSemRegDialog.getSpinnerAdapter();
                    spinnerAdapter.addItems(data);
                    spinnerAdapter2 = maceNewSemRegDialog.getSpinnerAdapter();
                    int count = spinnerAdapter2.getCount();
                    for (int i2 = 0; i2 < count; i2++) {
                        preference = maceNewSemRegDialog.getPreference();
                        String userSemId = preference.getUserSemId();
                        spinnerAdapter3 = maceNewSemRegDialog.getSpinnerAdapter();
                        if (Intrinsics.areEqual(userSemId, spinnerAdapter3.getSemester(i2).getId())) {
                            dialogMaceSemRegBinding = maceNewSemRegDialog.get_binding();
                            if (dialogMaceSemRegBinding == null || (spinner = dialogMaceSemRegBinding.spinnerSemesterLastAttended) == null) {
                                return;
                            }
                            spinner.setSelection(i2);
                            return;
                        }
                    }
                }
            }
        }));
    }

    private final void listenSpinner() {
        getMaceNewSemRegViewModel().getListResponse().observe(getViewLifecycleOwner(), new MaceNewSemRegDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends AcademicYearResponse>, Unit>() { // from class: in.etuwa.app.ui.semregistration.mace.MaceNewSemRegDialog$listenSpinner$1

            /* compiled from: MaceNewSemRegDialog.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends AcademicYearResponse> resource) {
                invoke2((Resource<AcademicYearResponse>) resource);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<AcademicYearResponse> resource) {
                DialogMaceSemRegBinding dialogMaceSemRegBinding;
                Spinner spinner;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i == 1) {
                    MaceNewSemRegDialog.this.hideProgress();
                    resource.getData();
                    return;
                }
                if (i == 2) {
                    MaceNewSemRegDialog.this.showProgress();
                    return;
                }
                if (i == 3) {
                    MaceNewSemRegDialog.this.hideProgress();
                    return;
                }
                if (i != 4) {
                    return;
                }
                MaceNewSemRegDialog.this.hideProgress();
                dialogMaceSemRegBinding = MaceNewSemRegDialog.this.get_binding();
                if (dialogMaceSemRegBinding == null || (spinner = dialogMaceSemRegBinding.spinnerAcademicYear) == null) {
                    return;
                }
                String message = resource.getMessage();
                Intrinsics.checkNotNull(message);
                ToastExtKt.showErrorToast(spinner, message);
            }
        }));
    }

    public final void setCallBack(PalaiSemesterRegFragment context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.listener = context;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        AddCounsellingListener addCounsellingListener = this.listener;
        if (addCounsellingListener != null) {
            addCounsellingListener.dismiss();
        }
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