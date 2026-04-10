package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.etuwa.app.R;

/* JADX INFO: loaded from: classes3.dex */
public final class RowNewDashBinding implements ViewBinding {
    public final CardView cardDash;
    public final LinearLayout iconBg;
    public final ImageView ivDash;
    private final CardView rootView;
    public final TextView tvTitleDash;

    private RowNewDashBinding(CardView rootView, CardView cardDash, LinearLayout iconBg, ImageView ivDash, TextView tvTitleDash) {
        this.rootView = rootView;
        this.cardDash = cardDash;
        this.iconBg = iconBg;
        this.ivDash = ivDash;
        this.tvTitleDash = tvTitleDash;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static RowNewDashBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowNewDashBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.row_new_dash, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static RowNewDashBinding bind(View rootView) {
        CardView cardView = (CardView) rootView;
        int i = R.id.icon_bg;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
        if (linearLayout != null) {
            i = R.id.iv_dash;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
            if (imageView != null) {
                i = R.id.tv_title_dash;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView != null) {
                    return new RowNewDashBinding(cardView, cardView, linearLayout, imageView, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}