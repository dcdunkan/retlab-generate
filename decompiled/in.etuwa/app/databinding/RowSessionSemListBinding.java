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
public final class RowSessionSemListBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final TextView sessionSem;

    private RowSessionSemListBinding(LinearLayout rootView, TextView sessionSem) {
        this.rootView = rootView;
        this.sessionSem = sessionSem;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static RowSessionSemListBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowSessionSemListBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_session_sem_list, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowSessionSemListBinding bind(View rootView) {
        int i = R.id.session_sem;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            return new RowSessionSemListBinding((LinearLayout) rootView, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}