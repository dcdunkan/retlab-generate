package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import in.etuwa.app.R;
import in.etuwa.app.ui.lab.equipment.labequipments.EquipmentViewModel;

/* loaded from: classes3.dex */
public abstract class EquipmentFragmentBinding extends ViewDataBinding {

    @Bindable
    protected EquipmentViewModel mEquipmentViewModel;
    public final RecyclerView rvLabEquipment;
    public final SwipeRefreshLayout swipeLayout;

    public abstract void setEquipmentViewModel(EquipmentViewModel equipmentViewModel);

    protected EquipmentFragmentBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView rvLabEquipment, SwipeRefreshLayout swipeLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.rvLabEquipment = rvLabEquipment;
        this.swipeLayout = swipeLayout;
    }

    public EquipmentViewModel getEquipmentViewModel() {
        return this.mEquipmentViewModel;
    }

    public static EquipmentFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static EquipmentFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (EquipmentFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.equipment_fragment, root, attachToRoot, component);
    }

    public static EquipmentFragmentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static EquipmentFragmentBinding inflate(LayoutInflater inflater, Object component) {
        return (EquipmentFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.equipment_fragment, null, false, component);
    }

    public static EquipmentFragmentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static EquipmentFragmentBinding bind(View view, Object component) {
        return (EquipmentFragmentBinding) bind(component, view, R.layout.equipment_fragment);
    }
}