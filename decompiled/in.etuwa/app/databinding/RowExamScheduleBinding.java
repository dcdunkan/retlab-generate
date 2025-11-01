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
public final class RowExamScheduleBinding implements ViewBinding {
    public final TextView examDescription;
    public final TextView examDownload;
    public final TextView examName;
    public final TextView examSubject;
    private final CardView rootView;
    public final TextView tvDateExam;
    public final TextView tvTimeExam;

    private RowExamScheduleBinding(CardView rootView, TextView examDescription, TextView examDownload, TextView examName, TextView examSubject, TextView tvDateExam, TextView tvTimeExam) {
        this.rootView = rootView;
        this.examDescription = examDescription;
        this.examDownload = examDownload;
        this.examName = examName;
        this.examSubject = examSubject;
        this.tvDateExam = tvDateExam;
        this.tvTimeExam = tvTimeExam;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static RowExamScheduleBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowExamScheduleBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_exam_schedule, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowExamScheduleBinding bind(View rootView) {
        int i = R.id.exam_description;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.exam_download;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.exam_name;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView3 != null) {
                    i = R.id.exam_subject;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView4 != null) {
                        i = R.id.tv_date_exam;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView5 != null) {
                            i = R.id.tv_time_exam;
                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView6 != null) {
                                return new RowExamScheduleBinding((CardView) rootView, textView, textView2, textView3, textView4, textView5, textView6);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}