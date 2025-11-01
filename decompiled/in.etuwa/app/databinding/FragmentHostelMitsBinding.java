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
import in.etuwa.app.R;
import in.etuwa.app.ui.hostel.hostelmits.HostelMitsViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentHostelMitsBinding extends ViewDataBinding {
    public final TextView hostelTv;
    public final TextView joinDate;

    @Bindable
    protected HostelMitsViewModel mHostelMitsViewModel;
    public final LinearLayout monthLayout;
    public final TextView payNowBtn;
    public final TextView roomNo;
    public final RecyclerView rvHostelFee;
    public final RecyclerView rvHostelFeeAdmission;
    public final Spinner spinnerHostelFee;
    public final LinearLayout swipeLayout;
    public final LinearLayout swipeLayout2;
    public final TextView tvHostelTotal;

    public abstract void setHostelMitsViewModel(HostelMitsViewModel hostelMitsViewModel);

    protected FragmentHostelMitsBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView hostelTv, TextView joinDate, LinearLayout monthLayout, TextView payNowBtn, TextView roomNo, RecyclerView rvHostelFee, RecyclerView rvHostelFeeAdmission, Spinner spinnerHostelFee, LinearLayout swipeLayout, LinearLayout swipeLayout2, TextView tvHostelTotal) {
        super(_bindingComponent, _root, _localFieldCount);
        this.hostelTv = hostelTv;
        this.joinDate = joinDate;
        this.monthLayout = monthLayout;
        this.payNowBtn = payNowBtn;
        this.roomNo = roomNo;
        this.rvHostelFee = rvHostelFee;
        this.rvHostelFeeAdmission = rvHostelFeeAdmission;
        this.spinnerHostelFee = spinnerHostelFee;
        this.swipeLayout = swipeLayout;
        this.swipeLayout2 = swipeLayout2;
        this.tvHostelTotal = tvHostelTotal;
    }

    public HostelMitsViewModel getHostelMitsViewModel() {
        return this.mHostelMitsViewModel;
    }

    public static FragmentHostelMitsBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentHostelMitsBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentHostelMitsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_hostel_mits, root, attachToRoot, component);
    }

    public static FragmentHostelMitsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentHostelMitsBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentHostelMitsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_hostel_mits, null, false, component);
    }

    public static FragmentHostelMitsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentHostelMitsBinding bind(View view, Object component) {
        return (FragmentHostelMitsBinding) bind(component, view, R.layout.fragment_hostel_mits);
    }
}