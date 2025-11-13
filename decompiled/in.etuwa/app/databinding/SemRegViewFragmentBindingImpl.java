package in.etuwa.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import de.hdodenhof.circleimageview.CircleImageView;
import in.etuwa.app.R;
import in.etuwa.app.ui.semregistration.view.SemRegViewViewModel;

/* loaded from: classes3.dex */
public class SemRegViewFragmentBindingImpl extends SemRegViewFragmentBinding {
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
        sparseIntArray.put(R.id.swipe_layout, 2);
        sparseIntArray.put(R.id.sem_reg_profile_image, 3);
        sparseIntArray.put(R.id.sem_edit_btn, 4);
        sparseIntArray.put(R.id.reg_slip_btn, 5);
        sparseIntArray.put(R.id.sem_reg_status, 6);
        sparseIntArray.put(R.id.hod_remark_layout, 7);
        sparseIntArray.put(R.id.sem_reg_remark_by_hod, 8);
        sparseIntArray.put(R.id.teacher_remark_layout, 9);
        sparseIntArray.put(R.id.sem_reg_remark_by_teacher, 10);
        sparseIntArray.put(R.id.sem_reg_adm_no, 11);
        sparseIntArray.put(R.id.sem_reg_applied_for, 12);
        sparseIntArray.put(R.id.sem_reg_name, 13);
        sparseIntArray.put(R.id.sem_reg_gender, 14);
        sparseIntArray.put(R.id.sem_reg_phone, 15);
        sparseIntArray.put(R.id.sem_reg_email, 16);
        sparseIntArray.put(R.id.sem_reg_exam_appear, 17);
        sparseIntArray.put(R.id.sem_reg_univ_no, 18);
        sparseIntArray.put(R.id.sem_reg_month_year, 19);
        sparseIntArray.put(R.id.sem_reg_back_paper, 20);
        sparseIntArray.put(R.id.sem_reg_back_paper_count, 21);
        sparseIntArray.put(R.id.sem_reg_earned_credit, 22);
        sparseIntArray.put(R.id.fee_layout, 23);
        sparseIntArray.put(R.id.sem_reg_fee_paid, 24);
        sparseIntArray.put(R.id.sem_reg_bank, 25);
        sparseIntArray.put(R.id.sem_reg_amount, 26);
        sparseIntArray.put(R.id.sem_reg_payment_mode, 27);
        sparseIntArray.put(R.id.sem_reg_fee_receipt, 28);
        sparseIntArray.put(R.id.sem_reg_ref_no, 29);
        sparseIntArray.put(R.id.sem_reg_e_grand, 30);
        sparseIntArray.put(R.id.sem_reg_fee_concession, 31);
        sparseIntArray.put(R.id.due_layout, 32);
        sparseIntArray.put(R.id.sem_reg_department, 33);
        sparseIntArray.put(R.id.sem_reg_department_due, 34);
        sparseIntArray.put(R.id.sem_reg_library, 35);
        sparseIntArray.put(R.id.sem_reg_library_due, 36);
        sparseIntArray.put(R.id.sem_reg_account, 37);
        sparseIntArray.put(R.id.sem_reg_account_due, 38);
        sparseIntArray.put(R.id.sem_reg_academic, 39);
        sparseIntArray.put(R.id.sem_reg_academic_due, 40);
        sparseIntArray.put(R.id.sem_reg_hostel, 41);
        sparseIntArray.put(R.id.sem_reg_hostel_due, 42);
        sparseIntArray.put(R.id.sem_reg_bus, 43);
        sparseIntArray.put(R.id.sem_reg_bus_due, 44);
    }

    public SemRegViewFragmentBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 45, sIncludes, sViewsWithIds));
    }

    private SemRegViewFragmentBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (LinearLayout) bindings[32], (LinearLayout) bindings[23], (LinearLayout) bindings[7], (TextView) bindings[5], (TextView) bindings[4], (TextView) bindings[39], (TextView) bindings[40], (TextView) bindings[37], (TextView) bindings[38], (TextView) bindings[11], (TextView) bindings[26], (TextView) bindings[12], (TextView) bindings[20], (TextView) bindings[21], (TextView) bindings[25], (TextView) bindings[43], (TextView) bindings[44], (TextView) bindings[33], (TextView) bindings[34], (TextView) bindings[30], (TextView) bindings[22], (TextView) bindings[16], (TextView) bindings[17], (TextView) bindings[31], (TextView) bindings[24], (TextView) bindings[28], (TextView) bindings[14], (TextView) bindings[41], (TextView) bindings[42], (TextView) bindings[35], (TextView) bindings[36], (TextView) bindings[19], (TextView) bindings[13], (TextView) bindings[27], (TextView) bindings[15], (CircleImageView) bindings[3], (TextView) bindings[29], (TextView) bindings[8], (TextView) bindings[10], (TextView) bindings[6], (TextView) bindings[18], (SwipeRefreshLayout) bindings[2], (LinearLayout) bindings[9]);
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
        if (200 != variableId) {
            return false;
        }
        setSemRegViewViewModel((SemRegViewViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.SemRegViewFragmentBinding
    public void setSemRegViewViewModel(SemRegViewViewModel SemRegViewViewModel) {
        this.mSemRegViewViewModel = SemRegViewViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}