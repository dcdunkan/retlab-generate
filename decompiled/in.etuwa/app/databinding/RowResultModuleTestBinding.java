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
public final class RowResultModuleTestBinding implements ViewBinding {
    public final TextView resultModuleScore;
    public final TextView resultModuleSubject;
    private final CardView rootView;

    private RowResultModuleTestBinding(CardView rootView, TextView resultModuleScore, TextView resultModuleSubject) {
        this.rootView = rootView;
        this.resultModuleScore = resultModuleScore;
        this.resultModuleSubject = resultModuleSubject;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static RowResultModuleTestBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowResultModuleTestBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_result_module_test, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowResultModuleTestBinding bind(View rootView) {
        int i = R.id.result_module_score;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.result_module_subject;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                return new RowResultModuleTestBinding((CardView) rootView, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}