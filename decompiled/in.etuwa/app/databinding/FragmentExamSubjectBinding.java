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
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import in.etuwa.app.R;
import in.etuwa.app.ui.examregistration.examsubjects.ExamSubjectViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentExamSubjectBinding extends ViewDataBinding {

    @Bindable
    protected ExamSubjectViewModel mExamSubjectViewModel;
    public final TextView notRegisteredBtn;
    public final LinearLayout regLyt;
    public final TextView registeredBtn;
    public final RecyclerView rvExamSubject;
    public final SwipeRefreshLayout swipeLayout;

    public abstract void setExamSubjectViewModel(ExamSubjectViewModel examSubjectViewModel);

    protected FragmentExamSubjectBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView notRegisteredBtn, LinearLayout regLyt, TextView registeredBtn, RecyclerView rvExamSubject, SwipeRefreshLayout swipeLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.notRegisteredBtn = notRegisteredBtn;
        this.regLyt = regLyt;
        this.registeredBtn = registeredBtn;
        this.rvExamSubject = rvExamSubject;
        this.swipeLayout = swipeLayout;
    }

    public ExamSubjectViewModel getExamSubjectViewModel() {
        return this.mExamSubjectViewModel;
    }

    public static FragmentExamSubjectBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentExamSubjectBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentExamSubjectBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_exam_subject, root, attachToRoot, component);
    }

    public static FragmentExamSubjectBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentExamSubjectBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentExamSubjectBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_exam_subject, null, false, component);
    }

    public static FragmentExamSubjectBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentExamSubjectBinding bind(View view, Object component) {
        return (FragmentExamSubjectBinding) bind(component, view, R.layout.fragment_exam_subject);
    }
}