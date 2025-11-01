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
public final class ActivityRegistrationBinding implements ViewBinding {
    public final WebView registrationWebview;
    private final ConstraintLayout rootView;

    private ActivityRegistrationBinding(ConstraintLayout rootView, WebView registrationWebview) {
        this.rootView = rootView;
        this.registrationWebview = registrationWebview;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityRegistrationBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityRegistrationBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.activity_registration, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityRegistrationBinding bind(View rootView) {
        int i = R.id.registration_webview;
        WebView webView = (WebView) ViewBindings.findChildViewById(rootView, i);
        if (webView != null) {
            return new ActivityRegistrationBinding((ConstraintLayout) rootView, webView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}