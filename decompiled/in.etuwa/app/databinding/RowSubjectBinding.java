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
public final class RowSubjectBinding implements ViewBinding {
    public final TextView attendanceText;
    public final TextView coBtn;
    public final TextView coverageBtn;
    public final TextView geSubject;
    private final CardView rootView;
    public final TextView subName;
    public final CircleProgressView subjectProgressBar;
    public final TextView subjectTeacherName;
    public final TextView syllabusBtn;

    private RowSubjectBinding(CardView rootView, TextView attendanceText, TextView coBtn, TextView coverageBtn, TextView geSubject, TextView subName, CircleProgressView subjectProgressBar, TextView subjectTeacherName, TextView syllabusBtn) {
        this.rootView = rootView;
        this.attendanceText = attendanceText;
        this.coBtn = coBtn;
        this.coverageBtn = coverageBtn;
        this.geSubject = geSubject;
        this.subName = subName;
        this.subjectProgressBar = subjectProgressBar;
        this.subjectTeacherName = subjectTeacherName;
        this.syllabusBtn = syllabusBtn;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static RowSubjectBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowSubjectBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_subject, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowSubjectBinding bind(View rootView) {
        int i = R.id.attendance_text;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.co_btn;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.coverage_btn;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView3 != null) {
                    i = R.id.ge_subject;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView4 != null) {
                        i = R.id.sub_name;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView5 != null) {
                            i = R.id.subject_progress_bar;
                            CircleProgressView circleProgressView = (CircleProgressView) ViewBindings.findChildViewById(rootView, i);
                            if (circleProgressView != null) {
                                i = R.id.subject_teacher_name;
                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView6 != null) {
                                    i = R.id.syllabus_btn;
                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView7 != null) {
                                        return new RowSubjectBinding((CardView) rootView, textView, textView2, textView3, textView4, textView5, circleProgressView, textView6, textView7);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}