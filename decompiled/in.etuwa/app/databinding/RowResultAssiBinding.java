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
public final class RowResultAssiBinding implements ViewBinding {
    public final LinearLayout contentContainer;
    public final TextView noScoreText;
    public final LinearLayout notSubmittedContainer;
    public final TextView resultAssignmentName;
    public final TextView resultAssignmentScore;
    public final TextView resultAssignmentSubject;
    private final MaterialCardView rootView;
    public final LinearLayout scoreContainer;
    public final View subjectIndicator;

    private RowResultAssiBinding(MaterialCardView rootView, LinearLayout contentContainer, TextView noScoreText, LinearLayout notSubmittedContainer, TextView resultAssignmentName, TextView resultAssignmentScore, TextView resultAssignmentSubject, LinearLayout scoreContainer, View subjectIndicator) {
        this.rootView = rootView;
        this.contentContainer = contentContainer;
        this.noScoreText = noScoreText;
        this.notSubmittedContainer = notSubmittedContainer;
        this.resultAssignmentName = resultAssignmentName;
        this.resultAssignmentScore = resultAssignmentScore;
        this.resultAssignmentSubject = resultAssignmentSubject;
        this.scoreContainer = scoreContainer;
        this.subjectIndicator = subjectIndicator;
    }

    @Override // androidx.viewbinding.ViewBinding
    public MaterialCardView getRoot() {
        return this.rootView;
    }

    public static RowResultAssiBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowResultAssiBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.row_result_assi, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static RowResultAssiBinding bind(View rootView) {
        View viewFindChildViewById;
        int i = R.id.content_container;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
        if (linearLayout != null) {
            i = R.id.no_score_text;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                i = R.id.not_submitted_container;
                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                if (linearLayout2 != null) {
                    i = R.id.result_assignment_name;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView2 != null) {
                        i = R.id.result_assignment_score;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView3 != null) {
                            i = R.id.result_assignment_subject;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView4 != null) {
                                i = R.id.score_container;
                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                if (linearLayout3 != null && (viewFindChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.subject_indicator))) != null) {
                                    return new RowResultAssiBinding((MaterialCardView) rootView, linearLayout, textView, linearLayout2, textView2, textView3, textView4, linearLayout3, viewFindChildViewById);
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