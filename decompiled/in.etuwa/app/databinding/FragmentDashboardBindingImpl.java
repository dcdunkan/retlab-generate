package in.etuwa.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import at.grabner.circleprogress.CircleProgressView;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.tabs.TabLayout;
import in.etuwa.app.R;
import in.etuwa.app.ui.dashboard.DashboardViewModel;
import in.etuwa.app.ui.dashboard.dashtable.BoundaryAwareViewPager;

/* JADX INFO: loaded from: classes3.dex */
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
        sparseIntArray.put(R.id.dash_user_name, 4);
        sparseIntArray.put(R.id.dash_user_roll_no, 5);
        sparseIntArray.put(R.id.dash_user_sem, 6);
        sparseIntArray.put(R.id.dash_user_dept, 7);
        sparseIntArray.put(R.id.card_live_tv, 8);
        sparseIntArray.put(R.id.notification_btn, 9);
        sparseIntArray.put(R.id.cv_time_table, 10);
        sparseIntArray.put(R.id.date_tv, 11);
        sparseIntArray.put(R.id.tabs, 12);
        sparseIntArray.put(R.id.timetable_pager_home, 13);
        sparseIntArray.put(R.id.no_timetable_tv, 14);
        sparseIntArray.put(R.id.timetable_loading_overlay, 15);
        sparseIntArray.put(R.id.timetable_progress, 16);
        sparseIntArray.put(R.id.timetable_loading_tv, 17);
        sparseIntArray.put(R.id.btn_mission, 18);
        sparseIntArray.put(R.id.btn_vision, 19);
        sparseIntArray.put(R.id.resultCard, 20);
        sparseIntArray.put(R.id.cgpa_tv, 21);
        sparseIntArray.put(R.id.earned_credit_tv, 22);
        sparseIntArray.put(R.id.total_passed_tv, 23);
        sparseIntArray.put(R.id.total_failed_tv, 24);
        sparseIntArray.put(R.id.attendance_cv, 25);
        sparseIntArray.put(R.id.dash_attendance_for_sem, 26);
        sparseIntArray.put(R.id.view_one_btn, 27);
        sparseIntArray.put(R.id.view_two_btn, 28);
        sparseIntArray.put(R.id.view_three_btn, 29);
        sparseIntArray.put(R.id.hr_view, 30);
        sparseIntArray.put(R.id.academics_btn, 31);
        sparseIntArray.put(R.id.fees_btn, 32);
        sparseIntArray.put(R.id.information_btn, 33);
        sparseIntArray.put(R.id.office_btn, 34);
        sparseIntArray.put(R.id.placement_btn, 35);
        sparseIntArray.put(R.id.rv_dash_one, 36);
        sparseIntArray.put(R.id.rv_dash_all, 37);
        sparseIntArray.put(R.id.rv_dash_two, 38);
        sparseIntArray.put(R.id.rv_dash_academics, 39);
        sparseIntArray.put(R.id.rv_dash_fees, 40);
        sparseIntArray.put(R.id.rv_dash_info, 41);
        sparseIntArray.put(R.id.rv_dash_office, 42);
        sparseIntArray.put(R.id.rv_dash_placement, 43);
        sparseIntArray.put(R.id.rv_dash_three, 44);
        sparseIntArray.put(R.id.noticeCard, 45);
        sparseIntArray.put(R.id.notice_btn, 46);
        sparseIntArray.put(R.id.noticeScrollView, 47);
        sparseIntArray.put(R.id.noticeContainer, 48);
        sparseIntArray.put(R.id.previous_btn, 49);
        sparseIntArray.put(R.id.month_tv, 50);
        sparseIntArray.put(R.id.next_btn, 51);
        sparseIntArray.put(R.id.rv_calender, 52);
    }

    public FragmentDashboardBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 53, sIncludes, sViewsWithIds));
    }

    private FragmentDashboardBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (TextView) bindings[31], (CardView) bindings[25], (TextView) bindings[18], (TextView) bindings[19], (CardView) bindings[8], (TextView) bindings[21], (LinearLayout) bindings[10], (CircleProgressView) bindings[26], (TextView) bindings[7], (TextView) bindings[4], (TextView) bindings[5], (TextView) bindings[6], (FrameLayout) bindings[0], (TextView) bindings[11], (TextView) bindings[22], (TextView) bindings[32], (HorizontalScrollView) bindings[30], (TextView) bindings[33], (TextView) bindings[50], (CardView) bindings[51], (TextView) bindings[14], (CardView) bindings[46], (CardView) bindings[45], (LinearLayout) bindings[48], (ScrollView) bindings[47], (CardView) bindings[9], (TextView) bindings[34], (TextView) bindings[35], (CardView) bindings[49], (CardView) bindings[20], (RecyclerView) bindings[52], (RecyclerView) bindings[39], (RecyclerView) bindings[37], (RecyclerView) bindings[40], (RecyclerView) bindings[41], (RecyclerView) bindings[42], (RecyclerView) bindings[36], (RecyclerView) bindings[43], (RecyclerView) bindings[44], (LinearLayout) bindings[38], (SwipeRefreshLayout) bindings[2], (TabLayout) bindings[12], (FrameLayout) bindings[15], (TextView) bindings[17], (BoundaryAwareViewPager) bindings[13], (ProgressBar) bindings[16], (TextView) bindings[24], (TextView) bindings[23], (ShapeableImageView) bindings[3], (ImageView) bindings[27], (ImageView) bindings[29], (ImageView) bindings[28]);
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
        if (68 != variableId) {
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