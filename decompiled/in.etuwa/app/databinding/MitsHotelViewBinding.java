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
public final class MitsHotelViewBinding implements ViewBinding {
    public final WebView mitsHostelWebview;
    private final ConstraintLayout rootView;

    private MitsHotelViewBinding(ConstraintLayout rootView, WebView mitsHostelWebview) {
        this.rootView = rootView;
        this.mitsHostelWebview = mitsHostelWebview;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static MitsHotelViewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static MitsHotelViewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.mits_hotel_view, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static MitsHotelViewBinding bind(View rootView) {
        int i = R.id.mits_hostel_webview;
        WebView webView = (WebView) ViewBindings.findChildViewById(rootView, i);
        if (webView != null) {
            return new MitsHotelViewBinding((ConstraintLayout) rootView, webView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}