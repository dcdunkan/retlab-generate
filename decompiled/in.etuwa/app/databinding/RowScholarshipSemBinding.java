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
public final class RowScholarshipSemBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final TextView slNo;
    public final TextView titleTv;
    public final TextView typeTv;

    private RowScholarshipSemBinding(LinearLayout rootView, TextView slNo, TextView titleTv, TextView typeTv) {
        this.rootView = rootView;
        this.slNo = slNo;
        this.titleTv = titleTv;
        this.typeTv = typeTv;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static RowScholarshipSemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowScholarshipSemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_scholarship_sem, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowScholarshipSemBinding bind(View rootView) {
        int i = R.id.sl_no;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.title_tv;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.type_tv;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView3 != null) {
                    return new RowScholarshipSemBinding((LinearLayout) rootView, textView, textView2, textView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}