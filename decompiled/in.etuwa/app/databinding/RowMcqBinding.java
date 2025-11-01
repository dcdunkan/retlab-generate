package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.etuwa.app.R;

/* loaded from: classes3.dex */
public final class RowMcqBinding implements ViewBinding {
    public final ImageView checkBtn;
    public final WebView mcqOption;
    public final LinearLayout mcqOptionView;
    private final LinearLayout rootView;

    private RowMcqBinding(LinearLayout rootView, ImageView checkBtn, WebView mcqOption, LinearLayout mcqOptionView) {
        this.rootView = rootView;
        this.checkBtn = checkBtn;
        this.mcqOption = mcqOption;
        this.mcqOptionView = mcqOptionView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static RowMcqBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowMcqBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_mcq, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowMcqBinding bind(View rootView) {
        int i = R.id.check_btn;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null) {
            i = R.id.mcq_option;
            WebView webView = (WebView) ViewBindings.findChildViewById(rootView, i);
            if (webView != null) {
                LinearLayout linearLayout = (LinearLayout) rootView;
                return new RowMcqBinding(linearLayout, imageView, webView, linearLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}