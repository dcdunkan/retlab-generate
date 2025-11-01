package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TableLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.etuwa.app.R;

/* loaded from: classes3.dex */
public final class HourDialogBinding implements ViewBinding {
    public final LinearLayout dutyHeaderHourAprove;
    public final LinearLayout dutyHeadrHourAply;
    public final Spinner hourSpinner;
    private final FrameLayout rootView;
    public final TableLayout tableDutyHour;

    private HourDialogBinding(FrameLayout rootView, LinearLayout dutyHeaderHourAprove, LinearLayout dutyHeadrHourAply, Spinner hourSpinner, TableLayout tableDutyHour) {
        this.rootView = rootView;
        this.dutyHeaderHourAprove = dutyHeaderHourAprove;
        this.dutyHeadrHourAply = dutyHeadrHourAply;
        this.hourSpinner = hourSpinner;
        this.tableDutyHour = tableDutyHour;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static HourDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static HourDialogBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.hour_dialog, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static HourDialogBinding bind(View rootView) {
        int i = R.id.duty_header_hour_aprove;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
        if (linearLayout != null) {
            i = R.id.duty_headr_hour_aply;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
            if (linearLayout2 != null) {
                i = R.id.hour_spinner;
                Spinner spinner = (Spinner) ViewBindings.findChildViewById(rootView, i);
                if (spinner != null) {
                    i = R.id.tableDutyHour;
                    TableLayout tableLayout = (TableLayout) ViewBindings.findChildViewById(rootView, i);
                    if (tableLayout != null) {
                        return new HourDialogBinding((FrameLayout) rootView, linearLayout, linearLayout2, spinner, tableLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}