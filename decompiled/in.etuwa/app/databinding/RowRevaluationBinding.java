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
public final class RowRevaluationBinding implements ViewBinding {
    public final CardView answerScriptCv;
    public final CheckBox answerSheetCheckBox;
    public final LinearLayout dueLayout;
    public final TextView examGrade;
    public final TextView examSubHead;
    public final TextView examType;
    public final CheckBox revaluationCheckBox;
    public final CardView revaluationCv;
    private final CardView rootView;

    private RowRevaluationBinding(CardView rootView, CardView answerScriptCv, CheckBox answerSheetCheckBox, LinearLayout dueLayout, TextView examGrade, TextView examSubHead, TextView examType, CheckBox revaluationCheckBox, CardView revaluationCv) {
        this.rootView = rootView;
        this.answerScriptCv = answerScriptCv;
        this.answerSheetCheckBox = answerSheetCheckBox;
        this.dueLayout = dueLayout;
        this.examGrade = examGrade;
        this.examSubHead = examSubHead;
        this.examType = examType;
        this.revaluationCheckBox = revaluationCheckBox;
        this.revaluationCv = revaluationCv;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static RowRevaluationBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowRevaluationBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_revaluation, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowRevaluationBinding bind(View rootView) {
        int i = R.id.answer_script_cv;
        CardView cardView = (CardView) ViewBindings.findChildViewById(rootView, i);
        if (cardView != null) {
            i = R.id.answer_sheet_check_box;
            CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(rootView, i);
            if (checkBox != null) {
                i = R.id.due_layout;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                if (linearLayout != null) {
                    i = R.id.exam_grade;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView != null) {
                        i = R.id.exam_sub_head;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView2 != null) {
                            i = R.id.exam_type;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView3 != null) {
                                i = R.id.revaluation_check_box;
                                CheckBox checkBox2 = (CheckBox) ViewBindings.findChildViewById(rootView, i);
                                if (checkBox2 != null) {
                                    i = R.id.revaluation_cv;
                                    CardView cardView2 = (CardView) ViewBindings.findChildViewById(rootView, i);
                                    if (cardView2 != null) {
                                        return new RowRevaluationBinding((CardView) rootView, cardView, checkBox, linearLayout, textView, textView2, textView3, checkBox2, cardView2);
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