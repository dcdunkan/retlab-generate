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
public final class RowViewSubRegBinding implements ViewBinding {
    public final TextView categoryNameTv;
    public final LinearLayout container;
    private final LinearLayout rootView;
    public final LinearLayout subjectsContainer;

    private RowViewSubRegBinding(LinearLayout rootView, TextView categoryNameTv, LinearLayout container, LinearLayout subjectsContainer) {
        this.rootView = rootView;
        this.categoryNameTv = categoryNameTv;
        this.container = container;
        this.subjectsContainer = subjectsContainer;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static RowViewSubRegBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowViewSubRegBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_view_sub_reg, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowViewSubRegBinding bind(View rootView) {
        int i = R.id.category_name_tv;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            LinearLayout linearLayout = (LinearLayout) rootView;
            int i2 = R.id.subjects_container;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, i2);
            if (linearLayout2 != null) {
                return new RowViewSubRegBinding(linearLayout, textView, linearLayout, linearLayout2);
            }
            i = i2;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}