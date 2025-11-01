package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import in.etuwa.app.R;
import in.etuwa.app.ui.transport.history.TransportHistoryViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentTransportHistoryBinding extends ViewDataBinding {

    @Bindable
    protected TransportHistoryViewModel mTransportHistoryViewModel;
    public final RecyclerView rvTransportFeeHistory;

    public abstract void setTransportHistoryViewModel(TransportHistoryViewModel transportHistoryViewModel);

    protected FragmentTransportHistoryBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView rvTransportFeeHistory) {
        super(_bindingComponent, _root, _localFieldCount);
        this.rvTransportFeeHistory = rvTransportFeeHistory;
    }

    public TransportHistoryViewModel getTransportHistoryViewModel() {
        return this.mTransportHistoryViewModel;
    }

    public static FragmentTransportHistoryBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentTransportHistoryBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentTransportHistoryBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_transport_history, root, attachToRoot, component);
    }

    public static FragmentTransportHistoryBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentTransportHistoryBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentTransportHistoryBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_transport_history, null, false, component);
    }

    public static FragmentTransportHistoryBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentTransportHistoryBinding bind(View view, Object component) {
        return (FragmentTransportHistoryBinding) bind(component, view, R.layout.fragment_transport_history);
    }
}