package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.etuwa.app.R;

/* loaded from: classes3.dex */
public final class FeeRecepitDialogBinding implements ViewBinding {
    public final TextView recieptFeeAmount;
    public final TextView recieptFeeBatch;
    public final TextView recieptFeeDate;
    public final LinearLayout recieptFeeLayout;
    public final TextView recieptFeeMethod;
    public final TextView recieptFeeReNo;
    public final TextView recieptFeeStatus;
    private final FrameLayout rootView;

    private FeeRecepitDialogBinding(FrameLayout rootView, TextView recieptFeeAmount, TextView recieptFeeBatch, TextView recieptFeeDate, LinearLayout recieptFeeLayout, TextView recieptFeeMethod, TextView recieptFeeReNo, TextView recieptFeeStatus) {
        this.rootView = rootView;
        this.recieptFeeAmount = recieptFeeAmount;
        this.recieptFeeBatch = recieptFeeBatch;
        this.recieptFeeDate = recieptFeeDate;
        this.recieptFeeLayout = recieptFeeLayout;
        this.recieptFeeMethod = recieptFeeMethod;
        this.recieptFeeReNo = recieptFeeReNo;
        this.recieptFeeStatus = recieptFeeStatus;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static FeeRecepitDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FeeRecepitDialogBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.fee_recepit_dialog, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static FeeRecepitDialogBinding bind(View rootView) {
        int i = R.id.reciept_fee_amount;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.reciept_fee_batch;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.reciept_fee_date;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView3 != null) {
                    i = R.id.reciept_fee_layout;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                    if (linearLayout != null) {
                        i = R.id.reciept_fee_method;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView4 != null) {
                            i = R.id.reciept_fee_re_no;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView5 != null) {
                                i = R.id.reciept_fee_status;
                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView6 != null) {
                                    return new FeeRecepitDialogBinding((FrameLayout) rootView, textView, textView2, textView3, linearLayout, textView4, textView5, textView6);
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