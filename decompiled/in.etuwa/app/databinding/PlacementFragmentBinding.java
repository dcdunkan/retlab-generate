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
import in.etuwa.app.ui.placement.PlacementViewModel;

/* JADX INFO: loaded from: classes3.dex */
public abstract class PlacementFragmentBinding extends ViewDataBinding {

    @Bindable
    protected PlacementViewModel mPlacementViewModel;
    public final RecyclerView rvPlacement;
    public final SwipeRefreshLayout swipeLayout;
    public final TextView toolbar;

    public abstract void setPlacementViewModel(PlacementViewModel placementViewModel);

    protected PlacementFragmentBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView rvPlacement, SwipeRefreshLayout swipeLayout, TextView toolbar) {
        super(_bindingComponent, _root, _localFieldCount);
        this.rvPlacement = rvPlacement;
        this.swipeLayout = swipeLayout;
        this.toolbar = toolbar;
    }

    public PlacementViewModel getPlacementViewModel() {
        return this.mPlacementViewModel;
    }

    public static PlacementFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PlacementFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (PlacementFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.placement_fragment, root, attachToRoot, component);
    }

    public static PlacementFragmentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PlacementFragmentBinding inflate(LayoutInflater inflater, Object component) {
        return (PlacementFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.placement_fragment, null, false, component);
    }

    public static PlacementFragmentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PlacementFragmentBinding bind(View view, Object component) {
        return (PlacementFragmentBinding) bind(component, view, R.layout.placement_fragment);
    }
}