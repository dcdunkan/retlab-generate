package in.etuwa.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import in.etuwa.app.R;
import in.etuwa.app.ui.subjectregistration.view.ViewSubjectRegistrationViewModel;

/* loaded from: classes3.dex */
public class DialogViewSubjectRegistrationBindingImpl extends DialogViewSubjectRegistrationBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;
    private final FrameLayout mboundView1;
    private final ViewProgressBarBinding mboundView11;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.sem_tv, 3);
        sparseIntArray.put(R.id.category_tv, 4);
        sparseIntArray.put(R.id.pathway_tv, 5);
        sparseIntArray.put(R.id.subjects_btn, 6);
        sparseIntArray.put(R.id.sem_history_btn, 7);
        sparseIntArray.put(R.id.rv_sub_status, 8);
        sparseIntArray.put(R.id.rv_sem_history, 9);
        sparseIntArray.put(R.id.update_btn, 10);
        sparseIntArray.put(R.id.progress_view, 11);
        sparseIntArray.put(R.id.upload_progressbar, 12);
        sparseIntArray.put(R.id.progress_text, 13);
    }

    public DialogViewSubjectRegistrationBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 14, sIncludes, sViewsWithIds));
    }

    private DialogViewSubjectRegistrationBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (TextView) bindings[4], (TextView) bindings[5], (TextView) bindings[13], (CardView) bindings[11], (RecyclerView) bindings[9], (RecyclerView) bindings[8], (TextView) bindings[7], (TextView) bindings[3], (TextView) bindings[6], (TextView) bindings[10], (ProgressBar) bindings[12]);
        this.mDirtyFlags = -1L;
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
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
        if (248 != variableId) {
            return false;
        }
        setViewSubjectRegistrationViewModel((ViewSubjectRegistrationViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.DialogViewSubjectRegistrationBinding
    public void setViewSubjectRegistrationViewModel(ViewSubjectRegistrationViewModel ViewSubjectRegistrationViewModel) {
        this.mViewSubjectRegistrationViewModel = ViewSubjectRegistrationViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}