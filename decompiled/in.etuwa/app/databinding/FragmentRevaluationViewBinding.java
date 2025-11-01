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
import in.etuwa.app.ui.examregistration.revaluation.view.RevaluationViewViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentRevaluationViewBinding extends ViewDataBinding {

    @Bindable
    protected RevaluationViewViewModel mRevaluationViewViewModel;
    public final LinearLayout payLyt;
    public final RecyclerView rvExamRevaluation;
    public final SwipeRefreshLayout swipeLayout;
    public final TextView tvHostelTotal;
    public final TextView updateBtn;

    public abstract void setRevaluationViewViewModel(RevaluationViewViewModel revaluationViewViewModel);

    protected FragmentRevaluationViewBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout payLyt, RecyclerView rvExamRevaluation, SwipeRefreshLayout swipeLayout, TextView tvHostelTotal, TextView updateBtn) {
        super(_bindingComponent, _root, _localFieldCount);
        this.payLyt = payLyt;
        this.rvExamRevaluation = rvExamRevaluation;
        this.swipeLayout = swipeLayout;
        this.tvHostelTotal = tvHostelTotal;
        this.updateBtn = updateBtn;
    }

    public RevaluationViewViewModel getRevaluationViewViewModel() {
        return this.mRevaluationViewViewModel;
    }

    public static FragmentRevaluationViewBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentRevaluationViewBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentRevaluationViewBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_revaluation_view, root, attachToRoot, component);
    }

    public static FragmentRevaluationViewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentRevaluationViewBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentRevaluationViewBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_revaluation_view, null, false, component);
    }

    public static FragmentRevaluationViewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentRevaluationViewBinding bind(View view, Object component) {
        return (FragmentRevaluationViewBinding) bind(component, view, R.layout.fragment_revaluation_view);
    }
}