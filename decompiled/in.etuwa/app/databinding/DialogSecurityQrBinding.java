package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import in.etuwa.app.R;
import in.etuwa.app.ui.hostel.attendance.viewleave.qrdialog.SecurityQrViewModel;

/* loaded from: classes3.dex */
public abstract class DialogSecurityQrBinding extends ViewDataBinding {
    public final TextView addressTv;
    public final ImageView approvedImage;
    public final ImageView bpImage;
    public final TextView bpName;
    public final ImageView bpQr;
    public final ScrollView bussPassView;
    public final TextView dateOfLeaveTv;
    public final TextView dateTv;
    public final TextView downloadBtn;
    public final TextView hostelNameTv;

    @Bindable
    protected SecurityQrViewModel mSecurityQrViewModel;
    public final TextView phoneTv;
    public final TextView reasonTv;
    public final TextView roomNoTv;
    public final TextView statusTv;
    public final TextView tvError;

    public abstract void setSecurityQrViewModel(SecurityQrViewModel securityQrViewModel);

    protected DialogSecurityQrBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView addressTv, ImageView approvedImage, ImageView bpImage, TextView bpName, ImageView bpQr, ScrollView bussPassView, TextView dateOfLeaveTv, TextView dateTv, TextView downloadBtn, TextView hostelNameTv, TextView phoneTv, TextView reasonTv, TextView roomNoTv, TextView statusTv, TextView tvError) {
        super(_bindingComponent, _root, _localFieldCount);
        this.addressTv = addressTv;
        this.approvedImage = approvedImage;
        this.bpImage = bpImage;
        this.bpName = bpName;
        this.bpQr = bpQr;
        this.bussPassView = bussPassView;
        this.dateOfLeaveTv = dateOfLeaveTv;
        this.dateTv = dateTv;
        this.downloadBtn = downloadBtn;
        this.hostelNameTv = hostelNameTv;
        this.phoneTv = phoneTv;
        this.reasonTv = reasonTv;
        this.roomNoTv = roomNoTv;
        this.statusTv = statusTv;
        this.tvError = tvError;
    }

    public SecurityQrViewModel getSecurityQrViewModel() {
        return this.mSecurityQrViewModel;
    }

    public static DialogSecurityQrBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogSecurityQrBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (DialogSecurityQrBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_security_qr, root, attachToRoot, component);
    }

    public static DialogSecurityQrBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogSecurityQrBinding inflate(LayoutInflater inflater, Object component) {
        return (DialogSecurityQrBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_security_qr, null, false, component);
    }

    public static DialogSecurityQrBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogSecurityQrBinding bind(View view, Object component) {
        return (DialogSecurityQrBinding) bind(component, view, R.layout.dialog_security_qr);
    }
}