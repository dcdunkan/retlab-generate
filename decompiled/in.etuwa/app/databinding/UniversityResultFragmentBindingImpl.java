package in.etuwa.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import in.etuwa.app.R;
import in.etuwa.app.ui.university.UniversityResultViewModel;

/* JADX INFO: loaded from: classes3.dex */
public class UniversityResultFragmentBindingImpl extends UniversityResultFragmentBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ViewProgressBarBinding mboundView0;
    private final CoordinatorLayout mboundView01;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.reg_no, 2);
        sparseIntArray.put(R.id.branch_name, 3);
        sparseIntArray.put(R.id.prog_name, 4);
        sparseIntArray.put(R.id.sem_name, 5);
        sparseIntArray.put(R.id.download_btn, 6);
        sparseIntArray.put(R.id.swipe_layout, 7);
        sparseIntArray.put(R.id.rv_result_list, 8);
        sparseIntArray.put(R.id.tv_earned_credit, 9);
        sparseIntArray.put(R.id.tv_sgpa, 10);
    }

    public UniversityResultFragmentBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 11, sIncludes, sViewsWithIds));
    }

    private UniversityResultFragmentBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (TextView) bindings[3], (MaterialButton) bindings[6], (TextView) bindings[4], (TextView) bindings[2], (RecyclerView) bindings[8], (TextView) bindings[5], (LinearLayout) bindings[7], (TextView) bindings[9], (TextView) bindings[10]);
        this.mDirtyFlags = -1L;
        Object obj = bindings[1];
        this.mboundView0 = obj != null ? ViewProgressBarBinding.bind((View) obj) : null;
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) bindings[0];
        this.mboundView01 = coordinatorLayout;
        coordinatorLayout.setTag(null);
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
        if (236 != variableId) {
            return false;
        }
        setUniversityResultViewModel((UniversityResultViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.UniversityResultFragmentBinding
    public void setUniversityResultViewModel(UniversityResultViewModel UniversityResultViewModel) {
        this.mUniversityResultViewModel = UniversityResultViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}