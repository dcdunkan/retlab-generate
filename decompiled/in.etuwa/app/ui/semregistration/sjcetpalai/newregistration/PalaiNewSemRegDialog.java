package in.etuwa.app.ui.semregistration.sjcetpalai.newregistration;

import android.app.DatePickerDialog;
import android.content.ComponentCallbacks;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.EditText;
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
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.counselling.status.CounsellingStatusResponse;
import in.etuwa.app.databinding.DialogPalaiSemRegBinding;
import in.etuwa.app.ui.base.BaseDialog;
import in.etuwa.app.ui.counselling.add.CounsellingStatusSpinnerAdapter;
import in.etuwa.app.ui.counselling.add.CounsellingTypeSpinnerAdapter;
import in.etuwa.app.ui.semregistration.sjcetpalai.PalaiSemesterRegFragment;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
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
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.parameter.ParametersHolderKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: PalaiNewSemRegDialog.kt */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 U2\u00020\u0001:\u0002TUB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010=\u001a\u00020>H\u0014J\b\u0010?\u001a\u00020>H\u0002J&\u0010@\u001a\u0004\u0018\u00010A2\u0006\u0010B\u001a\u00020C2\b\u0010D\u001a\u0004\u0018\u00010E2\b\u0010F\u001a\u0004\u0018\u00010GH\u0016J\b\u0010H\u001a\u00020>H\u0016J\b\u0010I\u001a\u00020>H\u0016J\u0010\u0010J\u001a\u00020>2\u0006\u0010K\u001a\u00020LH\u0016J\u001a\u0010M\u001a\u00020>2\u0006\u0010N\u001a\u00020A2\b\u0010F\u001a\u0004\u0018\u00010GH\u0016J\u000e\u0010O\u001a\u00020>2\u0006\u0010P\u001a\u00020QJ\b\u0010R\u001a\u00020>H\u0014J\b\u0010S\u001a\u00020>H\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010%\u001a\u00020&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b'\u0010(R\u000e\u0010+\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010/\u001a\u0002008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u0010*\u001a\u0004\b1\u00102R\u001b\u00104\u001a\u0002008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u0010*\u001a\u0004\b5\u00102R\u001b\u00107\u001a\u0002088BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b;\u0010*\u001a\u0004\b9\u0010:R\u000e\u0010<\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006V"}, d2 = {"Lin/etuwa/app/ui/semregistration/sjcetpalai/newregistration/PalaiNewSemRegDialog;", "Lin/etuwa/app/ui/base/BaseDialog;", "()V", "_binding", "Lin/etuwa/app/databinding/DialogPalaiSemRegBinding;", "academics", "", "academicsDetails", "accounts", "accountsDetails", "back", "backDetails", "binding", "getBinding", "()Lin/etuwa/app/databinding/DialogPalaiSemRegBinding;", "bus", "busDetails", "cgpaClicked", "", "dept", "deptDetails", "dueClicked", "examAttClicked", "feeClicked", "feeConcession", "finalPage", "globalElectiveClicked", "honor", "honorMinorClicked", "hostel", "hostelDetails", "id", "library", "libraryDetails", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/semregistration/sjcetpalai/newregistration/PalaiNewSemRegDialog$AddCounsellingListener;", "minor", "palaiNewSemRegViewModel", "Lin/etuwa/app/ui/semregistration/sjcetpalai/newregistration/PalaiNewSemRegViewModel;", "getPalaiNewSemRegViewModel", "()Lin/etuwa/app/ui/semregistration/sjcetpalai/newregistration/PalaiNewSemRegViewModel;", "palaiNewSemRegViewModel$delegate", "Lkotlin/Lazy;", "prevSemClicked", "reg", "regDetails", "sem", "spinnerBackPaper", "Lin/etuwa/app/ui/counselling/add/CounsellingStatusSpinnerAdapter;", "getSpinnerBackPaper", "()Lin/etuwa/app/ui/counselling/add/CounsellingStatusSpinnerAdapter;", "spinnerBackPaper$delegate", "spinnerRegistered", "getSpinnerRegistered", "spinnerRegistered$delegate", "spinnerSem", "Lin/etuwa/app/ui/counselling/add/CounsellingTypeSpinnerAdapter;", "getSpinnerSem", "()Lin/etuwa/app/ui/counselling/add/CounsellingTypeSpinnerAdapter;", "spinnerSem$delegate", "supplyClicked", "hideProgress", "", "listenSpinner2", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onDetach", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onViewCreated", SvgConstants.Tags.VIEW, "setCallBack", "context", "Lin/etuwa/app/ui/semregistration/sjcetpalai/PalaiSemesterRegFragment;", "setUp", "showProgress", "AddCounsellingListener", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PalaiNewSemRegDialog extends BaseDialog {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private DialogPalaiSemRegBinding _binding;
    private String academics;
    private String academicsDetails;
    private String accounts;
    private String accountsDetails;
    private String back;
    private String backDetails;
    private String bus;
    private String busDetails;
    private boolean cgpaClicked;
    private String dept;
    private String deptDetails;
    private boolean dueClicked;
    private boolean examAttClicked;
    private boolean feeClicked;
    private String feeConcession;
    private boolean finalPage;
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

    /* renamed from: palaiNewSemRegViewModel$delegate, reason: from kotlin metadata */
    private final Lazy palaiNewSemRegViewModel;
    private boolean prevSemClicked;
    private String reg;
    private String regDetails;
    private String sem;

    /* renamed from: spinnerBackPaper$delegate, reason: from kotlin metadata */
    private final Lazy spinnerBackPaper;

    /* renamed from: spinnerRegistered$delegate, reason: from kotlin metadata */
    private final Lazy spinnerRegistered;

    /* renamed from: spinnerSem$delegate, reason: from kotlin metadata */
    private final Lazy spinnerSem;
    private boolean supplyClicked;

    /* compiled from: PalaiNewSemRegDialog.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lin/etuwa/app/ui/semregistration/sjcetpalai/newregistration/PalaiNewSemRegDialog$AddCounsellingListener;", "", "dismiss", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface AddCounsellingListener {
        void dismiss();
    }

    @JvmStatic
    public static final PalaiNewSemRegDialog newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void showProgress() {
    }

    public PalaiNewSemRegDialog() {
        final PalaiNewSemRegDialog palaiNewSemRegDialog = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.semregistration.sjcetpalai.newregistration.PalaiNewSemRegDialog$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(palaiNewSemRegDialog);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.palaiNewSemRegViewModel = FragmentViewModelLazyKt.createViewModelLazy(palaiNewSemRegDialog, Reflection.getOrCreateKotlinClass(PalaiNewSemRegViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.semregistration.sjcetpalai.newregistration.PalaiNewSemRegDialog$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.semregistration.sjcetpalai.newregistration.PalaiNewSemRegDialog$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(PalaiNewSemRegViewModel.class), qualifier, b, null, koinScope);
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
        final PalaiNewSemRegDialog palaiNewSemRegDialog2 = this;
        final Function0<ParametersHolder> function02 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.semregistration.sjcetpalai.newregistration.PalaiNewSemRegDialog$spinnerSem$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(PalaiNewSemRegDialog.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        this.spinnerSem = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<CounsellingTypeSpinnerAdapter>() { // from class: in.etuwa.app.ui.semregistration.sjcetpalai.newregistration.PalaiNewSemRegDialog$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.counselling.add.CounsellingTypeSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final CounsellingTypeSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = palaiNewSemRegDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(CounsellingTypeSpinnerAdapter.class), b2, function02);
            }
        });
        final Function0<ParametersHolder> function03 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.semregistration.sjcetpalai.newregistration.PalaiNewSemRegDialog$spinnerRegistered$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(PalaiNewSemRegDialog.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b3 = 0 == true ? 1 : 0;
        this.spinnerRegistered = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<CounsellingStatusSpinnerAdapter>() { // from class: in.etuwa.app.ui.semregistration.sjcetpalai.newregistration.PalaiNewSemRegDialog$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.counselling.add.CounsellingStatusSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final CounsellingStatusSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = palaiNewSemRegDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(CounsellingStatusSpinnerAdapter.class), b3, function03);
            }
        });
        final Function0<ParametersHolder> function04 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.semregistration.sjcetpalai.newregistration.PalaiNewSemRegDialog$spinnerBackPaper$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(PalaiNewSemRegDialog.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode3 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        this.spinnerBackPaper = LazyKt.lazy(lazyThreadSafetyMode3, (Function0) new Function0<CounsellingStatusSpinnerAdapter>() { // from class: in.etuwa.app.ui.semregistration.sjcetpalai.newregistration.PalaiNewSemRegDialog$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.counselling.add.CounsellingStatusSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final CounsellingStatusSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = palaiNewSemRegDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(CounsellingStatusSpinnerAdapter.class), b4, function04);
            }
        });
    }

    private final PalaiNewSemRegViewModel getPalaiNewSemRegViewModel() {
        return (PalaiNewSemRegViewModel) this.palaiNewSemRegViewModel.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final DialogPalaiSemRegBinding get_binding() {
        return this._binding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CounsellingTypeSpinnerAdapter getSpinnerSem() {
        return (CounsellingTypeSpinnerAdapter) this.spinnerSem.getValue();
    }

    private final CounsellingStatusSpinnerAdapter getSpinnerRegistered() {
        return (CounsellingStatusSpinnerAdapter) this.spinnerRegistered.getValue();
    }

    private final CounsellingStatusSpinnerAdapter getSpinnerBackPaper() {
        return (CounsellingStatusSpinnerAdapter) this.spinnerBackPaper.getValue();
    }

    /* compiled from: PalaiNewSemRegDialog.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/semregistration/sjcetpalai/newregistration/PalaiNewSemRegDialog$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/semregistration/sjcetpalai/newregistration/PalaiNewSemRegDialog;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final PalaiNewSemRegDialog newInstance() {
            return new PalaiNewSemRegDialog();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = DialogPalaiSemRegBinding.inflate(inflater, container, false);
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding = get_binding();
        if (dialogPalaiSemRegBinding != null) {
            dialogPalaiSemRegBinding.setPalaiNewSemRegViewModel(getPalaiNewSemRegViewModel());
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding2 = get_binding();
        if (dialogPalaiSemRegBinding2 != null) {
            dialogPalaiSemRegBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding3 = get_binding();
        if (dialogPalaiSemRegBinding3 != null) {
            return dialogPalaiSemRegBinding3.getRoot();
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
        TextView textView4;
        TextView textView5;
        TextView textView6;
        TextView textView7;
        TextView textView8;
        TextView textView9;
        RadioGroup radioGroup;
        RadioGroup radioGroup2;
        RadioGroup radioGroup3;
        RadioGroup radioGroup4;
        RadioGroup radioGroup5;
        RadioGroup radioGroup6;
        RadioGroup radioGroup7;
        RadioGroup radioGroup8;
        RadioGroup radioGroup9;
        RadioGroup radioGroup10;
        RadioGroup radioGroup11;
        RadioGroup radioGroup12;
        TextView textView10;
        TextView textView11;
        TextView textView12;
        TextView textView13;
        TextView textView14;
        TextView textView15;
        TextView textView16;
        EditText editText;
        TextView textView17;
        TextView textView18;
        TextView textView19;
        TextView textView20;
        TextView textView21;
        TextView textView22;
        TextView textView23;
        TextView textView24;
        TextView textView25;
        TextView textView26;
        TextView textView27;
        TextView textView28;
        TextView textView29;
        TextView textView30;
        TextView textView31;
        Calendar calendar = Calendar.getInstance();
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = calendar.get(1);
        final Ref.IntRef intRef2 = new Ref.IntRef();
        intRef2.element = calendar.get(2);
        final Ref.IntRef intRef3 = new Ref.IntRef();
        intRef3.element = calendar.get(5);
        listenSpinner2();
        getPalaiNewSemRegViewModel().getSemRegStatus();
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding = get_binding();
        Spinner spinner = dialogPalaiSemRegBinding != null ? dialogPalaiSemRegBinding.spinnerSemesterLastAttended : null;
        if (spinner != null) {
            spinner.setAdapter((SpinnerAdapter) getSpinnerSem());
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding2 = get_binding();
        if (dialogPalaiSemRegBinding2 != null && (textView31 = dialogPalaiSemRegBinding2.nextOne) != null) {
            textView31.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.sjcetpalai.newregistration.PalaiNewSemRegDialog$$ExternalSyntheticLambda48
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PalaiNewSemRegDialog.setUp$lambda$0(PalaiNewSemRegDialog.this, view);
                }
            });
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding3 = get_binding();
        if (dialogPalaiSemRegBinding3 != null && (textView30 = dialogPalaiSemRegBinding3.backTwo) != null) {
            textView30.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.sjcetpalai.newregistration.PalaiNewSemRegDialog$$ExternalSyntheticLambda8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PalaiNewSemRegDialog.setUp$lambda$1(PalaiNewSemRegDialog.this, view);
                }
            });
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding4 = get_binding();
        if (dialogPalaiSemRegBinding4 != null && (textView29 = dialogPalaiSemRegBinding4.backThree) != null) {
            textView29.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.sjcetpalai.newregistration.PalaiNewSemRegDialog$$ExternalSyntheticLambda20
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PalaiNewSemRegDialog.setUp$lambda$2(PalaiNewSemRegDialog.this, view);
                }
            });
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding5 = get_binding();
        if (dialogPalaiSemRegBinding5 != null && (textView28 = dialogPalaiSemRegBinding5.nextTwo) != null) {
            textView28.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.sjcetpalai.newregistration.PalaiNewSemRegDialog$$ExternalSyntheticLambda32
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PalaiNewSemRegDialog.setUp$lambda$3(PalaiNewSemRegDialog.this, view);
                }
            });
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding6 = get_binding();
        if (dialogPalaiSemRegBinding6 != null && (textView27 = dialogPalaiSemRegBinding6.nextThree) != null) {
            textView27.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.sjcetpalai.newregistration.PalaiNewSemRegDialog$$ExternalSyntheticLambda38
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PalaiNewSemRegDialog.setUp$lambda$4(PalaiNewSemRegDialog.this, view);
                }
            });
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding7 = get_binding();
        if (dialogPalaiSemRegBinding7 != null && (textView26 = dialogPalaiSemRegBinding7.backFour) != null) {
            textView26.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.sjcetpalai.newregistration.PalaiNewSemRegDialog$$ExternalSyntheticLambda39
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PalaiNewSemRegDialog.setUp$lambda$5(PalaiNewSemRegDialog.this, view);
                }
            });
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding8 = get_binding();
        if (dialogPalaiSemRegBinding8 != null && (textView25 = dialogPalaiSemRegBinding8.nextFour) != null) {
            textView25.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.sjcetpalai.newregistration.PalaiNewSemRegDialog$$ExternalSyntheticLambda40
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PalaiNewSemRegDialog.setUp$lambda$6(PalaiNewSemRegDialog.this, view);
                }
            });
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding9 = get_binding();
        if (dialogPalaiSemRegBinding9 != null && (textView24 = dialogPalaiSemRegBinding9.backFive) != null) {
            textView24.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.sjcetpalai.newregistration.PalaiNewSemRegDialog$$ExternalSyntheticLambda41
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PalaiNewSemRegDialog.setUp$lambda$7(PalaiNewSemRegDialog.this, view);
                }
            });
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding10 = get_binding();
        if (dialogPalaiSemRegBinding10 != null && (textView23 = dialogPalaiSemRegBinding10.nextFive) != null) {
            textView23.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.sjcetpalai.newregistration.PalaiNewSemRegDialog$$ExternalSyntheticLambda42
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PalaiNewSemRegDialog.setUp$lambda$8(PalaiNewSemRegDialog.this, view);
                }
            });
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding11 = get_binding();
        if (dialogPalaiSemRegBinding11 != null && (textView22 = dialogPalaiSemRegBinding11.backSix) != null) {
            textView22.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.sjcetpalai.newregistration.PalaiNewSemRegDialog$$ExternalSyntheticLambda43
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PalaiNewSemRegDialog.setUp$lambda$9(PalaiNewSemRegDialog.this, view);
                }
            });
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding12 = get_binding();
        if (dialogPalaiSemRegBinding12 != null && (textView21 = dialogPalaiSemRegBinding12.nextSix) != null) {
            textView21.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.sjcetpalai.newregistration.PalaiNewSemRegDialog$$ExternalSyntheticLambda49
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PalaiNewSemRegDialog.setUp$lambda$10(PalaiNewSemRegDialog.this, view);
                }
            });
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding13 = get_binding();
        if (dialogPalaiSemRegBinding13 != null && (textView20 = dialogPalaiSemRegBinding13.nextSeven) != null) {
            textView20.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.sjcetpalai.newregistration.PalaiNewSemRegDialog$$ExternalSyntheticLambda50
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PalaiNewSemRegDialog.setUp$lambda$11(PalaiNewSemRegDialog.this, view);
                }
            });
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding14 = get_binding();
        if (dialogPalaiSemRegBinding14 != null && (textView19 = dialogPalaiSemRegBinding14.backSeven) != null) {
            textView19.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.sjcetpalai.newregistration.PalaiNewSemRegDialog$$ExternalSyntheticLambda51
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PalaiNewSemRegDialog.setUp$lambda$12(PalaiNewSemRegDialog.this, view);
                }
            });
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding15 = get_binding();
        if (dialogPalaiSemRegBinding15 != null && (textView18 = dialogPalaiSemRegBinding15.backEight) != null) {
            textView18.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.sjcetpalai.newregistration.PalaiNewSemRegDialog$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PalaiNewSemRegDialog.setUp$lambda$13(PalaiNewSemRegDialog.this, view);
                }
            });
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding16 = get_binding();
        if (dialogPalaiSemRegBinding16 != null && (textView17 = dialogPalaiSemRegBinding16.nextEight) != null) {
            textView17.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.sjcetpalai.newregistration.PalaiNewSemRegDialog$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PalaiNewSemRegDialog.setUp$lambda$14(PalaiNewSemRegDialog.this, view);
                }
            });
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding17 = get_binding();
        if (dialogPalaiSemRegBinding17 != null && (editText = dialogPalaiSemRegBinding17.semDateOne) != null) {
            editText.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.sjcetpalai.newregistration.PalaiNewSemRegDialog$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PalaiNewSemRegDialog.setUp$lambda$16(PalaiNewSemRegDialog.this, intRef, intRef2, intRef3, view);
                }
            });
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding18 = get_binding();
        if (dialogPalaiSemRegBinding18 != null && (textView16 = dialogPalaiSemRegBinding18.semDateTwo) != null) {
            textView16.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.sjcetpalai.newregistration.PalaiNewSemRegDialog$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PalaiNewSemRegDialog.setUp$lambda$18(PalaiNewSemRegDialog.this, intRef, intRef2, intRef3, view);
                }
            });
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding19 = get_binding();
        if (dialogPalaiSemRegBinding19 != null && (textView15 = dialogPalaiSemRegBinding19.semDateThree) != null) {
            textView15.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.sjcetpalai.newregistration.PalaiNewSemRegDialog$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PalaiNewSemRegDialog.setUp$lambda$20(PalaiNewSemRegDialog.this, intRef, intRef2, intRef3, view);
                }
            });
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding20 = get_binding();
        if (dialogPalaiSemRegBinding20 != null && (textView14 = dialogPalaiSemRegBinding20.semDateFour) != null) {
            textView14.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.sjcetpalai.newregistration.PalaiNewSemRegDialog$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PalaiNewSemRegDialog.setUp$lambda$22(PalaiNewSemRegDialog.this, intRef, intRef2, intRef3, view);
                }
            });
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding21 = get_binding();
        if (dialogPalaiSemRegBinding21 != null && (textView13 = dialogPalaiSemRegBinding21.semDateFive) != null) {
            textView13.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.sjcetpalai.newregistration.PalaiNewSemRegDialog$$ExternalSyntheticLambda7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PalaiNewSemRegDialog.setUp$lambda$24(PalaiNewSemRegDialog.this, intRef, intRef2, intRef3, view);
                }
            });
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding22 = get_binding();
        if (dialogPalaiSemRegBinding22 != null && (textView12 = dialogPalaiSemRegBinding22.semDateSix) != null) {
            textView12.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.sjcetpalai.newregistration.PalaiNewSemRegDialog$$ExternalSyntheticLambda9
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PalaiNewSemRegDialog.setUp$lambda$26(PalaiNewSemRegDialog.this, intRef, intRef2, intRef3, view);
                }
            });
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding23 = get_binding();
        if (dialogPalaiSemRegBinding23 != null && (textView11 = dialogPalaiSemRegBinding23.semDateSeven) != null) {
            textView11.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.sjcetpalai.newregistration.PalaiNewSemRegDialog$$ExternalSyntheticLambda10
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PalaiNewSemRegDialog.setUp$lambda$28(PalaiNewSemRegDialog.this, intRef, intRef2, intRef3, view);
                }
            });
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding24 = get_binding();
        if (dialogPalaiSemRegBinding24 != null && (textView10 = dialogPalaiSemRegBinding24.semDateEight) != null) {
            textView10.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.sjcetpalai.newregistration.PalaiNewSemRegDialog$$ExternalSyntheticLambda12
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PalaiNewSemRegDialog.setUp$lambda$30(PalaiNewSemRegDialog.this, intRef, intRef2, intRef3, view);
                }
            });
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding25 = get_binding();
        if (dialogPalaiSemRegBinding25 != null && (radioGroup12 = dialogPalaiSemRegBinding25.examGroup) != null) {
            radioGroup12.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.etuwa.app.ui.semregistration.sjcetpalai.newregistration.PalaiNewSemRegDialog$$ExternalSyntheticLambda13
                @Override // android.widget.RadioGroup.OnCheckedChangeListener
                public final void onCheckedChanged(RadioGroup radioGroup13, int i) {
                    PalaiNewSemRegDialog.setUp$lambda$31(PalaiNewSemRegDialog.this, radioGroup13, i);
                }
            });
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding26 = get_binding();
        if (dialogPalaiSemRegBinding26 != null && (radioGroup11 = dialogPalaiSemRegBinding26.busDue) != null) {
            radioGroup11.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.etuwa.app.ui.semregistration.sjcetpalai.newregistration.PalaiNewSemRegDialog$$ExternalSyntheticLambda14
                @Override // android.widget.RadioGroup.OnCheckedChangeListener
                public final void onCheckedChanged(RadioGroup radioGroup13, int i) {
                    PalaiNewSemRegDialog.setUp$lambda$32(PalaiNewSemRegDialog.this, radioGroup13, i);
                }
            });
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding27 = get_binding();
        if (dialogPalaiSemRegBinding27 != null && (radioGroup10 = dialogPalaiSemRegBinding27.feeDue) != null) {
            radioGroup10.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.etuwa.app.ui.semregistration.sjcetpalai.newregistration.PalaiNewSemRegDialog$$ExternalSyntheticLambda15
                @Override // android.widget.RadioGroup.OnCheckedChangeListener
                public final void onCheckedChanged(RadioGroup radioGroup13, int i) {
                    PalaiNewSemRegDialog.setUp$lambda$33(PalaiNewSemRegDialog.this, radioGroup13, i);
                }
            });
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding28 = get_binding();
        if (dialogPalaiSemRegBinding28 != null && (radioGroup9 = dialogPalaiSemRegBinding28.examGroup) != null) {
            radioGroup9.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.etuwa.app.ui.semregistration.sjcetpalai.newregistration.PalaiNewSemRegDialog$$ExternalSyntheticLambda16
                @Override // android.widget.RadioGroup.OnCheckedChangeListener
                public final void onCheckedChanged(RadioGroup radioGroup13, int i) {
                    PalaiNewSemRegDialog.setUp$lambda$34(PalaiNewSemRegDialog.this, radioGroup13, i);
                }
            });
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding29 = get_binding();
        if (dialogPalaiSemRegBinding29 != null && (radioGroup8 = dialogPalaiSemRegBinding29.busDue) != null) {
            radioGroup8.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.etuwa.app.ui.semregistration.sjcetpalai.newregistration.PalaiNewSemRegDialog$$ExternalSyntheticLambda17
                @Override // android.widget.RadioGroup.OnCheckedChangeListener
                public final void onCheckedChanged(RadioGroup radioGroup13, int i) {
                    PalaiNewSemRegDialog.setUp$lambda$35(PalaiNewSemRegDialog.this, radioGroup13, i);
                }
            });
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding30 = get_binding();
        if (dialogPalaiSemRegBinding30 != null && (radioGroup7 = dialogPalaiSemRegBinding30.backGroup) != null) {
            radioGroup7.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.etuwa.app.ui.semregistration.sjcetpalai.newregistration.PalaiNewSemRegDialog$$ExternalSyntheticLambda18
                @Override // android.widget.RadioGroup.OnCheckedChangeListener
                public final void onCheckedChanged(RadioGroup radioGroup13, int i) {
                    PalaiNewSemRegDialog.setUp$lambda$36(PalaiNewSemRegDialog.this, radioGroup13, i);
                }
            });
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding31 = get_binding();
        if (dialogPalaiSemRegBinding31 != null && (radioGroup6 = dialogPalaiSemRegBinding31.departmentDue) != null) {
            radioGroup6.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.etuwa.app.ui.semregistration.sjcetpalai.newregistration.PalaiNewSemRegDialog$$ExternalSyntheticLambda19
                @Override // android.widget.RadioGroup.OnCheckedChangeListener
                public final void onCheckedChanged(RadioGroup radioGroup13, int i) {
                    PalaiNewSemRegDialog.setUp$lambda$37(PalaiNewSemRegDialog.this, radioGroup13, i);
                }
            });
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding32 = get_binding();
        if (dialogPalaiSemRegBinding32 != null && (radioGroup5 = dialogPalaiSemRegBinding32.concessionBtn) != null) {
            radioGroup5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.etuwa.app.ui.semregistration.sjcetpalai.newregistration.PalaiNewSemRegDialog$$ExternalSyntheticLambda21
                @Override // android.widget.RadioGroup.OnCheckedChangeListener
                public final void onCheckedChanged(RadioGroup radioGroup13, int i) {
                    PalaiNewSemRegDialog.setUp$lambda$38(PalaiNewSemRegDialog.this, radioGroup13, i);
                }
            });
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding33 = get_binding();
        if (dialogPalaiSemRegBinding33 != null && (radioGroup4 = dialogPalaiSemRegBinding33.academicDue) != null) {
            radioGroup4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.etuwa.app.ui.semregistration.sjcetpalai.newregistration.PalaiNewSemRegDialog$$ExternalSyntheticLambda23
                @Override // android.widget.RadioGroup.OnCheckedChangeListener
                public final void onCheckedChanged(RadioGroup radioGroup13, int i) {
                    PalaiNewSemRegDialog.setUp$lambda$39(PalaiNewSemRegDialog.this, radioGroup13, i);
                }
            });
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding34 = get_binding();
        if (dialogPalaiSemRegBinding34 != null && (radioGroup3 = dialogPalaiSemRegBinding34.accountsDue) != null) {
            radioGroup3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.etuwa.app.ui.semregistration.sjcetpalai.newregistration.PalaiNewSemRegDialog$$ExternalSyntheticLambda24
                @Override // android.widget.RadioGroup.OnCheckedChangeListener
                public final void onCheckedChanged(RadioGroup radioGroup13, int i) {
                    PalaiNewSemRegDialog.setUp$lambda$40(PalaiNewSemRegDialog.this, radioGroup13, i);
                }
            });
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding35 = get_binding();
        if (dialogPalaiSemRegBinding35 != null && (radioGroup2 = dialogPalaiSemRegBinding35.libraryDue) != null) {
            radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.etuwa.app.ui.semregistration.sjcetpalai.newregistration.PalaiNewSemRegDialog$$ExternalSyntheticLambda25
                @Override // android.widget.RadioGroup.OnCheckedChangeListener
                public final void onCheckedChanged(RadioGroup radioGroup13, int i) {
                    PalaiNewSemRegDialog.setUp$lambda$41(PalaiNewSemRegDialog.this, radioGroup13, i);
                }
            });
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding36 = get_binding();
        if (dialogPalaiSemRegBinding36 != null && (radioGroup = dialogPalaiSemRegBinding36.hostelDue) != null) {
            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.etuwa.app.ui.semregistration.sjcetpalai.newregistration.PalaiNewSemRegDialog$$ExternalSyntheticLambda26
                @Override // android.widget.RadioGroup.OnCheckedChangeListener
                public final void onCheckedChanged(RadioGroup radioGroup13, int i) {
                    PalaiNewSemRegDialog.setUp$lambda$42(PalaiNewSemRegDialog.this, radioGroup13, i);
                }
            });
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding37 = get_binding();
        Spinner spinner2 = dialogPalaiSemRegBinding37 != null ? dialogPalaiSemRegBinding37.spinnerSemesterLastAttended : null;
        if (spinner2 != null) {
            spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.semregistration.sjcetpalai.newregistration.PalaiNewSemRegDialog$setUp$36
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    CounsellingTypeSpinnerAdapter spinnerSem;
                    PalaiNewSemRegDialog palaiNewSemRegDialog = PalaiNewSemRegDialog.this;
                    spinnerSem = palaiNewSemRegDialog.getSpinnerSem();
                    palaiNewSemRegDialog.sem = spinnerSem.getType(position).getId();
                }
            });
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding38 = get_binding();
        if (dialogPalaiSemRegBinding38 != null && (textView9 = dialogPalaiSemRegBinding38.examAttTv) != null) {
            textView9.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.sjcetpalai.newregistration.PalaiNewSemRegDialog$$ExternalSyntheticLambda27
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PalaiNewSemRegDialog.setUp$lambda$43(PalaiNewSemRegDialog.this, view);
                }
            });
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding39 = get_binding();
        if (dialogPalaiSemRegBinding39 != null && (textView8 = dialogPalaiSemRegBinding39.honorMinorTv) != null) {
            textView8.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.sjcetpalai.newregistration.PalaiNewSemRegDialog$$ExternalSyntheticLambda28
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PalaiNewSemRegDialog.setUp$lambda$44(PalaiNewSemRegDialog.this, view);
                }
            });
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding40 = get_binding();
        if (dialogPalaiSemRegBinding40 != null && (textView7 = dialogPalaiSemRegBinding40.globalElecTv) != null) {
            textView7.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.sjcetpalai.newregistration.PalaiNewSemRegDialog$$ExternalSyntheticLambda29
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PalaiNewSemRegDialog.setUp$lambda$45(PalaiNewSemRegDialog.this, view);
                }
            });
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding41 = get_binding();
        if (dialogPalaiSemRegBinding41 != null && (textView6 = dialogPalaiSemRegBinding41.sgpaCgpaTv) != null) {
            textView6.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.sjcetpalai.newregistration.PalaiNewSemRegDialog$$ExternalSyntheticLambda30
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PalaiNewSemRegDialog.setUp$lambda$46(PalaiNewSemRegDialog.this, view);
                }
            });
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding42 = get_binding();
        if (dialogPalaiSemRegBinding42 != null && (textView5 = dialogPalaiSemRegBinding42.supplyTv) != null) {
            textView5.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.sjcetpalai.newregistration.PalaiNewSemRegDialog$$ExternalSyntheticLambda31
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PalaiNewSemRegDialog.setUp$lambda$47(PalaiNewSemRegDialog.this, view);
                }
            });
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding43 = get_binding();
        if (dialogPalaiSemRegBinding43 != null && (textView4 = dialogPalaiSemRegBinding43.prevSemTv) != null) {
            textView4.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.sjcetpalai.newregistration.PalaiNewSemRegDialog$$ExternalSyntheticLambda34
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PalaiNewSemRegDialog.setUp$lambda$48(PalaiNewSemRegDialog.this, view);
                }
            });
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding44 = get_binding();
        if (dialogPalaiSemRegBinding44 != null && (textView3 = dialogPalaiSemRegBinding44.feeDetailsTv) != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.sjcetpalai.newregistration.PalaiNewSemRegDialog$$ExternalSyntheticLambda35
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PalaiNewSemRegDialog.setUp$lambda$49(PalaiNewSemRegDialog.this, view);
                }
            });
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding45 = get_binding();
        if (dialogPalaiSemRegBinding45 != null && (textView2 = dialogPalaiSemRegBinding45.dueTv) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.sjcetpalai.newregistration.PalaiNewSemRegDialog$$ExternalSyntheticLambda36
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PalaiNewSemRegDialog.setUp$lambda$50(PalaiNewSemRegDialog.this, view);
                }
            });
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding46 = get_binding();
        if (dialogPalaiSemRegBinding46 == null || (textView = dialogPalaiSemRegBinding46.registerBtn) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.semregistration.sjcetpalai.newregistration.PalaiNewSemRegDialog$$ExternalSyntheticLambda37
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PalaiNewSemRegDialog.setUp$lambda$51(PalaiNewSemRegDialog.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$0(PalaiNewSemRegDialog this$0, View view) {
        TextView textView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding = this$0.get_binding();
        LinearLayout linearLayout = dialogPalaiSemRegBinding != null ? dialogPalaiSemRegBinding.pageOne : null;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding2 = this$0.get_binding();
        LinearLayout linearLayout2 = dialogPalaiSemRegBinding2 != null ? dialogPalaiSemRegBinding2.pageTwo : null;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(0);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding3 = this$0.get_binding();
        LinearLayout linearLayout3 = dialogPalaiSemRegBinding3 != null ? dialogPalaiSemRegBinding3.pageThree : null;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding4 = this$0.get_binding();
        LinearLayout linearLayout4 = dialogPalaiSemRegBinding4 != null ? dialogPalaiSemRegBinding4.pageFour : null;
        if (linearLayout4 != null) {
            linearLayout4.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding5 = this$0.get_binding();
        LinearLayout linearLayout5 = dialogPalaiSemRegBinding5 != null ? dialogPalaiSemRegBinding5.pageFive : null;
        if (linearLayout5 != null) {
            linearLayout5.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding6 = this$0.get_binding();
        LinearLayout linearLayout6 = dialogPalaiSemRegBinding6 != null ? dialogPalaiSemRegBinding6.pageSix : null;
        if (linearLayout6 != null) {
            linearLayout6.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding7 = this$0.get_binding();
        LinearLayout linearLayout7 = dialogPalaiSemRegBinding7 != null ? dialogPalaiSemRegBinding7.pageSeven : null;
        if (linearLayout7 != null) {
            linearLayout7.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding8 = this$0.get_binding();
        LinearLayout linearLayout8 = dialogPalaiSemRegBinding8 != null ? dialogPalaiSemRegBinding8.pageEight : null;
        if (linearLayout8 != null) {
            linearLayout8.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding9 = this$0.get_binding();
        TextView textView2 = dialogPalaiSemRegBinding9 != null ? dialogPalaiSemRegBinding9.examAttTv : null;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding10 = this$0.get_binding();
        LinearLayout linearLayout9 = dialogPalaiSemRegBinding10 != null ? dialogPalaiSemRegBinding10.universityPreviousLayout : null;
        if (linearLayout9 != null) {
            linearLayout9.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding11 = this$0.get_binding();
        LinearLayout linearLayout10 = dialogPalaiSemRegBinding11 != null ? dialogPalaiSemRegBinding11.honorMinorLt : null;
        if (linearLayout10 != null) {
            linearLayout10.setVisibility(0);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding12 = this$0.get_binding();
        TextView textView3 = dialogPalaiSemRegBinding12 != null ? dialogPalaiSemRegBinding12.honorMinorTv : null;
        if (textView3 != null) {
            textView3.setVisibility(0);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding13 = this$0.get_binding();
        LinearLayout linearLayout11 = dialogPalaiSemRegBinding13 != null ? dialogPalaiSemRegBinding13.globalElecLt : null;
        if (linearLayout11 != null) {
            linearLayout11.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding14 = this$0.get_binding();
        TextView textView4 = dialogPalaiSemRegBinding14 != null ? dialogPalaiSemRegBinding14.globalElecTv : null;
        if (textView4 != null) {
            textView4.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding15 = this$0.get_binding();
        LinearLayout linearLayout12 = dialogPalaiSemRegBinding15 != null ? dialogPalaiSemRegBinding15.sgpaCgpaLt : null;
        if (linearLayout12 != null) {
            linearLayout12.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding16 = this$0.get_binding();
        TextView textView5 = dialogPalaiSemRegBinding16 != null ? dialogPalaiSemRegBinding16.sgpaCgpaTv : null;
        if (textView5 != null) {
            textView5.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding17 = this$0.get_binding();
        LinearLayout linearLayout13 = dialogPalaiSemRegBinding17 != null ? dialogPalaiSemRegBinding17.supplyLt : null;
        if (linearLayout13 != null) {
            linearLayout13.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding18 = this$0.get_binding();
        TextView textView6 = dialogPalaiSemRegBinding18 != null ? dialogPalaiSemRegBinding18.supplyTv : null;
        if (textView6 != null) {
            textView6.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding19 = this$0.get_binding();
        LinearLayout linearLayout14 = dialogPalaiSemRegBinding19 != null ? dialogPalaiSemRegBinding19.prevSemLt : null;
        if (linearLayout14 != null) {
            linearLayout14.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding20 = this$0.get_binding();
        TextView textView7 = dialogPalaiSemRegBinding20 != null ? dialogPalaiSemRegBinding20.prevSemTv : null;
        if (textView7 != null) {
            textView7.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding21 = this$0.get_binding();
        LinearLayout linearLayout15 = dialogPalaiSemRegBinding21 != null ? dialogPalaiSemRegBinding21.feeDetailsLt : null;
        if (linearLayout15 != null) {
            linearLayout15.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding22 = this$0.get_binding();
        TextView textView8 = dialogPalaiSemRegBinding22 != null ? dialogPalaiSemRegBinding22.feeDetailsTv : null;
        if (textView8 != null) {
            textView8.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding23 = this$0.get_binding();
        LinearLayout linearLayout16 = dialogPalaiSemRegBinding23 != null ? dialogPalaiSemRegBinding23.dueLt : null;
        if (linearLayout16 != null) {
            linearLayout16.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding24 = this$0.get_binding();
        TextView textView9 = dialogPalaiSemRegBinding24 != null ? dialogPalaiSemRegBinding24.dueTv : null;
        if (textView9 != null) {
            textView9.setVisibility(8);
        }
        if (this$0.finalPage) {
            DialogPalaiSemRegBinding dialogPalaiSemRegBinding25 = this$0.get_binding();
            textView = dialogPalaiSemRegBinding25 != null ? dialogPalaiSemRegBinding25.registerBtn : null;
            if (textView == null) {
                return;
            }
            textView.setVisibility(0);
            return;
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding26 = this$0.get_binding();
        textView = dialogPalaiSemRegBinding26 != null ? dialogPalaiSemRegBinding26.registerBtn : null;
        if (textView == null) {
            return;
        }
        textView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(PalaiNewSemRegDialog this$0, View view) {
        TextView textView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding = this$0.get_binding();
        LinearLayout linearLayout = dialogPalaiSemRegBinding != null ? dialogPalaiSemRegBinding.pageOne : null;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding2 = this$0.get_binding();
        LinearLayout linearLayout2 = dialogPalaiSemRegBinding2 != null ? dialogPalaiSemRegBinding2.pageTwo : null;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding3 = this$0.get_binding();
        LinearLayout linearLayout3 = dialogPalaiSemRegBinding3 != null ? dialogPalaiSemRegBinding3.pageThree : null;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding4 = this$0.get_binding();
        LinearLayout linearLayout4 = dialogPalaiSemRegBinding4 != null ? dialogPalaiSemRegBinding4.pageFour : null;
        if (linearLayout4 != null) {
            linearLayout4.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding5 = this$0.get_binding();
        LinearLayout linearLayout5 = dialogPalaiSemRegBinding5 != null ? dialogPalaiSemRegBinding5.pageFive : null;
        if (linearLayout5 != null) {
            linearLayout5.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding6 = this$0.get_binding();
        LinearLayout linearLayout6 = dialogPalaiSemRegBinding6 != null ? dialogPalaiSemRegBinding6.pageSix : null;
        if (linearLayout6 != null) {
            linearLayout6.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding7 = this$0.get_binding();
        LinearLayout linearLayout7 = dialogPalaiSemRegBinding7 != null ? dialogPalaiSemRegBinding7.pageSeven : null;
        if (linearLayout7 != null) {
            linearLayout7.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding8 = this$0.get_binding();
        LinearLayout linearLayout8 = dialogPalaiSemRegBinding8 != null ? dialogPalaiSemRegBinding8.pageEight : null;
        if (linearLayout8 != null) {
            linearLayout8.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding9 = this$0.get_binding();
        TextView textView2 = dialogPalaiSemRegBinding9 != null ? dialogPalaiSemRegBinding9.examAttTv : null;
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding10 = this$0.get_binding();
        LinearLayout linearLayout9 = dialogPalaiSemRegBinding10 != null ? dialogPalaiSemRegBinding10.universityPreviousLayout : null;
        if (linearLayout9 != null) {
            linearLayout9.setVisibility(0);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding11 = this$0.get_binding();
        LinearLayout linearLayout10 = dialogPalaiSemRegBinding11 != null ? dialogPalaiSemRegBinding11.honorMinorLt : null;
        if (linearLayout10 != null) {
            linearLayout10.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding12 = this$0.get_binding();
        TextView textView3 = dialogPalaiSemRegBinding12 != null ? dialogPalaiSemRegBinding12.honorMinorTv : null;
        if (textView3 != null) {
            textView3.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding13 = this$0.get_binding();
        LinearLayout linearLayout11 = dialogPalaiSemRegBinding13 != null ? dialogPalaiSemRegBinding13.globalElecLt : null;
        if (linearLayout11 != null) {
            linearLayout11.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding14 = this$0.get_binding();
        TextView textView4 = dialogPalaiSemRegBinding14 != null ? dialogPalaiSemRegBinding14.globalElecTv : null;
        if (textView4 != null) {
            textView4.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding15 = this$0.get_binding();
        LinearLayout linearLayout12 = dialogPalaiSemRegBinding15 != null ? dialogPalaiSemRegBinding15.sgpaCgpaLt : null;
        if (linearLayout12 != null) {
            linearLayout12.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding16 = this$0.get_binding();
        TextView textView5 = dialogPalaiSemRegBinding16 != null ? dialogPalaiSemRegBinding16.sgpaCgpaTv : null;
        if (textView5 != null) {
            textView5.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding17 = this$0.get_binding();
        LinearLayout linearLayout13 = dialogPalaiSemRegBinding17 != null ? dialogPalaiSemRegBinding17.supplyLt : null;
        if (linearLayout13 != null) {
            linearLayout13.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding18 = this$0.get_binding();
        TextView textView6 = dialogPalaiSemRegBinding18 != null ? dialogPalaiSemRegBinding18.supplyTv : null;
        if (textView6 != null) {
            textView6.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding19 = this$0.get_binding();
        LinearLayout linearLayout14 = dialogPalaiSemRegBinding19 != null ? dialogPalaiSemRegBinding19.prevSemLt : null;
        if (linearLayout14 != null) {
            linearLayout14.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding20 = this$0.get_binding();
        TextView textView7 = dialogPalaiSemRegBinding20 != null ? dialogPalaiSemRegBinding20.prevSemTv : null;
        if (textView7 != null) {
            textView7.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding21 = this$0.get_binding();
        LinearLayout linearLayout15 = dialogPalaiSemRegBinding21 != null ? dialogPalaiSemRegBinding21.feeDetailsLt : null;
        if (linearLayout15 != null) {
            linearLayout15.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding22 = this$0.get_binding();
        TextView textView8 = dialogPalaiSemRegBinding22 != null ? dialogPalaiSemRegBinding22.feeDetailsTv : null;
        if (textView8 != null) {
            textView8.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding23 = this$0.get_binding();
        LinearLayout linearLayout16 = dialogPalaiSemRegBinding23 != null ? dialogPalaiSemRegBinding23.dueLt : null;
        if (linearLayout16 != null) {
            linearLayout16.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding24 = this$0.get_binding();
        TextView textView9 = dialogPalaiSemRegBinding24 != null ? dialogPalaiSemRegBinding24.dueTv : null;
        if (textView9 != null) {
            textView9.setVisibility(8);
        }
        if (this$0.finalPage) {
            DialogPalaiSemRegBinding dialogPalaiSemRegBinding25 = this$0.get_binding();
            textView = dialogPalaiSemRegBinding25 != null ? dialogPalaiSemRegBinding25.registerBtn : null;
            if (textView == null) {
                return;
            }
            textView.setVisibility(0);
            return;
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding26 = this$0.get_binding();
        textView = dialogPalaiSemRegBinding26 != null ? dialogPalaiSemRegBinding26.registerBtn : null;
        if (textView == null) {
            return;
        }
        textView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$2(PalaiNewSemRegDialog this$0, View view) {
        TextView textView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding = this$0.get_binding();
        LinearLayout linearLayout = dialogPalaiSemRegBinding != null ? dialogPalaiSemRegBinding.pageOne : null;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding2 = this$0.get_binding();
        LinearLayout linearLayout2 = dialogPalaiSemRegBinding2 != null ? dialogPalaiSemRegBinding2.pageTwo : null;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(0);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding3 = this$0.get_binding();
        LinearLayout linearLayout3 = dialogPalaiSemRegBinding3 != null ? dialogPalaiSemRegBinding3.pageThree : null;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding4 = this$0.get_binding();
        LinearLayout linearLayout4 = dialogPalaiSemRegBinding4 != null ? dialogPalaiSemRegBinding4.pageFour : null;
        if (linearLayout4 != null) {
            linearLayout4.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding5 = this$0.get_binding();
        LinearLayout linearLayout5 = dialogPalaiSemRegBinding5 != null ? dialogPalaiSemRegBinding5.pageFive : null;
        if (linearLayout5 != null) {
            linearLayout5.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding6 = this$0.get_binding();
        LinearLayout linearLayout6 = dialogPalaiSemRegBinding6 != null ? dialogPalaiSemRegBinding6.pageSix : null;
        if (linearLayout6 != null) {
            linearLayout6.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding7 = this$0.get_binding();
        LinearLayout linearLayout7 = dialogPalaiSemRegBinding7 != null ? dialogPalaiSemRegBinding7.pageSeven : null;
        if (linearLayout7 != null) {
            linearLayout7.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding8 = this$0.get_binding();
        LinearLayout linearLayout8 = dialogPalaiSemRegBinding8 != null ? dialogPalaiSemRegBinding8.pageEight : null;
        if (linearLayout8 != null) {
            linearLayout8.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding9 = this$0.get_binding();
        TextView textView2 = dialogPalaiSemRegBinding9 != null ? dialogPalaiSemRegBinding9.examAttTv : null;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding10 = this$0.get_binding();
        LinearLayout linearLayout9 = dialogPalaiSemRegBinding10 != null ? dialogPalaiSemRegBinding10.universityPreviousLayout : null;
        if (linearLayout9 != null) {
            linearLayout9.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding11 = this$0.get_binding();
        LinearLayout linearLayout10 = dialogPalaiSemRegBinding11 != null ? dialogPalaiSemRegBinding11.honorMinorLt : null;
        if (linearLayout10 != null) {
            linearLayout10.setVisibility(0);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding12 = this$0.get_binding();
        TextView textView3 = dialogPalaiSemRegBinding12 != null ? dialogPalaiSemRegBinding12.honorMinorTv : null;
        if (textView3 != null) {
            textView3.setVisibility(0);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding13 = this$0.get_binding();
        LinearLayout linearLayout11 = dialogPalaiSemRegBinding13 != null ? dialogPalaiSemRegBinding13.globalElecLt : null;
        if (linearLayout11 != null) {
            linearLayout11.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding14 = this$0.get_binding();
        TextView textView4 = dialogPalaiSemRegBinding14 != null ? dialogPalaiSemRegBinding14.globalElecTv : null;
        if (textView4 != null) {
            textView4.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding15 = this$0.get_binding();
        LinearLayout linearLayout12 = dialogPalaiSemRegBinding15 != null ? dialogPalaiSemRegBinding15.sgpaCgpaLt : null;
        if (linearLayout12 != null) {
            linearLayout12.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding16 = this$0.get_binding();
        TextView textView5 = dialogPalaiSemRegBinding16 != null ? dialogPalaiSemRegBinding16.sgpaCgpaTv : null;
        if (textView5 != null) {
            textView5.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding17 = this$0.get_binding();
        LinearLayout linearLayout13 = dialogPalaiSemRegBinding17 != null ? dialogPalaiSemRegBinding17.supplyLt : null;
        if (linearLayout13 != null) {
            linearLayout13.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding18 = this$0.get_binding();
        TextView textView6 = dialogPalaiSemRegBinding18 != null ? dialogPalaiSemRegBinding18.supplyTv : null;
        if (textView6 != null) {
            textView6.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding19 = this$0.get_binding();
        LinearLayout linearLayout14 = dialogPalaiSemRegBinding19 != null ? dialogPalaiSemRegBinding19.prevSemLt : null;
        if (linearLayout14 != null) {
            linearLayout14.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding20 = this$0.get_binding();
        TextView textView7 = dialogPalaiSemRegBinding20 != null ? dialogPalaiSemRegBinding20.prevSemTv : null;
        if (textView7 != null) {
            textView7.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding21 = this$0.get_binding();
        LinearLayout linearLayout15 = dialogPalaiSemRegBinding21 != null ? dialogPalaiSemRegBinding21.feeDetailsLt : null;
        if (linearLayout15 != null) {
            linearLayout15.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding22 = this$0.get_binding();
        TextView textView8 = dialogPalaiSemRegBinding22 != null ? dialogPalaiSemRegBinding22.feeDetailsTv : null;
        if (textView8 != null) {
            textView8.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding23 = this$0.get_binding();
        LinearLayout linearLayout16 = dialogPalaiSemRegBinding23 != null ? dialogPalaiSemRegBinding23.dueLt : null;
        if (linearLayout16 != null) {
            linearLayout16.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding24 = this$0.get_binding();
        TextView textView9 = dialogPalaiSemRegBinding24 != null ? dialogPalaiSemRegBinding24.dueTv : null;
        if (textView9 != null) {
            textView9.setVisibility(8);
        }
        if (this$0.finalPage) {
            DialogPalaiSemRegBinding dialogPalaiSemRegBinding25 = this$0.get_binding();
            textView = dialogPalaiSemRegBinding25 != null ? dialogPalaiSemRegBinding25.registerBtn : null;
            if (textView == null) {
                return;
            }
            textView.setVisibility(0);
            return;
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding26 = this$0.get_binding();
        textView = dialogPalaiSemRegBinding26 != null ? dialogPalaiSemRegBinding26.registerBtn : null;
        if (textView == null) {
            return;
        }
        textView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$3(PalaiNewSemRegDialog this$0, View view) {
        TextView textView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding = this$0.get_binding();
        LinearLayout linearLayout = dialogPalaiSemRegBinding != null ? dialogPalaiSemRegBinding.pageOne : null;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding2 = this$0.get_binding();
        LinearLayout linearLayout2 = dialogPalaiSemRegBinding2 != null ? dialogPalaiSemRegBinding2.pageTwo : null;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding3 = this$0.get_binding();
        LinearLayout linearLayout3 = dialogPalaiSemRegBinding3 != null ? dialogPalaiSemRegBinding3.pageThree : null;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(0);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding4 = this$0.get_binding();
        LinearLayout linearLayout4 = dialogPalaiSemRegBinding4 != null ? dialogPalaiSemRegBinding4.pageFour : null;
        if (linearLayout4 != null) {
            linearLayout4.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding5 = this$0.get_binding();
        LinearLayout linearLayout5 = dialogPalaiSemRegBinding5 != null ? dialogPalaiSemRegBinding5.pageFive : null;
        if (linearLayout5 != null) {
            linearLayout5.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding6 = this$0.get_binding();
        LinearLayout linearLayout6 = dialogPalaiSemRegBinding6 != null ? dialogPalaiSemRegBinding6.pageSix : null;
        if (linearLayout6 != null) {
            linearLayout6.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding7 = this$0.get_binding();
        LinearLayout linearLayout7 = dialogPalaiSemRegBinding7 != null ? dialogPalaiSemRegBinding7.pageSeven : null;
        if (linearLayout7 != null) {
            linearLayout7.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding8 = this$0.get_binding();
        LinearLayout linearLayout8 = dialogPalaiSemRegBinding8 != null ? dialogPalaiSemRegBinding8.pageEight : null;
        if (linearLayout8 != null) {
            linearLayout8.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding9 = this$0.get_binding();
        TextView textView2 = dialogPalaiSemRegBinding9 != null ? dialogPalaiSemRegBinding9.examAttTv : null;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding10 = this$0.get_binding();
        LinearLayout linearLayout9 = dialogPalaiSemRegBinding10 != null ? dialogPalaiSemRegBinding10.universityPreviousLayout : null;
        if (linearLayout9 != null) {
            linearLayout9.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding11 = this$0.get_binding();
        LinearLayout linearLayout10 = dialogPalaiSemRegBinding11 != null ? dialogPalaiSemRegBinding11.honorMinorLt : null;
        if (linearLayout10 != null) {
            linearLayout10.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding12 = this$0.get_binding();
        TextView textView3 = dialogPalaiSemRegBinding12 != null ? dialogPalaiSemRegBinding12.honorMinorTv : null;
        if (textView3 != null) {
            textView3.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding13 = this$0.get_binding();
        LinearLayout linearLayout11 = dialogPalaiSemRegBinding13 != null ? dialogPalaiSemRegBinding13.globalElecLt : null;
        if (linearLayout11 != null) {
            linearLayout11.setVisibility(0);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding14 = this$0.get_binding();
        TextView textView4 = dialogPalaiSemRegBinding14 != null ? dialogPalaiSemRegBinding14.globalElecTv : null;
        if (textView4 != null) {
            textView4.setVisibility(0);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding15 = this$0.get_binding();
        LinearLayout linearLayout12 = dialogPalaiSemRegBinding15 != null ? dialogPalaiSemRegBinding15.sgpaCgpaLt : null;
        if (linearLayout12 != null) {
            linearLayout12.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding16 = this$0.get_binding();
        TextView textView5 = dialogPalaiSemRegBinding16 != null ? dialogPalaiSemRegBinding16.sgpaCgpaTv : null;
        if (textView5 != null) {
            textView5.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding17 = this$0.get_binding();
        LinearLayout linearLayout13 = dialogPalaiSemRegBinding17 != null ? dialogPalaiSemRegBinding17.supplyLt : null;
        if (linearLayout13 != null) {
            linearLayout13.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding18 = this$0.get_binding();
        TextView textView6 = dialogPalaiSemRegBinding18 != null ? dialogPalaiSemRegBinding18.supplyTv : null;
        if (textView6 != null) {
            textView6.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding19 = this$0.get_binding();
        LinearLayout linearLayout14 = dialogPalaiSemRegBinding19 != null ? dialogPalaiSemRegBinding19.prevSemLt : null;
        if (linearLayout14 != null) {
            linearLayout14.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding20 = this$0.get_binding();
        TextView textView7 = dialogPalaiSemRegBinding20 != null ? dialogPalaiSemRegBinding20.prevSemTv : null;
        if (textView7 != null) {
            textView7.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding21 = this$0.get_binding();
        LinearLayout linearLayout15 = dialogPalaiSemRegBinding21 != null ? dialogPalaiSemRegBinding21.feeDetailsLt : null;
        if (linearLayout15 != null) {
            linearLayout15.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding22 = this$0.get_binding();
        TextView textView8 = dialogPalaiSemRegBinding22 != null ? dialogPalaiSemRegBinding22.feeDetailsTv : null;
        if (textView8 != null) {
            textView8.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding23 = this$0.get_binding();
        LinearLayout linearLayout16 = dialogPalaiSemRegBinding23 != null ? dialogPalaiSemRegBinding23.dueLt : null;
        if (linearLayout16 != null) {
            linearLayout16.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding24 = this$0.get_binding();
        TextView textView9 = dialogPalaiSemRegBinding24 != null ? dialogPalaiSemRegBinding24.dueTv : null;
        if (textView9 != null) {
            textView9.setVisibility(8);
        }
        if (this$0.finalPage) {
            DialogPalaiSemRegBinding dialogPalaiSemRegBinding25 = this$0.get_binding();
            textView = dialogPalaiSemRegBinding25 != null ? dialogPalaiSemRegBinding25.registerBtn : null;
            if (textView == null) {
                return;
            }
            textView.setVisibility(0);
            return;
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding26 = this$0.get_binding();
        textView = dialogPalaiSemRegBinding26 != null ? dialogPalaiSemRegBinding26.registerBtn : null;
        if (textView == null) {
            return;
        }
        textView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$4(PalaiNewSemRegDialog this$0, View view) {
        TextView textView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding = this$0.get_binding();
        LinearLayout linearLayout = dialogPalaiSemRegBinding != null ? dialogPalaiSemRegBinding.pageOne : null;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding2 = this$0.get_binding();
        LinearLayout linearLayout2 = dialogPalaiSemRegBinding2 != null ? dialogPalaiSemRegBinding2.pageTwo : null;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding3 = this$0.get_binding();
        LinearLayout linearLayout3 = dialogPalaiSemRegBinding3 != null ? dialogPalaiSemRegBinding3.pageThree : null;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding4 = this$0.get_binding();
        LinearLayout linearLayout4 = dialogPalaiSemRegBinding4 != null ? dialogPalaiSemRegBinding4.pageFour : null;
        if (linearLayout4 != null) {
            linearLayout4.setVisibility(0);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding5 = this$0.get_binding();
        LinearLayout linearLayout5 = dialogPalaiSemRegBinding5 != null ? dialogPalaiSemRegBinding5.pageFive : null;
        if (linearLayout5 != null) {
            linearLayout5.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding6 = this$0.get_binding();
        LinearLayout linearLayout6 = dialogPalaiSemRegBinding6 != null ? dialogPalaiSemRegBinding6.pageSix : null;
        if (linearLayout6 != null) {
            linearLayout6.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding7 = this$0.get_binding();
        LinearLayout linearLayout7 = dialogPalaiSemRegBinding7 != null ? dialogPalaiSemRegBinding7.pageSeven : null;
        if (linearLayout7 != null) {
            linearLayout7.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding8 = this$0.get_binding();
        LinearLayout linearLayout8 = dialogPalaiSemRegBinding8 != null ? dialogPalaiSemRegBinding8.pageEight : null;
        if (linearLayout8 != null) {
            linearLayout8.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding9 = this$0.get_binding();
        TextView textView2 = dialogPalaiSemRegBinding9 != null ? dialogPalaiSemRegBinding9.examAttTv : null;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding10 = this$0.get_binding();
        LinearLayout linearLayout9 = dialogPalaiSemRegBinding10 != null ? dialogPalaiSemRegBinding10.universityPreviousLayout : null;
        if (linearLayout9 != null) {
            linearLayout9.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding11 = this$0.get_binding();
        LinearLayout linearLayout10 = dialogPalaiSemRegBinding11 != null ? dialogPalaiSemRegBinding11.honorMinorLt : null;
        if (linearLayout10 != null) {
            linearLayout10.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding12 = this$0.get_binding();
        TextView textView3 = dialogPalaiSemRegBinding12 != null ? dialogPalaiSemRegBinding12.honorMinorTv : null;
        if (textView3 != null) {
            textView3.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding13 = this$0.get_binding();
        LinearLayout linearLayout11 = dialogPalaiSemRegBinding13 != null ? dialogPalaiSemRegBinding13.globalElecLt : null;
        if (linearLayout11 != null) {
            linearLayout11.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding14 = this$0.get_binding();
        TextView textView4 = dialogPalaiSemRegBinding14 != null ? dialogPalaiSemRegBinding14.globalElecTv : null;
        if (textView4 != null) {
            textView4.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding15 = this$0.get_binding();
        LinearLayout linearLayout12 = dialogPalaiSemRegBinding15 != null ? dialogPalaiSemRegBinding15.sgpaCgpaLt : null;
        if (linearLayout12 != null) {
            linearLayout12.setVisibility(0);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding16 = this$0.get_binding();
        TextView textView5 = dialogPalaiSemRegBinding16 != null ? dialogPalaiSemRegBinding16.sgpaCgpaTv : null;
        if (textView5 != null) {
            textView5.setVisibility(0);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding17 = this$0.get_binding();
        LinearLayout linearLayout13 = dialogPalaiSemRegBinding17 != null ? dialogPalaiSemRegBinding17.supplyLt : null;
        if (linearLayout13 != null) {
            linearLayout13.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding18 = this$0.get_binding();
        TextView textView6 = dialogPalaiSemRegBinding18 != null ? dialogPalaiSemRegBinding18.supplyTv : null;
        if (textView6 != null) {
            textView6.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding19 = this$0.get_binding();
        LinearLayout linearLayout14 = dialogPalaiSemRegBinding19 != null ? dialogPalaiSemRegBinding19.prevSemLt : null;
        if (linearLayout14 != null) {
            linearLayout14.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding20 = this$0.get_binding();
        TextView textView7 = dialogPalaiSemRegBinding20 != null ? dialogPalaiSemRegBinding20.prevSemTv : null;
        if (textView7 != null) {
            textView7.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding21 = this$0.get_binding();
        LinearLayout linearLayout15 = dialogPalaiSemRegBinding21 != null ? dialogPalaiSemRegBinding21.feeDetailsLt : null;
        if (linearLayout15 != null) {
            linearLayout15.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding22 = this$0.get_binding();
        TextView textView8 = dialogPalaiSemRegBinding22 != null ? dialogPalaiSemRegBinding22.feeDetailsTv : null;
        if (textView8 != null) {
            textView8.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding23 = this$0.get_binding();
        LinearLayout linearLayout16 = dialogPalaiSemRegBinding23 != null ? dialogPalaiSemRegBinding23.dueLt : null;
        if (linearLayout16 != null) {
            linearLayout16.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding24 = this$0.get_binding();
        TextView textView9 = dialogPalaiSemRegBinding24 != null ? dialogPalaiSemRegBinding24.dueTv : null;
        if (textView9 != null) {
            textView9.setVisibility(8);
        }
        if (this$0.finalPage) {
            DialogPalaiSemRegBinding dialogPalaiSemRegBinding25 = this$0.get_binding();
            textView = dialogPalaiSemRegBinding25 != null ? dialogPalaiSemRegBinding25.registerBtn : null;
            if (textView == null) {
                return;
            }
            textView.setVisibility(0);
            return;
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding26 = this$0.get_binding();
        textView = dialogPalaiSemRegBinding26 != null ? dialogPalaiSemRegBinding26.registerBtn : null;
        if (textView == null) {
            return;
        }
        textView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$5(PalaiNewSemRegDialog this$0, View view) {
        TextView textView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding = this$0.get_binding();
        LinearLayout linearLayout = dialogPalaiSemRegBinding != null ? dialogPalaiSemRegBinding.pageOne : null;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding2 = this$0.get_binding();
        LinearLayout linearLayout2 = dialogPalaiSemRegBinding2 != null ? dialogPalaiSemRegBinding2.pageTwo : null;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding3 = this$0.get_binding();
        LinearLayout linearLayout3 = dialogPalaiSemRegBinding3 != null ? dialogPalaiSemRegBinding3.pageThree : null;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(0);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding4 = this$0.get_binding();
        LinearLayout linearLayout4 = dialogPalaiSemRegBinding4 != null ? dialogPalaiSemRegBinding4.pageFour : null;
        if (linearLayout4 != null) {
            linearLayout4.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding5 = this$0.get_binding();
        LinearLayout linearLayout5 = dialogPalaiSemRegBinding5 != null ? dialogPalaiSemRegBinding5.pageFive : null;
        if (linearLayout5 != null) {
            linearLayout5.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding6 = this$0.get_binding();
        LinearLayout linearLayout6 = dialogPalaiSemRegBinding6 != null ? dialogPalaiSemRegBinding6.pageSix : null;
        if (linearLayout6 != null) {
            linearLayout6.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding7 = this$0.get_binding();
        LinearLayout linearLayout7 = dialogPalaiSemRegBinding7 != null ? dialogPalaiSemRegBinding7.pageSeven : null;
        if (linearLayout7 != null) {
            linearLayout7.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding8 = this$0.get_binding();
        LinearLayout linearLayout8 = dialogPalaiSemRegBinding8 != null ? dialogPalaiSemRegBinding8.pageEight : null;
        if (linearLayout8 != null) {
            linearLayout8.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding9 = this$0.get_binding();
        TextView textView2 = dialogPalaiSemRegBinding9 != null ? dialogPalaiSemRegBinding9.examAttTv : null;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding10 = this$0.get_binding();
        LinearLayout linearLayout9 = dialogPalaiSemRegBinding10 != null ? dialogPalaiSemRegBinding10.universityPreviousLayout : null;
        if (linearLayout9 != null) {
            linearLayout9.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding11 = this$0.get_binding();
        LinearLayout linearLayout10 = dialogPalaiSemRegBinding11 != null ? dialogPalaiSemRegBinding11.honorMinorLt : null;
        if (linearLayout10 != null) {
            linearLayout10.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding12 = this$0.get_binding();
        TextView textView3 = dialogPalaiSemRegBinding12 != null ? dialogPalaiSemRegBinding12.honorMinorTv : null;
        if (textView3 != null) {
            textView3.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding13 = this$0.get_binding();
        LinearLayout linearLayout11 = dialogPalaiSemRegBinding13 != null ? dialogPalaiSemRegBinding13.globalElecLt : null;
        if (linearLayout11 != null) {
            linearLayout11.setVisibility(0);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding14 = this$0.get_binding();
        TextView textView4 = dialogPalaiSemRegBinding14 != null ? dialogPalaiSemRegBinding14.globalElecTv : null;
        if (textView4 != null) {
            textView4.setVisibility(0);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding15 = this$0.get_binding();
        LinearLayout linearLayout12 = dialogPalaiSemRegBinding15 != null ? dialogPalaiSemRegBinding15.sgpaCgpaLt : null;
        if (linearLayout12 != null) {
            linearLayout12.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding16 = this$0.get_binding();
        TextView textView5 = dialogPalaiSemRegBinding16 != null ? dialogPalaiSemRegBinding16.sgpaCgpaTv : null;
        if (textView5 != null) {
            textView5.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding17 = this$0.get_binding();
        LinearLayout linearLayout13 = dialogPalaiSemRegBinding17 != null ? dialogPalaiSemRegBinding17.supplyLt : null;
        if (linearLayout13 != null) {
            linearLayout13.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding18 = this$0.get_binding();
        TextView textView6 = dialogPalaiSemRegBinding18 != null ? dialogPalaiSemRegBinding18.supplyTv : null;
        if (textView6 != null) {
            textView6.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding19 = this$0.get_binding();
        LinearLayout linearLayout14 = dialogPalaiSemRegBinding19 != null ? dialogPalaiSemRegBinding19.prevSemLt : null;
        if (linearLayout14 != null) {
            linearLayout14.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding20 = this$0.get_binding();
        TextView textView7 = dialogPalaiSemRegBinding20 != null ? dialogPalaiSemRegBinding20.prevSemTv : null;
        if (textView7 != null) {
            textView7.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding21 = this$0.get_binding();
        LinearLayout linearLayout15 = dialogPalaiSemRegBinding21 != null ? dialogPalaiSemRegBinding21.feeDetailsLt : null;
        if (linearLayout15 != null) {
            linearLayout15.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding22 = this$0.get_binding();
        TextView textView8 = dialogPalaiSemRegBinding22 != null ? dialogPalaiSemRegBinding22.feeDetailsTv : null;
        if (textView8 != null) {
            textView8.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding23 = this$0.get_binding();
        LinearLayout linearLayout16 = dialogPalaiSemRegBinding23 != null ? dialogPalaiSemRegBinding23.dueLt : null;
        if (linearLayout16 != null) {
            linearLayout16.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding24 = this$0.get_binding();
        TextView textView9 = dialogPalaiSemRegBinding24 != null ? dialogPalaiSemRegBinding24.dueTv : null;
        if (textView9 != null) {
            textView9.setVisibility(8);
        }
        if (this$0.finalPage) {
            DialogPalaiSemRegBinding dialogPalaiSemRegBinding25 = this$0.get_binding();
            textView = dialogPalaiSemRegBinding25 != null ? dialogPalaiSemRegBinding25.registerBtn : null;
            if (textView == null) {
                return;
            }
            textView.setVisibility(0);
            return;
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding26 = this$0.get_binding();
        textView = dialogPalaiSemRegBinding26 != null ? dialogPalaiSemRegBinding26.registerBtn : null;
        if (textView == null) {
            return;
        }
        textView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$6(PalaiNewSemRegDialog this$0, View view) {
        TextView textView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding = this$0.get_binding();
        LinearLayout linearLayout = dialogPalaiSemRegBinding != null ? dialogPalaiSemRegBinding.pageOne : null;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding2 = this$0.get_binding();
        LinearLayout linearLayout2 = dialogPalaiSemRegBinding2 != null ? dialogPalaiSemRegBinding2.pageTwo : null;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding3 = this$0.get_binding();
        LinearLayout linearLayout3 = dialogPalaiSemRegBinding3 != null ? dialogPalaiSemRegBinding3.pageThree : null;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding4 = this$0.get_binding();
        LinearLayout linearLayout4 = dialogPalaiSemRegBinding4 != null ? dialogPalaiSemRegBinding4.pageFour : null;
        if (linearLayout4 != null) {
            linearLayout4.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding5 = this$0.get_binding();
        LinearLayout linearLayout5 = dialogPalaiSemRegBinding5 != null ? dialogPalaiSemRegBinding5.pageFive : null;
        if (linearLayout5 != null) {
            linearLayout5.setVisibility(0);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding6 = this$0.get_binding();
        LinearLayout linearLayout6 = dialogPalaiSemRegBinding6 != null ? dialogPalaiSemRegBinding6.pageSix : null;
        if (linearLayout6 != null) {
            linearLayout6.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding7 = this$0.get_binding();
        LinearLayout linearLayout7 = dialogPalaiSemRegBinding7 != null ? dialogPalaiSemRegBinding7.pageSeven : null;
        if (linearLayout7 != null) {
            linearLayout7.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding8 = this$0.get_binding();
        LinearLayout linearLayout8 = dialogPalaiSemRegBinding8 != null ? dialogPalaiSemRegBinding8.pageEight : null;
        if (linearLayout8 != null) {
            linearLayout8.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding9 = this$0.get_binding();
        TextView textView2 = dialogPalaiSemRegBinding9 != null ? dialogPalaiSemRegBinding9.examAttTv : null;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding10 = this$0.get_binding();
        LinearLayout linearLayout9 = dialogPalaiSemRegBinding10 != null ? dialogPalaiSemRegBinding10.universityPreviousLayout : null;
        if (linearLayout9 != null) {
            linearLayout9.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding11 = this$0.get_binding();
        LinearLayout linearLayout10 = dialogPalaiSemRegBinding11 != null ? dialogPalaiSemRegBinding11.honorMinorLt : null;
        if (linearLayout10 != null) {
            linearLayout10.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding12 = this$0.get_binding();
        TextView textView3 = dialogPalaiSemRegBinding12 != null ? dialogPalaiSemRegBinding12.honorMinorTv : null;
        if (textView3 != null) {
            textView3.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding13 = this$0.get_binding();
        LinearLayout linearLayout11 = dialogPalaiSemRegBinding13 != null ? dialogPalaiSemRegBinding13.globalElecLt : null;
        if (linearLayout11 != null) {
            linearLayout11.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding14 = this$0.get_binding();
        TextView textView4 = dialogPalaiSemRegBinding14 != null ? dialogPalaiSemRegBinding14.globalElecTv : null;
        if (textView4 != null) {
            textView4.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding15 = this$0.get_binding();
        LinearLayout linearLayout12 = dialogPalaiSemRegBinding15 != null ? dialogPalaiSemRegBinding15.sgpaCgpaLt : null;
        if (linearLayout12 != null) {
            linearLayout12.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding16 = this$0.get_binding();
        TextView textView5 = dialogPalaiSemRegBinding16 != null ? dialogPalaiSemRegBinding16.sgpaCgpaTv : null;
        if (textView5 != null) {
            textView5.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding17 = this$0.get_binding();
        LinearLayout linearLayout13 = dialogPalaiSemRegBinding17 != null ? dialogPalaiSemRegBinding17.supplyLt : null;
        if (linearLayout13 != null) {
            linearLayout13.setVisibility(0);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding18 = this$0.get_binding();
        TextView textView6 = dialogPalaiSemRegBinding18 != null ? dialogPalaiSemRegBinding18.supplyTv : null;
        if (textView6 != null) {
            textView6.setVisibility(0);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding19 = this$0.get_binding();
        LinearLayout linearLayout14 = dialogPalaiSemRegBinding19 != null ? dialogPalaiSemRegBinding19.prevSemLt : null;
        if (linearLayout14 != null) {
            linearLayout14.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding20 = this$0.get_binding();
        TextView textView7 = dialogPalaiSemRegBinding20 != null ? dialogPalaiSemRegBinding20.prevSemTv : null;
        if (textView7 != null) {
            textView7.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding21 = this$0.get_binding();
        LinearLayout linearLayout15 = dialogPalaiSemRegBinding21 != null ? dialogPalaiSemRegBinding21.feeDetailsLt : null;
        if (linearLayout15 != null) {
            linearLayout15.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding22 = this$0.get_binding();
        TextView textView8 = dialogPalaiSemRegBinding22 != null ? dialogPalaiSemRegBinding22.feeDetailsTv : null;
        if (textView8 != null) {
            textView8.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding23 = this$0.get_binding();
        LinearLayout linearLayout16 = dialogPalaiSemRegBinding23 != null ? dialogPalaiSemRegBinding23.dueLt : null;
        if (linearLayout16 != null) {
            linearLayout16.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding24 = this$0.get_binding();
        TextView textView9 = dialogPalaiSemRegBinding24 != null ? dialogPalaiSemRegBinding24.dueTv : null;
        if (textView9 != null) {
            textView9.setVisibility(8);
        }
        if (this$0.finalPage) {
            DialogPalaiSemRegBinding dialogPalaiSemRegBinding25 = this$0.get_binding();
            textView = dialogPalaiSemRegBinding25 != null ? dialogPalaiSemRegBinding25.registerBtn : null;
            if (textView == null) {
                return;
            }
            textView.setVisibility(0);
            return;
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding26 = this$0.get_binding();
        textView = dialogPalaiSemRegBinding26 != null ? dialogPalaiSemRegBinding26.registerBtn : null;
        if (textView == null) {
            return;
        }
        textView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$7(PalaiNewSemRegDialog this$0, View view) {
        TextView textView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding = this$0.get_binding();
        LinearLayout linearLayout = dialogPalaiSemRegBinding != null ? dialogPalaiSemRegBinding.pageOne : null;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding2 = this$0.get_binding();
        LinearLayout linearLayout2 = dialogPalaiSemRegBinding2 != null ? dialogPalaiSemRegBinding2.pageTwo : null;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding3 = this$0.get_binding();
        LinearLayout linearLayout3 = dialogPalaiSemRegBinding3 != null ? dialogPalaiSemRegBinding3.pageThree : null;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding4 = this$0.get_binding();
        LinearLayout linearLayout4 = dialogPalaiSemRegBinding4 != null ? dialogPalaiSemRegBinding4.pageFour : null;
        if (linearLayout4 != null) {
            linearLayout4.setVisibility(0);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding5 = this$0.get_binding();
        LinearLayout linearLayout5 = dialogPalaiSemRegBinding5 != null ? dialogPalaiSemRegBinding5.pageFive : null;
        if (linearLayout5 != null) {
            linearLayout5.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding6 = this$0.get_binding();
        LinearLayout linearLayout6 = dialogPalaiSemRegBinding6 != null ? dialogPalaiSemRegBinding6.pageSix : null;
        if (linearLayout6 != null) {
            linearLayout6.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding7 = this$0.get_binding();
        LinearLayout linearLayout7 = dialogPalaiSemRegBinding7 != null ? dialogPalaiSemRegBinding7.pageSeven : null;
        if (linearLayout7 != null) {
            linearLayout7.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding8 = this$0.get_binding();
        LinearLayout linearLayout8 = dialogPalaiSemRegBinding8 != null ? dialogPalaiSemRegBinding8.pageEight : null;
        if (linearLayout8 != null) {
            linearLayout8.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding9 = this$0.get_binding();
        TextView textView2 = dialogPalaiSemRegBinding9 != null ? dialogPalaiSemRegBinding9.examAttTv : null;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding10 = this$0.get_binding();
        LinearLayout linearLayout9 = dialogPalaiSemRegBinding10 != null ? dialogPalaiSemRegBinding10.universityPreviousLayout : null;
        if (linearLayout9 != null) {
            linearLayout9.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding11 = this$0.get_binding();
        LinearLayout linearLayout10 = dialogPalaiSemRegBinding11 != null ? dialogPalaiSemRegBinding11.honorMinorLt : null;
        if (linearLayout10 != null) {
            linearLayout10.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding12 = this$0.get_binding();
        TextView textView3 = dialogPalaiSemRegBinding12 != null ? dialogPalaiSemRegBinding12.honorMinorTv : null;
        if (textView3 != null) {
            textView3.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding13 = this$0.get_binding();
        LinearLayout linearLayout11 = dialogPalaiSemRegBinding13 != null ? dialogPalaiSemRegBinding13.globalElecLt : null;
        if (linearLayout11 != null) {
            linearLayout11.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding14 = this$0.get_binding();
        TextView textView4 = dialogPalaiSemRegBinding14 != null ? dialogPalaiSemRegBinding14.globalElecTv : null;
        if (textView4 != null) {
            textView4.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding15 = this$0.get_binding();
        LinearLayout linearLayout12 = dialogPalaiSemRegBinding15 != null ? dialogPalaiSemRegBinding15.sgpaCgpaLt : null;
        if (linearLayout12 != null) {
            linearLayout12.setVisibility(0);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding16 = this$0.get_binding();
        TextView textView5 = dialogPalaiSemRegBinding16 != null ? dialogPalaiSemRegBinding16.sgpaCgpaTv : null;
        if (textView5 != null) {
            textView5.setVisibility(0);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding17 = this$0.get_binding();
        LinearLayout linearLayout13 = dialogPalaiSemRegBinding17 != null ? dialogPalaiSemRegBinding17.supplyLt : null;
        if (linearLayout13 != null) {
            linearLayout13.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding18 = this$0.get_binding();
        TextView textView6 = dialogPalaiSemRegBinding18 != null ? dialogPalaiSemRegBinding18.supplyTv : null;
        if (textView6 != null) {
            textView6.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding19 = this$0.get_binding();
        LinearLayout linearLayout14 = dialogPalaiSemRegBinding19 != null ? dialogPalaiSemRegBinding19.prevSemLt : null;
        if (linearLayout14 != null) {
            linearLayout14.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding20 = this$0.get_binding();
        TextView textView7 = dialogPalaiSemRegBinding20 != null ? dialogPalaiSemRegBinding20.prevSemTv : null;
        if (textView7 != null) {
            textView7.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding21 = this$0.get_binding();
        LinearLayout linearLayout15 = dialogPalaiSemRegBinding21 != null ? dialogPalaiSemRegBinding21.feeDetailsLt : null;
        if (linearLayout15 != null) {
            linearLayout15.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding22 = this$0.get_binding();
        TextView textView8 = dialogPalaiSemRegBinding22 != null ? dialogPalaiSemRegBinding22.feeDetailsTv : null;
        if (textView8 != null) {
            textView8.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding23 = this$0.get_binding();
        LinearLayout linearLayout16 = dialogPalaiSemRegBinding23 != null ? dialogPalaiSemRegBinding23.dueLt : null;
        if (linearLayout16 != null) {
            linearLayout16.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding24 = this$0.get_binding();
        TextView textView9 = dialogPalaiSemRegBinding24 != null ? dialogPalaiSemRegBinding24.dueTv : null;
        if (textView9 != null) {
            textView9.setVisibility(8);
        }
        if (this$0.finalPage) {
            DialogPalaiSemRegBinding dialogPalaiSemRegBinding25 = this$0.get_binding();
            textView = dialogPalaiSemRegBinding25 != null ? dialogPalaiSemRegBinding25.registerBtn : null;
            if (textView == null) {
                return;
            }
            textView.setVisibility(0);
            return;
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding26 = this$0.get_binding();
        textView = dialogPalaiSemRegBinding26 != null ? dialogPalaiSemRegBinding26.registerBtn : null;
        if (textView == null) {
            return;
        }
        textView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$8(PalaiNewSemRegDialog this$0, View view) {
        TextView textView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding = this$0.get_binding();
        LinearLayout linearLayout = dialogPalaiSemRegBinding != null ? dialogPalaiSemRegBinding.pageOne : null;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding2 = this$0.get_binding();
        LinearLayout linearLayout2 = dialogPalaiSemRegBinding2 != null ? dialogPalaiSemRegBinding2.pageTwo : null;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding3 = this$0.get_binding();
        LinearLayout linearLayout3 = dialogPalaiSemRegBinding3 != null ? dialogPalaiSemRegBinding3.pageThree : null;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding4 = this$0.get_binding();
        LinearLayout linearLayout4 = dialogPalaiSemRegBinding4 != null ? dialogPalaiSemRegBinding4.pageFour : null;
        if (linearLayout4 != null) {
            linearLayout4.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding5 = this$0.get_binding();
        LinearLayout linearLayout5 = dialogPalaiSemRegBinding5 != null ? dialogPalaiSemRegBinding5.pageFive : null;
        if (linearLayout5 != null) {
            linearLayout5.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding6 = this$0.get_binding();
        LinearLayout linearLayout6 = dialogPalaiSemRegBinding6 != null ? dialogPalaiSemRegBinding6.pageSix : null;
        if (linearLayout6 != null) {
            linearLayout6.setVisibility(0);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding7 = this$0.get_binding();
        LinearLayout linearLayout7 = dialogPalaiSemRegBinding7 != null ? dialogPalaiSemRegBinding7.pageSeven : null;
        if (linearLayout7 != null) {
            linearLayout7.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding8 = this$0.get_binding();
        LinearLayout linearLayout8 = dialogPalaiSemRegBinding8 != null ? dialogPalaiSemRegBinding8.pageEight : null;
        if (linearLayout8 != null) {
            linearLayout8.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding9 = this$0.get_binding();
        TextView textView2 = dialogPalaiSemRegBinding9 != null ? dialogPalaiSemRegBinding9.examAttTv : null;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding10 = this$0.get_binding();
        LinearLayout linearLayout9 = dialogPalaiSemRegBinding10 != null ? dialogPalaiSemRegBinding10.universityPreviousLayout : null;
        if (linearLayout9 != null) {
            linearLayout9.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding11 = this$0.get_binding();
        LinearLayout linearLayout10 = dialogPalaiSemRegBinding11 != null ? dialogPalaiSemRegBinding11.honorMinorLt : null;
        if (linearLayout10 != null) {
            linearLayout10.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding12 = this$0.get_binding();
        TextView textView3 = dialogPalaiSemRegBinding12 != null ? dialogPalaiSemRegBinding12.honorMinorTv : null;
        if (textView3 != null) {
            textView3.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding13 = this$0.get_binding();
        LinearLayout linearLayout11 = dialogPalaiSemRegBinding13 != null ? dialogPalaiSemRegBinding13.globalElecLt : null;
        if (linearLayout11 != null) {
            linearLayout11.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding14 = this$0.get_binding();
        TextView textView4 = dialogPalaiSemRegBinding14 != null ? dialogPalaiSemRegBinding14.globalElecTv : null;
        if (textView4 != null) {
            textView4.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding15 = this$0.get_binding();
        LinearLayout linearLayout12 = dialogPalaiSemRegBinding15 != null ? dialogPalaiSemRegBinding15.sgpaCgpaLt : null;
        if (linearLayout12 != null) {
            linearLayout12.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding16 = this$0.get_binding();
        TextView textView5 = dialogPalaiSemRegBinding16 != null ? dialogPalaiSemRegBinding16.sgpaCgpaTv : null;
        if (textView5 != null) {
            textView5.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding17 = this$0.get_binding();
        LinearLayout linearLayout13 = dialogPalaiSemRegBinding17 != null ? dialogPalaiSemRegBinding17.supplyLt : null;
        if (linearLayout13 != null) {
            linearLayout13.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding18 = this$0.get_binding();
        TextView textView6 = dialogPalaiSemRegBinding18 != null ? dialogPalaiSemRegBinding18.supplyTv : null;
        if (textView6 != null) {
            textView6.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding19 = this$0.get_binding();
        LinearLayout linearLayout14 = dialogPalaiSemRegBinding19 != null ? dialogPalaiSemRegBinding19.prevSemLt : null;
        if (linearLayout14 != null) {
            linearLayout14.setVisibility(0);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding20 = this$0.get_binding();
        TextView textView7 = dialogPalaiSemRegBinding20 != null ? dialogPalaiSemRegBinding20.prevSemTv : null;
        if (textView7 != null) {
            textView7.setVisibility(0);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding21 = this$0.get_binding();
        LinearLayout linearLayout15 = dialogPalaiSemRegBinding21 != null ? dialogPalaiSemRegBinding21.feeDetailsLt : null;
        if (linearLayout15 != null) {
            linearLayout15.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding22 = this$0.get_binding();
        TextView textView8 = dialogPalaiSemRegBinding22 != null ? dialogPalaiSemRegBinding22.feeDetailsTv : null;
        if (textView8 != null) {
            textView8.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding23 = this$0.get_binding();
        LinearLayout linearLayout16 = dialogPalaiSemRegBinding23 != null ? dialogPalaiSemRegBinding23.dueLt : null;
        if (linearLayout16 != null) {
            linearLayout16.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding24 = this$0.get_binding();
        TextView textView9 = dialogPalaiSemRegBinding24 != null ? dialogPalaiSemRegBinding24.dueTv : null;
        if (textView9 != null) {
            textView9.setVisibility(8);
        }
        if (this$0.finalPage) {
            DialogPalaiSemRegBinding dialogPalaiSemRegBinding25 = this$0.get_binding();
            textView = dialogPalaiSemRegBinding25 != null ? dialogPalaiSemRegBinding25.registerBtn : null;
            if (textView == null) {
                return;
            }
            textView.setVisibility(0);
            return;
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding26 = this$0.get_binding();
        textView = dialogPalaiSemRegBinding26 != null ? dialogPalaiSemRegBinding26.registerBtn : null;
        if (textView == null) {
            return;
        }
        textView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$9(PalaiNewSemRegDialog this$0, View view) {
        TextView textView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding = this$0.get_binding();
        LinearLayout linearLayout = dialogPalaiSemRegBinding != null ? dialogPalaiSemRegBinding.pageOne : null;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding2 = this$0.get_binding();
        LinearLayout linearLayout2 = dialogPalaiSemRegBinding2 != null ? dialogPalaiSemRegBinding2.pageTwo : null;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding3 = this$0.get_binding();
        LinearLayout linearLayout3 = dialogPalaiSemRegBinding3 != null ? dialogPalaiSemRegBinding3.pageThree : null;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding4 = this$0.get_binding();
        LinearLayout linearLayout4 = dialogPalaiSemRegBinding4 != null ? dialogPalaiSemRegBinding4.pageFour : null;
        if (linearLayout4 != null) {
            linearLayout4.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding5 = this$0.get_binding();
        LinearLayout linearLayout5 = dialogPalaiSemRegBinding5 != null ? dialogPalaiSemRegBinding5.pageFive : null;
        if (linearLayout5 != null) {
            linearLayout5.setVisibility(0);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding6 = this$0.get_binding();
        LinearLayout linearLayout6 = dialogPalaiSemRegBinding6 != null ? dialogPalaiSemRegBinding6.pageSix : null;
        if (linearLayout6 != null) {
            linearLayout6.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding7 = this$0.get_binding();
        LinearLayout linearLayout7 = dialogPalaiSemRegBinding7 != null ? dialogPalaiSemRegBinding7.pageSeven : null;
        if (linearLayout7 != null) {
            linearLayout7.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding8 = this$0.get_binding();
        LinearLayout linearLayout8 = dialogPalaiSemRegBinding8 != null ? dialogPalaiSemRegBinding8.pageEight : null;
        if (linearLayout8 != null) {
            linearLayout8.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding9 = this$0.get_binding();
        TextView textView2 = dialogPalaiSemRegBinding9 != null ? dialogPalaiSemRegBinding9.examAttTv : null;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding10 = this$0.get_binding();
        LinearLayout linearLayout9 = dialogPalaiSemRegBinding10 != null ? dialogPalaiSemRegBinding10.universityPreviousLayout : null;
        if (linearLayout9 != null) {
            linearLayout9.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding11 = this$0.get_binding();
        LinearLayout linearLayout10 = dialogPalaiSemRegBinding11 != null ? dialogPalaiSemRegBinding11.honorMinorLt : null;
        if (linearLayout10 != null) {
            linearLayout10.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding12 = this$0.get_binding();
        TextView textView3 = dialogPalaiSemRegBinding12 != null ? dialogPalaiSemRegBinding12.honorMinorTv : null;
        if (textView3 != null) {
            textView3.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding13 = this$0.get_binding();
        LinearLayout linearLayout11 = dialogPalaiSemRegBinding13 != null ? dialogPalaiSemRegBinding13.globalElecLt : null;
        if (linearLayout11 != null) {
            linearLayout11.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding14 = this$0.get_binding();
        TextView textView4 = dialogPalaiSemRegBinding14 != null ? dialogPalaiSemRegBinding14.globalElecTv : null;
        if (textView4 != null) {
            textView4.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding15 = this$0.get_binding();
        LinearLayout linearLayout12 = dialogPalaiSemRegBinding15 != null ? dialogPalaiSemRegBinding15.sgpaCgpaLt : null;
        if (linearLayout12 != null) {
            linearLayout12.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding16 = this$0.get_binding();
        TextView textView5 = dialogPalaiSemRegBinding16 != null ? dialogPalaiSemRegBinding16.sgpaCgpaTv : null;
        if (textView5 != null) {
            textView5.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding17 = this$0.get_binding();
        LinearLayout linearLayout13 = dialogPalaiSemRegBinding17 != null ? dialogPalaiSemRegBinding17.supplyLt : null;
        if (linearLayout13 != null) {
            linearLayout13.setVisibility(0);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding18 = this$0.get_binding();
        TextView textView6 = dialogPalaiSemRegBinding18 != null ? dialogPalaiSemRegBinding18.supplyTv : null;
        if (textView6 != null) {
            textView6.setVisibility(0);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding19 = this$0.get_binding();
        LinearLayout linearLayout14 = dialogPalaiSemRegBinding19 != null ? dialogPalaiSemRegBinding19.prevSemLt : null;
        if (linearLayout14 != null) {
            linearLayout14.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding20 = this$0.get_binding();
        TextView textView7 = dialogPalaiSemRegBinding20 != null ? dialogPalaiSemRegBinding20.prevSemTv : null;
        if (textView7 != null) {
            textView7.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding21 = this$0.get_binding();
        LinearLayout linearLayout15 = dialogPalaiSemRegBinding21 != null ? dialogPalaiSemRegBinding21.feeDetailsLt : null;
        if (linearLayout15 != null) {
            linearLayout15.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding22 = this$0.get_binding();
        TextView textView8 = dialogPalaiSemRegBinding22 != null ? dialogPalaiSemRegBinding22.feeDetailsTv : null;
        if (textView8 != null) {
            textView8.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding23 = this$0.get_binding();
        LinearLayout linearLayout16 = dialogPalaiSemRegBinding23 != null ? dialogPalaiSemRegBinding23.dueLt : null;
        if (linearLayout16 != null) {
            linearLayout16.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding24 = this$0.get_binding();
        TextView textView9 = dialogPalaiSemRegBinding24 != null ? dialogPalaiSemRegBinding24.dueTv : null;
        if (textView9 != null) {
            textView9.setVisibility(8);
        }
        if (this$0.finalPage) {
            DialogPalaiSemRegBinding dialogPalaiSemRegBinding25 = this$0.get_binding();
            textView = dialogPalaiSemRegBinding25 != null ? dialogPalaiSemRegBinding25.registerBtn : null;
            if (textView == null) {
                return;
            }
            textView.setVisibility(0);
            return;
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding26 = this$0.get_binding();
        textView = dialogPalaiSemRegBinding26 != null ? dialogPalaiSemRegBinding26.registerBtn : null;
        if (textView == null) {
            return;
        }
        textView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$10(PalaiNewSemRegDialog this$0, View view) {
        TextView textView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding = this$0.get_binding();
        LinearLayout linearLayout = dialogPalaiSemRegBinding != null ? dialogPalaiSemRegBinding.pageOne : null;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding2 = this$0.get_binding();
        LinearLayout linearLayout2 = dialogPalaiSemRegBinding2 != null ? dialogPalaiSemRegBinding2.pageTwo : null;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding3 = this$0.get_binding();
        LinearLayout linearLayout3 = dialogPalaiSemRegBinding3 != null ? dialogPalaiSemRegBinding3.pageThree : null;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding4 = this$0.get_binding();
        LinearLayout linearLayout4 = dialogPalaiSemRegBinding4 != null ? dialogPalaiSemRegBinding4.pageFour : null;
        if (linearLayout4 != null) {
            linearLayout4.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding5 = this$0.get_binding();
        LinearLayout linearLayout5 = dialogPalaiSemRegBinding5 != null ? dialogPalaiSemRegBinding5.pageFive : null;
        if (linearLayout5 != null) {
            linearLayout5.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding6 = this$0.get_binding();
        LinearLayout linearLayout6 = dialogPalaiSemRegBinding6 != null ? dialogPalaiSemRegBinding6.pageSix : null;
        if (linearLayout6 != null) {
            linearLayout6.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding7 = this$0.get_binding();
        LinearLayout linearLayout7 = dialogPalaiSemRegBinding7 != null ? dialogPalaiSemRegBinding7.pageSeven : null;
        if (linearLayout7 != null) {
            linearLayout7.setVisibility(0);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding8 = this$0.get_binding();
        LinearLayout linearLayout8 = dialogPalaiSemRegBinding8 != null ? dialogPalaiSemRegBinding8.pageEight : null;
        if (linearLayout8 != null) {
            linearLayout8.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding9 = this$0.get_binding();
        TextView textView2 = dialogPalaiSemRegBinding9 != null ? dialogPalaiSemRegBinding9.examAttTv : null;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding10 = this$0.get_binding();
        LinearLayout linearLayout9 = dialogPalaiSemRegBinding10 != null ? dialogPalaiSemRegBinding10.universityPreviousLayout : null;
        if (linearLayout9 != null) {
            linearLayout9.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding11 = this$0.get_binding();
        LinearLayout linearLayout10 = dialogPalaiSemRegBinding11 != null ? dialogPalaiSemRegBinding11.honorMinorLt : null;
        if (linearLayout10 != null) {
            linearLayout10.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding12 = this$0.get_binding();
        TextView textView3 = dialogPalaiSemRegBinding12 != null ? dialogPalaiSemRegBinding12.honorMinorTv : null;
        if (textView3 != null) {
            textView3.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding13 = this$0.get_binding();
        LinearLayout linearLayout11 = dialogPalaiSemRegBinding13 != null ? dialogPalaiSemRegBinding13.globalElecLt : null;
        if (linearLayout11 != null) {
            linearLayout11.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding14 = this$0.get_binding();
        TextView textView4 = dialogPalaiSemRegBinding14 != null ? dialogPalaiSemRegBinding14.globalElecTv : null;
        if (textView4 != null) {
            textView4.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding15 = this$0.get_binding();
        LinearLayout linearLayout12 = dialogPalaiSemRegBinding15 != null ? dialogPalaiSemRegBinding15.sgpaCgpaLt : null;
        if (linearLayout12 != null) {
            linearLayout12.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding16 = this$0.get_binding();
        TextView textView5 = dialogPalaiSemRegBinding16 != null ? dialogPalaiSemRegBinding16.sgpaCgpaTv : null;
        if (textView5 != null) {
            textView5.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding17 = this$0.get_binding();
        LinearLayout linearLayout13 = dialogPalaiSemRegBinding17 != null ? dialogPalaiSemRegBinding17.supplyLt : null;
        if (linearLayout13 != null) {
            linearLayout13.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding18 = this$0.get_binding();
        TextView textView6 = dialogPalaiSemRegBinding18 != null ? dialogPalaiSemRegBinding18.supplyTv : null;
        if (textView6 != null) {
            textView6.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding19 = this$0.get_binding();
        LinearLayout linearLayout14 = dialogPalaiSemRegBinding19 != null ? dialogPalaiSemRegBinding19.prevSemLt : null;
        if (linearLayout14 != null) {
            linearLayout14.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding20 = this$0.get_binding();
        TextView textView7 = dialogPalaiSemRegBinding20 != null ? dialogPalaiSemRegBinding20.prevSemTv : null;
        if (textView7 != null) {
            textView7.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding21 = this$0.get_binding();
        LinearLayout linearLayout15 = dialogPalaiSemRegBinding21 != null ? dialogPalaiSemRegBinding21.feeDetailsLt : null;
        if (linearLayout15 != null) {
            linearLayout15.setVisibility(0);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding22 = this$0.get_binding();
        TextView textView8 = dialogPalaiSemRegBinding22 != null ? dialogPalaiSemRegBinding22.feeDetailsTv : null;
        if (textView8 != null) {
            textView8.setVisibility(0);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding23 = this$0.get_binding();
        LinearLayout linearLayout16 = dialogPalaiSemRegBinding23 != null ? dialogPalaiSemRegBinding23.dueLt : null;
        if (linearLayout16 != null) {
            linearLayout16.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding24 = this$0.get_binding();
        TextView textView9 = dialogPalaiSemRegBinding24 != null ? dialogPalaiSemRegBinding24.dueTv : null;
        if (textView9 != null) {
            textView9.setVisibility(8);
        }
        if (this$0.finalPage) {
            DialogPalaiSemRegBinding dialogPalaiSemRegBinding25 = this$0.get_binding();
            textView = dialogPalaiSemRegBinding25 != null ? dialogPalaiSemRegBinding25.registerBtn : null;
            if (textView == null) {
                return;
            }
            textView.setVisibility(0);
            return;
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding26 = this$0.get_binding();
        textView = dialogPalaiSemRegBinding26 != null ? dialogPalaiSemRegBinding26.registerBtn : null;
        if (textView == null) {
            return;
        }
        textView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$11(PalaiNewSemRegDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.finalPage = true;
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding = this$0.get_binding();
        LinearLayout linearLayout = dialogPalaiSemRegBinding != null ? dialogPalaiSemRegBinding.pageOne : null;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding2 = this$0.get_binding();
        LinearLayout linearLayout2 = dialogPalaiSemRegBinding2 != null ? dialogPalaiSemRegBinding2.pageTwo : null;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding3 = this$0.get_binding();
        LinearLayout linearLayout3 = dialogPalaiSemRegBinding3 != null ? dialogPalaiSemRegBinding3.pageThree : null;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding4 = this$0.get_binding();
        LinearLayout linearLayout4 = dialogPalaiSemRegBinding4 != null ? dialogPalaiSemRegBinding4.pageFour : null;
        if (linearLayout4 != null) {
            linearLayout4.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding5 = this$0.get_binding();
        LinearLayout linearLayout5 = dialogPalaiSemRegBinding5 != null ? dialogPalaiSemRegBinding5.pageFive : null;
        if (linearLayout5 != null) {
            linearLayout5.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding6 = this$0.get_binding();
        LinearLayout linearLayout6 = dialogPalaiSemRegBinding6 != null ? dialogPalaiSemRegBinding6.pageSix : null;
        if (linearLayout6 != null) {
            linearLayout6.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding7 = this$0.get_binding();
        LinearLayout linearLayout7 = dialogPalaiSemRegBinding7 != null ? dialogPalaiSemRegBinding7.pageSeven : null;
        if (linearLayout7 != null) {
            linearLayout7.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding8 = this$0.get_binding();
        LinearLayout linearLayout8 = dialogPalaiSemRegBinding8 != null ? dialogPalaiSemRegBinding8.pageEight : null;
        if (linearLayout8 != null) {
            linearLayout8.setVisibility(0);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding9 = this$0.get_binding();
        TextView textView = dialogPalaiSemRegBinding9 != null ? dialogPalaiSemRegBinding9.registerBtn : null;
        if (textView != null) {
            textView.setVisibility(0);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding10 = this$0.get_binding();
        TextView textView2 = dialogPalaiSemRegBinding10 != null ? dialogPalaiSemRegBinding10.examAttTv : null;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding11 = this$0.get_binding();
        LinearLayout linearLayout9 = dialogPalaiSemRegBinding11 != null ? dialogPalaiSemRegBinding11.universityPreviousLayout : null;
        if (linearLayout9 != null) {
            linearLayout9.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding12 = this$0.get_binding();
        LinearLayout linearLayout10 = dialogPalaiSemRegBinding12 != null ? dialogPalaiSemRegBinding12.honorMinorLt : null;
        if (linearLayout10 != null) {
            linearLayout10.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding13 = this$0.get_binding();
        TextView textView3 = dialogPalaiSemRegBinding13 != null ? dialogPalaiSemRegBinding13.honorMinorTv : null;
        if (textView3 != null) {
            textView3.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding14 = this$0.get_binding();
        LinearLayout linearLayout11 = dialogPalaiSemRegBinding14 != null ? dialogPalaiSemRegBinding14.globalElecLt : null;
        if (linearLayout11 != null) {
            linearLayout11.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding15 = this$0.get_binding();
        TextView textView4 = dialogPalaiSemRegBinding15 != null ? dialogPalaiSemRegBinding15.globalElecTv : null;
        if (textView4 != null) {
            textView4.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding16 = this$0.get_binding();
        LinearLayout linearLayout12 = dialogPalaiSemRegBinding16 != null ? dialogPalaiSemRegBinding16.sgpaCgpaLt : null;
        if (linearLayout12 != null) {
            linearLayout12.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding17 = this$0.get_binding();
        TextView textView5 = dialogPalaiSemRegBinding17 != null ? dialogPalaiSemRegBinding17.sgpaCgpaTv : null;
        if (textView5 != null) {
            textView5.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding18 = this$0.get_binding();
        LinearLayout linearLayout13 = dialogPalaiSemRegBinding18 != null ? dialogPalaiSemRegBinding18.supplyLt : null;
        if (linearLayout13 != null) {
            linearLayout13.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding19 = this$0.get_binding();
        TextView textView6 = dialogPalaiSemRegBinding19 != null ? dialogPalaiSemRegBinding19.supplyTv : null;
        if (textView6 != null) {
            textView6.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding20 = this$0.get_binding();
        LinearLayout linearLayout14 = dialogPalaiSemRegBinding20 != null ? dialogPalaiSemRegBinding20.prevSemLt : null;
        if (linearLayout14 != null) {
            linearLayout14.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding21 = this$0.get_binding();
        TextView textView7 = dialogPalaiSemRegBinding21 != null ? dialogPalaiSemRegBinding21.prevSemTv : null;
        if (textView7 != null) {
            textView7.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding22 = this$0.get_binding();
        LinearLayout linearLayout15 = dialogPalaiSemRegBinding22 != null ? dialogPalaiSemRegBinding22.feeDetailsLt : null;
        if (linearLayout15 != null) {
            linearLayout15.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding23 = this$0.get_binding();
        TextView textView8 = dialogPalaiSemRegBinding23 != null ? dialogPalaiSemRegBinding23.feeDetailsTv : null;
        if (textView8 != null) {
            textView8.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding24 = this$0.get_binding();
        LinearLayout linearLayout16 = dialogPalaiSemRegBinding24 != null ? dialogPalaiSemRegBinding24.dueLt : null;
        if (linearLayout16 != null) {
            linearLayout16.setVisibility(0);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding25 = this$0.get_binding();
        TextView textView9 = dialogPalaiSemRegBinding25 != null ? dialogPalaiSemRegBinding25.dueTv : null;
        if (textView9 == null) {
            return;
        }
        textView9.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$12(PalaiNewSemRegDialog this$0, View view) {
        TextView textView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding = this$0.get_binding();
        LinearLayout linearLayout = dialogPalaiSemRegBinding != null ? dialogPalaiSemRegBinding.pageOne : null;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding2 = this$0.get_binding();
        LinearLayout linearLayout2 = dialogPalaiSemRegBinding2 != null ? dialogPalaiSemRegBinding2.pageTwo : null;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding3 = this$0.get_binding();
        LinearLayout linearLayout3 = dialogPalaiSemRegBinding3 != null ? dialogPalaiSemRegBinding3.pageThree : null;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding4 = this$0.get_binding();
        LinearLayout linearLayout4 = dialogPalaiSemRegBinding4 != null ? dialogPalaiSemRegBinding4.pageFour : null;
        if (linearLayout4 != null) {
            linearLayout4.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding5 = this$0.get_binding();
        LinearLayout linearLayout5 = dialogPalaiSemRegBinding5 != null ? dialogPalaiSemRegBinding5.pageFive : null;
        if (linearLayout5 != null) {
            linearLayout5.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding6 = this$0.get_binding();
        LinearLayout linearLayout6 = dialogPalaiSemRegBinding6 != null ? dialogPalaiSemRegBinding6.pageSix : null;
        if (linearLayout6 != null) {
            linearLayout6.setVisibility(0);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding7 = this$0.get_binding();
        LinearLayout linearLayout7 = dialogPalaiSemRegBinding7 != null ? dialogPalaiSemRegBinding7.pageSeven : null;
        if (linearLayout7 != null) {
            linearLayout7.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding8 = this$0.get_binding();
        LinearLayout linearLayout8 = dialogPalaiSemRegBinding8 != null ? dialogPalaiSemRegBinding8.pageEight : null;
        if (linearLayout8 != null) {
            linearLayout8.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding9 = this$0.get_binding();
        TextView textView2 = dialogPalaiSemRegBinding9 != null ? dialogPalaiSemRegBinding9.examAttTv : null;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding10 = this$0.get_binding();
        LinearLayout linearLayout9 = dialogPalaiSemRegBinding10 != null ? dialogPalaiSemRegBinding10.universityPreviousLayout : null;
        if (linearLayout9 != null) {
            linearLayout9.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding11 = this$0.get_binding();
        LinearLayout linearLayout10 = dialogPalaiSemRegBinding11 != null ? dialogPalaiSemRegBinding11.honorMinorLt : null;
        if (linearLayout10 != null) {
            linearLayout10.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding12 = this$0.get_binding();
        TextView textView3 = dialogPalaiSemRegBinding12 != null ? dialogPalaiSemRegBinding12.honorMinorTv : null;
        if (textView3 != null) {
            textView3.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding13 = this$0.get_binding();
        LinearLayout linearLayout11 = dialogPalaiSemRegBinding13 != null ? dialogPalaiSemRegBinding13.globalElecLt : null;
        if (linearLayout11 != null) {
            linearLayout11.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding14 = this$0.get_binding();
        TextView textView4 = dialogPalaiSemRegBinding14 != null ? dialogPalaiSemRegBinding14.globalElecTv : null;
        if (textView4 != null) {
            textView4.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding15 = this$0.get_binding();
        LinearLayout linearLayout12 = dialogPalaiSemRegBinding15 != null ? dialogPalaiSemRegBinding15.sgpaCgpaLt : null;
        if (linearLayout12 != null) {
            linearLayout12.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding16 = this$0.get_binding();
        TextView textView5 = dialogPalaiSemRegBinding16 != null ? dialogPalaiSemRegBinding16.sgpaCgpaTv : null;
        if (textView5 != null) {
            textView5.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding17 = this$0.get_binding();
        LinearLayout linearLayout13 = dialogPalaiSemRegBinding17 != null ? dialogPalaiSemRegBinding17.supplyLt : null;
        if (linearLayout13 != null) {
            linearLayout13.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding18 = this$0.get_binding();
        TextView textView6 = dialogPalaiSemRegBinding18 != null ? dialogPalaiSemRegBinding18.supplyTv : null;
        if (textView6 != null) {
            textView6.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding19 = this$0.get_binding();
        LinearLayout linearLayout14 = dialogPalaiSemRegBinding19 != null ? dialogPalaiSemRegBinding19.prevSemLt : null;
        if (linearLayout14 != null) {
            linearLayout14.setVisibility(0);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding20 = this$0.get_binding();
        TextView textView7 = dialogPalaiSemRegBinding20 != null ? dialogPalaiSemRegBinding20.prevSemTv : null;
        if (textView7 != null) {
            textView7.setVisibility(0);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding21 = this$0.get_binding();
        LinearLayout linearLayout15 = dialogPalaiSemRegBinding21 != null ? dialogPalaiSemRegBinding21.feeDetailsLt : null;
        if (linearLayout15 != null) {
            linearLayout15.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding22 = this$0.get_binding();
        TextView textView8 = dialogPalaiSemRegBinding22 != null ? dialogPalaiSemRegBinding22.feeDetailsTv : null;
        if (textView8 != null) {
            textView8.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding23 = this$0.get_binding();
        LinearLayout linearLayout16 = dialogPalaiSemRegBinding23 != null ? dialogPalaiSemRegBinding23.dueLt : null;
        if (linearLayout16 != null) {
            linearLayout16.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding24 = this$0.get_binding();
        TextView textView9 = dialogPalaiSemRegBinding24 != null ? dialogPalaiSemRegBinding24.dueTv : null;
        if (textView9 != null) {
            textView9.setVisibility(8);
        }
        if (this$0.finalPage) {
            DialogPalaiSemRegBinding dialogPalaiSemRegBinding25 = this$0.get_binding();
            textView = dialogPalaiSemRegBinding25 != null ? dialogPalaiSemRegBinding25.registerBtn : null;
            if (textView == null) {
                return;
            }
            textView.setVisibility(0);
            return;
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding26 = this$0.get_binding();
        textView = dialogPalaiSemRegBinding26 != null ? dialogPalaiSemRegBinding26.registerBtn : null;
        if (textView == null) {
            return;
        }
        textView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$13(PalaiNewSemRegDialog this$0, View view) {
        TextView textView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding = this$0.get_binding();
        LinearLayout linearLayout = dialogPalaiSemRegBinding != null ? dialogPalaiSemRegBinding.pageOne : null;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding2 = this$0.get_binding();
        LinearLayout linearLayout2 = dialogPalaiSemRegBinding2 != null ? dialogPalaiSemRegBinding2.pageTwo : null;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding3 = this$0.get_binding();
        LinearLayout linearLayout3 = dialogPalaiSemRegBinding3 != null ? dialogPalaiSemRegBinding3.pageThree : null;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding4 = this$0.get_binding();
        LinearLayout linearLayout4 = dialogPalaiSemRegBinding4 != null ? dialogPalaiSemRegBinding4.pageFour : null;
        if (linearLayout4 != null) {
            linearLayout4.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding5 = this$0.get_binding();
        LinearLayout linearLayout5 = dialogPalaiSemRegBinding5 != null ? dialogPalaiSemRegBinding5.pageFive : null;
        if (linearLayout5 != null) {
            linearLayout5.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding6 = this$0.get_binding();
        LinearLayout linearLayout6 = dialogPalaiSemRegBinding6 != null ? dialogPalaiSemRegBinding6.pageSix : null;
        if (linearLayout6 != null) {
            linearLayout6.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding7 = this$0.get_binding();
        LinearLayout linearLayout7 = dialogPalaiSemRegBinding7 != null ? dialogPalaiSemRegBinding7.pageSeven : null;
        if (linearLayout7 != null) {
            linearLayout7.setVisibility(0);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding8 = this$0.get_binding();
        LinearLayout linearLayout8 = dialogPalaiSemRegBinding8 != null ? dialogPalaiSemRegBinding8.pageEight : null;
        if (linearLayout8 != null) {
            linearLayout8.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding9 = this$0.get_binding();
        TextView textView2 = dialogPalaiSemRegBinding9 != null ? dialogPalaiSemRegBinding9.examAttTv : null;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding10 = this$0.get_binding();
        LinearLayout linearLayout9 = dialogPalaiSemRegBinding10 != null ? dialogPalaiSemRegBinding10.universityPreviousLayout : null;
        if (linearLayout9 != null) {
            linearLayout9.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding11 = this$0.get_binding();
        LinearLayout linearLayout10 = dialogPalaiSemRegBinding11 != null ? dialogPalaiSemRegBinding11.honorMinorLt : null;
        if (linearLayout10 != null) {
            linearLayout10.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding12 = this$0.get_binding();
        TextView textView3 = dialogPalaiSemRegBinding12 != null ? dialogPalaiSemRegBinding12.honorMinorTv : null;
        if (textView3 != null) {
            textView3.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding13 = this$0.get_binding();
        LinearLayout linearLayout11 = dialogPalaiSemRegBinding13 != null ? dialogPalaiSemRegBinding13.globalElecLt : null;
        if (linearLayout11 != null) {
            linearLayout11.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding14 = this$0.get_binding();
        TextView textView4 = dialogPalaiSemRegBinding14 != null ? dialogPalaiSemRegBinding14.globalElecTv : null;
        if (textView4 != null) {
            textView4.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding15 = this$0.get_binding();
        LinearLayout linearLayout12 = dialogPalaiSemRegBinding15 != null ? dialogPalaiSemRegBinding15.sgpaCgpaLt : null;
        if (linearLayout12 != null) {
            linearLayout12.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding16 = this$0.get_binding();
        TextView textView5 = dialogPalaiSemRegBinding16 != null ? dialogPalaiSemRegBinding16.sgpaCgpaTv : null;
        if (textView5 != null) {
            textView5.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding17 = this$0.get_binding();
        LinearLayout linearLayout13 = dialogPalaiSemRegBinding17 != null ? dialogPalaiSemRegBinding17.supplyLt : null;
        if (linearLayout13 != null) {
            linearLayout13.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding18 = this$0.get_binding();
        TextView textView6 = dialogPalaiSemRegBinding18 != null ? dialogPalaiSemRegBinding18.supplyTv : null;
        if (textView6 != null) {
            textView6.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding19 = this$0.get_binding();
        LinearLayout linearLayout14 = dialogPalaiSemRegBinding19 != null ? dialogPalaiSemRegBinding19.prevSemLt : null;
        if (linearLayout14 != null) {
            linearLayout14.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding20 = this$0.get_binding();
        TextView textView7 = dialogPalaiSemRegBinding20 != null ? dialogPalaiSemRegBinding20.prevSemTv : null;
        if (textView7 != null) {
            textView7.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding21 = this$0.get_binding();
        LinearLayout linearLayout15 = dialogPalaiSemRegBinding21 != null ? dialogPalaiSemRegBinding21.feeDetailsLt : null;
        if (linearLayout15 != null) {
            linearLayout15.setVisibility(0);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding22 = this$0.get_binding();
        TextView textView8 = dialogPalaiSemRegBinding22 != null ? dialogPalaiSemRegBinding22.feeDetailsTv : null;
        if (textView8 != null) {
            textView8.setVisibility(0);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding23 = this$0.get_binding();
        LinearLayout linearLayout16 = dialogPalaiSemRegBinding23 != null ? dialogPalaiSemRegBinding23.dueLt : null;
        if (linearLayout16 != null) {
            linearLayout16.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding24 = this$0.get_binding();
        TextView textView9 = dialogPalaiSemRegBinding24 != null ? dialogPalaiSemRegBinding24.dueTv : null;
        if (textView9 != null) {
            textView9.setVisibility(8);
        }
        if (this$0.finalPage) {
            DialogPalaiSemRegBinding dialogPalaiSemRegBinding25 = this$0.get_binding();
            textView = dialogPalaiSemRegBinding25 != null ? dialogPalaiSemRegBinding25.registerBtn : null;
            if (textView == null) {
                return;
            }
            textView.setVisibility(0);
            return;
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding26 = this$0.get_binding();
        textView = dialogPalaiSemRegBinding26 != null ? dialogPalaiSemRegBinding26.registerBtn : null;
        if (textView == null) {
            return;
        }
        textView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$14(PalaiNewSemRegDialog this$0, View view) {
        TextView textView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding = this$0.get_binding();
        LinearLayout linearLayout = dialogPalaiSemRegBinding != null ? dialogPalaiSemRegBinding.pageOne : null;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding2 = this$0.get_binding();
        LinearLayout linearLayout2 = dialogPalaiSemRegBinding2 != null ? dialogPalaiSemRegBinding2.pageTwo : null;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding3 = this$0.get_binding();
        LinearLayout linearLayout3 = dialogPalaiSemRegBinding3 != null ? dialogPalaiSemRegBinding3.pageThree : null;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding4 = this$0.get_binding();
        LinearLayout linearLayout4 = dialogPalaiSemRegBinding4 != null ? dialogPalaiSemRegBinding4.pageFour : null;
        if (linearLayout4 != null) {
            linearLayout4.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding5 = this$0.get_binding();
        LinearLayout linearLayout5 = dialogPalaiSemRegBinding5 != null ? dialogPalaiSemRegBinding5.pageFive : null;
        if (linearLayout5 != null) {
            linearLayout5.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding6 = this$0.get_binding();
        LinearLayout linearLayout6 = dialogPalaiSemRegBinding6 != null ? dialogPalaiSemRegBinding6.pageSix : null;
        if (linearLayout6 != null) {
            linearLayout6.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding7 = this$0.get_binding();
        LinearLayout linearLayout7 = dialogPalaiSemRegBinding7 != null ? dialogPalaiSemRegBinding7.pageSeven : null;
        if (linearLayout7 != null) {
            linearLayout7.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding8 = this$0.get_binding();
        LinearLayout linearLayout8 = dialogPalaiSemRegBinding8 != null ? dialogPalaiSemRegBinding8.pageEight : null;
        if (linearLayout8 != null) {
            linearLayout8.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding9 = this$0.get_binding();
        TextView textView2 = dialogPalaiSemRegBinding9 != null ? dialogPalaiSemRegBinding9.examAttTv : null;
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding10 = this$0.get_binding();
        LinearLayout linearLayout9 = dialogPalaiSemRegBinding10 != null ? dialogPalaiSemRegBinding10.universityPreviousLayout : null;
        if (linearLayout9 != null) {
            linearLayout9.setVisibility(0);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding11 = this$0.get_binding();
        LinearLayout linearLayout10 = dialogPalaiSemRegBinding11 != null ? dialogPalaiSemRegBinding11.honorMinorLt : null;
        if (linearLayout10 != null) {
            linearLayout10.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding12 = this$0.get_binding();
        TextView textView3 = dialogPalaiSemRegBinding12 != null ? dialogPalaiSemRegBinding12.honorMinorTv : null;
        if (textView3 != null) {
            textView3.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding13 = this$0.get_binding();
        LinearLayout linearLayout11 = dialogPalaiSemRegBinding13 != null ? dialogPalaiSemRegBinding13.globalElecLt : null;
        if (linearLayout11 != null) {
            linearLayout11.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding14 = this$0.get_binding();
        TextView textView4 = dialogPalaiSemRegBinding14 != null ? dialogPalaiSemRegBinding14.globalElecTv : null;
        if (textView4 != null) {
            textView4.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding15 = this$0.get_binding();
        LinearLayout linearLayout12 = dialogPalaiSemRegBinding15 != null ? dialogPalaiSemRegBinding15.sgpaCgpaLt : null;
        if (linearLayout12 != null) {
            linearLayout12.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding16 = this$0.get_binding();
        TextView textView5 = dialogPalaiSemRegBinding16 != null ? dialogPalaiSemRegBinding16.sgpaCgpaTv : null;
        if (textView5 != null) {
            textView5.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding17 = this$0.get_binding();
        LinearLayout linearLayout13 = dialogPalaiSemRegBinding17 != null ? dialogPalaiSemRegBinding17.supplyLt : null;
        if (linearLayout13 != null) {
            linearLayout13.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding18 = this$0.get_binding();
        TextView textView6 = dialogPalaiSemRegBinding18 != null ? dialogPalaiSemRegBinding18.supplyTv : null;
        if (textView6 != null) {
            textView6.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding19 = this$0.get_binding();
        LinearLayout linearLayout14 = dialogPalaiSemRegBinding19 != null ? dialogPalaiSemRegBinding19.prevSemLt : null;
        if (linearLayout14 != null) {
            linearLayout14.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding20 = this$0.get_binding();
        TextView textView7 = dialogPalaiSemRegBinding20 != null ? dialogPalaiSemRegBinding20.prevSemTv : null;
        if (textView7 != null) {
            textView7.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding21 = this$0.get_binding();
        LinearLayout linearLayout15 = dialogPalaiSemRegBinding21 != null ? dialogPalaiSemRegBinding21.feeDetailsLt : null;
        if (linearLayout15 != null) {
            linearLayout15.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding22 = this$0.get_binding();
        TextView textView8 = dialogPalaiSemRegBinding22 != null ? dialogPalaiSemRegBinding22.feeDetailsTv : null;
        if (textView8 != null) {
            textView8.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding23 = this$0.get_binding();
        LinearLayout linearLayout16 = dialogPalaiSemRegBinding23 != null ? dialogPalaiSemRegBinding23.dueLt : null;
        if (linearLayout16 != null) {
            linearLayout16.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding24 = this$0.get_binding();
        TextView textView9 = dialogPalaiSemRegBinding24 != null ? dialogPalaiSemRegBinding24.dueTv : null;
        if (textView9 != null) {
            textView9.setVisibility(8);
        }
        if (this$0.finalPage) {
            DialogPalaiSemRegBinding dialogPalaiSemRegBinding25 = this$0.get_binding();
            textView = dialogPalaiSemRegBinding25 != null ? dialogPalaiSemRegBinding25.registerBtn : null;
            if (textView == null) {
                return;
            }
            textView.setVisibility(0);
            return;
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding26 = this$0.get_binding();
        textView = dialogPalaiSemRegBinding26 != null ? dialogPalaiSemRegBinding26.registerBtn : null;
        if (textView == null) {
            return;
        }
        textView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$16(final PalaiNewSemRegDialog this$0, Ref.IntRef year, final Ref.IntRef month, final Ref.IntRef day, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(year, "$year");
        Intrinsics.checkNotNullParameter(month, "$month");
        Intrinsics.checkNotNullParameter(day, "$day");
        new DatePickerDialog(this$0.requireContext(), new DatePickerDialog.OnDateSetListener() { // from class: in.etuwa.app.ui.semregistration.sjcetpalai.newregistration.PalaiNewSemRegDialog$$ExternalSyntheticLambda47
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                PalaiNewSemRegDialog.setUp$lambda$16$lambda$15(PalaiNewSemRegDialog.this, month, day, datePicker, i, i2, i3);
            }
        }, year.element, month.element, day.element).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$16$lambda$15(PalaiNewSemRegDialog this$0, Ref.IntRef month, Ref.IntRef day, DatePicker datePicker, int i, int i2, int i3) {
        EditText editText;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(month, "$month");
        Intrinsics.checkNotNullParameter(day, "$day");
        System.out.println((Object) (i + " and " + i2 + " and " + i3));
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding = this$0.get_binding();
        if (dialogPalaiSemRegBinding == null || (editText = dialogPalaiSemRegBinding.semDateOne) == null) {
            return;
        }
        editText.setText(i + HelpFormatter.DEFAULT_OPT_PREFIX + (month.element + 1) + HelpFormatter.DEFAULT_OPT_PREFIX + day.element);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$18(PalaiNewSemRegDialog this$0, Ref.IntRef year, Ref.IntRef month, Ref.IntRef day, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(year, "$year");
        Intrinsics.checkNotNullParameter(month, "$month");
        Intrinsics.checkNotNullParameter(day, "$day");
        new DatePickerDialog(this$0.requireContext(), new DatePickerDialog.OnDateSetListener() { // from class: in.etuwa.app.ui.semregistration.sjcetpalai.newregistration.PalaiNewSemRegDialog$$ExternalSyntheticLambda22
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                PalaiNewSemRegDialog.setUp$lambda$18$lambda$17(datePicker, i, i2, i3);
            }
        }, year.element, month.element, day.element).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$18$lambda$17(DatePicker datePicker, int i, int i2, int i3) {
        System.out.println((Object) (i + " and " + i2 + " and " + i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$20(PalaiNewSemRegDialog this$0, Ref.IntRef year, Ref.IntRef month, Ref.IntRef day, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(year, "$year");
        Intrinsics.checkNotNullParameter(month, "$month");
        Intrinsics.checkNotNullParameter(day, "$day");
        new DatePickerDialog(this$0.requireContext(), new DatePickerDialog.OnDateSetListener() { // from class: in.etuwa.app.ui.semregistration.sjcetpalai.newregistration.PalaiNewSemRegDialog$$ExternalSyntheticLambda46
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                PalaiNewSemRegDialog.setUp$lambda$20$lambda$19(datePicker, i, i2, i3);
            }
        }, year.element, month.element, day.element).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$20$lambda$19(DatePicker datePicker, int i, int i2, int i3) {
        System.out.println((Object) (i + " and " + i2 + " and " + i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$22(PalaiNewSemRegDialog this$0, Ref.IntRef year, Ref.IntRef month, Ref.IntRef day, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(year, "$year");
        Intrinsics.checkNotNullParameter(month, "$month");
        Intrinsics.checkNotNullParameter(day, "$day");
        new DatePickerDialog(this$0.requireContext(), new DatePickerDialog.OnDateSetListener() { // from class: in.etuwa.app.ui.semregistration.sjcetpalai.newregistration.PalaiNewSemRegDialog$$ExternalSyntheticLambda33
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                PalaiNewSemRegDialog.setUp$lambda$22$lambda$21(datePicker, i, i2, i3);
            }
        }, year.element, month.element, day.element).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$22$lambda$21(DatePicker datePicker, int i, int i2, int i3) {
        System.out.println((Object) (i + " and " + i2 + " and " + i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$24(PalaiNewSemRegDialog this$0, Ref.IntRef year, Ref.IntRef month, Ref.IntRef day, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(year, "$year");
        Intrinsics.checkNotNullParameter(month, "$month");
        Intrinsics.checkNotNullParameter(day, "$day");
        new DatePickerDialog(this$0.requireContext(), new DatePickerDialog.OnDateSetListener() { // from class: in.etuwa.app.ui.semregistration.sjcetpalai.newregistration.PalaiNewSemRegDialog$$ExternalSyntheticLambda0
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                PalaiNewSemRegDialog.setUp$lambda$24$lambda$23(datePicker, i, i2, i3);
            }
        }, year.element, month.element, day.element).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$24$lambda$23(DatePicker datePicker, int i, int i2, int i3) {
        System.out.println((Object) (i + " and " + i2 + " and " + i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$26(PalaiNewSemRegDialog this$0, Ref.IntRef year, Ref.IntRef month, Ref.IntRef day, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(year, "$year");
        Intrinsics.checkNotNullParameter(month, "$month");
        Intrinsics.checkNotNullParameter(day, "$day");
        new DatePickerDialog(this$0.requireContext(), new DatePickerDialog.OnDateSetListener() { // from class: in.etuwa.app.ui.semregistration.sjcetpalai.newregistration.PalaiNewSemRegDialog$$ExternalSyntheticLambda11
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                PalaiNewSemRegDialog.setUp$lambda$26$lambda$25(datePicker, i, i2, i3);
            }
        }, year.element, month.element, day.element).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$26$lambda$25(DatePicker datePicker, int i, int i2, int i3) {
        System.out.println((Object) (i + " and " + i2 + " and " + i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$28(PalaiNewSemRegDialog this$0, Ref.IntRef year, Ref.IntRef month, Ref.IntRef day, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(year, "$year");
        Intrinsics.checkNotNullParameter(month, "$month");
        Intrinsics.checkNotNullParameter(day, "$day");
        new DatePickerDialog(this$0.requireContext(), new DatePickerDialog.OnDateSetListener() { // from class: in.etuwa.app.ui.semregistration.sjcetpalai.newregistration.PalaiNewSemRegDialog$$ExternalSyntheticLambda45
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                PalaiNewSemRegDialog.setUp$lambda$28$lambda$27(datePicker, i, i2, i3);
            }
        }, year.element, month.element, day.element).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$28$lambda$27(DatePicker datePicker, int i, int i2, int i3) {
        System.out.println((Object) (i + " and " + i2 + " and " + i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$30(PalaiNewSemRegDialog this$0, Ref.IntRef year, Ref.IntRef month, Ref.IntRef day, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(year, "$year");
        Intrinsics.checkNotNullParameter(month, "$month");
        Intrinsics.checkNotNullParameter(day, "$day");
        new DatePickerDialog(this$0.requireContext(), new DatePickerDialog.OnDateSetListener() { // from class: in.etuwa.app.ui.semregistration.sjcetpalai.newregistration.PalaiNewSemRegDialog$$ExternalSyntheticLambda44
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                PalaiNewSemRegDialog.setUp$lambda$30$lambda$29(datePicker, i, i2, i3);
            }
        }, year.element, month.element, day.element).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$30$lambda$29(DatePicker datePicker, int i, int i2, int i3) {
        System.out.println((Object) (i + " and " + i2 + " and " + i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$31(PalaiNewSemRegDialog this$0, RadioGroup radioGroup, int i) {
        TextInputLayout textInputLayout;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(radioGroup, "radioGroup");
        if (radioGroup.getCheckedRadioButtonId() == R.id.exam_yes) {
            DialogPalaiSemRegBinding dialogPalaiSemRegBinding = this$0.get_binding();
            textInputLayout = dialogPalaiSemRegBinding != null ? dialogPalaiSemRegBinding.mtMonthYear : null;
            if (textInputLayout != null) {
                textInputLayout.setVisibility(0);
            }
            String string = this$0.getString(R.string.yes);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.yes)");
            this$0.reg = string;
            return;
        }
        this$0.regDetails = "";
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding2 = this$0.get_binding();
        textInputLayout = dialogPalaiSemRegBinding2 != null ? dialogPalaiSemRegBinding2.mtMonthYear : null;
        if (textInputLayout != null) {
            textInputLayout.setVisibility(8);
        }
        String string2 = this$0.getString(R.string.no);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.no)");
        this$0.reg = string2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$32(PalaiNewSemRegDialog this$0, RadioGroup radioGroup, int i) {
        TextInputLayout textInputLayout;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(radioGroup, "radioGroup");
        if (radioGroup.getCheckedRadioButtonId() == R.id.bus_yes) {
            DialogPalaiSemRegBinding dialogPalaiSemRegBinding = this$0.get_binding();
            textInputLayout = dialogPalaiSemRegBinding != null ? dialogPalaiSemRegBinding.mtBusDetail : null;
            if (textInputLayout != null) {
                textInputLayout.setVisibility(0);
            }
            String string = this$0.getString(R.string.yes);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.yes)");
            this$0.reg = string;
            return;
        }
        this$0.regDetails = "";
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding2 = this$0.get_binding();
        textInputLayout = dialogPalaiSemRegBinding2 != null ? dialogPalaiSemRegBinding2.mtBusDetail : null;
        if (textInputLayout != null) {
            textInputLayout.setVisibility(8);
        }
        String string2 = this$0.getString(R.string.no);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.no)");
        this$0.reg = string2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$33(PalaiNewSemRegDialog this$0, RadioGroup radioGroup, int i) {
        TextInputLayout textInputLayout;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(radioGroup, "radioGroup");
        if (radioGroup.getCheckedRadioButtonId() == R.id.bus_yes) {
            DialogPalaiSemRegBinding dialogPalaiSemRegBinding = this$0.get_binding();
            TextInputLayout textInputLayout2 = dialogPalaiSemRegBinding != null ? dialogPalaiSemRegBinding.mtBankName : null;
            if (textInputLayout2 != null) {
                textInputLayout2.setVisibility(0);
            }
            DialogPalaiSemRegBinding dialogPalaiSemRegBinding2 = this$0.get_binding();
            TextInputLayout textInputLayout3 = dialogPalaiSemRegBinding2 != null ? dialogPalaiSemRegBinding2.mtAmountPaid : null;
            if (textInputLayout3 != null) {
                textInputLayout3.setVisibility(0);
            }
            DialogPalaiSemRegBinding dialogPalaiSemRegBinding3 = this$0.get_binding();
            TextInputLayout textInputLayout4 = dialogPalaiSemRegBinding3 != null ? dialogPalaiSemRegBinding3.mtDatePayment : null;
            if (textInputLayout4 != null) {
                textInputLayout4.setVisibility(0);
            }
            DialogPalaiSemRegBinding dialogPalaiSemRegBinding4 = this$0.get_binding();
            TextInputLayout textInputLayout5 = dialogPalaiSemRegBinding4 != null ? dialogPalaiSemRegBinding4.mtModePayment : null;
            if (textInputLayout5 != null) {
                textInputLayout5.setVisibility(0);
            }
            DialogPalaiSemRegBinding dialogPalaiSemRegBinding5 = this$0.get_binding();
            textInputLayout = dialogPalaiSemRegBinding5 != null ? dialogPalaiSemRegBinding5.mtRefNo : null;
            if (textInputLayout != null) {
                textInputLayout.setVisibility(0);
            }
            String string = this$0.getString(R.string.yes);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.yes)");
            this$0.reg = string;
            return;
        }
        this$0.regDetails = "";
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding6 = this$0.get_binding();
        TextInputLayout textInputLayout6 = dialogPalaiSemRegBinding6 != null ? dialogPalaiSemRegBinding6.mtBankName : null;
        if (textInputLayout6 != null) {
            textInputLayout6.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding7 = this$0.get_binding();
        TextInputLayout textInputLayout7 = dialogPalaiSemRegBinding7 != null ? dialogPalaiSemRegBinding7.mtAmountPaid : null;
        if (textInputLayout7 != null) {
            textInputLayout7.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding8 = this$0.get_binding();
        TextInputLayout textInputLayout8 = dialogPalaiSemRegBinding8 != null ? dialogPalaiSemRegBinding8.mtDatePayment : null;
        if (textInputLayout8 != null) {
            textInputLayout8.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding9 = this$0.get_binding();
        TextInputLayout textInputLayout9 = dialogPalaiSemRegBinding9 != null ? dialogPalaiSemRegBinding9.mtModePayment : null;
        if (textInputLayout9 != null) {
            textInputLayout9.setVisibility(8);
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding10 = this$0.get_binding();
        textInputLayout = dialogPalaiSemRegBinding10 != null ? dialogPalaiSemRegBinding10.mtRefNo : null;
        if (textInputLayout != null) {
            textInputLayout.setVisibility(8);
        }
        String string2 = this$0.getString(R.string.no);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.no)");
        this$0.reg = string2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$34(PalaiNewSemRegDialog this$0, RadioGroup radioGroup, int i) {
        TextInputLayout textInputLayout;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(radioGroup, "radioGroup");
        if (radioGroup.getCheckedRadioButtonId() == R.id.exam_yes) {
            DialogPalaiSemRegBinding dialogPalaiSemRegBinding = this$0.get_binding();
            textInputLayout = dialogPalaiSemRegBinding != null ? dialogPalaiSemRegBinding.mtMonthYear : null;
            if (textInputLayout != null) {
                textInputLayout.setVisibility(0);
            }
            String string = this$0.getString(R.string.yes);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.yes)");
            this$0.reg = string;
            return;
        }
        this$0.regDetails = "";
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding2 = this$0.get_binding();
        textInputLayout = dialogPalaiSemRegBinding2 != null ? dialogPalaiSemRegBinding2.mtMonthYear : null;
        if (textInputLayout != null) {
            textInputLayout.setVisibility(8);
        }
        String string2 = this$0.getString(R.string.no);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.no)");
        this$0.reg = string2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$35(PalaiNewSemRegDialog this$0, RadioGroup radioGroup, int i) {
        TextInputLayout textInputLayout;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(radioGroup, "radioGroup");
        if (radioGroup.getCheckedRadioButtonId() == R.id.bus_yes) {
            DialogPalaiSemRegBinding dialogPalaiSemRegBinding = this$0.get_binding();
            textInputLayout = dialogPalaiSemRegBinding != null ? dialogPalaiSemRegBinding.mtBusDetail : null;
            if (textInputLayout != null) {
                textInputLayout.setVisibility(0);
            }
            String string = this$0.getString(R.string.yes);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.yes)");
            this$0.bus = string;
            return;
        }
        this$0.busDetails = "";
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding2 = this$0.get_binding();
        textInputLayout = dialogPalaiSemRegBinding2 != null ? dialogPalaiSemRegBinding2.mtBusDetail : null;
        if (textInputLayout != null) {
            textInputLayout.setVisibility(8);
        }
        String string2 = this$0.getString(R.string.no);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.no)");
        this$0.bus = string2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$36(PalaiNewSemRegDialog this$0, RadioGroup radioGroup, int i) {
        TextInputLayout textInputLayout;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(radioGroup, "radioGroup");
        if (radioGroup.getCheckedRadioButtonId() == R.id.back_yes) {
            DialogPalaiSemRegBinding dialogPalaiSemRegBinding = this$0.get_binding();
            textInputLayout = dialogPalaiSemRegBinding != null ? dialogPalaiSemRegBinding.mtBackPapers : null;
            if (textInputLayout != null) {
                textInputLayout.setVisibility(0);
            }
            String string = this$0.getString(R.string.yes);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.yes)");
            this$0.back = string;
            return;
        }
        this$0.backDetails = "";
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding2 = this$0.get_binding();
        textInputLayout = dialogPalaiSemRegBinding2 != null ? dialogPalaiSemRegBinding2.mtBackPapers : null;
        if (textInputLayout != null) {
            textInputLayout.setVisibility(8);
        }
        String string2 = this$0.getString(R.string.no);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.no)");
        this$0.back = string2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$37(PalaiNewSemRegDialog this$0, RadioGroup radioGroup, int i) {
        TextInputLayout textInputLayout;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(radioGroup, "radioGroup");
        if (radioGroup.getCheckedRadioButtonId() == R.id.back_yes) {
            DialogPalaiSemRegBinding dialogPalaiSemRegBinding = this$0.get_binding();
            textInputLayout = dialogPalaiSemRegBinding != null ? dialogPalaiSemRegBinding.mtDeptDetail : null;
            if (textInputLayout != null) {
                textInputLayout.setVisibility(0);
            }
            String string = this$0.getString(R.string.yes);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.yes)");
            this$0.dept = string;
            return;
        }
        this$0.deptDetails = "";
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding2 = this$0.get_binding();
        textInputLayout = dialogPalaiSemRegBinding2 != null ? dialogPalaiSemRegBinding2.mtDeptDetail : null;
        if (textInputLayout != null) {
            textInputLayout.setVisibility(8);
        }
        String string2 = this$0.getString(R.string.no);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.no)");
        this$0.dept = string2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$38(PalaiNewSemRegDialog this$0, RadioGroup radioGroup, int i) {
        TextInputLayout textInputLayout;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(radioGroup, "radioGroup");
        if (radioGroup.getCheckedRadioButtonId() == R.id.back_yes) {
            DialogPalaiSemRegBinding dialogPalaiSemRegBinding = this$0.get_binding();
            textInputLayout = dialogPalaiSemRegBinding != null ? dialogPalaiSemRegBinding.mtConcessionDetsils : null;
            if (textInputLayout != null) {
                textInputLayout.setVisibility(0);
            }
            String string = this$0.getString(R.string.yes);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.yes)");
            this$0.feeConcession = string;
            return;
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding2 = this$0.get_binding();
        textInputLayout = dialogPalaiSemRegBinding2 != null ? dialogPalaiSemRegBinding2.mtConcessionDetsils : null;
        if (textInputLayout != null) {
            textInputLayout.setVisibility(8);
        }
        String string2 = this$0.getString(R.string.no);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.no)");
        this$0.feeConcession = string2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$39(PalaiNewSemRegDialog this$0, RadioGroup radioGroup, int i) {
        TextInputLayout textInputLayout;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(radioGroup, "radioGroup");
        if (radioGroup.getCheckedRadioButtonId() == R.id.back_yes) {
            DialogPalaiSemRegBinding dialogPalaiSemRegBinding = this$0.get_binding();
            textInputLayout = dialogPalaiSemRegBinding != null ? dialogPalaiSemRegBinding.mtAcademicDetail : null;
            if (textInputLayout != null) {
                textInputLayout.setVisibility(0);
            }
            String string = this$0.getString(R.string.yes);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.yes)");
            this$0.academics = string;
            return;
        }
        this$0.academicsDetails = "";
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding2 = this$0.get_binding();
        textInputLayout = dialogPalaiSemRegBinding2 != null ? dialogPalaiSemRegBinding2.mtAcademicDetail : null;
        if (textInputLayout != null) {
            textInputLayout.setVisibility(8);
        }
        String string2 = this$0.getString(R.string.no);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.no)");
        this$0.academics = string2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$40(PalaiNewSemRegDialog this$0, RadioGroup radioGroup, int i) {
        TextInputLayout textInputLayout;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(radioGroup, "radioGroup");
        if (radioGroup.getCheckedRadioButtonId() == R.id.back_yes) {
            DialogPalaiSemRegBinding dialogPalaiSemRegBinding = this$0.get_binding();
            textInputLayout = dialogPalaiSemRegBinding != null ? dialogPalaiSemRegBinding.mtAccountDetail : null;
            if (textInputLayout != null) {
                textInputLayout.setVisibility(0);
            }
            String string = this$0.getString(R.string.yes);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.yes)");
            this$0.accounts = string;
            return;
        }
        this$0.accountsDetails = "";
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding2 = this$0.get_binding();
        textInputLayout = dialogPalaiSemRegBinding2 != null ? dialogPalaiSemRegBinding2.mtAccountDetail : null;
        if (textInputLayout != null) {
            textInputLayout.setVisibility(8);
        }
        String string2 = this$0.getString(R.string.no);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.no)");
        this$0.accounts = string2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$41(PalaiNewSemRegDialog this$0, RadioGroup radioGroup, int i) {
        TextInputLayout textInputLayout;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(radioGroup, "radioGroup");
        if (radioGroup.getCheckedRadioButtonId() == R.id.back_yes) {
            DialogPalaiSemRegBinding dialogPalaiSemRegBinding = this$0.get_binding();
            textInputLayout = dialogPalaiSemRegBinding != null ? dialogPalaiSemRegBinding.mtLibraryDetail : null;
            if (textInputLayout != null) {
                textInputLayout.setVisibility(0);
            }
            String string = this$0.getString(R.string.yes);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.yes)");
            this$0.library = string;
            return;
        }
        this$0.libraryDetails = "";
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding2 = this$0.get_binding();
        textInputLayout = dialogPalaiSemRegBinding2 != null ? dialogPalaiSemRegBinding2.mtLibraryDetail : null;
        if (textInputLayout != null) {
            textInputLayout.setVisibility(8);
        }
        String string2 = this$0.getString(R.string.no);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.no)");
        this$0.library = string2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$42(PalaiNewSemRegDialog this$0, RadioGroup radioGroup, int i) {
        TextInputLayout textInputLayout;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(radioGroup, "radioGroup");
        if (radioGroup.getCheckedRadioButtonId() == R.id.back_yes) {
            DialogPalaiSemRegBinding dialogPalaiSemRegBinding = this$0.get_binding();
            textInputLayout = dialogPalaiSemRegBinding != null ? dialogPalaiSemRegBinding.mtHostelDetail : null;
            if (textInputLayout != null) {
                textInputLayout.setVisibility(0);
            }
            String string = this$0.getString(R.string.yes);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.yes)");
            this$0.hostel = string;
            return;
        }
        this$0.hostelDetails = "";
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding2 = this$0.get_binding();
        textInputLayout = dialogPalaiSemRegBinding2 != null ? dialogPalaiSemRegBinding2.mtHostelDetail : null;
        if (textInputLayout != null) {
            textInputLayout.setVisibility(8);
        }
        String string2 = this$0.getString(R.string.no);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.no)");
        this$0.hostel = string2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$43(PalaiNewSemRegDialog this$0, View view) {
        LinearLayout linearLayout;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.examAttClicked) {
            this$0.examAttClicked = true;
            DialogPalaiSemRegBinding dialogPalaiSemRegBinding = this$0.get_binding();
            linearLayout = dialogPalaiSemRegBinding != null ? dialogPalaiSemRegBinding.universityPreviousLayout : null;
            if (linearLayout == null) {
                return;
            }
            linearLayout.setVisibility(0);
            return;
        }
        this$0.examAttClicked = false;
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding2 = this$0.get_binding();
        linearLayout = dialogPalaiSemRegBinding2 != null ? dialogPalaiSemRegBinding2.universityPreviousLayout : null;
        if (linearLayout == null) {
            return;
        }
        linearLayout.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$44(PalaiNewSemRegDialog this$0, View view) {
        LinearLayout linearLayout;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.honorMinorClicked) {
            this$0.honorMinorClicked = true;
            DialogPalaiSemRegBinding dialogPalaiSemRegBinding = this$0.get_binding();
            linearLayout = dialogPalaiSemRegBinding != null ? dialogPalaiSemRegBinding.honorMinorLt : null;
            if (linearLayout == null) {
                return;
            }
            linearLayout.setVisibility(0);
            return;
        }
        this$0.honorMinorClicked = false;
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding2 = this$0.get_binding();
        linearLayout = dialogPalaiSemRegBinding2 != null ? dialogPalaiSemRegBinding2.honorMinorLt : null;
        if (linearLayout == null) {
            return;
        }
        linearLayout.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$45(PalaiNewSemRegDialog this$0, View view) {
        LinearLayout linearLayout;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.globalElectiveClicked) {
            this$0.globalElectiveClicked = true;
            DialogPalaiSemRegBinding dialogPalaiSemRegBinding = this$0.get_binding();
            linearLayout = dialogPalaiSemRegBinding != null ? dialogPalaiSemRegBinding.globalElecLt : null;
            if (linearLayout == null) {
                return;
            }
            linearLayout.setVisibility(0);
            return;
        }
        this$0.globalElectiveClicked = false;
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding2 = this$0.get_binding();
        linearLayout = dialogPalaiSemRegBinding2 != null ? dialogPalaiSemRegBinding2.globalElecLt : null;
        if (linearLayout == null) {
            return;
        }
        linearLayout.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$46(PalaiNewSemRegDialog this$0, View view) {
        LinearLayout linearLayout;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.cgpaClicked) {
            this$0.cgpaClicked = true;
            DialogPalaiSemRegBinding dialogPalaiSemRegBinding = this$0.get_binding();
            linearLayout = dialogPalaiSemRegBinding != null ? dialogPalaiSemRegBinding.sgpaCgpaLt : null;
            if (linearLayout == null) {
                return;
            }
            linearLayout.setVisibility(0);
            return;
        }
        this$0.cgpaClicked = false;
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding2 = this$0.get_binding();
        linearLayout = dialogPalaiSemRegBinding2 != null ? dialogPalaiSemRegBinding2.sgpaCgpaLt : null;
        if (linearLayout == null) {
            return;
        }
        linearLayout.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$47(PalaiNewSemRegDialog this$0, View view) {
        LinearLayout linearLayout;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.supplyClicked) {
            this$0.supplyClicked = true;
            DialogPalaiSemRegBinding dialogPalaiSemRegBinding = this$0.get_binding();
            linearLayout = dialogPalaiSemRegBinding != null ? dialogPalaiSemRegBinding.supplyLt : null;
            if (linearLayout == null) {
                return;
            }
            linearLayout.setVisibility(0);
            return;
        }
        this$0.supplyClicked = false;
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding2 = this$0.get_binding();
        linearLayout = dialogPalaiSemRegBinding2 != null ? dialogPalaiSemRegBinding2.supplyLt : null;
        if (linearLayout == null) {
            return;
        }
        linearLayout.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$48(PalaiNewSemRegDialog this$0, View view) {
        LinearLayout linearLayout;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.prevSemClicked) {
            this$0.prevSemClicked = true;
            DialogPalaiSemRegBinding dialogPalaiSemRegBinding = this$0.get_binding();
            linearLayout = dialogPalaiSemRegBinding != null ? dialogPalaiSemRegBinding.prevSemLt : null;
            if (linearLayout == null) {
                return;
            }
            linearLayout.setVisibility(0);
            return;
        }
        this$0.prevSemClicked = false;
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding2 = this$0.get_binding();
        linearLayout = dialogPalaiSemRegBinding2 != null ? dialogPalaiSemRegBinding2.prevSemLt : null;
        if (linearLayout == null) {
            return;
        }
        linearLayout.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$49(PalaiNewSemRegDialog this$0, View view) {
        LinearLayout linearLayout;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.feeClicked) {
            this$0.feeClicked = true;
            DialogPalaiSemRegBinding dialogPalaiSemRegBinding = this$0.get_binding();
            linearLayout = dialogPalaiSemRegBinding != null ? dialogPalaiSemRegBinding.feeDetailsLt : null;
            if (linearLayout == null) {
                return;
            }
            linearLayout.setVisibility(0);
            return;
        }
        this$0.feeClicked = false;
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding2 = this$0.get_binding();
        linearLayout = dialogPalaiSemRegBinding2 != null ? dialogPalaiSemRegBinding2.feeDetailsLt : null;
        if (linearLayout == null) {
            return;
        }
        linearLayout.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$50(PalaiNewSemRegDialog this$0, View view) {
        LinearLayout linearLayout;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.dueClicked) {
            this$0.dueClicked = true;
            DialogPalaiSemRegBinding dialogPalaiSemRegBinding = this$0.get_binding();
            linearLayout = dialogPalaiSemRegBinding != null ? dialogPalaiSemRegBinding.dueLt : null;
            if (linearLayout == null) {
                return;
            }
            linearLayout.setVisibility(0);
            return;
        }
        this$0.dueClicked = false;
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding2 = this$0.get_binding();
        linearLayout = dialogPalaiSemRegBinding2 != null ? dialogPalaiSemRegBinding2.dueLt : null;
        if (linearLayout == null) {
            return;
        }
        linearLayout.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$51(PalaiNewSemRegDialog this$0, View view) {
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
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Editable editable = null;
        if (Intrinsics.areEqual(this$0.reg, "Yes")) {
            DialogPalaiSemRegBinding dialogPalaiSemRegBinding = this$0.get_binding();
            if (Intrinsics.areEqual(String.valueOf((dialogPalaiSemRegBinding == null || (textInputEditText14 = dialogPalaiSemRegBinding.etMonthYear) == null) ? null : textInputEditText14.getText()), "")) {
                DialogPalaiSemRegBinding dialogPalaiSemRegBinding2 = this$0.get_binding();
                if (dialogPalaiSemRegBinding2 == null || (textInputEditText13 = dialogPalaiSemRegBinding2.etMonthYear) == null) {
                    return;
                }
                ToastExtKt.showErrorToast(textInputEditText13, "Please Fill Registered Month and year!!");
                return;
            }
        }
        if (Intrinsics.areEqual(this$0.back, "Yes")) {
            DialogPalaiSemRegBinding dialogPalaiSemRegBinding3 = this$0.get_binding();
            if (Intrinsics.areEqual(String.valueOf((dialogPalaiSemRegBinding3 == null || (textInputEditText12 = dialogPalaiSemRegBinding3.etBackPaperCount) == null) ? null : textInputEditText12.getText()), "")) {
                DialogPalaiSemRegBinding dialogPalaiSemRegBinding4 = this$0.get_binding();
                if (dialogPalaiSemRegBinding4 == null || (textInputEditText11 = dialogPalaiSemRegBinding4.etBackPaperCount) == null) {
                    return;
                }
                ToastExtKt.showErrorToast(textInputEditText11, "Please specify number of back papers!!");
                return;
            }
        }
        HashMap hashMap = new HashMap();
        hashMap.put("SemesterRegistration[semester_id]", this$0.sem);
        hashMap.put("SemesterRegistration[exam_appear]", this$0.reg);
        hashMap.put("SemesterRegistration[backpaper]", this$0.back);
        if (Intrinsics.areEqual(this$0.reg, "Yes")) {
            DialogPalaiSemRegBinding dialogPalaiSemRegBinding5 = this$0.get_binding();
            hashMap.put("SemesterRegistration[exam_month_year]", String.valueOf((dialogPalaiSemRegBinding5 == null || (textInputEditText10 = dialogPalaiSemRegBinding5.etMonthYear) == null) ? null : textInputEditText10.getText()));
        } else {
            hashMap.put("SemesterRegistration[exam_month_year]", "");
        }
        if (Intrinsics.areEqual(this$0.back, "Yes")) {
            DialogPalaiSemRegBinding dialogPalaiSemRegBinding6 = this$0.get_binding();
            hashMap.put("SemesterRegistration[backlogs_count]", String.valueOf((dialogPalaiSemRegBinding6 == null || (textInputEditText9 = dialogPalaiSemRegBinding6.etBackPaperCount) == null) ? null : textInputEditText9.getText()));
        } else {
            hashMap.put("SemesterRegistration[backlogs_count]", "");
        }
        DialogPalaiSemRegBinding dialogPalaiSemRegBinding7 = this$0.get_binding();
        hashMap.put("SemregExamdetail[period_discontinue]", String.valueOf((dialogPalaiSemRegBinding7 == null || (textInputEditText8 = dialogPalaiSemRegBinding7.etPeriodDiscontinued) == null) ? null : textInputEditText8.getText()));
        hashMap.put("SemesterRegistration[honour]", this$0.honor);
        hashMap.put("SemesterRegistration[minor]", this$0.minor);
        hashMap.put("SemesterRegistration[elective1]", this$0.minor);
        hashMap.put("SemesterRegistration[elective2]", this$0.minor);
        hashMap.put("SemesterRegistration[elective3]", this$0.minor);
        hashMap.put("SemesterRegistration[global_elective1]", this$0.minor);
        hashMap.put("SemesterRegistration[global_elective2]", this$0.minor);
        hashMap.put("SemesterRegistration[global_elective3]", this$0.minor);
        hashMap.put("SemregExamdetail[sgpa_one]", this$0.minor);
        hashMap.put("SemregExamdetail[sgpa_two]", this$0.minor);
        hashMap.put("SemregExamdetail[sgpa_three]", this$0.minor);
        hashMap.put("SemregExamdetail[sgpa_four]", this$0.minor);
        hashMap.put("SemregExamdetail[sgpa_five]", this$0.minor);
        hashMap.put("SemregExamdetail[sgpa_six]", this$0.minor);
        hashMap.put("SemregExamdetail[sgpa_seven]", this$0.minor);
        hashMap.put("SemregExamdetail[cgpa_one]", this$0.minor);
        hashMap.put("SemregExamdetail[cgpa_two]", this$0.minor);
        hashMap.put("SemregExamdetail[cgpa_three]", this$0.minor);
        hashMap.put("SemregExamdetail[cgpa_four]", this$0.minor);
        hashMap.put("SemregExamdetail[cgpa_five]", this$0.minor);
        hashMap.put("SemregExamdetail[cgpa_six]", this$0.minor);
        hashMap.put("SemregExamdetail[cgpa_seven]", this$0.minor);
        hashMap.put("SemregExamdetail[exam_one]", this$0.minor);
        hashMap.put("SemregExamdetail[exam_two]", this$0.minor);
        hashMap.put("SemregExamdetail[exam_three]", this$0.minor);
        hashMap.put("SemregExamdetail[exam_four]", this$0.minor);
        hashMap.put("SemregExamdetail[exam_five]", this$0.minor);
        hashMap.put("SemregExamdetail[exam_six]", this$0.minor);
        hashMap.put("SemregExamdetail[exam_seven]", this$0.minor);
        hashMap.put("SemregExamdetail[exam_date_one]", this$0.minor);
        hashMap.put("SemregExamdetail[exam_date_two]", this$0.minor);
        hashMap.put("SemregExamdetail[exam_date_three]", this$0.minor);
        hashMap.put("SemregExamdetail[exam_date_four]", this$0.minor);
        hashMap.put("SemregExamdetail[exam_date_five]", this$0.minor);
        hashMap.put("SemregExamdetail[exam_date_six]", this$0.minor);
        hashMap.put("SemregExamdetail[exam_date_seven]", this$0.minor);
        hashMap.put("SemesterRegistration[position_held]", this$0.minor);
        hashMap.put("SemesterRegistration[stay]", this$0.minor);
        hashMap.put("SemesterRegistration[membership]", this$0.minor);
        hashMap.put("SemesterRegistration[stay_detail]", this$0.minor);
        hashMap.put("SemesterRegistration[prize_won]", this$0.minor);
        hashMap.put("SemesterRegistration[contact_owner]", this$0.minor);
        hashMap.put("SemesterRegistration[attendance]", this$0.minor);
        hashMap.put("SemesterRegistration[condonation]", this$0.minor);
        hashMap.put("SemesterRegistration[fee_paid]", this$0.minor);
        hashMap.put("SemesterRegistration[bank_name]", this$0.minor);
        hashMap.put("SemesterRegistration[amount_paid]", this$0.minor);
        hashMap.put("SemesterRegistration[payment_date]", this$0.minor);
        hashMap.put("SemesterRegistration[payment_mode]", this$0.minor);
        hashMap.put("SemesterRegistration[payment_reference_no]", this$0.minor);
        hashMap.put("SemesterRegistration[fee_concession]", this$0.feeConcession);
        if (Intrinsics.areEqual(this$0.feeConcession, "Yes")) {
            DialogPalaiSemRegBinding dialogPalaiSemRegBinding8 = this$0.get_binding();
            hashMap.put("SemesterRegistration[fee_concession_category]", String.valueOf((dialogPalaiSemRegBinding8 == null || (textInputEditText7 = dialogPalaiSemRegBinding8.etConcessionDetails) == null) ? null : textInputEditText7.getText()));
        } else {
            hashMap.put("SemesterRegistration[fee_concession_category]", "");
        }
        hashMap.put("SemesterRegistration[department_due]", this$0.dept);
        if (Intrinsics.areEqual(this$0.dept, "Yes")) {
            DialogPalaiSemRegBinding dialogPalaiSemRegBinding9 = this$0.get_binding();
            hashMap.put("SemesterRegistration[department_due_details]", String.valueOf((dialogPalaiSemRegBinding9 == null || (textInputEditText6 = dialogPalaiSemRegBinding9.etDeptDetails) == null) ? null : textInputEditText6.getText()));
        } else {
            hashMap.put("SemesterRegistration[department_due_details]", "");
        }
        hashMap.put("SemesterRegistration[library_due]", this$0.library);
        if (Intrinsics.areEqual(this$0.library, "Yes")) {
            DialogPalaiSemRegBinding dialogPalaiSemRegBinding10 = this$0.get_binding();
            hashMap.put("SemesterRegistration[librarary_due_details]", String.valueOf((dialogPalaiSemRegBinding10 == null || (textInputEditText5 = dialogPalaiSemRegBinding10.etLibraryDetails) == null) ? null : textInputEditText5.getText()));
        } else {
            hashMap.put("SemesterRegistration[librarary_due_details]", "");
        }
        hashMap.put("SemesterRegistration[accounts_due]", this$0.accounts);
        if (Intrinsics.areEqual(this$0.accounts, "Yes")) {
            DialogPalaiSemRegBinding dialogPalaiSemRegBinding11 = this$0.get_binding();
            hashMap.put("SemesterRegistration[accounts_due_details]", String.valueOf((dialogPalaiSemRegBinding11 == null || (textInputEditText4 = dialogPalaiSemRegBinding11.etAccountsDetails) == null) ? null : textInputEditText4.getText()));
        } else {
            hashMap.put("SemesterRegistration[accounts_due_details]", "");
        }
        hashMap.put("SemesterRegistration[academic_due]", this$0.academics);
        if (Intrinsics.areEqual(this$0.academics, "Yes")) {
            DialogPalaiSemRegBinding dialogPalaiSemRegBinding12 = this$0.get_binding();
            hashMap.put("SemesterRegistration[academic_due_details]", String.valueOf((dialogPalaiSemRegBinding12 == null || (textInputEditText3 = dialogPalaiSemRegBinding12.etAcademicDetails) == null) ? null : textInputEditText3.getText()));
        } else {
            hashMap.put("SemesterRegistration[academic_due_details]", "");
        }
        hashMap.put("SemesterRegistration[hostel_due]", this$0.hostel);
        if (Intrinsics.areEqual(this$0.hostel, "Yes")) {
            DialogPalaiSemRegBinding dialogPalaiSemRegBinding13 = this$0.get_binding();
            hashMap.put("SemesterRegistration[hostel_due_details]", String.valueOf((dialogPalaiSemRegBinding13 == null || (textInputEditText2 = dialogPalaiSemRegBinding13.etHostelDetails) == null) ? null : textInputEditText2.getText()));
        } else {
            hashMap.put("SemesterRegistration[hostel_due_details]", "");
        }
        hashMap.put("SemesterRegistration[bus_due]", this$0.bus);
        if (Intrinsics.areEqual(this$0.bus, "Yes")) {
            DialogPalaiSemRegBinding dialogPalaiSemRegBinding14 = this$0.get_binding();
            if (dialogPalaiSemRegBinding14 != null && (textInputEditText = dialogPalaiSemRegBinding14.etBusDetails) != null) {
                editable = textInputEditText.getText();
            }
            hashMap.put("SemesterRegistration[bus_due_details]", String.valueOf(editable));
            return;
        }
        hashMap.put("SemesterRegistration[bus_due_details]", "");
    }

    private final void listenSpinner2() {
        getPalaiNewSemRegViewModel().getStatusResponse().observe(getViewLifecycleOwner(), new PalaiNewSemRegDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends CounsellingStatusResponse>, Unit>() { // from class: in.etuwa.app.ui.semregistration.sjcetpalai.newregistration.PalaiNewSemRegDialog$listenSpinner2$1

            /* compiled from: PalaiNewSemRegDialog.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends CounsellingStatusResponse> resource) {
                invoke2((Resource<CounsellingStatusResponse>) resource);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<CounsellingStatusResponse> resource) {
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i == 1) {
                    PalaiNewSemRegDialog.this.hideProgress();
                    resource.getData();
                } else if (i == 2) {
                    PalaiNewSemRegDialog.this.showProgress();
                } else if (i == 3) {
                    PalaiNewSemRegDialog.this.hideProgress();
                } else {
                    if (i != 4) {
                        return;
                    }
                    PalaiNewSemRegDialog.this.hideProgress();
                }
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