package in.etuwa.app.ui.analysis;

import android.content.ComponentCallbacks;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.ui.feenewengineer.payment.feeconfirmdialog.FeeConfirmDialogKt;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.core.qualifier.Qualifier;

/* compiled from: AttendanceAnalysisFragment.kt */
/* loaded from: classes4.dex */
public final class AttendanceAnalysisFragment extends Fragment {
    public LinearLayout layout;
    public TextView noData;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
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
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        View findViewById = view.findViewById(R.id.viewNoData);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.viewNoData)");
        setNoData((TextView) findViewById);
        getNoData().setVisibility(4);
        View findViewById2 = view.findViewById(R.id.atten_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.atten_layout)");
        setLayout((LinearLayout) findViewById2);
        getPreference().setNewLogin(false);
    }

    private final ArrayList<IBarDataSet> getBarData(ArrayList<String> total, ArrayList<String> present) {
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
        barDataSet.setValueFormatter(new IValueFormatter() { // from class: in.etuwa.app.ui.analysis.AttendanceAnalysisFragment$$ExternalSyntheticLambda0
            @Override // com.github.mikephil.charting.formatter.IValueFormatter
            public final String getFormattedValue(float f, Entry entry, int i3, ViewPortHandler viewPortHandler) {
                String barData$lambda$3$lambda$2;
                barData$lambda$3$lambda$2 = AttendanceAnalysisFragment.getBarData$lambda$3$lambda$2(f, entry, i3, viewPortHandler);
                return barData$lambda$3$lambda$2;
            }
        });
        barDataSet.setHighlightEnabled(false);
        barDataSet.setDrawValues(false);
        barDataSet.setColors(new int[]{R.color.sem3}, getActivity());
        BarDataSet barDataSet2 = new BarDataSet(this.entries2, "bar");
        barDataSet2.setValueFormatter(new IValueFormatter() { // from class: in.etuwa.app.ui.analysis.AttendanceAnalysisFragment$$ExternalSyntheticLambda1
            @Override // com.github.mikephil.charting.formatter.IValueFormatter
            public final String getFormattedValue(float f, Entry entry, int i3, ViewPortHandler viewPortHandler) {
                String barData$lambda$5$lambda$4;
                barData$lambda$5$lambda$4 = AttendanceAnalysisFragment.getBarData$lambda$5$lambda$4(f, entry, i3, viewPortHandler);
                return barData$lambda$5$lambda$4;
            }
        });
        barDataSet2.setHighlightEnabled(false);
        barDataSet2.setColors(new int[]{R.color.sem7}, getActivity());
        ArrayList<IBarDataSet> arrayList3 = new ArrayList<>();
        arrayList3.add(barDataSet);
        arrayList3.add(barDataSet2);
        return arrayList3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String getBarData$lambda$3$lambda$2(float f, Entry entry, int i, ViewPortHandler viewPortHandler) {
        StringBuilder sb = new StringBuilder();
        sb.append(f);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String getBarData$lambda$5$lambda$4(float f, Entry entry, int i, ViewPortHandler viewPortHandler) {
        StringBuilder sb = new StringBuilder();
        sb.append(f);
        return sb.toString();
    }
}