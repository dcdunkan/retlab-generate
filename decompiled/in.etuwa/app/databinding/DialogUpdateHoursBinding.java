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
import in.etuwa.app.ui.leave.duty.directapply.updatehours.UpdateHoursDirectViewModel;

/* loaded from: classes3.dex */
public abstract class DialogUpdateHoursBinding extends ViewDataBinding {
    public final TextView deleteBtn;

    @Bindable
    protected UpdateHoursDirectViewModel mUpdateHoursDirectViewModel;
    public final RecyclerView rvDates;
    public final RecyclerView rvHours;
    public final TextView tvDate;

    public abstract void setUpdateHoursDirectViewModel(UpdateHoursDirectViewModel updateHoursDirectViewModel);

    protected DialogUpdateHoursBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView deleteBtn, RecyclerView rvDates, RecyclerView rvHours, TextView tvDate) {
        super(_bindingComponent, _root, _localFieldCount);
        this.deleteBtn = deleteBtn;
        this.rvDates = rvDates;
        this.rvHours = rvHours;
        this.tvDate = tvDate;
    }

    public UpdateHoursDirectViewModel getUpdateHoursDirectViewModel() {
        return this.mUpdateHoursDirectViewModel;
    }

    public static DialogUpdateHoursBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogUpdateHoursBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (DialogUpdateHoursBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_update_hours, root, attachToRoot, component);
    }

    public static DialogUpdateHoursBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogUpdateHoursBinding inflate(LayoutInflater inflater, Object component) {
        return (DialogUpdateHoursBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_update_hours, null, false, component);
    }

    public static DialogUpdateHoursBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogUpdateHoursBinding bind(View view, Object component) {
        return (DialogUpdateHoursBinding) bind(component, view, R.layout.dialog_update_hours);
    }
}