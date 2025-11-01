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
import in.etuwa.app.ui.lab.practical.experiment.ExperimentViewModel;

/* loaded from: classes3.dex */
public abstract class ExperementFragmentBinding extends ViewDataBinding {

    @Bindable
    protected ExperimentViewModel mExperimentViewModel;
    public final RecyclerView rvExperiment;
    public final SwipeRefreshLayout swipeLayout;

    public abstract void setExperimentViewModel(ExperimentViewModel experimentViewModel);

    protected ExperementFragmentBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView rvExperiment, SwipeRefreshLayout swipeLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.rvExperiment = rvExperiment;
        this.swipeLayout = swipeLayout;
    }

    public ExperimentViewModel getExperimentViewModel() {
        return this.mExperimentViewModel;
    }

    public static ExperementFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ExperementFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (ExperementFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.experement_fragment, root, attachToRoot, component);
    }

    public static ExperementFragmentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ExperementFragmentBinding inflate(LayoutInflater inflater, Object component) {
        return (ExperementFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.experement_fragment, null, false, component);
    }

    public static ExperementFragmentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ExperementFragmentBinding bind(View view, Object component) {
        return (ExperementFragmentBinding) bind(component, view, R.layout.experement_fragment);
    }
}