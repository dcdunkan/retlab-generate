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
import in.etuwa.app.ui.examregistration.revaluation.fee.RevaluationFeeViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentRevaluationFeeBinding extends ViewDataBinding {

    @Bindable
    protected RevaluationFeeViewModel mRevaluationFeeViewModel;
    public final LinearLayout payLyt;
    public final TextView payNowBtn;
    public final RecyclerView rvExamRevaluation;
    public final SwipeRefreshLayout swipeLayout;
    public final TextView tvHostelTotal;

    public abstract void setRevaluationFeeViewModel(RevaluationFeeViewModel revaluationFeeViewModel);

    protected FragmentRevaluationFeeBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout payLyt, TextView payNowBtn, RecyclerView rvExamRevaluation, SwipeRefreshLayout swipeLayout, TextView tvHostelTotal) {
        super(_bindingComponent, _root, _localFieldCount);
        this.payLyt = payLyt;
        this.payNowBtn = payNowBtn;
        this.rvExamRevaluation = rvExamRevaluation;
        this.swipeLayout = swipeLayout;
        this.tvHostelTotal = tvHostelTotal;
    }

    public RevaluationFeeViewModel getRevaluationFeeViewModel() {
        return this.mRevaluationFeeViewModel;
    }

    public static FragmentRevaluationFeeBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentRevaluationFeeBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentRevaluationFeeBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_revaluation_fee, root, attachToRoot, component);
    }

    public static FragmentRevaluationFeeBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentRevaluationFeeBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentRevaluationFeeBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_revaluation_fee, null, false, component);
    }

    public static FragmentRevaluationFeeBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentRevaluationFeeBinding bind(View view, Object component) {
        return (FragmentRevaluationFeeBinding) bind(component, view, R.layout.fragment_revaluation_fee);
    }
}