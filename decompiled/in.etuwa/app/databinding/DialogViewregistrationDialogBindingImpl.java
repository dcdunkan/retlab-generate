package in.etuwa.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import in.etuwa.app.R;
import in.etuwa.app.ui.hostel.gcekhostel.registration.viewregistration.ViewRegistrationViewModel;

/* loaded from: classes3.dex */
public class DialogViewregistrationDialogBindingImpl extends DialogViewregistrationDialogBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ScrollView mboundView0;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.reg_title, 1);
        sparseIntArray.put(R.id.name_re, 2);
        sparseIntArray.put(R.id.admsn_number_re, 3);
        sparseIntArray.put(R.id.hostel_applied_for_re, 4);
        sparseIntArray.put(R.id.status_re, 5);
        sparseIntArray.put(R.id.remarks_re, 6);
        sparseIntArray.put(R.id.type_re, 7);
        sparseIntArray.put(R.id.readmission_re, 8);
        sparseIntArray.put(R.id.address_re, 9);
        sparseIntArray.put(R.id.phone_re, 10);
        sparseIntArray.put(R.id.distance_re, 11);
        sparseIntArray.put(R.id.annual_income_re, 12);
        sparseIntArray.put(R.id.back_paper_re, 13);
        sparseIntArray.put(R.id.certificate_dwn_re, 14);
    }

    public DialogViewregistrationDialogBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 15, sIncludes, sViewsWithIds));
    }

    private DialogViewregistrationDialogBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (TextView) bindings[9], (TextView) bindings[3], (TextView) bindings[12], (TextView) bindings[13], (TextView) bindings[14], (TextView) bindings[11], (TextView) bindings[4], (TextView) bindings[2], (TextView) bindings[10], (TextView) bindings[8], (TextView) bindings[1], (TextView) bindings[6], (TextView) bindings[5], (TextView) bindings[7]);
        this.mDirtyFlags = -1L;
        ScrollView scrollView = (ScrollView) bindings[0];
        this.mboundView0 = scrollView;
        scrollView.setTag(null);
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
        if (246 != variableId) {
            return false;
        }
        setViewRegistrationViewModel((ViewRegistrationViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.DialogViewregistrationDialogBinding
    public void setViewRegistrationViewModel(ViewRegistrationViewModel ViewRegistrationViewModel) {
        this.mViewRegistrationViewModel = ViewRegistrationViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}