package in.etuwa.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import in.etuwa.app.R;
import in.etuwa.app.ui.profile.bankdetails.BankDetailsViewModel;

/* loaded from: classes3.dex */
public class DialogBankDetailsBindingImpl extends DialogBankDetailsBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ScrollView mboundView0;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.edit_btn, 1);
        sparseIntArray.put(R.id.bank_name_tv, 2);
        sparseIntArray.put(R.id.name, 3);
        sparseIntArray.put(R.id.name_et, 4);
        sparseIntArray.put(R.id.view1, 5);
        sparseIntArray.put(R.id.branch_name_tv, 6);
        sparseIntArray.put(R.id.branch, 7);
        sparseIntArray.put(R.id.branch_et, 8);
        sparseIntArray.put(R.id.view2, 9);
        sparseIntArray.put(R.id.acc_no_tv, 10);
        sparseIntArray.put(R.id.acc_no, 11);
        sparseIntArray.put(R.id.acc_no_et, 12);
        sparseIntArray.put(R.id.retype_acc_lyt, 13);
        sparseIntArray.put(R.id.retype_acc_no_tv, 14);
        sparseIntArray.put(R.id.retype_acc_no_et, 15);
        sparseIntArray.put(R.id.view4, 16);
        sparseIntArray.put(R.id.ifsc_tv, 17);
        sparseIntArray.put(R.id.ifsc, 18);
        sparseIntArray.put(R.id.ifsc_et, 19);
        sparseIntArray.put(R.id.update_lyt, 20);
        sparseIntArray.put(R.id.update_btn, 21);
    }

    public DialogBankDetailsBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 22, sIncludes, sViewsWithIds));
    }

    private DialogBankDetailsBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (TextView) bindings[11], (EditText) bindings[12], (TextView) bindings[10], (TextView) bindings[2], (TextView) bindings[7], (EditText) bindings[8], (TextView) bindings[6], (TextView) bindings[1], (TextView) bindings[18], (EditText) bindings[19], (TextView) bindings[17], (TextView) bindings[3], (EditText) bindings[4], (LinearLayout) bindings[13], (EditText) bindings[15], (TextView) bindings[14], (TextView) bindings[21], (LinearLayout) bindings[20], (TextView) bindings[5], (TextView) bindings[9], (TextView) bindings[16]);
        this.mDirtyFlags = -1L;
        ScrollView scrollView = (ScrollView) bindings[0];
        this.mboundView0 = scrollView;
        scrollView.setTag(null);
        setRootTag(root);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.mDirtyFlags != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int variableId, Object variable) {
        if (38 != variableId) {
            return false;
        }
        setBankDetailsViewModel((BankDetailsViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.DialogBankDetailsBinding
    public void setBankDetailsViewModel(BankDetailsViewModel BankDetailsViewModel) {
        this.mBankDetailsViewModel = BankDetailsViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}