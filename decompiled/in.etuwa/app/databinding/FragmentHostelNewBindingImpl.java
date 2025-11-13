package in.etuwa.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import in.etuwa.app.R;
import in.etuwa.app.ui.hostelnew.HostelNewViewModel;

/* loaded from: classes3.dex */
public class FragmentHostelNewBindingImpl extends FragmentHostelNewBinding {
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
        sparseIntArray.put(R.id.pay_online_btn, 2);
        sparseIntArray.put(R.id.receipt_btn, 3);
        sparseIntArray.put(R.id.swipe_receipt_layout, 4);
        sparseIntArray.put(R.id.rv_receipts, 5);
        sparseIntArray.put(R.id.swipe_layout_history, 6);
        sparseIntArray.put(R.id.rv_admission_history, 7);
        sparseIntArray.put(R.id.rv_monthly_history, 8);
        sparseIntArray.put(R.id.swipe_layout, 9);
        sparseIntArray.put(R.id.rv_admission, 10);
        sparseIntArray.put(R.id.rv_monthly, 11);
        sparseIntArray.put(R.id.pay_btn_lyt, 12);
        sparseIntArray.put(R.id.tv_fee_engnr_total, 13);
        sparseIntArray.put(R.id.pay_fee_engnr_btn, 14);
    }

    public FragmentHostelNewBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 15, sIncludes, sViewsWithIds));
    }

    private FragmentHostelNewBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (LinearLayout) bindings[12], (TextView) bindings[14], (TextView) bindings[2], (TextView) bindings[3], (RecyclerView) bindings[10], (RecyclerView) bindings[7], (RecyclerView) bindings[11], (RecyclerView) bindings[8], (RecyclerView) bindings[5], (SwipeRefreshLayout) bindings[9], (SwipeRefreshLayout) bindings[6], (SwipeRefreshLayout) bindings[4], (TextView) bindings[13]);
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
        if (114 != variableId) {
            return false;
        }
        setHostelNewViewModel((HostelNewViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.FragmentHostelNewBinding
    public void setHostelNewViewModel(HostelNewViewModel HostelNewViewModel) {
        this.mHostelNewViewModel = HostelNewViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}