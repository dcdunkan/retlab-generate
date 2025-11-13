package in.etuwa.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import in.etuwa.app.R;
import in.etuwa.app.ui.fees.gateway2.GatewayTwoViewModel;

/* loaded from: classes3.dex */
public class DialogGatewayTwoBindingImpl extends DialogGatewayTwoBinding {
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
        sparseIntArray.put(R.id.edit_btn, 1);
        sparseIntArray.put(R.id.bank_name_tv, 2);
        sparseIntArray.put(R.id.start, 3);
        sparseIntArray.put(R.id.name_et, 4);
        sparseIntArray.put(R.id.branch_name_tv, 5);
        sparseIntArray.put(R.id.end, 6);
        sparseIntArray.put(R.id.branch_et, 7);
        sparseIntArray.put(R.id.acc_no_tv, 8);
        sparseIntArray.put(R.id.no_of_entries, 9);
        sparseIntArray.put(R.id.acc_no_et, 10);
        sparseIntArray.put(R.id.retype_acc_lyt, 11);
        sparseIntArray.put(R.id.retype_acc_no_tv, 12);
        sparseIntArray.put(R.id.retype_acc_no_et, 13);
        sparseIntArray.put(R.id.ifsc_tv, 14);
        sparseIntArray.put(R.id.generate_btn, 15);
        sparseIntArray.put(R.id.update_lyt, 16);
        sparseIntArray.put(R.id.update_btn, 17);
    }

    public DialogGatewayTwoBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 18, sIncludes, sViewsWithIds));
    }

    private DialogGatewayTwoBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (EditText) bindings[10], (TextView) bindings[8], (TextView) bindings[2], (EditText) bindings[7], (TextView) bindings[5], (TextView) bindings[1], (EditText) bindings[6], (TextView) bindings[15], (TextView) bindings[14], (EditText) bindings[4], (EditText) bindings[9], (LinearLayout) bindings[11], (EditText) bindings[13], (TextView) bindings[12], (EditText) bindings[3], (TextView) bindings[17], (LinearLayout) bindings[16]);
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
        if (98 != variableId) {
            return false;
        }
        setGatewayTwoViewModel((GatewayTwoViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.DialogGatewayTwoBinding
    public void setGatewayTwoViewModel(GatewayTwoViewModel GatewayTwoViewModel) {
        this.mGatewayTwoViewModel = GatewayTwoViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}