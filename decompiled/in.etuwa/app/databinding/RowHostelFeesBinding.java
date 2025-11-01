package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.etuwa.app.R;

/* loaded from: classes3.dex */
public final class RowHostelFeesBinding implements ViewBinding {
    public final TextView amountLbl;
    public final TextView balanceLbl;
    public final TextView hostelFeeName;
    public final LinearLayout linearHostel;
    public final TextView paidLbl;
    public final EditText payableLbl;
    private final LinearLayout rootView;
    public final TextView scholorshipLbl;

    private RowHostelFeesBinding(LinearLayout rootView, TextView amountLbl, TextView balanceLbl, TextView hostelFeeName, LinearLayout linearHostel, TextView paidLbl, EditText payableLbl, TextView scholorshipLbl) {
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

    public static RowHostelFeesBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowHostelFeesBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_hostel_fees, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowHostelFeesBinding bind(View rootView) {
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
                        EditText editText = (EditText) ViewBindings.findChildViewById(rootView, i);
                        if (editText != null) {
                            i = R.id.scholorship_lbl;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView5 != null) {
                                return new RowHostelFeesBinding(linearLayout, textView, textView2, textView3, linearLayout, textView4, editText, textView5);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}