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
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0014R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R*\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00180\nj\b\u0012\u0004\u0012\u00020\u0018`\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000e\"\u0004\b\u001a\u0010\u0010R\u001a\u0010\u001b\u001a\u00020\u001cX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006%"}, d2 = {"Lin/etuwa/app/ui/analysis/batchpercentage/BatchPercentageActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "chart", "Lcom/github/mikephil/charting/charts/LineChart;", "getChart", "()Lcom/github/mikephil/charting/charts/LineChart;", "setChart", "(Lcom/github/mikephil/charting/charts/LineChart;)V", RemoteConfigConstants.ResponseFieldKey.ENTRIES, "Ljava/util/ArrayList;", "Lcom/github/mikephil/charting/data/Entry;", "Lkotlin/collections/ArrayList;", "getEntries", "()Ljava/util/ArrayList;", "setEntries", "(Ljava/util/ArrayList;)V", "layout", "Landroid/widget/LinearLayout;", "getLayout", "()Landroid/widget/LinearLayout;", "setLayout", "(Landroid/widget/LinearLayout;)V", "mark", "", "getMark", "setMark", "noData", "Landroid/widget/TextView;", "getNoData", "()Landroid/widget/TextView;", "setNoData", "(Landroid/widget/TextView;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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