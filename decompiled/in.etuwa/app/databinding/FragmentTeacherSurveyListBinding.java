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
import in.etuwa.app.ui.survey.teachersurvey.TeacherSurveyViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentTeacherSurveyListBinding extends ViewDataBinding {

    @Bindable
    protected TeacherSurveyViewModel mTeacherSurveyViewModel;
    public final RecyclerView rvTeacherSurvey;
    public final SwipeRefreshLayout swipeLayout;

    public abstract void setTeacherSurveyViewModel(TeacherSurveyViewModel teacherSurveyViewModel);

    protected FragmentTeacherSurveyListBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView rvTeacherSurvey, SwipeRefreshLayout swipeLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.rvTeacherSurvey = rvTeacherSurvey;
        this.swipeLayout = swipeLayout;
    }

    public TeacherSurveyViewModel getTeacherSurveyViewModel() {
        return this.mTeacherSurveyViewModel;
    }

    public static FragmentTeacherSurveyListBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentTeacherSurveyListBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentTeacherSurveyListBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_teacher_survey_list, root, attachToRoot, component);
    }

    public static FragmentTeacherSurveyListBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentTeacherSurveyListBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentTeacherSurveyListBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_teacher_survey_list, null, false, component);
    }

    public static FragmentTeacherSurveyListBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentTeacherSurveyListBinding bind(View view, Object component) {
        return (FragmentTeacherSurveyListBinding) bind(component, view, R.layout.fragment_teacher_survey_list);
    }
}