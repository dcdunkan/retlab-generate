package in.etuwa.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import in.etuwa.app.R;
import in.etuwa.app.ui.exam.submit.SubmitExamDialogViewModel;

/* loaded from: classes3.dex */
public class SubmitExamDialogBindingImpl extends SubmitExamDialogBinding {
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
        sparseIntArray.put(R.id.loader, 1);
        sparseIntArray.put(R.id.progress_view, 2);
        sparseIntArray.put(R.id.upload_progressbar, 3);
        sparseIntArray.put(R.id.progress_text, 4);
        sparseIntArray.put(R.id.exam_card, 5);
        sparseIntArray.put(R.id.file_name, 6);
        sparseIntArray.put(R.id.exam_select, 7);
        sparseIntArray.put(R.id.exam_upload, 8);
        sparseIntArray.put(R.id.tv_size_limit, 9);
    }

    public SubmitExamDialogBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 10, sIncludes, sViewsWithIds));
    }

    private SubmitExamDialogBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (LinearLayout) bindings[5], (TextView) bindings[7], (TextView) bindings[8], (TextView) bindings[6], (ProgressBar) bindings[1], (TextView) bindings[4], (LinearLayout) bindings[2], (TextView) bindings[9], (ProgressBar) bindings[3]);
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
        if (214 != variableId) {
            return false;
        }
        setSubmitExamDialogViewModel((SubmitExamDialogViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.SubmitExamDialogBinding
    public void setSubmitExamDialogViewModel(SubmitExamDialogViewModel SubmitExamDialogViewModel) {
        this.mSubmitExamDialogViewModel = SubmitExamDialogViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}