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
public final class RowSpecialBinding implements ViewBinding {
    private final CardView rootView;
    public final TextView timetableSpecialDate;
    public final TextView timetableSpecialPeriod;
    public final TextView timetableSpecialSubject;
    public final TextView timetableSpecialTeacher;

    private RowSpecialBinding(CardView rootView, TextView timetableSpecialDate, TextView timetableSpecialPeriod, TextView timetableSpecialSubject, TextView timetableSpecialTeacher) {
        this.rootView = rootView;
        this.timetableSpecialDate = timetableSpecialDate;
        this.timetableSpecialPeriod = timetableSpecialPeriod;
        this.timetableSpecialSubject = timetableSpecialSubject;
        this.timetableSpecialTeacher = timetableSpecialTeacher;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static RowSpecialBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowSpecialBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_special, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowSpecialBinding bind(View rootView) {
        int i = R.id.timetable_special_date;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.timetable_special_period;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.timetable_special_subject;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView3 != null) {
                    i = R.id.timetable_special_teacher;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView4 != null) {
                        return new RowSpecialBinding((CardView) rootView, textView, textView2, textView3, textView4);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}