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
public final class RowLeaveTakenBinding implements ViewBinding {
    public final TextView leaveAvailable;
    public final TextView leaveTaken;
    public final TextView nameOfLeave;
    private final CardView rootView;

    private RowLeaveTakenBinding(CardView rootView, TextView leaveAvailable, TextView leaveTaken, TextView nameOfLeave) {
        this.rootView = rootView;
        this.leaveAvailable = leaveAvailable;
        this.leaveTaken = leaveTaken;
        this.nameOfLeave = nameOfLeave;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static RowLeaveTakenBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowLeaveTakenBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_leave_taken, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowLeaveTakenBinding bind(View rootView) {
        int i = R.id.leave_available;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.leave_taken;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.name_of_leave;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView3 != null) {
                    return new RowLeaveTakenBinding((CardView) rootView, textView, textView2, textView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}