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
public final class RowFeeBinding implements ViewBinding {
    public final LinearLayout cardFees;
    private final LinearLayout rootView;
    public final TextView tvBalance;
    public final TextView tvInstalment;
    public final TextView tvPaid;
    public final TextView tvScholarship;
    public final TextView tvTotalAmount;

    private RowFeeBinding(LinearLayout rootView, LinearLayout cardFees, TextView tvBalance, TextView tvInstalment, TextView tvPaid, TextView tvScholarship, TextView tvTotalAmount) {
        this.rootView = rootView;
        this.cardFees = cardFees;
        this.tvBalance = tvBalance;
        this.tvInstalment = tvInstalment;
        this.tvPaid = tvPaid;
        this.tvScholarship = tvScholarship;
        this.tvTotalAmount = tvTotalAmount;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static RowFeeBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowFeeBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_fee, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowFeeBinding bind(View rootView) {
        LinearLayout linearLayout = (LinearLayout) rootView;
        int i = R.id.tv_balance;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.tv_instalment;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.tv_paid;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView3 != null) {
                    i = R.id.tv_scholarship;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView4 != null) {
                        i = R.id.tv_total_amount;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView5 != null) {
                            return new RowFeeBinding(linearLayout, linearLayout, textView, textView2, textView3, textView4, textView5);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}