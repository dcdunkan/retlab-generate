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
import in.etuwa.app.ui.stationary.StationaryMainViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentStationaryMainBinding extends ViewDataBinding {
    public final AppBarLayout appBarLayout;

    @Bindable
    protected StationaryMainViewModel mStationaryMainViewModel;
    public final ViewPager stationaryPager;
    public final TabLayout tabs;

    public abstract void setStationaryMainViewModel(StationaryMainViewModel stationaryMainViewModel);

    protected FragmentStationaryMainBinding(Object _bindingComponent, View _root, int _localFieldCount, AppBarLayout appBarLayout, ViewPager stationaryPager, TabLayout tabs) {
        super(_bindingComponent, _root, _localFieldCount);
        this.appBarLayout = appBarLayout;
        this.stationaryPager = stationaryPager;
        this.tabs = tabs;
    }

    public StationaryMainViewModel getStationaryMainViewModel() {
        return this.mStationaryMainViewModel;
    }

    public static FragmentStationaryMainBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentStationaryMainBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentStationaryMainBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_stationary_main, root, attachToRoot, component);
    }

    public static FragmentStationaryMainBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentStationaryMainBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentStationaryMainBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_stationary_main, null, false, component);
    }

    public static FragmentStationaryMainBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentStationaryMainBinding bind(View view, Object component) {
        return (FragmentStationaryMainBinding) bind(component, view, R.layout.fragment_stationary_main);
    }
}