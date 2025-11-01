package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import in.etuwa.app.R;
import in.etuwa.app.ui.survey.coursesurvey.CourseEvaluationSurveyViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentCourseSurveyBinding extends ViewDataBinding {

    @Bindable
    protected CourseEvaluationSurveyViewModel mSurveyViewModel;
    public final RecyclerView rvSurvey;
    public final SwipeRefreshLayout swipeLayout;

    public abstract void setSurveyViewModel(CourseEvaluationSurveyViewModel surveyViewModel);

    protected FragmentCourseSurveyBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView rvSurvey, SwipeRefreshLayout swipeLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.rvSurvey = rvSurvey;
        this.swipeLayout = swipeLayout;
    }

    public CourseEvaluationSurveyViewModel getSurveyViewModel() {
        return this.mSurveyViewModel;
    }

    public static FragmentCourseSurveyBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentCourseSurveyBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentCourseSurveyBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_course_survey, root, attachToRoot, component);
    }

    public static FragmentCourseSurveyBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentCourseSurveyBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentCourseSurveyBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_course_survey, null, false, component);
    }

    public static FragmentCourseSurveyBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentCourseSurveyBinding bind(View view, Object component) {
        return (FragmentCourseSurveyBinding) bind(component, view, R.layout.fragment_course_survey);
    }
}