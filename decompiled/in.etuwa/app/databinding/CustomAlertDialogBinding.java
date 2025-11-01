package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.etuwa.app.R;

/* loaded from: classes3.dex */
public final class CustomAlertDialogBinding implements ViewBinding {
    public final Button btnOk;
    private final LinearLayout rootView;
    public final TextView tvMessage;

    private CustomAlertDialogBinding(LinearLayout rootView, Button btnOk, TextView tvMessage) {
        this.rootView = rootView;
        this.btnOk = btnOk;
        this.tvMessage = tvMessage;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static CustomAlertDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static CustomAlertDialogBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.custom_alert_dialog, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static CustomAlertDialogBinding bind(View rootView) {
        int i = R.id.btnOk;
        Button button = (Button) ViewBindings.findChildViewById(rootView, i);
        if (button != null) {
            i = R.id.tvMessage;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                return new CustomAlertDialogBinding((LinearLayout) rootView, button, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}