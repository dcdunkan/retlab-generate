package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.etuwa.app.R;

/* loaded from: classes3.dex */
public final class RowDashBinding implements ViewBinding {
    public final LinearLayout cardDash;
    public final ImageView ivDash;
    private final LinearLayout rootView;
    public final TextView tvTitleDash;

    private RowDashBinding(LinearLayout rootView, LinearLayout cardDash, ImageView ivDash, TextView tvTitleDash) {
        this.rootView = rootView;
        this.cardDash = cardDash;
        this.ivDash = ivDash;
        this.tvTitleDash = tvTitleDash;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static RowDashBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowDashBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_dash, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowDashBinding bind(View rootView) {
        LinearLayout linearLayout = (LinearLayout) rootView;
        int i = R.id.iv_dash;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null) {
            i = R.id.tv_title_dash;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                return new RowDashBinding(linearLayout, linearLayout, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}