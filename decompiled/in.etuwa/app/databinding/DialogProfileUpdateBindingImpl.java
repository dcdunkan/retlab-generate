package in.etuwa.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
import in.etuwa.app.ui.hostel.gcekhostel.registration.editregistration.EditRegistrationViewModel;

/* loaded from: classes3.dex */
public class DialogProfileUpdateBindingImpl extends DialogProfileUpdateBinding {
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
        sparseIntArray.put(R.id._title, 3);
        sparseIntArray.put(R.id.personal_details, 4);
        sparseIntArray.put(R.id.general_details_arrowBtn, 5);
        sparseIntArray.put(R.id.profile_personal_expandableView, 6);
        sparseIntArray.put(R.id.et_first_name, 7);
        sparseIntArray.put(R.id.et_middle_name, 8);
        sparseIntArray.put(R.id.et_last_name, 9);
        sparseIntArray.put(R.id.spinner_gender, 10);
        sparseIntArray.put(R.id.et__date_of_birth, 11);
        sparseIntArray.put(R.id.spinner_religion, 12);
        sparseIntArray.put(R.id.et_place_birth, 13);
        sparseIntArray.put(R.id.et_aadhar_no, 14);
        sparseIntArray.put(R.id.progress_view, 15);
        sparseIntArray.put(R.id.upload_progressbar, 16);
        sparseIntArray.put(R.id.progress_text, 17);
    }

    public DialogProfileUpdateBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 18, sIncludes, sViewsWithIds));
    }

    private DialogProfileUpdateBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (TextView) bindings[3], (TextInputEditText) bindings[14], (EditText) bindings[11], (TextInputEditText) bindings[7], (TextInputEditText) bindings[9], (TextInputEditText) bindings[8], (TextInputEditText) bindings[13], (Button) bindings[5], (TextView) bindings[4], (LinearLayout) bindings[6], (TextView) bindings[17], (CardView) bindings[15], (Spinner) bindings[10], (Spinner) bindings[12], (ProgressBar) bindings[16]);
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
        if (76 != variableId) {
            return false;
        }
        setEditRegistrationViewModel((EditRegistrationViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.DialogProfileUpdateBinding
    public void setEditRegistrationViewModel(EditRegistrationViewModel EditRegistrationViewModel) {
        this.mEditRegistrationViewModel = EditRegistrationViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}