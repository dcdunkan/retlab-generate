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
import in.etuwa.app.ui.survey.posurvey.questions.POSurveyQuestionsViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentPoSurveyQuestionsBinding extends ViewDataBinding {

    @Bindable
    protected POSurveyQuestionsViewModel mPoSurveyQuestionsViewModel;
    public final RecyclerView rvSurveyQuestions;
    public final TextView submitAnswer;

    public abstract void setPoSurveyQuestionsViewModel(POSurveyQuestionsViewModel poSurveyQuestionsViewModel);

    protected FragmentPoSurveyQuestionsBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView rvSurveyQuestions, TextView submitAnswer) {
        super(_bindingComponent, _root, _localFieldCount);
        this.rvSurveyQuestions = rvSurveyQuestions;
        this.submitAnswer = submitAnswer;
    }

    public POSurveyQuestionsViewModel getPoSurveyQuestionsViewModel() {
        return this.mPoSurveyQuestionsViewModel;
    }

    public static FragmentPoSurveyQuestionsBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentPoSurveyQuestionsBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentPoSurveyQuestionsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_po_survey_questions, root, attachToRoot, component);
    }

    public static FragmentPoSurveyQuestionsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentPoSurveyQuestionsBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentPoSurveyQuestionsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_po_survey_questions, null, false, component);
    }

    public static FragmentPoSurveyQuestionsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentPoSurveyQuestionsBinding bind(View view, Object component) {
        return (FragmentPoSurveyQuestionsBinding) bind(component, view, R.layout.fragment_po_survey_questions);
    }
}