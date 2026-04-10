package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import in.etuwa.app.R;
import in.etuwa.app.ui.profile.bankdetails.BankDetailsViewModel;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DialogBankDetailsBinding extends ViewDataBinding {
    public final TextView accNo;
    public final TextInputEditText accNoEt;
    public final TextView accNoTv;
    public final TextView bankNameTv;
    public final TextView branch;
    public final TextInputEditText branchEt;
    public final TextView branchNameTv;
    public final TextView editBtn;
    public final TextView ifsc;
    public final TextInputEditText ifscEt;
    public final TextView ifscTv;

    @Bindable
    protected BankDetailsViewModel mBankDetailsViewModel;
    public final TextView name;
    public final TextInputEditText nameEt;
    public final LinearLayout retypeAccLyt;
    public final TextInputEditText retypeAccNoEt;
    public final TextView retypeAccNoTv;
    public final MaterialButton updateBtn;
    public final LinearLayout updateLyt;
    public final View view1;
    public final View view2;
    public final View view4;

    public abstract void setBankDetailsViewModel(BankDetailsViewModel bankDetailsViewModel);

    protected DialogBankDetailsBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView accNo, TextInputEditText accNoEt, TextView accNoTv, TextView bankNameTv, TextView branch, TextInputEditText branchEt, TextView branchNameTv, TextView editBtn, TextView ifsc, TextInputEditText ifscEt, TextView ifscTv, TextView name, TextInputEditText nameEt, LinearLayout retypeAccLyt, TextInputEditText retypeAccNoEt, TextView retypeAccNoTv, MaterialButton updateBtn, LinearLayout updateLyt, View view1, View view2, View view4) {
        super(_bindingComponent, _root, _localFieldCount);
        this.accNo = accNo;
        this.accNoEt = accNoEt;
        this.accNoTv = accNoTv;
        this.bankNameTv = bankNameTv;
        this.branch = branch;
        this.branchEt = branchEt;
        this.branchNameTv = branchNameTv;
        this.editBtn = editBtn;
        this.ifsc = ifsc;
        this.ifscEt = ifscEt;
        this.ifscTv = ifscTv;
        this.name = name;
        this.nameEt = nameEt;
        this.retypeAccLyt = retypeAccLyt;
        this.retypeAccNoEt = retypeAccNoEt;
        this.retypeAccNoTv = retypeAccNoTv;
        this.updateBtn = updateBtn;
        this.updateLyt = updateLyt;
        this.view1 = view1;
        this.view2 = view2;
        this.view4 = view4;
    }

    public BankDetailsViewModel getBankDetailsViewModel() {
        return this.mBankDetailsViewModel;
    }

    public static DialogBankDetailsBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogBankDetailsBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (DialogBankDetailsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_bank_details, root, attachToRoot, component);
    }

    public static DialogBankDetailsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogBankDetailsBinding inflate(LayoutInflater inflater, Object component) {
        return (DialogBankDetailsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_bank_details, null, false, component);
    }

    public static DialogBankDetailsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogBankDetailsBinding bind(View view, Object component) {
        return (DialogBankDetailsBinding) bind(component, view, R.layout.dialog_bank_details);
    }
}