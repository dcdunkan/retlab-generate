package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.textfield.TextInputEditText;
import in.etuwa.app.R;
import in.etuwa.app.ui.profile.updateabc.UpdateAbcViewModel;

/* loaded from: classes3.dex */
public abstract class DialogAbcUpdateBinding extends ViewDataBinding {
    public final TextInputEditText etAbcId;
    public final TextView helpBtn;

    @Bindable
    protected UpdateAbcViewModel mUpdateAbcViewModel;
    public final TextView updateBtn;
    public final TextView viewInstructionBtn;

    public abstract void setUpdateAbcViewModel(UpdateAbcViewModel updateAbcViewModel);

    protected DialogAbcUpdateBinding(Object _bindingComponent, View _root, int _localFieldCount, TextInputEditText etAbcId, TextView helpBtn, TextView updateBtn, TextView viewInstructionBtn) {
        super(_bindingComponent, _root, _localFieldCount);
        this.etAbcId = etAbcId;
        this.helpBtn = helpBtn;
        this.updateBtn = updateBtn;
        this.viewInstructionBtn = viewInstructionBtn;
    }

    public UpdateAbcViewModel getUpdateAbcViewModel() {
        return this.mUpdateAbcViewModel;
    }

    public static DialogAbcUpdateBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogAbcUpdateBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (DialogAbcUpdateBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_abc_update, root, attachToRoot, component);
    }

    public static DialogAbcUpdateBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogAbcUpdateBinding inflate(LayoutInflater inflater, Object component) {
        return (DialogAbcUpdateBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_abc_update, null, false, component);
    }

    public static DialogAbcUpdateBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogAbcUpdateBinding bind(View view, Object component) {
        return (DialogAbcUpdateBinding) bind(component, view, R.layout.dialog_abc_update);
    }
}