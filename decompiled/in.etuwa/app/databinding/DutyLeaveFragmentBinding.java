package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import in.etuwa.app.R;
import in.etuwa.app.ui.leave.duty.DutyLeaveViewModel;

/* loaded from: classes3.dex */
public abstract class DutyLeaveFragmentBinding extends ViewDataBinding {
    public final TextView directApplyBtn;

    @Bindable
    protected DutyLeaveViewModel mDutyLeaveViewModel;
    public final RecyclerView rvDutyLeave;
    public final Spinner spinnerLeave;

    public abstract void setDutyLeaveViewModel(DutyLeaveViewModel dutyLeaveViewModel);

    protected DutyLeaveFragmentBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView directApplyBtn, RecyclerView rvDutyLeave, Spinner spinnerLeave) {
        super(_bindingComponent, _root, _localFieldCount);
        this.directApplyBtn = directApplyBtn;
        this.rvDutyLeave = rvDutyLeave;
        this.spinnerLeave = spinnerLeave;
    }

    public DutyLeaveViewModel getDutyLeaveViewModel() {
        return this.mDutyLeaveViewModel;
    }

    public static DutyLeaveFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DutyLeaveFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (DutyLeaveFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.duty_leave_fragment, root, attachToRoot, component);
    }

    public static DutyLeaveFragmentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DutyLeaveFragmentBinding inflate(LayoutInflater inflater, Object component) {
        return (DutyLeaveFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.duty_leave_fragment, null, false, component);
    }

    public static DutyLeaveFragmentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DutyLeaveFragmentBinding bind(View view, Object component) {
        return (DutyLeaveFragmentBinding) bind(component, view, R.layout.duty_leave_fragment);
    }
}