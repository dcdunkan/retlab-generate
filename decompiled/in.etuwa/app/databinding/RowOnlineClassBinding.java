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
public final class RowOnlineClassBinding implements ViewBinding {
    private final CardView rootView;
    public final TextView subjectClass;

    private RowOnlineClassBinding(CardView rootView, TextView subjectClass) {
        this.rootView = rootView;
        this.subjectClass = subjectClass;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static RowOnlineClassBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowOnlineClassBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_online_class, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowOnlineClassBinding bind(View rootView) {
        int i = R.id.subject_class;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            return new RowOnlineClassBinding((CardView) rootView, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}