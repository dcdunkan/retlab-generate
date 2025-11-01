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
public final class RowCourseOutcomesBinding implements ViewBinding {
    public final TextView coId;
    public final TextView coTopic;
    private final CardView rootView;

    private RowCourseOutcomesBinding(CardView rootView, TextView coId, TextView coTopic) {
        this.rootView = rootView;
        this.coId = coId;
        this.coTopic = coTopic;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static RowCourseOutcomesBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowCourseOutcomesBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_course_outcomes, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowCourseOutcomesBinding bind(View rootView) {
        int i = R.id.co_id;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.co_topic;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                return new RowCourseOutcomesBinding((CardView) rootView, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}