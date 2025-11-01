package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.etuwa.app.R;

/* loaded from: classes3.dex */
public final class RowFundedSemBinding implements ViewBinding {
    public final TextView agencyTv;
    public final TextView amountTv;
    public final TextView durationTv;
    private final LinearLayout rootView;
    public final TextView titleTv;

    private RowFundedSemBinding(LinearLayout rootView, TextView agencyTv, TextView amountTv, TextView durationTv, TextView titleTv) {
        this.rootView = rootView;
        this.agencyTv = agencyTv;
        this.amountTv = amountTv;
        this.durationTv = durationTv;
        this.titleTv = titleTv;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static RowFundedSemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowFundedSemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_funded_sem, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowFundedSemBinding bind(View rootView) {
        int i = R.id.agency_tv;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.amount_tv;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.duration_tv;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView3 != null) {
                    i = R.id.title_tv;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView4 != null) {
                        return new RowFundedSemBinding((LinearLayout) rootView, textView, textView2, textView3, textView4);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}