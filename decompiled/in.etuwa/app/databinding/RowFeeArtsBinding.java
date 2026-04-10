package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.card.MaterialCardView;
import in.etuwa.app.R;

/* JADX INFO: loaded from: classes3.dex */
public final class RowFeeArtsBinding implements ViewBinding {
    public final TextView artsAmountLbl;
    public final TextView artsBalanceLbl;
    public final TextView artsFeeName;
    public final TextView artsPaidLbl;
    public final TextView artsPayableLbl;
    public final TextView artsScholorshipLbl;
    public final MaterialCardView linearArtsFee;
    private final MaterialCardView rootView;

    private RowFeeArtsBinding(MaterialCardView rootView, TextView artsAmountLbl, TextView artsBalanceLbl, TextView artsFeeName, TextView artsPaidLbl, TextView artsPayableLbl, TextView artsScholorshipLbl, MaterialCardView linearArtsFee) {
        this.rootView = rootView;
        this.artsAmountLbl = artsAmountLbl;
        this.artsBalanceLbl = artsBalanceLbl;
        this.artsFeeName = artsFeeName;
        this.artsPaidLbl = artsPaidLbl;
        this.artsPayableLbl = artsPayableLbl;
        this.artsScholorshipLbl = artsScholorshipLbl;
        this.linearArtsFee = linearArtsFee;
    }

    @Override // androidx.viewbinding.ViewBinding
    public MaterialCardView getRoot() {
        return this.rootView;
    }

    public static RowFeeArtsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowFeeArtsBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.row_fee_arts, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static RowFeeArtsBinding bind(View rootView) {
        int i = R.id.arts_amount_lbl;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.arts_balance_lbl;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.arts_fee_name;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView3 != null) {
                    i = R.id.arts_paid_lbl;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView4 != null) {
                        i = R.id.arts_payable_lbl;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView5 != null) {
                            i = R.id.arts_scholorship_lbl;
                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView6 != null) {
                                MaterialCardView materialCardView = (MaterialCardView) rootView;
                                return new RowFeeArtsBinding(materialCardView, textView, textView2, textView3, textView4, textView5, textView6, materialCardView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}