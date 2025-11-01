package in.etuwa.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
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
import in.etuwa.app.ui.semregistration.mace.MaceNewSemRegViewModel;

/* loaded from: classes3.dex */
public class DialogMaceSemRegBindingImpl extends DialogMaceSemRegBinding {
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
        sparseIntArray.put(R.id.personal_details_lyt, 15);
        sparseIntArray.put(R.id.et_phone_number, 16);
        sparseIntArray.put(R.id.et_email_id, 17);
        sparseIntArray.put(R.id.et_name_of_house, 18);
        sparseIntArray.put(R.id.et_address, 19);
        sparseIntArray.put(R.id.et_contact_num, 20);
        sparseIntArray.put(R.id.et_parents_mob, 21);
        sparseIntArray.put(R.id.university_previous_layout, 22);
        sparseIntArray.put(R.id.spinner_semester_last_attended, 23);
        sparseIntArray.put(R.id.exam_group, 24);
        sparseIntArray.put(R.id.exam_yes, 25);
        sparseIntArray.put(R.id.exam_no, 26);
        sparseIntArray.put(R.id.mt_month_year, 27);
        sparseIntArray.put(R.id.et_month_year, 28);
        sparseIntArray.put(R.id.back_group, 29);
        sparseIntArray.put(R.id.back_yes, 30);
        sparseIntArray.put(R.id.back_no, 31);
        sparseIntArray.put(R.id.mt_back_papers, 32);
        sparseIntArray.put(R.id.et_back_paper_count, 33);
        sparseIntArray.put(R.id.et_period_discontinued, 34);
        sparseIntArray.put(R.id.et_credits_earned, 35);
        sparseIntArray.put(R.id.spinner_academic_year, 36);
        sparseIntArray.put(R.id.honor_minor_lt, 37);
        sparseIntArray.put(R.id.exam_att_tv, 38);
        sparseIntArray.put(R.id.honour_group, 39);
        sparseIntArray.put(R.id.honour_yes, 40);
        sparseIntArray.put(R.id.honour_no, 41);
        sparseIntArray.put(R.id.minor_group, 42);
        sparseIntArray.put(R.id.minor_yes, 43);
        sparseIntArray.put(R.id.minor_no, 44);
        sparseIntArray.put(R.id.dues_lt, 45);
        sparseIntArray.put(R.id.library_due, 46);
        sparseIntArray.put(R.id.library_yes, 47);
        sparseIntArray.put(R.id.library_no, 48);
        sparseIntArray.put(R.id.mt_dept_lib, 49);
        sparseIntArray.put(R.id.et_dept_lib, 50);
        sparseIntArray.put(R.id.college_library_group, 51);
        sparseIntArray.put(R.id.college_library_yes, 52);
        sparseIntArray.put(R.id.college_library_no, 53);
        sparseIntArray.put(R.id.mt_library_details, 54);
        sparseIntArray.put(R.id.et_library_details, 55);
        sparseIntArray.put(R.id.et_lab_one, 56);
        sparseIntArray.put(R.id.lab_one_group, 57);
        sparseIntArray.put(R.id.lab_one_yes, 58);
        sparseIntArray.put(R.id.lab_one_no, 59);
        sparseIntArray.put(R.id.mt_lab_one_details, 60);
        sparseIntArray.put(R.id.et_lab_one_details, 61);
        sparseIntArray.put(R.id.et_lab_two, 62);
        sparseIntArray.put(R.id.dues_tv, 63);
        sparseIntArray.put(R.id.lab_two_group, 64);
        sparseIntArray.put(R.id.lab_two_yes, 65);
        sparseIntArray.put(R.id.lab_two_no, 66);
        sparseIntArray.put(R.id.mt_lab_two_details, 67);
        sparseIntArray.put(R.id.et_lab_two_details, 68);
        sparseIntArray.put(R.id.register_btn, 69);
    }

    public DialogMaceSemRegBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 70, sIncludes, sViewsWithIds));
    }

    private DialogMaceSemRegBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (TextView) bindings[13], (RadioGroup) bindings[29], (RadioButton) bindings[31], (TextView) bindings[4], (TextView) bindings[10], (TextView) bindings[7], (RadioButton) bindings[30], (RadioGroup) bindings[51], (RadioButton) bindings[53], (RadioButton) bindings[52], (LinearLayout) bindings[45], (TextView) bindings[63], (TextInputEditText) bindings[19], (TextInputEditText) bindings[33], (TextInputEditText) bindings[20], (TextInputEditText) bindings[35], (TextInputEditText) bindings[50], (TextInputEditText) bindings[17], (TextInputEditText) bindings[56], (TextInputEditText) bindings[61], (TextInputEditText) bindings[62], (TextInputEditText) bindings[68], (TextInputEditText) bindings[55], (TextInputEditText) bindings[28], (TextInputEditText) bindings[18], (TextInputEditText) bindings[21], (TextInputEditText) bindings[34], (TextInputEditText) bindings[16], (TextView) bindings[38], (RadioGroup) bindings[24], (RadioButton) bindings[26], (RadioButton) bindings[25], (LinearLayout) bindings[37], (RadioGroup) bindings[39], (RadioButton) bindings[41], (RadioButton) bindings[40], (RadioGroup) bindings[57], (RadioButton) bindings[59], (RadioButton) bindings[58], (RadioGroup) bindings[64], (RadioButton) bindings[66], (RadioButton) bindings[65], (RadioGroup) bindings[46], (RadioButton) bindings[48], (RadioButton) bindings[47], (RadioGroup) bindings[42], (RadioButton) bindings[44], (RadioButton) bindings[43], (TextInputLayout) bindings[32], (TextInputLayout) bindings[49], (TextInputLayout) bindings[60], (TextInputLayout) bindings[67], (TextInputLayout) bindings[54], (TextInputLayout) bindings[27], (TextView) bindings[14], (TextView) bindings[5], (TextView) bindings[11], (TextView) bindings[8], (LinearLayout) bindings[12], (LinearLayout) bindings[3], (LinearLayout) bindings[9], (LinearLayout) bindings[6], (LinearLayout) bindings[15], (TextView) bindings[69], (Spinner) bindings[36], (Spinner) bindings[23], (LinearLayout) bindings[22]);
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
        if (131 != variableId) {
            return false;
        }
        setMaceNewSemRegViewModel((MaceNewSemRegViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.DialogMaceSemRegBinding
    public void setMaceNewSemRegViewModel(MaceNewSemRegViewModel MaceNewSemRegViewModel) {
        this.mMaceNewSemRegViewModel = MaceNewSemRegViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}