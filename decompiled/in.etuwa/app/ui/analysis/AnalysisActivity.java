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
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0016"}, d2 = {"Lin/etuwa/app/ui/analysis/AnalysisActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "fragmentList", "", "Landroidx/fragment/app/Fragment;", "tabs", "Lcom/google/android/material/tabs/TabLayout;", "getTabs", "()Lcom/google/android/material/tabs/TabLayout;", "setTabs", "(Lcom/google/android/material/tabs/TabLayout;)V", "viewPager", "Landroidx/viewpager/widget/ViewPager;", "getViewPager", "()Landroidx/viewpager/widget/ViewPager;", "setViewPager", "(Landroidx/viewpager/widget/ViewPager;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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