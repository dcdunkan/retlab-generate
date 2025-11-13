package in.etuwa.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import in.etuwa.app.R;
import in.etuwa.app.ui.transport.payment.dialog.TrasportFeePayViewModel;

/* loaded from: classes3.dex */
public class DialogTransportFeePayBindingImpl extends DialogTransportFeePayBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final FrameLayout mboundView0;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.due_layout, 1);
        sparseIntArray.put(R.id.tv_amount, 2);
        sparseIntArray.put(R.id.tv_fine, 3);
        sparseIntArray.put(R.id.tv_total, 4);
        sparseIntArray.put(R.id.pay_now_btn, 5);
    }

    public DialogTransportFeePayBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds));
    }

    private DialogTransportFeePayBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (LinearLayout) bindings[1], (TextView) bindings[5], (TextView) bindings[2], (TextView) bindings[3], (TextView) bindings[4]);
        this.mDirtyFlags = -1L;
        FrameLayout frameLayout = (FrameLayout) bindings[0];
        this.mboundView0 = frameLayout;
        frameLayout.setTag(null);
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
        if (229 != variableId) {
            return false;
        }
        setTrasportFeePayViewModel((TrasportFeePayViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.DialogTransportFeePayBinding
    public void setTrasportFeePayViewModel(TrasportFeePayViewModel TrasportFeePayViewModel) {
        this.mTrasportFeePayViewModel = TrasportFeePayViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}