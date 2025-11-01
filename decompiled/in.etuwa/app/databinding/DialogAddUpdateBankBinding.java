package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import in.etuwa.app.R;
import in.etuwa.app.ui.profile.addupdatebank.AddUpdateBankViewModel;

/* loaded from: classes3.dex */
public abstract class DialogAddUpdateBankBinding extends ViewDataBinding {
    public final TextInputEditText etAccno;
    public final TextInputEditText etBankName;
    public final TextInputEditText etBranchName;
    public final TextInputEditText etConfirmAccno;
    public final TextInputEditText etIfscCode;

    @Bindable
    protected AddUpdateBankViewModel mAddUpdateBankViewModel;
    public final TextInputLayout reEnterAccEt;
    public final TextView updateBtn;
    public final TextView verifyBtn;

    public abstract void setAddUpdateBankViewModel(AddUpdateBankViewModel addUpdateBankViewModel);

    protected DialogAddUpdateBankBinding(Object _bindingComponent, View _root, int _localFieldCount, TextInputEditText etAccno, TextInputEditText etBankName, TextInputEditText etBranchName, TextInputEditText etConfirmAccno, TextInputEditText etIfscCode, TextInputLayout reEnterAccEt, TextView updateBtn, TextView verifyBtn) {
        super(_bindingComponent, _root, _localFieldCount);
        this.etAccno = etAccno;
        this.etBankName = etBankName;
        this.etBranchName = etBranchName;
        this.etConfirmAccno = etConfirmAccno;
        this.etIfscCode = etIfscCode;
        this.reEnterAccEt = reEnterAccEt;
        this.updateBtn = updateBtn;
        this.verifyBtn = verifyBtn;
    }

    public AddUpdateBankViewModel getAddUpdateBankViewModel() {
        return this.mAddUpdateBankViewModel;
    }

    public static DialogAddUpdateBankBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogAddUpdateBankBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (DialogAddUpdateBankBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_add_update_bank, root, attachToRoot, component);
    }

    public static DialogAddUpdateBankBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogAddUpdateBankBinding inflate(LayoutInflater inflater, Object component) {
        return (DialogAddUpdateBankBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_add_update_bank, null, false, component);
    }

    public static DialogAddUpdateBankBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogAddUpdateBankBinding bind(View view, Object component) {
        return (DialogAddUpdateBankBinding) bind(component, view, R.layout.dialog_add_update_bank);
    }
}