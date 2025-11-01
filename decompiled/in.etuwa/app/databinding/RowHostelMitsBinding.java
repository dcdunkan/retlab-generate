package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.etuwa.app.R;

/* loaded from: classes3.dex */
public final class RowHostelMitsBinding implements ViewBinding {
    public final TextView hostelFeeDetail;
    public final TextView hostelInstallment;
    public final TextView hostelMainAmount;
    public final TextView hostelMainBalance;
    public final TextView hostelMainPaid;
    public final TextView hostelMainScholarship;
    public final CheckBox installmentCheck;
    public final LinearLayout linearHost;
    private final LinearLayout rootView;

    private RowHostelMitsBinding(LinearLayout rootView, TextView hostelFeeDetail, TextView hostelInstallment, TextView hostelMainAmount, TextView hostelMainBalance, TextView hostelMainPaid, TextView hostelMainScholarship, CheckBox installmentCheck, LinearLayout linearHost) {
        this.rootView = rootView;
        this.hostelFeeDetail = hostelFeeDetail;
        this.hostelInstallment = hostelInstallment;
        this.hostelMainAmount = hostelMainAmount;
        this.hostelMainBalance = hostelMainBalance;
        this.hostelMainPaid = hostelMainPaid;
        this.hostelMainScholarship = hostelMainScholarship;
        this.installmentCheck = installmentCheck;
        this.linearHost = linearHost;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static RowHostelMitsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowHostelMitsBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_hostel_mits, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowHostelMitsBinding bind(View rootView) {
        int i = R.id.hostel_fee_detail;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.hostel_installment;
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
                            i = R.id.hostel_main_scholarship;
                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView6 != null) {
                                i = R.id.installment_check;
                                CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(rootView, i);
                                if (checkBox != null) {
                                    LinearLayout linearLayout = (LinearLayout) rootView;
                                    return new RowHostelMitsBinding(linearLayout, textView, textView2, textView3, textView4, textView5, textView6, checkBox, linearLayout);
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