package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import in.etuwa.app.R;
import in.etuwa.app.ui.grievance.view.cellmembers.CellMemberDialogViewModel;

/* loaded from: classes3.dex */
public abstract class CellMemberDialogBinding extends ViewDataBinding {

    @Bindable
    protected CellMemberDialogViewModel mCellMemberDialogViewModel;
    public final RecyclerView rvCellMembers;

    public abstract void setCellMemberDialogViewModel(CellMemberDialogViewModel cellMemberDialogViewModel);

    protected CellMemberDialogBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView rvCellMembers) {
        super(_bindingComponent, _root, _localFieldCount);
        this.rvCellMembers = rvCellMembers;
    }

    public CellMemberDialogViewModel getCellMemberDialogViewModel() {
        return this.mCellMemberDialogViewModel;
    }

    public static CellMemberDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CellMemberDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (CellMemberDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.cell_member_dialog, root, attachToRoot, component);
    }

    public static CellMemberDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CellMemberDialogBinding inflate(LayoutInflater inflater, Object component) {
        return (CellMemberDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.cell_member_dialog, null, false, component);
    }

    public static CellMemberDialogBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CellMemberDialogBinding bind(View view, Object component) {
        return (CellMemberDialogBinding) bind(component, view, R.layout.cell_member_dialog);
    }
}