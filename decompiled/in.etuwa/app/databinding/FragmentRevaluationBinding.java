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
import in.etuwa.app.ui.examregistration.revaluation.RevaluationViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentRevaluationBinding extends ViewDataBinding {

    @Bindable
    protected RevaluationViewModel mRevaluationViewModel;
    public final TextView payLaterBtn;
    public final LinearLayout payLaterLyt;
    public final LinearLayout payLyt;
    public final TextView payNowBtn;
    public final TextView registerBtn;
    public final LinearLayout registerLyt;
    public final RecyclerView rvExamRevaluation;
    public final SwipeRefreshLayout swipeLayout;
    public final TextView tvHostelTotal;

    public abstract void setRevaluationViewModel(RevaluationViewModel revaluationViewModel);

    protected FragmentRevaluationBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView payLaterBtn, LinearLayout payLaterLyt, LinearLayout payLyt, TextView payNowBtn, TextView registerBtn, LinearLayout registerLyt, RecyclerView rvExamRevaluation, SwipeRefreshLayout swipeLayout, TextView tvHostelTotal) {
        super(_bindingComponent, _root, _localFieldCount);
        this.payLaterBtn = payLaterBtn;
        this.payLaterLyt = payLaterLyt;
        this.payLyt = payLyt;
        this.payNowBtn = payNowBtn;
        this.registerBtn = registerBtn;
        this.registerLyt = registerLyt;
        this.rvExamRevaluation = rvExamRevaluation;
        this.swipeLayout = swipeLayout;
        this.tvHostelTotal = tvHostelTotal;
    }

    public RevaluationViewModel getRevaluationViewModel() {
        return this.mRevaluationViewModel;
    }

    public static FragmentRevaluationBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentRevaluationBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentRevaluationBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_revaluation, root, attachToRoot, component);
    }

    public static FragmentRevaluationBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentRevaluationBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentRevaluationBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_revaluation, null, false, component);
    }

    public static FragmentRevaluationBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentRevaluationBinding bind(View view, Object component) {
        return (FragmentRevaluationBinding) bind(component, view, R.layout.fragment_revaluation);
    }
}