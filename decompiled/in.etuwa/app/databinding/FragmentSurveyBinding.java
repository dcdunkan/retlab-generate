package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import in.etuwa.app.R;
import in.etuwa.app.ui.survey.SurveyViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentSurveyBinding extends ViewDataBinding {
    public final TextView courseBtn;
    public final TextView graduateBtn;

    @Bindable
    protected SurveyViewModel mSurveyViewModel;
    public final TextView poSurveyBtn;
    public final RecyclerView rvSurvey;
    public final SwipeRefreshLayout swipeLayout;

    public abstract void setSurveyViewModel(SurveyViewModel surveyViewModel);

    protected FragmentSurveyBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView courseBtn, TextView graduateBtn, TextView poSurveyBtn, RecyclerView rvSurvey, SwipeRefreshLayout swipeLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.courseBtn = courseBtn;
        this.graduateBtn = graduateBtn;
        this.poSurveyBtn = poSurveyBtn;
        this.rvSurvey = rvSurvey;
        this.swipeLayout = swipeLayout;
    }

    public SurveyViewModel getSurveyViewModel() {
        return this.mSurveyViewModel;
    }

    public static FragmentSurveyBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSurveyBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentSurveyBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_survey, root, attachToRoot, component);
    }

    public static FragmentSurveyBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSurveyBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentSurveyBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_survey, null, false, component);
    }

    public static FragmentSurveyBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSurveyBinding bind(View view, Object component) {
        return (FragmentSurveyBinding) bind(component, view, R.layout.fragment_survey);
    }
}