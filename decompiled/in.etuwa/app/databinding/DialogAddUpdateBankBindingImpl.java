package in.etuwa.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import in.etuwa.app.R;
import in.etuwa.app.ui.profile.addupdatebank.AddUpdateBankViewModel;

/* loaded from: classes3.dex */
public class DialogAddUpdateBankBindingImpl extends DialogAddUpdateBankBinding {
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
        sparseIntArray.put(R.id.et_bank_name, 1);
        sparseIntArray.put(R.id.et_accno, 2);
        sparseIntArray.put(R.id.re_enter_acc_et, 3);
        sparseIntArray.put(R.id.et_confirm_accno, 4);
        sparseIntArray.put(R.id.et_branch_name, 5);
        sparseIntArray.put(R.id.et_ifsc_code, 6);
        sparseIntArray.put(R.id.verify_btn, 7);
        sparseIntArray.put(R.id.update_btn, 8);
    }

    public DialogAddUpdateBankBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 9, sIncludes, sViewsWithIds));
    }

    private DialogAddUpdateBankBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (TextInputEditText) bindings[2], (TextInputEditText) bindings[1], (TextInputEditText) bindings[5], (TextInputEditText) bindings[4], (TextInputEditText) bindings[6], (TextInputLayout) bindings[3], (TextView) bindings[8], (TextView) bindings[7]);
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
        if (23 != variableId) {
            return false;
        }
        setAddUpdateBankViewModel((AddUpdateBankViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.DialogAddUpdateBankBinding
    public void setAddUpdateBankViewModel(AddUpdateBankViewModel AddUpdateBankViewModel) {
        this.mAddUpdateBankViewModel = AddUpdateBankViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}