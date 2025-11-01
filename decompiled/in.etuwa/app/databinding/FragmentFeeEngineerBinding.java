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
import in.etuwa.app.R;
import in.etuwa.app.ui.feenewengineer.payment.FeeEngineerViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentFeeEngineerBinding extends ViewDataBinding {

    @Bindable
    protected FeeEngineerViewModel mFeeEngineeringViewModel;
    public final LinearLayout payBtnLyt;
    public final TextView payFeeEngnrBtn;
    public final RecyclerView rvFeeEngnr;
    public final LinearLayout swipeLayout;
    public final TextView tvFeeEngnrTotal;

    public abstract void setFeeEngineeringViewModel(FeeEngineerViewModel feeEngineeringViewModel);

    protected FragmentFeeEngineerBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout payBtnLyt, TextView payFeeEngnrBtn, RecyclerView rvFeeEngnr, LinearLayout swipeLayout, TextView tvFeeEngnrTotal) {
        super(_bindingComponent, _root, _localFieldCount);
        this.payBtnLyt = payBtnLyt;
        this.payFeeEngnrBtn = payFeeEngnrBtn;
        this.rvFeeEngnr = rvFeeEngnr;
        this.swipeLayout = swipeLayout;
        this.tvFeeEngnrTotal = tvFeeEngnrTotal;
    }

    public FeeEngineerViewModel getFeeEngineeringViewModel() {
        return this.mFeeEngineeringViewModel;
    }

    public static FragmentFeeEngineerBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentFeeEngineerBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentFeeEngineerBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_fee_engineer, root, attachToRoot, component);
    }

    public static FragmentFeeEngineerBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentFeeEngineerBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentFeeEngineerBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_fee_engineer, null, false, component);
    }

    public static FragmentFeeEngineerBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentFeeEngineerBinding bind(View view, Object component) {
        return (FragmentFeeEngineerBinding) bind(component, view, R.layout.fragment_fee_engineer);
    }
}