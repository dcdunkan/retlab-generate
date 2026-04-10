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
public final class RowLabListBinding implements ViewBinding {
    public final TextView labListName;
    private final MaterialCardView rootView;
    public final MaterialButton safetyMeasures;
    public final MaterialButton viewEquipment;

    private RowLabListBinding(MaterialCardView rootView, TextView labListName, MaterialButton safetyMeasures, MaterialButton viewEquipment) {
        this.rootView = rootView;
        this.labListName = labListName;
        this.safetyMeasures = safetyMeasures;
        this.viewEquipment = viewEquipment;
    }

    @Override // androidx.viewbinding.ViewBinding
    public MaterialCardView getRoot() {
        return this.rootView;
    }

    public static RowLabListBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowLabListBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.row_lab_list, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static RowLabListBinding bind(View rootView) {
        int i = R.id.lab_list_name;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.safety_measures;
            MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(rootView, i);
            if (materialButton != null) {
                i = R.id.view_equipment;
                MaterialButton materialButton2 = (MaterialButton) ViewBindings.findChildViewById(rootView, i);
                if (materialButton2 != null) {
                    return new RowLabListBinding((MaterialCardView) rootView, textView, materialButton, materialButton2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}