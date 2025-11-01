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
import in.etuwa.app.ui.due.DueViewModel;

/* loaded from: classes3.dex */
public abstract class DueFragmentBinding extends ViewDataBinding {

    @Bindable
    protected DueViewModel mDueViewModel;
    public final RecyclerView rvDue;
    public final SwipeRefreshLayout swipeLayout;

    public abstract void setDueViewModel(DueViewModel dueViewModel);

    protected DueFragmentBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView rvDue, SwipeRefreshLayout swipeLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.rvDue = rvDue;
        this.swipeLayout = swipeLayout;
    }

    public DueViewModel getDueViewModel() {
        return this.mDueViewModel;
    }

    public static DueFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DueFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (DueFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.due_fragment, root, attachToRoot, component);
    }

    public static DueFragmentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DueFragmentBinding inflate(LayoutInflater inflater, Object component) {
        return (DueFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.due_fragment, null, false, component);
    }

    public static DueFragmentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DueFragmentBinding bind(View view, Object component) {
        return (DueFragmentBinding) bind(component, view, R.layout.due_fragment);
    }
}