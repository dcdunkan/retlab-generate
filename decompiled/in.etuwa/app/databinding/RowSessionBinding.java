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
public final class RowSessionBinding implements ViewBinding {
    public final LinearLayout notSubmittedContainer;
    public final TextView resultSessionScore;
    public final TextView resultSessionSubject;
    private final MaterialCardView rootView;
    public final LinearLayout scoreContainer;
    public final View sessionIndicator;

    private RowSessionBinding(MaterialCardView rootView, LinearLayout notSubmittedContainer, TextView resultSessionScore, TextView resultSessionSubject, LinearLayout scoreContainer, View sessionIndicator) {
        this.rootView = rootView;
        this.notSubmittedContainer = notSubmittedContainer;
        this.resultSessionScore = resultSessionScore;
        this.resultSessionSubject = resultSessionSubject;
        this.scoreContainer = scoreContainer;
        this.sessionIndicator = sessionIndicator;
    }

    @Override // androidx.viewbinding.ViewBinding
    public MaterialCardView getRoot() {
        return this.rootView;
    }

    public static RowSessionBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowSessionBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.row_session, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static RowSessionBinding bind(View rootView) {
        View viewFindChildViewById;
        int i = R.id.not_submitted_container;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
        if (linearLayout != null) {
            i = R.id.result_session_score;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                i = R.id.result_session_subject;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView2 != null) {
                    i = R.id.score_container;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                    if (linearLayout2 != null && (viewFindChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.session_indicator))) != null) {
                        return new RowSessionBinding((MaterialCardView) rootView, linearLayout, textView, textView2, linearLayout2, viewFindChildViewById);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}