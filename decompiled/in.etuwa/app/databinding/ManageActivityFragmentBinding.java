package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import in.etuwa.app.R;
import in.etuwa.app.ui.activitypoint.manage.ManageActivityViewModel;

/* loaded from: classes3.dex */
public abstract class ManageActivityFragmentBinding extends ViewDataBinding {

    @Bindable
    protected ManageActivityViewModel mManageActivityViewModel;
    public final RecyclerView rvManageActivityPoint;
    public final SwipeRefreshLayout swipeLayout;

    public abstract void setManageActivityViewModel(ManageActivityViewModel manageActivityViewModel);

    protected ManageActivityFragmentBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView rvManageActivityPoint, SwipeRefreshLayout swipeLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.rvManageActivityPoint = rvManageActivityPoint;
        this.swipeLayout = swipeLayout;
    }

    public ManageActivityViewModel getManageActivityViewModel() {
        return this.mManageActivityViewModel;
    }

    public static ManageActivityFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ManageActivityFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (ManageActivityFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.manage_activity_fragment, root, attachToRoot, component);
    }

    public static ManageActivityFragmentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ManageActivityFragmentBinding inflate(LayoutInflater inflater, Object component) {
        return (ManageActivityFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.manage_activity_fragment, null, false, component);
    }

    public static ManageActivityFragmentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ManageActivityFragmentBinding bind(View view, Object component) {
        return (ManageActivityFragmentBinding) bind(component, view, R.layout.manage_activity_fragment);
    }
}