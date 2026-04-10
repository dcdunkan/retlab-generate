package in.etuwa.app.ui.analysis.subjectattendance;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import in.etuwa.app.R;
import in.etuwa.app.data.network.CallBackResponse;
import in.etuwa.app.ui.analysis.AnalysisTask;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: AnalysisSubAttendanceActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
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
        View viewFindViewById = findViewById(R.id.sem_viewpager);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(R.id.sem_viewpager)");
        setViewPager((ViewPager) viewFindViewById);
        View viewFindViewById2 = findViewById(R.id.sem_tab);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(R.id.sem_tab)");
        setTabLayout((TabLayout) viewFindViewById2);
        View viewFindViewById3 = findViewById(R.id.viewNoData);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(R.id.viewNoData)");
        setNoData((TextView) viewFindViewById3);
        getNoData().setVisibility(4);
        new AnalysisTask(this).getAttendanceSubject(new CallBackResponse() { // from class: in.etuwa.app.ui.analysis.subjectattendance.AnalysisSubAttendanceActivity.onCreate.1
            @Override // in.etuwa.app.data.network.CallBackResponse
            public void serverResponse(String response) {
                Intrinsics.checkNotNullParameter(response, "response");
                try {
                    JSONArray jSONArray = new JSONArray(response);
                    if (jSONArray.length() == 0) {
                        AnalysisSubAttendanceActivity.this.getNoData().setVisibility(0);
                        AnalysisSubAttendanceActivity.this.getViewPager().setVisibility(8);
                        return;
                    }
                    int length = jSONArray.length();
                    for (int i = 0; i < length; i++) {
                        ArrayList<AnalysisSubAttendanceBean> arrayList = new ArrayList<>();
                        JSONArray jSONArray2 = jSONArray.getJSONArray(i);
                        int length2 = jSONArray2.length();
                        for (int i2 = 0; i2 < length2; i2++) {
                            JSONObject jSONObject = jSONArray2.getJSONObject(i2);
                            String string = jSONObject.getString("subject code");
                            Intrinsics.checkNotNullExpressionValue(string, "obj1.getString(\"subject code\")");
                            arrayList.add(new AnalysisSubAttendanceBean(StringsKt.trim((CharSequence) string).toString(), jSONObject.getDouble("percentage")));
                        }
                        AnalysisSubAttendanceActivity.this.getSubject2().add(arrayList);
                    }
                    AnalysisSubAttendanceActivity analysisSubAttendanceActivity = AnalysisSubAttendanceActivity.this;
                    FragmentManager supportFragmentManager = AnalysisSubAttendanceActivity.this.getSupportFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
                    analysisSubAttendanceActivity.setPagerAdapter(new SubAttendancePagerAdapter(supportFragmentManager, AnalysisSubAttendanceActivity.this.getSubject2()));
                    AnalysisSubAttendanceActivity.this.getViewPager().setAdapter(AnalysisSubAttendanceActivity.this.getPagerAdapter());
                    AnalysisSubAttendanceActivity.this.getTabLayout().setupWithViewPager(AnalysisSubAttendanceActivity.this.getViewPager());
                } catch (Exception unused) {
                    Toast.makeText(AnalysisSubAttendanceActivity.this, "Something Went Wrong", 0).show();
                }
            }
        });
    }
}