package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.etuwa.app.R;

/* loaded from: classes3.dex */
public final class FragmentAcadamicFeeNextBinding implements ViewBinding {
    public final TextView acadamicNextdate;
    public final TextView acadamicPayNow;
    public final TextView acadamicPaymentMethod;
    public final LinearLayout layoutPayConfirm;
    private final FrameLayout rootView;
    public final TableLayout tableAcadamicFeeConfirm;

    private FragmentAcadamicFeeNextBinding(FrameLayout rootView, TextView acadamicNextdate, TextView acadamicPayNow, TextView acadamicPaymentMethod, LinearLayout layoutPayConfirm, TableLayout tableAcadamicFeeConfirm) {
        this.rootView = rootView;
        this.acadamicNextdate = acadamicNextdate;
        this.acadamicPayNow = acadamicPayNow;
        this.acadamicPaymentMethod = acadamicPaymentMethod;
        this.layoutPayConfirm = layoutPayConfirm;
        this.tableAcadamicFeeConfirm = tableAcadamicFeeConfirm;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static FragmentAcadamicFeeNextBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentAcadamicFeeNextBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.fragment_acadamic_fee_next, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentAcadamicFeeNextBinding bind(View rootView) {
        int i = R.id.acadamicNextdate;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.acadamicPayNow;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.acadamic_payment_method;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView3 != null) {
                    i = R.id.layoutPayConfirm;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                    if (linearLayout != null) {
                        i = R.id.tableAcadamicFeeConfirm;
                        TableLayout tableLayout = (TableLayout) ViewBindings.findChildViewById(rootView, i);
                        if (tableLayout != null) {
                            return new FragmentAcadamicFeeNextBinding((FrameLayout) rootView, textView, textView2, textView3, linearLayout, tableLayout);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}