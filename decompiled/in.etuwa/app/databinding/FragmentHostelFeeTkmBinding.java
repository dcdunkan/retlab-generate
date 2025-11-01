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
import in.etuwa.app.ui.hostel.tkmhostel.fee.HostelFeeTkmViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentHostelFeeTkmBinding extends ViewDataBinding {
    public final TextView hostelTv;
    public final TextView joinDate;

    @Bindable
    protected HostelFeeTkmViewModel mHostelFeeTkmViewModel;
    public final LinearLayout monthLayout;
    public final TextView payNowBtn;
    public final TextView roomNo;
    public final RecyclerView rvHostelFee;
    public final LinearLayout swipeLayout;
    public final TextView tvHostelTotal;

    public abstract void setHostelFeeTkmViewModel(HostelFeeTkmViewModel hostelFeeTkmViewModel);

    protected FragmentHostelFeeTkmBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView hostelTv, TextView joinDate, LinearLayout monthLayout, TextView payNowBtn, TextView roomNo, RecyclerView rvHostelFee, LinearLayout swipeLayout, TextView tvHostelTotal) {
        super(_bindingComponent, _root, _localFieldCount);
        this.hostelTv = hostelTv;
        this.joinDate = joinDate;
        this.monthLayout = monthLayout;
        this.payNowBtn = payNowBtn;
        this.roomNo = roomNo;
        this.rvHostelFee = rvHostelFee;
        this.swipeLayout = swipeLayout;
        this.tvHostelTotal = tvHostelTotal;
    }

    public HostelFeeTkmViewModel getHostelFeeTkmViewModel() {
        return this.mHostelFeeTkmViewModel;
    }

    public static FragmentHostelFeeTkmBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentHostelFeeTkmBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentHostelFeeTkmBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_hostel_fee_tkm, root, attachToRoot, component);
    }

    public static FragmentHostelFeeTkmBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentHostelFeeTkmBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentHostelFeeTkmBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_hostel_fee_tkm, null, false, component);
    }

    public static FragmentHostelFeeTkmBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentHostelFeeTkmBinding bind(View view, Object component) {
        return (FragmentHostelFeeTkmBinding) bind(component, view, R.layout.fragment_hostel_fee_tkm);
    }
}