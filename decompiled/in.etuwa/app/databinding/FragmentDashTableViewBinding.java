package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import in.etuwa.app.R;
import in.etuwa.app.ui.dashboard.dashtable.DashTableViewViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentDashTableViewBinding extends ViewDataBinding {

    @Bindable
    protected DashTableViewViewModel mDashTableViewViewModel;
    public final RecyclerView rvDashTableView;

    public abstract void setDashTableViewViewModel(DashTableViewViewModel dashTableViewViewModel);

    protected FragmentDashTableViewBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView rvDashTableView) {
        super(_bindingComponent, _root, _localFieldCount);
        this.rvDashTableView = rvDashTableView;
    }

    public DashTableViewViewModel getDashTableViewViewModel() {
        return this.mDashTableViewViewModel;
    }

    public static FragmentDashTableViewBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentDashTableViewBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentDashTableViewBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_dash_table_view, root, attachToRoot, component);
    }

    public static FragmentDashTableViewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentDashTableViewBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentDashTableViewBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_dash_table_view, null, false, component);
    }

    public static FragmentDashTableViewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentDashTableViewBinding bind(View view, Object component) {
        return (FragmentDashTableViewBinding) bind(component, view, R.layout.fragment_dash_table_view);
    }
}