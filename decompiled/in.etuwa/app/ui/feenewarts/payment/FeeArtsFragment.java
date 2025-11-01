package in.etuwa.app.ui.feenewarts.payment;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.feearts.payment.FeeArts;
import in.etuwa.app.data.model.feearts.payment.FeeArtsResponse;
import in.etuwa.app.data.model.feearts.payment.FeeArtsSemester;
import in.etuwa.app.data.model.feearts.payment.FeeArtsSemesterResponse;
import in.etuwa.app.data.model.feearts.payment.FeeArtsUrlResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.FragmentFeeArtsBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.feenewarts.payment.FeeArtsAdapter;
import in.etuwa.app.ui.feenewengineer.payment.feeconfirmdialog.FeeConfirmDialogKt;
import in.etuwa.app.utils.RecycleExtKt;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
import kotlin.text.StringsKt;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.parameter.ParametersHolderKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: FeeArtsFragment.kt */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 U2\u00020\u00012\u00020\u0002:\u0001UB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010>\u001a\u00020?H\u0014J\b\u0010@\u001a\u00020?H\u0014J\b\u0010A\u001a\u00020?H\u0002J\b\u0010B\u001a\u00020?H\u0002J\b\u0010C\u001a\u00020?H\u0002J\u0010\u0010D\u001a\u00020?2\u0006\u0010E\u001a\u00020FH\u0016J&\u0010G\u001a\u0004\u0018\u00010H2\u0006\u0010I\u001a\u00020J2\b\u0010K\u001a\u0004\u0018\u00010L2\b\u0010M\u001a\u0004\u0018\u00010NH\u0016J\b\u0010O\u001a\u00020?H\u0016J\u001a\u0010P\u001a\u00020?2\u0006\u0010Q\u001a\u00020H2\b\u0010M\u001a\u0004\u0018\u00010NH\u0016J\b\u0010R\u001a\u00020?H\u0014J\b\u0010S\u001a\u00020?H\u0014J\b\u0010T\u001a\u00020?H\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001f\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u000b\u001a\u0004\b!\u0010\"R\u001a\u0010$\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u000f\"\u0004\b&\u0010\u0011R \u0010'\u001a\b\u0012\u0004\u0012\u00020\r0(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R \u0010-\u001a\b\u0012\u0004\u0012\u00020\r0(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010*\"\u0004\b/\u0010,R\u001b\u00100\u001a\u0002018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u0010\u000b\u001a\u0004\b2\u00103R\u001a\u00105\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u000f\"\u0004\b7\u0010\u0011R\u001a\u00108\u001a\u000209X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=¨\u0006V"}, d2 = {"Lin/etuwa/app/ui/feenewarts/payment/FeeArtsFragment;", "Lin/etuwa/app/ui/base/BaseFragment;", "Lin/etuwa/app/ui/feenewarts/payment/FeeArtsAdapter$CallBack;", "()V", "_binding", "Lin/etuwa/app/databinding/FragmentFeeArtsBinding;", "adapter", "Lin/etuwa/app/ui/feenewarts/payment/FeeArtsAdapter;", "getAdapter", "()Lin/etuwa/app/ui/feenewarts/payment/FeeArtsAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "bal", "", "getBal", "()Ljava/lang/String;", "setBal", "(Ljava/lang/String;)V", "binding", "getBinding", "()Lin/etuwa/app/databinding/FragmentFeeArtsBinding;", "feeArtsViewModel", "Lin/etuwa/app/ui/feenewarts/payment/FeeArtsViewModel;", "getFeeArtsViewModel", "()Lin/etuwa/app/ui/feenewarts/payment/FeeArtsViewModel;", "feeArtsViewModel$delegate", "list", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/feearts/payment/FeeArts;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/helper/MainCallBackListener;", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", "receipt_date", "getReceipt_date", "setReceipt_date", "selected", "", "getSelected", "()Ljava/util/List;", "setSelected", "(Ljava/util/List;)V", "selectedTotal", "getSelectedTotal", "setSelectedTotal", "spinnerAdapter", "Lin/etuwa/app/ui/feenewarts/payment/FeeArtsSemSpinnerAdapter;", "getSpinnerAdapter", "()Lin/etuwa/app/ui/feenewarts/payment/FeeArtsSemSpinnerAdapter;", "spinnerAdapter$delegate", "studentId", "getStudentId", "setStudentId", FeeConfirmDialogKt.ARG_TOTAL, "", "getTotal", "()D", "setTotal", "(D)V", "hideBaseView", "", "hideProgress", "listenResponse", "listenSemResponse", "listenUrlResponse", "onAttach", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onViewCreated", SvgConstants.Tags.VIEW, "setUp", "showBaseView", "showProgress", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FeeArtsFragment extends BaseFragment implements FeeArtsAdapter.CallBack {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentFeeArtsBinding _binding;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;
    private String bal;

    /* renamed from: feeArtsViewModel$delegate, reason: from kotlin metadata */
    private final Lazy feeArtsViewModel;
    private ArrayList<FeeArts> list;
    private MainCallBackListener listener;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;
    private String receipt_date;
    private List<String> selected;
    private List<String> selectedTotal;

    /* renamed from: spinnerAdapter$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdapter;
    private String studentId;
    private double total;

    /* compiled from: FeeArtsFragment.kt */
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
    public static final FeeArtsFragment newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public FeeArtsFragment() {
        final FeeArtsFragment feeArtsFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.feenewarts.payment.FeeArtsFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(feeArtsFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.feeArtsViewModel = FragmentViewModelLazyKt.createViewModelLazy(feeArtsFragment, Reflection.getOrCreateKotlinClass(FeeArtsViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.feenewarts.payment.FeeArtsFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.feenewarts.payment.FeeArtsFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(FeeArtsViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final FeeArtsFragment feeArtsFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<FeeArtsAdapter>() { // from class: in.etuwa.app.ui.feenewarts.payment.FeeArtsFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.feenewarts.payment.FeeArtsAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final FeeArtsAdapter invoke() {
                ComponentCallbacks componentCallbacks = feeArtsFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(FeeArtsAdapter.class), b2, b3);
            }
        });
        this.list = new ArrayList<>();
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        final byte b5 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.feenewarts.payment.FeeArtsFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = feeArtsFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b4, b5);
            }
        });
        final Function0<ParametersHolder> function02 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.feenewarts.payment.FeeArtsFragment$spinnerAdapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(FeeArtsFragment.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode3 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b6 = 0 == true ? 1 : 0;
        this.spinnerAdapter = LazyKt.lazy(lazyThreadSafetyMode3, (Function0) new Function0<FeeArtsSemSpinnerAdapter>() { // from class: in.etuwa.app.ui.feenewarts.payment.FeeArtsFragment$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.feenewarts.payment.FeeArtsSemSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final FeeArtsSemSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = feeArtsFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(FeeArtsSemSpinnerAdapter.class), b6, function02);
            }
        });
        this.selected = new ArrayList();
        this.selectedTotal = new ArrayList();
        this.studentId = "";
        this.receipt_date = "";
        this.bal = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FeeArtsViewModel getFeeArtsViewModel() {
        return (FeeArtsViewModel) this.feeArtsViewModel.getValue();
    }

    private final FeeArtsAdapter getAdapter() {
        return (FeeArtsAdapter) this.adapter.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final FragmentFeeArtsBinding get_binding() {
        return this._binding;
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FeeArtsSemSpinnerAdapter getSpinnerAdapter() {
        return (FeeArtsSemSpinnerAdapter) this.spinnerAdapter.getValue();
    }

    public final List<String> getSelected() {
        return this.selected;
    }

    public final void setSelected(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.selected = list;
    }

    public final List<String> getSelectedTotal() {
        return this.selectedTotal;
    }

    public final void setSelectedTotal(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.selectedTotal = list;
    }

    public final double getTotal() {
        return this.total;
    }

    public final void setTotal(double d) {
        this.total = d;
    }

    public final String getStudentId() {
        return this.studentId;
    }

    public final void setStudentId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.studentId = str;
    }

    public final String getReceipt_date() {
        return this.receipt_date;
    }

    public final void setReceipt_date(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.receipt_date = str;
    }

    /* compiled from: FeeArtsFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/feenewarts/payment/FeeArtsFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/feenewarts/payment/FeeArtsFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final FeeArtsFragment newInstance() {
            return new FeeArtsFragment();
        }
    }

    public final String getBal() {
        return this.bal;
    }

    public final void setBal(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.bal = str;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentFeeArtsBinding.inflate(inflater, container, false);
        FragmentFeeArtsBinding fragmentFeeArtsBinding = get_binding();
        if (fragmentFeeArtsBinding != null) {
            fragmentFeeArtsBinding.setFeeArtsViewModel(getFeeArtsViewModel());
        }
        FragmentFeeArtsBinding fragmentFeeArtsBinding2 = get_binding();
        if (fragmentFeeArtsBinding2 != null) {
            fragmentFeeArtsBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        FragmentFeeArtsBinding fragmentFeeArtsBinding3 = get_binding();
        if (fragmentFeeArtsBinding3 != null) {
            return fragmentFeeArtsBinding3.getRoot();
        }
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setUp();
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void setUp() {
        TextView textView;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle("Fee Pay");
        }
        hideBaseView();
        getPreference().setNewLogin(false);
        FragmentFeeArtsBinding fragmentFeeArtsBinding = get_binding();
        RecyclerView recyclerView = fragmentFeeArtsBinding != null ? fragmentFeeArtsBinding.rvFeeArts : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        FragmentFeeArtsBinding fragmentFeeArtsBinding2 = get_binding();
        Spinner spinner = fragmentFeeArtsBinding2 != null ? fragmentFeeArtsBinding2.spinnerSem : null;
        if (spinner != null) {
            spinner.setAdapter((SpinnerAdapter) getSpinnerAdapter());
        }
        getAdapter().setCallBack(this);
        listenSemResponse();
        listenResponse();
        if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "naher", false, 2, (Object) null)) {
            getFeeArtsViewModel().getSemester();
            getFeeArtsViewModel().getFeesSemWise(getPreference().getUserSemId());
            FragmentFeeArtsBinding fragmentFeeArtsBinding3 = get_binding();
            Spinner spinner2 = fragmentFeeArtsBinding3 != null ? fragmentFeeArtsBinding3.spinnerSem : null;
            if (spinner2 != null) {
                spinner2.setVisibility(0);
            }
        } else {
            getFeeArtsViewModel().getFees();
            FragmentFeeArtsBinding fragmentFeeArtsBinding4 = get_binding();
            Spinner spinner3 = fragmentFeeArtsBinding4 != null ? fragmentFeeArtsBinding4.spinnerSem : null;
            if (spinner3 != null) {
                spinner3.setVisibility(8);
            }
        }
        FragmentFeeArtsBinding fragmentFeeArtsBinding5 = get_binding();
        Spinner spinner4 = fragmentFeeArtsBinding5 != null ? fragmentFeeArtsBinding5.spinnerSem : null;
        if (spinner4 != null) {
            spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.feenewarts.payment.FeeArtsFragment$setUp$1
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    FeeArtsSemSpinnerAdapter spinnerAdapter;
                    FeeArtsViewModel feeArtsViewModel;
                    spinnerAdapter = FeeArtsFragment.this.getSpinnerAdapter();
                    FeeArtsSemester semester = spinnerAdapter.getSemester(position);
                    feeArtsViewModel = FeeArtsFragment.this.getFeeArtsViewModel();
                    feeArtsViewModel.getFeesSemWise(String.valueOf(semester.getId()));
                }
            });
        }
        final HashMap hashMap = new HashMap();
        FragmentFeeArtsBinding fragmentFeeArtsBinding6 = get_binding();
        if (fragmentFeeArtsBinding6 == null || (textView = fragmentFeeArtsBinding6.payFeeArtsBtn) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.feenewarts.payment.FeeArtsFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeeArtsFragment.setUp$lambda$0(FeeArtsFragment.this, hashMap, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$0(FeeArtsFragment this$0, HashMap FeeCollection, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(FeeCollection, "$FeeCollection");
        int size = this$0.list.size() - 1;
        if (size >= 0) {
            int i = 0;
            while (true) {
                if (i == 0) {
                    HashMap hashMap = FeeCollection;
                    hashMap.put("payment", "1");
                    hashMap.put("Transaction[method]", "5");
                    hashMap.put("FeeReceipt[receipt_date]", this$0.receipt_date);
                    hashMap.put("FeeReceipt[amount]", this$0.bal);
                    hashMap.put("installment", this$0.list.get(0).getInstallment_id());
                }
                if (this$0.list.get(i).getBalance() != 0) {
                    HashMap hashMap2 = FeeCollection;
                    hashMap2.put("FeeCollection[" + this$0.list.get(i).getFee_head_id() + "][amount]", String.valueOf(this$0.list.get(i).getBalance()));
                    hashMap2.put("FeeCollection[" + this$0.list.get(i).getFee_head_id() + "][feegroup_id]", this$0.list.get(i).getFeegroup_id());
                    hashMap2.put("FeeCollection[" + this$0.list.get(i).getFee_head_id() + "][feetype_id]", this$0.list.get(i).getFeetype_id());
                    hashMap2.put("FeeCollection[" + this$0.list.get(i).getFee_head_id() + "][installment_id]", this$0.list.get(i).getInstallment_id());
                    hashMap2.put("FeeCollection[" + this$0.list.get(i).getFee_head_id() + "][feehead_id]", this$0.list.get(i).getFee_head_id());
                    hashMap2.put("FeeCollection[" + this$0.list.get(i).getFee_head_id() + "][student_id]", this$0.studentId);
                }
                if (i == size) {
                    break;
                } else {
                    i++;
                }
            }
        }
        System.out.println(FeeCollection);
        this$0.getFeeArtsViewModel().getFeeUrl(FeeCollection);
        this$0.listenUrlResponse();
    }

    private final void listenSemResponse() {
        getFeeArtsViewModel().getSemResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.feenewarts.payment.FeeArtsFragment$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FeeArtsFragment.listenSemResponse$lambda$2(FeeArtsFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenSemResponse$lambda$2(FeeArtsFragment this$0, Resource resource) {
        Spinner spinner;
        Spinner spinner2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i != 1) {
            if (i == 3) {
                this$0.hideProgress();
                this$0.showBaseView();
                return;
            }
            if (i != 4) {
                return;
            }
            this$0.hideProgress();
            this$0.showBaseView();
            FragmentFeeArtsBinding fragmentFeeArtsBinding = this$0.get_binding();
            if (fragmentFeeArtsBinding == null || (spinner2 = fragmentFeeArtsBinding.spinnerSem) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(spinner2, message);
            return;
        }
        this$0.hideProgress();
        this$0.showBaseView();
        FeeArtsSemesterResponse feeArtsSemesterResponse = (FeeArtsSemesterResponse) resource.getData();
        if (feeArtsSemesterResponse != null) {
            this$0.getSpinnerAdapter().addItems(feeArtsSemesterResponse.getInstallments());
            int count = this$0.getSpinnerAdapter().getCount();
            for (int i2 = 0; i2 < count; i2++) {
                if (Intrinsics.areEqual(this$0.getPreference().getUserSemId(), String.valueOf(this$0.getSpinnerAdapter().getSemester(i2).getId()))) {
                    FragmentFeeArtsBinding fragmentFeeArtsBinding2 = this$0.get_binding();
                    if (fragmentFeeArtsBinding2 == null || (spinner = fragmentFeeArtsBinding2.spinnerSem) == null) {
                        return;
                    }
                    spinner.setSelection(i2);
                    return;
                }
            }
        }
    }

    private final void listenResponse() {
        getFeeArtsViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.feenewarts.payment.FeeArtsFragment$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FeeArtsFragment.listenResponse$lambda$4(FeeArtsFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$4(FeeArtsFragment this$0, Resource resource) {
        RecyclerView rvFeeArts;
        TextView textView;
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i != 1) {
            if (i == 2) {
                this$0.showProgress();
                return;
            }
            if (i == 3) {
                this$0.hideProgress();
                this$0.showBaseView();
                return;
            }
            if (i != 4) {
                return;
            }
            this$0.hideProgress();
            this$0.showBaseView();
            FragmentFeeArtsBinding fragmentFeeArtsBinding = this$0.get_binding();
            if (fragmentFeeArtsBinding == null || (recyclerView = fragmentFeeArtsBinding.rvFeeArts) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(recyclerView, message);
            return;
        }
        this$0.hideProgress();
        FeeArtsResponse feeArtsResponse = (FeeArtsResponse) resource.getData();
        if (feeArtsResponse != null) {
            this$0.showBaseView();
            if (feeArtsResponse.getLogin()) {
                this$0.getAdapter().addItems(feeArtsResponse.getFee_groups());
                this$0.list = feeArtsResponse.getFee_groups();
                this$0.studentId = feeArtsResponse.getStudent_id();
                this$0.receipt_date = feeArtsResponse.getDate();
                this$0.bal = feeArtsResponse.getBal();
                int i2 = 0;
                if (StringsKt.contains$default((CharSequence) this$0.getPreference().getBaseUrl(), (CharSequence) "naher", false, 2, (Object) null)) {
                    FragmentFeeArtsBinding fragmentFeeArtsBinding2 = this$0.get_binding();
                    LinearLayout linearLayout = fragmentFeeArtsBinding2 != null ? fragmentFeeArtsBinding2.fineLayout : null;
                    if (linearLayout != null) {
                        linearLayout.setVisibility(0);
                    }
                    int size = feeArtsResponse.getFee_groups().size() - 1;
                    if (size >= 0) {
                        int i3 = 0;
                        while (true) {
                            i2 += this$0.list.get(i3).getBalance();
                            if (i3 == size) {
                                break;
                            } else {
                                i3++;
                            }
                        }
                    }
                    FragmentFeeArtsBinding fragmentFeeArtsBinding3 = this$0.get_binding();
                    TextView textView2 = fragmentFeeArtsBinding3 != null ? fragmentFeeArtsBinding3.tvSubtotal : null;
                    if (textView2 != null) {
                        textView2.setText("Subtotal : " + i2 + HelpFormatter.DEFAULT_LONG_OPT_SEPARATOR);
                    }
                    FragmentFeeArtsBinding fragmentFeeArtsBinding4 = this$0.get_binding();
                    TextView textView3 = fragmentFeeArtsBinding4 != null ? fragmentFeeArtsBinding4.tvFine : null;
                    if (textView3 != null) {
                        textView3.setText("Fine : " + feeArtsResponse.getFine());
                    }
                    FragmentFeeArtsBinding fragmentFeeArtsBinding5 = this$0.get_binding();
                    textView = fragmentFeeArtsBinding5 != null ? fragmentFeeArtsBinding5.tvFeeArtsTotal : null;
                    if (textView == null) {
                        return;
                    }
                    textView.setText("Total : " + feeArtsResponse.getTotal() + "  ");
                    return;
                }
                FragmentFeeArtsBinding fragmentFeeArtsBinding6 = this$0.get_binding();
                LinearLayout linearLayout2 = fragmentFeeArtsBinding6 != null ? fragmentFeeArtsBinding6.fineLayout : null;
                if (linearLayout2 != null) {
                    linearLayout2.setVisibility(8);
                }
                int size2 = feeArtsResponse.getFee_groups().size() - 1;
                if (size2 >= 0) {
                    int i4 = 0;
                    while (true) {
                        i2 += this$0.list.get(i4).getBalance();
                        if (i4 == size2) {
                            break;
                        } else {
                            i4++;
                        }
                    }
                }
                FragmentFeeArtsBinding fragmentFeeArtsBinding7 = this$0.get_binding();
                textView = fragmentFeeArtsBinding7 != null ? fragmentFeeArtsBinding7.tvFeeArtsTotal : null;
                if (textView == null) {
                    return;
                }
                textView.setText(String.valueOf(i2));
                return;
            }
            FragmentFeeArtsBinding fragmentFeeArtsBinding8 = this$0.get_binding();
            if (fragmentFeeArtsBinding8 == null || (rvFeeArts = fragmentFeeArtsBinding8.rvFeeArts) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(rvFeeArts, "rvFeeArts");
            ToastExtKt.showErrorToast(rvFeeArts, "network error");
        }
    }

    private final void listenUrlResponse() {
        getFeeArtsViewModel().getFeeUrlResponse().observe(getViewLifecycleOwner(), new FeeArtsFragment$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends FeeArtsUrlResponse>, Unit>() { // from class: in.etuwa.app.ui.feenewarts.payment.FeeArtsFragment$listenUrlResponse$1

            /* compiled from: FeeArtsFragment.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends FeeArtsUrlResponse> resource) {
                invoke2((Resource<FeeArtsUrlResponse>) resource);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:21:0x005c, code lost:
            
                r0 = r0.listener;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void invoke2(in.etuwa.app.utils.Resource<in.etuwa.app.data.model.feearts.payment.FeeArtsUrlResponse> r4) {
                /*
                    r3 = this;
                    in.etuwa.app.utils.Status r0 = r4.getStatus()
                    int[] r1 = in.etuwa.app.ui.feenewarts.payment.FeeArtsFragment$listenUrlResponse$1.WhenMappings.$EnumSwitchMapping$0
                    int r0 = r0.ordinal()
                    r0 = r1[r0]
                    r1 = 1
                    if (r0 == r1) goto L35
                    r4 = 2
                    if (r0 == r4) goto L2f
                    r4 = 3
                    if (r0 == r4) goto L24
                    r4 = 4
                    if (r0 == r4) goto L19
                    goto L69
                L19:
                    in.etuwa.app.ui.feenewarts.payment.FeeArtsFragment r4 = in.etuwa.app.ui.feenewarts.payment.FeeArtsFragment.this
                    r4.hideProgress()
                    in.etuwa.app.ui.feenewarts.payment.FeeArtsFragment r4 = in.etuwa.app.ui.feenewarts.payment.FeeArtsFragment.this
                    r4.showBaseView()
                    goto L69
                L24:
                    in.etuwa.app.ui.feenewarts.payment.FeeArtsFragment r4 = in.etuwa.app.ui.feenewarts.payment.FeeArtsFragment.this
                    r4.hideProgress()
                    in.etuwa.app.ui.feenewarts.payment.FeeArtsFragment r4 = in.etuwa.app.ui.feenewarts.payment.FeeArtsFragment.this
                    r4.showBaseView()
                    goto L69
                L2f:
                    in.etuwa.app.ui.feenewarts.payment.FeeArtsFragment r4 = in.etuwa.app.ui.feenewarts.payment.FeeArtsFragment.this
                    r4.showProgress()
                    goto L69
                L35:
                    in.etuwa.app.ui.feenewarts.payment.FeeArtsFragment r0 = in.etuwa.app.ui.feenewarts.payment.FeeArtsFragment.this
                    r0.hideProgress()
                    java.lang.Object r4 = r4.getData()
                    in.etuwa.app.data.model.feearts.payment.FeeArtsUrlResponse r4 = (in.etuwa.app.data.model.feearts.payment.FeeArtsUrlResponse) r4
                    if (r4 == 0) goto L69
                    in.etuwa.app.ui.feenewarts.payment.FeeArtsFragment r0 = in.etuwa.app.ui.feenewarts.payment.FeeArtsFragment.this
                    r0.showBaseView()
                    java.lang.String r1 = r4.getUrl()
                    java.io.PrintStream r2 = java.lang.System.out
                    r2.println(r1)
                    java.lang.String r1 = r4.getUrl()
                    java.lang.String r2 = ""
                    boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r2)
                    if (r1 != 0) goto L69
                    in.etuwa.app.helper.MainCallBackListener r0 = in.etuwa.app.ui.feenewarts.payment.FeeArtsFragment.access$getListener$p(r0)
                    if (r0 == 0) goto L69
                    java.lang.String r4 = r4.getUrl()
                    r0.openPaymentPage(r4)
                L69:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: in.etuwa.app.ui.feenewarts.payment.FeeArtsFragment$listenUrlResponse$1.invoke2(in.etuwa.app.utils.Resource):void");
            }
        }));
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
        RecyclerView recyclerView;
        FragmentFeeArtsBinding fragmentFeeArtsBinding = get_binding();
        if (fragmentFeeArtsBinding == null || (recyclerView = fragmentFeeArtsBinding.rvFeeArts) == null) {
            return;
        }
        RecycleExtKt.show(recyclerView);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
        RecyclerView recyclerView;
        FragmentFeeArtsBinding fragmentFeeArtsBinding = get_binding();
        if (fragmentFeeArtsBinding == null || (recyclerView = fragmentFeeArtsBinding.rvFeeArts) == null) {
            return;
        }
        RecycleExtKt.hide(recyclerView);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        if (context instanceof MainCallBackListener) {
            this.listener = (MainCallBackListener) context;
        } else {
            super.onAttach(context);
        }
    }
}