package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import in.etuwa.app.R;

/* JADX INFO: loaded from: classes3.dex */
public final class RowExamScheduleBinding implements ViewBinding {
    public final TextView examDescription;
    public final MaterialButton examDownload;
    public final TextView examName;
    public final TextView examSubject;
    private final MaterialCardView rootView;
    public final TextView tvDateExam;
    public final TextView tvTimeExam;

    private RowExamScheduleBinding(MaterialCardView rootView, TextView examDescription, MaterialButton examDownload, TextView examName, TextView examSubject, TextView tvDateExam, TextView tvTimeExam) {
        this.rootView = rootView;
        this.examDescription = examDescription;
        this.examDownload = examDownload;
        this.examName = examName;
        this.examSubject = examSubject;
        this.tvDateExam = tvDateExam;
        this.tvTimeExam = tvTimeExam;
    }

    @Override // androidx.viewbinding.ViewBinding
    public MaterialCardView getRoot() {
        return this.rootView;
    }

    public static RowExamScheduleBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowExamScheduleBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.row_exam_schedule, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static RowExamScheduleBinding bind(View rootView) {
        int i = R.id.exam_description;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.exam_download;
            MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(rootView, i);
            if (materialButton != null) {
                i = R.id.exam_name;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView2 != null) {
                    i = R.id.exam_subject;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView3 != null) {
                        i = R.id.tv_date_exam;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView4 != null) {
                            i = R.id.tv_time_exam;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView5 != null) {
                                return new RowExamScheduleBinding((MaterialCardView) rootView, textView, materialButton, textView2, textView3, textView4, textView5);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}