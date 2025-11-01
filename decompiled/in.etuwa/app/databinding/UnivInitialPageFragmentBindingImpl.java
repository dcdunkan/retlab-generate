package in.etuwa.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import in.etuwa.app.R;
import in.etuwa.app.ui.result.university.initialpage.UnivInitialPageViewModel;

/* loaded from: classes3.dex */
public class UnivInitialPageFragmentBindingImpl extends UnivInitialPageFragmentBinding {
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
        sparseIntArray.put(R.id.credits, 1);
        sparseIntArray.put(R.id.internal_mark_tv, 2);
        sparseIntArray.put(R.id.internal_mark, 3);
        sparseIntArray.put(R.id.sgpa, 4);
        sparseIntArray.put(R.id.cgpa, 5);
        sparseIntArray.put(R.id.result_status, 6);
        sparseIntArray.put(R.id.rv_univ_subjects, 7);
    }

    public UnivInitialPageFragmentBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 8, sIncludes, sViewsWithIds));
    }

    private UnivInitialPageFragmentBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (TextView) bindings[5], (TextView) bindings[1], (TextView) bindings[3], (TextView) bindings[2], (TextView) bindings[6], (RecyclerView) bindings[7], (TextView) bindings[4]);
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
        if (231 != variableId) {
            return false;
        }
        setUnivInitialPageViewModel((UnivInitialPageViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.UnivInitialPageFragmentBinding
    public void setUnivInitialPageViewModel(UnivInitialPageViewModel UnivInitialPageViewModel) {
        this.mUnivInitialPageViewModel = UnivInitialPageViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}