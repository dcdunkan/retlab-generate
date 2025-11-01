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
public final class ActivityHostelPaymentBinding implements ViewBinding {
    public final WebView hostelWeb;
    private final FrameLayout rootView;

    private ActivityHostelPaymentBinding(FrameLayout rootView, WebView hostelWeb) {
        this.rootView = rootView;
        this.hostelWeb = hostelWeb;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static ActivityHostelPaymentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityHostelPaymentBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.activity_hostel_payment, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityHostelPaymentBinding bind(View rootView) {
        int i = R.id.hostelWeb;
        WebView webView = (WebView) ViewBindings.findChildViewById(rootView, i);
        if (webView != null) {
            return new ActivityHostelPaymentBinding((FrameLayout) rootView, webView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}