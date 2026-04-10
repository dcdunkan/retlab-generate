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
public final class RowResultInternalBinding implements ViewBinding {
    public final View internalIndicator;
    public final TextView resultInternalScore;
    public final TextView resultInternalSubject;
    private final MaterialCardView rootView;
    public final LinearLayout scoreContainer;

    private RowResultInternalBinding(MaterialCardView rootView, View internalIndicator, TextView resultInternalScore, TextView resultInternalSubject, LinearLayout scoreContainer) {
        this.rootView = rootView;
        this.internalIndicator = internalIndicator;
        this.resultInternalScore = resultInternalScore;
        this.resultInternalSubject = resultInternalSubject;
        this.scoreContainer = scoreContainer;
    }

    @Override // androidx.viewbinding.ViewBinding
    public MaterialCardView getRoot() {
        return this.rootView;
    }

    public static RowResultInternalBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowResultInternalBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.row_result_internal, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static RowResultInternalBinding bind(View rootView) {
        int i = R.id.internal_indicator;
        View viewFindChildViewById = ViewBindings.findChildViewById(rootView, i);
        if (viewFindChildViewById != null) {
            i = R.id.result_internal_score;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                i = R.id.result_internal_subject;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView2 != null) {
                    i = R.id.score_container;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                    if (linearLayout != null) {
                        return new RowResultInternalBinding((MaterialCardView) rootView, viewFindChildViewById, textView, textView2, linearLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}