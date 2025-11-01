package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import in.etuwa.app.R;
import in.etuwa.app.ui.attendance.bydaynew.attendaceday.AttendanceDayDialogViewModel;

/* loaded from: classes3.dex */
public abstract class AttendanceByDayDialogBinding extends ViewDataBinding {
    public final LinearLayout attandamceBydayLayout1;
    public final TextView coverage1;
    public final TextView coverage2;
    public final TextView coverage3;
    public final TextView coverage4;
    public final TextView coverage5;
    public final TextView coverage6;
    public final TextView coverage7;
    public final TextView coverage8;
    public final TextView dateTitle;
    public final LinearLayout linearcoverage1;
    public final LinearLayout linearcoverage2;
    public final LinearLayout linearcoverage3;
    public final LinearLayout linearcoverage4;
    public final LinearLayout linearcoverage5;
    public final LinearLayout linearcoverage6;
    public final LinearLayout linearcoverage7;
    public final LinearLayout linearcoverage8;
    public final LinearLayout linearlt;

    @Bindable
    protected AttendanceDayDialogViewModel mAttendanceDayDialogViewModel;
    public final TextView notMarkedText;
    public final TextView period1;
    public final TextView period2;
    public final TextView period3;
    public final TextView period4;
    public final TextView period5;
    public final TextView period6;
    public final TextView period7;
    public final TextView period8;
    public final TextView subjectName1;
    public final TextView subjectName2;
    public final TextView subjectName3;
    public final TextView subjectName4;
    public final TextView subjectName5;
    public final TextView subjectName6;
    public final TextView subjectName7;
    public final TextView subjectName8;
    public final View view1;
    public final View view2;

    public abstract void setAttendanceDayDialogViewModel(AttendanceDayDialogViewModel attendanceDayDialogViewModel);

    protected AttendanceByDayDialogBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout attandamceBydayLayout1, TextView coverage1, TextView coverage2, TextView coverage3, TextView coverage4, TextView coverage5, TextView coverage6, TextView coverage7, TextView coverage8, TextView dateTitle, LinearLayout linearcoverage1, LinearLayout linearcoverage2, LinearLayout linearcoverage3, LinearLayout linearcoverage4, LinearLayout linearcoverage5, LinearLayout linearcoverage6, LinearLayout linearcoverage7, LinearLayout linearcoverage8, LinearLayout linearlt, TextView notMarkedText, TextView period1, TextView period2, TextView period3, TextView period4, TextView period5, TextView period6, TextView period7, TextView period8, TextView subjectName1, TextView subjectName2, TextView subjectName3, TextView subjectName4, TextView subjectName5, TextView subjectName6, TextView subjectName7, TextView subjectName8, View view1, View view2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.attandamceBydayLayout1 = attandamceBydayLayout1;
        this.coverage1 = coverage1;
        this.coverage2 = coverage2;
        this.coverage3 = coverage3;
        this.coverage4 = coverage4;
        this.coverage5 = coverage5;
        this.coverage6 = coverage6;
        this.coverage7 = coverage7;
        this.coverage8 = coverage8;
        this.dateTitle = dateTitle;
        this.linearcoverage1 = linearcoverage1;
        this.linearcoverage2 = linearcoverage2;
        this.linearcoverage3 = linearcoverage3;
        this.linearcoverage4 = linearcoverage4;
        this.linearcoverage5 = linearcoverage5;
        this.linearcoverage6 = linearcoverage6;
        this.linearcoverage7 = linearcoverage7;
        this.linearcoverage8 = linearcoverage8;
        this.linearlt = linearlt;
        this.notMarkedText = notMarkedText;
        this.period1 = period1;
        this.period2 = period2;
        this.period3 = period3;
        this.period4 = period4;
        this.period5 = period5;
        this.period6 = period6;
        this.period7 = period7;
        this.period8 = period8;
        this.subjectName1 = subjectName1;
        this.subjectName2 = subjectName2;
        this.subjectName3 = subjectName3;
        this.subjectName4 = subjectName4;
        this.subjectName5 = subjectName5;
        this.subjectName6 = subjectName6;
        this.subjectName7 = subjectName7;
        this.subjectName8 = subjectName8;
        this.view1 = view1;
        this.view2 = view2;
    }

    public AttendanceDayDialogViewModel getAttendanceDayDialogViewModel() {
        return this.mAttendanceDayDialogViewModel;
    }

    public static AttendanceByDayDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AttendanceByDayDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (AttendanceByDayDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.attendance_by_day_dialog, root, attachToRoot, component);
    }

    public static AttendanceByDayDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AttendanceByDayDialogBinding inflate(LayoutInflater inflater, Object component) {
        return (AttendanceByDayDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.attendance_by_day_dialog, null, false, component);
    }

    public static AttendanceByDayDialogBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AttendanceByDayDialogBinding bind(View view, Object component) {
        return (AttendanceByDayDialogBinding) bind(component, view, R.layout.attendance_by_day_dialog);
    }
}