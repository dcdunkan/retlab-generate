package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import in.etuwa.app.R;
import in.etuwa.app.ui.fees.webview.WebViewViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentWebviewBinding extends ViewDataBinding {

    @Bindable
    protected WebViewViewModel mWebViewViewModel;
    public final SwipeRefreshLayout swipeLayout;
    public final WebView webView;

    public abstract void setWebViewViewModel(WebViewViewModel webViewViewModel);

    protected FragmentWebviewBinding(Object _bindingComponent, View _root, int _localFieldCount, SwipeRefreshLayout swipeLayout, WebView webView) {
        super(_bindingComponent, _root, _localFieldCount);
        this.swipeLayout = swipeLayout;
        this.webView = webView;
    }

    public WebViewViewModel getWebViewViewModel() {
        return this.mWebViewViewModel;
    }

    public static FragmentWebviewBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentWebviewBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentWebviewBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_webview, root, attachToRoot, component);
    }

    public static FragmentWebviewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentWebviewBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentWebviewBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_webview, null, false, component);
    }

    public static FragmentWebviewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentWebviewBinding bind(View view, Object component) {
        return (FragmentWebviewBinding) bind(component, view, R.layout.fragment_webview);
    }
}