package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import in.etuwa.app.R;
import in.etuwa.app.ui.activitypoint.ActivityPointViewModel;

/* loaded from: classes3.dex */
public abstract class ActivityPointFragmentBinding extends ViewDataBinding {

    @Bindable
    protected ActivityPointViewModel mActivityPointViewModel;
    public final Button manageBtn;
    public final RecyclerView rvActivityPoint;
    public final SwipeRefreshLayout swipeLayout;
    public final TextView totalPoint;

    public abstract void setActivityPointViewModel(ActivityPointViewModel activityPointViewModel);

    protected ActivityPointFragmentBinding(Object _bindingComponent, View _root, int _localFieldCount, Button manageBtn, RecyclerView rvActivityPoint, SwipeRefreshLayout swipeLayout, TextView totalPoint) {
        super(_bindingComponent, _root, _localFieldCount);
        this.manageBtn = manageBtn;
        this.rvActivityPoint = rvActivityPoint;
        this.swipeLayout = swipeLayout;
        this.totalPoint = totalPoint;
    }

    public ActivityPointViewModel getActivityPointViewModel() {
        return this.mActivityPointViewModel;
    }

    public static ActivityPointFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityPointFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (ActivityPointFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.activity_point_fragment, root, attachToRoot, component);
    }

    public static ActivityPointFragmentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityPointFragmentBinding inflate(LayoutInflater inflater, Object component) {
        return (ActivityPointFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.activity_point_fragment, null, false, component);
    }

    public static ActivityPointFragmentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityPointFragmentBinding bind(View view, Object component) {
        return (ActivityPointFragmentBinding) bind(component, view, R.layout.activity_point_fragment);
    }
}