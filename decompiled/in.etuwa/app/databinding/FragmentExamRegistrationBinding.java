package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import in.etuwa.app.R;
import in.etuwa.app.ui.examregistration.examsubjects.register.ExamRegisterViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentExamRegistrationBinding extends ViewDataBinding {

    @Bindable
    protected ExamRegisterViewModel mExamRegisterViewModel;
    public final TextView payLaterBtn;
    public final LinearLayout payLaterLyt;
    public final LinearLayout payLyt;
    public final TextView payNowBtn;
    public final TextView registerBtn;
    public final LinearLayout registerLyt;
    public final RecyclerView rvExamSubject;
    public final CheckBox selectAllCheckBox;
    public final LinearLayout selectLyt;
    public final TextView selectTv;
    public final SwipeRefreshLayout swipeLayout;
    public final TextView tvAdditionalFees;
    public final TextView tvHostelTotal;

    public abstract void setExamRegisterViewModel(ExamRegisterViewModel examRegisterViewModel);

    protected FragmentExamRegistrationBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView payLaterBtn, LinearLayout payLaterLyt, LinearLayout payLyt, TextView payNowBtn, TextView registerBtn, LinearLayout registerLyt, RecyclerView rvExamSubject, CheckBox selectAllCheckBox, LinearLayout selectLyt, TextView selectTv, SwipeRefreshLayout swipeLayout, TextView tvAdditionalFees, TextView tvHostelTotal) {
        super(_bindingComponent, _root, _localFieldCount);
        this.payLaterBtn = payLaterBtn;
        this.payLaterLyt = payLaterLyt;
        this.payLyt = payLyt;
        this.payNowBtn = payNowBtn;
        this.registerBtn = registerBtn;
        this.registerLyt = registerLyt;
        this.rvExamSubject = rvExamSubject;
        this.selectAllCheckBox = selectAllCheckBox;
        this.selectLyt = selectLyt;
        this.selectTv = selectTv;
        this.swipeLayout = swipeLayout;
        this.tvAdditionalFees = tvAdditionalFees;
        this.tvHostelTotal = tvHostelTotal;
    }

    public ExamRegisterViewModel getExamRegisterViewModel() {
        return this.mExamRegisterViewModel;
    }

    public static FragmentExamRegistrationBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentExamRegistrationBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentExamRegistrationBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_exam_registration, root, attachToRoot, component);
    }

    public static FragmentExamRegistrationBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentExamRegistrationBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentExamRegistrationBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_exam_registration, null, false, component);
    }

    public static FragmentExamRegistrationBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentExamRegistrationBinding bind(View view, Object component) {
        return (FragmentExamRegistrationBinding) bind(component, view, R.layout.fragment_exam_registration);
    }
}