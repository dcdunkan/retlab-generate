package in.etuwa.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import in.etuwa.app.R;
import in.etuwa.app.ui.activitypoint.ActivityPointViewModel;

/* loaded from: classes3.dex */
public class ActivityPointFragmentBindingImpl extends ActivityPointFragmentBinding {
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
        sparseIntArray.put(R.id.total_point, 3);
        sparseIntArray.put(R.id.rv_activity_point, 4);
        sparseIntArray.put(R.id.manage_btn, 5);
    }

    public ActivityPointFragmentBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds));
    }

    private ActivityPointFragmentBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (Button) bindings[5], (RecyclerView) bindings[4], (SwipeRefreshLayout) bindings[2], (TextView) bindings[3]);
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
        if (6 != variableId) {
            return false;
        }
        setActivityPointViewModel((ActivityPointViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.ActivityPointFragmentBinding
    public void setActivityPointViewModel(ActivityPointViewModel ActivityPointViewModel) {
        this.mActivityPointViewModel = ActivityPointViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}