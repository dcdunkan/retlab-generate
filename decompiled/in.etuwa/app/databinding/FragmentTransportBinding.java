package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import in.etuwa.app.R;
import in.etuwa.app.ui.fees.transport.TransportFeeViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentTransportBinding extends ViewDataBinding {
    public final TextView boardingPointTv;

    @Bindable
    protected TransportFeeViewModel mTransportFeeViewModel;
    public final LinearLayout noDataLyt;
    public final TextView noDataTv;
    public final LinearLayout payBtnLyt;
    public final TextView payTransportBtn;
    public final RecyclerView rvTransport;
    public final Spinner spinnerYearTransport;
    public final SwipeRefreshLayout swipeLayout;
    public final TextView tvTransportTotal;

    public abstract void setTransportFeeViewModel(TransportFeeViewModel transportFeeViewModel);

    protected FragmentTransportBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView boardingPointTv, LinearLayout noDataLyt, TextView noDataTv, LinearLayout payBtnLyt, TextView payTransportBtn, RecyclerView rvTransport, Spinner spinnerYearTransport, SwipeRefreshLayout swipeLayout, TextView tvTransportTotal) {
        super(_bindingComponent, _root, _localFieldCount);
        this.boardingPointTv = boardingPointTv;
        this.noDataLyt = noDataLyt;
        this.noDataTv = noDataTv;
        this.payBtnLyt = payBtnLyt;
        this.payTransportBtn = payTransportBtn;
        this.rvTransport = rvTransport;
        this.spinnerYearTransport = spinnerYearTransport;
        this.swipeLayout = swipeLayout;
        this.tvTransportTotal = tvTransportTotal;
    }

    public TransportFeeViewModel getTransportFeeViewModel() {
        return this.mTransportFeeViewModel;
    }

    public static FragmentTransportBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentTransportBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentTransportBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_transport, root, attachToRoot, component);
    }

    public static FragmentTransportBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentTransportBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentTransportBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_transport, null, false, component);
    }

    public static FragmentTransportBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentTransportBinding bind(View view, Object component) {
        return (FragmentTransportBinding) bind(component, view, R.layout.fragment_transport);
    }
}