package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import in.etuwa.app.R;
import in.etuwa.app.ui.hostelnew.confirm.HostelNewConfirmViewModel;

/* loaded from: classes3.dex */
public abstract class DialogHostelNewConfirmBinding extends ViewDataBinding {
    public final TextView fine;

    @Bindable
    protected HostelNewConfirmViewModel mHostelNewConfirmViewModel;
    public final TextView payConfirmBtn;
    public final TextView regTitle;
    public final TextView subTotal;
    public final TextView totalAmount;

    public abstract void setHostelNewConfirmViewModel(HostelNewConfirmViewModel hostelNewConfirmViewModel);

    protected DialogHostelNewConfirmBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView fine, TextView payConfirmBtn, TextView regTitle, TextView subTotal, TextView totalAmount) {
        super(_bindingComponent, _root, _localFieldCount);
        this.fine = fine;
        this.payConfirmBtn = payConfirmBtn;
        this.regTitle = regTitle;
        this.subTotal = subTotal;
        this.totalAmount = totalAmount;
    }

    public HostelNewConfirmViewModel getHostelNewConfirmViewModel() {
        return this.mHostelNewConfirmViewModel;
    }

    public static DialogHostelNewConfirmBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogHostelNewConfirmBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (DialogHostelNewConfirmBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_hostel_new_confirm, root, attachToRoot, component);
    }

    public static DialogHostelNewConfirmBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogHostelNewConfirmBinding inflate(LayoutInflater inflater, Object component) {
        return (DialogHostelNewConfirmBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_hostel_new_confirm, null, false, component);
    }

    public static DialogHostelNewConfirmBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogHostelNewConfirmBinding bind(View view, Object component) {
        return (DialogHostelNewConfirmBinding) bind(component, view, R.layout.dialog_hostel_new_confirm);
    }
}