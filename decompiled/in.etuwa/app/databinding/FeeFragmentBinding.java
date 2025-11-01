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
import in.etuwa.app.ui.fees.payment.FeeViewModel;

/* loaded from: classes3.dex */
public abstract class FeeFragmentBinding extends ViewDataBinding {

    @Bindable
    protected FeeViewModel mFeeViewModel;
    public final TextView payNowBtn;
    public final RecyclerView rvFee;
    public final Spinner spinnerInstallment;
    public final SwipeRefreshLayout swipeLayout;
    public final TextView tvTotal;

    public abstract void setFeeViewModel(FeeViewModel feeViewModel);

    protected FeeFragmentBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView payNowBtn, RecyclerView rvFee, Spinner spinnerInstallment, SwipeRefreshLayout swipeLayout, TextView tvTotal) {
        super(_bindingComponent, _root, _localFieldCount);
        this.payNowBtn = payNowBtn;
        this.rvFee = rvFee;
        this.spinnerInstallment = spinnerInstallment;
        this.swipeLayout = swipeLayout;
        this.tvTotal = tvTotal;
    }

    public FeeViewModel getFeeViewModel() {
        return this.mFeeViewModel;
    }

    public static FeeFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FeeFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FeeFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fee_fragment, root, attachToRoot, component);
    }

    public static FeeFragmentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FeeFragmentBinding inflate(LayoutInflater inflater, Object component) {
        return (FeeFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fee_fragment, null, false, component);
    }

    public static FeeFragmentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FeeFragmentBinding bind(View view, Object component) {
        return (FeeFragmentBinding) bind(component, view, R.layout.fee_fragment);
    }
}