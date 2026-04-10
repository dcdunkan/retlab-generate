package in.etuwa.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import at.grabner.circleprogress.CircleProgressView;
import com.google.android.material.card.MaterialCardView;
import in.etuwa.app.R;
import in.etuwa.app.ui.attendance.bysubject.AttendanceViewModel;

/* JADX INFO: loaded from: classes3.dex */
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
        sparseIntArray.put(R.id.toolbar, 2);
        sparseIntArray.put(R.id.hr_view, 3);
        sparseIntArray.put(R.id.by_subject_btn, 4);
        sparseIntArray.put(R.id.by_day_btn, 5);
        sparseIntArray.put(R.id.by_subject_lyt, 6);
        sparseIntArray.put(R.id.spinner_lt, 7);
        sparseIntArray.put(R.id.spinner_sem, 8);
        sparseIntArray.put(R.id.total_cv, 9);
        sparseIntArray.put(R.id.attendance_by_sub, 10);
        sparseIntArray.put(R.id.attendance_by_total, 11);
        sparseIntArray.put(R.id.attendance_by_per, 12);
        sparseIntArray.put(R.id.segment_view, 13);
        sparseIntArray.put(R.id.without_btn, 14);
        sparseIntArray.put(R.id.without_tv, 15);
        sparseIntArray.put(R.id.with_btn, 16);
        sparseIntArray.put(R.id.with_tv, 17);
        sparseIntArray.put(R.id.swipe_layout, 18);
        sparseIntArray.put(R.id.rv_attendance, 19);
        sparseIntArray.put(R.id.atteandce_by_day_lyt, 20);
        sparseIntArray.put(R.id.previous_btn, 21);
        sparseIntArray.put(R.id.month_tv, 22);
        sparseIntArray.put(R.id.next_btn, 23);
        sparseIntArray.put(R.id.rv_calender, 24);
    }

    public AttendanceFragmentBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 25, sIncludes, sViewsWithIds));
    }

    private AttendanceFragmentBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (CardView) bindings[20], (CircleProgressView) bindings[12], (TextView) bindings[10], (TextView) bindings[11], (TextView) bindings[5], (TextView) bindings[4], (LinearLayout) bindings[6], (HorizontalScrollView) bindings[3], (TextView) bindings[22], (CardView) bindings[23], (CardView) bindings[21], (RecyclerView) bindings[19], (RecyclerView) bindings[24], (MaterialCardView) bindings[13], (MaterialCardView) bindings[7], (Spinner) bindings[8], (SwipeRefreshLayout) bindings[18], (TextView) bindings[2], (MaterialCardView) bindings[9], (LinearLayout) bindings[16], (View) bindings[17], (LinearLayout) bindings[14], (View) bindings[15]);
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