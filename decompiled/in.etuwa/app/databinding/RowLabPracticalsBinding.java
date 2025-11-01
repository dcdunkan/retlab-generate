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
public final class RowLabPracticalsBinding implements ViewBinding {
    public final TextView labPracticalAttendance;
    public final TextView labPracticalName;
    private final CardView rootView;
    public final TextView viewEvaluation;
    public final TextView viewExperiments;

    private RowLabPracticalsBinding(CardView rootView, TextView labPracticalAttendance, TextView labPracticalName, TextView viewEvaluation, TextView viewExperiments) {
        this.rootView = rootView;
        this.labPracticalAttendance = labPracticalAttendance;
        this.labPracticalName = labPracticalName;
        this.viewEvaluation = viewEvaluation;
        this.viewExperiments = viewExperiments;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static RowLabPracticalsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowLabPracticalsBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_lab_practicals, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowLabPracticalsBinding bind(View rootView) {
        int i = R.id.lab_practical_attendance;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.lab_practical_name;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.view_evaluation;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView3 != null) {
                    i = R.id.view_experiments;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView4 != null) {
                        return new RowLabPracticalsBinding((CardView) rootView, textView, textView2, textView3, textView4);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}