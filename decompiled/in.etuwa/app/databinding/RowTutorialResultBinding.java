package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.etuwa.app.R;

/* loaded from: classes3.dex */
public final class RowTutorialResultBinding implements ViewBinding {
    public final LinearLayout nameLayout;
    private final CardView rootView;
    public final TextView tvMark;
    public final TextView tvSub;
    public final TextView tvTitle;

    private RowTutorialResultBinding(CardView rootView, LinearLayout nameLayout, TextView tvMark, TextView tvSub, TextView tvTitle) {
        this.rootView = rootView;
        this.nameLayout = nameLayout;
        this.tvMark = tvMark;
        this.tvSub = tvSub;
        this.tvTitle = tvTitle;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static RowTutorialResultBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowTutorialResultBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_tutorial_result, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowTutorialResultBinding bind(View rootView) {
        int i = R.id.name_layout;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
        if (linearLayout != null) {
            i = R.id.tv_mark;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                i = R.id.tv_sub;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView2 != null) {
                    i = R.id.tv_title;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView3 != null) {
                        return new RowTutorialResultBinding((CardView) rootView, linearLayout, textView, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}