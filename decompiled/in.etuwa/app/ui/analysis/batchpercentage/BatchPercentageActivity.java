package in.etuwa.app.ui.analysis.batchpercentage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import com.android.volley.DefaultRetryPolicy;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.network.CallBackResponse;
import in.etuwa.app.ui.analysis.AnalysisTask;
import in.etuwa.app.ui.analysis.subjectattendance.AnalysisSubAttendanceActivity;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* JADX INFO: compiled from: BatchPercentageActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class BatchPercentageActivity extends AppCompatActivity {
    private LineChart chart;
    public LinearLayout layout;
    public TextView noData;
    private ArrayList<Entry> entries = new ArrayList<>();
    private ArrayList<String> mark = new ArrayList<>();

    public final LineChart getChart() {
        return this.chart;
    }

    public final void setChart(LineChart lineChart) {
        this.chart = lineChart;
    }

    public final ArrayList<Entry> getEntries() {
        return this.entries;
    }

    public final void setEntries(ArrayList<Entry> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.entries = arrayList;
    }

    public final ArrayList<String> getMark() {
        return this.mark;
    }

    public final void setMark(ArrayList<String> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.mark = arrayList;
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
        setContentView(R.layout.activity_batch_percentage);
        setTitle("Analysis");
        View viewFindViewById = findViewById(R.id.viewNoData);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(R.id.viewNoData)");
        setNoData((TextView) viewFindViewById);
        getNoData().setVisibility(4);
        View viewFindViewById2 = findViewById(R.id.bach_layout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(R.id.bach_layout)");
        setLayout((LinearLayout) viewFindViewById2);
        TextView textView = (TextView) findViewById(R.id.sub_atten);
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.analysis.batchpercentage.BatchPercentageActivity$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BatchPercentageActivity.onCreate$lambda$0(this.f$0, view);
                }
            });
        }
        new AnalysisTask(this).getAttendancepercent(new CallBackResponse() { // from class: in.etuwa.app.ui.analysis.batchpercentage.BatchPercentageActivity.onCreate.2
            @Override // in.etuwa.app.data.network.CallBackResponse
            public void serverResponse(String response) {
                Intrinsics.checkNotNullParameter(response, "response");
                try {
                    JSONArray jSONArray = new JSONArray(response);
                    if (jSONArray.length() == 0) {
                        BatchPercentageActivity.this.getNoData().setVisibility(0);
                        BatchPercentageActivity.this.getLayout().setVisibility(8);
                        return;
                    }
                    int length = jSONArray.length();
                    for (int i = 0; i < length; i++) {
                        BatchPercentageActivity.this.getMark().add(jSONArray.getString(i));
                    }
                    BatchPercentageActivity batchPercentageActivity = BatchPercentageActivity.this;
                    batchPercentageActivity.setChart((LineChart) batchPercentageActivity.findViewById(R.id.batch_bar_chart));
                    LineChart lineChart = (LineChart) BatchPercentageActivity.this.findViewById(R.id.batch_bar_chart);
                    lineChart.setScaleEnabled(false);
                    lineChart.getAxisRight().setDrawGridLines(false);
                    lineChart.getAxisLeft().setDrawGridLines(false);
                    lineChart.getXAxis().setDrawGridLines(false);
                    lineChart.setClickable(false);
                    BatchPercentageActivity.this.setEntries(new ArrayList<>());
                    int size = BatchPercentageActivity.this.getMark().size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ArrayList<Entry> entries = BatchPercentageActivity.this.getEntries();
                        String str = BatchPercentageActivity.this.getMark().get(i2);
                        Intrinsics.checkNotNullExpressionValue(str, "mark.get(i)");
                        entries.add(new BarEntry(i2, Float.parseFloat(str)));
                    }
                    LineDataSet lineDataSet = new LineDataSet(BatchPercentageActivity.this.getEntries(), "Attendance Percentage");
                    lineDataSet.setColor(ContextCompat.getColor(BatchPercentageActivity.this, R.color.sem4));
                    lineDataSet.setValueTextColor(ContextCompat.getColor(BatchPercentageActivity.this, R.color.sem3));
                    XAxis xAxis = lineChart.getXAxis();
                    final String[] strArr = {"1", ExifInterface.GPS_MEASUREMENT_2D, ExifInterface.GPS_MEASUREMENT_3D, "4", "5", "6", "7", "8"};
                    XAxis xAxis2 = lineChart.getXAxis();
                    xAxis2.setLabelCount(BatchPercentageActivity.this.getEntries().size());
                    xAxis2.setPosition(XAxis.XAxisPosition.BOTTOM);
                    xAxis2.setDrawLabels(true);
                    xAxis2.setDrawGridLines(false);
                    xAxis2.setDrawAxisLine(false);
                    xAxis.setGranularity(1.0f);
                    xAxis.setValueFormatter(new ValueFormatter() { // from class: in.etuwa.app.ui.analysis.batchpercentage.BatchPercentageActivity$onCreate$2$serverResponse$2
                        @Override // com.github.mikephil.charting.formatter.ValueFormatter
                        public String getAxisLabel(float value, AxisBase axis) {
                            int i3 = (int) value;
                            String[] strArr2 = strArr;
                            return i3 < strArr2.length ? strArr2[i3] : "";
                        }
                    });
                    lineChart.getAxisRight().setEnabled(false);
                    lineChart.getDescription().setEnabled(false);
                    YAxis axisLeft = lineChart.getAxisLeft();
                    axisLeft.setAxisMinimum(0.0f);
                    axisLeft.setAxisMaximum(100.0f);
                    axisLeft.setLabelCount(10);
                    axisLeft.setDrawTopYLabelEntry(true);
                    axisLeft.setDrawGridLines(false);
                    axisLeft.setDrawAxisLine(false);
                    axisLeft.setGranularity(1.0f);
                    lineChart.setData(new LineData(lineDataSet));
                    lineChart.animateX(DefaultRetryPolicy.DEFAULT_TIMEOUT_MS);
                    lineChart.invalidate();
                } catch (Exception unused) {
                    Toast.makeText(BatchPercentageActivity.this, "Something Went Wrong", 0).show();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(BatchPercentageActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.startActivity(new Intent(this$0, (Class<?>) AnalysisSubAttendanceActivity.class));
    }
}