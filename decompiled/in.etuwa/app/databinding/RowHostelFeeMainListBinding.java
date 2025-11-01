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
public final class RowHostelFeeMainListBinding implements ViewBinding {
    public final TextView feeHead;
    public final TextView hostelMonth;
    public final LinearLayout linearHost;
    private final LinearLayout rootView;

    private RowHostelFeeMainListBinding(LinearLayout rootView, TextView feeHead, TextView hostelMonth, LinearLayout linearHost) {
        this.rootView = rootView;
        this.feeHead = feeHead;
        this.hostelMonth = hostelMonth;
        this.linearHost = linearHost;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static RowHostelFeeMainListBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowHostelFeeMainListBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_hostel_fee_main_list, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowHostelFeeMainListBinding bind(View rootView) {
        int i = R.id.fee_head;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.hostel_month;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                LinearLayout linearLayout = (LinearLayout) rootView;
                return new RowHostelFeeMainListBinding(linearLayout, textView, textView2, linearLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}