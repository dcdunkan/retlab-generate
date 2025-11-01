package in.etuwa.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import in.etuwa.app.R;
import in.etuwa.app.ui.timetable.TimeTableViewModel;

/* loaded from: classes3.dex */
public class TimeTableFragmentBindingImpl extends TimeTableFragmentBinding {
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
        sparseIntArray.put(R.id.appBarLayout, 2);
        sparseIntArray.put(R.id.tabs, 3);
        sparseIntArray.put(R.id.timetable_pager, 4);
        sparseIntArray.put(R.id.menu, 5);
        sparseIntArray.put(R.id.fabSpecial, 6);
        sparseIntArray.put(R.id.fabChange, 7);
    }

    public TimeTableFragmentBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 8, sIncludes, sViewsWithIds));
    }

    private TimeTableFragmentBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (AppBarLayout) bindings[2], (FloatingActionButton) bindings[7], (FloatingActionButton) bindings[6], (FloatingActionMenu) bindings[5], (TabLayout) bindings[3], (ViewPager) bindings[4]);
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
        if (221 != variableId) {
            return false;
        }
        setTimeTableViewModel((TimeTableViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.TimeTableFragmentBinding
    public void setTimeTableViewModel(TimeTableViewModel TimeTableViewModel) {
        this.mTimeTableViewModel = TimeTableViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}