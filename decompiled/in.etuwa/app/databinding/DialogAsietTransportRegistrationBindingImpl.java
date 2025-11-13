package in.etuwa.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import in.etuwa.app.R;
import in.etuwa.app.ui.transport.registration.asiet.registration.AsietTransRegViewModel;

/* loaded from: classes3.dex */
public class DialogAsietTransportRegistrationBindingImpl extends DialogAsietTransportRegistrationBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final FrameLayout mboundView0;
    private final CardView mboundView1;
    private final ViewProgressBarBinding mboundView11;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.apply_company_layout, 3);
        sparseIntArray.put(R.id.spinner_boarding, 4);
        sparseIntArray.put(R.id.mt_amount, 5);
        sparseIntArray.put(R.id.et_amount, 6);
        sparseIntArray.put(R.id.mt_exact_boarding_point, 7);
        sparseIntArray.put(R.id.et_exact_boarding_point, 8);
        sparseIntArray.put(R.id.bus_details_btn, 9);
        sparseIntArray.put(R.id.et_date2, 10);
        sparseIntArray.put(R.id.et_date, 11);
        sparseIntArray.put(R.id.check_box, 12);
        sparseIntArray.put(R.id.register_btn, 13);
    }

    public DialogAsietTransportRegistrationBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 14, sIncludes, sViewsWithIds));
    }

    private DialogAsietTransportRegistrationBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (LinearLayout) bindings[3], (TextView) bindings[9], (CheckBox) bindings[12], (TextInputEditText) bindings[6], (EditText) bindings[11], (TextView) bindings[10], (TextInputEditText) bindings[8], (TextInputLayout) bindings[5], (TextInputLayout) bindings[7], (TextView) bindings[13], (Spinner) bindings[4]);
        this.mDirtyFlags = -1L;
        FrameLayout frameLayout = (FrameLayout) bindings[0];
        this.mboundView0 = frameLayout;
        frameLayout.setTag(null);
        CardView cardView = (CardView) bindings[1];
        this.mboundView1 = cardView;
        cardView.setTag(null);
        Object obj = bindings[2];
        this.mboundView11 = obj != null ? ViewProgressBarBinding.bind((View) obj) : null;
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
        if (30 != variableId) {
            return false;
        }
        setAsietTransRegViewModel((AsietTransRegViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.DialogAsietTransportRegistrationBinding
    public void setAsietTransRegViewModel(AsietTransRegViewModel AsietTransRegViewModel) {
        this.mAsietTransRegViewModel = AsietTransRegViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}