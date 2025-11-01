package in.etuwa.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import in.etuwa.app.R;
import in.etuwa.app.ui.profile.parentdetails.ParentDetailsViewModel;

/* loaded from: classes3.dex */
public class DialogParentDetailsBindingImpl extends DialogParentDetailsBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ScrollView mboundView0;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.father_name, 1);
        sparseIntArray.put(R.id.father_number, 2);
        sparseIntArray.put(R.id.father_occ, 3);
        sparseIntArray.put(R.id.mother_name, 4);
        sparseIntArray.put(R.id.mother_num, 5);
        sparseIntArray.put(R.id.mother_occ, 6);
        sparseIntArray.put(R.id.email, 7);
    }

    public DialogParentDetailsBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 8, sIncludes, sViewsWithIds));
    }

    private DialogParentDetailsBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (TextView) bindings[7], (TextView) bindings[1], (TextView) bindings[2], (TextView) bindings[3], (TextView) bindings[4], (TextView) bindings[5], (TextView) bindings[6]);
        this.mDirtyFlags = -1L;
        ScrollView scrollView = (ScrollView) bindings[0];
        this.mboundView0 = scrollView;
        scrollView.setTag(null);
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
        if (156 != variableId) {
            return false;
        }
        setParentDetailsViewModel((ParentDetailsViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.DialogParentDetailsBinding
    public void setParentDetailsViewModel(ParentDetailsViewModel ParentDetailsViewModel) {
        this.mParentDetailsViewModel = ParentDetailsViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}