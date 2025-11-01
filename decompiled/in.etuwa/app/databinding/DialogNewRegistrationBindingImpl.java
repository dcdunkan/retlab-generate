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
import in.etuwa.app.ui.hostel.gcekhostel.registration.newregistration.NewRegistrationViewModel;

/* loaded from: classes3.dex */
public class DialogNewRegistrationBindingImpl extends DialogNewRegistrationBinding {
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
        sparseIntArray.put(R.id.spinner_readmission, 6);
        sparseIntArray.put(R.id.et_name_address, 7);
        sparseIntArray.put(R.id.et_phone, 8);
        sparseIntArray.put(R.id.et_annual_income, 9);
        sparseIntArray.put(R.id.et_distance, 10);
        sparseIntArray.put(R.id.completion_card, 11);
        sparseIntArray.put(R.id.completion_file_name, 12);
        sparseIntArray.put(R.id.completion_select, 13);
        sparseIntArray.put(R.id.register_btn, 14);
        sparseIntArray.put(R.id.progress_view, 15);
        sparseIntArray.put(R.id.upload_progressbar, 16);
        sparseIntArray.put(R.id.progress_text, 17);
    }

    public DialogNewRegistrationBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 18, sIncludes, sViewsWithIds));
    }

    private DialogNewRegistrationBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (LinearLayout) bindings[11], (TextView) bindings[12], (TextView) bindings[13], (TextInputEditText) bindings[9], (TextInputEditText) bindings[10], (TextInputEditText) bindings[7], (TextInputEditText) bindings[8], (TextView) bindings[17], (CardView) bindings[15], (TextView) bindings[3], (TextView) bindings[14], (Spinner) bindings[5], (Spinner) bindings[6], (Spinner) bindings[4], (ProgressBar) bindings[16]);
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
        if (147 != variableId) {
            return false;
        }
        setNewRegistrationViewModel((NewRegistrationViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.DialogNewRegistrationBinding
    public void setNewRegistrationViewModel(NewRegistrationViewModel NewRegistrationViewModel) {
        this.mNewRegistrationViewModel = NewRegistrationViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}