package in.etuwa.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import in.etuwa.app.R;
import in.etuwa.app.ui.attendance.calendarview.AttendanceCalendarViewViewModel;

/* loaded from: classes3.dex */
public class FragmentAttendanceCalendarViewBindingImpl extends FragmentAttendanceCalendarViewBinding {
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
        sparseIntArray.put(R.id.previous_btn, 2);
        sparseIntArray.put(R.id.month_tv, 3);
        sparseIntArray.put(R.id.next_btn, 4);
        sparseIntArray.put(R.id.rv_calender, 5);
    }

    public FragmentAttendanceCalendarViewBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds));
    }

    private FragmentAttendanceCalendarViewBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (TextView) bindings[3], (TextView) bindings[4], (TextView) bindings[2], (RecyclerView) bindings[5]);
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
        if (34 != variableId) {
            return false;
        }
        setAttendanceCalendarViewViewModel((AttendanceCalendarViewViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.FragmentAttendanceCalendarViewBinding
    public void setAttendanceCalendarViewViewModel(AttendanceCalendarViewViewModel AttendanceCalendarViewViewModel) {
        this.mAttendanceCalendarViewViewModel = AttendanceCalendarViewViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}