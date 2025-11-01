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
import in.etuwa.app.ui.examregistration.examsubjects.ExamSubjectViewModel;

/* loaded from: classes3.dex */
public class FragmentExamSubjectBindingImpl extends FragmentExamSubjectBinding {
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
        sparseIntArray.put(R.id.reg_lyt, 1);
        sparseIntArray.put(R.id.not_registered_btn, 2);
        sparseIntArray.put(R.id.registered_btn, 3);
        sparseIntArray.put(R.id.swipe_layout, 4);
        sparseIntArray.put(R.id.rv_exam_subject, 5);
    }

    public FragmentExamSubjectBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds));
    }

    private FragmentExamSubjectBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (TextView) bindings[2], (LinearLayout) bindings[1], (TextView) bindings[3], (RecyclerView) bindings[5], (SwipeRefreshLayout) bindings[4]);
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
        if (83 != variableId) {
            return false;
        }
        setExamSubjectViewModel((ExamSubjectViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.FragmentExamSubjectBinding
    public void setExamSubjectViewModel(ExamSubjectViewModel ExamSubjectViewModel) {
        this.mExamSubjectViewModel = ExamSubjectViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}