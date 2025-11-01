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
import in.etuwa.app.ui.counselling.add.AddCounsellingViewModel;

/* loaded from: classes3.dex */
public class AddCounsellingDialogBindingImpl extends AddCounsellingDialogBinding {
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
        sparseIntArray.put(R.id.counc_title, 3);
        sparseIntArray.put(R.id.spinner_councelling_type, 4);
        sparseIntArray.put(R.id.et_cs_concern, 5);
        sparseIntArray.put(R.id.et_cs_concern_home, 6);
        sparseIntArray.put(R.id.cs_concern_studies, 7);
        sparseIntArray.put(R.id.cs_relationship, 8);
        sparseIntArray.put(R.id.cs_phisical, 9);
        sparseIntArray.put(R.id.spinner_councelling_before, 10);
        sparseIntArray.put(R.id.spinner_councelling_meet, 11);
        sparseIntArray.put(R.id.comnt_layout, 12);
        sparseIntArray.put(R.id.cs_comment, 13);
        sparseIntArray.put(R.id.add_counselling_btn, 14);
        sparseIntArray.put(R.id.progress_view, 15);
        sparseIntArray.put(R.id.upload_progressbar, 16);
        sparseIntArray.put(R.id.progress_text, 17);
    }

    public AddCounsellingDialogBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 18, sIncludes, sViewsWithIds));
    }

    private AddCounsellingDialogBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (TextView) bindings[14], (TextInputLayout) bindings[12], (TextView) bindings[3], (TextInputEditText) bindings[13], (TextInputEditText) bindings[7], (TextInputEditText) bindings[9], (TextInputEditText) bindings[8], (TextInputEditText) bindings[5], (TextInputEditText) bindings[6], (TextView) bindings[17], (CardView) bindings[15], (Spinner) bindings[10], (Spinner) bindings[11], (Spinner) bindings[4], (ProgressBar) bindings[16]);
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
        if (9 != variableId) {
            return false;
        }
        setAddCounsellingDialogViewModel((AddCounsellingViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.AddCounsellingDialogBinding
    public void setAddCounsellingDialogViewModel(AddCounsellingViewModel AddCounsellingDialogViewModel) {
        this.mAddCounsellingDialogViewModel = AddCounsellingDialogViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}