package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.etuwa.app.R;

/* loaded from: classes3.dex */
public final class RowQuizBinding implements ViewBinding {
    public final TextView quizBtn;
    public final TextView quizEndTime;
    public final TextView quizName;
    public final TextView quizStartTime;
    public final TextView quizText;
    public final TextView quizType;
    private final CardView rootView;

    private RowQuizBinding(CardView rootView, TextView quizBtn, TextView quizEndTime, TextView quizName, TextView quizStartTime, TextView quizText, TextView quizType) {
        this.rootView = rootView;
        this.quizBtn = quizBtn;
        this.quizEndTime = quizEndTime;
        this.quizName = quizName;
        this.quizStartTime = quizStartTime;
        this.quizText = quizText;
        this.quizType = quizType;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static RowQuizBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowQuizBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_quiz, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowQuizBinding bind(View rootView) {
        int i = R.id.quiz_btn;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.quiz_end_time;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.quiz_name;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView3 != null) {
                    i = R.id.quiz_start_time;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView4 != null) {
                        i = R.id.quiz_text;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView5 != null) {
                            i = R.id.quiz_type;
                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView6 != null) {
                                return new RowQuizBinding((CardView) rootView, textView, textView2, textView3, textView4, textView5, textView6);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}