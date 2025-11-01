package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import in.etuwa.app.R;
import in.etuwa.app.ui.dashboard.maintenance.MaintenanceViewModel;

/* loaded from: classes3.dex */
public abstract class DialogMmaintenanceBinding extends ViewDataBinding {
    public final TextView closeBtn;

    @Bindable
    protected MaintenanceViewModel mMaintenanceViewModel;

    public abstract void setMaintenanceViewModel(MaintenanceViewModel MaintenanceViewModel);

    protected DialogMmaintenanceBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView closeBtn) {
        super(_bindingComponent, _root, _localFieldCount);
        this.closeBtn = closeBtn;
    }

    public MaintenanceViewModel getMaintenanceViewModel() {
        return this.mMaintenanceViewModel;
    }

    public static DialogMmaintenanceBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogMmaintenanceBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (DialogMmaintenanceBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_mmaintenance, root, attachToRoot, component);
    }

    public static DialogMmaintenanceBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogMmaintenanceBinding inflate(LayoutInflater inflater, Object component) {
        return (DialogMmaintenanceBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_mmaintenance, null, false, component);
    }

    public static DialogMmaintenanceBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogMmaintenanceBinding bind(View view, Object component) {
        return (DialogMmaintenanceBinding) bind(component, view, R.layout.dialog_mmaintenance);
    }
}