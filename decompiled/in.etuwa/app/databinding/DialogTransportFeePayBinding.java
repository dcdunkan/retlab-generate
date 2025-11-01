package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import in.etuwa.app.R;
import in.etuwa.app.ui.transport.payment.dialog.TrasportFeePayViewModel;

/* loaded from: classes3.dex */
public abstract class DialogTransportFeePayBinding extends ViewDataBinding {
    public final LinearLayout dueLayout;

    @Bindable
    protected TrasportFeePayViewModel mTrasportFeePayViewModel;
    public final TextView payNowBtn;
    public final TextView tvAmount;
    public final TextView tvFine;
    public final TextView tvTotal;

    public abstract void setTrasportFeePayViewModel(TrasportFeePayViewModel trasportFeePayViewModel);

    protected DialogTransportFeePayBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout dueLayout, TextView payNowBtn, TextView tvAmount, TextView tvFine, TextView tvTotal) {
        super(_bindingComponent, _root, _localFieldCount);
        this.dueLayout = dueLayout;
        this.payNowBtn = payNowBtn;
        this.tvAmount = tvAmount;
        this.tvFine = tvFine;
        this.tvTotal = tvTotal;
    }

    public TrasportFeePayViewModel getTrasportFeePayViewModel() {
        return this.mTrasportFeePayViewModel;
    }

    public static DialogTransportFeePayBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogTransportFeePayBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (DialogTransportFeePayBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_transport_fee_pay, root, attachToRoot, component);
    }

    public static DialogTransportFeePayBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogTransportFeePayBinding inflate(LayoutInflater inflater, Object component) {
        return (DialogTransportFeePayBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_transport_fee_pay, null, false, component);
    }

    public static DialogTransportFeePayBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogTransportFeePayBinding bind(View view, Object component) {
        return (DialogTransportFeePayBinding) bind(component, view, R.layout.dialog_transport_fee_pay);
    }
}