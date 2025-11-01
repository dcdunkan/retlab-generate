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
public final class RowLabDueBinding implements ViewBinding {
    public final TextView labDueAmount;
    public final TextView labDueDate;
    public final TextView labDueEquipmentName;
    public final TextView labDueLabName;
    public final TextView labDuePaidDate;
    public final TextView labDueStatus;
    private final CardView rootView;

    private RowLabDueBinding(CardView rootView, TextView labDueAmount, TextView labDueDate, TextView labDueEquipmentName, TextView labDueLabName, TextView labDuePaidDate, TextView labDueStatus) {
        this.rootView = rootView;
        this.labDueAmount = labDueAmount;
        this.labDueDate = labDueDate;
        this.labDueEquipmentName = labDueEquipmentName;
        this.labDueLabName = labDueLabName;
        this.labDuePaidDate = labDuePaidDate;
        this.labDueStatus = labDueStatus;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static RowLabDueBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowLabDueBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_lab_due, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowLabDueBinding bind(View rootView) {
        int i = R.id.lab_due_amount;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.lab_due_date;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.lab_due_equipment_name;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView3 != null) {
                    i = R.id.lab_due_lab_name;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView4 != null) {
                        i = R.id.lab_due_paid_date;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView5 != null) {
                            i = R.id.lab_due_status;
                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView6 != null) {
                                return new RowLabDueBinding((CardView) rootView, textView, textView2, textView3, textView4, textView5, textView6);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}