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
public final class RowHostelHistoryBinding implements ViewBinding {
    public final TextView hostelInstallment;
    public final TextView hostelMainAdjustment;
    public final TextView hostelMainAmount;
    public final TextView hostelMainBalance;
    public final TextView hostelMainPaid;
    public final MaterialCardView linearHost;
    private final MaterialCardView rootView;

    private RowHostelHistoryBinding(MaterialCardView rootView, TextView hostelInstallment, TextView hostelMainAdjustment, TextView hostelMainAmount, TextView hostelMainBalance, TextView hostelMainPaid, MaterialCardView linearHost) {
        this.rootView = rootView;
        this.hostelInstallment = hostelInstallment;
        this.hostelMainAdjustment = hostelMainAdjustment;
        this.hostelMainAmount = hostelMainAmount;
        this.hostelMainBalance = hostelMainBalance;
        this.hostelMainPaid = hostelMainPaid;
        this.linearHost = linearHost;
    }

    @Override // androidx.viewbinding.ViewBinding
    public MaterialCardView getRoot() {
        return this.rootView;
    }

    public static RowHostelHistoryBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowHostelHistoryBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.row_hostel_history, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
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
                            MaterialCardView materialCardView = (MaterialCardView) rootView;
                            return new RowHostelHistoryBinding(materialCardView, textView, textView2, textView3, textView4, textView5, materialCardView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}