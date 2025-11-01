package in.etuwa.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import in.etuwa.app.R;
import in.etuwa.app.ui.grievance.add.AddGrievanceDialogViewModel;

/* loaded from: classes3.dex */
public class AddGrievanceDialogBindingImpl extends AddGrievanceDialogBinding {
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
        sparseIntArray.put(R.id.griv_title, 3);
        sparseIntArray.put(R.id.spinner_grievance, 4);
        sparseIntArray.put(R.id.et_gr_subject, 5);
        sparseIntArray.put(R.id.gr_complaint, 6);
        sparseIntArray.put(R.id.comnt_layout, 7);
        sparseIntArray.put(R.id.gr_comment, 8);
        sparseIntArray.put(R.id.gr_upload_path, 9);
        sparseIntArray.put(R.id.upload_gr_btn, 10);
        sparseIntArray.put(R.id.add_grievance_btn, 11);
        sparseIntArray.put(R.id.progress_view, 12);
        sparseIntArray.put(R.id.upload_progressbar, 13);
        sparseIntArray.put(R.id.progress_text, 14);
    }

    public AddGrievanceDialogBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 15, sIncludes, sViewsWithIds));
    }

    private AddGrievanceDialogBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (TextView) bindings[11], (TextInputLayout) bindings[7], (TextInputEditText) bindings[5], (TextInputEditText) bindings[8], (TextInputEditText) bindings[6], (TextView) bindings[9], (TextView) bindings[3], (TextView) bindings[14], (CardView) bindings[12], (Spinner) bindings[4], (TextView) bindings[10], (ProgressBar) bindings[13]);
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
        if (12 != variableId) {
            return false;
        }
        setAddGrievanceDialogViewModel((AddGrievanceDialogViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.AddGrievanceDialogBinding
    public void setAddGrievanceDialogViewModel(AddGrievanceDialogViewModel AddGrievanceDialogViewModel) {
        this.mAddGrievanceDialogViewModel = AddGrievanceDialogViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}