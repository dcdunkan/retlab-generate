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
import in.etuwa.app.ui.survey.coursesurvey.subjects.CourseSurveySubjectsViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentCourseSurveySubjectsBinding extends ViewDataBinding {

    @Bindable
    protected CourseSurveySubjectsViewModel mCourseSurveySubjectsViewModel;
    public final RecyclerView rvSurvey;
    public final SwipeRefreshLayout swipeLayout;

    public abstract void setCourseSurveySubjectsViewModel(CourseSurveySubjectsViewModel courseSurveySubjectsViewModel);

    protected FragmentCourseSurveySubjectsBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView rvSurvey, SwipeRefreshLayout swipeLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.rvSurvey = rvSurvey;
        this.swipeLayout = swipeLayout;
    }

    public CourseSurveySubjectsViewModel getCourseSurveySubjectsViewModel() {
        return this.mCourseSurveySubjectsViewModel;
    }

    public static FragmentCourseSurveySubjectsBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentCourseSurveySubjectsBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentCourseSurveySubjectsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_course_survey_subjects, root, attachToRoot, component);
    }

    public static FragmentCourseSurveySubjectsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentCourseSurveySubjectsBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentCourseSurveySubjectsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_course_survey_subjects, null, false, component);
    }

    public static FragmentCourseSurveySubjectsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentCourseSurveySubjectsBinding bind(View view, Object component) {
        return (FragmentCourseSurveySubjectsBinding) bind(component, view, R.layout.fragment_course_survey_subjects);
    }
}