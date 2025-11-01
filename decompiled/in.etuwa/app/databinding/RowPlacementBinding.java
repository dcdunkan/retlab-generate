package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.etuwa.app.R;

/* loaded from: classes3.dex */
public final class RowPlacementBinding implements ViewBinding {
    public final TextView plApplyBtn;
    public final TextView plCompanyName;
    public final TextView plDate;
    public final TextView plDescription;
    public final TextView plLastDate;
    private final CardView rootView;

    private RowPlacementBinding(CardView rootView, TextView plApplyBtn, TextView plCompanyName, TextView plDate, TextView plDescription, TextView plLastDate) {
        this.rootView = rootView;
        this.plApplyBtn = plApplyBtn;
        this.plCompanyName = plCompanyName;
        this.plDate = plDate;
        this.plDescription = plDescription;
        this.plLastDate = plLastDate;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static RowPlacementBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowPlacementBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_placement, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowPlacementBinding bind(View rootView) {
        int i = R.id.pl_apply_btn;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.pl_company_name;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.pl_date;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView3 != null) {
                    i = R.id.pl_description;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView4 != null) {
                        i = R.id.pl_last_date;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView5 != null) {
                            return new RowPlacementBinding((CardView) rootView, textView, textView2, textView3, textView4, textView5);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}