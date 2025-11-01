package in.etuwa.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import in.etuwa.app.R;
import in.etuwa.app.ui.semregistration.mvjce.view.ViewMvjceSemRegViewModel;

/* loaded from: classes3.dex */
public class ViewMvjceSemRegDialogBindingImpl extends ViewMvjceSemRegDialogBinding {
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
        sparseIntArray.put(R.id.sem_edit_btn, 3);
        sparseIntArray.put(R.id.reg_slip_btn, 4);
        sparseIntArray.put(R.id.sem_reg_status, 5);
        sparseIntArray.put(R.id.hod_remark_layout, 6);
        sparseIntArray.put(R.id.sem_reg_remark_by_hod, 7);
        sparseIntArray.put(R.id.teacher_remark_layout, 8);
        sparseIntArray.put(R.id.sem_reg_remark_by_teacher, 9);
        sparseIntArray.put(R.id.sem_reg_adm_no, 10);
        sparseIntArray.put(R.id.sem_reg_applied_for, 11);
        sparseIntArray.put(R.id.sem_reg_name, 12);
        sparseIntArray.put(R.id.sem_reg_gender, 13);
        sparseIntArray.put(R.id.sem_reg_phone, 14);
        sparseIntArray.put(R.id.sem_reg_email, 15);
        sparseIntArray.put(R.id.sem_reg_exam_appear, 16);
        sparseIntArray.put(R.id.sem_reg_univ_no, 17);
        sparseIntArray.put(R.id.sem_reg_month_year, 18);
        sparseIntArray.put(R.id.sem_reg_back_paper, 19);
        sparseIntArray.put(R.id.sem_reg_back_paper_count, 20);
        sparseIntArray.put(R.id.sem_reg_earned_credit, 21);
        sparseIntArray.put(R.id.due_layout, 22);
        sparseIntArray.put(R.id.sem_reg_department, 23);
        sparseIntArray.put(R.id.sem_reg_department_due, 24);
        sparseIntArray.put(R.id.sem_reg_library, 25);
        sparseIntArray.put(R.id.sem_reg_library_due, 26);
        sparseIntArray.put(R.id.sem_reg_account, 27);
        sparseIntArray.put(R.id.sem_reg_account_due, 28);
        sparseIntArray.put(R.id.sem_reg_academic, 29);
        sparseIntArray.put(R.id.sem_reg_academic_due, 30);
        sparseIntArray.put(R.id.sem_reg_hostel, 31);
        sparseIntArray.put(R.id.sem_reg_hostel_due, 32);
        sparseIntArray.put(R.id.sem_reg_bus, 33);
        sparseIntArray.put(R.id.sem_reg_bus_due, 34);
    }

    public ViewMvjceSemRegDialogBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 35, sIncludes, sViewsWithIds));
    }

    private ViewMvjceSemRegDialogBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (LinearLayout) bindings[22], (LinearLayout) bindings[6], (TextView) bindings[4], (TextView) bindings[3], (TextView) bindings[29], (TextView) bindings[30], (TextView) bindings[27], (TextView) bindings[28], (TextView) bindings[10], (TextView) bindings[11], (TextView) bindings[19], (TextView) bindings[20], (TextView) bindings[33], (TextView) bindings[34], (TextView) bindings[23], (TextView) bindings[24], (TextView) bindings[21], (TextView) bindings[15], (TextView) bindings[16], (TextView) bindings[13], (TextView) bindings[31], (TextView) bindings[32], (TextView) bindings[25], (TextView) bindings[26], (TextView) bindings[18], (TextView) bindings[12], (TextView) bindings[14], (TextView) bindings[7], (TextView) bindings[9], (TextView) bindings[5], (TextView) bindings[17], (SwipeRefreshLayout) bindings[2], (LinearLayout) bindings[8]);
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
        if (243 != variableId) {
            return false;
        }
        setViewMvjceSemRegViewModel((ViewMvjceSemRegViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.ViewMvjceSemRegDialogBinding
    public void setViewMvjceSemRegViewModel(ViewMvjceSemRegViewModel ViewMvjceSemRegViewModel) {
        this.mViewMvjceSemRegViewModel = ViewMvjceSemRegViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}