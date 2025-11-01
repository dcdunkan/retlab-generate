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
public final class RowSubjectPlanBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final TextView topicTv;

    private RowSubjectPlanBinding(LinearLayout rootView, TextView topicTv) {
        this.rootView = rootView;
        this.topicTv = topicTv;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static RowSubjectPlanBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowSubjectPlanBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_subject_plan, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowSubjectPlanBinding bind(View rootView) {
        int i = R.id.topic_tv;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            return new RowSubjectPlanBinding((LinearLayout) rootView, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}