package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.github.mikephil.charting.charts.LineChart;
import in.etuwa.app.R;

/* loaded from: classes3.dex */
public final class ActivityBatchPercentageBinding implements ViewBinding {
    public final LinearLayout bachLayout;
    public final LineChart batchBarChart;
    private final FrameLayout rootView;
    public final Button subAtten;

    private ActivityBatchPercentageBinding(FrameLayout rootView, LinearLayout bachLayout, LineChart batchBarChart, Button subAtten) {
        this.rootView = rootView;
        this.bachLayout = bachLayout;
        this.batchBarChart = batchBarChart;
        this.subAtten = subAtten;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static ActivityBatchPercentageBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityBatchPercentageBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.activity_batch_percentage, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityBatchPercentageBinding bind(View rootView) {
        int i = R.id.bach_layout;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
        if (linearLayout != null) {
            i = R.id.batch_bar_chart;
            LineChart lineChart = (LineChart) ViewBindings.findChildViewById(rootView, i);
            if (lineChart != null) {
                i = R.id.sub_atten;
                Button button = (Button) ViewBindings.findChildViewById(rootView, i);
                if (button != null) {
                    return new ActivityBatchPercentageBinding((FrameLayout) rootView, linearLayout, lineChart, button);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}