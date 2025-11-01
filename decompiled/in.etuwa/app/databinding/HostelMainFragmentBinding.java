package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.etuwa.app.R;

/* loaded from: classes3.dex */
public final class HostelMainFragmentBinding implements ViewBinding {
    public final TextView hostelNewRegistration;
    public final TextView hostelPayBtn;
    public final TextView messGcekBtn;
    public final TextView receiptGcekBtn;
    private final FrameLayout rootView;

    private HostelMainFragmentBinding(FrameLayout rootView, TextView hostelNewRegistration, TextView hostelPayBtn, TextView messGcekBtn, TextView receiptGcekBtn) {
        this.rootView = rootView;
        this.hostelNewRegistration = hostelNewRegistration;
        this.hostelPayBtn = hostelPayBtn;
        this.messGcekBtn = messGcekBtn;
        this.receiptGcekBtn = receiptGcekBtn;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static HostelMainFragmentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static HostelMainFragmentBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.hostel_main_fragment, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static HostelMainFragmentBinding bind(View rootView) {
        int i = R.id.hostel_new_registration;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.hostel_pay_btn;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.mess_gcek_btn;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView3 != null) {
                    i = R.id.receipt_gcek_btn;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView4 != null) {
                        return new HostelMainFragmentBinding((FrameLayout) rootView, textView, textView2, textView3, textView4);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}