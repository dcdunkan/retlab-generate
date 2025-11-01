package in.etuwa.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import in.etuwa.app.R;
import in.etuwa.app.ui.transport.buspass.BusPassViewModel;

/* loaded from: classes3.dex */
public class FragmentTransportBuspassBindingImpl extends FragmentTransportBuspassBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final FrameLayout mboundView0;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.tv_error, 1);
        sparseIntArray.put(R.id.buss_pass_view, 2);
        sparseIntArray.put(R.id.bp_image, 3);
        sparseIntArray.put(R.id.bp_qr, 4);
        sparseIntArray.put(R.id.full_screen_qr_btn, 5);
        sparseIntArray.put(R.id.bp_name, 6);
        sparseIntArray.put(R.id.bp_batch, 7);
        sparseIntArray.put(R.id.bp_admssn_no, 8);
        sparseIntArray.put(R.id.bp_academic_program, 9);
        sparseIntArray.put(R.id.bp_duration, 10);
        sparseIntArray.put(R.id.bp_sem, 11);
        sparseIntArray.put(R.id.bp_gender, 12);
        sparseIntArray.put(R.id.bp_route, 13);
        sparseIntArray.put(R.id.bp_boarding_point, 14);
        sparseIntArray.put(R.id.bp_pass_category, 15);
        sparseIntArray.put(R.id.bp_validity, 16);
        sparseIntArray.put(R.id.bp_pass_code, 17);
    }

    public FragmentTransportBuspassBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 18, sIncludes, sViewsWithIds));
    }

    private FragmentTransportBuspassBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (TextView) bindings[9], (TextView) bindings[8], (TextView) bindings[7], (TextView) bindings[14], (TextView) bindings[10], (TextView) bindings[12], (ImageView) bindings[3], (TextView) bindings[6], (TextView) bindings[15], (TextView) bindings[17], (ImageView) bindings[4], (TextView) bindings[13], (TextView) bindings[11], (TextView) bindings[16], (ScrollView) bindings[2], (TextView) bindings[5], (TextView) bindings[1]);
        this.mDirtyFlags = -1L;
        FrameLayout frameLayout = (FrameLayout) bindings[0];
        this.mboundView0 = frameLayout;
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
        if (43 != variableId) {
            return false;
        }
        setBusPassViewModel((BusPassViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.FragmentTransportBuspassBinding
    public void setBusPassViewModel(BusPassViewModel BusPassViewModel) {
        this.mBusPassViewModel = BusPassViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}