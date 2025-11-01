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
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J0\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\"0\u0004j\b\u0012\u0004\u0012\u00020\"`\u00062\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006H\u0002J&\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u001a\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020$2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016R*\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR*\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\f0\u0004j\b\u0012\u0004\u0012\u00020\f`\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\nR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001d\u0010\u001e¨\u0006."}, d2 = {"Lin/etuwa/app/ui/analysis/AcademicProgressFragment;", "Landroidx/fragment/app/Fragment;", "()V", "academic", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getAcademic", "()Ljava/util/ArrayList;", "setAcademic", "(Ljava/util/ArrayList;)V", RemoteConfigConstants.ResponseFieldKey.ENTRIES, "Lcom/github/mikephil/charting/data/BarEntry;", "getEntries", "setEntries", "layout", "Landroid/widget/LinearLayout;", "getLayout", "()Landroid/widget/LinearLayout;", "setLayout", "(Landroid/widget/LinearLayout;)V", "noData", "Landroid/widget/TextView;", "getNoData", "()Landroid/widget/TextView;", "setNoData", "(Landroid/widget/TextView;)V", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", "Lkotlin/Lazy;", "getBarData", "Lcom/github/mikephil/charting/interfaces/datasets/IBarDataSet;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", SvgConstants.Tags.VIEW, "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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