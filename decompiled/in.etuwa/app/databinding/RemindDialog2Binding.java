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
import in.etuwa.app.ui.counselling.remind.ReminderDialogViewModel;

/* loaded from: classes3.dex */
public abstract class RemindDialog2Binding extends ViewDataBinding {
    public final EditText etRemind;

    @Bindable
    protected ReminderDialogViewModel mReminderDialogViewModel;
    public final TextView remindBtn;

    public abstract void setReminderDialogViewModel(ReminderDialogViewModel reminderDialogViewModel);

    protected RemindDialog2Binding(Object _bindingComponent, View _root, int _localFieldCount, EditText etRemind, TextView remindBtn) {
        super(_bindingComponent, _root, _localFieldCount);
        this.etRemind = etRemind;
        this.remindBtn = remindBtn;
    }

    public ReminderDialogViewModel getReminderDialogViewModel() {
        return this.mReminderDialogViewModel;
    }

    public static RemindDialog2Binding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RemindDialog2Binding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (RemindDialog2Binding) ViewDataBinding.inflateInternal(inflater, R.layout.remind_dialog2, root, attachToRoot, component);
    }

    public static RemindDialog2Binding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RemindDialog2Binding inflate(LayoutInflater inflater, Object component) {
        return (RemindDialog2Binding) ViewDataBinding.inflateInternal(inflater, R.layout.remind_dialog2, null, false, component);
    }

    public static RemindDialog2Binding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RemindDialog2Binding bind(View view, Object component) {
        return (RemindDialog2Binding) bind(component, view, R.layout.remind_dialog2);
    }
}