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
import androidx.recyclerview.widget.RecyclerView;
import in.etuwa.app.R;
import in.etuwa.app.ui.feepartial.hostel.HostelPartialViewModel;

/* loaded from: classes3.dex */
public class FragmentHostelPartialBindingImpl extends FragmentHostelPartialBinding {
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
        sparseIntArray.put(R.id.hostel_tv, 3);
        sparseIntArray.put(R.id.room_no, 4);
        sparseIntArray.put(R.id.join_date, 5);
        sparseIntArray.put(R.id.month_layout, 6);
        sparseIntArray.put(R.id.spinner_hostel_fee, 7);
        sparseIntArray.put(R.id.swipe_layout, 8);
        sparseIntArray.put(R.id.rv_hostel_fee, 9);
        sparseIntArray.put(R.id.swipe_layout2, 10);
        sparseIntArray.put(R.id.rv_hostel_fee_admission, 11);
        sparseIntArray.put(R.id.tv_hostel_total, 12);
        sparseIntArray.put(R.id.pay_now_btn, 13);
    }

    public FragmentHostelPartialBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 14, sIncludes, sViewsWithIds));
    }

    private FragmentHostelPartialBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (TextView) bindings[3], (TextView) bindings[5], (LinearLayout) bindings[6], (TextView) bindings[13], (TextView) bindings[4], (RecyclerView) bindings[9], (RecyclerView) bindings[11], (Spinner) bindings[7], (LinearLayout) bindings[8], (LinearLayout) bindings[10], (TextView) bindings[12]);
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
        if (116 != variableId) {
            return false;
        }
        setHostelPartialViewModel((HostelPartialViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.FragmentHostelPartialBinding
    public void setHostelPartialViewModel(HostelPartialViewModel HostelPartialViewModel) {
        this.mHostelPartialViewModel = HostelPartialViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}