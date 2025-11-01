package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import in.etuwa.app.R;
import in.etuwa.app.ui.leavemanagement.LeaveManagementViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentLeaveManagementBinding extends ViewDataBinding {
    public final Button applyBtn;

    @Bindable
    protected LeaveManagementViewModel mLeaveManagementViewModel;
    public final RecyclerView rvLeave;
    public final SwipeRefreshLayout swipeLayout;

    public abstract void setLeaveManagementViewModel(LeaveManagementViewModel leaveManagementViewModel);

    protected FragmentLeaveManagementBinding(Object _bindingComponent, View _root, int _localFieldCount, Button applyBtn, RecyclerView rvLeave, SwipeRefreshLayout swipeLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.applyBtn = applyBtn;
        this.rvLeave = rvLeave;
        this.swipeLayout = swipeLayout;
    }

    public LeaveManagementViewModel getLeaveManagementViewModel() {
        return this.mLeaveManagementViewModel;
    }

    public static FragmentLeaveManagementBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentLeaveManagementBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentLeaveManagementBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_leave_management, root, attachToRoot, component);
    }

    public static FragmentLeaveManagementBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentLeaveManagementBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentLeaveManagementBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_leave_management, null, false, component);
    }

    public static FragmentLeaveManagementBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentLeaveManagementBinding bind(View view, Object component) {
        return (FragmentLeaveManagementBinding) bind(component, view, R.layout.fragment_leave_management);
    }
}