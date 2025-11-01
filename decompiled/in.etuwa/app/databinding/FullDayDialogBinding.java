package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.etuwa.app.R;

/* loaded from: classes3.dex */
public final class FullDayDialogBinding implements ViewBinding {
    public final LinearLayout dutyHeaderApply;
    public final LinearLayout dutyHeaderAprov;
    private final LinearLayout rootView;
    public final TableLayout tableDutyFull;

    private FullDayDialogBinding(LinearLayout rootView, LinearLayout dutyHeaderApply, LinearLayout dutyHeaderAprov, TableLayout tableDutyFull) {
        this.rootView = rootView;
        this.dutyHeaderApply = dutyHeaderApply;
        this.dutyHeaderAprov = dutyHeaderAprov;
        this.tableDutyFull = tableDutyFull;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FullDayDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FullDayDialogBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.full_day_dialog, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static FullDayDialogBinding bind(View rootView) {
        int i = R.id.duty_header_apply;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
        if (linearLayout != null) {
            i = R.id.duty_header_aprov;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
            if (linearLayout2 != null) {
                i = R.id.tableDutyFull;
                TableLayout tableLayout = (TableLayout) ViewBindings.findChildViewById(rootView, i);
                if (tableLayout != null) {
                    return new FullDayDialogBinding((LinearLayout) rootView, linearLayout, linearLayout2, tableLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}