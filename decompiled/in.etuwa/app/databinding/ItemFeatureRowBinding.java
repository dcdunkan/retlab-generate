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

/* JADX INFO: loaded from: classes3.dex */
public final class ItemFeatureRowBinding implements ViewBinding {
    public final ImageView ivFeatureIcon;
    private final LinearLayout rootView;
    public final TextView tvFeatureDesc;
    public final TextView tvFeatureTitle;

    private ItemFeatureRowBinding(LinearLayout rootView, ImageView ivFeatureIcon, TextView tvFeatureDesc, TextView tvFeatureTitle) {
        this.rootView = rootView;
        this.ivFeatureIcon = ivFeatureIcon;
        this.tvFeatureDesc = tvFeatureDesc;
        this.tvFeatureTitle = tvFeatureTitle;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ItemFeatureRowBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ItemFeatureRowBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.item_feature_row, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemFeatureRowBinding bind(View rootView) {
        int i = R.id.ivFeatureIcon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null) {
            i = R.id.tvFeatureDesc;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                i = R.id.tvFeatureTitle;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView2 != null) {
                    return new ItemFeatureRowBinding((LinearLayout) rootView, imageView, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}