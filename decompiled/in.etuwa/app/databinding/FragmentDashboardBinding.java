package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
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
public abstract class FragmentDashboardBinding extends ViewDataBinding {
    public final CardView attendanceCv;
    public final TextView changeBtn;
    public final CardView cvDash;
    public final CardView cvTimetable;
    public final CardView cvVisionMission;
    public final CircleProgressView dashAttendanceForSem;
    public final TabLayout dashTabs;
    public final WrapContentViewPager dashTimeTablePager;
    public final TextView dashUserDept;
    public final TextView dashUserName;
    public final TextView dashUserRollNo;
    public final TextView dashUserSem;
    public final FrameLayout dashlyt;
    public final LinearLayout detailLayout;
    public final TextView downBtn;
    public final ImageView infoTimeTableHome;
    public final TextView libraryBtn;
    public final CardView libraryCard;
    public final LinearLayout linearhour1;
    public final TextView live;

    @Bindable
    protected DashboardViewModel mDashboardViewModel;
    public final TextView missionBtn;
    public final CardView noticeCv;
    public final TextView noticeText;
    public final RecyclerView rvDash;
    public final SwipeRefreshLayout swipeLayout;
    public final TextView upBtn;
    public final CircleImageView userIcon;
    public final TextView visionBtn;

    public abstract void setDashboardViewModel(DashboardViewModel dashboardViewModel);

    protected FragmentDashboardBinding(Object _bindingComponent, View _root, int _localFieldCount, CardView attendanceCv, TextView changeBtn, CardView cvDash, CardView cvTimetable, CardView cvVisionMission, CircleProgressView dashAttendanceForSem, TabLayout dashTabs, WrapContentViewPager dashTimeTablePager, TextView dashUserDept, TextView dashUserName, TextView dashUserRollNo, TextView dashUserSem, FrameLayout dashlyt, LinearLayout detailLayout, TextView downBtn, ImageView infoTimeTableHome, TextView libraryBtn, CardView libraryCard, LinearLayout linearhour1, TextView live, TextView missionBtn, CardView noticeCv, TextView noticeText, RecyclerView rvDash, SwipeRefreshLayout swipeLayout, TextView upBtn, CircleImageView userIcon, TextView visionBtn) {
        super(_bindingComponent, _root, _localFieldCount);
        this.attendanceCv = attendanceCv;
        this.changeBtn = changeBtn;
        this.cvDash = cvDash;
        this.cvTimetable = cvTimetable;
        this.cvVisionMission = cvVisionMission;
        this.dashAttendanceForSem = dashAttendanceForSem;
        this.dashTabs = dashTabs;
        this.dashTimeTablePager = dashTimeTablePager;
        this.dashUserDept = dashUserDept;
        this.dashUserName = dashUserName;
        this.dashUserRollNo = dashUserRollNo;
        this.dashUserSem = dashUserSem;
        this.dashlyt = dashlyt;
        this.detailLayout = detailLayout;
        this.downBtn = downBtn;
        this.infoTimeTableHome = infoTimeTableHome;
        this.libraryBtn = libraryBtn;
        this.libraryCard = libraryCard;
        this.linearhour1 = linearhour1;
        this.live = live;
        this.missionBtn = missionBtn;
        this.noticeCv = noticeCv;
        this.noticeText = noticeText;
        this.rvDash = rvDash;
        this.swipeLayout = swipeLayout;
        this.upBtn = upBtn;
        this.userIcon = userIcon;
        this.visionBtn = visionBtn;
    }

    public DashboardViewModel getDashboardViewModel() {
        return this.mDashboardViewModel;
    }

    public static FragmentDashboardBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentDashboardBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentDashboardBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_dashboard, root, attachToRoot, component);
    }

    public static FragmentDashboardBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentDashboardBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentDashboardBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_dashboard, null, false, component);
    }

    public static FragmentDashboardBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentDashboardBinding bind(View view, Object component) {
        return (FragmentDashboardBinding) bind(component, view, R.layout.fragment_dashboard);
    }
}