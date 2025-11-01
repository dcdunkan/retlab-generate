package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import in.etuwa.app.R;
import in.etuwa.app.ui.transport.registration.view.TransportRegHistoryViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentTransportRegHistoryBinding extends ViewDataBinding {
    public final FloatingActionButton fabAddTransReg;

    @Bindable
    protected TransportRegHistoryViewModel mTransportRegHistoryViewModel;
    public final RecyclerView rvRegHistoryTransport;
    public final SwipeRefreshLayout swipeLayout;

    public abstract void setTransportRegHistoryViewModel(TransportRegHistoryViewModel transportRegHistoryViewModel);

    protected FragmentTransportRegHistoryBinding(Object _bindingComponent, View _root, int _localFieldCount, FloatingActionButton fabAddTransReg, RecyclerView rvRegHistoryTransport, SwipeRefreshLayout swipeLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.fabAddTransReg = fabAddTransReg;
        this.rvRegHistoryTransport = rvRegHistoryTransport;
        this.swipeLayout = swipeLayout;
    }

    public TransportRegHistoryViewModel getTransportRegHistoryViewModel() {
        return this.mTransportRegHistoryViewModel;
    }

    public static FragmentTransportRegHistoryBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentTransportRegHistoryBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentTransportRegHistoryBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_transport_reg_history, root, attachToRoot, component);
    }

    public static FragmentTransportRegHistoryBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentTransportRegHistoryBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentTransportRegHistoryBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_transport_reg_history, null, false, component);
    }

    public static FragmentTransportRegHistoryBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentTransportRegHistoryBinding bind(View view, Object component) {
        return (FragmentTransportRegHistoryBinding) bind(component, view, R.layout.fragment_transport_reg_history);
    }
}