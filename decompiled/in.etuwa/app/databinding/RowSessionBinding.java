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
public final class RowSessionBinding implements ViewBinding {
    public final TextView resultSessionScore;
    public final TextView resultSessionSubject;
    private final CardView rootView;

    private RowSessionBinding(CardView rootView, TextView resultSessionScore, TextView resultSessionSubject) {
        this.rootView = rootView;
        this.resultSessionScore = resultSessionScore;
        this.resultSessionSubject = resultSessionSubject;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static RowSessionBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowSessionBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_session, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowSessionBinding bind(View rootView) {
        int i = R.id.result_session_score;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.result_session_subject;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                return new RowSessionBinding((CardView) rootView, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}