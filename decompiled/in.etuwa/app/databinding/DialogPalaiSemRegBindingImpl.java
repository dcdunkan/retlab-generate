package in.etuwa.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
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
import in.etuwa.app.ui.semregistration.sjcetpalai.newregistration.PalaiNewSemRegViewModel;

/* loaded from: classes3.dex */
public class DialogPalaiSemRegBindingImpl extends DialogPalaiSemRegBinding {
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
        sparseIntArray.put(R.id.page_four, 12);
        sparseIntArray.put(R.id.back_four, 13);
        sparseIntArray.put(R.id.next_four, 14);
        sparseIntArray.put(R.id.page_five, 15);
        sparseIntArray.put(R.id.back_five, 16);
        sparseIntArray.put(R.id.next_five, 17);
        sparseIntArray.put(R.id.page_six, 18);
        sparseIntArray.put(R.id.back_six, 19);
        sparseIntArray.put(R.id.next_six, 20);
        sparseIntArray.put(R.id.page_seven, 21);
        sparseIntArray.put(R.id.back_seven, 22);
        sparseIntArray.put(R.id.next_seven, 23);
        sparseIntArray.put(R.id.page_eight, 24);
        sparseIntArray.put(R.id.back_eight, 25);
        sparseIntArray.put(R.id.next_eight, 26);
        sparseIntArray.put(R.id.exam_att_tv, 27);
        sparseIntArray.put(R.id.university_previous_layout, 28);
        sparseIntArray.put(R.id.spinner_semester_last_attended, 29);
        sparseIntArray.put(R.id.exam_group, 30);
        sparseIntArray.put(R.id.exam_yes, 31);
        sparseIntArray.put(R.id.exam_no, 32);
        sparseIntArray.put(R.id.back_group, 33);
        sparseIntArray.put(R.id.back_yes, 34);
        sparseIntArray.put(R.id.back_no, 35);
        sparseIntArray.put(R.id.mt_month_year, 36);
        sparseIntArray.put(R.id.et_month_year, 37);
        sparseIntArray.put(R.id.mt_back_papers, 38);
        sparseIntArray.put(R.id.et_back_paper_count, 39);
        sparseIntArray.put(R.id.et_period_discontinued, 40);
        sparseIntArray.put(R.id.honor_minor_tv, 41);
        sparseIntArray.put(R.id.honor_minor_lt, 42);
        sparseIntArray.put(R.id.global_elec_tv, 43);
        sparseIntArray.put(R.id.global_elec_lt, 44);
        sparseIntArray.put(R.id.spinner_present_hostel, 45);
        sparseIntArray.put(R.id.sgpa_cgpa_tv, 46);
        sparseIntArray.put(R.id.sgpa_cgpa_lt, 47);
        sparseIntArray.put(R.id.supply_tv, 48);
        sparseIntArray.put(R.id.supply_lt, 49);
        sparseIntArray.put(R.id.et_sem_one, 50);
        sparseIntArray.put(R.id.sem_date_one, 51);
        sparseIntArray.put(R.id.sem_date_two, 52);
        sparseIntArray.put(R.id.sem_date_three, 53);
        sparseIntArray.put(R.id.sem_date_four, 54);
        sparseIntArray.put(R.id.sem_date_five, 55);
        sparseIntArray.put(R.id.sem_date_six, 56);
        sparseIntArray.put(R.id.sem_date_seven, 57);
        sparseIntArray.put(R.id.sem_date_eight, 58);
        sparseIntArray.put(R.id.prev_sem_tv, 59);
        sparseIntArray.put(R.id.prev_sem_lt, 60);
        sparseIntArray.put(R.id.fee_details_tv, 61);
        sparseIntArray.put(R.id.fee_details_lt, 62);
        sparseIntArray.put(R.id.fee_due, 63);
        sparseIntArray.put(R.id.fee_yes, 64);
        sparseIntArray.put(R.id.fee_no, 65);
        sparseIntArray.put(R.id.mt_bank_name, 66);
        sparseIntArray.put(R.id.et_bank_name, 67);
        sparseIntArray.put(R.id.mt_amount_paid, 68);
        sparseIntArray.put(R.id.et_amount_paid, 69);
        sparseIntArray.put(R.id.mt_date_payment, 70);
        sparseIntArray.put(R.id.et_date_payment, 71);
        sparseIntArray.put(R.id.mt_mode_payment, 72);
        sparseIntArray.put(R.id.et_mode_payment, 73);
        sparseIntArray.put(R.id.mt_ref_no, 74);
        sparseIntArray.put(R.id.et_ref_no, 75);
        sparseIntArray.put(R.id.concession_btn, 76);
        sparseIntArray.put(R.id.concession_yes, 77);
        sparseIntArray.put(R.id.concession_no, 78);
        sparseIntArray.put(R.id.mt_concession_detsils, 79);
        sparseIntArray.put(R.id.et_concession_details, 80);
        sparseIntArray.put(R.id.due_tv, 81);
        sparseIntArray.put(R.id.due_lt, 82);
        sparseIntArray.put(R.id.department_due, 83);
        sparseIntArray.put(R.id.dept_yes, 84);
        sparseIntArray.put(R.id.dept_no, 85);
        sparseIntArray.put(R.id.mt_dept_detail, 86);
        sparseIntArray.put(R.id.et_dept_details, 87);
        sparseIntArray.put(R.id.library_due, 88);
        sparseIntArray.put(R.id.library_yes, 89);
        sparseIntArray.put(R.id.library_no, 90);
        sparseIntArray.put(R.id.mt_library_detail, 91);
        sparseIntArray.put(R.id.et_library_details, 92);
        sparseIntArray.put(R.id.accounts_due, 93);
        sparseIntArray.put(R.id.accounts_yes, 94);
        sparseIntArray.put(R.id.accounts_no, 95);
        sparseIntArray.put(R.id.mt_account_detail, 96);
        sparseIntArray.put(R.id.et_accounts_details, 97);
        sparseIntArray.put(R.id.academic_due, 98);
        sparseIntArray.put(R.id.academic_yes, 99);
        sparseIntArray.put(R.id.academic_no, 100);
        sparseIntArray.put(R.id.mt_academic_detail, 101);
        sparseIntArray.put(R.id.et_academic_details, 102);
        sparseIntArray.put(R.id.hostel_due, 103);
        sparseIntArray.put(R.id.hostel_yes, 104);
        sparseIntArray.put(R.id.hostel_no, 105);
        sparseIntArray.put(R.id.mt_hostel_detail, 106);
        sparseIntArray.put(R.id.et_hostel_details, 107);
        sparseIntArray.put(R.id.bus_due, 108);
        sparseIntArray.put(R.id.bus_yes, 109);
        sparseIntArray.put(R.id.bus_no, 110);
        sparseIntArray.put(R.id.mt_bus_detail, 111);
        sparseIntArray.put(R.id.et_bus_details, 112);
        sparseIntArray.put(R.id.register_btn, 113);
        sparseIntArray.put(R.id.progress_view, 114);
        sparseIntArray.put(R.id.upload_progressbar, 115);
        sparseIntArray.put(R.id.progress_text, 116);
    }

    public DialogPalaiSemRegBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 117, sIncludes, sViewsWithIds));
    }

    private DialogPalaiSemRegBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (RadioGroup) bindings[98], (RadioButton) bindings[100], (RadioButton) bindings[99], (RadioGroup) bindings[93], (RadioButton) bindings[95], (RadioButton) bindings[94], (TextView) bindings[25], (TextView) bindings[16], (TextView) bindings[13], (RadioGroup) bindings[33], (RadioButton) bindings[35], (TextView) bindings[4], (TextView) bindings[22], (TextView) bindings[19], (TextView) bindings[10], (TextView) bindings[7], (RadioButton) bindings[34], (RadioGroup) bindings[108], (RadioButton) bindings[110], (RadioButton) bindings[109], (RadioGroup) bindings[76], (RadioButton) bindings[78], (RadioButton) bindings[77], (RadioGroup) bindings[83], (RadioButton) bindings[85], (RadioButton) bindings[84], (LinearLayout) bindings[82], (TextView) bindings[81], (TextInputEditText) bindings[102], (TextInputEditText) bindings[97], (TextInputEditText) bindings[69], (TextInputEditText) bindings[39], (TextInputEditText) bindings[67], (TextInputEditText) bindings[112], (TextInputEditText) bindings[80], (TextInputEditText) bindings[71], (TextInputEditText) bindings[87], (TextInputEditText) bindings[107], (TextInputEditText) bindings[92], (TextInputEditText) bindings[73], (TextInputEditText) bindings[37], (TextInputEditText) bindings[40], (TextInputEditText) bindings[75], (TextInputEditText) bindings[50], (TextView) bindings[27], (RadioGroup) bindings[30], (RadioButton) bindings[32], (RadioButton) bindings[31], (LinearLayout) bindings[62], (TextView) bindings[61], (RadioGroup) bindings[63], (RadioButton) bindings[65], (RadioButton) bindings[64], (LinearLayout) bindings[44], (TextView) bindings[43], (LinearLayout) bindings[42], (TextView) bindings[41], (RadioGroup) bindings[103], (RadioButton) bindings[105], (RadioButton) bindings[104], (RadioGroup) bindings[88], (RadioButton) bindings[90], (RadioButton) bindings[89], (TextInputLayout) bindings[101], (TextInputLayout) bindings[96], (TextInputLayout) bindings[68], (TextInputLayout) bindings[38], (TextInputLayout) bindings[66], (TextInputLayout) bindings[111], (TextInputLayout) bindings[79], (TextInputLayout) bindings[70], (TextInputLayout) bindings[86], (TextInputLayout) bindings[106], (TextInputLayout) bindings[91], (TextInputLayout) bindings[72], (TextInputLayout) bindings[36], (TextInputLayout) bindings[74], (TextView) bindings[26], (TextView) bindings[17], (TextView) bindings[14], (TextView) bindings[5], (TextView) bindings[23], (TextView) bindings[20], (TextView) bindings[11], (TextView) bindings[8], (LinearLayout) bindings[24], (LinearLayout) bindings[15], (LinearLayout) bindings[12], (LinearLayout) bindings[3], (LinearLayout) bindings[21], (LinearLayout) bindings[18], (LinearLayout) bindings[9], (LinearLayout) bindings[6], (LinearLayout) bindings[60], (TextView) bindings[59], (TextView) bindings[116], (CardView) bindings[114], (TextView) bindings[113], (TextView) bindings[58], (TextView) bindings[55], (TextView) bindings[54], (EditText) bindings[51], (TextView) bindings[57], (TextView) bindings[56], (TextView) bindings[53], (TextView) bindings[52], (LinearLayout) bindings[47], (TextView) bindings[46], (Spinner) bindings[45], (Spinner) bindings[29], (LinearLayout) bindings[49], (TextView) bindings[48], (LinearLayout) bindings[28], (ProgressBar) bindings[115]);
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
        if (154 != variableId) {
            return false;
        }
        setPalaiNewSemRegViewModel((PalaiNewSemRegViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.DialogPalaiSemRegBinding
    public void setPalaiNewSemRegViewModel(PalaiNewSemRegViewModel PalaiNewSemRegViewModel) {
        this.mPalaiNewSemRegViewModel = PalaiNewSemRegViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}