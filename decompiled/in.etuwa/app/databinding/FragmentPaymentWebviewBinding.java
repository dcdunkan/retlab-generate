package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import in.etuwa.app.R;
import in.etuwa.app.ui.feenewengineer.payment.webview.PaymentWebViewViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentPaymentWebviewBinding extends ViewDataBinding {

    @Bindable
    protected PaymentWebViewViewModel mPaymentWebViewViewModel;
    public final WebView webview;

    public abstract void setPaymentWebViewViewModel(PaymentWebViewViewModel paymentWebViewViewModel);

    protected FragmentPaymentWebviewBinding(Object _bindingComponent, View _root, int _localFieldCount, WebView webview) {
        super(_bindingComponent, _root, _localFieldCount);
        this.webview = webview;
    }

    public PaymentWebViewViewModel getPaymentWebViewViewModel() {
        return this.mPaymentWebViewViewModel;
    }

    public static FragmentPaymentWebviewBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentPaymentWebviewBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentPaymentWebviewBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_payment_webview, root, attachToRoot, component);
    }

    public static FragmentPaymentWebviewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentPaymentWebviewBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentPaymentWebviewBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_payment_webview, null, false, component);
    }

    public static FragmentPaymentWebviewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentPaymentWebviewBinding bind(View view, Object component) {
        return (FragmentPaymentWebviewBinding) bind(component, view, R.layout.fragment_payment_webview);
    }
}