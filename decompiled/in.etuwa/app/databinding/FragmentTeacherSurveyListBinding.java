package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.cardview.widget.CardView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import in.etuwa.app.R;
import in.etuwa.app.ui.survey.teachersurvey.TeacherSurveyViewModel;

/* JADX INFO: loaded from: classes3.dex */
public abstract class FragmentTeacherSurveyListBinding extends ViewDataBinding {
    public final AppBarLayout appBarLayout;
    public final Chip chipAll;
    public final Chip chipCompleted;
    public final ChipGroup chipGroupFilter;
    public final Chip chipPending;
    public final ImageView ivClearSearch;
    public final ImageView ivFilter;
    public final ImageView ivSearch;

    @Bindable
    protected TeacherSurveyViewModel mTeacherSurveyViewModel;
    public final RecyclerView rvTeacherSurvey;
    public final CardView searchCard;
    public final EditText searchInput;
    public final SwipeRefreshLayout swipeLayout;

    public abstract void setTeacherSurveyViewModel(TeacherSurveyViewModel teacherSurveyViewModel);

    protected FragmentTeacherSurveyListBinding(Object _bindingComponent, View _root, int _localFieldCount, AppBarLayout appBarLayout, Chip chipAll, Chip chipCompleted, ChipGroup chipGroupFilter, Chip chipPending, ImageView ivClearSearch, ImageView ivFilter, ImageView ivSearch, RecyclerView rvTeacherSurvey, CardView searchCard, EditText searchInput, SwipeRefreshLayout swipeLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.appBarLayout = appBarLayout;
        this.chipAll = chipAll;
        this.chipCompleted = chipCompleted;
        this.chipGroupFilter = chipGroupFilter;
        this.chipPending = chipPending;
        this.ivClearSearch = ivClearSearch;
        this.ivFilter = ivFilter;
        this.ivSearch = ivSearch;
        this.rvTeacherSurvey = rvTeacherSurvey;
        this.searchCard = searchCard;
        this.searchInput = searchInput;
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