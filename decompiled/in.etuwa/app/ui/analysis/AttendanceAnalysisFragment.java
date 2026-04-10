package in.etuwa.app.ui.analysis;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
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
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.network.CallBackResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.ui.analysis.batchpercentage.BatchPercentageActivity;
import in.etuwa.app.ui.feenewengineer.payment.feeconfirmdialog.FeeConfirmDialogKt;
import in.etuwa.app.utils.ToastExtKt;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.core.qualifier.Qualifier;

/* JADX INFO: compiled from: AttendanceAnalysisFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AttendanceAnalysisFragment extends Fragment {
    public LinearLayout layout;
    public TextView noData;

    /* JADX INFO: renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;
    private ArrayList<BarEntry> entries1 = new ArrayList<>();
    private ArrayList<BarEntry> entries2 = new ArrayList<>();
    private ArrayList<String> present = new ArrayList<>();
    private ArrayList<String> total = new ArrayList<>();

    public AttendanceAnalysisFragment() {
        final AttendanceAnalysisFragment attendanceAnalysisFragment = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.analysis.AttendanceAnalysisFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = attendanceAnalysisFragment;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), qualifier, b);
            }
        });
    }

    public final ArrayList<BarEntry> getEntries1() {
        return this.entries1;
    }

    public final void setEntries1(ArrayList<BarEntry> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.entries1 = arrayList;
    }

    public final ArrayList<BarEntry> getEntries2() {
        return this.entries2;
    }

    public final void setEntries2(ArrayList<BarEntry> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.entries2 = arrayList;
    }

    public final ArrayList<String> getPresent() {
        return this.present;
    }

    public final void setPresent(ArrayList<String> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.present = arrayList;
    }

    public final ArrayList<String> getTotal() {
        return this.total;
    }

    public final void setTotal(ArrayList<String> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.total = arrayList;
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

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R.layout.attendance_analysis_fragment, container, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(final View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        View viewFindViewById = view.findViewById(R.id.viewNoData);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "view.findViewById(R.id.viewNoData)");
        setNoData((TextView) viewFindViewById);
        getNoData().setVisibility(4);
        View viewFindViewById2 = view.findViewById(R.id.atten_layout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "view.findViewById(R.id.atten_layout)");
        setLayout((LinearLayout) viewFindViewById2);
        getPreference().setNewLogin(false);
        final TextView textView = (TextView) view.findViewById(R.id.atten_analysis_perc_btn);
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.analysis.AttendanceAnalysisFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    AttendanceAnalysisFragment.onViewCreated$lambda$0(this.f$0, view2);
                }
            });
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        new AnalysisTask(contextRequireContext).getAttendance(new CallBackResponse() { // from class: in.etuwa.app.ui.analysis.AttendanceAnalysisFragment.onViewCreated.2
            @Override // in.etuwa.app.data.network.CallBackResponse
            public void serverResponse(String response) {
                Intrinsics.checkNotNullParameter(response, "response");
                try {
                    JSONArray jSONArray = new JSONArray(response);
                    JSONArray jSONArray2 = jSONArray.getJSONObject(0).getJSONArray("sem_present");
                    int length = jSONArray2.length();
                    for (int i = 0; i < length; i++) {
                        AttendanceAnalysisFragment.this.getPresent().add(jSONArray2.getString(i));
                    }
                    JSONArray jSONArray3 = jSONArray.getJSONObject(1).getJSONArray("sem_total_hours");
                    int length2 = jSONArray3.length();
                    for (int i2 = 0; i2 < length2; i2++) {
                        AttendanceAnalysisFragment.this.getTotal().add(jSONArray3.getString(i2));
                    }
                    if (jSONArray2.length() == 0 && jSONArray3.length() == 0) {
                        AttendanceAnalysisFragment.this.getLayout().setVisibility(8);
                        AttendanceAnalysisFragment.this.getNoData().setVisibility(0);
                    }
                    BarChart barChart = (BarChart) view.findViewById(R.id.atten_bar_chart);
                    AttendanceAnalysisFragment attendanceAnalysisFragment = AttendanceAnalysisFragment.this;
                    barChart.setData(new BarData(attendanceAnalysisFragment.getBarData(attendanceAnalysisFragment.getTotal(), AttendanceAnalysisFragment.this.getPresent())));
                    YAxis axisLeft = barChart.getAxisLeft();
                    axisLeft.setAxisMinimum(0.0f);
                    axisLeft.setAxisMaximum(400.0f);
                    axisLeft.setLabelCount(21);
                    axisLeft.setDrawTopYLabelEntry(true);
                    axisLeft.setDrawGridLines(false);
                    axisLeft.setDrawAxisLine(false);
                    axisLeft.setValueFormatter(new ValueFormatter() { // from class: in.etuwa.app.ui.analysis.AttendanceAnalysisFragment$onViewCreated$2$serverResponse$1$1
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
                    AttendanceAnalysisFragment attendanceAnalysisFragment2 = AttendanceAnalysisFragment.this;
                    xAxis.setValueFormatter(new IndexAxisValueFormatter(strArr));
                    xAxis.setLabelCount(attendanceAnalysisFragment2.getEntries1().size());
                    xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
                    xAxis.setDrawLabels(true);
                    xAxis.setDrawGridLines(false);
                    xAxis.setDrawAxisLine(false);
                    barChart.setDrawValueAboveBar(false);
                    barChart.getDescription().setEnabled(false);
                    barChart.setClickable(false);
                    barChart.getLegend().setEnabled(false);
                    barChart.setScaleEnabled(false);
                    barChart.animateY(CalendarProperties.FIRST_VISIBLE_PAGE, Easing.Linear);
                } catch (Exception unused) {
                    TextView textView2 = textView;
                    if (textView2 != null) {
                        ToastExtKt.showInfoToast(textView2, "Something Went Wrong");
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(AttendanceAnalysisFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.startActivity(new Intent(this$0.getContext(), (Class<?>) BatchPercentageActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ArrayList<IBarDataSet> getBarData(ArrayList<String> total, ArrayList<String> present) {
        ArrayList<BarEntry> arrayList = new ArrayList<>();
        int size = total.size();
        for (int i = 0; i < size; i++) {
            String str = total.get(i);
            Intrinsics.checkNotNullExpressionValue(str, "total[i]");
            arrayList.add(new BarEntry(i, Float.parseFloat(str)));
        }
        this.entries1 = arrayList;
        ArrayList<BarEntry> arrayList2 = new ArrayList<>();
        int size2 = present.size();
        for (int i2 = 0; i2 < size2; i2++) {
            String str2 = present.get(i2);
            Intrinsics.checkNotNullExpressionValue(str2, "present[i]");
            arrayList2.add(new BarEntry(i2, Float.parseFloat(str2)));
        }
        this.entries2 = arrayList2;
        BarDataSet barDataSet = new BarDataSet(this.entries1, "bar");
        barDataSet.setValueFormatter(new ValueFormatter() { // from class: in.etuwa.app.ui.analysis.AttendanceAnalysisFragment$getBarData$dataSet1$1$1
            @Override // com.github.mikephil.charting.formatter.ValueFormatter
            public String getFormattedValue(float value) {
                return String.valueOf((int) value);
            }
        });
        barDataSet.setHighlightEnabled(false);
        barDataSet.setDrawValues(false);
        barDataSet.setColors(new int[]{R.color.sem3}, getActivity());
        BarDataSet barDataSet2 = new BarDataSet(this.entries2, "bar");
        barDataSet2.setValueFormatter(new ValueFormatter() { // from class: in.etuwa.app.ui.analysis.AttendanceAnalysisFragment$getBarData$dataSet2$1$1
            @Override // com.github.mikephil.charting.formatter.ValueFormatter
            public String getFormattedValue(float value) {
                return String.valueOf((int) value);
            }
        });
        barDataSet2.setHighlightEnabled(false);
        barDataSet2.setColors(new int[]{R.color.sem7}, getActivity());
        ArrayList<IBarDataSet> arrayList3 = new ArrayList<>();
        arrayList3.add(barDataSet);
        arrayList3.add(barDataSet2);
        return arrayList3;
    }
}