package in.etuwa.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.textfield.TextInputEditText;
import in.etuwa.app.R;
import in.etuwa.app.ui.certificate_request.add_request_dialog.AddRequestDialogViewModel;

/* loaded from: classes3.dex */
public class AddRequestDialogBindingImpl extends AddRequestDialogBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ViewProgressBarBinding mboundView0;
    private final FrameLayout mboundView01;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.loader, 2);
        sparseIntArray.put(R.id.progress_view, 3);
        sparseIntArray.put(R.id.upload_progressbar, 4);
        sparseIntArray.put(R.id.progress_text, 5);
        sparseIntArray.put(R.id.assi_card, 6);
        sparseIntArray.put(R.id.text_view_id, 7);
        sparseIntArray.put(R.id.spinner_certificate_list, 8);
        sparseIntArray.put(R.id.itr_lyt, 9);
        sparseIntArray.put(R.id.spinner_request_opted, 10);
        sparseIntArray.put(R.id.common_layout, 11);
        sparseIntArray.put(R.id.name_of_parent_itr, 12);
        sparseIntArray.put(R.id.house_name_itr, 13);
        sparseIntArray.put(R.id.street_itr, 14);
        sparseIntArray.put(R.id.post_office_itr, 15);
        sparseIntArray.put(R.id.district_itr, 16);
        sparseIntArray.put(R.id.state_itr, 17);
        sparseIntArray.put(R.id.pin_code_itr, 18);
        sparseIntArray.put(R.id.bank_name_text, 19);
        sparseIntArray.put(R.id.bank_adress_text, 20);
        sparseIntArray.put(R.id.original_cert_lyt, 21);
        sparseIntArray.put(R.id.spinner_original_cert, 22);
        sparseIntArray.put(R.id.fee_lyt, 23);
        sparseIntArray.put(R.id.cgpa_lyt, 24);
        sparseIntArray.put(R.id.cgpa_exam_et, 25);
        sparseIntArray.put(R.id.spinner_semester2, 26);
        sparseIntArray.put(R.id.month_year_cgpa_et, 27);
        sparseIntArray.put(R.id.sgpa_et, 28);
        sparseIntArray.put(R.id.reason_cgpa_et, 29);
        sparseIntArray.put(R.id.is_hostler_tv, 30);
        sparseIntArray.put(R.id.spinner_hostler, 31);
        sparseIntArray.put(R.id.reason_text, 32);
        sparseIntArray.put(R.id.completion_card, 33);
        sparseIntArray.put(R.id.completion_file_name, 34);
        sparseIntArray.put(R.id.completion_select, 35);
        sparseIntArray.put(R.id.submit_btn, 36);
    }

    public AddRequestDialogBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 37, sIncludes, sViewsWithIds));
    }

    private AddRequestDialogBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (LinearLayout) bindings[6], (TextInputEditText) bindings[20], (TextInputEditText) bindings[19], (TextInputEditText) bindings[25], (LinearLayout) bindings[24], (LinearLayout) bindings[11], (LinearLayout) bindings[33], (TextView) bindings[34], (TextView) bindings[35], (TextInputEditText) bindings[16], (LinearLayout) bindings[23], (TextInputEditText) bindings[13], (TextView) bindings[30], (LinearLayout) bindings[9], (ProgressBar) bindings[2], (TextInputEditText) bindings[27], (TextInputEditText) bindings[12], (LinearLayout) bindings[21], (TextInputEditText) bindings[18], (TextInputEditText) bindings[15], (TextView) bindings[5], (LinearLayout) bindings[3], (TextInputEditText) bindings[29], (TextInputEditText) bindings[32], (TextInputEditText) bindings[28], (Spinner) bindings[8], (Spinner) bindings[31], (Spinner) bindings[22], (Spinner) bindings[10], (Spinner) bindings[26], (TextInputEditText) bindings[17], (TextInputEditText) bindings[14], (TextView) bindings[36], (TextView) bindings[7], (ProgressBar) bindings[4]);
        this.mDirtyFlags = -1L;
        Object obj = bindings[1];
        this.mboundView0 = obj != null ? ViewProgressBarBinding.bind((View) obj) : null;
        FrameLayout frameLayout = (FrameLayout) bindings[0];
        this.mboundView01 = frameLayout;
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
        if (21 != variableId) {
            return false;
        }
        setAddRequestDialogViewModel((AddRequestDialogViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.AddRequestDialogBinding
    public void setAddRequestDialogViewModel(AddRequestDialogViewModel AddRequestDialogViewModel) {
        this.mAddRequestDialogViewModel = AddRequestDialogViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}