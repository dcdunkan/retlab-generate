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
public final class RowTimetableViewBinding implements ViewBinding {
    public final CardView cardTimeTable;
    private final CardView rootView;
    public final TextView timeTableSubject;
    public final TextView timeTableTeacherName;
    public final TextView timeTableTimePeriod;
    public final TextView timetableSide;

    private RowTimetableViewBinding(CardView rootView, CardView cardTimeTable, TextView timeTableSubject, TextView timeTableTeacherName, TextView timeTableTimePeriod, TextView timetableSide) {
        this.rootView = rootView;
        this.cardTimeTable = cardTimeTable;
        this.timeTableSubject = timeTableSubject;
        this.timeTableTeacherName = timeTableTeacherName;
        this.timeTableTimePeriod = timeTableTimePeriod;
        this.timetableSide = timetableSide;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static RowTimetableViewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowTimetableViewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_timetable_view, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowTimetableViewBinding bind(View rootView) {
        CardView cardView = (CardView) rootView;
        int i = R.id.time_table_subject;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.time_table_teacher_name;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.time_table_time_period;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView3 != null) {
                    i = R.id.timetable_side;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView4 != null) {
                        return new RowTimetableViewBinding(cardView, cardView, textView, textView2, textView3, textView4);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}