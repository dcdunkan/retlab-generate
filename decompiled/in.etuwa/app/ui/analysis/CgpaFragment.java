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
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.network.CallBackResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.ui.analysis.cgpasubjects.AnalysisSubjActivity;
import in.etuwa.app.ui.analysis.semestersgpa.SgpaActivity;
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

/* JADX INFO: compiled from: CgpaFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class CgpaFragment extends Fragment {
    public LinearLayout layout;
    public TextView noData;

    /* JADX INFO: renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;
    private ArrayList<BarEntry> entries = new ArrayList<>();
    private ArrayList<String> percentage = new ArrayList<>();

    public CgpaFragment() {
        final CgpaFragment cgpaFragment = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.analysis.CgpaFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = cgpaFragment;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), qualifier, b);
            }
        });
    }

    public final ArrayList<BarEntry> getEntries() {
        return this.entries;
    }

    public final void setEntries(ArrayList<BarEntry> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.entries = arrayList;
    }

    public final ArrayList<String> getPercentage() {
        return this.percentage;
    }

    public final void setPercentage(ArrayList<String> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.percentage = arrayList;
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
        return inflater.inflate(R.layout.fragment_cgpa, container, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(final View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        View viewFindViewById = view.findViewById(R.id.viewNoData);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "view.findViewById(R.id.viewNoData)");
        setNoData((TextView) viewFindViewById);
        getNoData().setVisibility(4);
        View viewFindViewById2 = view.findViewById(R.id.cgp_layout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "view.findViewById(R.id.cgp_layout)");
        setLayout((LinearLayout) viewFindViewById2);
        TextView textView = (TextView) view.findViewById(R.id.subject_score_btn);
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.analysis.CgpaFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    CgpaFragment.onViewCreated$lambda$0(this.f$0, view2);
                }
            });
        }
        final TextView textView2 = (TextView) view.findViewById(R.id.sgpa_btn);
        if (textView2 != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.analysis.CgpaFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    CgpaFragment.onViewCreated$lambda$1(this.f$0, view2);
                }
            });
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        new AnalysisTask(contextRequireContext).getAnalysis(new CallBackResponse() { // from class: in.etuwa.app.ui.analysis.CgpaFragment.onViewCreated.3
            @Override // in.etuwa.app.data.network.CallBackResponse
            public void serverResponse(String response) {
                Intrinsics.checkNotNullParameter(response, "response");
                CgpaFragment.this.getPercentage().clear();
                try {
                    JSONArray jSONArray = new JSONArray(response);
                    if (jSONArray.length() == 0) {
                        CgpaFragment.this.getNoData().setVisibility(0);
                        CgpaFragment.this.getLayout().setVisibility(8);
                        return;
                    }
                    int length = jSONArray.length();
                    for (int i = 0; i < length; i++) {
                        CgpaFragment.this.getPercentage().add(jSONArray.get(i).toString());
                    }
                    BarChart barChart = (BarChart) view.findViewById(R.id.cgpa_bar_chart);
                    CgpaFragment cgpaFragment = CgpaFragment.this;
                    barChart.setData(new BarData(cgpaFragment.getBarData(cgpaFragment.getPercentage())));
                    YAxis axisLeft = barChart.getAxisLeft();
                    axisLeft.setAxisMinimum(0.0f);
                    axisLeft.setAxisMaximum(100.0f);
                    axisLeft.setLabelCount(10);
                    axisLeft.setDrawTopYLabelEntry(true);
                    axisLeft.setDrawGridLines(false);
                    axisLeft.setDrawAxisLine(false);
                    axisLeft.setValueFormatter(new ValueFormatter() { // from class: in.etuwa.app.ui.analysis.CgpaFragment$onViewCreated$3$serverResponse$1$1
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
                    CgpaFragment cgpaFragment2 = CgpaFragment.this;
                    xAxis.setValueFormatter(new IndexAxisValueFormatter(strArr));
                    xAxis.setLabelCount(cgpaFragment2.getEntries().size());
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
                    TextView textView3 = textView2;
                    if (textView3 != null) {
                        ToastExtKt.showErrorToast(textView3, "Something Went Wrong " + e.getMessage());
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(CgpaFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.startActivity(new Intent(this$0.getContext(), (Class<?>) AnalysisSubjActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$1(CgpaFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.startActivity(new Intent(this$0.getContext(), (Class<?>) SgpaActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ArrayList<IBarDataSet> getBarData(ArrayList<String> percentage) {
        ArrayList<BarEntry> arrayList = new ArrayList<>();
        int size = percentage.size();
        for (int i = 0; i < size; i++) {
            String str = percentage.get(i);
            Intrinsics.checkNotNullExpressionValue(str, "percentage[i]");
            arrayList.add(new BarEntry(i, Float.parseFloat(str)));
        }
        this.entries = arrayList;
        BarDataSet barDataSet = new BarDataSet(this.entries, "bar");
        barDataSet.setValueFormatter(new ValueFormatter() { // from class: in.etuwa.app.ui.analysis.CgpaFragment$getBarData$dataSet$1$1
            @Override // com.github.mikephil.charting.formatter.ValueFormatter
            public String getFormattedValue(float value) {
                return String.valueOf((int) value);
            }
        });
        barDataSet.setHighlightEnabled(false);
        barDataSet.setColors(new int[]{R.color.sem1, R.color.sem2, R.color.sem3, R.color.sem4, R.color.sem5, R.color.sem6, R.color.sem7, R.color.sem8}, getActivity());
        ArrayList<IBarDataSet> arrayList2 = new ArrayList<>();
        arrayList2.add(barDataSet);
        return arrayList2;
    }
}