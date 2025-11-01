package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.github.mikephil.charting.charts.BarChart;
import in.etuwa.app.R;

/* loaded from: classes3.dex */
public final class SemPagerFragmentBinding implements ViewBinding {
    public final BarChart barChartSub;
    private final LinearLayout rootView;

    private SemPagerFragmentBinding(LinearLayout rootView, BarChart barChartSub) {
        this.rootView = rootView;
        this.barChartSub = barChartSub;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static SemPagerFragmentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static SemPagerFragmentBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.sem_pager_fragment, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static SemPagerFragmentBinding bind(View rootView) {
        int i = R.id.bar_chart_sub;
        BarChart barChart = (BarChart) ViewBindings.findChildViewById(rootView, i);
        if (barChart != null) {
            return new SemPagerFragmentBinding((LinearLayout) rootView, barChart);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}