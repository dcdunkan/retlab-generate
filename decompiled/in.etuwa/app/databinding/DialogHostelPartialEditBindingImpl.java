package in.etuwa.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import in.etuwa.app.R;
import in.etuwa.app.ui.feepartial.hostel.edit.HostelPartialEditViewModel;

/* loaded from: classes3.dex */
public class DialogHostelPartialEditBindingImpl extends DialogHostelPartialEditBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final CardView mboundView0;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.month_lbl, 1);
        sparseIntArray.put(R.id.swipe_layout, 2);
        sparseIntArray.put(R.id.rv_hostel_fee, 3);
        sparseIntArray.put(R.id.confirm_btn, 4);
    }

    public DialogHostelPartialEditBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds));
    }

    private DialogHostelPartialEditBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (TextView) bindings[4], (TextView) bindings[1], (RecyclerView) bindings[3], (SwipeRefreshLayout) bindings[2]);
        this.mDirtyFlags = -1L;
        CardView cardView = (CardView) bindings[0];
        this.mboundView0 = cardView;
        cardView.setTag(null);
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
        if (116 != variableId) {
            return false;
        }
        setHostelPartialEditViewModel((HostelPartialEditViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.DialogHostelPartialEditBinding
    public void setHostelPartialEditViewModel(HostelPartialEditViewModel HostelPartialEditViewModel) {
        this.mHostelPartialEditViewModel = HostelPartialEditViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}