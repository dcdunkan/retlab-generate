package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import in.etuwa.app.R;
import in.etuwa.app.ui.profile.bankdetails.BankDetailsViewModel;

/* loaded from: classes3.dex */
public abstract class DialogBankDetailsBinding extends ViewDataBinding {
    public final TextView accNo;
    public final EditText accNoEt;
    public final TextView accNoTv;
    public final TextView bankNameTv;
    public final TextView branch;
    public final EditText branchEt;
    public final TextView branchNameTv;
    public final TextView editBtn;
    public final TextView ifsc;
    public final EditText ifscEt;
    public final TextView ifscTv;

    @Bindable
    protected BankDetailsViewModel mBankDetailsViewModel;
    public final TextView name;
    public final EditText nameEt;
    public final LinearLayout retypeAccLyt;
    public final EditText retypeAccNoEt;
    public final TextView retypeAccNoTv;
    public final TextView updateBtn;
    public final LinearLayout updateLyt;
    public final TextView view1;
    public final TextView view2;
    public final TextView view4;

    public abstract void setBankDetailsViewModel(BankDetailsViewModel bankDetailsViewModel);

    protected DialogBankDetailsBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView accNo, EditText accNoEt, TextView accNoTv, TextView bankNameTv, TextView branch, EditText branchEt, TextView branchNameTv, TextView editBtn, TextView ifsc, EditText ifscEt, TextView ifscTv, TextView name, EditText nameEt, LinearLayout retypeAccLyt, EditText retypeAccNoEt, TextView retypeAccNoTv, TextView updateBtn, LinearLayout updateLyt, TextView view1, TextView view2, TextView view4) {
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