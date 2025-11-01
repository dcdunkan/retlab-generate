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
import in.etuwa.app.ui.fees.transport.receipt.TransportReceiptViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentTransportReceiptBinding extends ViewDataBinding {

    @Bindable
    protected TransportReceiptViewModel mReceiptViewModel;
    public final RecyclerView rvFeeReceipt;
    public final SwipeRefreshLayout swipeLayout;

    public abstract void setReceiptViewModel(TransportReceiptViewModel receiptViewModel);

    protected FragmentTransportReceiptBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView rvFeeReceipt, SwipeRefreshLayout swipeLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.rvFeeReceipt = rvFeeReceipt;
        this.swipeLayout = swipeLayout;
    }

    public TransportReceiptViewModel getReceiptViewModel() {
        return this.mReceiptViewModel;
    }

    public static FragmentTransportReceiptBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentTransportReceiptBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentTransportReceiptBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_transport_receipt, root, attachToRoot, component);
    }

    public static FragmentTransportReceiptBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentTransportReceiptBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentTransportReceiptBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_transport_receipt, null, false, component);
    }

    public static FragmentTransportReceiptBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentTransportReceiptBinding bind(View view, Object component) {
        return (FragmentTransportReceiptBinding) bind(component, view, R.layout.fragment_transport_receipt);
    }
}