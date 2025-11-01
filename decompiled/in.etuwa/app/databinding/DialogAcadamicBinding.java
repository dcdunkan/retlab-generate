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
public final class DialogAcadamicBinding implements ViewBinding {
    public final TextView acadaDialoPayAmount;
    public final TextView acadaDialoPayBal;
    public final TextView acadaDialoPayPaid;
    public final TextView acadaDialoPaySchol;
    public final TextView acadaDialoTotPayable;
    private final LinearLayout rootView;

    private DialogAcadamicBinding(LinearLayout rootView, TextView acadaDialoPayAmount, TextView acadaDialoPayBal, TextView acadaDialoPayPaid, TextView acadaDialoPaySchol, TextView acadaDialoTotPayable) {
        this.rootView = rootView;
        this.acadaDialoPayAmount = acadaDialoPayAmount;
        this.acadaDialoPayBal = acadaDialoPayBal;
        this.acadaDialoPayPaid = acadaDialoPayPaid;
        this.acadaDialoPaySchol = acadaDialoPaySchol;
        this.acadaDialoTotPayable = acadaDialoTotPayable;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DialogAcadamicBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DialogAcadamicBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.dialog_acadamic, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogAcadamicBinding bind(View rootView) {
        int i = R.id.acadaDialoPayAmount;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.acadaDialoPayBal;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.acadaDialoPayPaid;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView3 != null) {
                    i = R.id.acadaDialoPaySchol;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView4 != null) {
                        i = R.id.acadaDialoTotPayable;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView5 != null) {
                            return new DialogAcadamicBinding((LinearLayout) rootView, textView, textView2, textView3, textView4, textView5);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}