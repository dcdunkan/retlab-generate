package in.etuwa.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import in.etuwa.app.R;
import in.etuwa.app.ui.fees.FeeMainViewModel;

/* loaded from: classes3.dex */
public class FragmentFeeMainBindingImpl extends FragmentFeeMainBinding {
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
        sparseIntArray.put(R.id.pay_btn, 1);
        sparseIntArray.put(R.id.view_receipt, 2);
        sparseIntArray.put(R.id.tv_transport_view, 3);
        sparseIntArray.put(R.id.transport_fee_btn, 4);
        sparseIntArray.put(R.id.transport_reg_btn, 5);
        sparseIntArray.put(R.id.transport_history_btn, 6);
        sparseIntArray.put(R.id.view_transport_receipt, 7);
        sparseIntArray.put(R.id.view_transport_buspass, 8);
        sparseIntArray.put(R.id.payment_gateway_btn, 9);
        sparseIntArray.put(R.id.deal_btn_view, 10);
        sparseIntArray.put(R.id.deal_btn, 11);
    }

    public FragmentFeeMainBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 12, sIncludes, sViewsWithIds));
    }

    private FragmentFeeMainBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (LinearLayout) bindings[11], (View) bindings[10], (LinearLayout) bindings[1], (LinearLayout) bindings[9], (LinearLayout) bindings[4], (LinearLayout) bindings[6], (LinearLayout) bindings[5], (TextView) bindings[3], (LinearLayout) bindings[2], (LinearLayout) bindings[8], (LinearLayout) bindings[7]);
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
        if (92 != variableId) {
            return false;
        }
        setFeeMainViewModel((FeeMainViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.FragmentFeeMainBinding
    public void setFeeMainViewModel(FeeMainViewModel FeeMainViewModel) {
        this.mFeeMainViewModel = FeeMainViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}