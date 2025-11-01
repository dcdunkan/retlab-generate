package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.github.mikephil.charting.charts.BarChart;
import in.etuwa.app.R;

/* loaded from: classes3.dex */
public final class AttendanceAnalysisFragmentBinding implements ViewBinding {
    public final Button attenAnalysisPercBtn;
    public final BarChart attenBarChart;
    public final LinearLayout attenLayout;
    private final FrameLayout rootView;

    private AttendanceAnalysisFragmentBinding(FrameLayout rootView, Button attenAnalysisPercBtn, BarChart attenBarChart, LinearLayout attenLayout) {
        this.rootView = rootView;
        this.attenAnalysisPercBtn = attenAnalysisPercBtn;
        this.attenBarChart = attenBarChart;
        this.attenLayout = attenLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static AttendanceAnalysisFragmentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static AttendanceAnalysisFragmentBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.attendance_analysis_fragment, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static AttendanceAnalysisFragmentBinding bind(View rootView) {
        int i = R.id.atten_analysis_perc_btn;
        Button button = (Button) ViewBindings.findChildViewById(rootView, i);
        if (button != null) {
            i = R.id.atten_bar_chart;
            BarChart barChart = (BarChart) ViewBindings.findChildViewById(rootView, i);
            if (barChart != null) {
                i = R.id.atten_layout;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                if (linearLayout != null) {
                    return new AttendanceAnalysisFragmentBinding((FrameLayout) rootView, button, barChart, linearLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}