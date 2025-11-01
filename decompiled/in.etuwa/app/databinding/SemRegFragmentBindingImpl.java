package in.etuwa.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.textfield.TextInputEditText;
import in.etuwa.app.R;
import in.etuwa.app.ui.semregistration.edit.SemRegViewModel;

/* loaded from: classes3.dex */
public class SemRegFragmentBindingImpl extends SemRegFragmentBinding {
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
        sparseIntArray.put(R.id.spinner_layout, 2);
        sparseIntArray.put(R.id.spinner_sem_reg, 3);
        sparseIntArray.put(R.id.spinner_layout2, 4);
        sparseIntArray.put(R.id.sem_last_attended, 5);
        sparseIntArray.put(R.id.exam_group, 6);
        sparseIntArray.put(R.id.exam_yes, 7);
        sparseIntArray.put(R.id.exam_no, 8);
        sparseIntArray.put(R.id.et_sem_month_year, 9);
        sparseIntArray.put(R.id.back_paper_group, 10);
        sparseIntArray.put(R.id.back_yes, 11);
        sparseIntArray.put(R.id.back_no, 12);
        sparseIntArray.put(R.id.et_sem_count_back_paper, 13);
        sparseIntArray.put(R.id.et_sem_earned_credit, 14);
        sparseIntArray.put(R.id.card_fee_details, 15);
        sparseIntArray.put(R.id.fee_paid_group, 16);
        sparseIntArray.put(R.id.fee_yes, 17);
        sparseIntArray.put(R.id.fee_no, 18);
        sparseIntArray.put(R.id.pay_fee_btn, 19);
        sparseIntArray.put(R.id.fee_layout, 20);
        sparseIntArray.put(R.id.et_sem_bank_name, 21);
        sparseIntArray.put(R.id.et_sem_amount, 22);
        sparseIntArray.put(R.id.et_sem_paid_date, 23);
        sparseIntArray.put(R.id.et_sem_mode_of_payment, 24);
        sparseIntArray.put(R.id.et_sem_ref_no, 25);
        sparseIntArray.put(R.id.choose_file_btn, 26);
        sparseIntArray.put(R.id.tv_sem_reg_file_path, 27);
        sparseIntArray.put(R.id.e_grand_group, 28);
        sparseIntArray.put(R.id.e_grand_yes, 29);
        sparseIntArray.put(R.id.e_grand_no, 30);
        sparseIntArray.put(R.id.et_sem_fee_concession_category, 31);
        sparseIntArray.put(R.id.card_due, 32);
        sparseIntArray.put(R.id.department_group, 33);
        sparseIntArray.put(R.id.department_yes, 34);
        sparseIntArray.put(R.id.department_no, 35);
        sparseIntArray.put(R.id.et_sem_department_due, 36);
        sparseIntArray.put(R.id.library_group, 37);
        sparseIntArray.put(R.id.library_yes, 38);
        sparseIntArray.put(R.id.library_no, 39);
        sparseIntArray.put(R.id.et_sem_library_due, 40);
        sparseIntArray.put(R.id.accounts_group, 41);
        sparseIntArray.put(R.id.accounts_yes, 42);
        sparseIntArray.put(R.id.accounts_no, 43);
        sparseIntArray.put(R.id.et_sem_account_due, 44);
        sparseIntArray.put(R.id.academic_group, 45);
        sparseIntArray.put(R.id.academic_yes, 46);
        sparseIntArray.put(R.id.academic_no, 47);
        sparseIntArray.put(R.id.et_sem_academic_due, 48);
        sparseIntArray.put(R.id.hostel_group, 49);
        sparseIntArray.put(R.id.hostel_yes, 50);
        sparseIntArray.put(R.id.hostel_no, 51);
        sparseIntArray.put(R.id.et_sem_hostel_due, 52);
        sparseIntArray.put(R.id.bus_group, 53);
        sparseIntArray.put(R.id.bus_yes, 54);
        sparseIntArray.put(R.id.bus_no, 55);
        sparseIntArray.put(R.id.et_sem_bus_due, 56);
        sparseIntArray.put(R.id.et_sem_submit_btn, 57);
        sparseIntArray.put(R.id.progress_view, 58);
        sparseIntArray.put(R.id.upload_progressbar, 59);
        sparseIntArray.put(R.id.progress_text, 60);
    }

    public SemRegFragmentBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 61, sIncludes, sViewsWithIds));
    }

    private SemRegFragmentBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (RadioGroup) bindings[45], (RadioButton) bindings[47], (RadioButton) bindings[46], (RadioGroup) bindings[41], (RadioButton) bindings[43], (RadioButton) bindings[42], (RadioButton) bindings[12], (RadioGroup) bindings[10], (RadioButton) bindings[11], (RadioGroup) bindings[53], (RadioButton) bindings[55], (RadioButton) bindings[54], (CardView) bindings[32], (CardView) bindings[15], (TextView) bindings[26], (RadioGroup) bindings[33], (RadioButton) bindings[35], (RadioButton) bindings[34], (RadioGroup) bindings[28], (RadioButton) bindings[30], (RadioButton) bindings[29], (TextInputEditText) bindings[48], (TextInputEditText) bindings[44], (TextInputEditText) bindings[22], (TextInputEditText) bindings[21], (TextInputEditText) bindings[56], (TextInputEditText) bindings[13], (TextInputEditText) bindings[36], (TextInputEditText) bindings[14], (TextInputEditText) bindings[31], (TextInputEditText) bindings[52], (TextInputEditText) bindings[40], (TextInputEditText) bindings[24], (TextInputEditText) bindings[9], (TextInputEditText) bindings[23], (TextInputEditText) bindings[25], (TextView) bindings[57], (RadioGroup) bindings[6], (RadioButton) bindings[8], (RadioButton) bindings[7], (LinearLayout) bindings[20], (RadioButton) bindings[18], (RadioGroup) bindings[16], (RadioButton) bindings[17], (RadioGroup) bindings[49], (RadioButton) bindings[51], (RadioButton) bindings[50], (RadioGroup) bindings[37], (RadioButton) bindings[39], (RadioButton) bindings[38], (TextView) bindings[19], (TextView) bindings[60], (LinearLayout) bindings[58], (TextView) bindings[5], (LinearLayout) bindings[2], (LinearLayout) bindings[4], (Spinner) bindings[3], (TextView) bindings[27], (ProgressBar) bindings[59]);
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
        if (198 != variableId) {
            return false;
        }
        setSemRegViewModel((SemRegViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.SemRegFragmentBinding
    public void setSemRegViewModel(SemRegViewModel SemRegViewModel) {
        this.mSemRegViewModel = SemRegViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}