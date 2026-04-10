package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.button.MaterialButton;
import in.etuwa.app.R;
import in.etuwa.app.ui.changepassword.ChangePasswordViewModel;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DialogChangePasswordBinding extends ViewDataBinding {
    public final MaterialButton changePassBtn;
    public final EditText etConfirmPass;
    public final EditText etCurrentPassword;
    public final EditText etNewPassword;

    @Bindable
    protected ChangePasswordViewModel mChangePasswordDialogViewModel;

    public abstract void setChangePasswordDialogViewModel(ChangePasswordViewModel changePasswordDialogViewModel);

    protected DialogChangePasswordBinding(Object _bindingComponent, View _root, int _localFieldCount, MaterialButton changePassBtn, EditText etConfirmPass, EditText etCurrentPassword, EditText etNewPassword) {
        super(_bindingComponent, _root, _localFieldCount);
        this.changePassBtn = changePassBtn;
        this.etConfirmPass = etConfirmPass;
        this.etCurrentPassword = etCurrentPassword;
        this.etNewPassword = etNewPassword;
    }

    public ChangePasswordViewModel getChangePasswordDialogViewModel() {
        return this.mChangePasswordDialogViewModel;
    }

    public static DialogChangePasswordBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogChangePasswordBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (DialogChangePasswordBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_change_password, root, attachToRoot, component);
    }

    public static DialogChangePasswordBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogChangePasswordBinding inflate(LayoutInflater inflater, Object component) {
        return (DialogChangePasswordBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_change_password, null, false, component);
    }

    public static DialogChangePasswordBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogChangePasswordBinding bind(View view, Object component) {
        return (DialogChangePasswordBinding) bind(component, view, R.layout.dialog_change_password);
    }
}