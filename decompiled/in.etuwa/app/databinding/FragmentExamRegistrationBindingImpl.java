package in.etuwa.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import in.etuwa.app.R;
import in.etuwa.app.ui.examregistration.examsubjects.register.ExamRegisterViewModel;

/* loaded from: classes3.dex */
public class FragmentExamRegistrationBindingImpl extends FragmentExamRegistrationBinding {
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
        sparseIntArray.put(R.id.select_tv, 1);
        sparseIntArray.put(R.id.select_all_checkBox, 2);
        sparseIntArray.put(R.id.swipe_layout, 3);
        sparseIntArray.put(R.id.rv_exam_subject, 4);
        sparseIntArray.put(R.id.pay_lyt, 5);
        sparseIntArray.put(R.id.tv_hostel_total, 6);
        sparseIntArray.put(R.id.pay_now_btn, 7);
        sparseIntArray.put(R.id.register_lyt, 8);
        sparseIntArray.put(R.id.register_btn, 9);
        sparseIntArray.put(R.id.pay_later_lyt, 10);
        sparseIntArray.put(R.id.pay_later_btn, 11);
    }

    public FragmentExamRegistrationBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 12, sIncludes, sViewsWithIds));
    }

    private FragmentExamRegistrationBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (TextView) bindings[11], (LinearLayout) bindings[10], (LinearLayout) bindings[5], (TextView) bindings[7], (TextView) bindings[9], (LinearLayout) bindings[8], (RecyclerView) bindings[4], (CheckBox) bindings[2], (TextView) bindings[1], (SwipeRefreshLayout) bindings[3], (TextView) bindings[6]);
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
        if (80 != variableId) {
            return false;
        }
        setExamRegisterViewModel((ExamRegisterViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.FragmentExamRegistrationBinding
    public void setExamRegisterViewModel(ExamRegisterViewModel ExamRegisterViewModel) {
        this.mExamRegisterViewModel = ExamRegisterViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}