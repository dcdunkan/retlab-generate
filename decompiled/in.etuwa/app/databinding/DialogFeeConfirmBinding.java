package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import in.etuwa.app.R;
import in.etuwa.app.ui.feenewengineer.payment.feeconfirmdialog.FeeConfirmViewModel;

/* loaded from: classes3.dex */
public abstract class DialogFeeConfirmBinding extends ViewDataBinding {
    public final TextView fine;

    @Bindable
    protected FeeConfirmViewModel mFeeConfirmViewModel;
    public final TextView payConfirmBtn;
    public final TextView regTitle;
    public final TextView subTotal;
    public final TextView totalAmount;

    public abstract void setFeeConfirmViewModel(FeeConfirmViewModel feeConfirmViewModel);

    protected DialogFeeConfirmBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView fine, TextView payConfirmBtn, TextView regTitle, TextView subTotal, TextView totalAmount) {
        super(_bindingComponent, _root, _localFieldCount);
        this.fine = fine;
        this.payConfirmBtn = payConfirmBtn;
        this.regTitle = regTitle;
        this.subTotal = subTotal;
        this.totalAmount = totalAmount;
    }

    public FeeConfirmViewModel getFeeConfirmViewModel() {
        return this.mFeeConfirmViewModel;
    }

    public static DialogFeeConfirmBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogFeeConfirmBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (DialogFeeConfirmBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_fee_confirm, root, attachToRoot, component);
    }

    public static DialogFeeConfirmBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogFeeConfirmBinding inflate(LayoutInflater inflater, Object component) {
        return (DialogFeeConfirmBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_fee_confirm, null, false, component);
    }

    public static DialogFeeConfirmBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogFeeConfirmBinding bind(View view, Object component) {
        return (DialogFeeConfirmBinding) bind(component, view, R.layout.dialog_fee_confirm);
    }
}