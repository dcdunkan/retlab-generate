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
public final class ItemDialogDateIndicatorBinding implements ViewBinding {
    public final View colorView;
    public final TextView eventNameView;
    private final LinearLayout rootView;

    private ItemDialogDateIndicatorBinding(LinearLayout rootView, View colorView, TextView eventNameView) {
        this.rootView = rootView;
        this.colorView = colorView;
        this.eventNameView = eventNameView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ItemDialogDateIndicatorBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ItemDialogDateIndicatorBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.item_dialog_date_indicator, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemDialogDateIndicatorBinding bind(View rootView) {
        int i = R.id.color_view;
        View findChildViewById = ViewBindings.findChildViewById(rootView, i);
        if (findChildViewById != null) {
            i = R.id.event_name_view;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                return new ItemDialogDateIndicatorBinding((LinearLayout) rootView, findChildViewById, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}