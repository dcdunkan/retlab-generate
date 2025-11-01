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
public final class RowResultAssiBinding implements ViewBinding {
    public final TextView resultAssignmentName;
    public final TextView resultAssignmentScore;
    public final TextView resultAssignmentSubject;
    private final CardView rootView;

    private RowResultAssiBinding(CardView rootView, TextView resultAssignmentName, TextView resultAssignmentScore, TextView resultAssignmentSubject) {
        this.rootView = rootView;
        this.resultAssignmentName = resultAssignmentName;
        this.resultAssignmentScore = resultAssignmentScore;
        this.resultAssignmentSubject = resultAssignmentSubject;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static RowResultAssiBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowResultAssiBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_result_assi, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowResultAssiBinding bind(View rootView) {
        int i = R.id.result_assignment_name;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.result_assignment_score;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.result_assignment_subject;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView3 != null) {
                    return new RowResultAssiBinding((CardView) rootView, textView, textView2, textView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}