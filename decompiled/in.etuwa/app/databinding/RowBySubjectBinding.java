package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import at.grabner.circleprogress.CircleProgressView;
import in.etuwa.app.R;

/* loaded from: classes3.dex */
public final class RowBySubjectBinding implements ViewBinding {
    public final CircleProgressView attendanceByPer;
    public final TextView attendanceBySub;
    public final TextView attendanceByTotal;
    private final CardView rootView;
    public final View sideBarAttendance;

    private RowBySubjectBinding(CardView rootView, CircleProgressView attendanceByPer, TextView attendanceBySub, TextView attendanceByTotal, View sideBarAttendance) {
        this.rootView = rootView;
        this.attendanceByPer = attendanceByPer;
        this.attendanceBySub = attendanceBySub;
        this.attendanceByTotal = attendanceByTotal;
        this.sideBarAttendance = sideBarAttendance;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static RowBySubjectBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowBySubjectBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_by_subject, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowBySubjectBinding bind(View rootView) {
        View findChildViewById;
        int i = R.id.attendance_by_per;
        CircleProgressView circleProgressView = (CircleProgressView) ViewBindings.findChildViewById(rootView, i);
        if (circleProgressView != null) {
            i = R.id.attendance_by_sub;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                i = R.id.attendance_by_total;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView2 != null && (findChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.side_bar_attendance))) != null) {
                    return new RowBySubjectBinding((CardView) rootView, circleProgressView, textView, textView2, findChildViewById);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}