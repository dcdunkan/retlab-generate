package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import in.etuwa.app.R;
import in.etuwa.app.ui.counselling.view.cellmembers.CellMember2DialogViewModel;

/* loaded from: classes3.dex */
public abstract class CellMember2DialogBinding extends ViewDataBinding {

    @Bindable
    protected CellMember2DialogViewModel mCellMember2DialogViewModel;
    public final RecyclerView rvCellMembers;

    public abstract void setCellMember2DialogViewModel(CellMember2DialogViewModel cellMember2DialogViewModel);

    protected CellMember2DialogBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView rvCellMembers) {
        super(_bindingComponent, _root, _localFieldCount);
        this.rvCellMembers = rvCellMembers;
    }

    public CellMember2DialogViewModel getCellMember2DialogViewModel() {
        return this.mCellMember2DialogViewModel;
    }

    public static CellMember2DialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CellMember2DialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (CellMember2DialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.cell_member2_dialog, root, attachToRoot, component);
    }

    public static CellMember2DialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CellMember2DialogBinding inflate(LayoutInflater inflater, Object component) {
        return (CellMember2DialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.cell_member2_dialog, null, false, component);
    }

    public static CellMember2DialogBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CellMember2DialogBinding bind(View view, Object component) {
        return (CellMember2DialogBinding) bind(component, view, R.layout.cell_member2_dialog);
    }
}