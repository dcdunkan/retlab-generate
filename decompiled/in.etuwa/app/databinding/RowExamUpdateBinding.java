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
public final class RowExamUpdateBinding implements ViewBinding {
    public final LinearLayout amountLyt;
    public final LinearLayout dueLayout;
    public final TextView examAmount;
    public final CheckBox examCheckBox;
    public final TextView examConcession;
    public final TextView examMsg;
    public final TextView examSubHead;
    public final TextView examType;
    private final LinearLayout rootView;
    public final LinearLayout statusLyt;

    private RowExamUpdateBinding(LinearLayout rootView, LinearLayout amountLyt, LinearLayout dueLayout, TextView examAmount, CheckBox examCheckBox, TextView examConcession, TextView examMsg, TextView examSubHead, TextView examType, LinearLayout statusLyt) {
        this.rootView = rootView;
        this.amountLyt = amountLyt;
        this.dueLayout = dueLayout;
        this.examAmount = examAmount;
        this.examCheckBox = examCheckBox;
        this.examConcession = examConcession;
        this.examMsg = examMsg;
        this.examSubHead = examSubHead;
        this.examType = examType;
        this.statusLyt = statusLyt;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static RowExamUpdateBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowExamUpdateBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_exam_update, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowExamUpdateBinding bind(View rootView) {
        int i = R.id.amount_lyt;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
        if (linearLayout != null) {
            i = R.id.due_layout;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
            if (linearLayout2 != null) {
                i = R.id.exam_amount;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView != null) {
                    i = R.id.exam_check_box;
                    CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(rootView, i);
                    if (checkBox != null) {
                        i = R.id.exam_concession;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView2 != null) {
                            i = R.id.exam_msg;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView3 != null) {
                                i = R.id.exam_sub_head;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView4 != null) {
                                    i = R.id.exam_type;
                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView5 != null) {
                                        i = R.id.status_lyt;
                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                        if (linearLayout3 != null) {
                                            return new RowExamUpdateBinding((LinearLayout) rootView, linearLayout, linearLayout2, textView, checkBox, textView2, textView3, textView4, textView5, linearLayout3);
                                        }
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