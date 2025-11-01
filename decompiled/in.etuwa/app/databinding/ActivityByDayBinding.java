package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import in.etuwa.app.R;

/* loaded from: classes3.dex */
public final class ActivityByDayBinding implements ViewBinding {
    public final LinearLayout attLl;
    public final FloatingActionButton fabDate;
    private final RelativeLayout rootView;

    private ActivityByDayBinding(RelativeLayout rootView, LinearLayout attLl, FloatingActionButton fabDate) {
        this.rootView = rootView;
        this.attLl = attLl;
        this.fabDate = fabDate;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityByDayBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityByDayBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.activity_by_day, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityByDayBinding bind(View rootView) {
        int i = R.id.att_ll;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
        if (linearLayout != null) {
            i = R.id.fab_date;
            FloatingActionButton floatingActionButton = (FloatingActionButton) ViewBindings.findChildViewById(rootView, i);
            if (floatingActionButton != null) {
                return new ActivityByDayBinding((RelativeLayout) rootView, linearLayout, floatingActionButton);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}