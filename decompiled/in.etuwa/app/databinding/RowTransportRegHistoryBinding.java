package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.etuwa.app.R;

/* loaded from: classes3.dex */
public final class RowTransportRegHistoryBinding implements ViewBinding {
    public final LinearLayout dueLayout;
    private final CardView rootView;
    public final TextView transportRegBoarding;
    public final TextView transportRegDate;
    public final TextView transportRegStartDate;
    public final TextView transportRegStatus;
    public final TextView transportRegYear;

    private RowTransportRegHistoryBinding(CardView rootView, LinearLayout dueLayout, TextView transportRegBoarding, TextView transportRegDate, TextView transportRegStartDate, TextView transportRegStatus, TextView transportRegYear) {
        this.rootView = rootView;
        this.dueLayout = dueLayout;
        this.transportRegBoarding = transportRegBoarding;
        this.transportRegDate = transportRegDate;
        this.transportRegStartDate = transportRegStartDate;
        this.transportRegStatus = transportRegStatus;
        this.transportRegYear = transportRegYear;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static RowTransportRegHistoryBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowTransportRegHistoryBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_transport_reg_history, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowTransportRegHistoryBinding bind(View rootView) {
        int i = R.id.due_layout;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
        if (linearLayout != null) {
            i = R.id.transport_reg_boarding;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                i = R.id.transport_reg_date;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView2 != null) {
                    i = R.id.transport_reg_start_date;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView3 != null) {
                        i = R.id.transport_reg_status;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView4 != null) {
                            i = R.id.transport_reg_year;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView5 != null) {
                                return new RowTransportRegHistoryBinding((CardView) rootView, linearLayout, textView, textView2, textView3, textView4, textView5);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}