package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.etuwa.app.R;

/* loaded from: classes3.dex */
public final class ActivityAcadamicPaymentBinding implements ViewBinding {
    public final WebView acadamicWeb;
    private final FrameLayout rootView;

    private ActivityAcadamicPaymentBinding(FrameLayout rootView, WebView acadamicWeb) {
        this.rootView = rootView;
        this.acadamicWeb = acadamicWeb;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static ActivityAcadamicPaymentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityAcadamicPaymentBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.activity_acadamic_payment, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityAcadamicPaymentBinding bind(View rootView) {
        int i = R.id.acadamicWeb;
        WebView webView = (WebView) ViewBindings.findChildViewById(rootView, i);
        if (webView != null) {
            return new ActivityAcadamicPaymentBinding((FrameLayout) rootView, webView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}