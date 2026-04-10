package in.etuwa.app.ui.feenewarts.payment;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.feearts.payment.FeeArts;
import in.etuwa.app.data.model.feearts.payment.FeeArtsResponse;
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

/* JADX INFO: compiled from: FeeArtsFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class FeeArtsFragment extends BaseFragment implements FeeArtsAdapter.CallBack {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentFeeArtsBinding _binding;

    /* JADX INFO: renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;
    private String bal;

    /* JADX INFO: renamed from: feeArtsViewModel$delegate, reason: from kotlin metadata */
    private final Lazy feeArtsViewModel;
    private ArrayList<FeeArts> list;
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

    /* JADX INFO: compiled from: FeeArtsFragment.kt */
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
                return feeArtsFragment;
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
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) function0.invoke()).getViewModelStore();
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
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) function0.invoke(), Reflection.getOrCreateKotlinClass(FeeArtsViewModel.class), qualifier, b, null, koinScope);
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
                return ParametersHolderKt.parametersOf(this.this$0.requireActivity());
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

    /* JADX INFO: renamed from: getBinding, reason: from getter */
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

    /* JADX INFO: compiled from: FeeArtsFragment.kt */
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
        MaterialButton materialButton;
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
            spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.feenewarts.payment.FeeArtsFragment.setUp.1
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    FeeArtsFragment.this.getFeeArtsViewModel().getFeesSemWise(String.valueOf(FeeArtsFragment.this.getSpinnerAdapter().getSemester(position).getId()));
                }
            });
        }
        final HashMap map = new HashMap();
        FragmentFeeArtsBinding fragmentFeeArtsBinding6 = get_binding();
        if (fragmentFeeArtsBinding6 == null || (materialButton = fragmentFeeArtsBinding6.payFeeArtsBtn) == null) {
            return;
        }
        materialButton.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.feenewarts.payment.FeeArtsFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeeArtsFragment.setUp$lambda$0(this.f$0, map, view);
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
                    HashMap map = FeeCollection;
                    map.put("payment", "1");
                    map.put("Transaction[method]", "5");
                    map.put("FeeReceipt[receipt_date]", this$0.receipt_date);
                    map.put("FeeReceipt[amount]", this$0.bal);
                    map.put("installment", this$0.list.get(0).getInstallment_id());
                }
                if (this$0.list.get(i).getBalance() != 0) {
                    HashMap map2 = FeeCollection;
                    map2.put("FeeCollection[" + this$0.list.get(i).getFee_head_id() + "][amount]", String.valueOf(this$0.list.get(i).getBalance()));
                    map2.put("FeeCollection[" + this$0.list.get(i).getFee_head_id() + "][feegroup_id]", this$0.list.get(i).getFeegroup_id());
                    map2.put("FeeCollection[" + this$0.list.get(i).getFee_head_id() + "][feetype_id]", this$0.list.get(i).getFeetype_id());
                    map2.put("FeeCollection[" + this$0.list.get(i).getFee_head_id() + "][installment_id]", this$0.list.get(i).getInstallment_id());
                    map2.put("FeeCollection[" + this$0.list.get(i).getFee_head_id() + "][feehead_id]", this$0.list.get(i).getFee_head_id());
                    map2.put("FeeCollection[" + this$0.list.get(i).getFee_head_id() + "][student_id]", this$0.studentId);
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
                FeeArtsFragment.listenSemResponse$lambda$2(this.f$0, (Resource) obj);
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
                FeeArtsFragment.listenResponse$lambda$4(this.f$0, (Resource) obj);
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
                int balance = 0;
                if (StringsKt.contains$default((CharSequence) this$0.getPreference().getBaseUrl(), (CharSequence) "naher", false, 2, (Object) null)) {
                    FragmentFeeArtsBinding fragmentFeeArtsBinding2 = this$0.get_binding();
                    MaterialCardView materialCardView = fragmentFeeArtsBinding2 != null ? fragmentFeeArtsBinding2.fineLayout : null;
                    if (materialCardView != null) {
                        materialCardView.setVisibility(0);
                    }
                    int size = feeArtsResponse.getFee_groups().size() - 1;
                    if (size >= 0) {
                        int i2 = 0;
                        while (true) {
                            balance += this$0.list.get(i2).getBalance();
                            if (i2 == size) {
                                break;
                            } else {
                                i2++;
                            }
                        }
                    }
                    FragmentFeeArtsBinding fragmentFeeArtsBinding3 = this$0.get_binding();
                    TextView textView2 = fragmentFeeArtsBinding3 != null ? fragmentFeeArtsBinding3.tvSubtotal : null;
                    if (textView2 != null) {
                        textView2.setText("Subtotal : " + balance + HelpFormatter.DEFAULT_LONG_OPT_SEPARATOR);
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
                MaterialCardView materialCardView2 = fragmentFeeArtsBinding6 != null ? fragmentFeeArtsBinding6.fineLayout : null;
                if (materialCardView2 != null) {
                    materialCardView2.setVisibility(8);
                }
                int size2 = feeArtsResponse.getFee_groups().size() - 1;
                if (size2 >= 0) {
                    int i3 = 0;
                    while (true) {
                        balance += this$0.list.get(i3).getBalance();
                        if (i3 == size2) {
                            break;
                        } else {
                            i3++;
                        }
                    }
                }
                FragmentFeeArtsBinding fragmentFeeArtsBinding7 = this$0.get_binding();
                textView = fragmentFeeArtsBinding7 != null ? fragmentFeeArtsBinding7.tvFeeArtsTotal : null;
                if (textView == null) {
                    return;
                }
                textView.setText(String.valueOf(balance));
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
        getFeeArtsViewModel().getFeeUrlResponse().observe(getViewLifecycleOwner(), new FeeArtsFragment$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends FeeArtsUrlResponse>, Unit>() { // from class: in.etuwa.app.ui.feenewarts.payment.FeeArtsFragment.listenUrlResponse.1

            /* JADX INFO: renamed from: in.etuwa.app.ui.feenewarts.payment.FeeArtsFragment$listenUrlResponse$1$WhenMappings */
            /* JADX INFO: compiled from: FeeArtsFragment.kt */
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
                        FeeArtsFragment.this.showProgress();
                        return;
                    }
                    if (i == 3) {
                        FeeArtsFragment.this.hideProgress();
                        FeeArtsFragment.this.showBaseView();
                        return;
                    } else {
                        if (i != 4) {
                            return;
                        }
                        FeeArtsFragment.this.hideProgress();
                        FeeArtsFragment.this.showBaseView();
                        return;
                    }
                }
                FeeArtsFragment.this.hideProgress();
                FeeArtsUrlResponse data = resource.getData();
                if (data != null) {
                    FeeArtsFragment feeArtsFragment = FeeArtsFragment.this;
                    feeArtsFragment.showBaseView();
                    System.out.println((Object) data.getUrl());
                    if (Intrinsics.areEqual(data.getUrl(), "") || (mainCallBackListener = feeArtsFragment.listener) == null) {
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