package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.github.mikephil.charting.charts.BarChart;
import in.etuwa.app.R;

/* loaded from: classes3.dex */
public final class AcademicProgressFragmentBinding implements ViewBinding {
    public final LinearLayout acadamicLayout;
    public final BarChart acadamicProgressChart;
    private final FrameLayout rootView;

    private AcademicProgressFragmentBinding(FrameLayout rootView, LinearLayout acadamicLayout, BarChart acadamicProgressChart) {
        this.rootView = rootView;
        this.acadamicLayout = acadamicLayout;
        this.acadamicProgressChart = acadamicProgressChart;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static AcademicProgressFragmentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static AcademicProgressFragmentBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.academic_progress_fragment, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static AcademicProgressFragmentBinding bind(View rootView) {
        int i = R.id.acadamic_layout;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
        if (linearLayout != null) {
            i = R.id.acadamic_progress_chart;
            BarChart barChart = (BarChart) ViewBindings.findChildViewById(rootView, i);
            if (barChart != null) {
                return new AcademicProgressFragmentBinding((FrameLayout) rootView, linearLayout, barChart);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}