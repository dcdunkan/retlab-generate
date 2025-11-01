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
import in.etuwa.app.ui.examregistration.examsubjects.updateregister.UpdateRegisterViewModel;

/* loaded from: classes3.dex */
public class FragmentExamUpdateBindingImpl extends FragmentExamUpdateBinding {
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
        sparseIntArray.put(R.id.rv_exam_subject, 2);
        sparseIntArray.put(R.id.pay_lyt, 3);
        sparseIntArray.put(R.id.tv_hostel_total, 4);
        sparseIntArray.put(R.id.pay_now_btn, 5);
        sparseIntArray.put(R.id.register_lyt, 6);
        sparseIntArray.put(R.id.register_btn, 7);
        sparseIntArray.put(R.id.pay_later_lyt, 8);
        sparseIntArray.put(R.id.pay_later_btn, 9);
    }

    public FragmentExamUpdateBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 10, sIncludes, sViewsWithIds));
    }

    private FragmentExamUpdateBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
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
        if (237 != variableId) {
            return false;
        }
        setUpdateRegisterViewModel((UpdateRegisterViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.FragmentExamUpdateBinding
    public void setUpdateRegisterViewModel(UpdateRegisterViewModel UpdateRegisterViewModel) {
        this.mUpdateRegisterViewModel = UpdateRegisterViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}