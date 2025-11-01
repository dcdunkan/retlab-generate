package in.etuwa.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import at.grabner.circleprogress.CircleProgressView;
import in.etuwa.app.R;
import in.etuwa.app.ui.attendance.bysubject.AttendanceViewModel;

/* loaded from: classes3.dex */
public class AttendanceFragmentBindingImpl extends AttendanceFragmentBinding {
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
        sparseIntArray.put(R.id.by_day_btn, 2);
        sparseIntArray.put(R.id.spinner_lt, 3);
        sparseIntArray.put(R.id.spinner_sem, 4);
        sparseIntArray.put(R.id.total_cv, 5);
        sparseIntArray.put(R.id.attendance_by_sub, 6);
        sparseIntArray.put(R.id.attendance_by_total, 7);
        sparseIntArray.put(R.id.attendance_by_per, 8);
        sparseIntArray.put(R.id.segment_view, 9);
        sparseIntArray.put(R.id.without_btn, 10);
        sparseIntArray.put(R.id.without_tv, 11);
        sparseIntArray.put(R.id.with_btn, 12);
        sparseIntArray.put(R.id.with_tv, 13);
        sparseIntArray.put(R.id.swipe_layout, 14);
        sparseIntArray.put(R.id.rv_attendance, 15);
    }

    public AttendanceFragmentBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 16, sIncludes, sViewsWithIds));
    }

    private AttendanceFragmentBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (CircleProgressView) bindings[8], (TextView) bindings[6], (TextView) bindings[7], (Button) bindings[2], (RecyclerView) bindings[15], (LinearLayout) bindings[9], (LinearLayout) bindings[3], (Spinner) bindings[4], (SwipeRefreshLayout) bindings[14], (CardView) bindings[5], (LinearLayout) bindings[12], (TextView) bindings[13], (LinearLayout) bindings[10], (TextView) bindings[11]);
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
        if (36 != variableId) {
            return false;
        }
        setAttendanceViewModel((AttendanceViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.AttendanceFragmentBinding
    public void setAttendanceViewModel(AttendanceViewModel AttendanceViewModel) {
        this.mAttendanceViewModel = AttendanceViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}