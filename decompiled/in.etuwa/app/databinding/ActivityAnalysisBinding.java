package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import in.etuwa.app.R;

/* loaded from: classes3.dex */
public final class ActivityAnalysisBinding implements ViewBinding {
    public final TabLayout analysisTabs;
    public final ViewPager analysisViewpager;
    public final BottomNavigationView bottomNav;
    private final LinearLayout rootView;

    private ActivityAnalysisBinding(LinearLayout rootView, TabLayout analysisTabs, ViewPager analysisViewpager, BottomNavigationView bottomNav) {
        this.rootView = rootView;
        this.analysisTabs = analysisTabs;
        this.analysisViewpager = analysisViewpager;
        this.bottomNav = bottomNav;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityAnalysisBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityAnalysisBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.activity_analysis, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityAnalysisBinding bind(View rootView) {
        int i = R.id.analysis_tabs;
        TabLayout tabLayout = (TabLayout) ViewBindings.findChildViewById(rootView, i);
        if (tabLayout != null) {
            i = R.id.analysis_viewpager;
            ViewPager viewPager = (ViewPager) ViewBindings.findChildViewById(rootView, i);
            if (viewPager != null) {
                i = R.id.bottom_nav;
                BottomNavigationView bottomNavigationView = (BottomNavigationView) ViewBindings.findChildViewById(rootView, i);
                if (bottomNavigationView != null) {
                    return new ActivityAnalysisBinding((LinearLayout) rootView, tabLayout, viewPager, bottomNavigationView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}