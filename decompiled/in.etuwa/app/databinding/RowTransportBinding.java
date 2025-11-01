package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.etuwa.app.R;

/* loaded from: classes3.dex */
public final class RowTransportBinding implements ViewBinding {
    public final CheckBox feeTransportCheckBox;
    public final LinearLayout linearHost;
    private final LinearLayout rootView;
    public final TextView transportAdjustmentTv;
    public final TextView transportAmountTv;
    public final TextView transportBalanceTv;
    public final TextView transportPaidTv;
    public final TextView transportParticularTv;
    public final TextView transportParticularTvPaid;
    public final TextView transportStatusTv;

    private RowTransportBinding(LinearLayout rootView, CheckBox feeTransportCheckBox, LinearLayout linearHost, TextView transportAdjustmentTv, TextView transportAmountTv, TextView transportBalanceTv, TextView transportPaidTv, TextView transportParticularTv, TextView transportParticularTvPaid, TextView transportStatusTv) {
        this.rootView = rootView;
        this.feeTransportCheckBox = feeTransportCheckBox;
        this.linearHost = linearHost;
        this.transportAdjustmentTv = transportAdjustmentTv;
        this.transportAmountTv = transportAmountTv;
        this.transportBalanceTv = transportBalanceTv;
        this.transportPaidTv = transportPaidTv;
        this.transportParticularTv = transportParticularTv;
        this.transportParticularTvPaid = transportParticularTvPaid;
        this.transportStatusTv = transportStatusTv;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static RowTransportBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowTransportBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_transport, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowTransportBinding bind(View rootView) {
        int i = R.id.fee_transport_check_box;
        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(rootView, i);
        if (checkBox != null) {
            LinearLayout linearLayout = (LinearLayout) rootView;
            i = R.id.transport_adjustment_tv;
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
                                i = R.id.transport_particular_tv_paid;
                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView6 != null) {
                                    i = R.id.transport_status_tv;
                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView7 != null) {
                                        return new RowTransportBinding(linearLayout, checkBox, linearLayout, textView, textView2, textView3, textView4, textView5, textView6, textView7);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}