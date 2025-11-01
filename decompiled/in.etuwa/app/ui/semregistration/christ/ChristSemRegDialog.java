package in.etuwa.app.ui.semregistration.christ;

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
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.SemRegSuccessResponse;
import in.etuwa.app.data.model.Semester;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.DialogChristSemRegBinding;
import in.etuwa.app.helper.SemesterSpinnerAdapter;
import in.etuwa.app.ui.base.BaseDialog;
import in.etuwa.app.ui.semregistration.list.SemRegisterListFragment;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import java.util.ArrayList;
import java.util.Calendar;
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

/* compiled from: ChristSemRegDialog.kt */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 T2\u00020\u0001:\u0002STB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010;\u001a\u00020<H\u0014J\b\u0010=\u001a\u00020<H\u0002J\b\u0010>\u001a\u00020<H\u0002J&\u0010?\u001a\u0004\u0018\u00010@2\u0006\u0010A\u001a\u00020B2\b\u0010C\u001a\u0004\u0018\u00010D2\b\u0010E\u001a\u0004\u0018\u00010FH\u0016J\b\u0010G\u001a\u00020<H\u0016J\b\u0010H\u001a\u00020<H\u0016J\u0010\u0010I\u001a\u00020<2\u0006\u0010J\u001a\u00020KH\u0016J\u001a\u0010L\u001a\u00020<2\u0006\u0010M\u001a\u00020@2\b\u0010E\u001a\u0004\u0018\u00010FH\u0016J\u000e\u0010N\u001a\u00020<2\u0006\u0010O\u001a\u00020PJ\b\u0010Q\u001a\u00020<H\u0014J\b\u0010R\u001a\u00020<H\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0019\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010,\u001a\u00020-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u0010\u0018\u001a\u0004\b.\u0010/R\u000e\u00101\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u00105\u001a\u0002068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010\u0018\u001a\u0004\b7\u00108R\u000e\u0010:\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006U"}, d2 = {"Lin/etuwa/app/ui/semregistration/christ/ChristSemRegDialog;", "Lin/etuwa/app/ui/base/BaseDialog;", "()V", "_binding", "Lin/etuwa/app/databinding/DialogChristSemRegBinding;", "academics", "", "academicsDetails", "accounts", "accountsDetails", "back", "backDetails", "binding", "getBinding", "()Lin/etuwa/app/databinding/DialogChristSemRegBinding;", "bus", "busDetails", "cgpaClicked", "", "christSemRegViewModel", "Lin/etuwa/app/ui/semregistration/christ/ChristSemRegViewModel;", "getChristSemRegViewModel", "()Lin/etuwa/app/ui/semregistration/christ/ChristSemRegViewModel;", "christSemRegViewModel$delegate", "Lkotlin/Lazy;", "dept", "deptDetails", "dueClicked", "examAttClicked", "feeClicked", "feeConcession", "finalPage", "flag", "globalElectiveClicked", "honor", "honorMinorClicked", "hostel", "hostelDetails", "id", "library", "libraryDetails", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/semregistration/christ/ChristSemRegDialog$AddCounsellingListener;", "minor", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", "prevSemClicked", "reg", "regDetails", "sem", "spinnerSem", "Lin/etuwa/app/helper/SemesterSpinnerAdapter;", "getSpinnerSem", "()Lin/etuwa/app/helper/SemesterSpinnerAdapter;", "spinnerSem$delegate", "supplyClicked", "hideProgress", "", "listenAddResponse", "listenSemResponse", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onDetach", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onViewCreated", SvgConstants.Tags.VIEW, "setCallBack", "context", "Lin/etuwa/app/ui/semregistration/list/SemRegisterListFragment;", "setUp", "showProgress", "AddCounsellingListener", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ChristSemRegDialog extends BaseDialog {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private DialogChristSemRegBinding _binding;
    private String academics;
    private String academicsDetails;
    private String accounts;
    private String accountsDetails;
    private String back;
    private String backDetails;
    private String bus;
    private String busDetails;
    private boolean cgpaClicked;

    /* renamed from: christSemRegViewModel$delegate, reason: from kotlin metadata */
    private final Lazy christSemRegViewModel;
    private String dept;
    private String deptDetails;
    private boolean dueClicked;
    private boolean examAttClicked;
    private boolean feeClicked;
    private String feeConcession;
    private boolean finalPage;
    private boolean flag;
    private boolean globalElectiveClicked;
    private String honor;
    private boolean honorMinorClicked;
    private String hostel;
    private String hostelDetails;
    private String id;
    private String library;
    private String libraryDetails;
    private AddCounsellingListener listener;
    private String minor;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;
    private boolean prevSemClicked;
    private String reg;
    private String regDetails;
    private String sem;

    /* renamed from: spinnerSem$delegate, reason: from kotlin metadata */
    private final Lazy spinnerSem;
    private boolean supplyClicked;

    /* compiled from: ChristSemRegDialog.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lin/etuwa/app/ui/semregistration/christ/ChristSemRegDialog$AddCounsellingListener;", "", "dismiss", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface AddCounsellingListener {
        void dismiss();
    }

    /* compiled from: ChristSemRegDialog.kt */
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
    public static final ChristSemRegDialog newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void showProgress() {
    }

    public ChristSemRegDialog() {
        final ChristSemRegDialog christSemRegDialog = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.semregistration.christ.ChristSemRegDialog$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(christSemRegDialog);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.christSemRegViewModel = FragmentViewModelLazyKt.createViewModelLazy(christSemRegDialog, Reflection.getOrCreateKotlinClass(ChristSemRegViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.semregistration.christ.ChristSemRegDialog$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.semregistration.christ.ChristSemRegDialog$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(ChristSemRegViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final ChristSemRegDialog christSemRegDialog2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.semregistration.christ.ChristSemRegDialog$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = christSemRegDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b2, b3);
            }
        });
        this.minor = "";
        this.sem = "";
        this.reg = "Yes";
        this.bus = "Yes";
        this.dept = "Yes";
        this.library = "Yes";
        this.accounts = "Yes";
        this.academics = "Yes";
        this.hostel = "Yes";
        this.back = "Yes";
        this.feeConcession = "Yes";
        this.deptDetails = "";
        this.libraryDetails = "";
        this.busDetails = "";
        this.accountsDetails = "";
        this.academicsDetails = "";
        this.hostelDetails = "";
        this.regDetails = "";
        this.backDetails = "";
        this.honor = "";
        final Function0<ParametersHolder> function02 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.semregistration.christ.ChristSemRegDialog$spinnerSem$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(ChristSemRegDialog.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        this.spinnerSem = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<SemesterSpinnerAdapter>() { // from class: in.etuwa.app.ui.semregistration.christ.ChristSemRegDialog$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.helper.SemesterSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SemesterSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = christSemRegDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SemesterSpinnerAdapter.class), b4, function02);
            }
        });
    }

    private final ChristSemRegViewModel getChristSemRegViewModel() {
        return (ChristSemRegViewModel) this.christSemRegViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getBinding, reason: from getter */
    public final DialogChristSemRegBinding get_binding() {
        return this._binding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SemesterSpinnerAdapter getSpinnerSem() {
        return (SemesterSpinnerAdapter) this.spinnerSem.getValue();
    }

    /* compiled from: ChristSemRegDialog.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/semregistration/christ/ChristSemRegDialog$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/semregistration/christ/ChristSemRegDialog;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ChristSemRegDialog newInstance() {
            return new ChristSemRegDialog();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = DialogChristSemRegBinding.inflate(inflater, container, false);
        DialogChristSemRegBinding dialogChristSemRegBinding = get_binding();
        if (dialogChristSemRegBinding != null) {
            dialogChristSemRegBinding.setChristSemRegViewModel(getChristSemRegViewModel());
        }
        DialogChristSemRegBinding dialogChristSemRegBinding2 = get_binding();
        if (dialogChristSemRegBinding2 != null) {
            dialogChristSemRegBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        DialogChristSemRegBinding dialogChristSemRegBinding3 = get_binding();
        if (dialogChristSemRegBinding3 != null) {
            return dialogChristSemRegBinding3.getRoot();
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
        RadioGroup radioGroup;
        RadioGroup radioGroup2;
        RadioGroup radioGroup3;
        RadioGroup radioGroup4;
        RadioGroup radioGroup5;
        RadioGroup radioGroup6;
        RadioGroup radioGroup7;
        Calendar calendar = Calendar.getInstance();
        calendar.get(1);
        calendar.get(2);
        calendar.get(5);
        listenAddResponse();
        listenSemResponse();
        getChristSemRegViewModel().getSemester();
        DialogChristSemRegBinding dialogChristSemRegBinding = get_binding();
        Spinner spinner = dialogChristSemRegBinding != null ? dialogChristSemRegBinding.spinnerSemesterLastAttended : null;
        if (spinner != null) {
            spinner.setAdapter((SpinnerAdapter) getSpinnerSem());
        }
        DialogChristSemRegBinding dialogChristSemRegBinding2 = get_binding();
        Spinner spinner2 = dialogChristSemRegBinding2 != null ? dialogChristSemRegBinding2.spinnerSemesterLastAttended : null;
        if (spinner2 != null) {
            spinner2.setAdapter((SpinnerAdapter) getSpinnerSem());
        }
        DialogChristSemRegBinding dialogChristSemRegBinding3 = get_binding();
        if (dialogChristSemRegBinding3 != null && (radioGroup7 = dialogChristSemRegBinding3.busDue) != null) {
            radioGroup7.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.etuwa.app.ui.semregistration.christ.ChristSemRegDialog$$ExternalSyntheticLambda0
                @Override // android.widget.RadioGroup.OnCheckedChangeListener
                public final void onCheckedChanged(RadioGroup radioGroup8, int i) {
                    ChristSemRegDialog.setUp$lambda$0(ChristSemRegDialog.this, radioGroup8, i);
                }
            });
        }
        DialogChristSemRegBinding dialogChristSemRegBinding4 = get_binding();
        if (dialogChristSemRegBinding4 != null && (radioGroup6 = dialogChristSemRegBinding4.busDue) != null) {
            radioGroup6.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.etuwa.app.ui.semregistration.christ.ChristSemRegDialog$$ExternalSyntheticLambda1
                @Override // android.widget.RadioGroup.OnCheckedChangeListener
                public final void onCheckedChanged(RadioGroup radioGroup8, int i) {
                    ChristSemRegDialog.setUp$lambda$1(ChristSemRegDialog.this, radioGroup8, i);
                }
            });
        }
        DialogChristSemRegBinding dialogChristSemRegBinding5 = get_binding();
        if (dialogChristSemRegBinding5 != null && (radioGroup5 = dialogChristSemRegBinding5.departmentDue) != null) {
            radioGroup5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.etuwa.app.ui.semregistration.christ.ChristSemRegDialog$$ExternalSyntheticLambda2
                @Override // android.widget.RadioGroup.OnCheckedChangeListener
                public final void onCheckedChanged(RadioGroup radioGroup8, int i) {
                    ChristSemRegDialog.setUp$lambda$2(ChristSemRegDialog.this, radioGroup8, i);
                }
            });
        }
        DialogChristSemRegBinding dialogChristSemRegBinding6 = get_binding();
        if (dialogChristSemRegBinding6 != null && (radioGroup4 = dialogChristSemRegBinding6.academicDue) != null) {
            radioGroup4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.etuwa.app.ui.semregistration.christ.ChristSemRegDialog$$ExternalSyntheticLambda3
                @Override // android.widget.RadioGroup.OnCheckedChangeListener
                public final void onCheckedChanged(RadioGroup radioGroup8, int i) {
                    ChristSemRegDialog.setUp$lambda$3(ChristSemRegDialog.this, radioGroup8, i);
                }
            });
        }
        DialogChristSemRegBinding dialogChristSemRegBinding7 = get_binding();
        if (dialogChristSemRegBinding7 != null && (radioGroup3 = dialogChristSemRegBinding7.accountsDue) != null) {
            radioGroup3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.etuwa.app.ui.semregistration.christ.ChristSemRegDialog$$ExternalSyntheticLambda4
                @Override // android.widget.RadioGroup.OnCheckedChangeListener
                public final void onCheckedChanged(RadioGroup radioGroup8, int i) {
                    ChristSemRegDialog.setUp$lambda$4(ChristSemRegDialog.this, radioGroup8, i);
                }
            });
        }
        DialogChristSemRegBinding dialogChristSemRegBinding8 = get_binding();
        if (dialogChristSemRegBinding8 != null && (radioGroup2 = dialogChristSemRegBinding8.libraryDue) != null) {
            radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.etuwa.app.ui.semregistration.christ.ChristSemRegDialog$$ExternalSyntheticLambda5
                @Override // android.widget.RadioGroup.OnCheckedChangeListener
                public final void onCheckedChanged(RadioGroup radioGroup8, int i) {
                    ChristSemRegDialog.setUp$lambda$5(ChristSemRegDialog.this, radioGroup8, i);
                }
            });
        }
        DialogChristSemRegBinding dialogChristSemRegBinding9 = get_binding();
        if (dialogChristSemRegBinding9 != null && (radioGroup = dialogChristSemRegBinding9.hostelDue) != null) {
            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.etuwa.app.ui.semregistration.christ.ChristSemRegDialog$$ExternalSyntheticLambda6
                @Override // android.widget.RadioGroup.OnCheckedChangeListener
                public final void onCheckedChanged(RadioGroup radioGroup8, int i) {
                    ChristSemRegDialog.setUp$lambda$6(ChristSemRegDialog.this, radioGroup8, i);
                }
            });
        }
        DialogChristSemRegBinding dialogChristSemRegBinding10 = get_binding();
        if (dialogChristSemRegBinding10 != null && (textView2 = dialogChristSemRegBinding10.dueTv) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.christ.ChristSemRegDialog$$ExternalSyntheticLambda7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ChristSemRegDialog.setUp$lambda$7(ChristSemRegDialog.this, view);
                }
            });
        }
        DialogChristSemRegBinding dialogChristSemRegBinding11 = get_binding();
        Spinner spinner3 = dialogChristSemRegBinding11 != null ? dialogChristSemRegBinding11.spinnerSemesterLastAttended : null;
        if (spinner3 != null) {
            spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.semregistration.christ.ChristSemRegDialog$setUp$9
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    SemesterSpinnerAdapter spinnerSem;
                    boolean z;
                    SemesterSpinnerAdapter spinnerSem2;
                    SharedPrefManager preference;
                    SemesterSpinnerAdapter spinnerSem3;
                    DialogChristSemRegBinding dialogChristSemRegBinding12;
                    Spinner spinner4;
                    ChristSemRegDialog christSemRegDialog = ChristSemRegDialog.this;
                    spinnerSem = christSemRegDialog.getSpinnerSem();
                    christSemRegDialog.sem = spinnerSem.getSemester(position).getId();
                    z = ChristSemRegDialog.this.flag;
                    if (z) {
                        return;
                    }
                    ChristSemRegDialog.this.flag = true;
                    spinnerSem2 = ChristSemRegDialog.this.getSpinnerSem();
                    int count = spinnerSem2.getCount();
                    for (int i = 0; i < count; i++) {
                        preference = ChristSemRegDialog.this.getPreference();
                        String userSemId = preference.getUserSemId();
                        spinnerSem3 = ChristSemRegDialog.this.getSpinnerSem();
                        if (Intrinsics.areEqual(userSemId, spinnerSem3.getSemester(i).getId())) {
                            dialogChristSemRegBinding12 = ChristSemRegDialog.this.get_binding();
                            if (dialogChristSemRegBinding12 == null || (spinner4 = dialogChristSemRegBinding12.spinnerSemesterLastAttended) == null) {
                                return;
                            }
                            spinner4.setSelection(i);
                            return;
                        }
                    }
                }
            });
        }
        DialogChristSemRegBinding dialogChristSemRegBinding12 = get_binding();
        if (dialogChristSemRegBinding12 == null || (textView = dialogChristSemRegBinding12.registerBtn) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.christ.ChristSemRegDialog$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChristSemRegDialog.setUp$lambda$8(ChristSemRegDialog.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$0(ChristSemRegDialog this$0, RadioGroup radioGroup, int i) {
        TextInputLayout textInputLayout;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(radioGroup, "radioGroup");
        if (radioGroup.getCheckedRadioButtonId() == R.id.bus_yes) {
            DialogChristSemRegBinding dialogChristSemRegBinding = this$0.get_binding();
            textInputLayout = dialogChristSemRegBinding != null ? dialogChristSemRegBinding.mtBusDetail : null;
            if (textInputLayout != null) {
                textInputLayout.setVisibility(0);
            }
            String string = this$0.getString(R.string.yes);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.yes)");
            this$0.reg = string;
            return;
        }
        this$0.regDetails = "";
        DialogChristSemRegBinding dialogChristSemRegBinding2 = this$0.get_binding();
        textInputLayout = dialogChristSemRegBinding2 != null ? dialogChristSemRegBinding2.mtBusDetail : null;
        if (textInputLayout != null) {
            textInputLayout.setVisibility(8);
        }
        String string2 = this$0.getString(R.string.no);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.no)");
        this$0.reg = string2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(ChristSemRegDialog this$0, RadioGroup radioGroup, int i) {
        TextInputLayout textInputLayout;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(radioGroup, "radioGroup");
        if (radioGroup.getCheckedRadioButtonId() == R.id.bus_yes) {
            DialogChristSemRegBinding dialogChristSemRegBinding = this$0.get_binding();
            textInputLayout = dialogChristSemRegBinding != null ? dialogChristSemRegBinding.mtBusDetail : null;
            if (textInputLayout != null) {
                textInputLayout.setVisibility(0);
            }
            String string = this$0.getString(R.string.yes);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.yes)");
            this$0.bus = string;
            return;
        }
        this$0.busDetails = "";
        DialogChristSemRegBinding dialogChristSemRegBinding2 = this$0.get_binding();
        textInputLayout = dialogChristSemRegBinding2 != null ? dialogChristSemRegBinding2.mtBusDetail : null;
        if (textInputLayout != null) {
            textInputLayout.setVisibility(8);
        }
        String string2 = this$0.getString(R.string.no);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.no)");
        this$0.bus = string2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$2(ChristSemRegDialog this$0, RadioGroup radioGroup, int i) {
        TextInputLayout textInputLayout;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(radioGroup, "radioGroup");
        if (radioGroup.getCheckedRadioButtonId() == R.id.back_yes) {
            DialogChristSemRegBinding dialogChristSemRegBinding = this$0.get_binding();
            textInputLayout = dialogChristSemRegBinding != null ? dialogChristSemRegBinding.mtDeptDetail : null;
            if (textInputLayout != null) {
                textInputLayout.setVisibility(0);
            }
            String string = this$0.getString(R.string.yes);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.yes)");
            this$0.dept = string;
            return;
        }
        this$0.deptDetails = "";
        DialogChristSemRegBinding dialogChristSemRegBinding2 = this$0.get_binding();
        textInputLayout = dialogChristSemRegBinding2 != null ? dialogChristSemRegBinding2.mtDeptDetail : null;
        if (textInputLayout != null) {
            textInputLayout.setVisibility(8);
        }
        String string2 = this$0.getString(R.string.no);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.no)");
        this$0.dept = string2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$3(ChristSemRegDialog this$0, RadioGroup radioGroup, int i) {
        TextInputLayout textInputLayout;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(radioGroup, "radioGroup");
        if (radioGroup.getCheckedRadioButtonId() == R.id.back_yes) {
            DialogChristSemRegBinding dialogChristSemRegBinding = this$0.get_binding();
            textInputLayout = dialogChristSemRegBinding != null ? dialogChristSemRegBinding.mtAcademicDetail : null;
            if (textInputLayout != null) {
                textInputLayout.setVisibility(0);
            }
            String string = this$0.getString(R.string.yes);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.yes)");
            this$0.academics = string;
            return;
        }
        this$0.academicsDetails = "";
        DialogChristSemRegBinding dialogChristSemRegBinding2 = this$0.get_binding();
        textInputLayout = dialogChristSemRegBinding2 != null ? dialogChristSemRegBinding2.mtAcademicDetail : null;
        if (textInputLayout != null) {
            textInputLayout.setVisibility(8);
        }
        String string2 = this$0.getString(R.string.no);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.no)");
        this$0.academics = string2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$4(ChristSemRegDialog this$0, RadioGroup radioGroup, int i) {
        TextInputLayout textInputLayout;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(radioGroup, "radioGroup");
        if (radioGroup.getCheckedRadioButtonId() == R.id.back_yes) {
            DialogChristSemRegBinding dialogChristSemRegBinding = this$0.get_binding();
            textInputLayout = dialogChristSemRegBinding != null ? dialogChristSemRegBinding.mtAccountDetail : null;
            if (textInputLayout != null) {
                textInputLayout.setVisibility(0);
            }
            String string = this$0.getString(R.string.yes);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.yes)");
            this$0.accounts = string;
            return;
        }
        this$0.accountsDetails = "";
        DialogChristSemRegBinding dialogChristSemRegBinding2 = this$0.get_binding();
        textInputLayout = dialogChristSemRegBinding2 != null ? dialogChristSemRegBinding2.mtAccountDetail : null;
        if (textInputLayout != null) {
            textInputLayout.setVisibility(8);
        }
        String string2 = this$0.getString(R.string.no);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.no)");
        this$0.accounts = string2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$5(ChristSemRegDialog this$0, RadioGroup radioGroup, int i) {
        TextInputLayout textInputLayout;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(radioGroup, "radioGroup");
        if (radioGroup.getCheckedRadioButtonId() == R.id.back_yes) {
            DialogChristSemRegBinding dialogChristSemRegBinding = this$0.get_binding();
            textInputLayout = dialogChristSemRegBinding != null ? dialogChristSemRegBinding.mtLibraryDetail : null;
            if (textInputLayout != null) {
                textInputLayout.setVisibility(0);
            }
            String string = this$0.getString(R.string.yes);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.yes)");
            this$0.library = string;
            return;
        }
        this$0.libraryDetails = "";
        DialogChristSemRegBinding dialogChristSemRegBinding2 = this$0.get_binding();
        textInputLayout = dialogChristSemRegBinding2 != null ? dialogChristSemRegBinding2.mtLibraryDetail : null;
        if (textInputLayout != null) {
            textInputLayout.setVisibility(8);
        }
        String string2 = this$0.getString(R.string.no);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.no)");
        this$0.library = string2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$6(ChristSemRegDialog this$0, RadioGroup radioGroup, int i) {
        TextInputLayout textInputLayout;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(radioGroup, "radioGroup");
        if (radioGroup.getCheckedRadioButtonId() == R.id.back_yes) {
            DialogChristSemRegBinding dialogChristSemRegBinding = this$0.get_binding();
            textInputLayout = dialogChristSemRegBinding != null ? dialogChristSemRegBinding.mtHostelDetail : null;
            if (textInputLayout != null) {
                textInputLayout.setVisibility(0);
            }
            String string = this$0.getString(R.string.yes);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.yes)");
            this$0.hostel = string;
            return;
        }
        this$0.hostelDetails = "";
        DialogChristSemRegBinding dialogChristSemRegBinding2 = this$0.get_binding();
        textInputLayout = dialogChristSemRegBinding2 != null ? dialogChristSemRegBinding2.mtHostelDetail : null;
        if (textInputLayout != null) {
            textInputLayout.setVisibility(8);
        }
        String string2 = this$0.getString(R.string.no);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.no)");
        this$0.hostel = string2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$7(ChristSemRegDialog this$0, View view) {
        LinearLayout linearLayout;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.dueClicked) {
            this$0.dueClicked = true;
            DialogChristSemRegBinding dialogChristSemRegBinding = this$0.get_binding();
            linearLayout = dialogChristSemRegBinding != null ? dialogChristSemRegBinding.dueLt : null;
            if (linearLayout == null) {
                return;
            }
            linearLayout.setVisibility(0);
            return;
        }
        this$0.dueClicked = false;
        DialogChristSemRegBinding dialogChristSemRegBinding2 = this$0.get_binding();
        linearLayout = dialogChristSemRegBinding2 != null ? dialogChristSemRegBinding2.dueLt : null;
        if (linearLayout == null) {
            return;
        }
        linearLayout.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$8(ChristSemRegDialog this$0, View view) {
        TextInputEditText textInputEditText;
        TextInputEditText textInputEditText2;
        TextInputEditText textInputEditText3;
        TextInputEditText textInputEditText4;
        TextInputEditText textInputEditText5;
        TextInputEditText textInputEditText6;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        HashMap hashMap = new HashMap();
        hashMap.clear();
        HashMap hashMap2 = hashMap;
        hashMap2.put("SemesterRegistration[semester_id]", this$0.sem);
        hashMap2.put("SemesterRegistration[department_due]", this$0.dept);
        Editable editable = null;
        if (Intrinsics.areEqual(this$0.dept, "Yes")) {
            DialogChristSemRegBinding dialogChristSemRegBinding = this$0.get_binding();
            hashMap2.put("SemesterRegistration[department_due_details]", String.valueOf((dialogChristSemRegBinding == null || (textInputEditText6 = dialogChristSemRegBinding.etDeptDetails) == null) ? null : textInputEditText6.getText()));
        } else {
            hashMap2.put("SemesterRegistration[department_due_details]", "");
        }
        hashMap2.put("SemesterRegistration[library_due]", this$0.library);
        if (Intrinsics.areEqual(this$0.library, "Yes")) {
            DialogChristSemRegBinding dialogChristSemRegBinding2 = this$0.get_binding();
            hashMap2.put("SemesterRegistration[librarary_due_details]", String.valueOf((dialogChristSemRegBinding2 == null || (textInputEditText5 = dialogChristSemRegBinding2.etLibraryDetails) == null) ? null : textInputEditText5.getText()));
        } else {
            hashMap2.put("SemesterRegistration[librarary_due_details]", "");
        }
        hashMap2.put("SemesterRegistration[accounts_due]", this$0.accounts);
        if (Intrinsics.areEqual(this$0.accounts, "Yes")) {
            DialogChristSemRegBinding dialogChristSemRegBinding3 = this$0.get_binding();
            hashMap2.put("SemesterRegistration[accounts_due_details]", String.valueOf((dialogChristSemRegBinding3 == null || (textInputEditText4 = dialogChristSemRegBinding3.etAccountsDetails) == null) ? null : textInputEditText4.getText()));
        } else {
            hashMap2.put("SemesterRegistration[accounts_due_details]", "");
        }
        hashMap2.put("SemesterRegistration[academic_due]", this$0.academics);
        if (Intrinsics.areEqual(this$0.academics, "Yes")) {
            DialogChristSemRegBinding dialogChristSemRegBinding4 = this$0.get_binding();
            hashMap2.put("SemesterRegistration[academic_due_details]", String.valueOf((dialogChristSemRegBinding4 == null || (textInputEditText3 = dialogChristSemRegBinding4.etAcademicDetails) == null) ? null : textInputEditText3.getText()));
        } else {
            hashMap2.put("SemesterRegistration[academic_due_details]", "");
        }
        hashMap2.put("SemesterRegistration[hostel_due]", this$0.hostel);
        if (Intrinsics.areEqual(this$0.hostel, "Yes")) {
            DialogChristSemRegBinding dialogChristSemRegBinding5 = this$0.get_binding();
            hashMap2.put("SemesterRegistration[hostel_due_details]", String.valueOf((dialogChristSemRegBinding5 == null || (textInputEditText2 = dialogChristSemRegBinding5.etHostelDetails) == null) ? null : textInputEditText2.getText()));
        } else {
            hashMap2.put("SemesterRegistration[hostel_due_details]", "");
        }
        hashMap2.put("SemesterRegistration[bus_due]", this$0.bus);
        if (Intrinsics.areEqual(this$0.bus, "Yes")) {
            DialogChristSemRegBinding dialogChristSemRegBinding6 = this$0.get_binding();
            if (dialogChristSemRegBinding6 != null && (textInputEditText = dialogChristSemRegBinding6.etBusDetails) != null) {
                editable = textInputEditText.getText();
            }
            hashMap2.put("SemesterRegistration[bus_due_details]", String.valueOf(editable));
        } else {
            hashMap2.put("SemesterRegistration[bus_due_details]", "");
        }
        this$0.getChristSemRegViewModel().getAddData(hashMap2);
    }

    private final void listenAddResponse() {
        getChristSemRegViewModel().getResponse().observe(getViewLifecycleOwner(), new ChristSemRegDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends SemRegSuccessResponse>, Unit>() { // from class: in.etuwa.app.ui.semregistration.christ.ChristSemRegDialog$listenAddResponse$1

            /* compiled from: ChristSemRegDialog.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends SemRegSuccessResponse> resource) {
                invoke2((Resource<SemRegSuccessResponse>) resource);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<SemRegSuccessResponse> resource) {
                DialogChristSemRegBinding dialogChristSemRegBinding;
                TextView registerBtn;
                DialogChristSemRegBinding dialogChristSemRegBinding2;
                TextView registerBtn2;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        ChristSemRegDialog.this.showProgress();
                        return;
                    } else if (i == 3) {
                        ChristSemRegDialog.this.hideProgress();
                        return;
                    } else {
                        if (i != 4) {
                            return;
                        }
                        ChristSemRegDialog.this.hideProgress();
                        return;
                    }
                }
                ChristSemRegDialog.this.hideProgress();
                SemRegSuccessResponse data = resource.getData();
                if (data != null) {
                    ChristSemRegDialog christSemRegDialog = ChristSemRegDialog.this;
                    if (!data.getSuccess() || !data.getLogin()) {
                        dialogChristSemRegBinding = christSemRegDialog.get_binding();
                        if (dialogChristSemRegBinding == null || (registerBtn = dialogChristSemRegBinding.registerBtn) == null) {
                            return;
                        }
                        Intrinsics.checkNotNullExpressionValue(registerBtn, "registerBtn");
                        ToastExtKt.showErrorToast(registerBtn, "Something Went Wrong");
                        return;
                    }
                    dialogChristSemRegBinding2 = christSemRegDialog.get_binding();
                    if (dialogChristSemRegBinding2 == null || (registerBtn2 = dialogChristSemRegBinding2.registerBtn) == null) {
                        return;
                    }
                    Intrinsics.checkNotNullExpressionValue(registerBtn2, "registerBtn");
                    ToastExtKt.showSuccessToast(registerBtn2, data.getMessage());
                }
            }
        }));
    }

    private final void listenSemResponse() {
        getChristSemRegViewModel().getSemResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.semregistration.christ.ChristSemRegDialog$$ExternalSyntheticLambda9
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ChristSemRegDialog.listenSemResponse$lambda$10(ChristSemRegDialog.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenSemResponse$lambda$10(ChristSemRegDialog this$0, Resource resource) {
        Spinner spinner;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i != 1) {
            if (i == 3) {
                this$0.hideProgress();
                return;
            } else {
                if (i != 4) {
                    return;
                }
                this$0.hideProgress();
                return;
            }
        }
        this$0.hideProgress();
        ArrayList<Semester> arrayList = (ArrayList) resource.getData();
        if (arrayList != null) {
            this$0.getSpinnerSem().addItems(arrayList);
            int count = this$0.getSpinnerSem().getCount();
            for (int i2 = 0; i2 < count; i2++) {
                if (Intrinsics.areEqual(this$0.getPreference().getUserSemId(), this$0.getSpinnerSem().getSemester(i2).getId())) {
                    DialogChristSemRegBinding dialogChristSemRegBinding = this$0.get_binding();
                    if (dialogChristSemRegBinding == null || (spinner = dialogChristSemRegBinding.spinnerSemesterLastAttended) == null) {
                        return;
                    }
                    spinner.setSelection(i2);
                    return;
                }
            }
        }
    }

    public final void setCallBack(SemRegisterListFragment context) {
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