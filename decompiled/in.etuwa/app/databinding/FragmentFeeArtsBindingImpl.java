package in.etuwa.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import in.etuwa.app.R;
import in.etuwa.app.ui.feenewarts.payment.FeeArtsViewModel;

/* JADX INFO: loaded from: classes3.dex */
public class FragmentFeeArtsBindingImpl extends FragmentFeeArtsBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ViewProgressBarBinding mboundView0;
    private final FrameLayout mboundView01;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.series_layout, 2);
        sparseIntArray.put(R.id.spinner_sem, 3);
        sparseIntArray.put(R.id.swipe_layout, 4);
        sparseIntArray.put(R.id.rv_fee_arts, 5);
        sparseIntArray.put(R.id.fine_layout, 6);
        sparseIntArray.put(R.id.tv_subtotal, 7);
        sparseIntArray.put(R.id.tv_fine, 8);
        sparseIntArray.put(R.id.tv_fee_arts_total, 9);
        sparseIntArray.put(R.id.pay_fee_arts_btn, 10);
    }

    public FragmentFeeArtsBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 11, sIncludes, sViewsWithIds));
    }

    private FragmentFeeArtsBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (MaterialCardView) bindings[6], (MaterialButton) bindings[10], (RecyclerView) bindings[5], (MaterialCardView) bindings[2], (Spinner) bindings[3], (ScrollView) bindings[4], (TextView) bindings[9], (TextView) bindings[8], (TextView) bindings[7]);
        this.mDirtyFlags = -1L;
        Object obj = bindings[1];
        this.mboundView0 = obj != null ? ViewProgressBarBinding.bind((View) obj) : null;
        FrameLayout frameLayout = (FrameLayout) bindings[0];
        this.mboundView01 = frameLayout;
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
        if (88 != variableId) {
            return false;
        }
        setFeeArtsViewModel((FeeArtsViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.FragmentFeeArtsBinding
    public void setFeeArtsViewModel(FeeArtsViewModel FeeArtsViewModel) {
        this.mFeeArtsViewModel = FeeArtsViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}