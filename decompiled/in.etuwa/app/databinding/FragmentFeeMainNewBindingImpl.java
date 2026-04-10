package in.etuwa.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import in.etuwa.app.R;
import in.etuwa.app.ui.fees.FeeMainNewViewModel;

/* JADX INFO: loaded from: classes3.dex */
public class FragmentFeeMainNewBindingImpl extends FragmentFeeMainNewBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;
    private final ViewProgressBarBinding mboundView1;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.toolbar, 3);
        sparseIntArray.put(R.id.search_card, 4);
        sparseIntArray.put(R.id.search_input, 5);
        sparseIntArray.put(R.id.main_lyt, 6);
        sparseIntArray.put(R.id.hr_view, 7);
        sparseIntArray.put(R.id.fees_btn, 8);
        sparseIntArray.put(R.id.receipt_btn, 9);
        sparseIntArray.put(R.id.fee_engineer_lyt, 10);
        sparseIntArray.put(R.id.swipe_layout, 11);
        sparseIntArray.put(R.id.rv_fee_engnr, 12);
        sparseIntArray.put(R.id.pay_btn_lyt, 13);
        sparseIntArray.put(R.id.tv_fee_engnr_total, 14);
        sparseIntArray.put(R.id.pay_fee_engnr_btn, 15);
        sparseIntArray.put(R.id.fee_arts_lyt, 16);
        sparseIntArray.put(R.id.series_layout, 17);
        sparseIntArray.put(R.id.spinner_sem, 18);
        sparseIntArray.put(R.id.rv_fee_arts, 19);
        sparseIntArray.put(R.id.fine_layout, 20);
        sparseIntArray.put(R.id.tv_subtotal, 21);
        sparseIntArray.put(R.id.tv_fine, 22);
        sparseIntArray.put(R.id.tv_fee_arts_total, 23);
        sparseIntArray.put(R.id.pay_fee_arts_btn, 24);
        sparseIntArray.put(R.id.rv_fee_receipt, 25);
    }

    public FragmentFeeMainNewBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 26, sIncludes, sViewsWithIds));
    }

    private FragmentFeeMainNewBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (FrameLayout) bindings[16], (FrameLayout) bindings[10], (FrameLayout) bindings[1], (TextView) bindings[8], (MaterialCardView) bindings[20], (HorizontalScrollView) bindings[7], (LinearLayout) bindings[6], (MaterialCardView) bindings[13], (MaterialButton) bindings[24], (MaterialButton) bindings[15], (TextView) bindings[9], (RecyclerView) bindings[19], (RecyclerView) bindings[12], (RecyclerView) bindings[25], (CardView) bindings[4], (EditText) bindings[5], (MaterialCardView) bindings[17], (Spinner) bindings[18], (LinearLayout) bindings[11], (TextView) bindings[3], (TextView) bindings[23], (TextView) bindings[14], (TextView) bindings[22], (TextView) bindings[21]);
        this.mDirtyFlags = -1L;
        this.feeReceiptLyt.setTag(null);
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        Object obj = bindings[2];
        this.mboundView1 = obj != null ? ViewProgressBarBinding.bind((View) obj) : null;
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
        if (93 != variableId) {
            return false;
        }
        setFeeMainNewViewModel((FeeMainNewViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.FragmentFeeMainNewBinding
    public void setFeeMainNewViewModel(FeeMainNewViewModel FeeMainNewViewModel) {
        this.mFeeMainNewViewModel = FeeMainNewViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}