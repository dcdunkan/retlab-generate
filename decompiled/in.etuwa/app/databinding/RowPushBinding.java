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
public final class RowPushBinding implements ViewBinding {
    public final CardView pushCardview;
    public final TextView pushDate;
    public final TextView pushMsg;
    public final TextView pushTime;
    public final TextView pushTitle;
    private final CardView rootView;

    private RowPushBinding(CardView rootView, CardView pushCardview, TextView pushDate, TextView pushMsg, TextView pushTime, TextView pushTitle) {
        this.rootView = rootView;
        this.pushCardview = pushCardview;
        this.pushDate = pushDate;
        this.pushMsg = pushMsg;
        this.pushTime = pushTime;
        this.pushTitle = pushTitle;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static RowPushBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowPushBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_push, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowPushBinding bind(View rootView) {
        CardView cardView = (CardView) rootView;
        int i = R.id.push_date;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.push_msg;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.push_time;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView3 != null) {
                    i = R.id.push_title;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView4 != null) {
                        return new RowPushBinding(cardView, cardView, textView, textView2, textView3, textView4);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}