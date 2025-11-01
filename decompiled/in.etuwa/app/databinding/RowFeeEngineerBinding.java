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
public final class RowFeeEngineerBinding implements ViewBinding {
    public final TextView engineerDetailBtn;
    public final TextView feeEngnrAmt;
    public final TextView feeEngnrBalance;
    public final CheckBox feeEngnrCheckBox;
    public final TextView feeEngnrHead;
    public final LinearLayout linearHost;
    private final LinearLayout rootView;

    private RowFeeEngineerBinding(LinearLayout rootView, TextView engineerDetailBtn, TextView feeEngnrAmt, TextView feeEngnrBalance, CheckBox feeEngnrCheckBox, TextView feeEngnrHead, LinearLayout linearHost) {
        this.rootView = rootView;
        this.engineerDetailBtn = engineerDetailBtn;
        this.feeEngnrAmt = feeEngnrAmt;
        this.feeEngnrBalance = feeEngnrBalance;
        this.feeEngnrCheckBox = feeEngnrCheckBox;
        this.feeEngnrHead = feeEngnrHead;
        this.linearHost = linearHost;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static RowFeeEngineerBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowFeeEngineerBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_fee_engineer, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowFeeEngineerBinding bind(View rootView) {
        int i = R.id.engineer_detail_btn;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.fee_engnr_amt;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.fee_engnr_balance;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView3 != null) {
                    i = R.id.fee_engnr_check_box;
                    CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(rootView, i);
                    if (checkBox != null) {
                        i = R.id.fee_engnr_head;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView4 != null) {
                            LinearLayout linearLayout = (LinearLayout) rootView;
                            return new RowFeeEngineerBinding(linearLayout, textView, textView2, textView3, checkBox, textView4, linearLayout);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}