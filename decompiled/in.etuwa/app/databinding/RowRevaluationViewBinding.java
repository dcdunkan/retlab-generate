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
public final class RowRevaluationViewBinding implements ViewBinding {
    public final LinearLayout answetLt;
    public final LinearLayout dueLayout;
    public final TextView examRevaluationAmnt;
    public final TextView examRevaluationType;
    public final TextView examScriptAmnt;
    public final TextView examSubHead;
    public final TextView receiptBtn;
    public final LinearLayout revaluationLt;
    private final CardView rootView;
    public final LinearLayout typeLt;

    private RowRevaluationViewBinding(CardView rootView, LinearLayout answetLt, LinearLayout dueLayout, TextView examRevaluationAmnt, TextView examRevaluationType, TextView examScriptAmnt, TextView examSubHead, TextView receiptBtn, LinearLayout revaluationLt, LinearLayout typeLt) {
        this.rootView = rootView;
        this.answetLt = answetLt;
        this.dueLayout = dueLayout;
        this.examRevaluationAmnt = examRevaluationAmnt;
        this.examRevaluationType = examRevaluationType;
        this.examScriptAmnt = examScriptAmnt;
        this.examSubHead = examSubHead;
        this.receiptBtn = receiptBtn;
        this.revaluationLt = revaluationLt;
        this.typeLt = typeLt;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static RowRevaluationViewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowRevaluationViewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_revaluation_view, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowRevaluationViewBinding bind(View rootView) {
        int i = R.id.answet_lt;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
        if (linearLayout != null) {
            i = R.id.due_layout;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
            if (linearLayout2 != null) {
                i = R.id.exam_revaluation_amnt;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView != null) {
                    i = R.id.exam_revaluation_type;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView2 != null) {
                        i = R.id.exam_script_amnt;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView3 != null) {
                            i = R.id.exam_sub_head;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView4 != null) {
                                i = R.id.receipt_btn;
                                TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView5 != null) {
                                    i = R.id.revaluation_lt;
                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                    if (linearLayout3 != null) {
                                        i = R.id.type_lt;
                                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                        if (linearLayout4 != null) {
                                            return new RowRevaluationViewBinding((CardView) rootView, linearLayout, linearLayout2, textView, textView2, textView3, textView4, textView5, linearLayout3, linearLayout4);
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