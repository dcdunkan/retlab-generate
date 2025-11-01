package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import in.etuwa.app.R;
import in.etuwa.app.ui.counselling.view.actions.Actions2DialogViewModel;

/* loaded from: classes3.dex */
public abstract class Actions2DialogBinding extends ViewDataBinding {

    @Bindable
    protected Actions2DialogViewModel mActionsDialogViewModel;
    public final RecyclerView rvActionLevels;

    public abstract void setActionsDialogViewModel(Actions2DialogViewModel actionsDialogViewModel);

    protected Actions2DialogBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView rvActionLevels) {
        super(_bindingComponent, _root, _localFieldCount);
        this.rvActionLevels = rvActionLevels;
    }

    public Actions2DialogViewModel getActionsDialogViewModel() {
        return this.mActionsDialogViewModel;
    }

    public static Actions2DialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static Actions2DialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (Actions2DialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.actions2_dialog, root, attachToRoot, component);
    }

    public static Actions2DialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static Actions2DialogBinding inflate(LayoutInflater inflater, Object component) {
        return (Actions2DialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.actions2_dialog, null, false, component);
    }

    public static Actions2DialogBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static Actions2DialogBinding bind(View view, Object component) {
        return (Actions2DialogBinding) bind(component, view, R.layout.actions2_dialog);
    }
}