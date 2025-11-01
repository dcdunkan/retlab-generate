package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import in.etuwa.app.R;
import in.etuwa.app.ui.survey.graduateexit.questions.GraduateSurveyQuestionsViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentGraduateExitSurveyQuestionsBinding extends ViewDataBinding {

    @Bindable
    protected GraduateSurveyQuestionsViewModel mGraduateSurveyQuestionsViewModel;
    public final RecyclerView rvSurveyQuestions;
    public final TextView submitAnswer;

    public abstract void setGraduateSurveyQuestionsViewModel(GraduateSurveyQuestionsViewModel graduateSurveyQuestionsViewModel);

    protected FragmentGraduateExitSurveyQuestionsBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView rvSurveyQuestions, TextView submitAnswer) {
        super(_bindingComponent, _root, _localFieldCount);
        this.rvSurveyQuestions = rvSurveyQuestions;
        this.submitAnswer = submitAnswer;
    }

    public GraduateSurveyQuestionsViewModel getGraduateSurveyQuestionsViewModel() {
        return this.mGraduateSurveyQuestionsViewModel;
    }

    public static FragmentGraduateExitSurveyQuestionsBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentGraduateExitSurveyQuestionsBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentGraduateExitSurveyQuestionsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_graduate_exit_survey_questions, root, attachToRoot, component);
    }

    public static FragmentGraduateExitSurveyQuestionsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentGraduateExitSurveyQuestionsBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentGraduateExitSurveyQuestionsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_graduate_exit_survey_questions, null, false, component);
    }

    public static FragmentGraduateExitSurveyQuestionsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentGraduateExitSurveyQuestionsBinding bind(View view, Object component) {
        return (FragmentGraduateExitSurveyQuestionsBinding) bind(component, view, R.layout.fragment_graduate_exit_survey_questions);
    }
}