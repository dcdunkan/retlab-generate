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
public final class RowTkmUniversityBinding implements ViewBinding {
    private final CardView rootView;
    public final TextView univCredit;
    public final TextView univGrade;
    public final TextView univSubjectName;

    private RowTkmUniversityBinding(CardView rootView, TextView univCredit, TextView univGrade, TextView univSubjectName) {
        this.rootView = rootView;
        this.univCredit = univCredit;
        this.univGrade = univGrade;
        this.univSubjectName = univSubjectName;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static RowTkmUniversityBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowTkmUniversityBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_tkm_university, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowTkmUniversityBinding bind(View rootView) {
        int i = R.id.univ_credit;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.univ_grade;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.univ_subject_name;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView3 != null) {
                    return new RowTkmUniversityBinding((CardView) rootView, textView, textView2, textView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}