package in.etuwa.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import in.etuwa.app.R;
import in.etuwa.app.ui.programoutcome.ProgramOutcomeViewModel;

/* JADX INFO: loaded from: classes3.dex */
public class FragmentProgramOutcomeBindingImpl extends FragmentProgramOutcomeBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ScrollView mboundView0;
    private final FrameLayout mboundView1;
    private final ViewProgressBarBinding mboundView11;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.toolbar, 3);
        sparseIntArray.put(R.id.hr_view, 4);
        sparseIntArray.put(R.id.outcome_btn, 5);
        sparseIntArray.put(R.id.educational_btn, 6);
        sparseIntArray.put(R.id.objectives_btn, 7);
        sparseIntArray.put(R.id.rv_outcome, 8);
        sparseIntArray.put(R.id.rv_educational, 9);
        sparseIntArray.put(R.id.rv_specific, 10);
    }

    public FragmentProgramOutcomeBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 11, sIncludes, sViewsWithIds));
    }

    private FragmentProgramOutcomeBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (TextView) bindings[6], (HorizontalScrollView) bindings[4], (TextView) bindings[7], (TextView) bindings[5], (RecyclerView) bindings[9], (RecyclerView) bindings[8], (RecyclerView) bindings[10], (TextView) bindings[3]);
        this.mDirtyFlags = -1L;
        ScrollView scrollView = (ScrollView) bindings[0];
        this.mboundView0 = scrollView;
        scrollView.setTag(null);
        FrameLayout frameLayout = (FrameLayout) bindings[1];
        this.mboundView1 = frameLayout;
        frameLayout.setTag(null);
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
        if (169 != variableId) {
            return false;
        }
        setProgramOutcomeViewModel((ProgramOutcomeViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.FragmentProgramOutcomeBinding
    public void setProgramOutcomeViewModel(ProgramOutcomeViewModel ProgramOutcomeViewModel) {
        this.mProgramOutcomeViewModel = ProgramOutcomeViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}