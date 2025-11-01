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
import in.etuwa.app.ui.lab.labdue.LabDueViewModel;

/* loaded from: classes3.dex */
public abstract class LabDueFragmentBinding extends ViewDataBinding {

    @Bindable
    protected LabDueViewModel mLabDueViewModel;
    public final RecyclerView rvLabDue;
    public final SwipeRefreshLayout swipeLayout;

    public abstract void setLabDueViewModel(LabDueViewModel labDueViewModel);

    protected LabDueFragmentBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView rvLabDue, SwipeRefreshLayout swipeLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.rvLabDue = rvLabDue;
        this.swipeLayout = swipeLayout;
    }

    public LabDueViewModel getLabDueViewModel() {
        return this.mLabDueViewModel;
    }

    public static LabDueFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LabDueFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (LabDueFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.lab_due_fragment, root, attachToRoot, component);
    }

    public static LabDueFragmentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LabDueFragmentBinding inflate(LayoutInflater inflater, Object component) {
        return (LabDueFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.lab_due_fragment, null, false, component);
    }

    public static LabDueFragmentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LabDueFragmentBinding bind(View view, Object component) {
        return (LabDueFragmentBinding) bind(component, view, R.layout.lab_due_fragment);
    }
}