package in.etuwa.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import in.etuwa.app.R;
import in.etuwa.app.ui.hostel.tkmhostel.HostelMainViewModel;

/* loaded from: classes3.dex */
public class HostelFragmentTkmBindingImpl extends HostelFragmentTkmBinding {
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
        sparseIntArray.put(R.id.hostel_new_registration, 1);
        sparseIntArray.put(R.id.view_reg_hostel, 2);
        sparseIntArray.put(R.id.reg_tkm_btn, 3);
        sparseIntArray.put(R.id.pay_tkm_btn, 4);
        sparseIntArray.put(R.id.receipt_tkm_btn, 5);
        sparseIntArray.put(R.id.mess_gcek_btn, 6);
        sparseIntArray.put(R.id.attendance_hostel_btn, 7);
    }

    public HostelFragmentTkmBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 8, sIncludes, sViewsWithIds));
    }

    private HostelFragmentTkmBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (LinearLayout) bindings[7], (LinearLayout) bindings[1], (LinearLayout) bindings[6], (LinearLayout) bindings[4], (LinearLayout) bindings[5], (TextView) bindings[3], (View) bindings[2]);
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
        if (111 != variableId) {
            return false;
        }
        setHostelMainViewModel((HostelMainViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.HostelFragmentTkmBinding
    public void setHostelMainViewModel(HostelMainViewModel HostelMainViewModel) {
        this.mHostelMainViewModel = HostelMainViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}