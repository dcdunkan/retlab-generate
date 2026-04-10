package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import in.etuwa.app.R;

/* JADX INFO: loaded from: classes3.dex */
public final class RowHostelNewAdmissionBinding implements ViewBinding {
    public final MaterialButton hostelFeeDetail;
    public final TextView hostelInstallment;
    public final TextView hostelLateFee;
    public final TextView hostelMainAmount;
    public final TextView hostelMainBalance;
    public final TextView hostelMainPaid;
    public final CheckBox installmentCheck;
    public final MaterialCardView linearHost;
    private final MaterialCardView rootView;

    private RowHostelNewAdmissionBinding(MaterialCardView rootView, MaterialButton hostelFeeDetail, TextView hostelInstallment, TextView hostelLateFee, TextView hostelMainAmount, TextView hostelMainBalance, TextView hostelMainPaid, CheckBox installmentCheck, MaterialCardView linearHost) {
        this.rootView = rootView;
        this.hostelFeeDetail = hostelFeeDetail;
        this.hostelInstallment = hostelInstallment;
        this.hostelLateFee = hostelLateFee;
        this.hostelMainAmount = hostelMainAmount;
        this.hostelMainBalance = hostelMainBalance;
        this.hostelMainPaid = hostelMainPaid;
        this.installmentCheck = installmentCheck;
        this.linearHost = linearHost;
    }

    @Override // androidx.viewbinding.ViewBinding
    public MaterialCardView getRoot() {
        return this.rootView;
    }

    public static RowHostelNewAdmissionBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowHostelNewAdmissionBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.row_hostel_new_admission, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static RowHostelNewAdmissionBinding bind(View rootView) {
        int i = R.id.hostel_fee_detail;
        MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(rootView, i);
        if (materialButton != null) {
            i = R.id.hostel_installment;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                i = R.id.hostel_late_fee;
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
                                i = R.id.installment_check;
                                CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(rootView, i);
                                if (checkBox != null) {
                                    MaterialCardView materialCardView = (MaterialCardView) rootView;
                                    return new RowHostelNewAdmissionBinding(materialCardView, materialButton, textView, textView2, textView3, textView4, textView5, checkBox, materialCardView);
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