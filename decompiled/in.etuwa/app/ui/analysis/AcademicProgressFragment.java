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
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.preference.SharedPrefManager;
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

/* compiled from: AcademicProgressFragment.kt */
/* loaded from: classes4.dex */
public final class AcademicProgressFragment extends Fragment {
    public LinearLayout layout;
    public TextView noData;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;
    private ArrayList<BarEntry> entries = new ArrayList<>();
    private ArrayList<String> academic = new ArrayList<>();

    public AcademicProgressFragment() {
        final AcademicProgressFragment academicProgressFragment = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.analysis.AcademicProgressFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = academicProgressFragment;
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

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R.layout.academic_progress_fragment, container, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        View findViewById = view.findViewById(R.id.viewNoData);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.viewNoData)");
        setNoData((TextView) findViewById);
        getNoData().setVisibility(4);
        View findViewById2 = view.findViewById(R.id.acadamic_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.acadamic_layout)");
        setLayout((LinearLayout) findViewById2);
        getPreference().setNewLogin(false);
    }

    private final ArrayList<IBarDataSet> getBarData(ArrayList<String> academic) {
        ArrayList<BarEntry> arrayList = new ArrayList<>();
        int size = academic.size();
        for (int i = 0; i < size; i++) {
            String str = academic.get(i);
            Intrinsics.checkNotNullExpressionValue(str, "academic[i]");
            arrayList.add(new BarEntry(i, Float.parseFloat(str)));
        }
        this.entries = arrayList;
        BarDataSet barDataSet = new BarDataSet(this.entries, "bar");
        barDataSet.setValueFormatter(new IValueFormatter() { // from class: in.etuwa.app.ui.analysis.AcademicProgressFragment$$ExternalSyntheticLambda0
            @Override // com.github.mikephil.charting.formatter.IValueFormatter
            public final String getFormattedValue(float f, Entry entry, int i2, ViewPortHandler viewPortHandler) {
                String barData$lambda$2$lambda$1;
                barData$lambda$2$lambda$1 = AcademicProgressFragment.getBarData$lambda$2$lambda$1(f, entry, i2, viewPortHandler);
                return barData$lambda$2$lambda$1;
            }
        });
        barDataSet.setHighlightEnabled(false);
        barDataSet.setColors(new int[]{R.color.tenth, R.color.hss, R.color.sem1, R.color.sem2, R.color.sem3, R.color.sem4, R.color.sem5, R.color.sem6, R.color.sem7, R.color.sem8}, getActivity());
        ArrayList<IBarDataSet> arrayList2 = new ArrayList<>();
        arrayList2.add(barDataSet);
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String getBarData$lambda$2$lambda$1(float f, Entry entry, int i, ViewPortHandler viewPortHandler) {
        StringBuilder sb = new StringBuilder();
        sb.append(f);
        return sb.toString();
    }
}