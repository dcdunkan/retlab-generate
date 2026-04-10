package in.etuwa.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.material.card.MaterialCardView;
import in.etuwa.app.R;
import in.etuwa.app.ui.lab.LabViewModel;

/* JADX INFO: loaded from: classes3.dex */
public class FragmentLabBindingImpl extends FragmentLabBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;
    private final ViewProgressBarBinding mboundView1;
    private final ViewProgressBarBinding mboundView2;
    private final ViewProgressBarBinding mboundView3;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.hr_view, 7);
        sparseIntArray.put(R.id.card_practical, 8);
        sparseIntArray.put(R.id.card_equipment, 9);
        sparseIntArray.put(R.id.card_due, 10);
        sparseIntArray.put(R.id.session_spinner_layout, 11);
        sparseIntArray.put(R.id.spinner_sem, 12);
        sparseIntArray.put(R.id.swipe_layout, 13);
        sparseIntArray.put(R.id.rv_practical, 14);
        sparseIntArray.put(R.id.swipe_layout2, 15);
        sparseIntArray.put(R.id.rv_lab_list, 16);
        sparseIntArray.put(R.id.rv_lab_due, 17);
    }

    public FragmentLabBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 18, sIncludes, sViewsWithIds));
    }

    private FragmentLabBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (TextView) bindings[10], (TextView) bindings[9], (TextView) bindings[8], (FrameLayout) bindings[2], (HorizontalScrollView) bindings[7], (FrameLayout) bindings[3], (FrameLayout) bindings[1], (RecyclerView) bindings[17], (RecyclerView) bindings[16], (RecyclerView) bindings[14], (MaterialCardView) bindings[11], (Spinner) bindings[12], (SwipeRefreshLayout) bindings[13], (SwipeRefreshLayout) bindings[15]);
        this.mDirtyFlags = -1L;
        this.equipmentLyt.setTag(null);
        this.labDueLyt.setTag(null);
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        Object obj = bindings[4];
        this.mboundView1 = obj != null ? ViewProgressBarBinding.bind((View) obj) : null;
        Object obj2 = bindings[5];
        this.mboundView2 = obj2 != null ? ViewProgressBarBinding.bind((View) obj2) : null;
        Object obj3 = bindings[6];
        this.mboundView3 = obj3 != null ? ViewProgressBarBinding.bind((View) obj3) : null;
        this.practicalLyt.setTag(null);
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
        if (127 != variableId) {
            return false;
        }
        setLabViewModel((LabViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.FragmentLabBinding
    public void setLabViewModel(LabViewModel LabViewModel) {
        this.mLabViewModel = LabViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}