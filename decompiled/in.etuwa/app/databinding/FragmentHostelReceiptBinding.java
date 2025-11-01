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
import in.etuwa.app.ui.hostel.tkmhostel.receipt.TkmReceiptViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentHostelReceiptBinding extends ViewDataBinding {

    @Bindable
    protected TkmReceiptViewModel mTkmReceiptViewModel;
    public final RecyclerView rvFeeReceipt;
    public final SwipeRefreshLayout swipeLayout;

    public abstract void setTkmReceiptViewModel(TkmReceiptViewModel tkmReceiptViewModel);

    protected FragmentHostelReceiptBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView rvFeeReceipt, SwipeRefreshLayout swipeLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.rvFeeReceipt = rvFeeReceipt;
        this.swipeLayout = swipeLayout;
    }

    public TkmReceiptViewModel getTkmReceiptViewModel() {
        return this.mTkmReceiptViewModel;
    }

    public static FragmentHostelReceiptBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentHostelReceiptBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentHostelReceiptBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_hostel_receipt, root, attachToRoot, component);
    }

    public static FragmentHostelReceiptBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentHostelReceiptBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentHostelReceiptBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_hostel_receipt, null, false, component);
    }

    public static FragmentHostelReceiptBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentHostelReceiptBinding bind(View view, Object component) {
        return (FragmentHostelReceiptBinding) bind(component, view, R.layout.fragment_hostel_receipt);
    }
}