package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.etuwa.app.R;

/* loaded from: classes3.dex */
public final class RowRemarkBinding implements ViewBinding {
    private final CardView rootView;
    public final TextView tvRemark;
    public final TextView tvRemarkBy;

    private RowRemarkBinding(CardView rootView, TextView tvRemark, TextView tvRemarkBy) {
        this.rootView = rootView;
        this.tvRemark = tvRemark;
        this.tvRemarkBy = tvRemarkBy;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static RowRemarkBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowRemarkBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_remark, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowRemarkBinding bind(View rootView) {
        int i = R.id.tv_remark;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.tv_remark_by;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                return new RowRemarkBinding((CardView) rootView, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}