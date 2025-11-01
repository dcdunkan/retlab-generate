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
public final class RowDueBinding implements ViewBinding {
    public final TextView dueAdmissionNo;
    public final TextView dueAmount;
    public final TextView dueBatch;
    public final TextView dueHasDue;
    public final TextView dueHead;
    public final LinearLayout dueLayout;
    public final TextView dueStatus;
    private final CardView rootView;

    private RowDueBinding(CardView rootView, TextView dueAdmissionNo, TextView dueAmount, TextView dueBatch, TextView dueHasDue, TextView dueHead, LinearLayout dueLayout, TextView dueStatus) {
        this.rootView = rootView;
        this.dueAdmissionNo = dueAdmissionNo;
        this.dueAmount = dueAmount;
        this.dueBatch = dueBatch;
        this.dueHasDue = dueHasDue;
        this.dueHead = dueHead;
        this.dueLayout = dueLayout;
        this.dueStatus = dueStatus;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static RowDueBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowDueBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_due, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowDueBinding bind(View rootView) {
        int i = R.id.due_admission_no;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.due_amount;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.due_batch;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView3 != null) {
                    i = R.id.due_has_due;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView4 != null) {
                        i = R.id.due_head;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView5 != null) {
                            i = R.id.due_layout;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                            if (linearLayout != null) {
                                i = R.id.due_status;
                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView6 != null) {
                                    return new RowDueBinding((CardView) rootView, textView, textView2, textView3, textView4, textView5, linearLayout, textView6);
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