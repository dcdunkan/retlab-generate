package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import in.etuwa.app.R;
import in.etuwa.app.ui.hostel.mess.orderhistory.OrderHistoryViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentOrderHistoryBinding extends ViewDataBinding {

    @Bindable
    protected OrderHistoryViewModel mOrderHistoryViewModel;
    public final CoordinatorLayout orderHistoryLayout;
    public final RecyclerView rvOrderHistory;
    public final SwipeRefreshLayout swipeLayout;

    public abstract void setOrderHistoryViewModel(OrderHistoryViewModel orderHistoryViewModel);

    protected FragmentOrderHistoryBinding(Object _bindingComponent, View _root, int _localFieldCount, CoordinatorLayout orderHistoryLayout, RecyclerView rvOrderHistory, SwipeRefreshLayout swipeLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.orderHistoryLayout = orderHistoryLayout;
        this.rvOrderHistory = rvOrderHistory;
        this.swipeLayout = swipeLayout;
    }

    public OrderHistoryViewModel getOrderHistoryViewModel() {
        return this.mOrderHistoryViewModel;
    }

    public static FragmentOrderHistoryBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentOrderHistoryBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentOrderHistoryBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_order_history, root, attachToRoot, component);
    }

    public static FragmentOrderHistoryBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentOrderHistoryBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentOrderHistoryBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_order_history, null, false, component);
    }

    public static FragmentOrderHistoryBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentOrderHistoryBinding bind(View view, Object component) {
        return (FragmentOrderHistoryBinding) bind(component, view, R.layout.fragment_order_history);
    }
}