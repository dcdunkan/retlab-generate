package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import in.etuwa.app.R;
import in.etuwa.app.ui.semregistration.list.SemRegisterListViewModel;

/* loaded from: classes3.dex */
public abstract class SemRegisterListFragmentBinding extends ViewDataBinding {
    public final FloatingActionButton fabAddSemReg;

    @Bindable
    protected SemRegisterListViewModel mSemRegisterListViewModel;
    public final RecyclerView rvRegList;
    public final SwipeRefreshLayout swipeLayout;

    public abstract void setSemRegisterListViewModel(SemRegisterListViewModel semRegisterListViewModel);

    protected SemRegisterListFragmentBinding(Object _bindingComponent, View _root, int _localFieldCount, FloatingActionButton fabAddSemReg, RecyclerView rvRegList, SwipeRefreshLayout swipeLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.fabAddSemReg = fabAddSemReg;
        this.rvRegList = rvRegList;
        this.swipeLayout = swipeLayout;
    }

    public SemRegisterListViewModel getSemRegisterListViewModel() {
        return this.mSemRegisterListViewModel;
    }

    public static SemRegisterListFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SemRegisterListFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (SemRegisterListFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.sem_register_list_fragment, root, attachToRoot, component);
    }

    public static SemRegisterListFragmentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SemRegisterListFragmentBinding inflate(LayoutInflater inflater, Object component) {
        return (SemRegisterListFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.sem_register_list_fragment, null, false, component);
    }

    public static SemRegisterListFragmentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SemRegisterListFragmentBinding bind(View view, Object component) {
        return (SemRegisterListFragmentBinding) bind(component, view, R.layout.sem_register_list_fragment);
    }
}