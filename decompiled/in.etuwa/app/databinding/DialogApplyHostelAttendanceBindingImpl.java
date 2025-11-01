package in.etuwa.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.textfield.TextInputEditText;
import in.etuwa.app.R;
import in.etuwa.app.ui.hostel.attendance.applyleave.HostelApplyLeaveViewModel;

/* loaded from: classes3.dex */
public class DialogApplyHostelAttendanceBindingImpl extends DialogApplyHostelAttendanceBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ScrollView mboundView0;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.spinner_leave_type, 1);
        sparseIntArray.put(R.id.lt_from_date, 2);
        sparseIntArray.put(R.id.et_from_date, 3);
        sparseIntArray.put(R.id.lt_end_date, 4);
        sparseIntArray.put(R.id.et_end_date, 5);
        sparseIntArray.put(R.id.et_reason, 6);
        sparseIntArray.put(R.id.save_btn, 7);
    }

    public DialogApplyHostelAttendanceBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 8, sIncludes, sViewsWithIds));
    }

    private DialogApplyHostelAttendanceBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (TextView) bindings[5], (TextView) bindings[3], (TextInputEditText) bindings[6], (CardView) bindings[4], (CardView) bindings[2], (TextView) bindings[7], (Spinner) bindings[1]);
        this.mDirtyFlags = -1L;
        ScrollView scrollView = (ScrollView) bindings[0];
        this.mboundView0 = scrollView;
        scrollView.setTag(null);
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
        if (105 != variableId) {
            return false;
        }
        setHostelApplyLeaveViewModel((HostelApplyLeaveViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.DialogApplyHostelAttendanceBinding
    public void setHostelApplyLeaveViewModel(HostelApplyLeaveViewModel HostelApplyLeaveViewModel) {
        this.mHostelApplyLeaveViewModel = HostelApplyLeaveViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}