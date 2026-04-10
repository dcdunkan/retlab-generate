package in.etuwa.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.checkbox.MaterialCheckBox;
import in.etuwa.app.R;
import in.etuwa.app.ui.hostel.attendance.parent.approveview.ParentApproveViewModel;

/* JADX INFO: loaded from: classes3.dex */
public class DialogParentApproveBindingImpl extends DialogParentApproveBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.handle_bar, 1);
        sparseIntArray.put(R.id.tv_title, 2);
        sparseIntArray.put(R.id.card_leave_details, 3);
        sparseIntArray.put(R.id.tv_leave_type, 4);
        sparseIntArray.put(R.id.tv_reason, 5);
        sparseIntArray.put(R.id.select_all_card, 6);
        sparseIntArray.put(R.id.checkbox_select_all, 7);
        sparseIntArray.put(R.id.rv_dates, 8);
        sparseIntArray.put(R.id.action_buttons, 9);
        sparseIntArray.put(R.id.btn_reject, 10);
        sparseIntArray.put(R.id.btn_approve, 11);
    }

    public DialogParentApproveBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 12, sIncludes, sViewsWithIds));
    }

    private DialogParentApproveBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (LinearLayout) bindings[9], (MaterialButton) bindings[11], (MaterialButton) bindings[10], (CardView) bindings[3], (MaterialCheckBox) bindings[7], (View) bindings[1], (RecyclerView) bindings[8], (MaterialCardView) bindings[6], (TextView) bindings[4], (TextView) bindings[5], (TextView) bindings[2]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
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
        if (158 != variableId) {
            return false;
        }
        setParentApproveViewModel((ParentApproveViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.DialogParentApproveBinding
    public void setParentApproveViewModel(ParentApproveViewModel ParentApproveViewModel) {
        this.mParentApproveViewModel = ParentApproveViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}