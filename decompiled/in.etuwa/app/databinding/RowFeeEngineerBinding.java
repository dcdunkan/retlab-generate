package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.checkbox.MaterialCheckBox;
import in.etuwa.app.R;

/* JADX INFO: loaded from: classes3.dex */
public final class RowFeeEngineerBinding implements ViewBinding {
    public final LinearLayout amountSection;
    public final MaterialCardView cardHost;
    public final MaterialButton engineerDetailBtn;
    public final TextView feeEngnrAmt;
    public final TextView feeEngnrBalance;
    public final MaterialCheckBox feeEngnrCheckBox;
    public final TextView feeEngnrHead;
    private final MaterialCardView rootView;

    private RowFeeEngineerBinding(MaterialCardView rootView, LinearLayout amountSection, MaterialCardView cardHost, MaterialButton engineerDetailBtn, TextView feeEngnrAmt, TextView feeEngnrBalance, MaterialCheckBox feeEngnrCheckBox, TextView feeEngnrHead) {
        this.rootView = rootView;
        this.amountSection = amountSection;
        this.cardHost = cardHost;
        this.engineerDetailBtn = engineerDetailBtn;
        this.feeEngnrAmt = feeEngnrAmt;
        this.feeEngnrBalance = feeEngnrBalance;
        this.feeEngnrCheckBox = feeEngnrCheckBox;
        this.feeEngnrHead = feeEngnrHead;
    }

    @Override // androidx.viewbinding.ViewBinding
    public MaterialCardView getRoot() {
        return this.rootView;
    }

    public static RowFeeEngineerBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowFeeEngineerBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.row_fee_engineer, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static RowFeeEngineerBinding bind(View rootView) {
        int i = R.id.amountSection;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
        if (linearLayout != null) {
            MaterialCardView materialCardView = (MaterialCardView) rootView;
            i = R.id.engineer_detail_btn;
            MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(rootView, i);
            if (materialButton != null) {
                i = R.id.fee_engnr_amt;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView != null) {
                    i = R.id.fee_engnr_balance;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView2 != null) {
                        i = R.id.fee_engnr_check_box;
                        MaterialCheckBox materialCheckBox = (MaterialCheckBox) ViewBindings.findChildViewById(rootView, i);
                        if (materialCheckBox != null) {
                            i = R.id.fee_engnr_head;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView3 != null) {
                                return new RowFeeEngineerBinding(materialCardView, linearLayout, materialCardView, materialButton, textView, textView2, materialCheckBox, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}