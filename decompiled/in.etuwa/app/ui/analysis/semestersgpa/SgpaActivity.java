package in.etuwa.app.ui.analysis.semestersgpa;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import in.etuwa.app.R;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SgpaActivity.kt */
/* loaded from: classes4.dex */
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
        View findViewById = findViewById(R.id.viewNoData);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.viewNoData)");
        setNoData((TextView) findViewById);
        getNoData().setVisibility(4);
        View findViewById2 = findViewById(R.id.acadamic_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.acadamic_layout)");
        setLayout((LinearLayout) findViewById2);
        setTitle("Analysis");
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
        barDataSet.setValueFormatter(new IValueFormatter() { // from class: in.etuwa.app.ui.analysis.semestersgpa.SgpaActivity$$ExternalSyntheticLambda0
            @Override // com.github.mikephil.charting.formatter.IValueFormatter
            public final String getFormattedValue(float f, Entry entry, int i2, ViewPortHandler viewPortHandler) {
                String barData$lambda$2$lambda$1;
                barData$lambda$2$lambda$1 = SgpaActivity.getBarData$lambda$2$lambda$1(f, entry, i2, viewPortHandler);
                return barData$lambda$2$lambda$1;
            }
        });
        barDataSet.setHighlightEnabled(false);
        barDataSet.setColors(new int[]{R.color.tenth, R.color.hss, R.color.sem1, R.color.sem2, R.color.sem3, R.color.sem4, R.color.sem5, R.color.sem6, R.color.sem7, R.color.sem8}, this);
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