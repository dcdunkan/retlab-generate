package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import in.etuwa.app.R;

/* loaded from: classes3.dex */
public final class ActivityAnalysisSubAttendanceBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final TabLayout semTab;
    public final ViewPager semViewpager;

    private ActivityAnalysisSubAttendanceBinding(LinearLayout rootView, TabLayout semTab, ViewPager semViewpager) {
        this.rootView = rootView;
        this.semTab = semTab;
        this.semViewpager = semViewpager;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityAnalysisSubAttendanceBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityAnalysisSubAttendanceBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.activity_analysis_sub_attendance, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityAnalysisSubAttendanceBinding bind(View rootView) {
        int i = R.id.sem_tab;
        TabLayout tabLayout = (TabLayout) ViewBindings.findChildViewById(rootView, i);
        if (tabLayout != null) {
            i = R.id.sem_viewpager;
            ViewPager viewPager = (ViewPager) ViewBindings.findChildViewById(rootView, i);
            if (viewPager != null) {
                return new ActivityAnalysisSubAttendanceBinding((LinearLayout) rootView, tabLayout, viewPager);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}