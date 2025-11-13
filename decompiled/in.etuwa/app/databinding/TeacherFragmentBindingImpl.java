package in.etuwa.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import in.etuwa.app.R;
import in.etuwa.app.ui.teacher.TeacherViewModel;

/* loaded from: classes3.dex */
public class TeacherFragmentBindingImpl extends TeacherFragmentBinding {
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
        sparseIntArray.put(R.id.hod_image, 2);
        sparseIntArray.put(R.id.hod_name, 3);
        sparseIntArray.put(R.id.hod_subject, 4);
        sparseIntArray.put(R.id.hod_email, 5);
        sparseIntArray.put(R.id.hod_phone, 6);
        sparseIntArray.put(R.id.btn_subject_teacher, 7);
        sparseIntArray.put(R.id.btn_staff_advisor, 8);
        sparseIntArray.put(R.id.swipe_layout, 9);
        sparseIntArray.put(R.id.rv_teacher, 10);
    }

    public TeacherFragmentBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 11, sIncludes, sViewsWithIds));
    }

    private TeacherFragmentBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (TextView) bindings[8], (TextView) bindings[7], (TextView) bindings[5], (ImageView) bindings[2], (TextView) bindings[3], (TextView) bindings[6], (TextView) bindings[4], (RecyclerView) bindings[10], (SwipeRefreshLayout) bindings[9]);
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
        if (221 != variableId) {
            return false;
        }
        setTeacherViewModel((TeacherViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.TeacherFragmentBinding
    public void setTeacherViewModel(TeacherViewModel TeacherViewModel) {
        this.mTeacherViewModel = TeacherViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}