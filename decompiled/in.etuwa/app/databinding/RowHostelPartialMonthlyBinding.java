package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.etuwa.app.R;

/* loaded from: classes3.dex */
public final class RowHostelPartialMonthlyBinding implements ViewBinding {
    public final TextView hostelInstallment;
    public final TextView hostelMainAmount;
    public final TextView hostelMainBalance;
    public final TextView hostelMainPaid;
    public final EditText hostelMainPayable;
    public final CheckBox installmentCheck;
    public final CardView linearHost;
    private final CardView rootView;

    private RowHostelPartialMonthlyBinding(CardView rootView, TextView hostelInstallment, TextView hostelMainAmount, TextView hostelMainBalance, TextView hostelMainPaid, EditText hostelMainPayable, CheckBox installmentCheck, CardView linearHost) {
        this.rootView = rootView;
        this.hostelInstallment = hostelInstallment;
        this.hostelMainAmount = hostelMainAmount;
        this.hostelMainBalance = hostelMainBalance;
        this.hostelMainPaid = hostelMainPaid;
        this.hostelMainPayable = hostelMainPayable;
        this.installmentCheck = installmentCheck;
        this.linearHost = linearHost;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static RowHostelPartialMonthlyBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowHostelPartialMonthlyBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_hostel_partial_monthly, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowHostelPartialMonthlyBinding bind(View rootView) {
        int i = R.id.hostel_installment;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.hostel_main_amount;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.hostel_main_balance;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView3 != null) {
                    i = R.id.hostel_main_paid;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView4 != null) {
                        i = R.id.hostel_main_payable;
                        EditText editText = (EditText) ViewBindings.findChildViewById(rootView, i);
                        if (editText != null) {
                            i = R.id.installment_check;
                            CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(rootView, i);
                            if (checkBox != null) {
                                CardView cardView = (CardView) rootView;
                                return new RowHostelPartialMonthlyBinding(cardView, textView, textView2, textView3, textView4, editText, checkBox, cardView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}