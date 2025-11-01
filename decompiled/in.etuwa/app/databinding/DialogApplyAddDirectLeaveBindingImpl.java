package in.etuwa.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
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
import in.etuwa.app.ui.leave.duty.directapply.apply.ApplyDirectDutyLeaveViewModel;

/* loaded from: classes3.dex */
public class DialogApplyAddDirectLeaveBindingImpl extends DialogApplyAddDirectLeaveBinding {
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
        sparseIntArray.put(R.id.reg_title, 3);
        sparseIntArray.put(R.id.spinner_duty_head, 4);
        sparseIntArray.put(R.id.et_reason, 5);
        sparseIntArray.put(R.id.et_from_date2, 6);
        sparseIntArray.put(R.id.et_from_date, 7);
        sparseIntArray.put(R.id.et_to_date2, 8);
        sparseIntArray.put(R.id.et_to_date, 9);
        sparseIntArray.put(R.id.completion_card, 10);
        sparseIntArray.put(R.id.completion_file_name, 11);
        sparseIntArray.put(R.id.completion_select, 12);
        sparseIntArray.put(R.id.apply_btn, 13);
        sparseIntArray.put(R.id.update_btn, 14);
        sparseIntArray.put(R.id.progress_view, 15);
        sparseIntArray.put(R.id.upload_progressbar, 16);
        sparseIntArray.put(R.id.progress_text, 17);
    }

    public DialogApplyAddDirectLeaveBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 18, sIncludes, sViewsWithIds));
    }

    private DialogApplyAddDirectLeaveBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (TextView) bindings[13], (LinearLayout) bindings[10], (TextView) bindings[11], (TextView) bindings[12], (EditText) bindings[7], (TextView) bindings[6], (TextInputEditText) bindings[5], (EditText) bindings[9], (TextView) bindings[8], (TextView) bindings[17], (CardView) bindings[15], (TextView) bindings[3], (Spinner) bindings[4], (TextView) bindings[14], (ProgressBar) bindings[16]);
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
        if (24 != variableId) {
            return false;
        }
        setApplyDirectDutyLeaveViewModel((ApplyDirectDutyLeaveViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.DialogApplyAddDirectLeaveBinding
    public void setApplyDirectDutyLeaveViewModel(ApplyDirectDutyLeaveViewModel ApplyDirectDutyLeaveViewModel) {
        this.mApplyDirectDutyLeaveViewModel = ApplyDirectDutyLeaveViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}