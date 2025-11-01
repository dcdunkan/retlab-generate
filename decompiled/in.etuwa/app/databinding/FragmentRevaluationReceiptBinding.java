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
import in.etuwa.app.ui.examregistration.revaluation.view.receipt.RevaluationReceiptViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentRevaluationReceiptBinding extends ViewDataBinding {

    @Bindable
    protected RevaluationReceiptViewModel mRevaluationReceiptViewModel;
    public final LinearLayout payLyt;
    public final TextView payNowBtn;
    public final RecyclerView rvExamRevaluation;
    public final SwipeRefreshLayout swipeLayout;
    public final TextView tvHostelTotal;

    public abstract void setRevaluationReceiptViewModel(RevaluationReceiptViewModel revaluationReceiptViewModel);

    protected FragmentRevaluationReceiptBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout payLyt, TextView payNowBtn, RecyclerView rvExamRevaluation, SwipeRefreshLayout swipeLayout, TextView tvHostelTotal) {
        super(_bindingComponent, _root, _localFieldCount);
        this.payLyt = payLyt;
        this.payNowBtn = payNowBtn;
        this.rvExamRevaluation = rvExamRevaluation;
        this.swipeLayout = swipeLayout;
        this.tvHostelTotal = tvHostelTotal;
    }

    public RevaluationReceiptViewModel getRevaluationReceiptViewModel() {
        return this.mRevaluationReceiptViewModel;
    }

    public static FragmentRevaluationReceiptBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentRevaluationReceiptBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentRevaluationReceiptBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_revaluation_receipt, root, attachToRoot, component);
    }

    public static FragmentRevaluationReceiptBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentRevaluationReceiptBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentRevaluationReceiptBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_revaluation_receipt, null, false, component);
    }

    public static FragmentRevaluationReceiptBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentRevaluationReceiptBinding bind(View view, Object component) {
        return (FragmentRevaluationReceiptBinding) bind(component, view, R.layout.fragment_revaluation_receipt);
    }
}