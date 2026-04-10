package in.etuwa.app.ui.analysis;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import in.etuwa.app.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnalysisActivity.kt */
/* loaded from: classes4.dex */
public final class AnalysisActivity extends AppCompatActivity {
    private final List<Fragment> fragmentList = new ArrayList();
    public TabLayout tabs;
    public ViewPager viewPager;

    public final ViewPager getViewPager() {
        ViewPager viewPager = this.viewPager;
        if (viewPager != null) {
            return viewPager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        return null;
    }

    public final void setViewPager(ViewPager viewPager) {
        Intrinsics.checkNotNullParameter(viewPager, "<set-?>");
        this.viewPager = viewPager;
    }

    public final TabLayout getTabs() {
        TabLayout tabLayout = this.tabs;
        if (tabLayout != null) {
            return tabLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("tabs");
        return null;
    }

    public final void setTabs(TabLayout tabLayout) {
        Intrinsics.checkNotNullParameter(tabLayout, "<set-?>");
        this.tabs = tabLayout;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analysis);
        setTitle("Analysis");
        View findViewById = findViewById(R.id.analysis_tabs);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.analysis_tabs)");
        setTabs((TabLayout) findViewById);
        View findViewById2 = findViewById(R.id.analysis_viewpager);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.analysis_viewpager)");
        setViewPager((ViewPager) findViewById2);
        this.fragmentList.clear();
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        AnalysisViewPagerAdapter analysisViewPagerAdapter = new AnalysisViewPagerAdapter(supportFragmentManager);
        this.fragmentList.add(new CgpaFragment());
        this.fragmentList.add(new AttendanceAnalysisFragment());
        this.fragmentList.add(new AcademicProgressFragment());
        analysisViewPagerAdapter.addFragment(this.fragmentList);
        getViewPager().setAdapter(analysisViewPagerAdapter);
        getTabs().setupWithViewPager(getViewPager());
    }
}