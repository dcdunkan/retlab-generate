package in.etuwa.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import in.etuwa.app.R;
import in.etuwa.app.ui.grievance.view.ViewGrievanceViewModel;

/* loaded from: classes3.dex */
public class ViewGrievanceFragmentBindingImpl extends ViewGrievanceFragmentBinding {
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
        sparseIntArray.put(R.id.gr_number, 3);
        sparseIntArray.put(R.id.gr_type, 4);
        sparseIntArray.put(R.id.gr_title, 5);
        sparseIntArray.put(R.id.gr_grievant, 6);
        sparseIntArray.put(R.id.gr_post_date, 7);
        sparseIntArray.put(R.id.gr_details, 8);
        sparseIntArray.put(R.id.view_gr_doc_btn, 9);
        sparseIntArray.put(R.id.gr_status, 10);
        sparseIntArray.put(R.id.gr_action_taken, 11);
        sparseIntArray.put(R.id.action_level_btn, 12);
        sparseIntArray.put(R.id.cell_member_btn, 13);
        sparseIntArray.put(R.id.gr_reply, 14);
        sparseIntArray.put(R.id.gr_date_of_reply, 15);
        sparseIntArray.put(R.id.view_reply_doc_btn, 16);
        sparseIntArray.put(R.id.gr_reply_details, 17);
    }

    public ViewGrievanceFragmentBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 18, sIncludes, sViewsWithIds));
    }

    private ViewGrievanceFragmentBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (TextView) bindings[12], (TextView) bindings[13], (TextView) bindings[11], (TextView) bindings[15], (TextView) bindings[8], (TextView) bindings[6], (TextView) bindings[3], (TextView) bindings[7], (TextView) bindings[14], (TextView) bindings[17], (TextView) bindings[10], (TextView) bindings[5], (TextView) bindings[4], (SwipeRefreshLayout) bindings[2], (TextView) bindings[9], (TextView) bindings[16]);
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
        if (242 != variableId) {
            return false;
        }
        setViewGrievanceViewModel((ViewGrievanceViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.ViewGrievanceFragmentBinding
    public void setViewGrievanceViewModel(ViewGrievanceViewModel ViewGrievanceViewModel) {
        this.mViewGrievanceViewModel = ViewGrievanceViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}