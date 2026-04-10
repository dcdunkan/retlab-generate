package in.etuwa.app.ui.analysis.subjectattendance;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.R;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SubAttendanceFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class SubAttendanceFragment extends Fragment {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private ArrayList<AnalysisSubAttendanceBean> list;
    private Integer pos;
    private ArrayList<BarEntry> entries = new ArrayList<>();
    private Integer[] represent = {Integer.valueOf(R.color.sem1), Integer.valueOf(R.color.sem2), Integer.valueOf(R.color.sem3), Integer.valueOf(R.color.sem4), Integer.valueOf(R.color.sem5), Integer.valueOf(R.color.sem6), Integer.valueOf(R.color.sem7), Integer.valueOf(R.color.sem8)};

    @JvmStatic
    public static final SubAttendanceFragment newInstance(ArrayList<AnalysisSubAttendanceBean> arrayList, int i) {
        return INSTANCE.newInstance(arrayList, i);
    }

    public final ArrayList<BarEntry> getEntries() {
        return this.entries;
    }

    public final void setEntries(ArrayList<BarEntry> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.entries = arrayList;
    }

    public final Integer[] getRepresent() {
        return this.represent;
    }

    public final void setRepresent(Integer[] numArr) {
        Intrinsics.checkNotNullParameter(numArr, "<set-?>");
        this.represent = numArr;
    }

    public final Integer getPos() {
        return this.pos;
    }

    public final void setPos(Integer num) {
        this.pos = num;
    }

    public final ArrayList<AnalysisSubAttendanceBean> getList() {
        return this.list;
    }

    public final void setList(ArrayList<AnalysisSubAttendanceBean> arrayList) {
        this.list = arrayList;
    }

    /* JADX INFO: compiled from: SubAttendanceFragment.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b2\u0006\u0010\t\u001a\u00020\nH\u0007¨\u0006\u000b"}, d2 = {"Lin/etuwa/app/ui/analysis/subjectattendance/SubAttendanceFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/analysis/subjectattendance/SubAttendanceFragment;", "list", "Ljava/util/ArrayList;", "Lin/etuwa/app/ui/analysis/subjectattendance/AnalysisSubAttendanceBean;", "Lkotlin/collections/ArrayList;", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final SubAttendanceFragment newInstance(ArrayList<AnalysisSubAttendanceBean> list, int position) {
            Intrinsics.checkNotNullParameter(list, "list");
            SubAttendanceFragment subAttendanceFragment = new SubAttendanceFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(CommonCssConstants.POSITION, position);
            bundle.putParcelableArrayList("list", list);
            subAttendanceFragment.setArguments(bundle);
            return subAttendanceFragment;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.pos = Integer.valueOf(arguments.getInt(CommonCssConstants.POSITION));
            this.list = arguments.getParcelableArrayList("list");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R.layout.sub_attendance_fragment, container, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        try {
            BarChart barChart = (BarChart) view.findViewById(R.id.bar_chart_sub);
            ArrayList<AnalysisSubAttendanceBean> arrayList = this.list;
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            barChart.setData(new BarData(getBarData(arrayList)));
            YAxis axisLeft = barChart.getAxisLeft();
            axisLeft.setAxisMinimum(0.0f);
            axisLeft.setAxisMaximum(100.0f);
            axisLeft.setLabelCount(10);
            axisLeft.setDrawTopYLabelEntry(true);
            axisLeft.setDrawGridLines(false);
            axisLeft.setDrawAxisLine(false);
            axisLeft.setValueFormatter(new ValueFormatter() { // from class: in.etuwa.app.ui.analysis.subjectattendance.SubAttendanceFragment$onViewCreated$1$1
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
            ArrayList arrayList2 = new ArrayList();
            ArrayList<AnalysisSubAttendanceBean> arrayList3 = this.list;
            Intrinsics.checkNotNull(arrayList3);
            int size = arrayList3.size();
            for (int i = 0; i < size; i++) {
                ArrayList<AnalysisSubAttendanceBean> arrayList4 = this.list;
                Intrinsics.checkNotNull(arrayList4);
                String subject_code = arrayList4.get(i).getSubject_code();
                Intrinsics.checkNotNull(subject_code);
                arrayList2.addAll(CollectionsKt.listOf(subject_code));
                XAxis xAxis = barChart.getXAxis();
                xAxis.setValueFormatter(new IndexAxisValueFormatter(arrayList2));
                ArrayList<AnalysisSubAttendanceBean> arrayList5 = this.list;
                Intrinsics.checkNotNull(arrayList5);
                xAxis.setLabelCount(arrayList5.size());
                xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
                xAxis.setDrawLabels(true);
                xAxis.setDrawGridLines(false);
                xAxis.setDrawAxisLine(false);
                xAxis.setLabelRotationAngle(45.0f);
            }
            barChart.setDrawValueAboveBar(true);
            barChart.getDescription().setEnabled(false);
            barChart.setClickable(false);
            barChart.getLegend().setEnabled(false);
            barChart.setScaleEnabled(false);
            barChart.animateY(CalendarProperties.FIRST_VISIBLE_PAGE, Easing.Linear);
        } catch (Exception unused) {
        }
    }

    private final ArrayList<IBarDataSet> getBarData(ArrayList<AnalysisSubAttendanceBean> list) {
        ArrayList<BarEntry> arrayList = new ArrayList<>();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(new BarEntry(i, (float) list.get(i).getPercentage_attendance()));
        }
        this.entries = arrayList;
        BarDataSet barDataSet = new BarDataSet(this.entries, "bar");
        barDataSet.setValueFormatter(new ValueFormatter() { // from class: in.etuwa.app.ui.analysis.subjectattendance.SubAttendanceFragment$getBarData$dataSet$1$1
            @Override // com.github.mikephil.charting.formatter.ValueFormatter
            public String getFormattedValue(float value) {
                return String.valueOf((int) value);
            }
        });
        barDataSet.setHighlightEnabled(false);
        Integer[] numArr = this.represent;
        Integer num = this.pos;
        Intrinsics.checkNotNull(num);
        barDataSet.setColors(new int[]{numArr[num.intValue()].intValue()}, getActivity());
        ArrayList<IBarDataSet> arrayList2 = new ArrayList<>();
        arrayList2.add(barDataSet);
        return arrayList2;
    }
}