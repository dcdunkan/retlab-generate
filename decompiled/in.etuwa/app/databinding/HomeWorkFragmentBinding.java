package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import in.etuwa.app.R;
import in.etuwa.app.ui.homework.HomeWorkViewModel;

/* loaded from: classes3.dex */
public abstract class HomeWorkFragmentBinding extends ViewDataBinding {
    public final TextView coveredHome;

    @Bindable
    protected HomeWorkViewModel mHomeWorkViewModel;
    public final TextView notCoveredHome;
    public final RecyclerView rvHomeWork;
    public final SwipeRefreshLayout swipeLayout;

    public abstract void setHomeWorkViewModel(HomeWorkViewModel homeWorkViewModel);

    protected HomeWorkFragmentBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView coveredHome, TextView notCoveredHome, RecyclerView rvHomeWork, SwipeRefreshLayout swipeLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.coveredHome = coveredHome;
        this.notCoveredHome = notCoveredHome;
        this.rvHomeWork = rvHomeWork;
        this.swipeLayout = swipeLayout;
    }

    public HomeWorkViewModel getHomeWorkViewModel() {
        return this.mHomeWorkViewModel;
    }

    public static HomeWorkFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HomeWorkFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (HomeWorkFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.home_work_fragment, root, attachToRoot, component);
    }

    public static HomeWorkFragmentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HomeWorkFragmentBinding inflate(LayoutInflater inflater, Object component) {
        return (HomeWorkFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.home_work_fragment, null, false, component);
    }

    public static HomeWorkFragmentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HomeWorkFragmentBinding bind(View view, Object component) {
        return (HomeWorkFragmentBinding) bind(component, view, R.layout.home_work_fragment);
    }
}