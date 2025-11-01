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
public final class ShowHostelFeeBinding implements ViewBinding {
    public final TextView hostdialPayable;
    public final TextView hostdiloPayAmount;
    public final TextView hostdiloPaySchol;
    private final LinearLayout rootView;

    private ShowHostelFeeBinding(LinearLayout rootView, TextView hostdialPayable, TextView hostdiloPayAmount, TextView hostdiloPaySchol) {
        this.rootView = rootView;
        this.hostdialPayable = hostdialPayable;
        this.hostdiloPayAmount = hostdiloPayAmount;
        this.hostdiloPaySchol = hostdiloPaySchol;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ShowHostelFeeBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ShowHostelFeeBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.show_hostel_fee, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static ShowHostelFeeBinding bind(View rootView) {
        int i = R.id.hostdialPayable;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.hostdiloPayAmount;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.hostdiloPaySchol;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView3 != null) {
                    return new ShowHostelFeeBinding((LinearLayout) rootView, textView, textView2, textView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}