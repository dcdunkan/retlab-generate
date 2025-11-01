package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.textfield.TextInputEditText;
import in.etuwa.app.R;
import in.etuwa.app.ui.hostel.attendance.applyleave.HostelApplyLeaveViewModel;

/* loaded from: classes3.dex */
public abstract class DialogApplyHostelAttendanceBinding extends ViewDataBinding {
    public final TextView etEndDate;
    public final TextView etFromDate;
    public final TextInputEditText etReason;
    public final CardView ltEndDate;
    public final CardView ltFromDate;

    @Bindable
    protected HostelApplyLeaveViewModel mHostelApplyLeaveViewModel;
    public final TextView saveBtn;
    public final Spinner spinnerLeaveType;

    public abstract void setHostelApplyLeaveViewModel(HostelApplyLeaveViewModel hostelApplyLeaveViewModel);

    protected DialogApplyHostelAttendanceBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView etEndDate, TextView etFromDate, TextInputEditText etReason, CardView ltEndDate, CardView ltFromDate, TextView saveBtn, Spinner spinnerLeaveType) {
        super(_bindingComponent, _root, _localFieldCount);
        this.etEndDate = etEndDate;
        this.etFromDate = etFromDate;
        this.etReason = etReason;
        this.ltEndDate = ltEndDate;
        this.ltFromDate = ltFromDate;
        this.saveBtn = saveBtn;
        this.spinnerLeaveType = spinnerLeaveType;
    }

    public HostelApplyLeaveViewModel getHostelApplyLeaveViewModel() {
        return this.mHostelApplyLeaveViewModel;
    }

    public static DialogApplyHostelAttendanceBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogApplyHostelAttendanceBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (DialogApplyHostelAttendanceBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_apply_hostel_attendance, root, attachToRoot, component);
    }

    public static DialogApplyHostelAttendanceBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogApplyHostelAttendanceBinding inflate(LayoutInflater inflater, Object component) {
        return (DialogApplyHostelAttendanceBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_apply_hostel_attendance, null, false, component);
    }

    public static DialogApplyHostelAttendanceBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogApplyHostelAttendanceBinding bind(View view, Object component) {
        return (DialogApplyHostelAttendanceBinding) bind(component, view, R.layout.dialog_apply_hostel_attendance);
    }
}