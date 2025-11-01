package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.etuwa.app.R;

/* loaded from: classes3.dex */
public final class FragmentAcadamicFeeListBinding implements ViewBinding {
    public final TextView acadamicPayMsg;
    public final TextView acadamicPayNext;
    public final TextView acadamicPayTotAmount;
    public final TextView acadamicPayTotBal;
    public final TextView acadamicPayTotPaid;
    public final TextView acadamicPayTotPayebl;
    public final TextView acadamicPayTotSchol;
    public final TextView acadamicReciptDate;
    public final RecyclerView recycPayment;
    private final FrameLayout rootView;
    public final Spinner spinnerFeeMethod;

    private FragmentAcadamicFeeListBinding(FrameLayout rootView, TextView acadamicPayMsg, TextView acadamicPayNext, TextView acadamicPayTotAmount, TextView acadamicPayTotBal, TextView acadamicPayTotPaid, TextView acadamicPayTotPayebl, TextView acadamicPayTotSchol, TextView acadamicReciptDate, RecyclerView recycPayment, Spinner spinnerFeeMethod) {
        this.rootView = rootView;
        this.acadamicPayMsg = acadamicPayMsg;
        this.acadamicPayNext = acadamicPayNext;
        this.acadamicPayTotAmount = acadamicPayTotAmount;
        this.acadamicPayTotBal = acadamicPayTotBal;
        this.acadamicPayTotPaid = acadamicPayTotPaid;
        this.acadamicPayTotPayebl = acadamicPayTotPayebl;
        this.acadamicPayTotSchol = acadamicPayTotSchol;
        this.acadamicReciptDate = acadamicReciptDate;
        this.recycPayment = recycPayment;
        this.spinnerFeeMethod = spinnerFeeMethod;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static FragmentAcadamicFeeListBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentAcadamicFeeListBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.fragment_acadamic_fee_list, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentAcadamicFeeListBinding bind(View rootView) {
        int i = R.id.acadamicPayMsg;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.acadamicPayNext;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.acadamicPayTotAmount;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView3 != null) {
                    i = R.id.acadamicPayTotBal;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView4 != null) {
                        i = R.id.acadamicPayTotPaid;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView5 != null) {
                            i = R.id.acadamicPayTotPayebl;
                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView6 != null) {
                                i = R.id.acadamicPayTotSchol;
                                TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView7 != null) {
                                    i = R.id.acadamicReciptDate;
                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView8 != null) {
                                        i = R.id.recyc_payment;
                                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                        if (recyclerView != null) {
                                            i = R.id.spinner_fee_method;
                                            Spinner spinner = (Spinner) ViewBindings.findChildViewById(rootView, i);
                                            if (spinner != null) {
                                                return new FragmentAcadamicFeeListBinding((FrameLayout) rootView, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, recyclerView, spinner);
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