package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import in.etuwa.app.R;
import in.etuwa.app.ui.feepartial.kmea.FeeListViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentFeePartialBinding extends ViewDataBinding {

    @Bindable
    protected FeeListViewModel mFeeListViewModel;
    public final TextView payNowBtn;
    public final RecyclerView rvFee;
    public final Spinner spinnerInstallment;
    public final SwipeRefreshLayout swipeLayout;
    public final TextView tvTotal;

    public abstract void setFeeListViewModel(FeeListViewModel feeListViewModel);

    protected FragmentFeePartialBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView payNowBtn, RecyclerView rvFee, Spinner spinnerInstallment, SwipeRefreshLayout swipeLayout, TextView tvTotal) {
        super(_bindingComponent, _root, _localFieldCount);
        this.payNowBtn = payNowBtn;
        this.rvFee = rvFee;
        this.spinnerInstallment = spinnerInstallment;
        this.swipeLayout = swipeLayout;
        this.tvTotal = tvTotal;
    }

    public FeeListViewModel getFeeListViewModel() {
        return this.mFeeListViewModel;
    }

    public static FragmentFeePartialBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentFeePartialBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentFeePartialBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_fee_partial, root, attachToRoot, component);
    }

    public static FragmentFeePartialBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentFeePartialBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentFeePartialBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_fee_partial, null, false, component);
    }

    public static FragmentFeePartialBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentFeePartialBinding bind(View view, Object component) {
        return (FragmentFeePartialBinding) bind(component, view, R.layout.fragment_fee_partial);
    }
}