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
public final class RowResultInternalBinding implements ViewBinding {
    public final TextView resultInternalScore;
    public final TextView resultInternalSubject;
    private final CardView rootView;

    private RowResultInternalBinding(CardView rootView, TextView resultInternalScore, TextView resultInternalSubject) {
        this.rootView = rootView;
        this.resultInternalScore = resultInternalScore;
        this.resultInternalSubject = resultInternalSubject;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static RowResultInternalBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowResultInternalBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_result_internal, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowResultInternalBinding bind(View rootView) {
        int i = R.id.result_internal_score;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.result_internal_subject;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                return new RowResultInternalBinding((CardView) rootView, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}