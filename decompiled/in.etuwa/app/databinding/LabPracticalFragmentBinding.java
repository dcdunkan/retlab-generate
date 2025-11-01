package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import in.etuwa.app.R;
import in.etuwa.app.ui.lab.practical.LabPracticalViewModel;

/* loaded from: classes3.dex */
public abstract class LabPracticalFragmentBinding extends ViewDataBinding {

    @Bindable
    protected LabPracticalViewModel mLabPracticalViewModel;
    public final RecyclerView rvPractical;
    public final Spinner spinnerSem;
    public final SwipeRefreshLayout swipeLayout;

    public abstract void setLabPracticalViewModel(LabPracticalViewModel labPracticalViewModel);

    protected LabPracticalFragmentBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView rvPractical, Spinner spinnerSem, SwipeRefreshLayout swipeLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.rvPractical = rvPractical;
        this.spinnerSem = spinnerSem;
        this.swipeLayout = swipeLayout;
    }

    public LabPracticalViewModel getLabPracticalViewModel() {
        return this.mLabPracticalViewModel;
    }

    public static LabPracticalFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LabPracticalFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (LabPracticalFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.lab_practical_fragment, root, attachToRoot, component);
    }

    public static LabPracticalFragmentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LabPracticalFragmentBinding inflate(LayoutInflater inflater, Object component) {
        return (LabPracticalFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.lab_practical_fragment, null, false, component);
    }

    public static LabPracticalFragmentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LabPracticalFragmentBinding bind(View view, Object component) {
        return (LabPracticalFragmentBinding) bind(component, view, R.layout.lab_practical_fragment);
    }
}