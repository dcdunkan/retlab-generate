package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import in.etuwa.app.R;
import in.etuwa.app.ui.attendance.calendarview.AttendanceCalendarViewViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentAttendanceCalendarViewBinding extends ViewDataBinding {

    @Bindable
    protected AttendanceCalendarViewViewModel mAttendanceCalendarViewViewModel;
    public final TextView monthTv;
    public final TextView nextBtn;
    public final TextView previousBtn;
    public final RecyclerView rvCalender;

    public abstract void setAttendanceCalendarViewViewModel(AttendanceCalendarViewViewModel attendanceCalendarViewViewModel);

    protected FragmentAttendanceCalendarViewBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView monthTv, TextView nextBtn, TextView previousBtn, RecyclerView rvCalender) {
        super(_bindingComponent, _root, _localFieldCount);
        this.monthTv = monthTv;
        this.nextBtn = nextBtn;
        this.previousBtn = previousBtn;
        this.rvCalender = rvCalender;
    }

    public AttendanceCalendarViewViewModel getAttendanceCalendarViewViewModel() {
        return this.mAttendanceCalendarViewViewModel;
    }

    public static FragmentAttendanceCalendarViewBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentAttendanceCalendarViewBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentAttendanceCalendarViewBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_attendance_calendar_view, root, attachToRoot, component);
    }

    public static FragmentAttendanceCalendarViewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentAttendanceCalendarViewBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentAttendanceCalendarViewBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_attendance_calendar_view, null, false, component);
    }

    public static FragmentAttendanceCalendarViewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentAttendanceCalendarViewBinding bind(View view, Object component) {
        return (FragmentAttendanceCalendarViewBinding) bind(component, view, R.layout.fragment_attendance_calendar_view);
    }
}