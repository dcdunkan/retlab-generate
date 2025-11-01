package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.etuwa.app.R;

/* loaded from: classes3.dex */
public final class RowCourseSurveyQuestionsBinding implements ViewBinding {
    public final LinearLayout multipleAnswerLyt;
    public final RadioButton option1;
    public final RadioButton option2;
    public final RadioButton option3;
    public final RadioButton option4;
    public final RadioButton option5;
    public final RadioGroup radioBtn;
    public final TextView requiredTv;
    private final FrameLayout rootView;
    public final TextView teacherSurveyQuestion;
    public final TextView teacherSurveyQuestionNo;

    private RowCourseSurveyQuestionsBinding(FrameLayout rootView, LinearLayout multipleAnswerLyt, RadioButton option1, RadioButton option2, RadioButton option3, RadioButton option4, RadioButton option5, RadioGroup radioBtn, TextView requiredTv, TextView teacherSurveyQuestion, TextView teacherSurveyQuestionNo) {
        this.rootView = rootView;
        this.multipleAnswerLyt = multipleAnswerLyt;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.option5 = option5;
        this.radioBtn = radioBtn;
        this.requiredTv = requiredTv;
        this.teacherSurveyQuestion = teacherSurveyQuestion;
        this.teacherSurveyQuestionNo = teacherSurveyQuestionNo;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static RowCourseSurveyQuestionsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowCourseSurveyQuestionsBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_course_survey_questions, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowCourseSurveyQuestionsBinding bind(View rootView) {
        int i = R.id.multiple_answer_lyt;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
        if (linearLayout != null) {
            i = R.id.option_1;
            RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(rootView, i);
            if (radioButton != null) {
                i = R.id.option_2;
                RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(rootView, i);
                if (radioButton2 != null) {
                    i = R.id.option_3;
                    RadioButton radioButton3 = (RadioButton) ViewBindings.findChildViewById(rootView, i);
                    if (radioButton3 != null) {
                        i = R.id.option_4;
                        RadioButton radioButton4 = (RadioButton) ViewBindings.findChildViewById(rootView, i);
                        if (radioButton4 != null) {
                            i = R.id.option_5;
                            RadioButton radioButton5 = (RadioButton) ViewBindings.findChildViewById(rootView, i);
                            if (radioButton5 != null) {
                                i = R.id.radio_btn;
                                RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(rootView, i);
                                if (radioGroup != null) {
                                    i = R.id.required_tv;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView != null) {
                                        i = R.id.teacher_survey_question;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                        if (textView2 != null) {
                                            i = R.id.teacher_survey_question_no;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                            if (textView3 != null) {
                                                return new RowCourseSurveyQuestionsBinding((FrameLayout) rootView, linearLayout, radioButton, radioButton2, radioButton3, radioButton4, radioButton5, radioGroup, textView, textView2, textView3);
                                            }
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