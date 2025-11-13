package in.etuwa.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import at.grabner.circleprogress.CircleProgressView;
import com.google.android.material.tabs.TabLayout;
import de.hdodenhof.circleimageview.CircleImageView;
import in.etuwa.app.R;
import in.etuwa.app.helper.WrapContentViewPager;
import in.etuwa.app.ui.dashboard.DashboardViewModel;

/* loaded from: classes3.dex */
public class FragmentDashboardBindingImpl extends FragmentDashboardBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ViewProgressBarBinding mboundView0;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.swipe_layout, 2);
        sparseIntArray.put(R.id.user_icon, 3);
        sparseIntArray.put(R.id.change_btn, 4);
        sparseIntArray.put(R.id.detail_layout, 5);
        sparseIntArray.put(R.id.linearhour1, 6);
        sparseIntArray.put(R.id.dash_user_name, 7);
        sparseIntArray.put(R.id.live, 8);
        sparseIntArray.put(R.id.down_btn, 9);
        sparseIntArray.put(R.id.dash_user_roll_no, 10);
        sparseIntArray.put(R.id.dash_user_sem, 11);
        sparseIntArray.put(R.id.dash_user_dept, 12);
        sparseIntArray.put(R.id.up_btn, 13);
        sparseIntArray.put(R.id.cv_timetable, 14);
        sparseIntArray.put(R.id.dash_tabs, 15);
        sparseIntArray.put(R.id.dash_time_table_pager, 16);
        sparseIntArray.put(R.id.info_time_table_home, 17);
        sparseIntArray.put(R.id.library_card, 18);
        sparseIntArray.put(R.id.library_btn, 19);
        sparseIntArray.put(R.id.attendance_cv, 20);
        sparseIntArray.put(R.id.dash_attendance_for_sem, 21);
        sparseIntArray.put(R.id.notice_cv, 22);
        sparseIntArray.put(R.id.notice_text, 23);
        sparseIntArray.put(R.id.cv_vision_mission, 24);
        sparseIntArray.put(R.id.vision_btn, 25);
        sparseIntArray.put(R.id.mission_btn, 26);
        sparseIntArray.put(R.id.cv_dash, 27);
        sparseIntArray.put(R.id.rv_dash, 28);
    }

    public FragmentDashboardBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 29, sIncludes, sViewsWithIds));
    }

    private FragmentDashboardBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (CardView) bindings[20], (TextView) bindings[4], (CardView) bindings[27], (CardView) bindings[14], (CardView) bindings[24], (CircleProgressView) bindings[21], (TabLayout) bindings[15], (WrapContentViewPager) bindings[16], (TextView) bindings[12], (TextView) bindings[7], (TextView) bindings[10], (TextView) bindings[11], (FrameLayout) bindings[0], (LinearLayout) bindings[5], (TextView) bindings[9], (ImageView) bindings[17], (TextView) bindings[19], (CardView) bindings[18], (LinearLayout) bindings[6], (TextView) bindings[8], (TextView) bindings[26], (CardView) bindings[22], (TextView) bindings[23], (RecyclerView) bindings[28], (SwipeRefreshLayout) bindings[2], (TextView) bindings[13], (CircleImageView) bindings[3], (TextView) bindings[25]);
        this.mDirtyFlags = -1L;
        this.dashlyt.setTag(null);
        Object obj = bindings[1];
        this.mboundView0 = obj != null ? ViewProgressBarBinding.bind((View) obj) : null;
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
        if (69 != variableId) {
            return false;
        }
        setDashboardViewModel((DashboardViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.FragmentDashboardBinding
    public void setDashboardViewModel(DashboardViewModel DashboardViewModel) {
        this.mDashboardViewModel = DashboardViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}