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
public final class RowMedicalBinding implements ViewBinding {
    public final TextView medicalDateF;
    public final TextView medicalDateTo;
    public final TextView medicalReason;
    public final TextView medicalRemark;
    public final View medicalViewSide;
    private final CardView rootView;

    private RowMedicalBinding(CardView rootView, TextView medicalDateF, TextView medicalDateTo, TextView medicalReason, TextView medicalRemark, View medicalViewSide) {
        this.rootView = rootView;
        this.medicalDateF = medicalDateF;
        this.medicalDateTo = medicalDateTo;
        this.medicalReason = medicalReason;
        this.medicalRemark = medicalRemark;
        this.medicalViewSide = medicalViewSide;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static RowMedicalBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowMedicalBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_medical, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowMedicalBinding bind(View rootView) {
        View findChildViewById;
        int i = R.id.medical_date_f;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.medical_date_to;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.medical_reason;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView3 != null) {
                    i = R.id.medical_remark;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView4 != null && (findChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.medical_view_side))) != null) {
                        return new RowMedicalBinding((CardView) rootView, textView, textView2, textView3, textView4, findChildViewById);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}