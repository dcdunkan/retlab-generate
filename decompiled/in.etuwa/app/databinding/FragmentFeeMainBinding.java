package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import in.etuwa.app.R;
import in.etuwa.app.ui.fees.FeeMainViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentFeeMainBinding extends ViewDataBinding {
    public final LinearLayout dealBtn;
    public final View dealBtnView;

    @Bindable
    protected FeeMainViewModel mFeeMainViewModel;
    public final LinearLayout payBtn;
    public final LinearLayout paymentGatewayBtn;
    public final LinearLayout transportFeeBtn;
    public final LinearLayout transportHistoryBtn;
    public final LinearLayout transportRegBtn;
    public final TextView tvTransportView;
    public final LinearLayout viewReceipt;
    public final LinearLayout viewTransportBuspass;
    public final LinearLayout viewTransportReceipt;

    public abstract void setFeeMainViewModel(FeeMainViewModel feeMainViewModel);

    protected FragmentFeeMainBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout dealBtn, View dealBtnView, LinearLayout payBtn, LinearLayout paymentGatewayBtn, LinearLayout transportFeeBtn, LinearLayout transportHistoryBtn, LinearLayout transportRegBtn, TextView tvTransportView, LinearLayout viewReceipt, LinearLayout viewTransportBuspass, LinearLayout viewTransportReceipt) {
        super(_bindingComponent, _root, _localFieldCount);
        this.dealBtn = dealBtn;
        this.dealBtnView = dealBtnView;
        this.payBtn = payBtn;
        this.paymentGatewayBtn = paymentGatewayBtn;
        this.transportFeeBtn = transportFeeBtn;
        this.transportHistoryBtn = transportHistoryBtn;
        this.transportRegBtn = transportRegBtn;
        this.tvTransportView = tvTransportView;
        this.viewReceipt = viewReceipt;
        this.viewTransportBuspass = viewTransportBuspass;
        this.viewTransportReceipt = viewTransportReceipt;
    }

    public FeeMainViewModel getFeeMainViewModel() {
        return this.mFeeMainViewModel;
    }

    public static FragmentFeeMainBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentFeeMainBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentFeeMainBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_fee_main, root, attachToRoot, component);
    }

    public static FragmentFeeMainBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentFeeMainBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentFeeMainBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_fee_main, null, false, component);
    }

    public static FragmentFeeMainBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentFeeMainBinding bind(View view, Object component) {
        return (FragmentFeeMainBinding) bind(component, view, R.layout.fragment_fee_main);
    }
}