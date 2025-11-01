package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.etuwa.app.R;

/* loaded from: classes3.dex */
public final class RowPoSurveyQuestionsBinding implements ViewBinding {
    public final CardView cardSurvey;
    public final RadioButton check1;
    public final RadioButton check2;
    public final RadioButton check3;
    public final RadioButton check4;
    public final RadioButton check5;
    public final TextView option1;
    public final TextView option2;
    public final TextView option3;
    public final TextView option4;
    public final TextView option5;
    public final LinearLayout questionLyt1;
    public final LinearLayout questionLyt2;
    public final LinearLayout questionLyt3;
    public final LinearLayout questionLyt4;
    public final LinearLayout questionLyt5;
    public final TextView questionNo;
    public final TextView questionTv;
    private final CardView rootView;

    private RowPoSurveyQuestionsBinding(CardView rootView, CardView cardSurvey, RadioButton check1, RadioButton check2, RadioButton check3, RadioButton check4, RadioButton check5, TextView option1, TextView option2, TextView option3, TextView option4, TextView option5, LinearLayout questionLyt1, LinearLayout questionLyt2, LinearLayout questionLyt3, LinearLayout questionLyt4, LinearLayout questionLyt5, TextView questionNo, TextView questionTv) {
        this.rootView = rootView;
        this.cardSurvey = cardSurvey;
        this.check1 = check1;
        this.check2 = check2;
        this.check3 = check3;
        this.check4 = check4;
        this.check5 = check5;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.option5 = option5;
        this.questionLyt1 = questionLyt1;
        this.questionLyt2 = questionLyt2;
        this.questionLyt3 = questionLyt3;
        this.questionLyt4 = questionLyt4;
        this.questionLyt5 = questionLyt5;
        this.questionNo = questionNo;
        this.questionTv = questionTv;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static RowPoSurveyQuestionsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowPoSurveyQuestionsBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_po_survey_questions, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowPoSurveyQuestionsBinding bind(View rootView) {
        CardView cardView = (CardView) rootView;
        int i = R.id.check_1;
        RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(rootView, i);
        if (radioButton != null) {
            i = R.id.check_2;
            RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(rootView, i);
            if (radioButton2 != null) {
                i = R.id.check_3;
                RadioButton radioButton3 = (RadioButton) ViewBindings.findChildViewById(rootView, i);
                if (radioButton3 != null) {
                    i = R.id.check_4;
                    RadioButton radioButton4 = (RadioButton) ViewBindings.findChildViewById(rootView, i);
                    if (radioButton4 != null) {
                        i = R.id.check_5;
                        RadioButton radioButton5 = (RadioButton) ViewBindings.findChildViewById(rootView, i);
                        if (radioButton5 != null) {
                            i = R.id.option_1;
                            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView != null) {
                                i = R.id.option_2;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView2 != null) {
                                    i = R.id.option_3;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView3 != null) {
                                        i = R.id.option_4;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                        if (textView4 != null) {
                                            i = R.id.option_5;
                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                            if (textView5 != null) {
                                                i = R.id.question_lyt_1;
                                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                if (linearLayout != null) {
                                                    i = R.id.question_lyt_2;
                                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                    if (linearLayout2 != null) {
                                                        i = R.id.question_lyt_3;
                                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                        if (linearLayout3 != null) {
                                                            i = R.id.question_lyt_4;
                                                            LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                            if (linearLayout4 != null) {
                                                                i = R.id.question_lyt_5;
                                                                LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                                if (linearLayout5 != null) {
                                                                    i = R.id.question_no;
                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                    if (textView6 != null) {
                                                                        i = R.id.question_tv;
                                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                        if (textView7 != null) {
                                                                            return new RowPoSurveyQuestionsBinding(cardView, cardView, radioButton, radioButton2, radioButton3, radioButton4, radioButton5, textView, textView2, textView3, textView4, textView5, linearLayout, linearLayout2, linearLayout3, linearLayout4, linearLayout5, textView6, textView7);
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