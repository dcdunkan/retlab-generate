package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import in.etuwa.app.R;
import in.etuwa.app.ui.store.storeview.StoreViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentStoreBinding extends ViewDataBinding {

    @Bindable
    protected StoreViewModel mStoreViewModel;
    public final TextView payStoreBtn;
    public final RecyclerView rvStore;
    public final Spinner spinnerCategory;
    public final SwipeRefreshLayout swipeLayout;
    public final TextView tvStoreTotal;

    public abstract void setStoreViewModel(StoreViewModel storeViewModel);

    protected FragmentStoreBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView payStoreBtn, RecyclerView rvStore, Spinner spinnerCategory, SwipeRefreshLayout swipeLayout, TextView tvStoreTotal) {
        super(_bindingComponent, _root, _localFieldCount);
        this.payStoreBtn = payStoreBtn;
        this.rvStore = rvStore;
        this.spinnerCategory = spinnerCategory;
        this.swipeLayout = swipeLayout;
        this.tvStoreTotal = tvStoreTotal;
    }

    public StoreViewModel getStoreViewModel() {
        return this.mStoreViewModel;
    }

    public static FragmentStoreBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentStoreBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentStoreBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_store, root, attachToRoot, component);
    }

    public static FragmentStoreBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentStoreBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentStoreBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_store, null, false, component);
    }

    public static FragmentStoreBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentStoreBinding bind(View view, Object component) {
        return (FragmentStoreBinding) bind(component, view, R.layout.fragment_store);
    }
}