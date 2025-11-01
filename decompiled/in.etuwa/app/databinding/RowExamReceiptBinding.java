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
public final class RowExamReceiptBinding implements ViewBinding {
    public final LinearLayout dueLayout;
    public final TextView receiptAmt;
    public final TextView receiptDate;
    public final TextView receiptDownload;
    public final TextView receiptNo;
    private final CardView rootView;

    private RowExamReceiptBinding(CardView rootView, LinearLayout dueLayout, TextView receiptAmt, TextView receiptDate, TextView receiptDownload, TextView receiptNo) {
        this.rootView = rootView;
        this.dueLayout = dueLayout;
        this.receiptAmt = receiptAmt;
        this.receiptDate = receiptDate;
        this.receiptDownload = receiptDownload;
        this.receiptNo = receiptNo;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static RowExamReceiptBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowExamReceiptBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_exam_receipt, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowExamReceiptBinding bind(View rootView) {
        int i = R.id.due_layout;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
        if (linearLayout != null) {
            i = R.id.receipt_amt;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                i = R.id.receipt_date;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView2 != null) {
                    i = R.id.receipt_download;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView3 != null) {
                        i = R.id.receipt_no;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView4 != null) {
                            return new RowExamReceiptBinding((CardView) rootView, linearLayout, textView, textView2, textView3, textView4);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}