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
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import in.etuwa.app.R;
import in.etuwa.app.ui.transportmain.TransportMainViewModel;

/* JADX INFO: loaded from: classes3.dex */
public class FragmentTransportMainBindingImpl extends FragmentTransportMainBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;
    private final FrameLayout mboundView1;
    private final ViewProgressBarBinding mboundView11;
    private final ViewProgressBarBinding mboundView2;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.toolbar, 5);
        sparseIntArray.put(R.id.search_card, 6);
        sparseIntArray.put(R.id.search_input, 7);
        sparseIntArray.put(R.id.main_lyt, 8);
        sparseIntArray.put(R.id.hr_view, 9);
        sparseIntArray.put(R.id.fees_btn, 10);
        sparseIntArray.put(R.id.receipt_btn, 11);
        sparseIntArray.put(R.id.registration_btn, 12);
        sparseIntArray.put(R.id.history_btn, 13);
        sparseIntArray.put(R.id.bus_pass_btn, 14);
        sparseIntArray.put(R.id.gateway_btn, 15);
        sparseIntArray.put(R.id.spinner_year_transport, 16);
        sparseIntArray.put(R.id.boarding_point_tv, 17);
        sparseIntArray.put(R.id.swipe_layout, 18);
        sparseIntArray.put(R.id.rv_transport, 19);
        sparseIntArray.put(R.id.no_data_lyt, 20);
        sparseIntArray.put(R.id.no_data_tv, 21);
        sparseIntArray.put(R.id.pay_btn_lyt, 22);
        sparseIntArray.put(R.id.tv_transport_total, 23);
        sparseIntArray.put(R.id.pay_transport_btn, 24);
        sparseIntArray.put(R.id.rv_fee_receipt, 25);
    }

    public FragmentTransportMainBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 26, sIncludes, sViewsWithIds));
    }

    private FragmentTransportMainBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (TextView) bindings[17], (TextView) bindings[14], (FrameLayout) bindings[2], (TextView) bindings[10], (TextView) bindings[15], (TextView) bindings[13], (HorizontalScrollView) bindings[9], (LinearLayout) bindings[8], (LinearLayout) bindings[20], (TextView) bindings[21], (MaterialCardView) bindings[22], (MaterialButton) bindings[24], (TextView) bindings[11], (TextView) bindings[12], (RecyclerView) bindings[25], (RecyclerView) bindings[19], (CardView) bindings[6], (EditText) bindings[7], (Spinner) bindings[16], (SwipeRefreshLayout) bindings[18], (TextView) bindings[5], (TextView) bindings[23]);
        this.mDirtyFlags = -1L;
        this.feeReceiptLyt.setTag(null);
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        FrameLayout frameLayout = (FrameLayout) bindings[1];
        this.mboundView1 = frameLayout;
        frameLayout.setTag(null);
        Object obj = bindings[3];
        this.mboundView11 = obj != null ? ViewProgressBarBinding.bind((View) obj) : null;
        Object obj2 = bindings[4];
        this.mboundView2 = obj2 != null ? ViewProgressBarBinding.bind((View) obj2) : null;
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
        if (228 != variableId) {
            return false;
        }
        setTransportMainViewModel((TransportMainViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.FragmentTransportMainBinding
    public void setTransportMainViewModel(TransportMainViewModel TransportMainViewModel) {
        this.mTransportMainViewModel = TransportMainViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}