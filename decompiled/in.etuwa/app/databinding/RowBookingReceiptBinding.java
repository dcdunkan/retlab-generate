package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.etuwa.app.R;

/* loaded from: classes3.dex */
public final class RowBookingReceiptBinding implements ViewBinding {
    public final TextView preBookBtn;
    private final CardView rootView;
    public final TextView tvCreateDate;
    public final TextView tvPaymentMethod;
    public final TextView tvProcessedBy;
    public final TextView tvReceiptDate;
    public final TextView tvReceiptNo;
    public final TextView tvStatus;
    public final TextView tvTotal;

    private RowBookingReceiptBinding(CardView rootView, TextView preBookBtn, TextView tvCreateDate, TextView tvPaymentMethod, TextView tvProcessedBy, TextView tvReceiptDate, TextView tvReceiptNo, TextView tvStatus, TextView tvTotal) {
        this.rootView = rootView;
        this.preBookBtn = preBookBtn;
        this.tvCreateDate = tvCreateDate;
        this.tvPaymentMethod = tvPaymentMethod;
        this.tvProcessedBy = tvProcessedBy;
        this.tvReceiptDate = tvReceiptDate;
        this.tvReceiptNo = tvReceiptNo;
        this.tvStatus = tvStatus;
        this.tvTotal = tvTotal;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static RowBookingReceiptBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowBookingReceiptBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_booking_receipt, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowBookingReceiptBinding bind(View rootView) {
        int i = R.id.pre_book_btn;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.tv_create_date;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.tv_payment_method;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView3 != null) {
                    i = R.id.tv_processed_by;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView4 != null) {
                        i = R.id.tv_receipt_date;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView5 != null) {
                            i = R.id.tv_receipt_no;
                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView6 != null) {
                                i = R.id.tv_status;
                                TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView7 != null) {
                                    i = R.id.tv_total;
                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView8 != null) {
                                        return new RowBookingReceiptBinding((CardView) rootView, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8);
                                    }
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