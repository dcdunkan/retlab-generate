package in.etuwa.app.ui.fees;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.fee.receipts.ReceiptResponse;
import in.etuwa.app.data.model.feearts.payment.FeeArts;
import in.etuwa.app.data.model.feearts.payment.FeeArtsResponse;
import in.etuwa.app.data.model.feearts.payment.FeeArtsSemesterResponse;
import in.etuwa.app.data.model.feearts.payment.FeeArtsUrlResponse;
import in.etuwa.app.data.model.feeengineer.payment.FeeEngineer;
import in.etuwa.app.data.model.feeengineer.payment.FeeEngineerResponse;
import in.etuwa.app.data.model.feeengineer.payment.FeeEngineerUrlResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.FragmentFeeMainNewBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.feenewarts.payment.FeeArtsSemSpinnerAdapter;
import in.etuwa.app.ui.feenewengineer.payment.dialog.FeeDetailDialog;
import in.etuwa.app.ui.feenewengineer.payment.feeconfirmdialog.FeeConfirmDialog;
import in.etuwa.app.ui.feenewengineer.payment.feeconfirmdialog.FeeConfirmDialogKt;
import in.etuwa.app.ui.fees.FeesMainArtsAdapter;
import in.etuwa.app.ui.fees.FeesMainEngineerAdapter;
import in.etuwa.app.ui.fees.receipt.ReceiptAdapter;
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

