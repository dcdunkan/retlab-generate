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
public final class FragmentCgpaBinding implements ViewBinding {
    public final LinearLayout cgpLayout;
    public final BarChart cgpaBarChart;
    private final FrameLayout rootView;
    public final Button sgpaBtn;
    public final Button subjectScoreBtn;

    private FragmentCgpaBinding(FrameLayout rootView, LinearLayout cgpLayout, BarChart cgpaBarChart, Button sgpaBtn, Button subjectScoreBtn) {
        this.rootView = rootView;
        this.cgpLayout = cgpLayout;
        this.cgpaBarChart = cgpaBarChart;
        this.sgpaBtn = sgpaBtn;
        this.subjectScoreBtn = subjectScoreBtn;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static FragmentCgpaBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentCgpaBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.fragment_cgpa, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentCgpaBinding bind(View rootView) {
        int i = R.id.cgp_layout;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
        if (linearLayout != null) {
            i = R.id.cgpa_bar_chart;
            BarChart barChart = (BarChart) ViewBindings.findChildViewById(rootView, i);
            if (barChart != null) {
                i = R.id.sgpa_btn;
                Button button = (Button) ViewBindings.findChildViewById(rootView, i);
                if (button != null) {
                    i = R.id.subject_score_btn;
                    Button button2 = (Button) ViewBindings.findChildViewById(rootView, i);
                    if (button2 != null) {
                        return new FragmentCgpaBinding((FrameLayout) rootView, linearLayout, barChart, button, button2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}