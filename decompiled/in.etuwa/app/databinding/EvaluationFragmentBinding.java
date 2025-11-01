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
import in.etuwa.app.ui.lab.practical.evaluation.EvaluationViewModel;

/* loaded from: classes3.dex */
public abstract class EvaluationFragmentBinding extends ViewDataBinding {

    @Bindable
    protected EvaluationViewModel mEvaluationViewModel;
    public final RecyclerView rvEvaluation;
    public final SwipeRefreshLayout swipeLayout;

    public abstract void setEvaluationViewModel(EvaluationViewModel evaluationViewModel);

    protected EvaluationFragmentBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView rvEvaluation, SwipeRefreshLayout swipeLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.rvEvaluation = rvEvaluation;
        this.swipeLayout = swipeLayout;
    }

    public EvaluationViewModel getEvaluationViewModel() {
        return this.mEvaluationViewModel;
    }

    public static EvaluationFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static EvaluationFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (EvaluationFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.evaluation_fragment, root, attachToRoot, component);
    }

    public static EvaluationFragmentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static EvaluationFragmentBinding inflate(LayoutInflater inflater, Object component) {
        return (EvaluationFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.evaluation_fragment, null, false, component);
    }

    public static EvaluationFragmentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static EvaluationFragmentBinding bind(View view, Object component) {
        return (EvaluationFragmentBinding) bind(component, view, R.layout.evaluation_fragment);
    }
}