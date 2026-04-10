package in.etuwa.app.ui.analysis.semestersgpa;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.exifinterface.media.ExifInterface;
import com.applandeo.materialcalendarview.utils.CalendarProperties;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.network.CallBackResponse;
import in.etuwa.app.ui.analysis.AnalysisTask;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* JADX INFO: compiled from: SgpaActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class SgpaActivity extends AppCompatActivity {
    public LinearLayout layout;
    public TextView noData;
    private ArrayList<BarEntry> entries = new ArrayList<>();
    private ArrayList<String> academic = new ArrayList<>();

    public final ArrayList<BarEntry> getEntries() {
        return this.entries;
    }

    public final void setEntries(ArrayList<BarEntry> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.entries = arrayList;
    }

    public final ArrayList<String> getAcademic() {
        return this.academic;
    }

    public final void setAcademic(ArrayList<String> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.academic = arrayList;
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

    public final LinearLayout getLayout() {
        LinearLayout linearLayout = this.layout;
        if (linearLayout != null) {
            return linearLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("layout");
        return null;
    }

    public final void setLayout(LinearLayout linearLayout) {
        Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
        this.layout = linearLayout;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sgpa);
        View viewFindViewById = findViewById(R.id.viewNoData);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(R.id.viewNoData)");
        setNoData((TextView) viewFindViewById);
        getNoData().setVisibility(4);
        View viewFindViewById2 = findViewById(R.id.acadamic_layout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(R.id.acadamic_layout)");
        setLayout((LinearLayout) viewFindViewById2);
        setTitle("Analysis");
        new AnalysisTask(this).getSgpa(new CallBackResponse() { // from class: in.etuwa.app.ui.analysis.semestersgpa.SgpaActivity.onCreate.1
            @Override // in.etuwa.app.data.network.CallBackResponse
            public void serverResponse(String response) {
                Intrinsics.checkNotNullParameter(response, "response");
                SgpaActivity.this.getAcademic().clear();
                try {
                    JSONArray jSONArray = new JSONArray(response);
                    if (jSONArray.length() == 0) {
                        SgpaActivity.this.getNoData().setVisibility(0);
                        SgpaActivity.this.getLayout().setVisibility(8);
                        return;
                    }
                    int length = jSONArray.length();
                    for (int i = 0; i < length; i++) {
                        SgpaActivity.this.getAcademic().add(jSONArray.getString(i));
                    }
                    BarChart barChart = (BarChart) SgpaActivity.this.findViewById(R.id.acadamic_progress_chart);
                    barChart.setData(new BarData(getBarData(SgpaActivity.this.getAcademic())));
                    YAxis axisLeft = barChart.getAxisLeft();
                    axisLeft.setAxisMinimum(0.0f);
                    axisLeft.setAxisMaximum(10.0f);
                    axisLeft.setLabelCount(10);
                    axisLeft.setDrawTopYLabelEntry(true);
                    axisLeft.setDrawGridLines(false);
                    axisLeft.setDrawAxisLine(false);
                    axisLeft.setValueFormatter(new ValueFormatter() { // from class: in.etuwa.app.ui.analysis.semestersgpa.SgpaActivity$onCreate$1$serverResponse$1$1
                        @Override // com.github.mikephil.charting.formatter.ValueFormatter
                        public String getAxisLabel(float value, AxisBase axis) {
                            return String.valueOf((int) value);
                        }
                    });
                    YAxis axisRight = barChart.getAxisRight();
                    axisRight.setDrawLabels(false);
                    axisRight.setDrawGridLines(false);
                    axisRight.setDrawZeroLine(false);
                    axisRight.setDrawTopYLabelEntry(true);
                    axisRight.setDrawAxisLine(false);
                    String[] strArr = {"1", ExifInterface.GPS_MEASUREMENT_2D, ExifInterface.GPS_MEASUREMENT_3D, "4", "5", "6", "7", "8"};
                    XAxis xAxis = barChart.getXAxis();
                    SgpaActivity sgpaActivity = SgpaActivity.this;
                    xAxis.setValueFormatter(new IndexAxisValueFormatter(strArr));
                    xAxis.setLabelCount(sgpaActivity.getEntries().size());
                    xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
                    xAxis.setDrawLabels(true);
                    xAxis.setDrawGridLines(false);
                    xAxis.setDrawAxisLine(false);
                    barChart.setDrawValueAboveBar(true);
                    barChart.getDescription().setEnabled(false);
                    barChart.setClickable(false);
                    barChart.getLegend().setEnabled(false);
                    barChart.setScaleEnabled(false);
                    barChart.animateY(CalendarProperties.FIRST_VISIBLE_PAGE, Easing.Linear);
                } catch (Exception e) {
                    Toast.makeText(SgpaActivity.this, e.toString(), 0).show();
                }
            }

            private final ArrayList<IBarDataSet> getBarData(ArrayList<String> academic) {
                SgpaActivity sgpaActivity = SgpaActivity.this;
                ArrayList<BarEntry> arrayList = new ArrayList<>();
                int size = academic.size();
                for (int i = 0; i < size; i++) {
                    String str = academic.get(i);
                    Intrinsics.checkNotNullExpressionValue(str, "academic[i]");
                    arrayList.add(new BarEntry(i, Float.parseFloat(str)));
                }
                sgpaActivity.setEntries(arrayList);
                BarDataSet barDataSet = new BarDataSet(SgpaActivity.this.getEntries(), "bar");
                SgpaActivity sgpaActivity2 = SgpaActivity.this;
                barDataSet.setValueFormatter(new ValueFormatter() { // from class: in.etuwa.app.ui.analysis.semestersgpa.SgpaActivity$onCreate$1$getBarData$dataSet$1$1
                    @Override // com.github.mikephil.charting.formatter.ValueFormatter
                    public String getFormattedValue(float value) {
                        return String.valueOf((int) value);
                    }
                });
                barDataSet.setHighlightEnabled(false);
                barDataSet.setColors(new int[]{R.color.tenth, R.color.hss, R.color.sem1, R.color.sem2, R.color.sem3, R.color.sem4, R.color.sem5, R.color.sem6, R.color.sem7, R.color.sem8}, sgpaActivity2);
                ArrayList<IBarDataSet> arrayList2 = new ArrayList<>();
                arrayList2.add(barDataSet);
                return arrayList2;
            }
        });
    }
}