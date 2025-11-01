package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import in.etuwa.app.R;
import in.etuwa.app.ui.examregistration.examsubjects.detaildialog.ExamSubjectDetailViewModel;

/* loaded from: classes3.dex */
public abstract class DialogExamSubjectDetailsBinding extends ViewDataBinding {
    public final LinearLayout dueLayout;

    @Bindable
    protected ExamSubjectDetailViewModel mExamSubjectDetailViewModel;
    public final TextView payNowBtn;
    public final TextView tvAmount;
    public final TextView tvFine;
    public final TextView tvFixed;
    public final TextView tvTotal;

    public abstract void setExamSubjectDetailViewModel(ExamSubjectDetailViewModel examSubjectDetailViewModel);

    protected DialogExamSubjectDetailsBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout dueLayout, TextView payNowBtn, TextView tvAmount, TextView tvFine, TextView tvFixed, TextView tvTotal) {
        super(_bindingComponent, _root, _localFieldCount);
        this.dueLayout = dueLayout;
        this.payNowBtn = payNowBtn;
        this.tvAmount = tvAmount;
        this.tvFine = tvFine;
        this.tvFixed = tvFixed;
        this.tvTotal = tvTotal;
    }

    public ExamSubjectDetailViewModel getExamSubjectDetailViewModel() {
        return this.mExamSubjectDetailViewModel;
    }

    public static DialogExamSubjectDetailsBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogExamSubjectDetailsBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (DialogExamSubjectDetailsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_exam_subject_details, root, attachToRoot, component);
    }

    public static DialogExamSubjectDetailsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogExamSubjectDetailsBinding inflate(LayoutInflater inflater, Object component) {
        return (DialogExamSubjectDetailsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_exam_subject_details, null, false, component);
    }

    public static DialogExamSubjectDetailsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogExamSubjectDetailsBinding bind(View view, Object component) {
        return (DialogExamSubjectDetailsBinding) bind(component, view, R.layout.dialog_exam_subject_details);
    }
}