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
import in.etuwa.app.ui.profile.positionheld.PositionHeldViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentPositionHeldBinding extends ViewDataBinding {
    public final TextView addBtn;

    @Bindable
    protected PositionHeldViewModel mPositionHeldViewModel;
    public final RecyclerView rvPosition;
    public final SwipeRefreshLayout swipeLayout;

    public abstract void setPositionHeldViewModel(PositionHeldViewModel positionHeldViewModel);

    protected FragmentPositionHeldBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView addBtn, RecyclerView rvPosition, SwipeRefreshLayout swipeLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.addBtn = addBtn;
        this.rvPosition = rvPosition;
        this.swipeLayout = swipeLayout;
    }

    public PositionHeldViewModel getPositionHeldViewModel() {
        return this.mPositionHeldViewModel;
    }

    public static FragmentPositionHeldBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentPositionHeldBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentPositionHeldBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_position_held, root, attachToRoot, component);
    }

    public static FragmentPositionHeldBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentPositionHeldBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentPositionHeldBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_position_held, null, false, component);
    }

    public static FragmentPositionHeldBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentPositionHeldBinding bind(View view, Object component) {
        return (FragmentPositionHeldBinding) bind(component, view, R.layout.fragment_position_held);
    }
}