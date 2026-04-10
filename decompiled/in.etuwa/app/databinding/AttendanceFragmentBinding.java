package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
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
import com.google.android.material.card.MaterialCardView;
import in.etuwa.app.R;
import in.etuwa.app.ui.attendance.bysubject.AttendanceViewModel;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AttendanceFragmentBinding extends ViewDataBinding {
    public final CardView atteandceByDayLyt;
    public final CircleProgressView attendanceByPer;
    public final TextView attendanceBySub;
    public final TextView attendanceByTotal;
    public final TextView byDayBtn;
    public final TextView bySubjectBtn;
    public final LinearLayout bySubjectLyt;
    public final HorizontalScrollView hrView;

    @Bindable
    protected AttendanceViewModel mAttendanceViewModel;
    public final TextView monthTv;
    public final CardView nextBtn;
    public final CardView previousBtn;
    public final RecyclerView rvAttendance;
    public final RecyclerView rvCalender;
    public final MaterialCardView segmentView;
    public final MaterialCardView spinnerLt;
    public final Spinner spinnerSem;
    public final SwipeRefreshLayout swipeLayout;
    public final TextView toolbar;
    public final MaterialCardView totalCv;
    public final LinearLayout withBtn;
    public final View withTv;
    public final LinearLayout withoutBtn;
    public final View withoutTv;

    public abstract void setAttendanceViewModel(AttendanceViewModel attendanceViewModel);

    protected AttendanceFragmentBinding(Object _bindingComponent, View _root, int _localFieldCount, CardView atteandceByDayLyt, CircleProgressView attendanceByPer, TextView attendanceBySub, TextView attendanceByTotal, TextView byDayBtn, TextView bySubjectBtn, LinearLayout bySubjectLyt, HorizontalScrollView hrView, TextView monthTv, CardView nextBtn, CardView previousBtn, RecyclerView rvAttendance, RecyclerView rvCalender, MaterialCardView segmentView, MaterialCardView spinnerLt, Spinner spinnerSem, SwipeRefreshLayout swipeLayout, TextView toolbar, MaterialCardView totalCv, LinearLayout withBtn, View withTv, LinearLayout withoutBtn, View withoutTv) {
        super(_bindingComponent, _root, _localFieldCount);
        this.atteandceByDayLyt = atteandceByDayLyt;
        this.attendanceByPer = attendanceByPer;
        this.attendanceBySub = attendanceBySub;
        this.attendanceByTotal = attendanceByTotal;
        this.byDayBtn = byDayBtn;
        this.bySubjectBtn = bySubjectBtn;
        this.bySubjectLyt = bySubjectLyt;
        this.hrView = hrView;
        this.monthTv = monthTv;
        this.nextBtn = nextBtn;
        this.previousBtn = previousBtn;
        this.rvAttendance = rvAttendance;
        this.rvCalender = rvCalender;
        this.segmentView = segmentView;
        this.spinnerLt = spinnerLt;
        this.spinnerSem = spinnerSem;
        this.swipeLayout = swipeLayout;
        this.toolbar = toolbar;
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