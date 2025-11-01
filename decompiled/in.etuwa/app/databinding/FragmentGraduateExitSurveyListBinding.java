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
import in.etuwa.app.ui.survey.graduateexit.GraduateExitSurveyViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentGraduateExitSurveyListBinding extends ViewDataBinding {

    @Bindable
    protected GraduateExitSurveyViewModel mGraduateExitSurveyViewModel;
    public final RecyclerView rvSurvey;
    public final SwipeRefreshLayout swipeLayout;

    public abstract void setGraduateExitSurveyViewModel(GraduateExitSurveyViewModel graduateExitSurveyViewModel);

    protected FragmentGraduateExitSurveyListBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView rvSurvey, SwipeRefreshLayout swipeLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.rvSurvey = rvSurvey;
        this.swipeLayout = swipeLayout;
    }

    public GraduateExitSurveyViewModel getGraduateExitSurveyViewModel() {
        return this.mGraduateExitSurveyViewModel;
    }

    public static FragmentGraduateExitSurveyListBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentGraduateExitSurveyListBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentGraduateExitSurveyListBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_graduate_exit_survey_list, root, attachToRoot, component);
    }

    public static FragmentGraduateExitSurveyListBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentGraduateExitSurveyListBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentGraduateExitSurveyListBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_graduate_exit_survey_list, null, false, component);
    }

    public static FragmentGraduateExitSurveyListBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentGraduateExitSurveyListBinding bind(View view, Object component) {
        return (FragmentGraduateExitSurveyListBinding) bind(component, view, R.layout.fragment_graduate_exit_survey_list);
    }
}