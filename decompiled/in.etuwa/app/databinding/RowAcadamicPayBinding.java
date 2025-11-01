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
public final class RowAcadamicPayBinding implements ViewBinding {
    public final TextView acadamicAmount;
    public final TextView acdamicPayName;
    public final LinearLayout linearplay;
    private final LinearLayout rootView;

    private RowAcadamicPayBinding(LinearLayout rootView, TextView acadamicAmount, TextView acdamicPayName, LinearLayout linearplay) {
        this.rootView = rootView;
        this.acadamicAmount = acadamicAmount;
        this.acdamicPayName = acdamicPayName;
        this.linearplay = linearplay;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static RowAcadamicPayBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowAcadamicPayBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_acadamic_pay, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowAcadamicPayBinding bind(View rootView) {
        int i = R.id.acadamicAmount;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.acdamicPayName;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                LinearLayout linearLayout = (LinearLayout) rootView;
                return new RowAcadamicPayBinding(linearLayout, textView, textView2, linearLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}