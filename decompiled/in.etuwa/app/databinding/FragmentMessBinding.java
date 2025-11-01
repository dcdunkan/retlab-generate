package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import in.etuwa.app.R;
import in.etuwa.app.ui.hostel.mess.MessViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentMessBinding extends ViewDataBinding {
    public final TextView bookNowBtn;

    @Bindable
    protected MessViewModel mMessViewModel;
    public final CoordinatorLayout messLayout;
    public final TextView orderHistoryBtn;
    public final RecyclerView rvMess;
    public final SwipeRefreshLayout swipeLayout;

    public abstract void setMessViewModel(MessViewModel messViewModel);

    protected FragmentMessBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView bookNowBtn, CoordinatorLayout messLayout, TextView orderHistoryBtn, RecyclerView rvMess, SwipeRefreshLayout swipeLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.bookNowBtn = bookNowBtn;
        this.messLayout = messLayout;
        this.orderHistoryBtn = orderHistoryBtn;
        this.rvMess = rvMess;
        this.swipeLayout = swipeLayout;
    }

    public MessViewModel getMessViewModel() {
        return this.mMessViewModel;
    }

    public static FragmentMessBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentMessBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentMessBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_mess, root, attachToRoot, component);
    }

    public static FragmentMessBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentMessBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentMessBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_mess, null, false, component);
    }

    public static FragmentMessBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentMessBinding bind(View view, Object component) {
        return (FragmentMessBinding) bind(component, view, R.layout.fragment_mess);
    }
}