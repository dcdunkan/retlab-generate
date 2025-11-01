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
import in.etuwa.app.ui.lab.equipment.LabListViewModel;

/* loaded from: classes3.dex */
public abstract class LabListFragmentBinding extends ViewDataBinding {

    @Bindable
    protected LabListViewModel mLabListViewModel;
    public final RecyclerView rvLabList;
    public final SwipeRefreshLayout swipeLayout;

    public abstract void setLabListViewModel(LabListViewModel labListViewModel);

    protected LabListFragmentBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView rvLabList, SwipeRefreshLayout swipeLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.rvLabList = rvLabList;
        this.swipeLayout = swipeLayout;
    }

    public LabListViewModel getLabListViewModel() {
        return this.mLabListViewModel;
    }

    public static LabListFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LabListFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (LabListFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.lab_list_fragment, root, attachToRoot, component);
    }

    public static LabListFragmentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LabListFragmentBinding inflate(LayoutInflater inflater, Object component) {
        return (LabListFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.lab_list_fragment, null, false, component);
    }

    public static LabListFragmentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LabListFragmentBinding bind(View view, Object component) {
        return (LabListFragmentBinding) bind(component, view, R.layout.lab_list_fragment);
    }
}