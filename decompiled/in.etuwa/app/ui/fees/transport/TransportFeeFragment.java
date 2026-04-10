package in.etuwa.app.ui.fees.transport;

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
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.button.MaterialButton;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.transport.TransportFeeResponse;
import in.etuwa.app.data.model.transport.TransportInstallments;
import in.etuwa.app.data.model.transport.TransportPayUrl;
import in.etuwa.app.databinding.FragmentTransportBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.feenewengineer.payment.feeconfirmdialog.FeeConfirmDialogKt;
import in.etuwa.app.ui.fees.transport.TransportFeeAdapter;
import in.etuwa.app.ui.transport.payment.dialog.TrasportFeePayDialog;
import in.etuwa.app.ui.transport.registration.register.BoardingSpinnerAdapter;
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
import kotlin.NotImplementedError;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.parameter.ParametersHolderKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* JADX INFO: compiled from: TransportFeeFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class TransportFeeFragment extends BaseFragment implements TransportFeeAdapter.CallBack, TrasportFeePayDialog.FeeDetailListner {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentTransportBinding _binding;

    /* JADX INFO: renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;
    private ArrayList<TransportInstallments> list;
    private MainCallBackListener listener;
    private List<String> selected;

    /* JADX INFO: renamed from: spinnerAdapter$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdapter;
    private String studentId;
    private int total;

    /* JADX INFO: renamed from: transportFeeViewModel$delegate, reason: from kotlin metadata */
    private final Lazy transportFeeViewModel;
    private String yearId;

    /* JADX INFO: compiled from: TransportFeeFragment.kt */
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
    public static final TransportFeeFragment newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public TransportFeeFragment() {
        final TransportFeeFragment transportFeeFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.fees.transport.TransportFeeFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return transportFeeFragment;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(transportFeeFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.transportFeeViewModel = FragmentViewModelLazyKt.createViewModelLazy(transportFeeFragment, Reflection.getOrCreateKotlinClass(TransportFeeViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.fees.transport.TransportFeeFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.fees.transport.TransportFeeFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) function0.invoke(), Reflection.getOrCreateKotlinClass(TransportFeeViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final TransportFeeFragment transportFeeFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<TransportFeeAdapter>() { // from class: in.etuwa.app.ui.fees.transport.TransportFeeFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.fees.transport.TransportFeeAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final TransportFeeAdapter invoke() {
                ComponentCallbacks componentCallbacks = transportFeeFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(TransportFeeAdapter.class), b2, b3);
            }
        });
        this.list = new ArrayList<>();
        this.selected = new ArrayList();
        final Function0<ParametersHolder> function02 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.fees.transport.TransportFeeFragment$spinnerAdapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(this.this$0.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        this.spinnerAdapter = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<BoardingSpinnerAdapter>() { // from class: in.etuwa.app.ui.fees.transport.TransportFeeFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.transport.registration.register.BoardingSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final BoardingSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = transportFeeFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(BoardingSpinnerAdapter.class), b4, function02);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TransportFeeViewModel getTransportFeeViewModel() {
        return (TransportFeeViewModel) this.transportFeeViewModel.getValue();
    }

    private final TransportFeeAdapter getAdapter() {
        return (TransportFeeAdapter) this.adapter.getValue();
    }

    /* JADX INFO: renamed from: getBinding, reason: from getter */
    private final FragmentTransportBinding get_binding() {
        return this._binding;
    }

    public final List<String> getSelected() {
        return this.selected;
    }

    public final void setSelected(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.selected = list;
    }

    public final int getTotal() {
        return this.total;
    }

    public final void setTotal(int i) {
        this.total = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BoardingSpinnerAdapter getSpinnerAdapter() {
        return (BoardingSpinnerAdapter) this.spinnerAdapter.getValue();
    }

    /* JADX INFO: compiled from: TransportFeeFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/fees/transport/TransportFeeFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/fees/transport/TransportFeeFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final TransportFeeFragment newInstance() {
            return new TransportFeeFragment();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentTransportBinding.inflate(inflater, container, false);
        FragmentTransportBinding fragmentTransportBinding = get_binding();
        if (fragmentTransportBinding != null) {
            fragmentTransportBinding.setTransportFeeViewModel(getTransportFeeViewModel());
        }
        FragmentTransportBinding fragmentTransportBinding2 = get_binding();
        if (fragmentTransportBinding2 != null) {
            fragmentTransportBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        FragmentTransportBinding fragmentTransportBinding3 = get_binding();
        if (fragmentTransportBinding3 != null) {
            return fragmentTransportBinding3.getRoot();
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
        SwipeRefreshLayout swipeRefreshLayout;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle("Transport Fees");
        }
        hideBaseView();
        FragmentTransportBinding fragmentTransportBinding = get_binding();
        RecyclerView recyclerView = fragmentTransportBinding != null ? fragmentTransportBinding.rvTransport : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        FragmentTransportBinding fragmentTransportBinding2 = get_binding();
        Spinner spinner = fragmentTransportBinding2 != null ? fragmentTransportBinding2.spinnerYearTransport : null;
        if (spinner != null) {
            spinner.setAdapter((SpinnerAdapter) getSpinnerAdapter());
        }
        listenSpinnerResponse();
        listenUrlResponse();
        final HashMap map = new HashMap();
        getAdapter().setCallBack(this);
        getTransportFeeViewModel().getTransportFeeYears();
        FragmentTransportBinding fragmentTransportBinding3 = get_binding();
        if (fragmentTransportBinding3 != null && (swipeRefreshLayout = fragmentTransportBinding3.swipeLayout) != null) {
            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: in.etuwa.app.ui.fees.transport.TransportFeeFragment$$ExternalSyntheticLambda3
                @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
                public final void onRefresh() {
                    TransportFeeFragment.setUp$lambda$0(this.f$0);
                }
            });
        }
        FragmentTransportBinding fragmentTransportBinding4 = get_binding();
        Spinner spinner2 = fragmentTransportBinding4 != null ? fragmentTransportBinding4.spinnerYearTransport : null;
        if (spinner2 != null) {
            spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.fees.transport.TransportFeeFragment.setUp.2
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    TransportFeeFragment transportFeeFragment = TransportFeeFragment.this;
                    transportFeeFragment.yearId = String.valueOf(transportFeeFragment.getSpinnerAdapter().getType(position).getId());
                    TransportFeeViewModel transportFeeViewModel = TransportFeeFragment.this.getTransportFeeViewModel();
                    String str = TransportFeeFragment.this.yearId;
                    Intrinsics.checkNotNull(str);
                    transportFeeViewModel.getTransportFees(str);
                    TransportFeeFragment.this.listenResponse();
                }
            });
        }
        FragmentTransportBinding fragmentTransportBinding5 = get_binding();
        if (fragmentTransportBinding5 == null || (materialButton = fragmentTransportBinding5.payTransportBtn) == null) {
            return;
        }
        materialButton.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.fees.transport.TransportFeeFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TransportFeeFragment.setUp$lambda$1(map, this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$0(TransportFeeFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TransportFeeViewModel transportFeeViewModel = this$0.getTransportFeeViewModel();
        String str = this$0.yearId;
        Intrinsics.checkNotNull(str);
        transportFeeViewModel.getTransportFees(str);
        FragmentTransportBinding fragmentTransportBinding = this$0.get_binding();
        SwipeRefreshLayout swipeRefreshLayout = fragmentTransportBinding != null ? fragmentTransportBinding.swipeLayout : null;
        if (swipeRefreshLayout == null) {
            return;
        }
        swipeRefreshLayout.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(HashMap transportFeeCollection, TransportFeeFragment this$0, View view) {
        TextView textView;
        TextView textView2;
        Intrinsics.checkNotNullParameter(transportFeeCollection, "$transportFeeCollection");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        HashMap map = transportFeeCollection;
        map.put("year_id", String.valueOf(this$0.yearId));
        map.put("TransportReceipt[method]", "4");
        map.put("Payment", "1");
        FragmentTransportBinding fragmentTransportBinding = this$0.get_binding();
        CharSequence text = null;
        map.put("TransportReceipt[amount]", String.valueOf((fragmentTransportBinding == null || (textView2 = fragmentTransportBinding.tvTransportTotal) == null) ? null : textView2.getText()));
        FragmentTransportBinding fragmentTransportBinding2 = this$0.get_binding();
        if (fragmentTransportBinding2 != null && (textView = fragmentTransportBinding2.tvTransportTotal) != null) {
            text = textView.getText();
        }
        map.put("TransportReceipt[sub_total]", String.valueOf(text));
        map.put("TransportReceipt[fine_amount]", "0");
        int size = this$0.selected.size() - 1;
        if (size >= 0) {
            int i = 0;
            while (true) {
                if (Intrinsics.areEqual(this$0.selected.get(i), "true")) {
                    map.put("TransportFeeCollection[" + this$0.list.get(i).getInstallment_id() + "][head_id]", this$0.list.get(i).getHead_id());
                    String str = "TransportFeeCollection[" + this$0.list.get(i).getInstallment_id() + "][student_id]";
                    String str2 = this$0.studentId;
                    Intrinsics.checkNotNull(str2);
                    map.put(str, str2);
                    map.put("TransportFeeCollection[" + this$0.list.get(i).getInstallment_id() + "][installment_id]", this$0.list.get(i).getInstallment_id());
                    map.put("TransportFeeCollection[" + this$0.list.get(i).getInstallment_id() + "][fine]", "");
                }
                if (i == size) {
                    break;
                } else {
                    i++;
                }
            }
        }
        this$0.getTransportFeeViewModel().getTransportFeesUrl(map);
    }

    private final void listenSpinnerResponse() {
        getTransportFeeViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.fees.transport.TransportFeeFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TransportFeeFragment.listenSpinnerResponse$lambda$3(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenSpinnerResponse$lambda$3(TransportFeeFragment this$0, Resource resource) {
        RecyclerView rvTransport;
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
            FragmentTransportBinding fragmentTransportBinding = this$0.get_binding();
            if (fragmentTransportBinding == null || (recyclerView = fragmentTransportBinding.rvTransport) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(recyclerView, message);
            return;
        }
        this$0.hideProgress();
        TransportFeeResponse transportFeeResponse = (TransportFeeResponse) resource.getData();
        if (transportFeeResponse != null) {
            this$0.showBaseView();
            if (Intrinsics.areEqual(transportFeeResponse.getError(), "")) {
                this$0.getSpinnerAdapter().addItems(transportFeeResponse.getYears());
                this$0.yearId = String.valueOf(transportFeeResponse.getYears().get(0).getId());
                FragmentTransportBinding fragmentTransportBinding2 = this$0.get_binding();
                TextView textView = fragmentTransportBinding2 != null ? fragmentTransportBinding2.boardingPointTv : null;
                if (textView == null) {
                    return;
                }
                textView.setText("BoardingPoint : " + transportFeeResponse.getBoarding_point());
                return;
            }
            FragmentTransportBinding fragmentTransportBinding3 = this$0.get_binding();
            if (fragmentTransportBinding3 == null || (rvTransport = fragmentTransportBinding3.rvTransport) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(rvTransport, "rvTransport");
            ToastExtKt.showErrorToast(rvTransport, transportFeeResponse.getError());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void listenResponse() {
        getTransportFeeViewModel().getFeesResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.fees.transport.TransportFeeFragment$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TransportFeeFragment.listenResponse$lambda$5(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$5(TransportFeeFragment this$0, Resource resource) {
        RecyclerView rvTransport;
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
            FragmentTransportBinding fragmentTransportBinding = this$0.get_binding();
            if (fragmentTransportBinding == null || (recyclerView = fragmentTransportBinding.rvTransport) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(recyclerView, message);
            return;
        }
        this$0.hideProgress();
        TransportFeeResponse transportFeeResponse = (TransportFeeResponse) resource.getData();
        if (transportFeeResponse != null) {
            this$0.showBaseView();
            try {
                if (Intrinsics.areEqual(transportFeeResponse.getError(), "")) {
                    FragmentTransportBinding fragmentTransportBinding2 = this$0.get_binding();
                    SwipeRefreshLayout swipeRefreshLayout = fragmentTransportBinding2 != null ? fragmentTransportBinding2.swipeLayout : null;
                    if (swipeRefreshLayout != null) {
                        swipeRefreshLayout.setVisibility(0);
                    }
                    FragmentTransportBinding fragmentTransportBinding3 = this$0.get_binding();
                    LinearLayout linearLayout = fragmentTransportBinding3 != null ? fragmentTransportBinding3.noDataLyt : null;
                    if (linearLayout != null) {
                        linearLayout.setVisibility(8);
                    }
                    this$0.getAdapter().addItems(transportFeeResponse.getInstallments());
                    this$0.list = transportFeeResponse.getInstallments();
                    FragmentTransportBinding fragmentTransportBinding4 = this$0.get_binding();
                    textView = fragmentTransportBinding4 != null ? fragmentTransportBinding4.noDataTv : null;
                    if (textView != null) {
                        textView.setText(transportFeeResponse.getError());
                    }
                } else {
                    FragmentTransportBinding fragmentTransportBinding5 = this$0.get_binding();
                    SwipeRefreshLayout swipeRefreshLayout2 = fragmentTransportBinding5 != null ? fragmentTransportBinding5.swipeLayout : null;
                    if (swipeRefreshLayout2 != null) {
                        swipeRefreshLayout2.setVisibility(8);
                    }
                    FragmentTransportBinding fragmentTransportBinding6 = this$0.get_binding();
                    LinearLayout linearLayout2 = fragmentTransportBinding6 != null ? fragmentTransportBinding6.noDataLyt : null;
                    if (linearLayout2 != null) {
                        linearLayout2.setVisibility(0);
                    }
                    FragmentTransportBinding fragmentTransportBinding7 = this$0.get_binding();
                    textView = fragmentTransportBinding7 != null ? fragmentTransportBinding7.noDataTv : null;
                    if (textView != null) {
                        textView.setText(transportFeeResponse.getError());
                    }
                }
            } catch (NullPointerException unused) {
                this$0.getAdapter().clearData();
                FragmentTransportBinding fragmentTransportBinding8 = this$0.get_binding();
                if (fragmentTransportBinding8 != null && (rvTransport = fragmentTransportBinding8.rvTransport) != null) {
                    Intrinsics.checkNotNullExpressionValue(rvTransport, "rvTransport");
                    ToastExtKt.showErrorToast(rvTransport, transportFeeResponse.getError());
                }
            }
            this$0.studentId = transportFeeResponse.getStudent_id();
        }
    }

    private final void listenUrlResponse() {
        getTransportFeeViewModel().getFeesUrlResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.fees.transport.TransportFeeFragment$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TransportFeeFragment.listenUrlResponse$lambda$7(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenUrlResponse$lambda$7(TransportFeeFragment this$0, Resource resource) {
        MainCallBackListener mainCallBackListener;
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            TransportPayUrl transportPayUrl = (TransportPayUrl) resource.getData();
            if (transportPayUrl != null) {
                this$0.showBaseView();
                System.out.println((Object) transportPayUrl.getUrl());
                if (Intrinsics.areEqual(transportPayUrl.getUrl(), "") || (mainCallBackListener = this$0.listener) == null) {
                    return;
                }
                mainCallBackListener.openPaymentPage(transportPayUrl.getUrl());
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
            this$0.showBaseView();
            return;
        }
        if (i != 4) {
            return;
        }
        this$0.hideProgress();
        this$0.showBaseView();
        FragmentTransportBinding fragmentTransportBinding = this$0.get_binding();
        if (fragmentTransportBinding == null || (recyclerView = fragmentTransportBinding.rvTransport) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(recyclerView, message);
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

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
        RecyclerView recyclerView;
        FragmentTransportBinding fragmentTransportBinding = get_binding();
        if (fragmentTransportBinding == null || (recyclerView = fragmentTransportBinding.rvTransport) == null) {
            return;
        }
        RecycleExtKt.show(recyclerView);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
        RecyclerView recyclerView;
        FragmentTransportBinding fragmentTransportBinding = get_binding();
        if (fragmentTransportBinding == null || (recyclerView = fragmentTransportBinding.rvTransport) == null) {
            return;
        }
        RecycleExtKt.hide(recyclerView);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }

    @Override // in.etuwa.app.ui.fees.transport.TransportFeeAdapter.CallBack
    public void updateSelected(List<String> sel, List<String> total) {
        MaterialButton materialButton;
        Intrinsics.checkNotNullParameter(sel, "sel");
        Intrinsics.checkNotNullParameter(total, "total");
        System.out.println(total);
        int size = total.size() - 1;
        int i = 0;
        if (size >= 0) {
            int i2 = 0;
            while (true) {
                i += Integer.parseInt(total.get(i2));
                if (i2 == size) {
                    break;
                } else {
                    i2++;
                }
            }
        }
        this.selected = sel;
        this.total = i;
        FragmentTransportBinding fragmentTransportBinding = get_binding();
        TextView textView = fragmentTransportBinding != null ? fragmentTransportBinding.tvTransportTotal : null;
        if (textView != null) {
            textView.setText(String.valueOf(i));
        }
        if (i <= 0) {
            FragmentTransportBinding fragmentTransportBinding2 = get_binding();
            materialButton = fragmentTransportBinding2 != null ? fragmentTransportBinding2.payTransportBtn : null;
            if (materialButton == null) {
                return;
            }
            materialButton.setVisibility(8);
            return;
        }
        FragmentTransportBinding fragmentTransportBinding3 = get_binding();
        materialButton = fragmentTransportBinding3 != null ? fragmentTransportBinding3.payTransportBtn : null;
        if (materialButton == null) {
            return;
        }
        materialButton.setVisibility(0);
    }

    @Override // in.etuwa.app.ui.transport.payment.dialog.TrasportFeePayDialog.FeeDetailListner
    public void dismiss() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // in.etuwa.app.ui.transport.payment.dialog.TrasportFeePayDialog.FeeDetailListner
    public void openPaymentPage(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }
}