/* JADX INFO: compiled from: FeeMainNewFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class FeeMainNewFragment extends BaseFragment implements FeesMainEngineerAdapter.CallBack, FeeDetailDialog.FeeDetailListner, FeeConfirmDialog.FeeDetailListner, FeesMainArtsAdapter.CallBack {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentFeeMainNewBinding _binding;

    /* JADX INFO: renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;

    /* JADX INFO: renamed from: adapterArts$delegate, reason: from kotlin metadata */
    private final Lazy adapterArts;

    /* JADX INFO: renamed from: adapterReceipt$delegate, reason: from kotlin metadata */
    private final Lazy adapterReceipt;
    private String bal;

    /* JADX INFO: renamed from: feeEngineerViewModel$delegate, reason: from kotlin metadata */
    private final Lazy feeEngineerViewModel;
    private ArrayList<FeeEngineer> list;
    private ArrayList<FeeArts> listArts;
    private MainCallBackListener listener;

    /* JADX INFO: renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;
    private String receipt_date;
    private List<String> selected;
    private List<String> selectedTotal;

    /* JADX INFO: renamed from: spinnerAdapter$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdapter;
    private String studentId;
    private double total;
    private double totalArts;

    /* JADX INFO: compiled from: FeeMainNewFragment.kt */
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
    public static final FeeMainNewFragment newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public FeeMainNewFragment() {
        final FeeMainNewFragment feeMainNewFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.fees.FeeMainNewFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return feeMainNewFragment;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(feeMainNewFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.feeEngineerViewModel = FragmentViewModelLazyKt.createViewModelLazy(feeMainNewFragment, Reflection.getOrCreateKotlinClass(FeeMainNewViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.fees.FeeMainNewFragment$special$$inlined$viewModel$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) function0.invoke()).getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.fees.FeeMainNewFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) function0.invoke(), Reflection.getOrCreateKotlinClass(FeeMainNewViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final FeeMainNewFragment feeMainNewFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<FeesMainEngineerAdapter>() { // from class: in.etuwa.app.ui.fees.FeeMainNewFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.fees.FeesMainEngineerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final FeesMainEngineerAdapter invoke() {
                ComponentCallbacks componentCallbacks = feeMainNewFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(FeesMainEngineerAdapter.class), b2, b3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        final byte b5 = 0 == true ? 1 : 0;
        this.adapterArts = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<FeesMainArtsAdapter>() { // from class: in.etuwa.app.ui.fees.FeeMainNewFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.fees.FeesMainArtsAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final FeesMainArtsAdapter invoke() {
                ComponentCallbacks componentCallbacks = feeMainNewFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(FeesMainArtsAdapter.class), b4, b5);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode3 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b6 = 0 == true ? 1 : 0;
        final byte b7 = 0 == true ? 1 : 0;
        this.adapterReceipt = LazyKt.lazy(lazyThreadSafetyMode3, (Function0) new Function0<ReceiptAdapter>() { // from class: in.etuwa.app.ui.fees.FeeMainNewFragment$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.fees.receipt.ReceiptAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final ReceiptAdapter invoke() {
                ComponentCallbacks componentCallbacks = feeMainNewFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(ReceiptAdapter.class), b6, b7);
            }
        });
        final Function0<ParametersHolder> function02 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.fees.FeeMainNewFragment$spinnerAdapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(this.this$0.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode4 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b8 = 0 == true ? 1 : 0;
        this.spinnerAdapter = LazyKt.lazy(lazyThreadSafetyMode4, (Function0) new Function0<FeeArtsSemSpinnerAdapter>() { // from class: in.etuwa.app.ui.fees.FeeMainNewFragment$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.feenewarts.payment.FeeArtsSemSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final FeeArtsSemSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = feeMainNewFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(FeeArtsSemSpinnerAdapter.class), b8, function02);
            }
        });
        this.list = new ArrayList<>();
        this.listArts = new ArrayList<>();
        LazyThreadSafetyMode lazyThreadSafetyMode5 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b9 = 0 == true ? 1 : 0;
        final byte b10 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode5, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.fees.FeeMainNewFragment$special$$inlined$inject$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = feeMainNewFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b9, b10);
            }
        });
        this.selected = new ArrayList();
        this.selectedTotal = new ArrayList();
        this.studentId = "";
        this.receipt_date = "";
        this.bal = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FeeMainNewViewModel getFeeEngineerViewModel() {
        return (FeeMainNewViewModel) this.feeEngineerViewModel.getValue();
    }

    private final FeesMainEngineerAdapter getAdapter() {
        return (FeesMainEngineerAdapter) this.adapter.getValue();
    }

    private final FeesMainArtsAdapter getAdapterArts() {
        return (FeesMainArtsAdapter) this.adapterArts.getValue();
    }

    private final ReceiptAdapter getAdapterReceipt() {
        return (ReceiptAdapter) this.adapterReceipt.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FeeArtsSemSpinnerAdapter getSpinnerAdapter() {
        return (FeeArtsSemSpinnerAdapter) this.spinnerAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getBinding, reason: from getter */
    public final FragmentFeeMainNewBinding get_binding() {
        return this._binding;
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
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

    public final double getTotalArts() {
        return this.totalArts;
    }

    public final void setTotalArts(double d) {
        this.totalArts = d;
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

    /* JADX INFO: compiled from: FeeMainNewFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/fees/FeeMainNewFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/fees/FeeMainNewFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final FeeMainNewFragment newInstance() {
            return new FeeMainNewFragment();
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
        this._binding = FragmentFeeMainNewBinding.inflate(inflater, container, false);
        FragmentFeeMainNewBinding fragmentFeeMainNewBinding = get_binding();
        if (fragmentFeeMainNewBinding != null) {
            fragmentFeeMainNewBinding.setFeeMainNewViewModel(getFeeEngineerViewModel());
        }
        FragmentFeeMainNewBinding fragmentFeeMainNewBinding2 = get_binding();
        if (fragmentFeeMainNewBinding2 != null) {
            fragmentFeeMainNewBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        FragmentFeeMainNewBinding fragmentFeeMainNewBinding3 = get_binding();
        if (fragmentFeeMainNewBinding3 != null) {
            return fragmentFeeMainNewBinding3.getRoot();
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
        MaterialButton materialButton;
        TextView textView;
        TextView textView2;
        MaterialButton materialButton2;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle("Fee Pay");
        }
        hideBaseView();
        getPreference().setNewLogin(false);
        FragmentFeeMainNewBinding fragmentFeeMainNewBinding = get_binding();
        RecyclerView recyclerView = fragmentFeeMainNewBinding != null ? fragmentFeeMainNewBinding.rvFeeEngnr : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        getAdapter().setCallBack(this);
        FragmentFeeMainNewBinding fragmentFeeMainNewBinding2 = get_binding();
        Spinner spinner = fragmentFeeMainNewBinding2 != null ? fragmentFeeMainNewBinding2.spinnerSem : null;
        if (spinner != null) {
            spinner.setAdapter((SpinnerAdapter) getSpinnerAdapter());
        }
        FragmentFeeMainNewBinding fragmentFeeMainNewBinding3 = get_binding();
        RecyclerView recyclerView2 = fragmentFeeMainNewBinding3 != null ? fragmentFeeMainNewBinding3.rvFeeArts : null;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(getAdapterArts());
        }
        getAdapterArts().setCallBack(this);
        FragmentFeeMainNewBinding fragmentFeeMainNewBinding4 = get_binding();
        RecyclerView recyclerView3 = fragmentFeeMainNewBinding4 != null ? fragmentFeeMainNewBinding4.rvFeeReceipt : null;
        if (recyclerView3 != null) {
            recyclerView3.setAdapter(getAdapterReceipt());
        }
        listenResponse();
        listenReceiptResponse();
        listenArtsResponse();
        listenSemResponse();
        listenArtsUrlResponse();
        if (getPreference().getFeeEngnrNew() || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "sjcetpalai", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "mvjce", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "asiet", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "sngce.", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "tkmit", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "vjec", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "christ", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "ukfcet", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "demo", false, 2, (Object) null)) {
            getFeeEngineerViewModel().getFees();
            FragmentFeeMainNewBinding fragmentFeeMainNewBinding5 = get_binding();
            FrameLayout frameLayout = fragmentFeeMainNewBinding5 != null ? fragmentFeeMainNewBinding5.feeEngineerLyt : null;
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
            }
            FragmentFeeMainNewBinding fragmentFeeMainNewBinding6 = get_binding();
            FrameLayout frameLayout2 = fragmentFeeMainNewBinding6 != null ? fragmentFeeMainNewBinding6.feeArtsLyt : null;
            if (frameLayout2 != null) {
                frameLayout2.setVisibility(8);
            }
        } else {
            if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "naher", false, 2, (Object) null)) {
                getFeeEngineerViewModel().getSemester();
                getFeeEngineerViewModel().getFeesSemWise(getPreference().getUserSemId());
                FragmentFeeMainNewBinding fragmentFeeMainNewBinding7 = get_binding();
                MaterialCardView materialCardView = fragmentFeeMainNewBinding7 != null ? fragmentFeeMainNewBinding7.seriesLayout : null;
                if (materialCardView != null) {
                    materialCardView.setVisibility(0);
                }
            } else {
                getFeeEngineerViewModel().getFeesArts();
                FragmentFeeMainNewBinding fragmentFeeMainNewBinding8 = get_binding();
                MaterialCardView materialCardView2 = fragmentFeeMainNewBinding8 != null ? fragmentFeeMainNewBinding8.seriesLayout : null;
                if (materialCardView2 != null) {
                    materialCardView2.setVisibility(8);
                }
            }
            FragmentFeeMainNewBinding fragmentFeeMainNewBinding9 = get_binding();
            FrameLayout frameLayout3 = fragmentFeeMainNewBinding9 != null ? fragmentFeeMainNewBinding9.feeEngineerLyt : null;
            if (frameLayout3 != null) {
                frameLayout3.setVisibility(8);
            }
            FragmentFeeMainNewBinding fragmentFeeMainNewBinding10 = get_binding();
            FrameLayout frameLayout4 = fragmentFeeMainNewBinding10 != null ? fragmentFeeMainNewBinding10.feeArtsLyt : null;
            if (frameLayout4 != null) {
                frameLayout4.setVisibility(0);
            }
        }
        FragmentFeeMainNewBinding fragmentFeeMainNewBinding11 = get_binding();
        Spinner spinner2 = fragmentFeeMainNewBinding11 != null ? fragmentFeeMainNewBinding11.spinnerSem : null;
        if (spinner2 != null) {
            spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.fees.FeeMainNewFragment.setUp.1
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    FeeMainNewFragment.this.getFeeEngineerViewModel().getFeesSemWise(String.valueOf(FeeMainNewFragment.this.getSpinnerAdapter().getSemester(position).getId()));
                }
            });
        }
        final HashMap map = new HashMap();
        FragmentFeeMainNewBinding fragmentFeeMainNewBinding12 = get_binding();
        if (fragmentFeeMainNewBinding12 != null && (materialButton2 = fragmentFeeMainNewBinding12.payFeeArtsBtn) != null) {
            materialButton2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.fees.FeeMainNewFragment$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeeMainNewFragment.setUp$lambda$0(this.f$0, map, view);
                }
            });
        }
        FragmentFeeMainNewBinding fragmentFeeMainNewBinding13 = get_binding();
        if (fragmentFeeMainNewBinding13 != null && (textView2 = fragmentFeeMainNewBinding13.feesBtn) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.fees.FeeMainNewFragment$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeeMainNewFragment.setUp$lambda$1(this.f$0, view);
                }
            });
        }
        FragmentFeeMainNewBinding fragmentFeeMainNewBinding14 = get_binding();
        if (fragmentFeeMainNewBinding14 != null && (textView = fragmentFeeMainNewBinding14.receiptBtn) != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.fees.FeeMainNewFragment$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeeMainNewFragment.setUp$lambda$2(this.f$0, view);
                }
            });
        }
        final HashMap map2 = new HashMap();
        FragmentFeeMainNewBinding fragmentFeeMainNewBinding15 = get_binding();
        if (fragmentFeeMainNewBinding15 == null || (materialButton = fragmentFeeMainNewBinding15.payFeeEngnrBtn) == null) {
            return;
        }
        materialButton.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.fees.FeeMainNewFragment$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeeMainNewFragment.setUp$lambda$3(map2, this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$0(FeeMainNewFragment this$0, HashMap FeeArtsCollection, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(FeeArtsCollection, "$FeeArtsCollection");
        int size = this$0.listArts.size() - 1;
        if (size >= 0) {
            int i = 0;
            while (true) {
                if (i == 0) {
                    HashMap map = FeeArtsCollection;
                    map.put("payment", "1");
                    map.put("Transaction[method]", "5");
                    map.put("FeeReceipt[receipt_date]", this$0.receipt_date);
                    map.put("FeeReceipt[amount]", this$0.bal);
                    map.put("installment", this$0.listArts.get(0).getInstallment_id());
                }
                if (this$0.listArts.get(i).getBalance() != 0) {
                    HashMap map2 = FeeArtsCollection;
                    map2.put("FeeCollection[" + this$0.listArts.get(i).getFee_head_id() + "][amount]", String.valueOf(this$0.listArts.get(i).getBalance()));
                    map2.put("FeeCollection[" + this$0.listArts.get(i).getFee_head_id() + "][feegroup_id]", this$0.listArts.get(i).getFeegroup_id());
                    map2.put("FeeCollection[" + this$0.listArts.get(i).getFee_head_id() + "][feetype_id]", this$0.listArts.get(i).getFeetype_id());
                    map2.put("FeeCollection[" + this$0.listArts.get(i).getFee_head_id() + "][installment_id]", this$0.listArts.get(i).getInstallment_id());
                    map2.put("FeeCollection[" + this$0.listArts.get(i).getFee_head_id() + "][feehead_id]", this$0.listArts.get(i).getFee_head_id());
                    map2.put("FeeCollection[" + this$0.listArts.get(i).getFee_head_id() + "][student_id]", this$0.studentId);
                }
                if (i == size) {
                    break;
                } else {
                    i++;
                }
            }
        }
        System.out.println(FeeArtsCollection);
        this$0.getFeeEngineerViewModel().getFeeArtsUrl(FeeArtsCollection);
        this$0.listenUrlResponse();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(FeeMainNewFragment this$0, View view) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentFeeMainNewBinding fragmentFeeMainNewBinding = this$0.get_binding();
        if (fragmentFeeMainNewBinding != null && (textView4 = fragmentFeeMainNewBinding.receiptBtn) != null) {
            textView4.setBackgroundResource(R.drawable.shape_round_unselected);
        }
        FragmentFeeMainNewBinding fragmentFeeMainNewBinding2 = this$0.get_binding();
        if (fragmentFeeMainNewBinding2 != null && (textView3 = fragmentFeeMainNewBinding2.feesBtn) != null) {
            textView3.setBackgroundResource(R.drawable.shape_round_selected);
        }
        if (this$0.getPreference().getFeeEngnrNew() || StringsKt.contains$default((CharSequence) this$0.getPreference().getBaseUrl(), (CharSequence) "sjcetpalai", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) this$0.getPreference().getBaseUrl(), (CharSequence) "mvjce", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) this$0.getPreference().getBaseUrl(), (CharSequence) "asiet", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) this$0.getPreference().getBaseUrl(), (CharSequence) "sngce.", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) this$0.getPreference().getBaseUrl(), (CharSequence) "tkmit", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) this$0.getPreference().getBaseUrl(), (CharSequence) "vjec", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) this$0.getPreference().getBaseUrl(), (CharSequence) "christ", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) this$0.getPreference().getBaseUrl(), (CharSequence) "ukfcet", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) this$0.getPreference().getBaseUrl(), (CharSequence) "demo", false, 2, (Object) null)) {
            FragmentFeeMainNewBinding fragmentFeeMainNewBinding3 = this$0.get_binding();
            FrameLayout frameLayout = fragmentFeeMainNewBinding3 != null ? fragmentFeeMainNewBinding3.feeEngineerLyt : null;
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
            }
            FragmentFeeMainNewBinding fragmentFeeMainNewBinding4 = this$0.get_binding();
            FrameLayout frameLayout2 = fragmentFeeMainNewBinding4 != null ? fragmentFeeMainNewBinding4.feeArtsLyt : null;
            if (frameLayout2 != null) {
                frameLayout2.setVisibility(8);
            }
            this$0.getFeeEngineerViewModel().getFees();
        } else {
            this$0.getFeeEngineerViewModel().getFeesArts();
            FragmentFeeMainNewBinding fragmentFeeMainNewBinding5 = this$0.get_binding();
            FrameLayout frameLayout3 = fragmentFeeMainNewBinding5 != null ? fragmentFeeMainNewBinding5.feeEngineerLyt : null;
            if (frameLayout3 != null) {
                frameLayout3.setVisibility(8);
            }
            FragmentFeeMainNewBinding fragmentFeeMainNewBinding6 = this$0.get_binding();
            FrameLayout frameLayout4 = fragmentFeeMainNewBinding6 != null ? fragmentFeeMainNewBinding6.feeArtsLyt : null;
            if (frameLayout4 != null) {
                frameLayout4.setVisibility(0);
            }
        }
        FragmentFeeMainNewBinding fragmentFeeMainNewBinding7 = this$0.get_binding();
        if (fragmentFeeMainNewBinding7 != null && (textView2 = fragmentFeeMainNewBinding7.receiptBtn) != null) {
            textView2.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        FragmentFeeMainNewBinding fragmentFeeMainNewBinding8 = this$0.get_binding();
        if (fragmentFeeMainNewBinding8 != null && (textView = fragmentFeeMainNewBinding8.feesBtn) != null) {
            textView.setTextColor(-1);
        }
        FragmentFeeMainNewBinding fragmentFeeMainNewBinding9 = this$0.get_binding();
        FrameLayout frameLayout5 = fragmentFeeMainNewBinding9 != null ? fragmentFeeMainNewBinding9.feeReceiptLyt : null;
        if (frameLayout5 == null) {
            return;
        }
        frameLayout5.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$2(FeeMainNewFragment this$0, View view) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getFeeEngineerViewModel().getReceipts();
        FragmentFeeMainNewBinding fragmentFeeMainNewBinding = this$0.get_binding();
        if (fragmentFeeMainNewBinding != null && (textView4 = fragmentFeeMainNewBinding.receiptBtn) != null) {
            textView4.setBackgroundResource(R.drawable.shape_round_selected);
        }
        FragmentFeeMainNewBinding fragmentFeeMainNewBinding2 = this$0.get_binding();
        if (fragmentFeeMainNewBinding2 != null && (textView3 = fragmentFeeMainNewBinding2.feesBtn) != null) {
            textView3.setBackgroundResource(R.drawable.shape_round_unselected);
        }
        FragmentFeeMainNewBinding fragmentFeeMainNewBinding3 = this$0.get_binding();
        if (fragmentFeeMainNewBinding3 != null && (textView2 = fragmentFeeMainNewBinding3.receiptBtn) != null) {
            textView2.setTextColor(-1);
        }
        FragmentFeeMainNewBinding fragmentFeeMainNewBinding4 = this$0.get_binding();
        if (fragmentFeeMainNewBinding4 != null && (textView = fragmentFeeMainNewBinding4.feesBtn) != null) {
            textView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        FragmentFeeMainNewBinding fragmentFeeMainNewBinding5 = this$0.get_binding();
        FrameLayout frameLayout = fragmentFeeMainNewBinding5 != null ? fragmentFeeMainNewBinding5.feeEngineerLyt : null;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        FragmentFeeMainNewBinding fragmentFeeMainNewBinding6 = this$0.get_binding();
        FrameLayout frameLayout2 = fragmentFeeMainNewBinding6 != null ? fragmentFeeMainNewBinding6.feeArtsLyt : null;
        if (frameLayout2 != null) {
            frameLayout2.setVisibility(8);
        }
        FragmentFeeMainNewBinding fragmentFeeMainNewBinding7 = this$0.get_binding();
        FrameLayout frameLayout3 = fragmentFeeMainNewBinding7 != null ? fragmentFeeMainNewBinding7.feeReceiptLyt : null;
        if (frameLayout3 == null) {
            return;
        }
        frameLayout3.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$3(HashMap FeeCollection, FeeMainNewFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(FeeCollection, "$FeeCollection");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        HashMap map = FeeCollection;
        map.put("payment", "1");
        map.put("batch_id", this$0.getPreference().getBatchId());
        int size = this$0.selected.size() - 1;
        if (size >= 0) {
            int i = 0;
            while (true) {
                if (Intrinsics.areEqual(this$0.selected.get(i), "true")) {
                    int size2 = this$0.list.get(i).getInstallments().size() - 1;
                    if (size2 >= 0) {
                        int i2 = 0;
                        while (true) {
                            if (Double.parseDouble(this$0.list.get(i).getInstallments().get(i2).getBalance()) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || Double.parseDouble(this$0.list.get(i).getInstallments().get(i2).getBalance()) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || Double.parseDouble(this$0.list.get(i).getInstallments().get(i2).getBalance()) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                                Double.parseDouble(this$0.list.get(i).getInstallments().get(i2).getBalance());
                                map.put("FeeCollection[" + this$0.list.get(i).getInstallments().get(i2).getFeeheadgroup_id() + "][amount]", this$0.list.get(i).getInstallments().get(i2).getBalance());
                                map.put("FeeCollection[" + this$0.list.get(i).getInstallments().get(i2).getFeeheadgroup_id() + "][feeheadgroup_id]", this$0.list.get(i).getInstallments().get(i2).getFeeheadgroup_id());
                            }
                            if (i2 == size2) {
                                break;
                            } else {
                                i2++;
                            }
                        }
                    }
                    map.put("payment", "1");
                    map.put("batch_id", this$0.getPreference().getBatchId());
                }
                if (i == size) {
                    break;
                } else {
                    i++;
                }
            }
        }
        this$0.getFeeEngineerViewModel().getFeeUrl(map);
        this$0.listenUrlResponse();
    }

    private final void listenSemResponse() {
        getFeeEngineerViewModel().getSemResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.fees.FeeMainNewFragment$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FeeMainNewFragment.listenSemResponse$lambda$5(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenSemResponse$lambda$5(FeeMainNewFragment this$0, Resource resource) {
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
            FragmentFeeMainNewBinding fragmentFeeMainNewBinding = this$0.get_binding();
            if (fragmentFeeMainNewBinding == null || (spinner2 = fragmentFeeMainNewBinding.spinnerSem) == null) {
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
                    FragmentFeeMainNewBinding fragmentFeeMainNewBinding2 = this$0.get_binding();
                    if (fragmentFeeMainNewBinding2 == null || (spinner = fragmentFeeMainNewBinding2.spinnerSem) == null) {
                        return;
                    }
                    spinner.setSelection(i2);
                    return;
                }
            }
        }
    }

    private final void listenResponse() {
        getFeeEngineerViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.fees.FeeMainNewFragment$$ExternalSyntheticLambda8
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FeeMainNewFragment.listenResponse$lambda$7(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void listenResponse$lambda$7(FeeMainNewFragment this$0, Resource resource) {
        RecyclerView rvFeeEngnr;
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
            FragmentFeeMainNewBinding fragmentFeeMainNewBinding = this$0.get_binding();
            if (fragmentFeeMainNewBinding == null || (recyclerView = fragmentFeeMainNewBinding.rvFeeEngnr) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(recyclerView, message);
            return;
        }
        this$0.hideProgress();
        FeeEngineerResponse feeEngineerResponse = (FeeEngineerResponse) resource.getData();
        if (feeEngineerResponse != null) {
            this$0.showBaseView();
            try {
                if (feeEngineerResponse.getLogin() && feeEngineerResponse.getSuccess()) {
                    FeesMainEngineerAdapter adapter = this$0.getAdapter();
                    ArrayList<FeeEngineer> fees = feeEngineerResponse.getFees();
                    Context contextRequireContext = this$0.requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                    adapter.addItems(fees, contextRequireContext);
                    this$0.list = feeEngineerResponse.getFees();
                    this$0 = Unit.INSTANCE;
                } else {
                    FragmentFeeMainNewBinding fragmentFeeMainNewBinding2 = this$0.get_binding();
                    this$0 = this$0;
                    if (fragmentFeeMainNewBinding2 != null) {
                        RecyclerView rvFeeEngnr2 = fragmentFeeMainNewBinding2.rvFeeEngnr;
                        this$0 = this$0;
                        if (rvFeeEngnr2 != null) {
                            Intrinsics.checkNotNullExpressionValue(rvFeeEngnr2, "rvFeeEngnr");
                            ToastExtKt.showErrorToast(rvFeeEngnr2, feeEngineerResponse.getMessage());
                            this$0 = Unit.INSTANCE;
                        }
                    }
                }
            } catch (NullPointerException unused) {
                FragmentFeeMainNewBinding fragmentFeeMainNewBinding3 = this$0.get_binding();
                if (fragmentFeeMainNewBinding3 == null || (rvFeeEngnr = fragmentFeeMainNewBinding3.rvFeeEngnr) == null) {
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(rvFeeEngnr, "rvFeeEngnr");
                ToastExtKt.showErrorToast(rvFeeEngnr, "Some Error occured while loading Fees");
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    private final void listenArtsResponse() {
        getFeeEngineerViewModel().getFeeArtsResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.fees.FeeMainNewFragment$$ExternalSyntheticLambda7
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FeeMainNewFragment.listenArtsResponse$lambda$9(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenArtsResponse$lambda$9(FeeMainNewFragment this$0, Resource resource) {
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
            FragmentFeeMainNewBinding fragmentFeeMainNewBinding = this$0.get_binding();
            if (fragmentFeeMainNewBinding == null || (recyclerView = fragmentFeeMainNewBinding.rvFeeArts) == null) {
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
                this$0.getAdapterArts().addItems(feeArtsResponse.getFee_groups());
                this$0.listArts = feeArtsResponse.getFee_groups();
                this$0.studentId = feeArtsResponse.getStudent_id();
                this$0.receipt_date = feeArtsResponse.getDate();
                this$0.bal = feeArtsResponse.getBal();
                int balance = 0;
                if (StringsKt.contains$default((CharSequence) this$0.getPreference().getBaseUrl(), (CharSequence) "naher", false, 2, (Object) null)) {
                    FragmentFeeMainNewBinding fragmentFeeMainNewBinding2 = this$0.get_binding();
                    MaterialCardView materialCardView = fragmentFeeMainNewBinding2 != null ? fragmentFeeMainNewBinding2.fineLayout : null;
                    if (materialCardView != null) {
                        materialCardView.setVisibility(0);
                    }
                    int size = feeArtsResponse.getFee_groups().size() - 1;
                    if (size >= 0) {
                        int i2 = 0;
                        while (true) {
                            balance += this$0.listArts.get(i2).getBalance();
                            if (i2 == size) {
                                break;
                            } else {
                                i2++;
                            }
                        }
                    }
                    FragmentFeeMainNewBinding fragmentFeeMainNewBinding3 = this$0.get_binding();
                    TextView textView2 = fragmentFeeMainNewBinding3 != null ? fragmentFeeMainNewBinding3.tvSubtotal : null;
                    if (textView2 != null) {
                        textView2.setText("Subtotal : " + balance + HelpFormatter.DEFAULT_LONG_OPT_SEPARATOR);
                    }
                    FragmentFeeMainNewBinding fragmentFeeMainNewBinding4 = this$0.get_binding();
                    TextView textView3 = fragmentFeeMainNewBinding4 != null ? fragmentFeeMainNewBinding4.tvFine : null;
                    if (textView3 != null) {
                        textView3.setText("Fine : " + feeArtsResponse.getFine());
                    }
                    FragmentFeeMainNewBinding fragmentFeeMainNewBinding5 = this$0.get_binding();
                    textView = fragmentFeeMainNewBinding5 != null ? fragmentFeeMainNewBinding5.tvFeeArtsTotal : null;
                    if (textView == null) {
                        return;
                    }
                    textView.setText("Total : " + feeArtsResponse.getTotal() + "  ");
                    return;
                }
                FragmentFeeMainNewBinding fragmentFeeMainNewBinding6 = this$0.get_binding();
                MaterialCardView materialCardView2 = fragmentFeeMainNewBinding6 != null ? fragmentFeeMainNewBinding6.fineLayout : null;
                if (materialCardView2 != null) {
                    materialCardView2.setVisibility(8);
                }
                int size2 = feeArtsResponse.getFee_groups().size() - 1;
                if (size2 >= 0) {
                    int i3 = 0;
                    while (true) {
                        balance += this$0.listArts.get(i3).getBalance();
                        if (i3 == size2) {
                            break;
                        } else {
                            i3++;
                        }
                    }
                }
                FragmentFeeMainNewBinding fragmentFeeMainNewBinding7 = this$0.get_binding();
                textView = fragmentFeeMainNewBinding7 != null ? fragmentFeeMainNewBinding7.tvFeeArtsTotal : null;
                if (textView == null) {
                    return;
                }
                textView.setText("Total : " + balance + "  ");
                return;
            }
            FragmentFeeMainNewBinding fragmentFeeMainNewBinding8 = this$0.get_binding();
            if (fragmentFeeMainNewBinding8 == null || (rvFeeArts = fragmentFeeMainNewBinding8.rvFeeArts) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(rvFeeArts, "rvFeeArts");
            ToastExtKt.showErrorToast(rvFeeArts, "network error");
        }
    }

    private final void listenKmeaResponse() {
        getFeeEngineerViewModel().getKmeaResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.fees.FeeMainNewFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FeeMainNewFragment.listenKmeaResponse$lambda$11(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenKmeaResponse$lambda$11(FeeMainNewFragment this$0, Resource resource) {
        RecyclerView rvFeeEngnr;
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
            FragmentFeeMainNewBinding fragmentFeeMainNewBinding = this$0.get_binding();
            if (fragmentFeeMainNewBinding == null || (recyclerView = fragmentFeeMainNewBinding.rvFeeEngnr) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(recyclerView, message);
            return;
        }
        this$0.hideProgress();
        FeeEngineerResponse feeEngineerResponse = (FeeEngineerResponse) resource.getData();
        if (feeEngineerResponse != null) {
            this$0.showBaseView();
            if (feeEngineerResponse.getLogin() && feeEngineerResponse.getSuccess()) {
                FeesMainEngineerAdapter adapter = this$0.getAdapter();
                ArrayList<FeeEngineer> fees = feeEngineerResponse.getFees();
                Context contextRequireContext = this$0.requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                adapter.addItems(fees, contextRequireContext);
                this$0.list = feeEngineerResponse.getFees();
                return;
            }
            FragmentFeeMainNewBinding fragmentFeeMainNewBinding2 = this$0.get_binding();
            if (fragmentFeeMainNewBinding2 == null || (rvFeeEngnr = fragmentFeeMainNewBinding2.rvFeeEngnr) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(rvFeeEngnr, "rvFeeEngnr");
            ToastExtKt.showErrorToast(rvFeeEngnr, feeEngineerResponse.getMessage());
        }
    }

    private final void listenUrlResponse() {
        getFeeEngineerViewModel().getFeeUrlResponse().observe(getViewLifecycleOwner(), new FeeMainNewFragment$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends FeeEngineerUrlResponse>, Unit>() { // from class: in.etuwa.app.ui.fees.FeeMainNewFragment.listenUrlResponse.1

            /* JADX INFO: renamed from: in.etuwa.app.ui.fees.FeeMainNewFragment$listenUrlResponse$1$WhenMappings */
            /* JADX INFO: compiled from: FeeMainNewFragment.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends FeeEngineerUrlResponse> resource) {
                invoke2((Resource<FeeEngineerUrlResponse>) resource);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<FeeEngineerUrlResponse> resource) {
                MaterialButton payFeeEngnrBtn;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                boolean z = true;
                if (i != 1) {
                    if (i == 2) {
                        FeeMainNewFragment.this.showProgress();
                        return;
                    }
                    if (i == 3) {
                        FeeMainNewFragment.this.hideProgress();
                        FeeMainNewFragment.this.showBaseView();
                        return;
                    } else {
                        if (i != 4) {
                            return;
                        }
                        FeeMainNewFragment.this.hideProgress();
                        FeeMainNewFragment.this.showBaseView();
                        return;
                    }
                }
                FeeMainNewFragment.this.hideProgress();
                FeeEngineerUrlResponse data = resource.getData();
                if (data != null) {
                    FeeMainNewFragment feeMainNewFragment = FeeMainNewFragment.this;
                    feeMainNewFragment.showBaseView();
                    System.out.println((Object) data.getUrl());
                    String url = data.getUrl();
                    if (!(url == null || url.length() == 0)) {
                        String error = data.getError();
                        if (error != null && error.length() != 0) {
                            z = false;
                        }
                        if (z) {
                            FragmentManager childFragmentManager = feeMainNewFragment.getChildFragmentManager();
                            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
                            FeeConfirmDialog feeConfirmDialogNewInstance = FeeConfirmDialog.INSTANCE.newInstance(data.getTotal(), data.getFine(), data.getSubtotal(), data.getUrl());
                            feeConfirmDialogNewInstance.setNewCallBack(feeMainNewFragment);
                            feeConfirmDialogNewInstance.show(childFragmentManager, (String) null);
                            return;
                        }
                    }
                    FragmentFeeMainNewBinding fragmentFeeMainNewBinding = feeMainNewFragment.get_binding();
                    if (fragmentFeeMainNewBinding == null || (payFeeEngnrBtn = fragmentFeeMainNewBinding.payFeeEngnrBtn) == null) {
                        return;
                    }
                    Intrinsics.checkNotNullExpressionValue(payFeeEngnrBtn, "payFeeEngnrBtn");
                    MaterialButton materialButton = payFeeEngnrBtn;
                    String error2 = data.getError();
                    if (error2 == null) {
                        error2 = "Something went wrong";
                    }
                    ToastExtKt.showErrorToast(materialButton, error2);
                }
            }
        }));
    }

    private final void listenReceiptResponse() {
        getFeeEngineerViewModel().getReceiptResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.fees.FeeMainNewFragment$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FeeMainNewFragment.listenReceiptResponse$lambda$13(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenReceiptResponse$lambda$13(FeeMainNewFragment this$0, Resource resource) {
        RecyclerView rvFeeReceipt;
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            ReceiptResponse receiptResponse = (ReceiptResponse) resource.getData();
            if (receiptResponse != null) {
                this$0.showBaseView();
                if (receiptResponse.getLogin()) {
                    if (receiptResponse.getSuccess()) {
                        this$0.getAdapterReceipt().addItems(receiptResponse.getReceipts());
                        return;
                    }
                    FragmentFeeMainNewBinding fragmentFeeMainNewBinding = this$0.get_binding();
                    if (fragmentFeeMainNewBinding == null || (rvFeeReceipt = fragmentFeeMainNewBinding.rvFeeReceipt) == null) {
                        return;
                    }
                    Intrinsics.checkNotNullExpressionValue(rvFeeReceipt, "rvFeeReceipt");
                    ToastExtKt.showErrorToast(rvFeeReceipt, receiptResponse.getMessage());
                    return;
                }
                return;
            }
            return;
        }
        if (i == 2) {
            this$0.hideBaseView();
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
        FragmentFeeMainNewBinding fragmentFeeMainNewBinding2 = this$0.get_binding();
        if (fragmentFeeMainNewBinding2 == null || (recyclerView = fragmentFeeMainNewBinding2.rvFeeReceipt) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(recyclerView, message);
    }

    private final void listenArtsUrlResponse() {
        getFeeEngineerViewModel().getFeeUrlArtsResponse().observe(getViewLifecycleOwner(), new FeeMainNewFragment$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends FeeArtsUrlResponse>, Unit>() { // from class: in.etuwa.app.ui.fees.FeeMainNewFragment.listenArtsUrlResponse.1

            /* JADX INFO: renamed from: in.etuwa.app.ui.fees.FeeMainNewFragment$listenArtsUrlResponse$1$WhenMappings */
            /* JADX INFO: compiled from: FeeMainNewFragment.kt */
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

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<FeeArtsUrlResponse> resource) {
                MainCallBackListener mainCallBackListener;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        FeeMainNewFragment.this.showProgress();
                        return;
                    }
                    if (i == 3) {
                        FeeMainNewFragment.this.hideProgress();
                        FeeMainNewFragment.this.showBaseView();
                        return;
                    } else {
                        if (i != 4) {
                            return;
                        }
                        FeeMainNewFragment.this.hideProgress();
                        FeeMainNewFragment.this.showBaseView();
                        return;
                    }
                }
                FeeMainNewFragment.this.hideProgress();
                FeeArtsUrlResponse data = resource.getData();
                if (data != null) {
                    FeeMainNewFragment feeMainNewFragment = FeeMainNewFragment.this;
                    feeMainNewFragment.showBaseView();
                    System.out.println((Object) data.getUrl());
                    if (Intrinsics.areEqual(data.getUrl(), "") || (mainCallBackListener = feeMainNewFragment.listener) == null) {
                        return;
                    }
                    mainCallBackListener.openPaymentPage(data.getUrl());
                }
            }
        }));
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
        RecyclerView recyclerView;
        FragmentFeeMainNewBinding fragmentFeeMainNewBinding = get_binding();
        if (fragmentFeeMainNewBinding == null || (recyclerView = fragmentFeeMainNewBinding.rvFeeEngnr) == null) {
            return;
        }
        RecycleExtKt.show(recyclerView);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
        RecyclerView recyclerView;
        FragmentFeeMainNewBinding fragmentFeeMainNewBinding = get_binding();
        if (fragmentFeeMainNewBinding == null || (recyclerView = fragmentFeeMainNewBinding.rvFeeEngnr) == null) {
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

    @Override // in.etuwa.app.ui.fees.FeesMainEngineerAdapter.CallBack
    public void updateSelected(List<String> sel, List<String> total) {
        int size;
        Intrinsics.checkNotNullParameter(sel, "sel");
        Intrinsics.checkNotNullParameter(total, "total");
        int size2 = total.size() - 1;
        double d = 0.0d;
        if (size2 >= 0) {
            int i = 0;
            while (true) {
                d += Double.parseDouble(total.get(i));
                if (d <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                    FragmentFeeMainNewBinding fragmentFeeMainNewBinding = get_binding();
                    MaterialButton materialButton = fragmentFeeMainNewBinding != null ? fragmentFeeMainNewBinding.payFeeEngnrBtn : null;
                    if (materialButton != null) {
                        materialButton.setVisibility(8);
                    }
                } else {
                    FragmentFeeMainNewBinding fragmentFeeMainNewBinding2 = get_binding();
                    MaterialButton materialButton2 = fragmentFeeMainNewBinding2 != null ? fragmentFeeMainNewBinding2.payFeeEngnrBtn : null;
                    if (materialButton2 != null) {
                        materialButton2.setVisibility(0);
                    }
                }
                if (i == size2) {
                    break;
                } else {
                    i++;
                }
            }
        }
        FragmentFeeMainNewBinding fragmentFeeMainNewBinding3 = get_binding();
        TextView textView = fragmentFeeMainNewBinding3 != null ? fragmentFeeMainNewBinding3.tvFeeEngnrTotal : null;
        if (textView != null) {
            textView.setText(String.valueOf(d));
        }
        int size3 = this.selected.size() - 1;
        double d2 = 0.0d;
        if (size3 >= 0) {
            int i2 = 0;
            while (true) {
                try {
                    if (Intrinsics.areEqual(sel.get(i2), "true") && this.list.get(i2).getInstallments().size() - 1 >= 0) {
                        int i3 = 0;
                        while (true) {
                            d2 += Double.parseDouble(this.list.get(i2).getInstallments().get(i3).getBalance());
                            if (d2 <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                                FragmentFeeMainNewBinding fragmentFeeMainNewBinding4 = get_binding();
                                MaterialButton materialButton3 = fragmentFeeMainNewBinding4 != null ? fragmentFeeMainNewBinding4.payFeeEngnrBtn : null;
                                if (materialButton3 != null) {
                                    materialButton3.setVisibility(8);
                                }
                            } else {
                                FragmentFeeMainNewBinding fragmentFeeMainNewBinding5 = get_binding();
                                MaterialButton materialButton4 = fragmentFeeMainNewBinding5 != null ? fragmentFeeMainNewBinding5.payFeeEngnrBtn : null;
                                if (materialButton4 != null) {
                                    materialButton4.setVisibility(0);
                                }
                            }
                            if (i3 == size) {
                                break;
                            } else {
                                i3++;
                            }
                        }
                    }
                    if (i2 == size3) {
                        break;
                    } else {
                        i2++;
                    }
                } catch (IndexOutOfBoundsException unused) {
                }
            }
        }
        this.selected = sel;
        this.selectedTotal = total;
        this.total = d2;
        if (d <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            FragmentFeeMainNewBinding fragmentFeeMainNewBinding6 = get_binding();
            MaterialButton materialButton5 = fragmentFeeMainNewBinding6 != null ? fragmentFeeMainNewBinding6.payFeeEngnrBtn : null;
            if (materialButton5 == null) {
                return;
            }
            materialButton5.setVisibility(8);
            return;
        }
        FragmentFeeMainNewBinding fragmentFeeMainNewBinding7 = get_binding();
        MaterialButton materialButton6 = fragmentFeeMainNewBinding7 != null ? fragmentFeeMainNewBinding7.payFeeEngnrBtn : null;
        if (materialButton6 == null) {
            return;
        }
        materialButton6.setVisibility(0);
    }

    @Override // in.etuwa.app.ui.fees.FeesMainEngineerAdapter.CallBack
    public void selectedIds(int position) {
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        FeeDetailDialog.INSTANCE.newInstance(position).show(childFragmentManager, (String) null);
    }

    @Override // in.etuwa.app.ui.feenewengineer.payment.dialog.FeeDetailDialog.FeeDetailListner
    public void dismiss() {
        FrameLayout frameLayout;
        if (getPreference().getFeeEngnrNew() || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "sjcetpalai", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "mvjce", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "asiet", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "sngce.", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "tkmit", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "vjec", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "christ", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "ukfcet", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "demo", false, 2, (Object) null)) {
            getFeeEngineerViewModel().getFees();
            FragmentFeeMainNewBinding fragmentFeeMainNewBinding = get_binding();
            FrameLayout frameLayout2 = fragmentFeeMainNewBinding != null ? fragmentFeeMainNewBinding.feeEngineerLyt : null;
            if (frameLayout2 != null) {
                frameLayout2.setVisibility(0);
            }
            FragmentFeeMainNewBinding fragmentFeeMainNewBinding2 = get_binding();
            frameLayout = fragmentFeeMainNewBinding2 != null ? fragmentFeeMainNewBinding2.feeArtsLyt : null;
            if (frameLayout == null) {
                return;
            }
            frameLayout.setVisibility(8);
            return;
        }
        if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "naher", false, 2, (Object) null)) {
            getFeeEngineerViewModel().getSemester();
            getFeeEngineerViewModel().getFeesSemWise(getPreference().getUserSemId());
            FragmentFeeMainNewBinding fragmentFeeMainNewBinding3 = get_binding();
            MaterialCardView materialCardView = fragmentFeeMainNewBinding3 != null ? fragmentFeeMainNewBinding3.seriesLayout : null;
            if (materialCardView != null) {
                materialCardView.setVisibility(0);
            }
        } else {
            getFeeEngineerViewModel().getFeesArts();
            FragmentFeeMainNewBinding fragmentFeeMainNewBinding4 = get_binding();
            MaterialCardView materialCardView2 = fragmentFeeMainNewBinding4 != null ? fragmentFeeMainNewBinding4.seriesLayout : null;
            if (materialCardView2 != null) {
                materialCardView2.setVisibility(8);
            }
        }
        FragmentFeeMainNewBinding fragmentFeeMainNewBinding5 = get_binding();
        FrameLayout frameLayout3 = fragmentFeeMainNewBinding5 != null ? fragmentFeeMainNewBinding5.feeEngineerLyt : null;
        if (frameLayout3 != null) {
            frameLayout3.setVisibility(8);
        }
        FragmentFeeMainNewBinding fragmentFeeMainNewBinding6 = get_binding();
        frameLayout = fragmentFeeMainNewBinding6 != null ? fragmentFeeMainNewBinding6.feeArtsLyt : null;
        if (frameLayout == null) {
            return;
        }
        frameLayout.setVisibility(0);
    }

    @Override // in.etuwa.app.ui.feenewengineer.payment.feeconfirmdialog.FeeConfirmDialog.FeeDetailListner
    public void openPaymentPage(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        MainCallBackListener mainCallBackListener = this.listener;
        if (mainCallBackListener != null) {
            mainCallBackListener.openPaymentPage(url);
        }
    }
}