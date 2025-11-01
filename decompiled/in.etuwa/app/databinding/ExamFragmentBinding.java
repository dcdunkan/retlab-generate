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
import in.etuwa.app.ui.examschedules.ExamViewModel;

/* loaded from: classes3.dex */
public abstract class ExamFragmentBinding extends ViewDataBinding {

    @Bindable
    protected ExamViewModel mExamViewModel;
    public final RecyclerView rvExam;
    public final SwipeRefreshLayout swipeLayout;

    public abstract void setExamViewModel(ExamViewModel examViewModel);

    protected ExamFragmentBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView rvExam, SwipeRefreshLayout swipeLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.rvExam = rvExam;
        this.swipeLayout = swipeLayout;
    }

    public ExamViewModel getExamViewModel() {
        return this.mExamViewModel;
    }

    public static ExamFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ExamFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (ExamFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.exam_fragment, root, attachToRoot, component);
    }

    public static ExamFragmentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ExamFragmentBinding inflate(LayoutInflater inflater, Object component) {
        return (ExamFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.exam_fragment, null, false, component);
    }

    public static ExamFragmentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ExamFragmentBinding bind(View view, Object component) {
        return (ExamFragmentBinding) bind(component, view, R.layout.exam_fragment);
    }
}