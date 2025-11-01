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
public final class RowSubStatusBinding implements ViewBinding {
    public final TextView nameTv;
    private final LinearLayout rootView;
    public final TextView statusTv;

    private RowSubStatusBinding(LinearLayout rootView, TextView nameTv, TextView statusTv) {
        this.rootView = rootView;
        this.nameTv = nameTv;
        this.statusTv = statusTv;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static RowSubStatusBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowSubStatusBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_sub_status, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowSubStatusBinding bind(View rootView) {
        int i = R.id.name_tv;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.status_tv;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                return new RowSubStatusBinding((LinearLayout) rootView, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}