package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.applandeo.materialcalendarview.CalendarView;
import in.etuwa.app.R;
import in.etuwa.app.ui.hostel.attendance.HostelAttendanceViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentHostelAttendanceBinding extends ViewDataBinding {
    public final CalendarView attendanceView;
    public final TextView btnApply;
    public final TextView btnView;

    @Bindable
    protected HostelAttendanceViewModel mHostelAttendanceViewModel;

    public abstract void setHostelAttendanceViewModel(HostelAttendanceViewModel hostelAttendanceViewModel);

    protected FragmentHostelAttendanceBinding(Object _bindingComponent, View _root, int _localFieldCount, CalendarView attendanceView, TextView btnApply, TextView btnView) {
        super(_bindingComponent, _root, _localFieldCount);
        this.attendanceView = attendanceView;
        this.btnApply = btnApply;
        this.btnView = btnView;
    }

    public HostelAttendanceViewModel getHostelAttendanceViewModel() {
        return this.mHostelAttendanceViewModel;
    }

    public static FragmentHostelAttendanceBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentHostelAttendanceBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentHostelAttendanceBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_hostel_attendance, root, attachToRoot, component);
    }

    public static FragmentHostelAttendanceBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentHostelAttendanceBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentHostelAttendanceBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_hostel_attendance, null, false, component);
    }

    public static FragmentHostelAttendanceBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentHostelAttendanceBinding bind(View view, Object component) {
        return (FragmentHostelAttendanceBinding) bind(component, view, R.layout.fragment_hostel_attendance);
    }
}