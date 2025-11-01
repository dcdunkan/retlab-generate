package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import in.etuwa.app.R;
import in.etuwa.app.ui.attendance.bydaynew.AttendanceByDayViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentAttendanceByDayBinding extends ViewDataBinding {
    public final CalendarView attendanceView;

    @Bindable
    protected AttendanceByDayViewModel mAttendanceByDayViewModel;
    public final TextView present;

    public abstract void setAttendanceByDayViewModel(AttendanceByDayViewModel attendanceByDayViewModel);

    protected FragmentAttendanceByDayBinding(Object _bindingComponent, View _root, int _localFieldCount, CalendarView attendanceView, TextView present) {
        super(_bindingComponent, _root, _localFieldCount);
        this.attendanceView = attendanceView;
        this.present = present;
    }

    public AttendanceByDayViewModel getAttendanceByDayViewModel() {
        return this.mAttendanceByDayViewModel;
    }

    public static FragmentAttendanceByDayBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentAttendanceByDayBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentAttendanceByDayBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_attendance_by_day, root, attachToRoot, component);
    }

    public static FragmentAttendanceByDayBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentAttendanceByDayBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentAttendanceByDayBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_attendance_by_day, null, false, component);
    }

    public static FragmentAttendanceByDayBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentAttendanceByDayBinding bind(View view, Object component) {
        return (FragmentAttendanceByDayBinding) bind(component, view, R.layout.fragment_attendance_by_day);
    }
}