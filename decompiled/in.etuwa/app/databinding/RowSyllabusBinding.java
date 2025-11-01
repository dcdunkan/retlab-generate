package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.etuwa.app.R;

/* loaded from: classes3.dex */
public final class RowSyllabusBinding implements ViewBinding {
    public final TextView module;
    private final CardView rootView;
    public final LinearLayout topicView2;

    private RowSyllabusBinding(CardView rootView, TextView module, LinearLayout topicView2) {
        this.rootView = rootView;
        this.module = module;
        this.topicView2 = topicView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static RowSyllabusBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowSyllabusBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_syllabus, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowSyllabusBinding bind(View rootView) {
        int i = R.id.module;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.topic_view2;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
            if (linearLayout != null) {
                return new RowSyllabusBinding((CardView) rootView, textView, linearLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}