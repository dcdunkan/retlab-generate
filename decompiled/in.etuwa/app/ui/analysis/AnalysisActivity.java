package in.etuwa.app.ui.analysis;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import in.etuwa.app.R;
import in.etuwa.app.ui.main.MainActivity;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import me.ibrahimsn.lib.SmoothBottomBar;

/* JADX INFO: compiled from: AnalysisActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AnalysisActivity extends AppCompatActivity {
    private final List<Fragment> fragmentList = new ArrayList();
    private FragmentManager manager;
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
        View viewFindViewById = findViewById(R.id.analysis_tabs);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(R.id.analysis_tabs)");
        setTabs((TabLayout) viewFindViewById);
        View viewFindViewById2 = findViewById(R.id.analysis_viewpager);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(R.id.analysis_viewpager)");
        setViewPager((ViewPager) viewFindViewById2);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        this.manager = supportFragmentManager;
        this.fragmentList.clear();
        SmoothBottomBar smoothBottomBar = (SmoothBottomBar) findViewById(R.id.bottom_nav_new);
        smoothBottomBar.setOnItemSelected(new Function1<Integer, Unit>() { // from class: in.etuwa.app.ui.analysis.AnalysisActivity.onCreate.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i) {
                if (i != 0) {
                    AnalysisActivity.this.openMain(i);
                } else {
                    AnalysisActivity.this.finish();
                }
            }
        });
        smoothBottomBar.setOnItemReselected(new Function1<Integer, Unit>() { // from class: in.etuwa.app.ui.analysis.AnalysisActivity.onCreate.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i) {
                if (i != 0) {
                    AnalysisActivity.this.openMain(i);
                } else {
                    AnalysisActivity.this.finish();
                }
            }
        });
        FragmentManager supportFragmentManager2 = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager2, "supportFragmentManager");
        AnalysisViewPagerAdapter analysisViewPagerAdapter = new AnalysisViewPagerAdapter(supportFragmentManager2);
        this.fragmentList.add(new CgpaFragment());
        this.fragmentList.add(new AttendanceAnalysisFragment());
        this.fragmentList.add(new AcademicProgressFragment());
        analysisViewPagerAdapter.addFragment(this.fragmentList);
        getViewPager().setAdapter(analysisViewPagerAdapter);
        getTabs().setupWithViewPager(getViewPager());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void openMain(int index) {
        Intent intent = new Intent(this, (Class<?>) MainActivity.class);
        intent.putExtra("bottom_index", index);
        intent.setFlags(131072);
        startActivity(intent);
        finish();
    }
}