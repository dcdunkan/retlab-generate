package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import in.etuwa.app.R;
import in.etuwa.app.ui.transport.buspass.fullscreen.QrFullScreenViewModel;

/* loaded from: classes3.dex */
public abstract class DialogQrFullScreenBinding extends ViewDataBinding {

    @Bindable
    protected QrFullScreenViewModel mQrFullScreenViewModel;
    public final TextView qrDownloadBtn;
    public final ImageView qrImageView;

    public abstract void setQrFullScreenViewModel(QrFullScreenViewModel qrFullScreenViewModel);

    protected DialogQrFullScreenBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView qrDownloadBtn, ImageView qrImageView) {
        super(_bindingComponent, _root, _localFieldCount);
        this.qrDownloadBtn = qrDownloadBtn;
        this.qrImageView = qrImageView;
    }

    public QrFullScreenViewModel getQrFullScreenViewModel() {
        return this.mQrFullScreenViewModel;
    }

    public static DialogQrFullScreenBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogQrFullScreenBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (DialogQrFullScreenBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_qr_full_screen, root, attachToRoot, component);
    }

    public static DialogQrFullScreenBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogQrFullScreenBinding inflate(LayoutInflater inflater, Object component) {
        return (DialogQrFullScreenBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_qr_full_screen, null, false, component);
    }

    public static DialogQrFullScreenBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogQrFullScreenBinding bind(View view, Object component) {
        return (DialogQrFullScreenBinding) bind(component, view, R.layout.dialog_qr_full_screen);
    }
}