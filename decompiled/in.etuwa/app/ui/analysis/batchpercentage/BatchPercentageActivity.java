package in.etuwa.app.ui.analysis.batchpercentage;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import in.etuwa.app.R;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BatchPercentageActivity.kt */
/* loaded from: classes4.dex */
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
        View findViewById = findViewById(R.id.viewNoData);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.viewNoData)");
        setNoData((TextView) findViewById);
        getNoData().setVisibility(4);
        View findViewById2 = findViewById(R.id.bach_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.bach_layout)");
        setLayout((LinearLayout) findViewById2);
    }
}