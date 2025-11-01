package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import in.etuwa.app.R;
import in.etuwa.app.ui.timetable.TimeTableViewModel;

/* loaded from: classes3.dex */
public abstract class TimeTableFragmentBinding extends ViewDataBinding {
    public final AppBarLayout appBarLayout;
    public final FloatingActionButton fabChange;
    public final FloatingActionButton fabSpecial;

    @Bindable
    protected TimeTableViewModel mTimeTableViewModel;
    public final FloatingActionMenu menu;
    public final TabLayout tabs;
    public final ViewPager timetablePager;

    public abstract void setTimeTableViewModel(TimeTableViewModel timeTableViewModel);

    protected TimeTableFragmentBinding(Object _bindingComponent, View _root, int _localFieldCount, AppBarLayout appBarLayout, FloatingActionButton fabChange, FloatingActionButton fabSpecial, FloatingActionMenu menu, TabLayout tabs, ViewPager timetablePager) {
        super(_bindingComponent, _root, _localFieldCount);
        this.appBarLayout = appBarLayout;
        this.fabChange = fabChange;
        this.fabSpecial = fabSpecial;
        this.menu = menu;
        this.tabs = tabs;
        this.timetablePager = timetablePager;
    }

    public TimeTableViewModel getTimeTableViewModel() {
        return this.mTimeTableViewModel;
    }

    public static TimeTableFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static TimeTableFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (TimeTableFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.time_table_fragment, root, attachToRoot, component);
    }

    public static TimeTableFragmentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static TimeTableFragmentBinding inflate(LayoutInflater inflater, Object component) {
        return (TimeTableFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.time_table_fragment, null, false, component);
    }

    public static TimeTableFragmentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static TimeTableFragmentBinding bind(View view, Object component) {
        return (TimeTableFragmentBinding) bind(component, view, R.layout.time_table_fragment);
    }
}