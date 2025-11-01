package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import in.etuwa.app.R;
import in.etuwa.app.ui.hostel.attendance.viewleave.HostelViewLeaveViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentHostelAttViewBinding extends ViewDataBinding {
    public final TextView applyNowBtn;

    @Bindable
    protected HostelViewLeaveViewModel mHostelViewLeaveViewModel;
    public final TextView noData;
    public final RecyclerView rvHostelAttView;
    public final CardView swipeLayout;

    public abstract void setHostelViewLeaveViewModel(HostelViewLeaveViewModel hostelViewLeaveViewModel);

    protected FragmentHostelAttViewBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView applyNowBtn, TextView noData, RecyclerView rvHostelAttView, CardView swipeLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.applyNowBtn = applyNowBtn;
        this.noData = noData;
        this.rvHostelAttView = rvHostelAttView;
        this.swipeLayout = swipeLayout;
    }

    public HostelViewLeaveViewModel getHostelViewLeaveViewModel() {
        return this.mHostelViewLeaveViewModel;
    }

    public static FragmentHostelAttViewBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentHostelAttViewBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentHostelAttViewBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_hostel_att_view, root, attachToRoot, component);
    }

    public static FragmentHostelAttViewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentHostelAttViewBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentHostelAttViewBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_hostel_att_view, null, false, component);
    }

    public static FragmentHostelAttViewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentHostelAttViewBinding bind(View view, Object component) {
        return (FragmentHostelAttViewBinding) bind(component, view, R.layout.fragment_hostel_att_view);
    }
}