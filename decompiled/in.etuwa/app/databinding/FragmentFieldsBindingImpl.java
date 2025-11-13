package in.etuwa.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import in.etuwa.app.R;
import in.etuwa.app.ui.fees.webview.fields.FieldsViewModel;

/* loaded from: classes3.dex */
public class FragmentFieldsBindingImpl extends FragmentFieldsBinding {
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
        sparseIntArray.put(R.id.name_tv, 1);
        sparseIntArray.put(R.id.name_et, 2);
        sparseIntArray.put(R.id.mobile_number_tv, 3);
        sparseIntArray.put(R.id.et_mobile_number, 4);
        sparseIntArray.put(R.id.number_tv, 5);
        sparseIntArray.put(R.id.et_aadhaar_number, 6);
        sparseIntArray.put(R.id.port_tv, 7);
        sparseIntArray.put(R.id.spinnerPort, 8);
        sparseIntArray.put(R.id.retype_acc_lyt, 9);
        sparseIntArray.put(R.id.zone_tv, 10);
        sparseIntArray.put(R.id.spinnerZone, 11);
        sparseIntArray.put(R.id.type_tv, 12);
        sparseIntArray.put(R.id.spinnerVehicle, 13);
        sparseIntArray.put(R.id.ton_tv, 14);
        sparseIntArray.put(R.id.spinnerTon, 15);
        sparseIntArray.put(R.id.place_tv, 16);
        sparseIntArray.put(R.id.place_et, 17);
        sparseIntArray.put(R.id.distance_tv, 18);
        sparseIntArray.put(R.id.distance_et, 19);
        sparseIntArray.put(R.id.update_lyt, 20);
        sparseIntArray.put(R.id.submit_btn, 21);
    }

    public FragmentFieldsBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 22, sIncludes, sViewsWithIds));
    }

    private FragmentFieldsBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (EditText) bindings[19], (TextView) bindings[18], (EditText) bindings[6], (EditText) bindings[4], (TextView) bindings[3], (EditText) bindings[2], (TextView) bindings[1], (TextView) bindings[5], (EditText) bindings[17], (TextView) bindings[16], (TextView) bindings[7], (LinearLayout) bindings[9], (Spinner) bindings[8], (Spinner) bindings[15], (Spinner) bindings[13], (Spinner) bindings[11], (TextView) bindings[21], (TextView) bindings[14], (TextView) bindings[12], (LinearLayout) bindings[20], (TextView) bindings[10]);
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
        if (96 != variableId) {
            return false;
        }
        setFieldsViewModel((FieldsViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.FragmentFieldsBinding
    public void setFieldsViewModel(FieldsViewModel FieldsViewModel) {
        this.mFieldsViewModel = FieldsViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}