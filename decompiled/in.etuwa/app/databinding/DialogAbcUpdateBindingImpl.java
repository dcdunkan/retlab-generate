package in.etuwa.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.textfield.TextInputEditText;
import in.etuwa.app.R;
import in.etuwa.app.ui.profile.updateabc.UpdateAbcViewModel;

/* loaded from: classes3.dex */
public class DialogAbcUpdateBindingImpl extends DialogAbcUpdateBinding {
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
        sparseIntArray.put(R.id.et_abc_id, 1);
        sparseIntArray.put(R.id.view_instruction_btn, 2);
        sparseIntArray.put(R.id.help_btn, 3);
        sparseIntArray.put(R.id.update_btn, 4);
    }

    public DialogAbcUpdateBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds));
    }

    private DialogAbcUpdateBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (TextInputEditText) bindings[1], (TextView) bindings[3], (TextView) bindings[4], (TextView) bindings[2]);
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
        if (235 != variableId) {
            return false;
        }
        setUpdateAbcViewModel((UpdateAbcViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.DialogAbcUpdateBinding
    public void setUpdateAbcViewModel(UpdateAbcViewModel UpdateAbcViewModel) {
        this.mUpdateAbcViewModel = UpdateAbcViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}