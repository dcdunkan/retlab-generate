package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import in.etuwa.app.R;
import in.etuwa.app.ui.hostel.tkmhostel.fee.payconfirm.HostelFeeConfirmViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentHostelFeeConfirmFragmentBinding extends ViewDataBinding {

    @Bindable
    protected HostelFeeConfirmViewModel mHostelFeeConfirmViewModel;
    public final TextView monthLbl;
    public final RecyclerView rvHostelFee;
    public final SwipeRefreshLayout swipeLayout;

    public abstract void setHostelFeeConfirmViewModel(HostelFeeConfirmViewModel hostelFeeConfirmViewModel);

    protected FragmentHostelFeeConfirmFragmentBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView monthLbl, RecyclerView rvHostelFee, SwipeRefreshLayout swipeLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.monthLbl = monthLbl;
        this.rvHostelFee = rvHostelFee;
        this.swipeLayout = swipeLayout;
    }

    public HostelFeeConfirmViewModel getHostelFeeConfirmViewModel() {
        return this.mHostelFeeConfirmViewModel;
    }

    public static FragmentHostelFeeConfirmFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentHostelFeeConfirmFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentHostelFeeConfirmFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_hostel_fee_confirm_fragment, root, attachToRoot, component);
    }

    public static FragmentHostelFeeConfirmFragmentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentHostelFeeConfirmFragmentBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentHostelFeeConfirmFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_hostel_fee_confirm_fragment, null, false, component);
    }

    public static FragmentHostelFeeConfirmFragmentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentHostelFeeConfirmFragmentBinding bind(View view, Object component) {
        return (FragmentHostelFeeConfirmFragmentBinding) bind(component, view, R.layout.fragment_hostel_fee_confirm_fragment);
    }
}