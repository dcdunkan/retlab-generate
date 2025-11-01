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
public final class RowHostelNewDetailsBinding implements ViewBinding {
    public final TextView amountLbl;
    public final TextView balanceLbl;
    public final TextView hostelFeeName;
    public final LinearLayout linearHostel;
    public final TextView paidLbl;
    public final TextView payableLbl;
    private final LinearLayout rootView;
    public final TextView scholorshipLbl;

    private RowHostelNewDetailsBinding(LinearLayout rootView, TextView amountLbl, TextView balanceLbl, TextView hostelFeeName, LinearLayout linearHostel, TextView paidLbl, TextView payableLbl, TextView scholorshipLbl) {
        this.rootView = rootView;
        this.amountLbl = amountLbl;
        this.balanceLbl = balanceLbl;
        this.hostelFeeName = hostelFeeName;
        this.linearHostel = linearHostel;
        this.paidLbl = paidLbl;
        this.payableLbl = payableLbl;
        this.scholorshipLbl = scholorshipLbl;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static RowHostelNewDetailsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowHostelNewDetailsBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_hostel_new_details, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowHostelNewDetailsBinding bind(View rootView) {
        int i = R.id.amount_lbl;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.balance_lbl;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.hostel_fee_name;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView3 != null) {
                    LinearLayout linearLayout = (LinearLayout) rootView;
                    i = R.id.paid_lbl;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView4 != null) {
                        i = R.id.payable_lbl;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView5 != null) {
                            i = R.id.scholorship_lbl;
                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView6 != null) {
                                return new RowHostelNewDetailsBinding(linearLayout, textView, textView2, textView3, linearLayout, textView4, textView5, textView6);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}