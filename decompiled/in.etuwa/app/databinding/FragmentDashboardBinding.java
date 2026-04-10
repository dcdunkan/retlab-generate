package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
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
public abstract class FragmentDashboardBinding extends ViewDataBinding {
    public final TextView academicsBtn;
    public final CardView attendanceCv;
    public final TextView btnMission;
    public final TextView btnVision;
    public final CardView cardLiveTv;
    public final TextView cgpaTv;
    public final LinearLayout cvTimeTable;
    public final CircleProgressView dashAttendanceForSem;
    public final TextView dashUserDept;
    public final TextView dashUserName;
    public final TextView dashUserRollNo;
    public final TextView dashUserSem;
    public final FrameLayout dashlyt;
    public final TextView dateTv;
    public final TextView earnedCreditTv;
    public final TextView feesBtn;
    public final HorizontalScrollView hrView;
    public final TextView informationBtn;

    @Bindable
    protected DashboardViewModel mDashboardViewModel;
    public final TextView monthTv;
    public final CardView nextBtn;
    public final TextView noTimetableTv;
    public final CardView noticeBtn;
    public final CardView noticeCard;
    public final LinearLayout noticeContainer;
    public final ScrollView noticeScrollView;
    public final CardView notificationBtn;
    public final TextView officeBtn;
    public final TextView placementBtn;
    public final CardView previousBtn;
    public final CardView resultCard;
    public final RecyclerView rvCalender;
    public final RecyclerView rvDashAcademics;
    public final RecyclerView rvDashAll;
    public final RecyclerView rvDashFees;
    public final RecyclerView rvDashInfo;
    public final RecyclerView rvDashOffice;
    public final RecyclerView rvDashOne;
    public final RecyclerView rvDashPlacement;
    public final RecyclerView rvDashThree;
    public final LinearLayout rvDashTwo;
    public final SwipeRefreshLayout swipeLayout;
    public final TabLayout tabs;
    public final FrameLayout timetableLoadingOverlay;
    public final TextView timetableLoadingTv;
    public final BoundaryAwareViewPager timetablePagerHome;
    public final ProgressBar timetableProgress;
    public final TextView totalFailedTv;
    public final TextView totalPassedTv;
    public final ShapeableImageView userIcon;
    public final ImageView viewOneBtn;
    public final ImageView viewThreeBtn;
    public final ImageView viewTwoBtn;

    public abstract void setDashboardViewModel(DashboardViewModel dashboardViewModel);

    protected FragmentDashboardBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView academicsBtn, CardView attendanceCv, TextView btnMission, TextView btnVision, CardView cardLiveTv, TextView cgpaTv, LinearLayout cvTimeTable, CircleProgressView dashAttendanceForSem, TextView dashUserDept, TextView dashUserName, TextView dashUserRollNo, TextView dashUserSem, FrameLayout dashlyt, TextView dateTv, TextView earnedCreditTv, TextView feesBtn, HorizontalScrollView hrView, TextView informationBtn, TextView monthTv, CardView nextBtn, TextView noTimetableTv, CardView noticeBtn, CardView noticeCard, LinearLayout noticeContainer, ScrollView noticeScrollView, CardView notificationBtn, TextView officeBtn, TextView placementBtn, CardView previousBtn, CardView resultCard, RecyclerView rvCalender, RecyclerView rvDashAcademics, RecyclerView rvDashAll, RecyclerView rvDashFees, RecyclerView rvDashInfo, RecyclerView rvDashOffice, RecyclerView rvDashOne, RecyclerView rvDashPlacement, RecyclerView rvDashThree, LinearLayout rvDashTwo, SwipeRefreshLayout swipeLayout, TabLayout tabs, FrameLayout timetableLoadingOverlay, TextView timetableLoadingTv, BoundaryAwareViewPager timetablePagerHome, ProgressBar timetableProgress, TextView totalFailedTv, TextView totalPassedTv, ShapeableImageView userIcon, ImageView viewOneBtn, ImageView viewThreeBtn, ImageView viewTwoBtn) {
        super(_bindingComponent, _root, _localFieldCount);
        this.academicsBtn = academicsBtn;
        this.attendanceCv = attendanceCv;
        this.btnMission = btnMission;
        this.btnVision = btnVision;
        this.cardLiveTv = cardLiveTv;
        this.cgpaTv = cgpaTv;
        this.cvTimeTable = cvTimeTable;
        this.dashAttendanceForSem = dashAttendanceForSem;
        this.dashUserDept = dashUserDept;
        this.dashUserName = dashUserName;
        this.dashUserRollNo = dashUserRollNo;
        this.dashUserSem = dashUserSem;
        this.dashlyt = dashlyt;
        this.dateTv = dateTv;
        this.earnedCreditTv = earnedCreditTv;
        this.feesBtn = feesBtn;
        this.hrView = hrView;
        this.informationBtn = informationBtn;
        this.monthTv = monthTv;
        this.nextBtn = nextBtn;
        this.noTimetableTv = noTimetableTv;
        this.noticeBtn = noticeBtn;
        this.noticeCard = noticeCard;
        this.noticeContainer = noticeContainer;
        this.noticeScrollView = noticeScrollView;
        this.notificationBtn = notificationBtn;
        this.officeBtn = officeBtn;
        this.placementBtn = placementBtn;
        this.previousBtn = previousBtn;
        this.resultCard = resultCard;
        this.rvCalender = rvCalender;
        this.rvDashAcademics = rvDashAcademics;
        this.rvDashAll = rvDashAll;
        this.rvDashFees = rvDashFees;
        this.rvDashInfo = rvDashInfo;
        this.rvDashOffice = rvDashOffice;
        this.rvDashOne = rvDashOne;
        this.rvDashPlacement = rvDashPlacement;
        this.rvDashThree = rvDashThree;
        this.rvDashTwo = rvDashTwo;
        this.swipeLayout = swipeLayout;
        this.tabs = tabs;
        this.timetableLoadingOverlay = timetableLoadingOverlay;
        this.timetableLoadingTv = timetableLoadingTv;
        this.timetablePagerHome = timetablePagerHome;
        this.timetableProgress = timetableProgress;
        this.totalFailedTv = totalFailedTv;
        this.totalPassedTv = totalPassedTv;
        this.userIcon = userIcon;
        this.viewOneBtn = viewOneBtn;
        this.viewThreeBtn = viewThreeBtn;
        this.viewTwoBtn = viewTwoBtn;
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