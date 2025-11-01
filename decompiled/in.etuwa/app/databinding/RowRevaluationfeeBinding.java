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
public final class RowRevaluationfeeBinding implements ViewBinding {
    public final LinearLayout answetLt;
    public final LinearLayout dueLayout;
    public final TextView examRevaluationAmnt;
    public final TextView examScriptAmnt;
    public final TextView examSubHead;
    public final LinearLayout revaluationLt;
    private final CardView rootView;

    private RowRevaluationfeeBinding(CardView rootView, LinearLayout answetLt, LinearLayout dueLayout, TextView examRevaluationAmnt, TextView examScriptAmnt, TextView examSubHead, LinearLayout revaluationLt) {
        this.rootView = rootView;
        this.answetLt = answetLt;
        this.dueLayout = dueLayout;
        this.examRevaluationAmnt = examRevaluationAmnt;
        this.examScriptAmnt = examScriptAmnt;
        this.examSubHead = examSubHead;
        this.revaluationLt = revaluationLt;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static RowRevaluationfeeBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowRevaluationfeeBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_revaluationfee, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowRevaluationfeeBinding bind(View rootView) {
        int i = R.id.answet_lt;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
        if (linearLayout != null) {
            i = R.id.due_layout;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
            if (linearLayout2 != null) {
                i = R.id.exam_revaluation_amnt;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView != null) {
                    i = R.id.exam_script_amnt;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView2 != null) {
                        i = R.id.exam_sub_head;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView3 != null) {
                            i = R.id.revaluation_lt;
                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                            if (linearLayout3 != null) {
                                return new RowRevaluationfeeBinding((CardView) rootView, linearLayout, linearLayout2, textView, textView2, textView3, linearLayout3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}