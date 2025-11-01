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
import in.etuwa.app.ui.hostelnew.HostelNewViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentHostelNewBinding extends ViewDataBinding {

    @Bindable
    protected HostelNewViewModel mHostelNewViewModel;
    public final LinearLayout payBtnLyt;
    public final TextView payFeeEngnrBtn;
    public final TextView payOnlineBtn;
    public final TextView receiptBtn;
    public final RecyclerView rvAdmission;
    public final RecyclerView rvAdmissionHistory;
    public final RecyclerView rvMonthly;
    public final RecyclerView rvMonthlyHistory;
    public final RecyclerView rvReceipts;
    public final SwipeRefreshLayout swipeLayout;
    public final SwipeRefreshLayout swipeLayoutHistory;
    public final SwipeRefreshLayout swipeReceiptLayout;
    public final TextView tvFeeEngnrTotal;

    public abstract void setHostelNewViewModel(HostelNewViewModel hostelNewViewModel);

    protected FragmentHostelNewBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout payBtnLyt, TextView payFeeEngnrBtn, TextView payOnlineBtn, TextView receiptBtn, RecyclerView rvAdmission, RecyclerView rvAdmissionHistory, RecyclerView rvMonthly, RecyclerView rvMonthlyHistory, RecyclerView rvReceipts, SwipeRefreshLayout swipeLayout, SwipeRefreshLayout swipeLayoutHistory, SwipeRefreshLayout swipeReceiptLayout, TextView tvFeeEngnrTotal) {
        super(_bindingComponent, _root, _localFieldCount);
        this.payBtnLyt = payBtnLyt;
        this.payFeeEngnrBtn = payFeeEngnrBtn;
        this.payOnlineBtn = payOnlineBtn;
        this.receiptBtn = receiptBtn;
        this.rvAdmission = rvAdmission;
        this.rvAdmissionHistory = rvAdmissionHistory;
        this.rvMonthly = rvMonthly;
        this.rvMonthlyHistory = rvMonthlyHistory;
        this.rvReceipts = rvReceipts;
        this.swipeLayout = swipeLayout;
        this.swipeLayoutHistory = swipeLayoutHistory;
        this.swipeReceiptLayout = swipeReceiptLayout;
        this.tvFeeEngnrTotal = tvFeeEngnrTotal;
    }

    public HostelNewViewModel getHostelNewViewModel() {
        return this.mHostelNewViewModel;
    }

    public static FragmentHostelNewBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentHostelNewBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentHostelNewBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_hostel_new, root, attachToRoot, component);
    }

    public static FragmentHostelNewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentHostelNewBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentHostelNewBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_hostel_new, null, false, component);
    }

    public static FragmentHostelNewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentHostelNewBinding bind(View view, Object component) {
        return (FragmentHostelNewBinding) bind(component, view, R.layout.fragment_hostel_new);
    }
}