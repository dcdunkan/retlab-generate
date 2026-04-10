package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.card.MaterialCardView;
import in.etuwa.app.R;

/* JADX INFO: loaded from: classes3.dex */
public final class QuizDescriptiveResultItemModernBinding implements ViewBinding {
    public final LinearLayout answerContainer;
    public final TextView attendanceStatus;
    public final TextView markObtained;
    public final TextView notAnsweredText;
    public final TextView questionContent;
    public final TextView questionNo;
    private final MaterialCardView rootView;
    public final TextView studentAnswer;

    private QuizDescriptiveResultItemModernBinding(MaterialCardView rootView, LinearLayout answerContainer, TextView attendanceStatus, TextView markObtained, TextView notAnsweredText, TextView questionContent, TextView questionNo, TextView studentAnswer) {
        this.rootView = rootView;
        this.answerContainer = answerContainer;
        this.attendanceStatus = attendanceStatus;
        this.markObtained = markObtained;
        this.notAnsweredText = notAnsweredText;
        this.questionContent = questionContent;
        this.questionNo = questionNo;
        this.studentAnswer = studentAnswer;
    }

    @Override // androidx.viewbinding.ViewBinding
    public MaterialCardView getRoot() {
        return this.rootView;
    }

    public static QuizDescriptiveResultItemModernBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static QuizDescriptiveResultItemModernBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.quiz_descriptive_result_item_modern, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static QuizDescriptiveResultItemModernBinding bind(View rootView) {
        int i = R.id.answer_container;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
        if (linearLayout != null) {
            i = R.id.attendance_status;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                i = R.id.mark_obtained;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView2 != null) {
                    i = R.id.not_answered_text;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView3 != null) {
                        i = R.id.question_content;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView4 != null) {
                            i = R.id.question_no;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView5 != null) {
                                i = R.id.student_answer;
                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView6 != null) {
                                    return new QuizDescriptiveResultItemModernBinding((MaterialCardView) rootView, linearLayout, textView, textView2, textView3, textView4, textView5, textView6);
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