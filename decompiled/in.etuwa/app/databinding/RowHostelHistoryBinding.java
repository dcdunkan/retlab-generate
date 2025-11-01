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
public final class RowHostelHistoryBinding implements ViewBinding {
    public final TextView hostelInstallment;
    public final TextView hostelMainAdjustment;
    public final TextView hostelMainAmount;
    public final TextView hostelMainBalance;
    public final TextView hostelMainPaid;
    public final LinearLayout linearHost;
    private final LinearLayout rootView;

    private RowHostelHistoryBinding(LinearLayout rootView, TextView hostelInstallment, TextView hostelMainAdjustment, TextView hostelMainAmount, TextView hostelMainBalance, TextView hostelMainPaid, LinearLayout linearHost) {
        this.rootView = rootView;
        this.hostelInstallment = hostelInstallment;
        this.hostelMainAdjustment = hostelMainAdjustment;
        this.hostelMainAmount = hostelMainAmount;
        this.hostelMainBalance = hostelMainBalance;
        this.hostelMainPaid = hostelMainPaid;
        this.linearHost = linearHost;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static RowHostelHistoryBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowHostelHistoryBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_hostel_history, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowHostelHistoryBinding bind(View rootView) {
        int i = R.id.hostel_installment;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.hostel_main_adjustment;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.hostel_main_amount;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView3 != null) {
                    i = R.id.hostel_main_balance;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView4 != null) {
                        i = R.id.hostel_main_paid;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView5 != null) {
                            LinearLayout linearLayout = (LinearLayout) rootView;
                            return new RowHostelHistoryBinding(linearLayout, textView, textView2, textView3, textView4, textView5, linearLayout);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}