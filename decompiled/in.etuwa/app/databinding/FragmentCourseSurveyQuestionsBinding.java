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
import in.etuwa.app.ui.survey.coursesurvey.questions.CourseSurveyQuestionsViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentCourseSurveyQuestionsBinding extends ViewDataBinding {

    @Bindable
    protected CourseSurveyQuestionsViewModel mCourseSurveyQuestionsViewModel;
    public final RecyclerView rvSurveyQuestions;
    public final TextView submitAnswer;

    public abstract void setCourseSurveyQuestionsViewModel(CourseSurveyQuestionsViewModel courseSurveyQuestionsViewModel);

    protected FragmentCourseSurveyQuestionsBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView rvSurveyQuestions, TextView submitAnswer) {
        super(_bindingComponent, _root, _localFieldCount);
        this.rvSurveyQuestions = rvSurveyQuestions;
        this.submitAnswer = submitAnswer;
    }

    public CourseSurveyQuestionsViewModel getCourseSurveyQuestionsViewModel() {
        return this.mCourseSurveyQuestionsViewModel;
    }

    public static FragmentCourseSurveyQuestionsBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentCourseSurveyQuestionsBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentCourseSurveyQuestionsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_course_survey_questions, root, attachToRoot, component);
    }

    public static FragmentCourseSurveyQuestionsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentCourseSurveyQuestionsBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentCourseSurveyQuestionsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_course_survey_questions, null, false, component);
    }

    public static FragmentCourseSurveyQuestionsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentCourseSurveyQuestionsBinding bind(View view, Object component) {
        return (FragmentCourseSurveyQuestionsBinding) bind(component, view, R.layout.fragment_course_survey_questions);
    }
}