package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import at.grabner.circleprogress.CircleProgressView;
import com.google.android.material.card.MaterialCardView;
import in.etuwa.app.R;

/* JADX INFO: loaded from: classes3.dex */
public final class RowBySubjectBinding implements ViewBinding {
    public final CircleProgressView attendanceByPer;
    public final TextView attendanceBySub;
    public final TextView attendanceByTotal;
    private final MaterialCardView rootView;
    public final View sideBarAttendance;

    private RowBySubjectBinding(MaterialCardView rootView, CircleProgressView attendanceByPer, TextView attendanceBySub, TextView attendanceByTotal, View sideBarAttendance) {
        this.rootView = rootView;
        this.attendanceByPer = attendanceByPer;
        this.attendanceBySub = attendanceBySub;
        this.attendanceByTotal = attendanceByTotal;
        this.sideBarAttendance = sideBarAttendance;
    }

    @Override // androidx.viewbinding.ViewBinding
    public MaterialCardView getRoot() {
        return this.rootView;
    }

    public static RowBySubjectBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowBySubjectBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.row_by_subject, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static RowBySubjectBinding bind(View rootView) {
        View viewFindChildViewById;
        int i = R.id.attendance_by_per;
        CircleProgressView circleProgressView = (CircleProgressView) ViewBindings.findChildViewById(rootView, i);
        if (circleProgressView != null) {
            i = R.id.attendance_by_sub;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                i = R.id.attendance_by_total;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView2 != null && (viewFindChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.side_bar_attendance))) != null) {
                    return new RowBySubjectBinding((MaterialCardView) rootView, circleProgressView, textView, textView2, viewFindChildViewById);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}