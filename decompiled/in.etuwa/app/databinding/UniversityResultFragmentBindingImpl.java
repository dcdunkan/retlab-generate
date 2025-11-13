package in.etuwa.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import in.etuwa.app.R;
import in.etuwa.app.ui.university.UniversityResultViewModel;

/* loaded from: classes3.dex */
public class UniversityResultFragmentBindingImpl extends UniversityResultFragmentBinding {
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
        sparseIntArray.put(R.id.reg_no, 3);
        sparseIntArray.put(R.id.branch_name, 4);
        sparseIntArray.put(R.id.prog_name, 5);
        sparseIntArray.put(R.id.sem_name, 6);
        sparseIntArray.put(R.id.download_btn, 7);
        sparseIntArray.put(R.id.swipe_layout, 8);
        sparseIntArray.put(R.id.rv_result_list, 9);
        sparseIntArray.put(R.id.tv_earned_credit, 10);
        sparseIntArray.put(R.id.tv_sgpa, 11);
    }

    public UniversityResultFragmentBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 12, sIncludes, sViewsWithIds));
    }

    private UniversityResultFragmentBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (TextView) bindings[4], (TextView) bindings[7], (TextView) bindings[5], (TextView) bindings[3], (RecyclerView) bindings[9], (TextView) bindings[6], (LinearLayout) bindings[8], (TextView) bindings[10], (TextView) bindings[11]);
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
        if (234 != variableId) {
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