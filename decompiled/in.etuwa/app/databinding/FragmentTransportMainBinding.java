package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import in.etuwa.app.R;
import in.etuwa.app.ui.transportmain.TransportMainViewModel;

/* JADX INFO: loaded from: classes3.dex */
public abstract class FragmentTransportMainBinding extends ViewDataBinding {
    public final TextView boardingPointTv;
    public final TextView busPassBtn;
    public final FrameLayout feeReceiptLyt;
    public final TextView feesBtn;
    public final TextView gatewayBtn;
    public final TextView historyBtn;
    public final HorizontalScrollView hrView;

    @Bindable
    protected TransportMainViewModel mTransportMainViewModel;
    public final LinearLayout mainLyt;
    public final LinearLayout noDataLyt;
    public final TextView noDataTv;
    public final MaterialCardView payBtnLyt;
    public final MaterialButton payTransportBtn;
    public final TextView receiptBtn;
    public final TextView registrationBtn;
    public final RecyclerView rvFeeReceipt;
    public final RecyclerView rvTransport;
    public final CardView searchCard;
    public final EditText searchInput;
    public final Spinner spinnerYearTransport;
    public final SwipeRefreshLayout swipeLayout;
    public final TextView toolbar;
    public final TextView tvTransportTotal;

    public abstract void setTransportMainViewModel(TransportMainViewModel transportMainViewModel);

    protected FragmentTransportMainBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView boardingPointTv, TextView busPassBtn, FrameLayout feeReceiptLyt, TextView feesBtn, TextView gatewayBtn, TextView historyBtn, HorizontalScrollView hrView, LinearLayout mainLyt, LinearLayout noDataLyt, TextView noDataTv, MaterialCardView payBtnLyt, MaterialButton payTransportBtn, TextView receiptBtn, TextView registrationBtn, RecyclerView rvFeeReceipt, RecyclerView rvTransport, CardView searchCard, EditText searchInput, Spinner spinnerYearTransport, SwipeRefreshLayout swipeLayout, TextView toolbar, TextView tvTransportTotal) {
        super(_bindingComponent, _root, _localFieldCount);
        this.boardingPointTv = boardingPointTv;
        this.busPassBtn = busPassBtn;
        this.feeReceiptLyt = feeReceiptLyt;
        this.feesBtn = feesBtn;
        this.gatewayBtn = gatewayBtn;
        this.historyBtn = historyBtn;
        this.hrView = hrView;
        this.mainLyt = mainLyt;
        this.noDataLyt = noDataLyt;
        this.noDataTv = noDataTv;
        this.payBtnLyt = payBtnLyt;
        this.payTransportBtn = payTransportBtn;
        this.receiptBtn = receiptBtn;
        this.registrationBtn = registrationBtn;
        this.rvFeeReceipt = rvFeeReceipt;
        this.rvTransport = rvTransport;
        this.searchCard = searchCard;
        this.searchInput = searchInput;
        this.spinnerYearTransport = spinnerYearTransport;
        this.swipeLayout = swipeLayout;
        this.toolbar = toolbar;
        this.tvTransportTotal = tvTransportTotal;
    }

    public TransportMainViewModel getTransportMainViewModel() {
        return this.mTransportMainViewModel;
    }

    public static FragmentTransportMainBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentTransportMainBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentTransportMainBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_transport_main, root, attachToRoot, component);
    }

    public static FragmentTransportMainBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentTransportMainBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentTransportMainBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_transport_main, null, false, component);
    }

    public static FragmentTransportMainBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentTransportMainBinding bind(View view, Object component) {
        return (FragmentTransportMainBinding) bind(component, view, R.layout.fragment_transport_main);
    }
}