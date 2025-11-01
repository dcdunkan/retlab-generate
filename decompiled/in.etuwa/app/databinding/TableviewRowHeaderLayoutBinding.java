package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.etuwa.app.R;

/* loaded from: classes3.dex */
public final class TableviewRowHeaderLayoutBinding implements ViewBinding {
    public final RelativeLayout root;
    private final RelativeLayout rootView;
    public final LinearLayout rowHeaderContainer;
    public final TextView rowHeaderTextview;

    private TableviewRowHeaderLayoutBinding(RelativeLayout rootView, RelativeLayout root, LinearLayout rowHeaderContainer, TextView rowHeaderTextview) {
        this.rootView = rootView;
        this.root = root;
        this.rowHeaderContainer = rowHeaderContainer;
        this.rowHeaderTextview = rowHeaderTextview;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static TableviewRowHeaderLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static TableviewRowHeaderLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.tableview_row_header_layout, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static TableviewRowHeaderLayoutBinding bind(View rootView) {
        RelativeLayout relativeLayout = (RelativeLayout) rootView;
        int i = R.id.row_header_container;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
        if (linearLayout != null) {
            i = R.id.row_header_textview;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                return new TableviewRowHeaderLayoutBinding(relativeLayout, relativeLayout, linearLayout, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}