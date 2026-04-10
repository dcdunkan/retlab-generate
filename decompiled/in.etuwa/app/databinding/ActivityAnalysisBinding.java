package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import in.etuwa.app.R;
import me.ibrahimsn.lib.SmoothBottomBar;

/* JADX INFO: loaded from: classes3.dex */
public final class ActivityAnalysisBinding implements ViewBinding {
    public final TabLayout analysisTabs;
    public final ViewPager analysisViewpager;
    public final AppBarLayout appBar;
    public final SmoothBottomBar bottomNavNew;
    private final CoordinatorLayout rootView;

    private ActivityAnalysisBinding(CoordinatorLayout rootView, TabLayout analysisTabs, ViewPager analysisViewpager, AppBarLayout appBar, SmoothBottomBar bottomNavNew) {
        this.rootView = rootView;
        this.analysisTabs = analysisTabs;
        this.analysisViewpager = analysisViewpager;
        this.appBar = appBar;
        this.bottomNavNew = bottomNavNew;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CoordinatorLayout getRoot() {
        return this.rootView;
    }

    public static ActivityAnalysisBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityAnalysisBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_analysis, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityAnalysisBinding bind(View rootView) {
        int i = R.id.analysis_tabs;
        TabLayout tabLayout = (TabLayout) ViewBindings.findChildViewById(rootView, i);
        if (tabLayout != null) {
            i = R.id.analysis_viewpager;
            ViewPager viewPager = (ViewPager) ViewBindings.findChildViewById(rootView, i);
            if (viewPager != null) {
                i = R.id.app_bar;
                AppBarLayout appBarLayout = (AppBarLayout) ViewBindings.findChildViewById(rootView, i);
                if (appBarLayout != null) {
                    i = R.id.bottom_nav_new;
                    SmoothBottomBar smoothBottomBar = (SmoothBottomBar) ViewBindings.findChildViewById(rootView, i);
                    if (smoothBottomBar != null) {
                        return new ActivityAnalysisBinding((CoordinatorLayout) rootView, tabLayout, viewPager, appBarLayout, smoothBottomBar);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}