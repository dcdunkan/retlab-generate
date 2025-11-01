package in.etuwa.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import in.etuwa.app.R;
import in.etuwa.app.ui.counselling.view.ViewCounsellingViewModel;

/* loaded from: classes3.dex */
public class ViewCounsellingFragmentBindingImpl extends ViewCounsellingFragmentBinding {
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
        sparseIntArray.put(R.id.cs_number, 3);
        sparseIntArray.put(R.id.cs_type, 4);
        sparseIntArray.put(R.id.cs_applicant, 5);
        sparseIntArray.put(R.id.cs_date, 6);
        sparseIntArray.put(R.id.cs_concern, 7);
        sparseIntArray.put(R.id.cs_impact_home, 8);
        sparseIntArray.put(R.id.cs_impact_studies, 9);
        sparseIntArray.put(R.id.cs_impact_relationship, 10);
        sparseIntArray.put(R.id.cs_physically_emotionally, 11);
        sparseIntArray.put(R.id.cs_counselling_history, 12);
        sparseIntArray.put(R.id.cs_counselling_session_required, 13);
        sparseIntArray.put(R.id.cs_action_taken, 14);
        sparseIntArray.put(R.id.action2_level_btncs, 15);
        sparseIntArray.put(R.id.cell_member_btncs, 16);
    }

    public ViewCounsellingFragmentBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 17, sIncludes, sViewsWithIds));
    }

    private ViewCounsellingFragmentBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (TextView) bindings[15], (TextView) bindings[16], (TextView) bindings[14], (TextView) bindings[5], (TextView) bindings[7], (TextView) bindings[12], (TextView) bindings[13], (TextView) bindings[6], (TextView) bindings[8], (TextView) bindings[10], (TextView) bindings[9], (TextView) bindings[3], (TextView) bindings[11], (TextView) bindings[4], (SwipeRefreshLayout) bindings[2]);
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
        if (241 != variableId) {
            return false;
        }
        setViewCounsellingViewModel((ViewCounsellingViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.ViewCounsellingFragmentBinding
    public void setViewCounsellingViewModel(ViewCounsellingViewModel ViewCounsellingViewModel) {
        this.mViewCounsellingViewModel = ViewCounsellingViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}