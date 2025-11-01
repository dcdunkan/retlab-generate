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
public final class RowCentralizedInfoBinding implements ViewBinding {
    public final CardView cardInfo;
    public final TextView infoDate;
    public final TextView infoTitle;
    public final TextView infoType;
    private final CardView rootView;

    private RowCentralizedInfoBinding(CardView rootView, CardView cardInfo, TextView infoDate, TextView infoTitle, TextView infoType) {
        this.rootView = rootView;
        this.cardInfo = cardInfo;
        this.infoDate = infoDate;
        this.infoTitle = infoTitle;
        this.infoType = infoType;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static RowCentralizedInfoBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowCentralizedInfoBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_centralized_info, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowCentralizedInfoBinding bind(View rootView) {
        CardView cardView = (CardView) rootView;
        int i = R.id.info_date;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.info_title;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.info_type;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView3 != null) {
                    return new RowCentralizedInfoBinding(cardView, cardView, textView, textView2, textView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}