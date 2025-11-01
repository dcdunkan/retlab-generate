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
import in.etuwa.app.R;
import in.etuwa.app.ui.hostel.gcekhostel.registration.reregistration.ReRegistrationViewModel;

/* loaded from: classes3.dex */
public class DialogNewRegistrationAisatBindingImpl extends DialogNewRegistrationAisatBinding {
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
        sparseIntArray.put(R.id.spinner_semester_applied, 4);
        sparseIntArray.put(R.id.spinner_catogory, 5);
        sparseIntArray.put(R.id.spinner_present_hostel, 6);
        sparseIntArray.put(R.id.spinner_pre, 7);
        sparseIntArray.put(R.id.receipt_card, 8);
        sparseIntArray.put(R.id.completion_file_name, 9);
        sparseIntArray.put(R.id.completion_select, 10);
        sparseIntArray.put(R.id.spinner_pr, 11);
        sparseIntArray.put(R.id.register_btn, 12);
        sparseIntArray.put(R.id.progress_view, 13);
        sparseIntArray.put(R.id.upload_progressbar, 14);
        sparseIntArray.put(R.id.progress_text, 15);
    }

    public DialogNewRegistrationAisatBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 16, sIncludes, sViewsWithIds));
    }

    private DialogNewRegistrationAisatBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (TextView) bindings[9], (TextView) bindings[10], (TextView) bindings[15], (CardView) bindings[13], (LinearLayout) bindings[8], (TextView) bindings[3], (TextView) bindings[12], (Spinner) bindings[5], (Spinner) bindings[11], (Spinner) bindings[7], (Spinner) bindings[6], (Spinner) bindings[4], (ProgressBar) bindings[14]);
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
        if (178 != variableId) {
            return false;
        }
        setReRegistrationViewModel((ReRegistrationViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.DialogNewRegistrationAisatBinding
    public void setReRegistrationViewModel(ReRegistrationViewModel ReRegistrationViewModel) {
        this.mReRegistrationViewModel = ReRegistrationViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}