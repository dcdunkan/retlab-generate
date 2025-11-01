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
public final class RowLabListBinding implements ViewBinding {
    public final TextView labListName;
    private final CardView rootView;
    public final TextView safetyMeasures;
    public final TextView viewEquipment;

    private RowLabListBinding(CardView rootView, TextView labListName, TextView safetyMeasures, TextView viewEquipment) {
        this.rootView = rootView;
        this.labListName = labListName;
        this.safetyMeasures = safetyMeasures;
        this.viewEquipment = viewEquipment;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static RowLabListBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowLabListBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_lab_list, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowLabListBinding bind(View rootView) {
        int i = R.id.lab_list_name;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.safety_measures;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.view_equipment;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView3 != null) {
                    return new RowLabListBinding((CardView) rootView, textView, textView2, textView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}