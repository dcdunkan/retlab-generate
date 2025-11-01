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
public final class RowActivityManageBinding implements ViewBinding {
    public final TextView manageActivityBtn;
    public final TextView manageActivityName;
    public final TextView manageActivityPoint;
    public final TextView manageActivitySem;
    public final TextView manageDetails;
    public final TextView manageStatus;
    private final CardView rootView;

    private RowActivityManageBinding(CardView rootView, TextView manageActivityBtn, TextView manageActivityName, TextView manageActivityPoint, TextView manageActivitySem, TextView manageDetails, TextView manageStatus) {
        this.rootView = rootView;
        this.manageActivityBtn = manageActivityBtn;
        this.manageActivityName = manageActivityName;
        this.manageActivityPoint = manageActivityPoint;
        this.manageActivitySem = manageActivitySem;
        this.manageDetails = manageDetails;
        this.manageStatus = manageStatus;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static RowActivityManageBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowActivityManageBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_activity_manage, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowActivityManageBinding bind(View rootView) {
        int i = R.id.manage_activity_btn;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.manage_activity_name;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.manage_activity_point;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView3 != null) {
                    i = R.id.manage_activity_sem;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView4 != null) {
                        i = R.id.manage_details;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView5 != null) {
                            i = R.id.manage_status;
                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView6 != null) {
                                return new RowActivityManageBinding((CardView) rootView, textView, textView2, textView3, textView4, textView5, textView6);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}