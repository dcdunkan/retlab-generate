package in.etuwa.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import in.etuwa.app.R;
import in.etuwa.app.ui.hostel.attendance.viewleave.qrdialog.SecurityQrViewModel;

/* loaded from: classes3.dex */
public class DialogSecurityQrBindingImpl extends DialogSecurityQrBinding {
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
        sparseIntArray.put(R.id.tv_error, 1);
        sparseIntArray.put(R.id.approved_image, 2);
        sparseIntArray.put(R.id.buss_pass_view, 3);
        sparseIntArray.put(R.id.download_btn, 4);
        sparseIntArray.put(R.id.bp_image, 5);
        sparseIntArray.put(R.id.bp_qr, 6);
        sparseIntArray.put(R.id.bp_name, 7);
        sparseIntArray.put(R.id.hostel_name_tv, 8);
        sparseIntArray.put(R.id.room_no_tv, 9);
        sparseIntArray.put(R.id.address_tv, 10);
        sparseIntArray.put(R.id.date_of_leave_tv, 11);
        sparseIntArray.put(R.id.reason_tv, 12);
        sparseIntArray.put(R.id.status_tv, 13);
        sparseIntArray.put(R.id.phone_tv, 14);
        sparseIntArray.put(R.id.date_tv, 15);
    }

    public DialogSecurityQrBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 16, sIncludes, sViewsWithIds));
    }

    private DialogSecurityQrBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (TextView) bindings[10], (ImageView) bindings[2], (ImageView) bindings[5], (TextView) bindings[7], (ImageView) bindings[6], (ScrollView) bindings[3], (TextView) bindings[11], (TextView) bindings[15], (TextView) bindings[4], (TextView) bindings[8], (TextView) bindings[14], (TextView) bindings[12], (TextView) bindings[9], (TextView) bindings[13], (TextView) bindings[1]);
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
        if (195 != variableId) {
            return false;
        }
        setSecurityQrViewModel((SecurityQrViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.DialogSecurityQrBinding
    public void setSecurityQrViewModel(SecurityQrViewModel SecurityQrViewModel) {
        this.mSecurityQrViewModel = SecurityQrViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}