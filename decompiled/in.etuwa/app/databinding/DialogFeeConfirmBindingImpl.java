package in.etuwa.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import in.etuwa.app.R;
import in.etuwa.app.ui.feenewengineer.payment.feeconfirmdialog.FeeConfirmViewModel;

/* loaded from: classes3.dex */
public class DialogFeeConfirmBindingImpl extends DialogFeeConfirmBinding {
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
        sparseIntArray.put(R.id.reg_title, 1);
        sparseIntArray.put(R.id.sub_total, 2);
        sparseIntArray.put(R.id.fine, 3);
        sparseIntArray.put(R.id.total_amount, 4);
        sparseIntArray.put(R.id.pay_confirm_btn, 5);
    }

    public DialogFeeConfirmBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds));
    }

    private DialogFeeConfirmBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (TextView) bindings[3], (TextView) bindings[5], (TextView) bindings[1], (TextView) bindings[2], (TextView) bindings[4]);
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
        if (88 != variableId) {
            return false;
        }
        setFeeConfirmViewModel((FeeConfirmViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.DialogFeeConfirmBinding
    public void setFeeConfirmViewModel(FeeConfirmViewModel FeeConfirmViewModel) {
        this.mFeeConfirmViewModel = FeeConfirmViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}