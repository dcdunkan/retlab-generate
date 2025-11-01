package in.etuwa.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import in.etuwa.app.R;
import in.etuwa.app.ui.feenewarts.payment.FeeArtsViewModel;

/* loaded from: classes3.dex */
public class FragmentFeeArtsBindingImpl extends FragmentFeeArtsBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final FrameLayout mboundView0;
    private final CardView mboundView1;
    private final ViewProgressBarBinding mboundView11;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.series_layout, 3);
        sparseIntArray.put(R.id.spinner_sem, 4);
        sparseIntArray.put(R.id.swipe_layout, 5);
        sparseIntArray.put(R.id.rv_fee_arts, 6);
        sparseIntArray.put(R.id.fine_layout, 7);
        sparseIntArray.put(R.id.tv_subtotal, 8);
        sparseIntArray.put(R.id.tv_fine, 9);
        sparseIntArray.put(R.id.tv_fee_arts_total, 10);
        sparseIntArray.put(R.id.pay_fee_arts_btn, 11);
    }

    public FragmentFeeArtsBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 12, sIncludes, sViewsWithIds));
    }

    private FragmentFeeArtsBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (LinearLayout) bindings[7], (TextView) bindings[11], (RecyclerView) bindings[6], (LinearLayout) bindings[3], (Spinner) bindings[4], (LinearLayout) bindings[5], (TextView) bindings[10], (TextView) bindings[9], (TextView) bindings[8]);
        this.mDirtyFlags = -1L;
        FrameLayout frameLayout = (FrameLayout) bindings[0];
        this.mboundView0 = frameLayout;
        frameLayout.setTag(null);
        CardView cardView = (CardView) bindings[1];
        this.mboundView1 = cardView;
        cardView.setTag(null);
        Object obj = bindings[2];
        this.mboundView11 = obj != null ? ViewProgressBarBinding.bind((View) obj) : null;
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
        if (87 != variableId) {
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