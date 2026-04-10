package in.etuwa.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.tabs.TabLayout;
import in.etuwa.app.R;
import in.etuwa.app.ui.result.ResultViewModel;

/* JADX INFO: loaded from: classes3.dex */
public class ResultFragmentBindingImpl extends ResultFragmentBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final CoordinatorLayout mboundView0;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.appBarLayout, 1);
        sparseIntArray.put(R.id.tvResults, 2);
        sparseIntArray.put(R.id.resultView, 3);
        sparseIntArray.put(R.id.tvUniResults, 4);
        sparseIntArray.put(R.id.uniView, 5);
        sparseIntArray.put(R.id.card_live_tv, 6);
        sparseIntArray.put(R.id.ivFilter, 7);
        sparseIntArray.put(R.id.hrView, 8);
        sparseIntArray.put(R.id.chip_group_results, 9);
        sparseIntArray.put(R.id.chip_assignment, 10);
        sparseIntArray.put(R.id.chip_series, 11);
        sparseIntArray.put(R.id.chip_module, 12);
        sparseIntArray.put(R.id.chip_tutorial, 13);
        sparseIntArray.put(R.id.chip_internal, 14);
        sparseIntArray.put(R.id.chip_university, 15);
        sparseIntArray.put(R.id.result_pager, 16);
        sparseIntArray.put(R.id.uniResultView, 17);
        sparseIntArray.put(R.id.internal_sem_text, 18);
        sparseIntArray.put(R.id.univ_tabs, 19);
        sparseIntArray.put(R.id.univ_Pager, 20);
    }

    public ResultFragmentBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 21, sIncludes, sViewsWithIds));
    }

    private ResultFragmentBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (AppBarLayout) bindings[1], (CardView) bindings[6], (Chip) bindings[10], (ChipGroup) bindings[9], (Chip) bindings[14], (Chip) bindings[12], (Chip) bindings[11], (Chip) bindings[13], (Chip) bindings[15], (HorizontalScrollView) bindings[8], (TextView) bindings[18], (ImageView) bindings[7], (ViewPager2) bindings[16], (View) bindings[3], (TextView) bindings[2], (TextView) bindings[4], (LinearLayout) bindings[17], (View) bindings[5], (ViewPager) bindings[20], (TabLayout) bindings[19]);
        this.mDirtyFlags = -1L;
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) bindings[0];
        this.mboundView0 = coordinatorLayout;
        coordinatorLayout.setTag(null);
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
        if (189 != variableId) {
            return false;
        }
        setResultViewModel((ResultViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.ResultFragmentBinding
    public void setResultViewModel(ResultViewModel ResultViewModel) {
        this.mResultViewModel = ResultViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}