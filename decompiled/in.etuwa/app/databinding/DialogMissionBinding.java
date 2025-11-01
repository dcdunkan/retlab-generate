package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import in.etuwa.app.R;
import in.etuwa.app.ui.dashboard.missiondialog.MissionDialogViewModel;

/* loaded from: classes3.dex */
public abstract class DialogMissionBinding extends ViewDataBinding {

    @Bindable
    protected MissionDialogViewModel mMissionDialogViewModel;
    public final TextView misColg;
    public final TextView misDept;

    public abstract void setMissionDialogViewModel(MissionDialogViewModel missionDialogViewModel);

    protected DialogMissionBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView misColg, TextView misDept) {
        super(_bindingComponent, _root, _localFieldCount);
        this.misColg = misColg;
        this.misDept = misDept;
    }

    public MissionDialogViewModel getMissionDialogViewModel() {
        return this.mMissionDialogViewModel;
    }

    public static DialogMissionBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogMissionBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (DialogMissionBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_mission, root, attachToRoot, component);
    }

    public static DialogMissionBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogMissionBinding inflate(LayoutInflater inflater, Object component) {
        return (DialogMissionBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_mission, null, false, component);
    }

    public static DialogMissionBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogMissionBinding bind(View view, Object component) {
        return (DialogMissionBinding) bind(component, view, R.layout.dialog_mission);
    }
}