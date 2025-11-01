package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import in.etuwa.app.R;
import in.etuwa.app.ui.feenewengineer.payment.FeeEngineerViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentFeeListBinding extends ViewDataBinding {
    public final CheckBox installmentMainCheck;
    public final TextView installmentName;

    @Bindable
    protected FeeEngineerViewModel mFeeEngineeringViewModel;
    public final TextView payFeeEngnrBtn;
    public final RecyclerView rvFeeEngnr;
    public final LinearLayout swipeLayout;
    public final TextView tvFeeEngnrTotal;

    public abstract void setFeeEngineeringViewModel(FeeEngineerViewModel feeEngineeringViewModel);

    protected FragmentFeeListBinding(Object _bindingComponent, View _root, int _localFieldCount, CheckBox installmentMainCheck, TextView installmentName, TextView payFeeEngnrBtn, RecyclerView rvFeeEngnr, LinearLayout swipeLayout, TextView tvFeeEngnrTotal) {
        super(_bindingComponent, _root, _localFieldCount);
        this.installmentMainCheck = installmentMainCheck;
        this.installmentName = installmentName;
        this.payFeeEngnrBtn = payFeeEngnrBtn;
        this.rvFeeEngnr = rvFeeEngnr;
        this.swipeLayout = swipeLayout;
        this.tvFeeEngnrTotal = tvFeeEngnrTotal;
    }

    public FeeEngineerViewModel getFeeEngineeringViewModel() {
        return this.mFeeEngineeringViewModel;
    }

    public static FragmentFeeListBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentFeeListBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentFeeListBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_fee_list, root, attachToRoot, component);
    }

    public static FragmentFeeListBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentFeeListBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentFeeListBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_fee_list, null, false, component);
    }

    public static FragmentFeeListBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentFeeListBinding bind(View view, Object component) {
        return (FragmentFeeListBinding) bind(component, view, R.layout.fragment_fee_list);
    }
}