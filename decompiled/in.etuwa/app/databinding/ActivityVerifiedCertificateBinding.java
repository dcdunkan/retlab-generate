package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.etuwa.app.R;

/* loaded from: classes3.dex */
public final class ActivityVerifiedCertificateBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final WebView verifiedCertificateWV;

    private ActivityVerifiedCertificateBinding(ConstraintLayout rootView, WebView verifiedCertificateWV) {
        this.rootView = rootView;
        this.verifiedCertificateWV = verifiedCertificateWV;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityVerifiedCertificateBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityVerifiedCertificateBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.activity_verified_certificate, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityVerifiedCertificateBinding bind(View rootView) {
        int i = R.id.verified_certificate_WV;
        WebView webView = (WebView) ViewBindings.findChildViewById(rootView, i);
        if (webView != null) {
            return new ActivityVerifiedCertificateBinding((ConstraintLayout) rootView, webView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}