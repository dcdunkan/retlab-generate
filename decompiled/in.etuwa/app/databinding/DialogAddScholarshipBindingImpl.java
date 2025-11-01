package in.etuwa.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.textfield.TextInputEditText;
import in.etuwa.app.R;
import in.etuwa.app.ui.profile.scholarships.add.AddScholarshipViewModel;

/* loaded from: classes3.dex */
public class DialogAddScholarshipBindingImpl extends DialogAddScholarshipBinding {
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
        sparseIntArray.put(R.id.reg_title, 3);
        sparseIntArray.put(R.id.spinner_type, 4);
        sparseIntArray.put(R.id.et_name, 5);
        sparseIntArray.put(R.id.spinner_since, 6);
        sparseIntArray.put(R.id.completion_card, 7);
        sparseIntArray.put(R.id.completion_file_name, 8);
        sparseIntArray.put(R.id.completion_select, 9);
        sparseIntArray.put(R.id.add_btn, 10);
        sparseIntArray.put(R.id.update_btn, 11);
        sparseIntArray.put(R.id.progress_view, 12);
        sparseIntArray.put(R.id.upload_progressbar, 13);
        sparseIntArray.put(R.id.progress_text, 14);
    }

    public DialogAddScholarshipBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 15, sIncludes, sViewsWithIds));
    }

    private DialogAddScholarshipBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (TextView) bindings[10], (LinearLayout) bindings[7], (TextView) bindings[8], (TextView) bindings[9], (TextInputEditText) bindings[5], (TextView) bindings[14], (CardView) bindings[12], (TextView) bindings[3], (Spinner) bindings[6], (Spinner) bindings[4], (TextView) bindings[11], (ProgressBar) bindings[13]);
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
        if (21 != variableId) {
            return false;
        }
        setAddScholarshipViewModel((AddScholarshipViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.DialogAddScholarshipBinding
    public void setAddScholarshipViewModel(AddScholarshipViewModel AddScholarshipViewModel) {
        this.mAddScholarshipViewModel = AddScholarshipViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}