package in.etuwa.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import in.etuwa.app.R;
import in.etuwa.app.ui.leave.duty.proof.ProofDutyLeaveViewModel;

/* loaded from: classes3.dex */
public class DialogDutyLeaveBindingImpl extends DialogDutyLeaveBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final FrameLayout mboundView0;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.loader, 1);
        sparseIntArray.put(R.id.progress_view, 2);
        sparseIntArray.put(R.id.upload_progressbar, 3);
        sparseIntArray.put(R.id.progress_text, 4);
        sparseIntArray.put(R.id.duty_card, 5);
        sparseIntArray.put(R.id.datelt1, 6);
        sparseIntArray.put(R.id.date1, 7);
        sparseIntArray.put(R.id.check_box_one, 8);
        sparseIntArray.put(R.id.datelt2, 9);
        sparseIntArray.put(R.id.date2, 10);
        sparseIntArray.put(R.id.check_box_two, 11);
        sparseIntArray.put(R.id.datelt3, 12);
        sparseIntArray.put(R.id.date3, 13);
        sparseIntArray.put(R.id.check_box_three, 14);
        sparseIntArray.put(R.id.datelt4, 15);
        sparseIntArray.put(R.id.date4, 16);
        sparseIntArray.put(R.id.check_box_four, 17);
        sparseIntArray.put(R.id.datelt5, 18);
        sparseIntArray.put(R.id.date5, 19);
        sparseIntArray.put(R.id.check_box_five, 20);
        sparseIntArray.put(R.id.datelt6, 21);
        sparseIntArray.put(R.id.date6, 22);
        sparseIntArray.put(R.id.check_box_six, 23);
        sparseIntArray.put(R.id.datelt7, 24);
        sparseIntArray.put(R.id.date7, 25);
        sparseIntArray.put(R.id.check_box_seven, 26);
        sparseIntArray.put(R.id.datelt8, 27);
        sparseIntArray.put(R.id.date8, 28);
        sparseIntArray.put(R.id.check_box_eight, 29);
        sparseIntArray.put(R.id.datelt9, 30);
        sparseIntArray.put(R.id.date9, 31);
        sparseIntArray.put(R.id.check_box_nine, 32);
        sparseIntArray.put(R.id.datelt10, 33);
        sparseIntArray.put(R.id.date10, 34);
        sparseIntArray.put(R.id.check_box_ten, 35);
        sparseIntArray.put(R.id.file_name, 36);
        sparseIntArray.put(R.id.duty_select, 37);
        sparseIntArray.put(R.id.duty_upload, 38);
    }

    public DialogDutyLeaveBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 39, sIncludes, sViewsWithIds));
    }

    private DialogDutyLeaveBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (CheckBox) bindings[29], (CheckBox) bindings[20], (CheckBox) bindings[17], (CheckBox) bindings[32], (CheckBox) bindings[8], (CheckBox) bindings[26], (CheckBox) bindings[23], (CheckBox) bindings[35], (CheckBox) bindings[14], (CheckBox) bindings[11], (TextView) bindings[7], (TextView) bindings[34], (TextView) bindings[10], (TextView) bindings[13], (TextView) bindings[16], (TextView) bindings[19], (TextView) bindings[22], (TextView) bindings[25], (TextView) bindings[28], (TextView) bindings[31], (LinearLayout) bindings[6], (LinearLayout) bindings[33], (LinearLayout) bindings[9], (LinearLayout) bindings[12], (LinearLayout) bindings[15], (LinearLayout) bindings[18], (LinearLayout) bindings[21], (LinearLayout) bindings[24], (LinearLayout) bindings[27], (LinearLayout) bindings[30], (LinearLayout) bindings[5], (TextView) bindings[37], (TextView) bindings[38], (TextView) bindings[36], (ProgressBar) bindings[1], (TextView) bindings[4], (LinearLayout) bindings[2], (ProgressBar) bindings[3]);
        this.mDirtyFlags = -1L;
        FrameLayout frameLayout = (FrameLayout) bindings[0];
        this.mboundView0 = frameLayout;
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
        if (168 != variableId) {
            return false;
        }
        setProofDutyLeaveViewModel((ProofDutyLeaveViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.DialogDutyLeaveBinding
    public void setProofDutyLeaveViewModel(ProofDutyLeaveViewModel ProofDutyLeaveViewModel) {
        this.mProofDutyLeaveViewModel = ProofDutyLeaveViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}