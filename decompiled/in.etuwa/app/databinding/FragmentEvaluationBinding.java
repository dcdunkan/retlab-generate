package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import in.etuwa.app.R;
import in.etuwa.app.ui.evaluation.EvaluationViewModel;

/* JADX INFO: loaded from: classes3.dex */
public abstract class FragmentEvaluationBinding extends ViewDataBinding {
    public final TextView allBtn;
    public final CardView assignmentBtnLyt;
    public final TextView assignmentsBtn;
    public final TextView homeworksBtn;
    public final HorizontalScrollView hrView;
    public final ImageView ivClearSearch;
    public final ImageView ivFilter;
    public final ImageView ivSearch;

    @Bindable
    protected EvaluationViewModel mEvaluationViewModel;
    public final LinearLayout mainLyt;
    public final TextView moduleBtn;
    public final TextView notSubmitBtn;
    public final RecyclerView rvAssignments;
    public final RecyclerView rvHomeworks;
    public final RecyclerView rvModuletest;
    public final RecyclerView rvSeriesExam;
    public final RecyclerView rvTutorial;
    public final CardView searchCard;
    public final EditText searchInput;
    public final TextView seriesBtn;
    public final TextView submitBtn;
    public final TextView toolbar;
    public final TextView tutorialsBtn;

    public abstract void setEvaluationViewModel(EvaluationViewModel evaluationViewModel);

    protected FragmentEvaluationBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView allBtn, CardView assignmentBtnLyt, TextView assignmentsBtn, TextView homeworksBtn, HorizontalScrollView hrView, ImageView ivClearSearch, ImageView ivFilter, ImageView ivSearch, LinearLayout mainLyt, TextView moduleBtn, TextView notSubmitBtn, RecyclerView rvAssignments, RecyclerView rvHomeworks, RecyclerView rvModuletest, RecyclerView rvSeriesExam, RecyclerView rvTutorial, CardView searchCard, EditText searchInput, TextView seriesBtn, TextView submitBtn, TextView toolbar, TextView tutorialsBtn) {
        super(_bindingComponent, _root, _localFieldCount);
        this.allBtn = allBtn;
        this.assignmentBtnLyt = assignmentBtnLyt;
        this.assignmentsBtn = assignmentsBtn;
        this.homeworksBtn = homeworksBtn;
        this.hrView = hrView;
        this.ivClearSearch = ivClearSearch;
        this.ivFilter = ivFilter;
        this.ivSearch = ivSearch;
        this.mainLyt = mainLyt;
        this.moduleBtn = moduleBtn;
        this.notSubmitBtn = notSubmitBtn;
        this.rvAssignments = rvAssignments;
        this.rvHomeworks = rvHomeworks;
        this.rvModuletest = rvModuletest;
        this.rvSeriesExam = rvSeriesExam;
        this.rvTutorial = rvTutorial;
        this.searchCard = searchCard;
        this.searchInput = searchInput;
        this.seriesBtn = seriesBtn;
        this.submitBtn = submitBtn;
        this.toolbar = toolbar;
        this.tutorialsBtn = tutorialsBtn;
    }

    public EvaluationViewModel getEvaluationViewModel() {
        return this.mEvaluationViewModel;
    }

    public static FragmentEvaluationBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentEvaluationBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentEvaluationBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_evaluation, root, attachToRoot, component);
    }

    public static FragmentEvaluationBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentEvaluationBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentEvaluationBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_evaluation, null, false, component);
    }

    public static FragmentEvaluationBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentEvaluationBinding bind(View view, Object component) {
        return (FragmentEvaluationBinding) bind(component, view, R.layout.fragment_evaluation);
    }
}