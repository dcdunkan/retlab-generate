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
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0014R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eRJ\u0010\u000f\u001a2\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u00120\u0010j\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012`\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006'"}, d2 = {"Lin/etuwa/app/ui/analysis/subjectattendance/AnalysisSubAttendanceActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "noData", "Landroid/widget/TextView;", "getNoData", "()Landroid/widget/TextView;", "setNoData", "(Landroid/widget/TextView;)V", "pagerAdapter", "Lin/etuwa/app/ui/analysis/subjectattendance/SubAttendancePagerAdapter;", "getPagerAdapter", "()Lin/etuwa/app/ui/analysis/subjectattendance/SubAttendancePagerAdapter;", "setPagerAdapter", "(Lin/etuwa/app/ui/analysis/subjectattendance/SubAttendancePagerAdapter;)V", "subject2", "Ljava/util/ArrayList;", "Lin/etuwa/app/ui/analysis/subjectattendance/AnalysisSubAttendanceBean;", "Lkotlin/collections/ArrayList;", "getSubject2", "()Ljava/util/ArrayList;", "setSubject2", "(Ljava/util/ArrayList;)V", "tabLayout", "Lcom/google/android/material/tabs/TabLayout;", "getTabLayout", "()Lcom/google/android/material/tabs/TabLayout;", "setTabLayout", "(Lcom/google/android/material/tabs/TabLayout;)V", "viewPager", "Landroidx/viewpager/widget/ViewPager;", "getViewPager", "()Landroidx/viewpager/widget/ViewPager;", "setViewPager", "(Landroidx/viewpager/widget/ViewPager;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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