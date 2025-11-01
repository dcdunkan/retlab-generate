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
public final class RowExamViewBinding implements ViewBinding {
    public final LinearLayout amountLyt;
    public final LinearLayout dueLayout;
    public final TextView examAmount;
    public final TextView examConcession;
    public final TextView examSubHead;
    public final TextView examType;
    private final LinearLayout rootView;

    private RowExamViewBinding(LinearLayout rootView, LinearLayout amountLyt, LinearLayout dueLayout, TextView examAmount, TextView examConcession, TextView examSubHead, TextView examType) {
        this.rootView = rootView;
        this.amountLyt = amountLyt;
        this.dueLayout = dueLayout;
        this.examAmount = examAmount;
        this.examConcession = examConcession;
        this.examSubHead = examSubHead;
        this.examType = examType;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static RowExamViewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowExamViewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_exam_view, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowExamViewBinding bind(View rootView) {
        int i = R.id.amount_lyt;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
        if (linearLayout != null) {
            i = R.id.due_layout;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
            if (linearLayout2 != null) {
                i = R.id.exam_amount;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView != null) {
                    i = R.id.exam_concession;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView2 != null) {
                        i = R.id.exam_sub_head;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView3 != null) {
                            i = R.id.exam_type;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView4 != null) {
                                return new RowExamViewBinding((LinearLayout) rootView, linearLayout, linearLayout2, textView, textView2, textView3, textView4);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}