package in.etuwa.app.ui.hostel.mess.orderhistory;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.mess.OrderHistoryResponse;
import in.etuwa.app.databinding.FragmentOrderHistoryBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.hostel.mess.orderhistory.OrderHistoryAdapter;
import in.etuwa.app.utils.RecycleExtKt;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: OrderHistoryFragment.kt */
/* loaded from: classes5.dex */
public final class OrderHistoryFragment extends BaseFragment implements OrderHistoryAdapter.CallBack {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentOrderHistoryBinding _binding;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;
    private MainCallBackListener listener;

    /* renamed from: orderHistoryViewModel$delegate, reason: from kotlin metadata */
    private final Lazy orderHistoryViewModel;

    /* compiled from: OrderHistoryFragment.kt */
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
    public static final OrderHistoryFragment newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public OrderHistoryFragment() {
        final OrderHistoryFragment orderHistoryFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.hostel.mess.orderhistory.OrderHistoryFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(orderHistoryFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.orderHistoryViewModel = FragmentViewModelLazyKt.createViewModelLazy(orderHistoryFragment, Reflection.getOrCreateKotlinClass(OrderHistoryViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.hostel.mess.orderhistory.OrderHistoryFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.hostel.mess.orderhistory.OrderHistoryFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(OrderHistoryViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final OrderHistoryFragment orderHistoryFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<OrderHistoryAdapter>() { // from class: in.etuwa.app.ui.hostel.mess.orderhistory.OrderHistoryFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.hostel.mess.orderhistory.OrderHistoryAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final OrderHistoryAdapter invoke() {
                ComponentCallbacks componentCallbacks = orderHistoryFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(OrderHistoryAdapter.class), b2, b3);
            }
        });
    }

    private final OrderHistoryViewModel getOrderHistoryViewModel() {
        return (OrderHistoryViewModel) this.orderHistoryViewModel.getValue();
    }

    private final OrderHistoryAdapter getAdapter() {
        return (OrderHistoryAdapter) this.adapter.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final FragmentOrderHistoryBinding get_binding() {
        return this._binding;
    }

    /* compiled from: OrderHistoryFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/hostel/mess/orderhistory/OrderHistoryFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/hostel/mess/orderhistory/OrderHistoryFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final OrderHistoryFragment newInstance() {
            return new OrderHistoryFragment();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentOrderHistoryBinding.inflate(inflater, container, false);
        FragmentOrderHistoryBinding fragmentOrderHistoryBinding = get_binding();
        if (fragmentOrderHistoryBinding != null) {
            fragmentOrderHistoryBinding.setOrderHistoryViewModel(getOrderHistoryViewModel());
        }
        FragmentOrderHistoryBinding fragmentOrderHistoryBinding2 = get_binding();
        if (fragmentOrderHistoryBinding2 != null) {
            fragmentOrderHistoryBinding2.setLifecycleOwner(this);
        }
        FragmentOrderHistoryBinding fragmentOrderHistoryBinding3 = get_binding();
        if (fragmentOrderHistoryBinding3 != null) {
            return fragmentOrderHistoryBinding3.getRoot();
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
        SwipeRefreshLayout swipeRefreshLayout;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle("Mess Order History");
        }
        hideBaseView();
        FragmentOrderHistoryBinding fragmentOrderHistoryBinding = get_binding();
        RecyclerView recyclerView = fragmentOrderHistoryBinding != null ? fragmentOrderHistoryBinding.rvOrderHistory : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        getAdapter().setCallBack(this);
        listenResponse();
        listenCancelResponce();
        getOrderHistoryViewModel().getMessData();
        FragmentOrderHistoryBinding fragmentOrderHistoryBinding2 = get_binding();
        if (fragmentOrderHistoryBinding2 == null || (swipeRefreshLayout = fragmentOrderHistoryBinding2.swipeLayout) == null) {
            return;
        }
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: in.etuwa.app.ui.hostel.mess.orderhistory.OrderHistoryFragment$$ExternalSyntheticLambda2
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                OrderHistoryFragment.setUp$lambda$0(OrderHistoryFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$0(OrderHistoryFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getOrderHistoryViewModel().getMessData();
        FragmentOrderHistoryBinding fragmentOrderHistoryBinding = this$0.get_binding();
        SwipeRefreshLayout swipeRefreshLayout = fragmentOrderHistoryBinding != null ? fragmentOrderHistoryBinding.swipeLayout : null;
        if (swipeRefreshLayout == null) {
            return;
        }
        swipeRefreshLayout.setRefreshing(false);
    }

    private final void listenResponse() {
        getOrderHistoryViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.hostel.mess.orderhistory.OrderHistoryFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                OrderHistoryFragment.listenResponse$lambda$2(OrderHistoryFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$2(OrderHistoryFragment this$0, Resource resource) {
        RecyclerView rvOrderHistory;
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            OrderHistoryResponse orderHistoryResponse = (OrderHistoryResponse) resource.getData();
            if (orderHistoryResponse != null) {
                try {
                    this$0.showBaseView();
                    this$0.getAdapter().addItems(orderHistoryResponse.getData());
                    Unit unit = Unit.INSTANCE;
                    return;
                } catch (NullPointerException unused) {
                    FragmentOrderHistoryBinding fragmentOrderHistoryBinding = this$0.get_binding();
                    if (fragmentOrderHistoryBinding == null || (rvOrderHistory = fragmentOrderHistoryBinding.rvOrderHistory) == null) {
                        return;
                    }
                    Intrinsics.checkNotNullExpressionValue(rvOrderHistory, "rvOrderHistory");
                    ToastExtKt.showInfoToast(rvOrderHistory, "No Data");
                    Unit unit2 = Unit.INSTANCE;
                    return;
                }
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
        FragmentOrderHistoryBinding fragmentOrderHistoryBinding2 = this$0.get_binding();
        if (fragmentOrderHistoryBinding2 == null || (recyclerView = fragmentOrderHistoryBinding2.rvOrderHistory) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(recyclerView, message);
    }

    private final void listenCancelResponce() {
        getOrderHistoryViewModel().getCancelResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.hostel.mess.orderhistory.OrderHistoryFragment$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                OrderHistoryFragment.listenCancelResponce$lambda$4(OrderHistoryFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenCancelResponce$lambda$4(OrderHistoryFragment this$0, Resource resource) {
        RecyclerView rvOrderHistory;
        RecyclerView rvOrderHistory2;
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
            } else {
                if (i != 4) {
                    return;
                }
                this$0.hideProgress();
                this$0.showBaseView();
                FragmentOrderHistoryBinding fragmentOrderHistoryBinding = this$0.get_binding();
                if (fragmentOrderHistoryBinding == null || (recyclerView = fragmentOrderHistoryBinding.rvOrderHistory) == null) {
                    return;
                }
                ToastExtKt.showErrorToast(recyclerView, "Sorry!!! You cannot cancel the order, Timeout..");
                return;
            }
        }
        this$0.hideProgress();
        SuccessResponse successResponse = (SuccessResponse) resource.getData();
        if (successResponse != null) {
            this$0.showBaseView();
            if (successResponse.getSuccess()) {
                FragmentOrderHistoryBinding fragmentOrderHistoryBinding2 = this$0.get_binding();
                if (fragmentOrderHistoryBinding2 != null && (rvOrderHistory2 = fragmentOrderHistoryBinding2.rvOrderHistory) != null) {
                    Intrinsics.checkNotNullExpressionValue(rvOrderHistory2, "rvOrderHistory");
                    ToastExtKt.showSuccessToast(rvOrderHistory2, successResponse.getMessage());
                }
                this$0.getOrderHistoryViewModel().getMessData();
                return;
            }
            FragmentOrderHistoryBinding fragmentOrderHistoryBinding3 = this$0.get_binding();
            if (fragmentOrderHistoryBinding3 == null || (rvOrderHistory = fragmentOrderHistoryBinding3.rvOrderHistory) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(rvOrderHistory, "rvOrderHistory");
            ToastExtKt.showSuccessToast(rvOrderHistory, successResponse.getError());
        }
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
        RecyclerView recyclerView;
        FragmentOrderHistoryBinding fragmentOrderHistoryBinding = get_binding();
        if (fragmentOrderHistoryBinding == null || (recyclerView = fragmentOrderHistoryBinding.rvOrderHistory) == null) {
            return;
        }
        RecycleExtKt.show(recyclerView);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
        RecyclerView recyclerView;
        FragmentOrderHistoryBinding fragmentOrderHistoryBinding = get_binding();
        if (fragmentOrderHistoryBinding == null || (recyclerView = fragmentOrderHistoryBinding.rvOrderHistory) == null) {
            return;
        }
        RecycleExtKt.hide(recyclerView);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        getAdapter().setCallBack(null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }

    @Override // in.etuwa.app.ui.hostel.mess.orderhistory.OrderHistoryAdapter.CallBack
    public void cancelBtnClicked(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        getOrderHistoryViewModel().getCancelOrder(id);
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