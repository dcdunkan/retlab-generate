package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import in.etuwa.app.R;
import in.etuwa.app.ui.leave.LeaveViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentLeaveBinding extends ViewDataBinding {
    public final AppBarLayout appBarLayout;
    public final ViewPager leavePager;

    @Bindable
    protected LeaveViewModel mLeaveViewModel;
    public final TabLayout tabs;

    public abstract void setLeaveViewModel(LeaveViewModel leaveViewModel);

    protected FragmentLeaveBinding(Object _bindingComponent, View _root, int _localFieldCount, AppBarLayout appBarLayout, ViewPager leavePager, TabLayout tabs) {
        super(_bindingComponent, _root, _localFieldCount);
        this.appBarLayout = appBarLayout;
        this.leavePager = leavePager;
        this.tabs = tabs;
    }

    public LeaveViewModel getLeaveViewModel() {
        return this.mLeaveViewModel;
    }

    public static FragmentLeaveBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentLeaveBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentLeaveBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_leave, root, attachToRoot, component);
    }

    public static FragmentLeaveBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentLeaveBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentLeaveBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_leave, null, false, component);
    }

    public static FragmentLeaveBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentLeaveBinding bind(View view, Object component) {
        return (FragmentLeaveBinding) bind(component, view, R.layout.fragment_leave);
    }
}