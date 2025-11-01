package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.etuwa.app.R;

/* loaded from: classes3.dex */
public final class RowTransportReceiptBinding implements ViewBinding {
    public final LinearLayout linearArtsFee;
    public final TextView receiptAmount;
    public final TextView receiptDate;
    public final TextView receiptNo;
    public final TextView receiptPayMethod;
    public final TextView receiptStatus;
    private final CardView rootView;

    private RowTransportReceiptBinding(CardView rootView, LinearLayout linearArtsFee, TextView receiptAmount, TextView receiptDate, TextView receiptNo, TextView receiptPayMethod, TextView receiptStatus) {
        this.rootView = rootView;
        this.linearArtsFee = linearArtsFee;
        this.receiptAmount = receiptAmount;
        this.receiptDate = receiptDate;
        this.receiptNo = receiptNo;
        this.receiptPayMethod = receiptPayMethod;
        this.receiptStatus = receiptStatus;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static RowTransportReceiptBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowTransportReceiptBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_transport_receipt, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowTransportReceiptBinding bind(View rootView) {
        int i = R.id.linearArtsFee;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
        if (linearLayout != null) {
            i = R.id.receipt_amount;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                i = R.id.receipt_date;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView2 != null) {
                    i = R.id.receipt_no;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView3 != null) {
                        i = R.id.receipt_pay_method;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView4 != null) {
                            i = R.id.receipt_status;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView5 != null) {
                                return new RowTransportReceiptBinding((CardView) rootView, linearLayout, textView, textView2, textView3, textView4, textView5);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}