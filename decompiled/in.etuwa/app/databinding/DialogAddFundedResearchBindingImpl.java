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
import in.etuwa.app.ui.profile.fundedresearch.add.AddFundedResearchViewModel;

/* loaded from: classes3.dex */
public class DialogAddFundedResearchBindingImpl extends DialogAddFundedResearchBinding {
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
        sparseIntArray.put(R.id.et_title, 4);
        sparseIntArray.put(R.id.et_agency, 5);
        sparseIntArray.put(R.id.et_amount, 6);
        sparseIntArray.put(R.id.spinner_year, 7);
        sparseIntArray.put(R.id.et_duration, 8);
        sparseIntArray.put(R.id.completion_card, 9);
        sparseIntArray.put(R.id.completion_file_name, 10);
        sparseIntArray.put(R.id.completion_select, 11);
        sparseIntArray.put(R.id.add_btn, 12);
        sparseIntArray.put(R.id.update_btn, 13);
        sparseIntArray.put(R.id.progress_view, 14);
        sparseIntArray.put(R.id.upload_progressbar, 15);
        sparseIntArray.put(R.id.progress_text, 16);
    }

    public DialogAddFundedResearchBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 17, sIncludes, sViewsWithIds));
    }

    private DialogAddFundedResearchBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (TextView) bindings[12], (LinearLayout) bindings[9], (TextView) bindings[10], (TextView) bindings[11], (TextInputEditText) bindings[5], (TextInputEditText) bindings[6], (TextInputEditText) bindings[8], (TextInputEditText) bindings[4], (TextView) bindings[16], (CardView) bindings[14], (TextView) bindings[3], (Spinner) bindings[7], (TextView) bindings[13], (ProgressBar) bindings[15]);
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
        setAddFundedResearchViewModel((AddFundedResearchViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.DialogAddFundedResearchBinding
    public void setAddFundedResearchViewModel(AddFundedResearchViewModel AddFundedResearchViewModel) {
        this.mAddFundedResearchViewModel = AddFundedResearchViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}