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
public final class RowHostelfeeDetailBinding implements ViewBinding {
    public final TextView hostRecycPayName;
    public final TextView hostRecycPayable;
    public final LinearLayout linearHost;
    private final LinearLayout rootView;

    private RowHostelfeeDetailBinding(LinearLayout rootView, TextView hostRecycPayName, TextView hostRecycPayable, LinearLayout linearHost) {
        this.rootView = rootView;
        this.hostRecycPayName = hostRecycPayName;
        this.hostRecycPayable = hostRecycPayable;
        this.linearHost = linearHost;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static RowHostelfeeDetailBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowHostelfeeDetailBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_hostelfee_detail, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowHostelfeeDetailBinding bind(View rootView) {
        int i = R.id.hostRecycPayName;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.hostRecycPayable;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                LinearLayout linearLayout = (LinearLayout) rootView;
                return new RowHostelfeeDetailBinding(linearLayout, textView, textView2, linearLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}