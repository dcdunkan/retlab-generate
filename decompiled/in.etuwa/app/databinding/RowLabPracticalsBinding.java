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
public final class RowLabPracticalsBinding implements ViewBinding {
    public final TextView labPracticalAttendance;
    public final TextView labPracticalName;
    private final MaterialCardView rootView;
    public final MaterialButton viewEvaluation;
    public final MaterialButton viewExperiments;

    private RowLabPracticalsBinding(MaterialCardView rootView, TextView labPracticalAttendance, TextView labPracticalName, MaterialButton viewEvaluation, MaterialButton viewExperiments) {
        this.rootView = rootView;
        this.labPracticalAttendance = labPracticalAttendance;
        this.labPracticalName = labPracticalName;
        this.viewEvaluation = viewEvaluation;
        this.viewExperiments = viewExperiments;
    }

    @Override // androidx.viewbinding.ViewBinding
    public MaterialCardView getRoot() {
        return this.rootView;
    }

    public static RowLabPracticalsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowLabPracticalsBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.row_lab_practicals, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static RowLabPracticalsBinding bind(View rootView) {
        int i = R.id.lab_practical_attendance;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.lab_practical_name;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.view_evaluation;
                MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(rootView, i);
                if (materialButton != null) {
                    i = R.id.view_experiments;
                    MaterialButton materialButton2 = (MaterialButton) ViewBindings.findChildViewById(rootView, i);
                    if (materialButton2 != null) {
                        return new RowLabPracticalsBinding((MaterialCardView) rootView, textView, textView2, materialButton, materialButton2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}