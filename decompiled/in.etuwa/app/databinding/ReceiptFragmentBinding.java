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
import in.etuwa.app.ui.fees.receipt.ReceiptViewModel;

/* loaded from: classes3.dex */
public abstract class ReceiptFragmentBinding extends ViewDataBinding {

    @Bindable
    protected ReceiptViewModel mReceiptViewModel;
    public final RecyclerView rvFeeReceipt;
    public final SwipeRefreshLayout swipeLayout;

    public abstract void setReceiptViewModel(ReceiptViewModel receiptViewModel);

    protected ReceiptFragmentBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView rvFeeReceipt, SwipeRefreshLayout swipeLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.rvFeeReceipt = rvFeeReceipt;
        this.swipeLayout = swipeLayout;
    }

    public ReceiptViewModel getReceiptViewModel() {
        return this.mReceiptViewModel;
    }

    public static ReceiptFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ReceiptFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (ReceiptFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.receipt_fragment, root, attachToRoot, component);
    }

    public static ReceiptFragmentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ReceiptFragmentBinding inflate(LayoutInflater inflater, Object component) {
        return (ReceiptFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.receipt_fragment, null, false, component);
    }

    public static ReceiptFragmentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ReceiptFragmentBinding bind(View view, Object component) {
        return (ReceiptFragmentBinding) bind(component, view, R.layout.receipt_fragment);
    }
}