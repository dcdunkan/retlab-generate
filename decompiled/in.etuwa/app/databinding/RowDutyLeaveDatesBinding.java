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
public final class RowDutyLeaveDatesBinding implements ViewBinding {
    public final TextView dateTv;
    private final CardView rootView;

    private RowDutyLeaveDatesBinding(CardView rootView, TextView dateTv) {
        this.rootView = rootView;
        this.dateTv = dateTv;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static RowDutyLeaveDatesBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowDutyLeaveDatesBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_duty_leave_dates, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowDutyLeaveDatesBinding bind(View rootView) {
        int i = R.id.date_tv;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            return new RowDutyLeaveDatesBinding((CardView) rootView, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}