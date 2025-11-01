package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import in.etuwa.app.R;
import in.etuwa.app.ui.stationary.booking.orderpage.OrderPageViewModel;

/* loaded from: classes3.dex */
public abstract class DialogStationaryPayBinding extends ViewDataBinding {
    public final ImageView addBtn;
    public final EditText etQuantity;

    @Bindable
    protected OrderPageViewModel mOrderPageViewModel;
    public final TextView payBtn;
    public final ImageView removeBtn;
    public final TextView tvProductName;
    public final TextView tvTotalPrice;
    public final TextView tvUnitPrice;

    public abstract void setOrderPageViewModel(OrderPageViewModel orderPageViewModel);

    protected DialogStationaryPayBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView addBtn, EditText etQuantity, TextView payBtn, ImageView removeBtn, TextView tvProductName, TextView tvTotalPrice, TextView tvUnitPrice) {
        super(_bindingComponent, _root, _localFieldCount);
        this.addBtn = addBtn;
        this.etQuantity = etQuantity;
        this.payBtn = payBtn;
        this.removeBtn = removeBtn;
        this.tvProductName = tvProductName;
        this.tvTotalPrice = tvTotalPrice;
        this.tvUnitPrice = tvUnitPrice;
    }

    public OrderPageViewModel getOrderPageViewModel() {
        return this.mOrderPageViewModel;
    }

    public static DialogStationaryPayBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogStationaryPayBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (DialogStationaryPayBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_stationary_pay, root, attachToRoot, component);
    }

    public static DialogStationaryPayBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogStationaryPayBinding inflate(LayoutInflater inflater, Object component) {
        return (DialogStationaryPayBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_stationary_pay, null, false, component);
    }

    public static DialogStationaryPayBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogStationaryPayBinding bind(View view, Object component) {
        return (DialogStationaryPayBinding) bind(component, view, R.layout.dialog_stationary_pay);
    }
}