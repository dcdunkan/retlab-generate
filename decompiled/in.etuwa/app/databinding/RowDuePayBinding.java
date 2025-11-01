package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.etuwa.app.R;

/* loaded from: classes3.dex */
public final class RowDuePayBinding implements ViewBinding {
    public final CheckBox dueCheckBox;
    public final LinearLayout dueLayout;
    public final TextView duePayAmt;
    public final TextView duePayBalance;
    public final TextView duePayHead;
    public final TextView duePayStat;
    private final CardView rootView;

    private RowDuePayBinding(CardView rootView, CheckBox dueCheckBox, LinearLayout dueLayout, TextView duePayAmt, TextView duePayBalance, TextView duePayHead, TextView duePayStat) {
        this.rootView = rootView;
        this.dueCheckBox = dueCheckBox;
        this.dueLayout = dueLayout;
        this.duePayAmt = duePayAmt;
        this.duePayBalance = duePayBalance;
        this.duePayHead = duePayHead;
        this.duePayStat = duePayStat;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static RowDuePayBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowDuePayBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_due_pay, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowDuePayBinding bind(View rootView) {
        int i = R.id.due_check_box;
        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(rootView, i);
        if (checkBox != null) {
            i = R.id.due_layout;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
            if (linearLayout != null) {
                i = R.id.due_pay_amt;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView != null) {
                    i = R.id.due_pay_balance;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView2 != null) {
                        i = R.id.due_pay_head;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView3 != null) {
                            i = R.id.due_pay_stat;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView4 != null) {
                                return new RowDuePayBinding((CardView) rootView, checkBox, linearLayout, textView, textView2, textView3, textView4);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}