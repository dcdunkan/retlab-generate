package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.card.MaterialCardView;
import in.etuwa.app.R;

/* JADX INFO: loaded from: classes3.dex */
public final class RowUnivSubjectsBinding implements ViewBinding {
    private final MaterialCardView rootView;
    public final TextView univStatus;
    public final TextView univSubject;

    private RowUnivSubjectsBinding(MaterialCardView rootView, TextView univStatus, TextView univSubject) {
        this.rootView = rootView;
        this.univStatus = univStatus;
        this.univSubject = univSubject;
    }

    @Override // androidx.viewbinding.ViewBinding
    public MaterialCardView getRoot() {
        return this.rootView;
    }

    public static RowUnivSubjectsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowUnivSubjectsBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.row_univ_subjects, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static RowUnivSubjectsBinding bind(View rootView) {
        int i = R.id.univ_status;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.univ_subject;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                return new RowUnivSubjectsBinding((MaterialCardView) rootView, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}