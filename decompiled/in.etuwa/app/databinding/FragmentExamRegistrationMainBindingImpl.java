package in.etuwa.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import in.etuwa.app.R;
import in.etuwa.app.ui.examregistration.ExamRegistrationViewModel;

/* loaded from: classes3.dex */
public class FragmentExamRegistrationMainBindingImpl extends FragmentExamRegistrationMainBinding {
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
        sparseIntArray.put(R.id.reg_btn, 1);
        sparseIntArray.put(R.id.exam_result, 2);
        sparseIntArray.put(R.id.revaluation_fee, 3);
        sparseIntArray.put(R.id.fee_receipt, 4);
        sparseIntArray.put(R.id.reg_lyt, 5);
        sparseIntArray.put(R.id.exam_result_lyt, 6);
        sparseIntArray.put(R.id.revaluation_fee_lyt, 7);
        sparseIntArray.put(R.id.fee_receipt_lyt, 8);
    }

    public FragmentExamRegistrationMainBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 9, sIncludes, sViewsWithIds));
    }

    private FragmentExamRegistrationMainBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (TextView) bindings[2], (LinearLayout) bindings[6], (TextView) bindings[4], (LinearLayout) bindings[8], (TextView) bindings[1], (LinearLayout) bindings[5], (TextView) bindings[3], (LinearLayout) bindings[7]);
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
        if (82 != variableId) {
            return false;
        }
        setExamRegistrationViewModel((ExamRegistrationViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.FragmentExamRegistrationMainBinding
    public void setExamRegistrationViewModel(ExamRegistrationViewModel ExamRegistrationViewModel) {
        this.mExamRegistrationViewModel = ExamRegistrationViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}