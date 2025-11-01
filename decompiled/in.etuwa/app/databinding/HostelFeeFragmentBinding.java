package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.etuwa.app.R;

/* loaded from: classes3.dex */
public final class HostelFeeFragmentBinding implements ViewBinding {
    public final TextView hFeeSearchBtn;
    public final TextView hostFeeAmount;
    public final TextView hostFeeFine;
    public final TextView hostPayMsg;
    public final TextView hostPayNext;
    public final TextView hostReciptDate;
    public final TextView hostTotPayebl;
    public final LinearLayout layoutPayable;
    public final LinearLayout methodLayout;
    public final RecyclerView recycHostelFee;
    private final FrameLayout rootView;
    public final Spinner spinnerHostelFeeMethod;
    public final Spinner spinnerHostelFeeMonth;
    public final Spinner spinnerHostelFeeYear;

    private HostelFeeFragmentBinding(FrameLayout rootView, TextView hFeeSearchBtn, TextView hostFeeAmount, TextView hostFeeFine, TextView hostPayMsg, TextView hostPayNext, TextView hostReciptDate, TextView hostTotPayebl, LinearLayout layoutPayable, LinearLayout methodLayout, RecyclerView recycHostelFee, Spinner spinnerHostelFeeMethod, Spinner spinnerHostelFeeMonth, Spinner spinnerHostelFeeYear) {
        this.rootView = rootView;
        this.hFeeSearchBtn = hFeeSearchBtn;
        this.hostFeeAmount = hostFeeAmount;
        this.hostFeeFine = hostFeeFine;
        this.hostPayMsg = hostPayMsg;
        this.hostPayNext = hostPayNext;
        this.hostReciptDate = hostReciptDate;
        this.hostTotPayebl = hostTotPayebl;
        this.layoutPayable = layoutPayable;
        this.methodLayout = methodLayout;
        this.recycHostelFee = recycHostelFee;
        this.spinnerHostelFeeMethod = spinnerHostelFeeMethod;
        this.spinnerHostelFeeMonth = spinnerHostelFeeMonth;
        this.spinnerHostelFeeYear = spinnerHostelFeeYear;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static HostelFeeFragmentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static HostelFeeFragmentBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.hostel_fee_fragment, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static HostelFeeFragmentBinding bind(View rootView) {
        int i = R.id.hFeeSearchBtn;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.hostFeeAmount;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.hostFeeFine;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView3 != null) {
                    i = R.id.hostPayMsg;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView4 != null) {
                        i = R.id.hostPayNext;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView5 != null) {
                            i = R.id.hostReciptDate;
                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView6 != null) {
                                i = R.id.hostTotPayebl;
                                TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView7 != null) {
                                    i = R.id.layoutPayable;
                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                    if (linearLayout != null) {
                                        i = R.id.method_layout;
                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                        if (linearLayout2 != null) {
                                            i = R.id.recyc_HostelFee;
                                            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                            if (recyclerView != null) {
                                                i = R.id.spinner_hostel_fee_method;
                                                Spinner spinner = (Spinner) ViewBindings.findChildViewById(rootView, i);
                                                if (spinner != null) {
                                                    i = R.id.spinnerHostelFeeMonth;
                                                    Spinner spinner2 = (Spinner) ViewBindings.findChildViewById(rootView, i);
                                                    if (spinner2 != null) {
                                                        i = R.id.spinnerHostelFeeYear;
                                                        Spinner spinner3 = (Spinner) ViewBindings.findChildViewById(rootView, i);
                                                        if (spinner3 != null) {
                                                            return new HostelFeeFragmentBinding((FrameLayout) rootView, textView, textView2, textView3, textView4, textView5, textView6, textView7, linearLayout, linearLayout2, recyclerView, spinner, spinner2, spinner3);
                                                        }
                                                    }
                                                }
                                            }
                                        }
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