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
public final class RowLiveTvBinding implements ViewBinding {
    public final CardView cardLive;
    public final TextView liveDate;
    public final TextView liveDetails;
    public final TextView liveTitle;
    public final TextView liveType;
    private final CardView rootView;

    private RowLiveTvBinding(CardView rootView, CardView cardLive, TextView liveDate, TextView liveDetails, TextView liveTitle, TextView liveType) {
        this.rootView = rootView;
        this.cardLive = cardLive;
        this.liveDate = liveDate;
        this.liveDetails = liveDetails;
        this.liveTitle = liveTitle;
        this.liveType = liveType;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static RowLiveTvBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowLiveTvBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_live_tv, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowLiveTvBinding bind(View rootView) {
        CardView cardView = (CardView) rootView;
        int i = R.id.live_date;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.live_details;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.live_title;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView3 != null) {
                    i = R.id.live_type;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView4 != null) {
                        return new RowLiveTvBinding(cardView, cardView, textView, textView2, textView3, textView4);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}