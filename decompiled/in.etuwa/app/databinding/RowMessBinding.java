package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.etuwa.app.R;

/* loaded from: classes3.dex */
public final class RowMessBinding implements ViewBinding {
    public final LinearLayout linearArtsFee;
    public final TextView messBreakfast;
    public final TextView messDinner;
    public final TextView messLunch;
    public final TextView messSnacks;
    public final TextView messType;
    private final CardView rootView;

    private RowMessBinding(CardView rootView, LinearLayout linearArtsFee, TextView messBreakfast, TextView messDinner, TextView messLunch, TextView messSnacks, TextView messType) {
        this.rootView = rootView;
        this.linearArtsFee = linearArtsFee;
        this.messBreakfast = messBreakfast;
        this.messDinner = messDinner;
        this.messLunch = messLunch;
        this.messSnacks = messSnacks;
        this.messType = messType;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static RowMessBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowMessBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_mess, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowMessBinding bind(View rootView) {
        int i = R.id.linearArtsFee;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
        if (linearLayout != null) {
            i = R.id.mess_breakfast;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                i = R.id.mess_dinner;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView2 != null) {
                    i = R.id.mess_lunch;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView3 != null) {
                        i = R.id.mess_snacks;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView4 != null) {
                            i = R.id.mess_type;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView5 != null) {
                                return new RowMessBinding((CardView) rootView, linearLayout, textView, textView2, textView3, textView4, textView5);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}