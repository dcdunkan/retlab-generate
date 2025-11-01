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
public final class RowLabSafetyBinding implements ViewBinding {
    private final CardView rootView;
    public final TextView safetyNumber;
    public final TextView safetyText;

    private RowLabSafetyBinding(CardView rootView, TextView safetyNumber, TextView safetyText) {
        this.rootView = rootView;
        this.safetyNumber = safetyNumber;
        this.safetyText = safetyText;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static RowLabSafetyBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowLabSafetyBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_lab_safety, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowLabSafetyBinding bind(View rootView) {
        int i = R.id.safety_number;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.safety_text;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                return new RowLabSafetyBinding((CardView) rootView, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}