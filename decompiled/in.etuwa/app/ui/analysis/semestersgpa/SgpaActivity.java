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
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u001c0\u0004j\b\u0012\u0004\u0012\u00020\u001c`\u00062\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006H\u0002J\u0012\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0014R*\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR*\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\f0\u0004j\b\u0012\u0004\u0012\u00020\f`\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\nR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006!"}, d2 = {"Lin/etuwa/app/ui/analysis/semestersgpa/SgpaActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "academic", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getAcademic", "()Ljava/util/ArrayList;", "setAcademic", "(Ljava/util/ArrayList;)V", RemoteConfigConstants.ResponseFieldKey.ENTRIES, "Lcom/github/mikephil/charting/data/BarEntry;", "getEntries", "setEntries", "layout", "Landroid/widget/LinearLayout;", "getLayout", "()Landroid/widget/LinearLayout;", "setLayout", "(Landroid/widget/LinearLayout;)V", "noData", "Landroid/widget/TextView;", "getNoData", "()Landroid/widget/TextView;", "setNoData", "(Landroid/widget/TextView;)V", "getBarData", "Lcom/github/mikephil/charting/interfaces/datasets/IBarDataSet;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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