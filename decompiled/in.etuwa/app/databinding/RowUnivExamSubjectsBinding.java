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
public final class RowUnivExamSubjectsBinding implements ViewBinding {
    private final CardView rootView;
    public final TextView univExamAttendance;
    public final TextView univExamCredit;
    public final TextView univExamMark;
    public final TextView univExamSubject;
    public final TextView viewUniStatus;

    private RowUnivExamSubjectsBinding(CardView rootView, TextView univExamAttendance, TextView univExamCredit, TextView univExamMark, TextView univExamSubject, TextView viewUniStatus) {
        this.rootView = rootView;
        this.univExamAttendance = univExamAttendance;
        this.univExamCredit = univExamCredit;
        this.univExamMark = univExamMark;
        this.univExamSubject = univExamSubject;
        this.viewUniStatus = viewUniStatus;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static RowUnivExamSubjectsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowUnivExamSubjectsBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_univ_exam_subjects, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowUnivExamSubjectsBinding bind(View rootView) {
        int i = R.id.univ_exam_attendance;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.univ_exam_credit;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.univ_exam_mark;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView3 != null) {
                    i = R.id.univ_exam_subject;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView4 != null) {
                        i = R.id.view_uni_status;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView5 != null) {
                            return new RowUnivExamSubjectsBinding((CardView) rootView, textView, textView2, textView3, textView4, textView5);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}