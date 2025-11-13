package in.etuwa.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import in.etuwa.app.R;
import in.etuwa.app.ui.fees.transport.TransportFeeViewModel;

/* loaded from: classes3.dex */
public class FragmentTransportBindingImpl extends FragmentTransportBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ViewProgressBarBinding mboundView0;
    private final FrameLayout mboundView01;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.spinner_year_transport, 2);
        sparseIntArray.put(R.id.boarding_point_tv, 3);
        sparseIntArray.put(R.id.swipe_layout, 4);
        sparseIntArray.put(R.id.rv_transport, 5);
        sparseIntArray.put(R.id.no_data_lyt, 6);
        sparseIntArray.put(R.id.no_data_tv, 7);
        sparseIntArray.put(R.id.pay_btn_lyt, 8);
        sparseIntArray.put(R.id.tv_transport_total, 9);
        sparseIntArray.put(R.id.pay_transport_btn, 10);
    }

    public FragmentTransportBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 11, sIncludes, sViewsWithIds));
    }

    private FragmentTransportBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (TextView) bindings[3], (LinearLayout) bindings[6], (TextView) bindings[7], (LinearLayout) bindings[8], (TextView) bindings[10], (RecyclerView) bindings[5], (Spinner) bindings[2], (SwipeRefreshLayout) bindings[4], (TextView) bindings[9]);
        this.mDirtyFlags = -1L;
        Object obj = bindings[1];
        this.mboundView0 = obj != null ? ViewProgressBarBinding.bind((View) obj) : null;
        FrameLayout frameLayout = (FrameLayout) bindings[0];
        this.mboundView01 = frameLayout;
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
        if (225 != variableId) {
            return false;
        }
        setTransportFeeViewModel((TransportFeeViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.FragmentTransportBinding
    public void setTransportFeeViewModel(TransportFeeViewModel TransportFeeViewModel) {
        this.mTransportFeeViewModel = TransportFeeViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}