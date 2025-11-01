package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import in.etuwa.app.R;
import in.etuwa.app.ui.newquiz.questions.QuizQuestionsViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentQuizQuestionsBinding extends ViewDataBinding {
    public final TextView backBtn;
    public final LinearLayout completionCard;
    public final TextView completionFileName;
    public final TextView completionSelect;
    public final TextView completionUpload;
    public final LinearLayout descriptiveAnswerLyt;
    public final TextInputEditText etDescriptive;
    public final TextView finishBtn;

    @Bindable
    protected QuizQuestionsViewModel mQuizQuestionsViewModel;
    public final TextInputLayout mtDescriptive;
    public final LinearLayout multipleAnswerLyt;
    public final TextView nextBtn;
    public final RadioButton option1;
    public final RadioButton option2;
    public final RadioButton option3;
    public final RadioButton option4;
    public final RadioButton option5;
    public final TextView progressText;
    public final CardView progressView;
    public final ImageView questionImage;
    public final TextView quizQuestion;
    public final TextView quizQuestionNo;
    public final RadioGroup quizQuestionsMultiple;
    public final ProgressBar uploadProgressbar;

    public abstract void setQuizQuestionsViewModel(QuizQuestionsViewModel quizQuestionsViewModel);

    protected FragmentQuizQuestionsBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView backBtn, LinearLayout completionCard, TextView completionFileName, TextView completionSelect, TextView completionUpload, LinearLayout descriptiveAnswerLyt, TextInputEditText etDescriptive, TextView finishBtn, TextInputLayout mtDescriptive, LinearLayout multipleAnswerLyt, TextView nextBtn, RadioButton option1, RadioButton option2, RadioButton option3, RadioButton option4, RadioButton option5, TextView progressText, CardView progressView, ImageView questionImage, TextView quizQuestion, TextView quizQuestionNo, RadioGroup quizQuestionsMultiple, ProgressBar uploadProgressbar) {
        super(_bindingComponent, _root, _localFieldCount);
        this.backBtn = backBtn;
        this.completionCard = completionCard;
        this.completionFileName = completionFileName;
        this.completionSelect = completionSelect;
        this.completionUpload = completionUpload;
        this.descriptiveAnswerLyt = descriptiveAnswerLyt;
        this.etDescriptive = etDescriptive;
        this.finishBtn = finishBtn;
        this.mtDescriptive = mtDescriptive;
        this.multipleAnswerLyt = multipleAnswerLyt;
        this.nextBtn = nextBtn;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.option5 = option5;
        this.progressText = progressText;
        this.progressView = progressView;
        this.questionImage = questionImage;
        this.quizQuestion = quizQuestion;
        this.quizQuestionNo = quizQuestionNo;
        this.quizQuestionsMultiple = quizQuestionsMultiple;
        this.uploadProgressbar = uploadProgressbar;
    }

    public QuizQuestionsViewModel getQuizQuestionsViewModel() {
        return this.mQuizQuestionsViewModel;
    }

    public static FragmentQuizQuestionsBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentQuizQuestionsBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentQuizQuestionsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_quiz_questions, root, attachToRoot, component);
    }

    public static FragmentQuizQuestionsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentQuizQuestionsBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentQuizQuestionsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_quiz_questions, null, false, component);
    }

    public static FragmentQuizQuestionsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentQuizQuestionsBinding bind(View view, Object component) {
        return (FragmentQuizQuestionsBinding) bind(component, view, R.layout.fragment_quiz_questions);
    }
}