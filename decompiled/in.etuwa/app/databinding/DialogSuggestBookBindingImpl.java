package in.etuwa.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import in.etuwa.app.R;
import in.etuwa.app.ui.library.suggest.SuggestBookViewModel;

/* loaded from: classes3.dex */
public class DialogSuggestBookBindingImpl extends DialogSuggestBookBinding {
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
        sparseIntArray.put(R.id.et_title, 1);
        sparseIntArray.put(R.id.et_author, 2);
        sparseIntArray.put(R.id.re_enter_acc_et, 3);
        sparseIntArray.put(R.id.et_publication, 4);
        sparseIntArray.put(R.id.et_edition, 5);
        sparseIntArray.put(R.id.et_isbn, 6);
        sparseIntArray.put(R.id.et_other_details, 7);
        sparseIntArray.put(R.id.suggest_btn, 8);
    }

    public DialogSuggestBookBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 9, sIncludes, sViewsWithIds));
    }

    private DialogSuggestBookBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (TextInputEditText) bindings[2], (TextInputEditText) bindings[5], (TextInputEditText) bindings[6], (TextInputEditText) bindings[7], (TextInputEditText) bindings[4], (TextInputEditText) bindings[1], (TextInputLayout) bindings[3], (TextView) bindings[8]);
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
        if (217 != variableId) {
            return false;
        }
        setSuggestBookViewModel((SuggestBookViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.DialogSuggestBookBinding
    public void setSuggestBookViewModel(SuggestBookViewModel SuggestBookViewModel) {
        this.mSuggestBookViewModel = SuggestBookViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}