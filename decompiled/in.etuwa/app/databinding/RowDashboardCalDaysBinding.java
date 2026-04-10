package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.etuwa.app.R;

/* JADX INFO: loaded from: classes3.dex */
public final class RowDashboardCalDaysBinding implements ViewBinding {
    public final LinearLayout daysLyt;
    public final LinearLayout markerContainer;
    private final LinearLayout rootView;
    public final TextView tvDay;

    private RowDashboardCalDaysBinding(LinearLayout rootView, LinearLayout daysLyt, LinearLayout markerContainer, TextView tvDay) {
        this.rootView = rootView;
        this.daysLyt = daysLyt;
        this.markerContainer = markerContainer;
        this.tvDay = tvDay;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static RowDashboardCalDaysBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowDashboardCalDaysBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.row_dashboard_cal_days, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static RowDashboardCalDaysBinding bind(View rootView) {
        LinearLayout linearLayout = (LinearLayout) rootView;
        int i = R.id.markerContainer;
        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
        if (linearLayout2 != null) {
            i = R.id.tvDay;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                return new RowDashboardCalDaysBinding(linearLayout, linearLayout, linearLayout2, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}