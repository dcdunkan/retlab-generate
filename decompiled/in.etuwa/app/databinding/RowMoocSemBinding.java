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
public final class RowMoocSemBinding implements ViewBinding {
    public final TextView fromDate;
    public final TextView organisedBy;
    private final LinearLayout rootView;
    public final TextView titleTv;
    public final TextView toDateTv;

    private RowMoocSemBinding(LinearLayout rootView, TextView fromDate, TextView organisedBy, TextView titleTv, TextView toDateTv) {
        this.rootView = rootView;
        this.fromDate = fromDate;
        this.organisedBy = organisedBy;
        this.titleTv = titleTv;
        this.toDateTv = toDateTv;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static RowMoocSemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowMoocSemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_mooc_sem, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowMoocSemBinding bind(View rootView) {
        int i = R.id.from_date;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.organised_by;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.title_tv;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView3 != null) {
                    i = R.id.to_date_tv;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView4 != null) {
                        return new RowMoocSemBinding((LinearLayout) rootView, textView, textView2, textView3, textView4);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}