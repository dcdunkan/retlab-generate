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
import in.etuwa.app.ui.subject.co.CoViewModel;

/* loaded from: classes3.dex */
public abstract class CoFragmentBinding extends ViewDataBinding {

    @Bindable
    protected CoViewModel mCoViewModel;
    public final RecyclerView rvCo;
    public final SwipeRefreshLayout swipeLayout;

    public abstract void setCoViewModel(CoViewModel coViewModel);

    protected CoFragmentBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView rvCo, SwipeRefreshLayout swipeLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.rvCo = rvCo;
        this.swipeLayout = swipeLayout;
    }

    public CoViewModel getCoViewModel() {
        return this.mCoViewModel;
    }

    public static CoFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CoFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (CoFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.co_fragment, root, attachToRoot, component);
    }

    public static CoFragmentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CoFragmentBinding inflate(LayoutInflater inflater, Object component) {
        return (CoFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.co_fragment, null, false, component);
    }

    public static CoFragmentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CoFragmentBinding bind(View view, Object component) {
        return (CoFragmentBinding) bind(component, view, R.layout.co_fragment);
    }
}