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
public final class ShowHostelReciptBinding implements ViewBinding {
    public final TextView hostReAmount;
    public final TextView hostReDate;
    public final TextView hostReHostel;
    public final TextView hostReInst;
    public final TextView hostReNo;
    private final LinearLayout rootView;

    private ShowHostelReciptBinding(LinearLayout rootView, TextView hostReAmount, TextView hostReDate, TextView hostReHostel, TextView hostReInst, TextView hostReNo) {
        this.rootView = rootView;
        this.hostReAmount = hostReAmount;
        this.hostReDate = hostReDate;
        this.hostReHostel = hostReHostel;
        this.hostReInst = hostReInst;
        this.hostReNo = hostReNo;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ShowHostelReciptBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ShowHostelReciptBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.show_hostel_recipt, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static ShowHostelReciptBinding bind(View rootView) {
        int i = R.id.hostReAmount;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.hostReDate;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.hostReHostel;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView3 != null) {
                    i = R.id.hostReInst;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView4 != null) {
                        i = R.id.hostReNo;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView5 != null) {
                            return new ShowHostelReciptBinding((LinearLayout) rootView, textView, textView2, textView3, textView4, textView5);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}