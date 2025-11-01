package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.etuwa.app.R;

/* loaded from: classes3.dex */
public final class RowActions2Binding implements ViewBinding {
    private final LinearLayout rootView;
    public final TextView tvActionDate;
    public final TextView tvActionLevel;
    public final TextView tvActionTaken;

    private RowActions2Binding(LinearLayout rootView, TextView tvActionDate, TextView tvActionLevel, TextView tvActionTaken) {
        this.rootView = rootView;
        this.tvActionDate = tvActionDate;
        this.tvActionLevel = tvActionLevel;
        this.tvActionTaken = tvActionTaken;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static RowActions2Binding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowActions2Binding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_actions2, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowActions2Binding bind(View rootView) {
        int i = R.id.tv_action_date;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.tv_action_level;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.tv_action_taken;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView3 != null) {
                    return new RowActions2Binding((LinearLayout) rootView, textView, textView2, textView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}