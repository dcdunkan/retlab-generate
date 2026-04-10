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
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import in.etuwa.app.R;
import in.etuwa.app.ui.hostel.attendance.applyleave.HostelApplyLeaveViewModel;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DialogApplyHostelAttendanceBinding extends ViewDataBinding {
    public final TextView etEndDate;
    public final TextView etEndDateTime;
    public final TextView etFromDate;
    public final TextView etFromDateTime;
    public final TextInputEditText etReason;
    public final CardView ltEndDate;
    public final CardView ltEndDateTime;
    public final CardView ltFromDate;
    public final CardView ltFromDateTime;

    @Bindable
    protected HostelApplyLeaveViewModel mHostelApplyLeaveViewModel;
    public final MaterialButton saveBtn;
    public final Spinner spinnerDateType;
    public final Spinner spinnerLeaveType;

    public abstract void setHostelApplyLeaveViewModel(HostelApplyLeaveViewModel hostelApplyLeaveViewModel);

    protected DialogApplyHostelAttendanceBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView etEndDate, TextView etEndDateTime, TextView etFromDate, TextView etFromDateTime, TextInputEditText etReason, CardView ltEndDate, CardView ltEndDateTime, CardView ltFromDate, CardView ltFromDateTime, MaterialButton saveBtn, Spinner spinnerDateType, Spinner spinnerLeaveType) {
        super(_bindingComponent, _root, _localFieldCount);
        this.etEndDate = etEndDate;
        this.etEndDateTime = etEndDateTime;
        this.etFromDate = etFromDate;
        this.etFromDateTime = etFromDateTime;
        this.etReason = etReason;
        this.ltEndDate = ltEndDate;
        this.ltEndDateTime = ltEndDateTime;
        this.ltFromDate = ltFromDate;
        this.ltFromDateTime = ltFromDateTime;
        this.saveBtn = saveBtn;
        this.spinnerDateType = spinnerDateType;
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