package in.etuwa.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import in.etuwa.app.R;
import in.etuwa.app.ui.examregistration.revaluation.view.update.RevaluationUpdateViewModel;

/* loaded from: classes3.dex */
public class FragmentRevaluationUpdateBindingImpl extends FragmentRevaluationUpdateBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final FrameLayout mboundView0;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.swipe_layout, 1);
        sparseIntArray.put(R.id.rv_exam_revaluation, 2);
        sparseIntArray.put(R.id.pay_lyt, 3);
        sparseIntArray.put(R.id.tv_hostel_total, 4);
        sparseIntArray.put(R.id.pay_now_btn, 5);
        sparseIntArray.put(R.id.register_lyt, 6);
        sparseIntArray.put(R.id.register_btn, 7);
        sparseIntArray.put(R.id.pay_later_lyt, 8);
        sparseIntArray.put(R.id.pay_later_btn, 9);
    }

    public FragmentRevaluationUpdateBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 10, sIncludes, sViewsWithIds));
    }

    private FragmentRevaluationUpdateBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (TextView) bindings[9], (LinearLayout) bindings[8], (LinearLayout) bindings[3], (TextView) bindings[5], (TextView) bindings[7], (LinearLayout) bindings[6], (RecyclerView) bindings[2], (SwipeRefreshLayout) bindings[1], (TextView) bindings[4]);
        this.mDirtyFlags = -1L;
        FrameLayout frameLayout = (FrameLayout) bindings[0];
        this.mboundView0 = frameLayout;
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
        if (189 != variableId) {
            return false;
        }
        setRevaluationUpdateViewModel((RevaluationUpdateViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.FragmentRevaluationUpdateBinding
    public void setRevaluationUpdateViewModel(RevaluationUpdateViewModel RevaluationUpdateViewModel) {
        this.mRevaluationUpdateViewModel = RevaluationUpdateViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}