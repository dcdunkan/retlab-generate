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
public final class RowSubRegListBinding implements ViewBinding {
    public final TextView appliedFrom;
    private final CardView rootView;
    public final TextView semCategory;
    public final TextView semDate;
    public final TextView statusBtn;
    public final TextView viewBtn;

    private RowSubRegListBinding(CardView rootView, TextView appliedFrom, TextView semCategory, TextView semDate, TextView statusBtn, TextView viewBtn) {
        this.rootView = rootView;
        this.appliedFrom = appliedFrom;
        this.semCategory = semCategory;
        this.semDate = semDate;
        this.statusBtn = statusBtn;
        this.viewBtn = viewBtn;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static RowSubRegListBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowSubRegListBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_sub_reg_list, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowSubRegListBinding bind(View rootView) {
        int i = R.id.applied_from;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.sem_category;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.sem_date;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView3 != null) {
                    i = R.id.status_btn;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView4 != null) {
                        i = R.id.view_btn;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView5 != null) {
                            return new RowSubRegListBinding((CardView) rootView, textView, textView2, textView3, textView4, textView5);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}