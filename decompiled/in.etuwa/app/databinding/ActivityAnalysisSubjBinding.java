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
public final class ActivityAnalysisSubjBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final TabLayout semTab;
    public final ViewPager semViewpager;

    private ActivityAnalysisSubjBinding(LinearLayout rootView, TabLayout semTab, ViewPager semViewpager) {
        this.rootView = rootView;
        this.semTab = semTab;
        this.semViewpager = semViewpager;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityAnalysisSubjBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityAnalysisSubjBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.activity_analysis_subj, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityAnalysisSubjBinding bind(View rootView) {
        int i = R.id.sem_tab;
        TabLayout tabLayout = (TabLayout) ViewBindings.findChildViewById(rootView, i);
        if (tabLayout != null) {
            i = R.id.sem_viewpager;
            ViewPager viewPager = (ViewPager) ViewBindings.findChildViewById(rootView, i);
            if (viewPager != null) {
                return new ActivityAnalysisSubjBinding((LinearLayout) rootView, tabLayout, viewPager);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}