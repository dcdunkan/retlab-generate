package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import in.etuwa.app.R;
import in.etuwa.app.ui.transport.payment.TransportFeeViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentTransportFeeBinding extends ViewDataBinding {

    @Bindable
    protected TransportFeeViewModel mTransportFeeViewModel;
    public final RecyclerView rvTransportFee;

    public abstract void setTransportFeeViewModel(TransportFeeViewModel transportFeeViewModel);

    protected FragmentTransportFeeBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView rvTransportFee) {
        super(_bindingComponent, _root, _localFieldCount);
        this.rvTransportFee = rvTransportFee;
    }

    public TransportFeeViewModel getTransportFeeViewModel() {
        return this.mTransportFeeViewModel;
    }

    public static FragmentTransportFeeBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentTransportFeeBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentTransportFeeBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_transport_fee, root, attachToRoot, component);
    }

    public static FragmentTransportFeeBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentTransportFeeBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentTransportFeeBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_transport_fee, null, false, component);
    }

    public static FragmentTransportFeeBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentTransportFeeBinding bind(View view, Object component) {
        return (FragmentTransportFeeBinding) bind(component, view, R.layout.fragment_transport_fee);
    }
}