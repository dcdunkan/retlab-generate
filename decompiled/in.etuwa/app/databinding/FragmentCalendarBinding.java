package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import in.etuwa.app.R;
import in.etuwa.app.ui.calendar.CalendarViewModel;
import ru.cleverpumpkin.calendar.CalendarView;

/* loaded from: classes3.dex */
public abstract class FragmentCalendarBinding extends ViewDataBinding {
    public final CalendarView calendarView;

    @Bindable
    protected CalendarViewModel mCalendarViewModel;

    public abstract void setCalendarViewModel(CalendarViewModel calendarViewModel);

    protected FragmentCalendarBinding(Object _bindingComponent, View _root, int _localFieldCount, CalendarView calendarView) {
        super(_bindingComponent, _root, _localFieldCount);
        this.calendarView = calendarView;
    }

    public CalendarViewModel getCalendarViewModel() {
        return this.mCalendarViewModel;
    }

    public static FragmentCalendarBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentCalendarBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentCalendarBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_calendar, root, attachToRoot, component);
    }

    public static FragmentCalendarBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentCalendarBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentCalendarBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_calendar, null, false, component);
    }

    public static FragmentCalendarBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentCalendarBinding bind(View view, Object component) {
        return (FragmentCalendarBinding) bind(component, view, R.layout.fragment_calendar);
    }
}