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
public final class RowTransportHistoryBinding implements ViewBinding {
    public final LinearLayout linearHost;
    private final LinearLayout rootView;
    public final TextView transportAdjustmentTv;
    public final TextView transportAmountTv;
    public final TextView transportBalanceTv;
    public final TextView transportPaidTv;
    public final TextView transportParticularTv;

    private RowTransportHistoryBinding(LinearLayout rootView, LinearLayout linearHost, TextView transportAdjustmentTv, TextView transportAmountTv, TextView transportBalanceTv, TextView transportPaidTv, TextView transportParticularTv) {
        this.rootView = rootView;
        this.linearHost = linearHost;
        this.transportAdjustmentTv = transportAdjustmentTv;
        this.transportAmountTv = transportAmountTv;
        this.transportBalanceTv = transportBalanceTv;
        this.transportPaidTv = transportPaidTv;
        this.transportParticularTv = transportParticularTv;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static RowTransportHistoryBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowTransportHistoryBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_transport_history, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowTransportHistoryBinding bind(View rootView) {
        LinearLayout linearLayout = (LinearLayout) rootView;
        int i = R.id.transport_adjustment_tv;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.transport_amount_tv;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.transport_balance_tv;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView3 != null) {
                    i = R.id.transport_paid_tv;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView4 != null) {
                        i = R.id.transport_particular_tv;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView5 != null) {
                            return new RowTransportHistoryBinding(linearLayout, linearLayout, textView, textView2, textView3, textView4, textView5);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}