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
public final class FragmentHostelNextBinding implements ViewBinding {
    public final TextView hostelPayNextdate;
    public final TextView hostelPayNow;
    public final TextView hostelPaymentMethod;
    public final LinearLayout layoutPayConfirm;
    private final FrameLayout rootView;
    public final TableLayout tableLayoutFeeConfirm;

    private FragmentHostelNextBinding(FrameLayout rootView, TextView hostelPayNextdate, TextView hostelPayNow, TextView hostelPaymentMethod, LinearLayout layoutPayConfirm, TableLayout tableLayoutFeeConfirm) {
        this.rootView = rootView;
        this.hostelPayNextdate = hostelPayNextdate;
        this.hostelPayNow = hostelPayNow;
        this.hostelPaymentMethod = hostelPaymentMethod;
        this.layoutPayConfirm = layoutPayConfirm;
        this.tableLayoutFeeConfirm = tableLayoutFeeConfirm;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static FragmentHostelNextBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentHostelNextBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.fragment_hostel_next, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentHostelNextBinding bind(View rootView) {
        int i = R.id.hostelPayNextdate;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.hostelPayNow;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.hostel_payment_method;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView3 != null) {
                    i = R.id.layoutPayConfirm;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                    if (linearLayout != null) {
                        i = R.id.tableLayoutFeeConfirm;
                        TableLayout tableLayout = (TableLayout) ViewBindings.findChildViewById(rootView, i);
                        if (tableLayout != null) {
                            return new FragmentHostelNextBinding((FrameLayout) rootView, textView, textView2, textView3, linearLayout, tableLayout);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}