package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import in.etuwa.app.R;
import in.etuwa.app.ui.grievance.view.actions.ActionsDialogViewModel;

/* loaded from: classes3.dex */
public abstract class ActionsDialogBinding extends ViewDataBinding {

    @Bindable
    protected ActionsDialogViewModel mActionsDialogViewModel;
    public final RecyclerView rvActionLevels;

    public abstract void setActionsDialogViewModel(ActionsDialogViewModel actionsDialogViewModel);

    protected ActionsDialogBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView rvActionLevels) {
        super(_bindingComponent, _root, _localFieldCount);
        this.rvActionLevels = rvActionLevels;
    }

    public ActionsDialogViewModel getActionsDialogViewModel() {
        return this.mActionsDialogViewModel;
    }

    public static ActionsDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActionsDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (ActionsDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.actions_dialog, root, attachToRoot, component);
    }

    public static ActionsDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActionsDialogBinding inflate(LayoutInflater inflater, Object component) {
        return (ActionsDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.actions_dialog, null, false, component);
    }

    public static ActionsDialogBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActionsDialogBinding bind(View view, Object component) {
        return (ActionsDialogBinding) bind(component, view, R.layout.actions_dialog);
    }
}