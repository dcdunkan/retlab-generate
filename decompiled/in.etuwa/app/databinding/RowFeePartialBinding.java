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
public final class RowFeePartialBinding implements ViewBinding {
    public final LinearLayout discountLyt;
    public final TextView engnrAmountLbl;
    public final TextView engnrBalanceLbl;
    public final TextView engnrDiscountLbl;
    public final TextView engnrFeeName;
    public final TextView engnrPaidLbl;
    public final EditText engnrPayingLbl;
    public final TextView engnrScholorshipLbl;
    public final LinearLayout linearEngnrFee;
    private final LinearLayout rootView;

    private RowFeePartialBinding(LinearLayout rootView, LinearLayout discountLyt, TextView engnrAmountLbl, TextView engnrBalanceLbl, TextView engnrDiscountLbl, TextView engnrFeeName, TextView engnrPaidLbl, EditText engnrPayingLbl, TextView engnrScholorshipLbl, LinearLayout linearEngnrFee) {
        this.rootView = rootView;
        this.discountLyt = discountLyt;
        this.engnrAmountLbl = engnrAmountLbl;
        this.engnrBalanceLbl = engnrBalanceLbl;
        this.engnrDiscountLbl = engnrDiscountLbl;
        this.engnrFeeName = engnrFeeName;
        this.engnrPaidLbl = engnrPaidLbl;
        this.engnrPayingLbl = engnrPayingLbl;
        this.engnrScholorshipLbl = engnrScholorshipLbl;
        this.linearEngnrFee = linearEngnrFee;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static RowFeePartialBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowFeePartialBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_fee_partial, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowFeePartialBinding bind(View rootView) {
        int i = R.id.discount_lyt;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
        if (linearLayout != null) {
            i = R.id.engnr_amount_lbl;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                i = R.id.engnr_balance_lbl;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView2 != null) {
                    i = R.id.engnr_discount_lbl;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView3 != null) {
                        i = R.id.engnr_fee_name;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView4 != null) {
                            i = R.id.engnr_paid_lbl;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView5 != null) {
                                i = R.id.engnr_paying_lbl;
                                EditText editText = (EditText) ViewBindings.findChildViewById(rootView, i);
                                if (editText != null) {
                                    i = R.id.engnr_scholorship_lbl;
                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView6 != null) {
                                        LinearLayout linearLayout2 = (LinearLayout) rootView;
                                        return new RowFeePartialBinding(linearLayout2, linearLayout, textView, textView2, textView3, textView4, textView5, editText, textView6, linearLayout2);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}