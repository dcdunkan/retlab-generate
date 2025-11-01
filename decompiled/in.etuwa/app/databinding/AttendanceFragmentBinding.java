package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import at.grabner.circleprogress.CircleProgressView;
import in.etuwa.app.R;
import in.etuwa.app.ui.attendance.bysubject.AttendanceViewModel;

/* loaded from: classes3.dex */
public abstract class AttendanceFragmentBinding extends ViewDataBinding {
    public final CircleProgressView attendanceByPer;
    public final TextView attendanceBySub;
    public final TextView attendanceByTotal;
    public final Button byDayBtn;

    @Bindable
    protected AttendanceViewModel mAttendanceViewModel;
    public final RecyclerView rvAttendance;
    public final LinearLayout segmentView;
    public final LinearLayout spinnerLt;
    public final Spinner spinnerSem;
    public final SwipeRefreshLayout swipeLayout;
    public final CardView totalCv;
    public final LinearLayout withBtn;
    public final TextView withTv;
    public final LinearLayout withoutBtn;
    public final TextView withoutTv;

    public abstract void setAttendanceViewModel(AttendanceViewModel attendanceViewModel);

    protected AttendanceFragmentBinding(Object _bindingComponent, View _root, int _localFieldCount, CircleProgressView attendanceByPer, TextView attendanceBySub, TextView attendanceByTotal, Button byDayBtn, RecyclerView rvAttendance, LinearLayout segmentView, LinearLayout spinnerLt, Spinner spinnerSem, SwipeRefreshLayout swipeLayout, CardView totalCv, LinearLayout withBtn, TextView withTv, LinearLayout withoutBtn, TextView withoutTv) {
        super(_bindingComponent, _root, _localFieldCount);
        this.attendanceByPer = attendanceByPer;
        this.attendanceBySub = attendanceBySub;
        this.attendanceByTotal = attendanceByTotal;
        this.byDayBtn = byDayBtn;
        this.rvAttendance = rvAttendance;
        this.segmentView = segmentView;
        this.spinnerLt = spinnerLt;
        this.spinnerSem = spinnerSem;
        this.swipeLayout = swipeLayout;
        this.totalCv = totalCv;
        this.withBtn = withBtn;
        this.withTv = withTv;
        this.withoutBtn = withoutBtn;
        this.withoutTv = withoutTv;
    }

    public AttendanceViewModel getAttendanceViewModel() {
        return this.mAttendanceViewModel;
    }

    public static AttendanceFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AttendanceFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (AttendanceFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.attendance_fragment, root, attachToRoot, component);
    }

    public static AttendanceFragmentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AttendanceFragmentBinding inflate(LayoutInflater inflater, Object component) {
        return (AttendanceFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.attendance_fragment, null, false, component);
    }

    public static AttendanceFragmentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AttendanceFragmentBinding bind(View view, Object component) {
        return (AttendanceFragmentBinding) bind(component, view, R.layout.attendance_fragment);
    }
}