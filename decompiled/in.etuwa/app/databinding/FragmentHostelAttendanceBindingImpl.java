package in.etuwa.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.applandeo.materialcalendarview.CalendarView;
import in.etuwa.app.R;
import in.etuwa.app.ui.hostel.attendance.HostelAttendanceViewModel;

/* loaded from: classes3.dex */
public class FragmentHostelAttendanceBindingImpl extends FragmentHostelAttendanceBinding {
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
        sparseIntArray.put(R.id.btn_apply, 2);
        sparseIntArray.put(R.id.btn_view, 3);
        sparseIntArray.put(R.id.attendance_view, 4);
    }

    public FragmentHostelAttendanceBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds));
    }

    private FragmentHostelAttendanceBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (CalendarView) bindings[4], (TextView) bindings[2], (TextView) bindings[3]);
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
        if (107 != variableId) {
            return false;
        }
        setHostelAttendanceViewModel((HostelAttendanceViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.FragmentHostelAttendanceBinding
    public void setHostelAttendanceViewModel(HostelAttendanceViewModel HostelAttendanceViewModel) {
        this.mHostelAttendanceViewModel = HostelAttendanceViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}