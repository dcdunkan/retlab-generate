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
public final class RowPositionSemBinding implements ViewBinding {
    public final TextView endDateTv;
    private final LinearLayout rootView;
    public final TextView startDateTv;
    public final TextView titleTv;

    private RowPositionSemBinding(LinearLayout rootView, TextView endDateTv, TextView startDateTv, TextView titleTv) {
        this.rootView = rootView;
        this.endDateTv = endDateTv;
        this.startDateTv = startDateTv;
        this.titleTv = titleTv;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static RowPositionSemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowPositionSemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_position_sem, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowPositionSemBinding bind(View rootView) {
        int i = R.id.end_date_tv;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.start_date_tv;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.title_tv;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView3 != null) {
                    return new RowPositionSemBinding((LinearLayout) rootView, textView, textView2, textView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}