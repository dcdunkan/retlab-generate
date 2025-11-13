package in.etuwa.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
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
import in.etuwa.app.ui.internship.apply.ApplyInternshipViewModel;

/* loaded from: classes3.dex */
public class ApplyInternshipBindingImpl extends ApplyInternshipBinding {
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
        sparseIntArray.put(R.id.spinner_company_names, 4);
        sparseIntArray.put(R.id.add_company_btn, 5);
        sparseIntArray.put(R.id.other_company_layout, 6);
        sparseIntArray.put(R.id.et_company, 7);
        sparseIntArray.put(R.id.close_company_btn, 8);
        sparseIntArray.put(R.id.internshipFromDate, 9);
        sparseIntArray.put(R.id.internshipToDate, 10);
        sparseIntArray.put(R.id.apply_internship_btn, 11);
        sparseIntArray.put(R.id.add_company_layout, 12);
        sparseIntArray.put(R.id.et_company_name, 13);
        sparseIntArray.put(R.id.comnt_layout, 14);
        sparseIntArray.put(R.id.et_company_address, 15);
        sparseIntArray.put(R.id.verified_layout, 16);
        sparseIntArray.put(R.id.cancel_btn, 17);
        sparseIntArray.put(R.id.add_btn, 18);
    }

    public ApplyInternshipBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 19, sIncludes, sViewsWithIds));
    }

    private ApplyInternshipBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (TextView) bindings[18], (TextView) bindings[5], (LinearLayout) bindings[12], (LinearLayout) bindings[3], (TextView) bindings[11], (TextView) bindings[17], (TextView) bindings[8], (TextInputLayout) bindings[14], (TextInputEditText) bindings[7], (TextInputEditText) bindings[15], (TextInputEditText) bindings[13], (TextView) bindings[9], (TextView) bindings[10], (LinearLayout) bindings[6], (Spinner) bindings[4], (LinearLayout) bindings[16]);
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
        if (26 != variableId) {
            return false;
        }
        setApplyInternshipViewModel((ApplyInternshipViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.ApplyInternshipBinding
    public void setApplyInternshipViewModel(ApplyInternshipViewModel ApplyInternshipViewModel) {
        this.mApplyInternshipViewModel = ApplyInternshipViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}