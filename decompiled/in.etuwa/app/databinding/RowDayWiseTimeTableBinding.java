package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.etuwa.app.R;

/* loaded from: classes3.dex */
public final class RowDayWiseTimeTableBinding implements ViewBinding {
    public final TextView hourTv;
    private final CardView rootView;
    public final TextView staffNameTv;
    public final LinearLayout subjectPlanLyt;
    public final TextView subjectTv;
    public final TextView viewClicked;

    private RowDayWiseTimeTableBinding(CardView rootView, TextView hourTv, TextView staffNameTv, LinearLayout subjectPlanLyt, TextView subjectTv, TextView viewClicked) {
        this.rootView = rootView;
        this.hourTv = hourTv;
        this.staffNameTv = staffNameTv;
        this.subjectPlanLyt = subjectPlanLyt;
        this.subjectTv = subjectTv;
        this.viewClicked = viewClicked;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static RowDayWiseTimeTableBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowDayWiseTimeTableBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_day_wise_time_table, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowDayWiseTimeTableBinding bind(View rootView) {
        int i = R.id.hour_tv;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.staff_name_tv;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.subject_plan_lyt;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                if (linearLayout != null) {
                    i = R.id.subject_tv;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView3 != null) {
                        i = R.id.view_clicked;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView4 != null) {
                            return new RowDayWiseTimeTableBinding((CardView) rootView, textView, textView2, linearLayout, textView3, textView4);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}