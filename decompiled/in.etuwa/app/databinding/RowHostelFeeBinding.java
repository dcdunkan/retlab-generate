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
public final class RowHostelFeeBinding implements ViewBinding {
    public final CardView cardHostel;
    public final TextView hostelReDate;
    public final TextView hostelReNo;
    private final CardView rootView;

    private RowHostelFeeBinding(CardView rootView, CardView cardHostel, TextView hostelReDate, TextView hostelReNo) {
        this.rootView = rootView;
        this.cardHostel = cardHostel;
        this.hostelReDate = hostelReDate;
        this.hostelReNo = hostelReNo;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static RowHostelFeeBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowHostelFeeBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_hostel_fee, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowHostelFeeBinding bind(View rootView) {
        CardView cardView = (CardView) rootView;
        int i = R.id.hostelReDate;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.hostelReNo;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                return new RowHostelFeeBinding(cardView, cardView, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}