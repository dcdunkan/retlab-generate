package in.etuwa.app.ui.analysis.subjectattendance;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.R;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SubAttendanceFragment.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 +2\u00020\u0001:\u0001+B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u001e0\u0004j\b\u0012\u0004\u0012\u00020\u001e`\u00062\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\f0\u0004j\b\u0012\u0004\u0012\u00020\f`\u0006H\u0002J\u0012\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J&\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u001a\u0010)\u001a\u00020 2\u0006\u0010*\u001a\u00020$2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016R*\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR.\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\nR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00100\u0017X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006,"}, d2 = {"Lin/etuwa/app/ui/analysis/subjectattendance/SubAttendanceFragment;", "Landroidx/fragment/app/Fragment;", "()V", RemoteConfigConstants.ResponseFieldKey.ENTRIES, "Ljava/util/ArrayList;", "Lcom/github/mikephil/charting/data/BarEntry;", "Lkotlin/collections/ArrayList;", "getEntries", "()Ljava/util/ArrayList;", "setEntries", "(Ljava/util/ArrayList;)V", "list", "Lin/etuwa/app/ui/analysis/subjectattendance/AnalysisSubAttendanceBean;", "getList", "setList", "pos", "", "getPos", "()Ljava/lang/Integer;", "setPos", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "represent", "", "getRepresent", "()[Ljava/lang/Integer;", "setRepresent", "([Ljava/lang/Integer;)V", "[Ljava/lang/Integer;", "getBarData", "Lcom/github/mikephil/charting/interfaces/datasets/IBarDataSet;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", SvgConstants.Tags.VIEW, "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SubAttendanceFragment extends Fragment {

    /* renamed from: Companion, reason: from kotlin metadata */
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

    /* compiled from: SubAttendanceFragment.kt */
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
    }

    private final ArrayList<IBarDataSet> getBarData(ArrayList<AnalysisSubAttendanceBean> list) {
        ArrayList<BarEntry> arrayList = new ArrayList<>();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(new BarEntry(i, (float) list.get(i).getPercentage_attendance()));
        }
        this.entries = arrayList;
        BarDataSet barDataSet = new BarDataSet(this.entries, "bar");
        barDataSet.setValueFormatter(new IValueFormatter() { // from class: in.etuwa.app.ui.analysis.subjectattendance.SubAttendanceFragment$$ExternalSyntheticLambda0
            @Override // com.github.mikephil.charting.formatter.IValueFormatter
            public final String getFormattedValue(float f, Entry entry, int i2, ViewPortHandler viewPortHandler) {
                String barData$lambda$3$lambda$2;
                barData$lambda$3$lambda$2 = SubAttendanceFragment.getBarData$lambda$3$lambda$2(f, entry, i2, viewPortHandler);
                return barData$lambda$3$lambda$2;
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final String getBarData$lambda$3$lambda$2(float f, Entry entry, int i, ViewPortHandler viewPortHandler) {
        StringBuilder sb = new StringBuilder();
        sb.append(f);
        return sb.toString();
    }
}