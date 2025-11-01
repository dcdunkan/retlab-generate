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
public final class RowHostelReceiptBinding implements ViewBinding {
    public final TextView hostelName;
    public final TextView hostelReceiptAmount;
    public final TextView hostelReceiptDate;
    public final TextView hostelReceiptNo;
    public final TextView receiptDownload;
    public final TextView receiptInstallment;
    private final LinearLayout rootView;

    private RowHostelReceiptBinding(LinearLayout rootView, TextView hostelName, TextView hostelReceiptAmount, TextView hostelReceiptDate, TextView hostelReceiptNo, TextView receiptDownload, TextView receiptInstallment) {
        this.rootView = rootView;
        this.hostelName = hostelName;
        this.hostelReceiptAmount = hostelReceiptAmount;
        this.hostelReceiptDate = hostelReceiptDate;
        this.hostelReceiptNo = hostelReceiptNo;
        this.receiptDownload = receiptDownload;
        this.receiptInstallment = receiptInstallment;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static RowHostelReceiptBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowHostelReceiptBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_hostel_receipt, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowHostelReceiptBinding bind(View rootView) {
        int i = R.id.hostel_name;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.hostel_receipt_amount;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.hostel_receipt_date;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView3 != null) {
                    i = R.id.hostel_receipt_no;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView4 != null) {
                        i = R.id.receipt_download;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView5 != null) {
                            i = R.id.receipt_installment;
                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView6 != null) {
                                return new RowHostelReceiptBinding((LinearLayout) rootView, textView, textView2, textView3, textView4, textView5, textView6);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}