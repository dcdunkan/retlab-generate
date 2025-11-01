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
public final class RowProgramOutcomeBinding implements ViewBinding {
    private final CardView rootView;
    public final TextView tvDescription;
    public final TextView tvHead;

    private RowProgramOutcomeBinding(CardView rootView, TextView tvDescription, TextView tvHead) {
        this.rootView = rootView;
        this.tvDescription = tvDescription;
        this.tvHead = tvHead;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static RowProgramOutcomeBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowProgramOutcomeBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_program_outcome, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowProgramOutcomeBinding bind(View rootView) {
        int i = R.id.tv_description;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.tv_head;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                return new RowProgramOutcomeBinding((CardView) rootView, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}