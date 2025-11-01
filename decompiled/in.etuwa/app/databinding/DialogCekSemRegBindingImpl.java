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
import com.google.android.material.textfield.TextInputLayout;
import in.etuwa.app.R;
import in.etuwa.app.ui.semregistration.mea.MeaSemRegViewModel;

/* loaded from: classes3.dex */
public class DialogCekSemRegBindingImpl extends DialogCekSemRegBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final CardView mboundView0;
    private final FrameLayout mboundView1;
    private final ViewProgressBarBinding mboundView11;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.page_one, 3);
        sparseIntArray.put(R.id.back_one, 4);
        sparseIntArray.put(R.id.next_one, 5);
        sparseIntArray.put(R.id.page_two, 6);
        sparseIntArray.put(R.id.back_two, 7);
        sparseIntArray.put(R.id.next_two, 8);
        sparseIntArray.put(R.id.page_three, 9);
        sparseIntArray.put(R.id.back_three, 10);
        sparseIntArray.put(R.id.next_three, 11);
        sparseIntArray.put(R.id.exam_att_tv, 12);
        sparseIntArray.put(R.id.university_previous_layout, 13);
        sparseIntArray.put(R.id.spinner_semester_last_attended, 14);
        sparseIntArray.put(R.id.exam_group, 15);
        sparseIntArray.put(R.id.exam_yes, 16);
        sparseIntArray.put(R.id.exam_no, 17);
        sparseIntArray.put(R.id.back_group, 18);
        sparseIntArray.put(R.id.back_yes, 19);
        sparseIntArray.put(R.id.back_no, 20);
        sparseIntArray.put(R.id.mt_month_year, 21);
        sparseIntArray.put(R.id.et_month_year, 22);
        sparseIntArray.put(R.id.mt_back_papers, 23);
        sparseIntArray.put(R.id.et_back_paper_count, 24);
        sparseIntArray.put(R.id.et_earned_credits, 25);
        sparseIntArray.put(R.id.fee_details_tv, 26);
        sparseIntArray.put(R.id.fee_details_lt, 27);
        sparseIntArray.put(R.id.fee_due, 28);
        sparseIntArray.put(R.id.fee_yes, 29);
        sparseIntArray.put(R.id.fee_no, 30);
        sparseIntArray.put(R.id.mt_bank_name, 31);
        sparseIntArray.put(R.id.et_bank_name, 32);
        sparseIntArray.put(R.id.mt_amount_paid, 33);
        sparseIntArray.put(R.id.et_amount_paid, 34);
        sparseIntArray.put(R.id.mt_date_payment, 35);
        sparseIntArray.put(R.id.et_date_payment, 36);
        sparseIntArray.put(R.id.mt_mode_payment, 37);
        sparseIntArray.put(R.id.et_mode_payment, 38);
        sparseIntArray.put(R.id.mt_ref_no, 39);
        sparseIntArray.put(R.id.et_ref_no, 40);
        sparseIntArray.put(R.id.upload_lyt, 41);
        sparseIntArray.put(R.id.completion_select, 42);
        sparseIntArray.put(R.id.completion_file_name, 43);
        sparseIntArray.put(R.id.concession_btn, 44);
        sparseIntArray.put(R.id.concession_yes, 45);
        sparseIntArray.put(R.id.concession_no, 46);
        sparseIntArray.put(R.id.mt_concession_detsils, 47);
        sparseIntArray.put(R.id.et_concession_details, 48);
        sparseIntArray.put(R.id.due_tv, 49);
        sparseIntArray.put(R.id.due_lt, 50);
        sparseIntArray.put(R.id.department_due, 51);
        sparseIntArray.put(R.id.dept_yes, 52);
        sparseIntArray.put(R.id.dept_no, 53);
        sparseIntArray.put(R.id.mt_dept_detail, 54);
        sparseIntArray.put(R.id.et_dept_details, 55);
        sparseIntArray.put(R.id.library_due, 56);
        sparseIntArray.put(R.id.library_yes, 57);
        sparseIntArray.put(R.id.library_no, 58);
        sparseIntArray.put(R.id.mt_library_detail, 59);
        sparseIntArray.put(R.id.et_library_details, 60);
        sparseIntArray.put(R.id.accounts_due, 61);
        sparseIntArray.put(R.id.accounts_yes, 62);
        sparseIntArray.put(R.id.accounts_no, 63);
        sparseIntArray.put(R.id.mt_account_detail, 64);
        sparseIntArray.put(R.id.et_accounts_details, 65);
        sparseIntArray.put(R.id.academic_due, 66);
        sparseIntArray.put(R.id.academic_yes, 67);
        sparseIntArray.put(R.id.academic_no, 68);
        sparseIntArray.put(R.id.mt_academic_detail, 69);
        sparseIntArray.put(R.id.et_academic_details, 70);
        sparseIntArray.put(R.id.hostel_due, 71);
        sparseIntArray.put(R.id.hostel_yes, 72);
        sparseIntArray.put(R.id.hostel_no, 73);
        sparseIntArray.put(R.id.mt_hostel_detail, 74);
        sparseIntArray.put(R.id.et_hostel_details, 75);
        sparseIntArray.put(R.id.bus_due, 76);
        sparseIntArray.put(R.id.bus_yes, 77);
        sparseIntArray.put(R.id.bus_no, 78);
        sparseIntArray.put(R.id.mt_bus_detail, 79);
        sparseIntArray.put(R.id.et_bus_details, 80);
        sparseIntArray.put(R.id.register_btn, 81);
        sparseIntArray.put(R.id.progress_view, 82);
        sparseIntArray.put(R.id.upload_progressbar, 83);
        sparseIntArray.put(R.id.progress_text, 84);
    }

    public DialogCekSemRegBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 85, sIncludes, sViewsWithIds));
    }

    private DialogCekSemRegBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (RadioGroup) bindings[66], (RadioButton) bindings[68], (RadioButton) bindings[67], (RadioGroup) bindings[61], (RadioButton) bindings[63], (RadioButton) bindings[62], (RadioGroup) bindings[18], (RadioButton) bindings[20], (TextView) bindings[4], (TextView) bindings[10], (TextView) bindings[7], (RadioButton) bindings[19], (RadioGroup) bindings[76], (RadioButton) bindings[78], (RadioButton) bindings[77], (TextView) bindings[43], (TextView) bindings[42], (RadioGroup) bindings[44], (RadioButton) bindings[46], (RadioButton) bindings[45], (RadioGroup) bindings[51], (RadioButton) bindings[53], (RadioButton) bindings[52], (LinearLayout) bindings[50], (TextView) bindings[49], (TextInputEditText) bindings[70], (TextInputEditText) bindings[65], (TextInputEditText) bindings[34], (TextInputEditText) bindings[24], (TextInputEditText) bindings[32], (TextInputEditText) bindings[80], (TextInputEditText) bindings[48], (TextInputEditText) bindings[36], (TextInputEditText) bindings[55], (TextInputEditText) bindings[25], (TextInputEditText) bindings[75], (TextInputEditText) bindings[60], (TextInputEditText) bindings[38], (TextInputEditText) bindings[22], (TextInputEditText) bindings[40], (TextView) bindings[12], (RadioGroup) bindings[15], (RadioButton) bindings[17], (RadioButton) bindings[16], (LinearLayout) bindings[27], (TextView) bindings[26], (RadioGroup) bindings[28], (RadioButton) bindings[30], (RadioButton) bindings[29], (RadioGroup) bindings[71], (RadioButton) bindings[73], (RadioButton) bindings[72], (RadioGroup) bindings[56], (RadioButton) bindings[58], (RadioButton) bindings[57], (TextInputLayout) bindings[69], (TextInputLayout) bindings[64], (TextInputLayout) bindings[33], (TextInputLayout) bindings[23], (TextInputLayout) bindings[31], (TextInputLayout) bindings[79], (TextInputLayout) bindings[47], (TextInputLayout) bindings[35], (TextInputLayout) bindings[54], (TextInputLayout) bindings[74], (TextInputLayout) bindings[59], (TextInputLayout) bindings[37], (TextInputLayout) bindings[21], (TextInputLayout) bindings[39], (TextView) bindings[5], (TextView) bindings[11], (TextView) bindings[8], (LinearLayout) bindings[3], (LinearLayout) bindings[9], (LinearLayout) bindings[6], (TextView) bindings[84], (CardView) bindings[82], (TextView) bindings[81], (Spinner) bindings[14], (LinearLayout) bindings[13], (LinearLayout) bindings[41], (ProgressBar) bindings[83]);
        this.mDirtyFlags = -1L;
        CardView cardView = (CardView) bindings[0];
        this.mboundView0 = cardView;
        cardView.setTag(null);
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
        if (136 != variableId) {
            return false;
        }
        setMeaSemRegViewModel((MeaSemRegViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.DialogCekSemRegBinding
    public void setMeaSemRegViewModel(MeaSemRegViewModel MeaSemRegViewModel) {
        this.mMeaSemRegViewModel = MeaSemRegViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}