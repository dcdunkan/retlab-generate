package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import in.etuwa.app.R;
import in.etuwa.app.ui.grievance.remind.RemindDialogViewModel;

/* loaded from: classes3.dex */
public abstract class RemindDialogBinding extends ViewDataBinding {
    public final EditText etRemind;

    @Bindable
    protected RemindDialogViewModel mRemindDialogViewModel;
    public final TextView remindBtn;

    public abstract void setRemindDialogViewModel(RemindDialogViewModel remindDialogViewModel);

    protected RemindDialogBinding(Object _bindingComponent, View _root, int _localFieldCount, EditText etRemind, TextView remindBtn) {
        super(_bindingComponent, _root, _localFieldCount);
        this.etRemind = etRemind;
        this.remindBtn = remindBtn;
    }

    public RemindDialogViewModel getRemindDialogViewModel() {
        return this.mRemindDialogViewModel;
    }

    public static RemindDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RemindDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (RemindDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.remind_dialog, root, attachToRoot, component);
    }

    public static RemindDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RemindDialogBinding inflate(LayoutInflater inflater, Object component) {
        return (RemindDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.remind_dialog, null, false, component);
    }

    public static RemindDialogBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RemindDialogBinding bind(View view, Object component) {
        return (RemindDialogBinding) bind(component, view, R.layout.remind_dialog);
    }
}