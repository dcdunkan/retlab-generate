package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.card.MaterialCardView;
import in.etuwa.app.R;

/* JADX INFO: loaded from: classes3.dex */
public final class QuizUploadResultItemModernBinding implements ViewBinding {
    public final TextView attendanceStatus;
    public final LinearLayout filesContainer;
    public final TextView markObtained;
    public final TextView questionContent;
    public final TextView questionNo;
    private final MaterialCardView rootView;

    private QuizUploadResultItemModernBinding(MaterialCardView rootView, TextView attendanceStatus, LinearLayout filesContainer, TextView markObtained, TextView questionContent, TextView questionNo) {
        this.rootView = rootView;
        this.attendanceStatus = attendanceStatus;
        this.filesContainer = filesContainer;
        this.markObtained = markObtained;
        this.questionContent = questionContent;
        this.questionNo = questionNo;
    }

    @Override // androidx.viewbinding.ViewBinding
    public MaterialCardView getRoot() {
        return this.rootView;
    }

    public static QuizUploadResultItemModernBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static QuizUploadResultItemModernBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.quiz_upload_result_item_modern, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static QuizUploadResultItemModernBinding bind(View rootView) {
        int i = R.id.attendance_status;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.files_container;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
            if (linearLayout != null) {
                i = R.id.mark_obtained;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView2 != null) {
                    i = R.id.question_content;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView3 != null) {
                        i = R.id.question_no;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView4 != null) {
                            return new QuizUploadResultItemModernBinding((MaterialCardView) rootView, textView, linearLayout, textView2, textView3, textView4);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}