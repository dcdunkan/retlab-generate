package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.etuwa.app.R;

/* loaded from: classes3.dex */
public final class RowTimetableChangeBinding implements ViewBinding {
    private final CardView rootView;
    public final TextView timetableChangeDate;
    public final TextView timetableChangePeriod;
    public final TextView timetableChangePlace;
    public final TextView timetableChangeTeacher;

    private RowTimetableChangeBinding(CardView rootView, TextView timetableChangeDate, TextView timetableChangePeriod, TextView timetableChangePlace, TextView timetableChangeTeacher) {
        this.rootView = rootView;
        this.timetableChangeDate = timetableChangeDate;
        this.timetableChangePeriod = timetableChangePeriod;
        this.timetableChangePlace = timetableChangePlace;
        this.timetableChangeTeacher = timetableChangeTeacher;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static RowTimetableChangeBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowTimetableChangeBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_timetable_change, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowTimetableChangeBinding bind(View rootView) {
        int i = R.id.timetable_change_date;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.timetable_change_period;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.timetable_change_place;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView3 != null) {
                    i = R.id.timetable_change_teacher;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView4 != null) {
                        return new RowTimetableChangeBinding((CardView) rootView, textView, textView2, textView3, textView4);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}