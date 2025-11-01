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
import in.etuwa.app.ui.semregistration.mvjce.MvjceSemRegViewModel;

/* loaded from: classes3.dex */
public class DialogMvjceSemRegBindingImpl extends DialogMvjceSemRegBinding {
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
        sparseIntArray.put(R.id.exam_att_tv, 26);
        sparseIntArray.put(R.id.university_previous_layout, 27);
        sparseIntArray.put(R.id.spinner_semester_last_attended, 28);
        sparseIntArray.put(R.id.exam_group, 29);
        sparseIntArray.put(R.id.exam_yes, 30);
        sparseIntArray.put(R.id.exam_no, 31);
        sparseIntArray.put(R.id.back_group, 32);
        sparseIntArray.put(R.id.back_yes, 33);
        sparseIntArray.put(R.id.back_no, 34);
        sparseIntArray.put(R.id.mt_month_year, 35);
        sparseIntArray.put(R.id.et_month_year, 36);
        sparseIntArray.put(R.id.mt_back_papers, 37);
        sparseIntArray.put(R.id.et_back_paper_count, 38);
        sparseIntArray.put(R.id.et_earned_credits, 39);
        sparseIntArray.put(R.id.honor_minor_tv, 40);
        sparseIntArray.put(R.id.honor_minor_lt, 41);
        sparseIntArray.put(R.id.spinner_honour, 42);
        sparseIntArray.put(R.id.spinner_minor, 43);
        sparseIntArray.put(R.id.global_elec_tv, 44);
        sparseIntArray.put(R.id.global_elec_lt, 45);
        sparseIntArray.put(R.id.elective1, 46);
        sparseIntArray.put(R.id.elective2, 47);
        sparseIntArray.put(R.id.elective3, 48);
        sparseIntArray.put(R.id.global_elective1, 49);
        sparseIntArray.put(R.id.global_elective2, 50);
        sparseIntArray.put(R.id.global_elective3, 51);
        sparseIntArray.put(R.id.additional_elective1, 52);
        sparseIntArray.put(R.id.additional_elective2, 53);
        sparseIntArray.put(R.id.additional_elective3, 54);
        sparseIntArray.put(R.id.global_elec_third_lt, 55);
        sparseIntArray.put(R.id.third_elective1, 56);
        sparseIntArray.put(R.id.third_elective2, 57);
        sparseIntArray.put(R.id.third_elective3, 58);
        sparseIntArray.put(R.id.third_program_elective1, 59);
        sparseIntArray.put(R.id.third_program_elective2, 60);
        sparseIntArray.put(R.id.third_program_elective3, 61);
        sparseIntArray.put(R.id.third_global_elective1, 62);
        sparseIntArray.put(R.id.third_additional_elective1, 63);
        sparseIntArray.put(R.id.third_additional_elective2, 64);
        sparseIntArray.put(R.id.third_additional_elective3, 65);
        sparseIntArray.put(R.id.third_additional_elective4, 66);
        sparseIntArray.put(R.id.sgpa_cgpa_tv, 67);
        sparseIntArray.put(R.id.sgpa_cgpa_lt, 68);
        sparseIntArray.put(R.id.supply_tv, 69);
        sparseIntArray.put(R.id.supply_lt, 70);
        sparseIntArray.put(R.id.et_sem_one, 71);
        sparseIntArray.put(R.id.sem_date_one, 72);
        sparseIntArray.put(R.id.sem_date_two, 73);
        sparseIntArray.put(R.id.sem_date_three, 74);
        sparseIntArray.put(R.id.sem_date_four, 75);
        sparseIntArray.put(R.id.sem_date_five, 76);
        sparseIntArray.put(R.id.sem_date_six, 77);
        sparseIntArray.put(R.id.sem_date_seven, 78);
        sparseIntArray.put(R.id.sem_date_eight, 79);
        sparseIntArray.put(R.id.prev_sem_tv, 80);
        sparseIntArray.put(R.id.prev_sem_lt, 81);
        sparseIntArray.put(R.id.fee_details_tv, 82);
        sparseIntArray.put(R.id.fee_details_lt, 83);
        sparseIntArray.put(R.id.fee_due, 84);
        sparseIntArray.put(R.id.fee_yes, 85);
        sparseIntArray.put(R.id.fee_no, 86);
        sparseIntArray.put(R.id.mt_bank_name, 87);
        sparseIntArray.put(R.id.et_bank_name, 88);
        sparseIntArray.put(R.id.mt_amount_paid, 89);
        sparseIntArray.put(R.id.et_amount_paid, 90);
        sparseIntArray.put(R.id.mt_date_payment, 91);
        sparseIntArray.put(R.id.et_date_payment, 92);
        sparseIntArray.put(R.id.mt_mode_payment, 93);
        sparseIntArray.put(R.id.et_mode_payment, 94);
        sparseIntArray.put(R.id.mt_ref_no, 95);
        sparseIntArray.put(R.id.et_ref_no, 96);
        sparseIntArray.put(R.id.upload_lyt, 97);
        sparseIntArray.put(R.id.completion_select, 98);
        sparseIntArray.put(R.id.completion_file_name, 99);
        sparseIntArray.put(R.id.concession_btn, 100);
        sparseIntArray.put(R.id.concession_yes, 101);
        sparseIntArray.put(R.id.concession_no, 102);
        sparseIntArray.put(R.id.mt_concession_detsils, 103);
        sparseIntArray.put(R.id.et_concession_details, 104);
        sparseIntArray.put(R.id.due_tv, 105);
        sparseIntArray.put(R.id.due_lt, 106);
        sparseIntArray.put(R.id.department_due, 107);
        sparseIntArray.put(R.id.dept_yes, 108);
        sparseIntArray.put(R.id.dept_no, 109);
        sparseIntArray.put(R.id.mt_dept_detail, 110);
        sparseIntArray.put(R.id.et_dept_details, 111);
        sparseIntArray.put(R.id.library_due, 112);
        sparseIntArray.put(R.id.library_yes, 113);
        sparseIntArray.put(R.id.library_no, 114);
        sparseIntArray.put(R.id.mt_library_detail, 115);
        sparseIntArray.put(R.id.et_library_details, 116);
        sparseIntArray.put(R.id.accounts_due, 117);
        sparseIntArray.put(R.id.accounts_yes, 118);
        sparseIntArray.put(R.id.accounts_no, 119);
        sparseIntArray.put(R.id.mt_account_detail, 120);
        sparseIntArray.put(R.id.et_accounts_details, 121);
        sparseIntArray.put(R.id.academic_due, 122);
        sparseIntArray.put(R.id.academic_yes, 123);
        sparseIntArray.put(R.id.academic_no, 124);
        sparseIntArray.put(R.id.mt_academic_detail, 125);
        sparseIntArray.put(R.id.et_academic_details, 126);
        sparseIntArray.put(R.id.hostel_due, 127);
        sparseIntArray.put(R.id.hostel_yes, 128);
        sparseIntArray.put(R.id.hostel_no, 129);
        sparseIntArray.put(R.id.mt_hostel_detail, 130);
        sparseIntArray.put(R.id.et_hostel_details, 131);
        sparseIntArray.put(R.id.bus_due, 132);
        sparseIntArray.put(R.id.bus_yes, 133);
        sparseIntArray.put(R.id.bus_no, 134);
        sparseIntArray.put(R.id.mt_bus_detail, 135);
        sparseIntArray.put(R.id.et_bus_details, 136);
        sparseIntArray.put(R.id.register_lyt, 137);
        sparseIntArray.put(R.id.tv_fee_engnr_total, 138);
        sparseIntArray.put(R.id.register_btn, 139);
        sparseIntArray.put(R.id.progress_view, 140);
        sparseIntArray.put(R.id.upload_progressbar, 141);
        sparseIntArray.put(R.id.progress_text, 142);
    }

    public DialogMvjceSemRegBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 143, sIncludes, sViewsWithIds));
    }

    private DialogMvjceSemRegBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (RadioGroup) bindings[122], (RadioButton) bindings[124], (RadioButton) bindings[123], (RadioGroup) bindings[117], (RadioButton) bindings[119], (RadioButton) bindings[118], (Spinner) bindings[52], (Spinner) bindings[53], (Spinner) bindings[54], (TextView) bindings[25], (TextView) bindings[16], (TextView) bindings[13], (RadioGroup) bindings[32], (RadioButton) bindings[34], (TextView) bindings[4], (TextView) bindings[22], (TextView) bindings[19], (TextView) bindings[10], (TextView) bindings[7], (RadioButton) bindings[33], (RadioGroup) bindings[132], (RadioButton) bindings[134], (RadioButton) bindings[133], (TextView) bindings[99], (TextView) bindings[98], (RadioGroup) bindings[100], (RadioButton) bindings[102], (RadioButton) bindings[101], (RadioGroup) bindings[107], (RadioButton) bindings[109], (RadioButton) bindings[108], (LinearLayout) bindings[106], (TextView) bindings[105], (Spinner) bindings[46], (Spinner) bindings[47], (Spinner) bindings[48], (TextInputEditText) bindings[126], (TextInputEditText) bindings[121], (TextInputEditText) bindings[90], (TextInputEditText) bindings[38], (TextInputEditText) bindings[88], (TextInputEditText) bindings[136], (TextInputEditText) bindings[104], (TextInputEditText) bindings[92], (TextInputEditText) bindings[111], (TextInputEditText) bindings[39], (TextInputEditText) bindings[131], (TextInputEditText) bindings[116], (TextInputEditText) bindings[94], (TextInputEditText) bindings[36], (TextInputEditText) bindings[96], (TextInputEditText) bindings[71], (TextView) bindings[26], (RadioGroup) bindings[29], (RadioButton) bindings[31], (RadioButton) bindings[30], (LinearLayout) bindings[83], (TextView) bindings[82], (RadioGroup) bindings[84], (RadioButton) bindings[86], (RadioButton) bindings[85], (LinearLayout) bindings[45], (LinearLayout) bindings[55], (TextView) bindings[44], (Spinner) bindings[49], (Spinner) bindings[50], (Spinner) bindings[51], (LinearLayout) bindings[41], (TextView) bindings[40], (RadioGroup) bindings[127], (RadioButton) bindings[129], (RadioButton) bindings[128], (RadioGroup) bindings[112], (RadioButton) bindings[114], (RadioButton) bindings[113], (TextInputLayout) bindings[125], (TextInputLayout) bindings[120], (TextInputLayout) bindings[89], (TextInputLayout) bindings[37], (TextInputLayout) bindings[87], (TextInputLayout) bindings[135], (TextInputLayout) bindings[103], (TextInputLayout) bindings[91], (TextInputLayout) bindings[110], (TextInputLayout) bindings[130], (TextInputLayout) bindings[115], (TextInputLayout) bindings[93], (TextInputLayout) bindings[35], (TextInputLayout) bindings[95], (TextView) bindings[17], (TextView) bindings[14], (TextView) bindings[5], (TextView) bindings[23], (TextView) bindings[20], (TextView) bindings[11], (TextView) bindings[8], (LinearLayout) bindings[24], (LinearLayout) bindings[15], (LinearLayout) bindings[12], (LinearLayout) bindings[3], (LinearLayout) bindings[21], (LinearLayout) bindings[18], (LinearLayout) bindings[9], (LinearLayout) bindings[6], (LinearLayout) bindings[81], (TextView) bindings[80], (TextView) bindings[142], (CardView) bindings[140], (TextView) bindings[139], (LinearLayout) bindings[137], (TextView) bindings[79], (TextView) bindings[76], (TextView) bindings[75], (EditText) bindings[72], (TextView) bindings[78], (TextView) bindings[77], (TextView) bindings[74], (TextView) bindings[73], (LinearLayout) bindings[68], (TextView) bindings[67], (Spinner) bindings[42], (Spinner) bindings[43], (Spinner) bindings[28], (LinearLayout) bindings[70], (TextView) bindings[69], (Spinner) bindings[63], (Spinner) bindings[64], (Spinner) bindings[65], (Spinner) bindings[66], (Spinner) bindings[56], (Spinner) bindings[57], (Spinner) bindings[58], (Spinner) bindings[62], (Spinner) bindings[59], (Spinner) bindings[60], (Spinner) bindings[61], (TextView) bindings[138], (LinearLayout) bindings[27], (LinearLayout) bindings[97], (ProgressBar) bindings[141]);
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
        if (145 != variableId) {
            return false;
        }
        setMvjceSemRegViewModel((MvjceSemRegViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.DialogMvjceSemRegBinding
    public void setMvjceSemRegViewModel(MvjceSemRegViewModel MvjceSemRegViewModel) {
        this.mMvjceSemRegViewModel = MvjceSemRegViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}