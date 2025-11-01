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
import in.etuwa.app.ui.examregistration.ExamRegistrationViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentExamRegistrationMainBinding extends ViewDataBinding {
    public final TextView examResult;
    public final LinearLayout examResultLyt;
    public final TextView feeReceipt;
    public final LinearLayout feeReceiptLyt;

    @Bindable
    protected ExamRegistrationViewModel mExamRegistrationViewModel;
    public final TextView regBtn;
    public final LinearLayout regLyt;
    public final TextView revaluationFee;
    public final LinearLayout revaluationFeeLyt;

    public abstract void setExamRegistrationViewModel(ExamRegistrationViewModel examRegistrationViewModel);

    protected FragmentExamRegistrationMainBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView examResult, LinearLayout examResultLyt, TextView feeReceipt, LinearLayout feeReceiptLyt, TextView regBtn, LinearLayout regLyt, TextView revaluationFee, LinearLayout revaluationFeeLyt) {
        super(_bindingComponent, _root, _localFieldCount);
        this.examResult = examResult;
        this.examResultLyt = examResultLyt;
        this.feeReceipt = feeReceipt;
        this.feeReceiptLyt = feeReceiptLyt;
        this.regBtn = regBtn;
        this.regLyt = regLyt;
        this.revaluationFee = revaluationFee;
        this.revaluationFeeLyt = revaluationFeeLyt;
    }

    public ExamRegistrationViewModel getExamRegistrationViewModel() {
        return this.mExamRegistrationViewModel;
    }

    public static FragmentExamRegistrationMainBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentExamRegistrationMainBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentExamRegistrationMainBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_exam_registration_main, root, attachToRoot, component);
    }

    public static FragmentExamRegistrationMainBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentExamRegistrationMainBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentExamRegistrationMainBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_exam_registration_main, null, false, component);
    }

    public static FragmentExamRegistrationMainBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentExamRegistrationMainBinding bind(View view, Object component) {
        return (FragmentExamRegistrationMainBinding) bind(component, view, R.layout.fragment_exam_registration_main);
    }
}