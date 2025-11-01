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
import in.etuwa.app.ui.centralizedinfo.CentralizedInfoViewModel;

/* loaded from: classes3.dex */
public abstract class CentralizedInfoFragmentBinding extends ViewDataBinding {

    @Bindable
    protected CentralizedInfoViewModel mCentralizedInfoViewModel;
    public final RecyclerView rvInfo;
    public final SwipeRefreshLayout swipeLayout;

    public abstract void setCentralizedInfoViewModel(CentralizedInfoViewModel centralizedInfoViewModel);

    protected CentralizedInfoFragmentBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView rvInfo, SwipeRefreshLayout swipeLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.rvInfo = rvInfo;
        this.swipeLayout = swipeLayout;
    }

    public CentralizedInfoViewModel getCentralizedInfoViewModel() {
        return this.mCentralizedInfoViewModel;
    }

    public static CentralizedInfoFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CentralizedInfoFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (CentralizedInfoFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.centralized_info_fragment, root, attachToRoot, component);
    }

    public static CentralizedInfoFragmentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CentralizedInfoFragmentBinding inflate(LayoutInflater inflater, Object component) {
        return (CentralizedInfoFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.centralized_info_fragment, null, false, component);
    }

    public static CentralizedInfoFragmentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CentralizedInfoFragmentBinding bind(View view, Object component) {
        return (CentralizedInfoFragmentBinding) bind(component, view, R.layout.centralized_info_fragment);
    }
}