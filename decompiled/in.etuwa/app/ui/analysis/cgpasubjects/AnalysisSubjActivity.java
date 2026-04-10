package in.etuwa.app.ui.analysis.cgpasubjects;

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

/* JADX INFO: compiled from: AnalysisSubjActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AnalysisSubjActivity extends AppCompatActivity {
    public TextView noData;
    public SubjectPagerAdapter pagerAdapter;
    private ArrayList<ArrayList<AnalysisSubjectBean>> subject2 = new ArrayList<>();
    public TabLayout tabLayout;
    public ViewPager viewPager;

    public final SubjectPagerAdapter getPagerAdapter() {
        SubjectPagerAdapter subjectPagerAdapter = this.pagerAdapter;
        if (subjectPagerAdapter != null) {
            return subjectPagerAdapter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
        return null;
    }

    public final void setPagerAdapter(SubjectPagerAdapter subjectPagerAdapter) {
        Intrinsics.checkNotNullParameter(subjectPagerAdapter, "<set-?>");
        this.pagerAdapter = subjectPagerAdapter;
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

    public final ArrayList<ArrayList<AnalysisSubjectBean>> getSubject2() {
        return this.subject2;
    }

    public final void setSubject2(ArrayList<ArrayList<AnalysisSubjectBean>> arrayList) {
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
        setContentView(R.layout.activity_analysis_subj);
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
        new AnalysisTask(this).getSubject(new CallBackResponse() { // from class: in.etuwa.app.ui.analysis.cgpasubjects.AnalysisSubjActivity.onCreate.1
            @Override // in.etuwa.app.data.network.CallBackResponse
            public void serverResponse(String response) {
                Intrinsics.checkNotNullParameter(response, "response");
                try {
                    JSONArray jSONArray = new JSONArray(response);
                    if (jSONArray.length() == 0) {
                        AnalysisSubjActivity.this.getNoData().setVisibility(0);
                        AnalysisSubjActivity.this.getViewPager().setVisibility(8);
                        return;
                    }
                    int length = jSONArray.length();
                    for (int i = 0; i < length; i++) {
                        ArrayList<AnalysisSubjectBean> arrayList = new ArrayList<>();
                        JSONArray jSONArray2 = jSONArray.getJSONArray(i);
                        int length2 = jSONArray2.length();
                        for (int i2 = 0; i2 < length2; i2++) {
                            JSONObject jSONObject = jSONArray2.getJSONObject(i2);
                            String string = jSONObject.getString("subject code");
                            Intrinsics.checkNotNullExpressionValue(string, "obj1.getString(\"subject code\")");
                            arrayList.add(new AnalysisSubjectBean(StringsKt.trim((CharSequence) string).toString(), jSONObject.getDouble("percentage")));
                        }
                        AnalysisSubjActivity.this.getSubject2().add(arrayList);
                    }
                    AnalysisSubjActivity analysisSubjActivity = AnalysisSubjActivity.this;
                    FragmentManager supportFragmentManager = AnalysisSubjActivity.this.getSupportFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
                    analysisSubjActivity.setPagerAdapter(new SubjectPagerAdapter(supportFragmentManager, AnalysisSubjActivity.this.getSubject2()));
                    AnalysisSubjActivity.this.getViewPager().setAdapter(AnalysisSubjActivity.this.getPagerAdapter());
                    AnalysisSubjActivity.this.getTabLayout().setupWithViewPager(AnalysisSubjActivity.this.getViewPager());
                } catch (Exception unused) {
                    Toast.makeText(AnalysisSubjActivity.this, "Something Went Wrong", 0).show();
                }
            }
        });
    }
}