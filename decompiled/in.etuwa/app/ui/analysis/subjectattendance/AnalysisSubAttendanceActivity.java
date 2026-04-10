package in.etuwa.app.ui.analysis.subjectattendance;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import in.etuwa.app.R;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnalysisSubAttendanceActivity.kt */
/* loaded from: classes4.dex */
public final class AnalysisSubAttendanceActivity extends AppCompatActivity {
    public TextView noData;
    public SubAttendancePagerAdapter pagerAdapter;
    private ArrayList<ArrayList<AnalysisSubAttendanceBean>> subject2 = new ArrayList<>();
    public TabLayout tabLayout;
    public ViewPager viewPager;

    public final SubAttendancePagerAdapter getPagerAdapter() {
        SubAttendancePagerAdapter subAttendancePagerAdapter = this.pagerAdapter;
        if (subAttendancePagerAdapter != null) {
            return subAttendancePagerAdapter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
        return null;
    }

    public final void setPagerAdapter(SubAttendancePagerAdapter subAttendancePagerAdapter) {
        Intrinsics.checkNotNullParameter(subAttendancePagerAdapter, "<set-?>");
        this.pagerAdapter = subAttendancePagerAdapter;
    }

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

    public final TabLayout getTabLayout() {
        TabLayout tabLayout = this.tabLayout;
        if (tabLayout != null) {
            return tabLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        return null;
    }

    public final void setTabLayout(TabLayout tabLayout) {
        Intrinsics.checkNotNullParameter(tabLayout, "<set-?>");
        this.tabLayout = tabLayout;
    }

    public final ArrayList<ArrayList<AnalysisSubAttendanceBean>> getSubject2() {
        return this.subject2;
    }

    public final void setSubject2(ArrayList<ArrayList<AnalysisSubAttendanceBean>> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.subject2 = arrayList;
    }

    public final TextView getNoData() {
        TextView textView = this.noData;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("noData");
        return null;
    }

    public final void setNoData(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.noData = textView;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analysis_sub_attendance);
        setTitle("Analysis");
        View findViewById = findViewById(R.id.sem_viewpager);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.sem_viewpager)");
        setViewPager((ViewPager) findViewById);
        View findViewById2 = findViewById(R.id.sem_tab);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.sem_tab)");
        setTabLayout((TabLayout) findViewById2);
        View findViewById3 = findViewById(R.id.viewNoData);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.viewNoData)");
        setNoData((TextView) findViewById3);
        getNoData().setVisibility(4);
    }
}