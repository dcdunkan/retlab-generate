package in.etuwa.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import in.etuwa.app.R;
import in.etuwa.app.ui.hostel.attendance.parent.HostelAttendanceParentViewModel;

/* loaded from: classes3.dex */
public class FragmentHostelAttendanceParentFragmentBindingImpl extends FragmentHostelAttendanceParentFragmentBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final FrameLayout mboundView0;
    private final CardView mboundView1;
    private final ViewProgressBarBinding mboundView11;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.approval_tv, 3);
        sparseIntArray.put(R.id.rejects_tv, 4);
        sparseIntArray.put(R.id.all_tv, 5);
        sparseIntArray.put(R.id.swipe_layout, 6);
        sparseIntArray.put(R.id.rv_hostel_att_view, 7);
        sparseIntArray.put(R.id.no_data, 8);
        sparseIntArray.put(R.id.fab_date_filter, 9);
    }

    public FragmentHostelAttendanceParentFragmentBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 10, sIncludes, sViewsWithIds));
    }

    private FragmentHostelAttendanceParentFragmentBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (TextView) bindings[5], (TextView) bindings[3], (FloatingActionButton) bindings[9], (TextView) bindings[8], (TextView) bindings[4], (RecyclerView) bindings[7], (CardView) bindings[6]);
        this.mDirtyFlags = -1L;
        FrameLayout frameLayout = (FrameLayout) bindings[0];
        this.mboundView0 = frameLayout;
        frameLayout.setTag(null);
        CardView cardView = (CardView) bindings[1];
        this.mboundView1 = cardView;
        cardView.setTag(null);
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
        if (107 != variableId) {
            return false;
        }
        setHostelAttendanceParentViewModel((HostelAttendanceParentViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.FragmentHostelAttendanceParentFragmentBinding
    public void setHostelAttendanceParentViewModel(HostelAttendanceParentViewModel HostelAttendanceParentViewModel) {
        this.mHostelAttendanceParentViewModel = HostelAttendanceParentViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}