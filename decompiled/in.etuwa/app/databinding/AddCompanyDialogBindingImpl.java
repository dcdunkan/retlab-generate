package in.etuwa.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import in.etuwa.app.R;
import in.etuwa.app.ui.internship.apply.addcompany.AddCompanyViewModel;

/* loaded from: classes3.dex */
public class AddCompanyDialogBindingImpl extends AddCompanyDialogBinding {
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
        sparseIntArray.put(R.id.add_company_layout, 3);
        sparseIntArray.put(R.id.et_company_name, 4);
        sparseIntArray.put(R.id.comnt_layout, 5);
        sparseIntArray.put(R.id.et_company_address, 6);
        sparseIntArray.put(R.id.verified_layout, 7);
        sparseIntArray.put(R.id.cancel_btn, 8);
        sparseIntArray.put(R.id.add_btn, 9);
    }

    public AddCompanyDialogBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 10, sIncludes, sViewsWithIds));
    }

    private AddCompanyDialogBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (TextView) bindings[9], (LinearLayout) bindings[3], (TextView) bindings[8], (TextInputLayout) bindings[5], (TextInputEditText) bindings[6], (TextInputEditText) bindings[4], (LinearLayout) bindings[7]);
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
        if (9 != variableId) {
            return false;
        }
        setAddCompanyDialogViewModel((AddCompanyViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.AddCompanyDialogBinding
    public void setAddCompanyDialogViewModel(AddCompanyViewModel AddCompanyDialogViewModel) {
        this.mAddCompanyDialogViewModel = AddCompanyDialogViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}