package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import in.etuwa.app.R;
import in.etuwa.app.ui.hostel.tkmhostel.fee.payweb.PayWebViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentPayWebBinding extends ViewDataBinding {
    public final WebView hostelWebView;

    @Bindable
    protected PayWebViewModel mPayWebViewModel;

    public abstract void setPayWebViewModel(PayWebViewModel payWebViewModel);

    protected FragmentPayWebBinding(Object _bindingComponent, View _root, int _localFieldCount, WebView hostelWebView) {
        super(_bindingComponent, _root, _localFieldCount);
        this.hostelWebView = hostelWebView;
    }

    public PayWebViewModel getPayWebViewModel() {
        return this.mPayWebViewModel;
    }

    public static FragmentPayWebBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentPayWebBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentPayWebBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_pay_web, root, attachToRoot, component);
    }

    public static FragmentPayWebBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentPayWebBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentPayWebBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_pay_web, null, false, component);
    }

    public static FragmentPayWebBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentPayWebBinding bind(View view, Object component) {
        return (FragmentPayWebBinding) bind(component, view, R.layout.fragment_pay_web);
    }
}