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
public final class RowLabEvaluationsBinding implements ViewBinding {
    public final TextView labExpOutput;
    public final TextView labExpRecord;
    public final TextView labExpTopic;
    public final TextView labExpViva;
    private final CardView rootView;

    private RowLabEvaluationsBinding(CardView rootView, TextView labExpOutput, TextView labExpRecord, TextView labExpTopic, TextView labExpViva) {
        this.rootView = rootView;
        this.labExpOutput = labExpOutput;
        this.labExpRecord = labExpRecord;
        this.labExpTopic = labExpTopic;
        this.labExpViva = labExpViva;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static RowLabEvaluationsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowLabEvaluationsBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_lab_evaluations, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowLabEvaluationsBinding bind(View rootView) {
        int i = R.id.lab_exp_output;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.lab_exp_record;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.lab_exp_topic;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView3 != null) {
                    i = R.id.lab_exp_viva;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView4 != null) {
                        return new RowLabEvaluationsBinding((CardView) rootView, textView, textView2, textView3, textView4);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}