package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import in.etuwa.app.R;
import in.etuwa.app.ui.dashboard.daywisetimetable.DayWiseTimeTableViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentDayWiseTimeTableBinding extends ViewDataBinding {
    public final FloatingActionButton fabDatePicker;

    @Bindable
    protected DayWiseTimeTableViewModel mDayWiseTimeTableViewModel;
    public final RecyclerView rvTimetable;
    public final SwipeRefreshLayout swipeLayout;

    public abstract void setDayWiseTimeTableViewModel(DayWiseTimeTableViewModel dayWiseTimeTableViewModel);

    protected FragmentDayWiseTimeTableBinding(Object _bindingComponent, View _root, int _localFieldCount, FloatingActionButton fabDatePicker, RecyclerView rvTimetable, SwipeRefreshLayout swipeLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.fabDatePicker = fabDatePicker;
        this.rvTimetable = rvTimetable;
        this.swipeLayout = swipeLayout;
    }

    public DayWiseTimeTableViewModel getDayWiseTimeTableViewModel() {
        return this.mDayWiseTimeTableViewModel;
    }

    public static FragmentDayWiseTimeTableBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentDayWiseTimeTableBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentDayWiseTimeTableBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_day_wise_time_table, root, attachToRoot, component);
    }

    public static FragmentDayWiseTimeTableBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentDayWiseTimeTableBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentDayWiseTimeTableBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_day_wise_time_table, null, false, component);
    }

    public static FragmentDayWiseTimeTableBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentDayWiseTimeTableBinding bind(View view, Object component) {
        return (FragmentDayWiseTimeTableBinding) bind(component, view, R.layout.fragment_day_wise_time_table);
    }
}