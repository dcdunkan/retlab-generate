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
import in.etuwa.app.ui.hostel.gcekhostel.registration.reregistration.ReRegistrationViewModel;

/* loaded from: classes3.dex */
public class DialogReRegistrationBindingImpl extends DialogReRegistrationBinding {
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
        sparseIntArray.put(R.id.spinner_no_of_year, 7);
        sparseIntArray.put(R.id.spinner_behaviour, 8);
        sparseIntArray.put(R.id.spinner_defaulter, 9);
        sparseIntArray.put(R.id.et_name_address, 10);
        sparseIntArray.put(R.id.et_phone, 11);
        sparseIntArray.put(R.id.et_annual_income, 12);
        sparseIntArray.put(R.id.et_distance, 13);
        sparseIntArray.put(R.id.et_hostel_details, 14);
        sparseIntArray.put(R.id.et_fine_details, 15);
        sparseIntArray.put(R.id.et_due_details, 16);
        sparseIntArray.put(R.id.completion_card, 17);
        sparseIntArray.put(R.id.completion_file_name, 18);
        sparseIntArray.put(R.id.completion_select, 19);
        sparseIntArray.put(R.id.register_btn, 20);
        sparseIntArray.put(R.id.progress_view, 21);
        sparseIntArray.put(R.id.upload_progressbar, 22);
        sparseIntArray.put(R.id.progress_text, 23);
    }

    public DialogReRegistrationBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 24, sIncludes, sViewsWithIds));
    }

    private DialogReRegistrationBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (LinearLayout) bindings[17], (TextView) bindings[18], (TextView) bindings[19], (TextInputEditText) bindings[12], (TextInputEditText) bindings[13], (TextInputEditText) bindings[16], (TextInputEditText) bindings[15], (TextInputEditText) bindings[14], (TextInputEditText) bindings[10], (TextInputEditText) bindings[11], (TextView) bindings[23], (CardView) bindings[21], (TextView) bindings[3], (TextView) bindings[20], (Spinner) bindings[8], (Spinner) bindings[5], (Spinner) bindings[9], (Spinner) bindings[7], (Spinner) bindings[6], (Spinner) bindings[4], (ProgressBar) bindings[22]);
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

    @Override // in.etuwa.app.databinding.DialogReRegistrationBinding
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