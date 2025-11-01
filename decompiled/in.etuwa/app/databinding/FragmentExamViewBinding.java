package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import in.etuwa.app.R;
import in.etuwa.app.ui.examregistration.examsubjects.view.ExamViewViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentExamViewBinding extends ViewDataBinding {
    public final LinearLayout dueLayout;
    public final LinearLayout errorLyt;
    public final TextView errorTv;

    @Bindable
    protected ExamViewViewModel mExamViewViewModel;
    public final TextView paySlipBtn;
    public final TextView registerBtn;
    public final LinearLayout registerLayout;
    public final RecyclerView rvRegHistory;
    public final LinearLayout swipeLayout;
    public final TextView tvAcademicYear;
    public final TextView tvDegree;
    public final TextView tvEndDate;
    public final TextView tvMonth;
    public final TextView tvSemester;
    public final TextView tvStartDate;
    public final TextView tvSubName;
    public final TextView tvYear;
    public final TextView updationBtn;
    public final LinearLayout updationLayout;

    public abstract void setExamViewViewModel(ExamViewViewModel examViewViewModel);

    protected FragmentExamViewBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout dueLayout, LinearLayout errorLyt, TextView errorTv, TextView paySlipBtn, TextView registerBtn, LinearLayout registerLayout, RecyclerView rvRegHistory, LinearLayout swipeLayout, TextView tvAcademicYear, TextView tvDegree, TextView tvEndDate, TextView tvMonth, TextView tvSemester, TextView tvStartDate, TextView tvSubName, TextView tvYear, TextView updationBtn, LinearLayout updationLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.dueLayout = dueLayout;
        this.errorLyt = errorLyt;
        this.errorTv = errorTv;
        this.paySlipBtn = paySlipBtn;
        this.registerBtn = registerBtn;
        this.registerLayout = registerLayout;
        this.rvRegHistory = rvRegHistory;
        this.swipeLayout = swipeLayout;
        this.tvAcademicYear = tvAcademicYear;
        this.tvDegree = tvDegree;
        this.tvEndDate = tvEndDate;
        this.tvMonth = tvMonth;
        this.tvSemester = tvSemester;
        this.tvStartDate = tvStartDate;
        this.tvSubName = tvSubName;
        this.tvYear = tvYear;
        this.updationBtn = updationBtn;
        this.updationLayout = updationLayout;
    }

    public ExamViewViewModel getExamViewViewModel() {
        return this.mExamViewViewModel;
    }

    public static FragmentExamViewBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentExamViewBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentExamViewBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_exam_view, root, attachToRoot, component);
    }

    public static FragmentExamViewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentExamViewBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentExamViewBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_exam_view, null, false, component);
    }

    public static FragmentExamViewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentExamViewBinding bind(View view, Object component) {
        return (FragmentExamViewBinding) bind(component, view, R.layout.fragment_exam_view);
    }
}