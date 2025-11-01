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
import in.etuwa.app.ui.circular.CircularViewModel;

/* loaded from: classes3.dex */
public abstract class CircularFragmentBinding extends ViewDataBinding {

    @Bindable
    protected CircularViewModel mCircularViewModel;
    public final RecyclerView rvCircular;
    public final SwipeRefreshLayout swipeLayout;

    public abstract void setCircularViewModel(CircularViewModel circularViewModel);

    protected CircularFragmentBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView rvCircular, SwipeRefreshLayout swipeLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.rvCircular = rvCircular;
        this.swipeLayout = swipeLayout;
    }

    public CircularViewModel getCircularViewModel() {
        return this.mCircularViewModel;
    }

    public static CircularFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CircularFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (CircularFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.circular_fragment, root, attachToRoot, component);
    }

    public static CircularFragmentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CircularFragmentBinding inflate(LayoutInflater inflater, Object component) {
        return (CircularFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.circular_fragment, null, false, component);
    }

    public static CircularFragmentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CircularFragmentBinding bind(View view, Object component) {
        return (CircularFragmentBinding) bind(component, view, R.layout.circular_fragment);
    }
}