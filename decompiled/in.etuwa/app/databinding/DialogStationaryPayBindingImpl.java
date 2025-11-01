package in.etuwa.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import in.etuwa.app.R;
import in.etuwa.app.ui.stationary.booking.orderpage.OrderPageViewModel;

/* loaded from: classes3.dex */
public class DialogStationaryPayBindingImpl extends DialogStationaryPayBinding {
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
        sparseIntArray.put(R.id.tv_product_name, 1);
        sparseIntArray.put(R.id.tv_unit_price, 2);
        sparseIntArray.put(R.id.remove_btn, 3);
        sparseIntArray.put(R.id.et_quantity, 4);
        sparseIntArray.put(R.id.add_btn, 5);
        sparseIntArray.put(R.id.tv_total_price, 6);
        sparseIntArray.put(R.id.pay_btn, 7);
    }

    public DialogStationaryPayBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 8, sIncludes, sViewsWithIds));
    }

    private DialogStationaryPayBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (ImageView) bindings[5], (EditText) bindings[4], (TextView) bindings[7], (ImageView) bindings[3], (TextView) bindings[1], (TextView) bindings[6], (TextView) bindings[2]);
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
        if (151 != variableId) {
            return false;
        }
        setOrderPageViewModel((OrderPageViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.DialogStationaryPayBinding
    public void setOrderPageViewModel(OrderPageViewModel OrderPageViewModel) {
        this.mOrderPageViewModel = OrderPageViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}