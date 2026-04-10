package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.card.MaterialCardView;
import in.etuwa.app.R;

/* JADX INFO: loaded from: classes3.dex */
public final class RowResultModuleTestBinding implements ViewBinding {
    public final View moduleIndicator;
    public final TextView resultModuleScore;
    public final TextView resultModuleSubject;
    private final MaterialCardView rootView;
    public final LinearLayout scoreContainer;

    private RowResultModuleTestBinding(MaterialCardView rootView, View moduleIndicator, TextView resultModuleScore, TextView resultModuleSubject, LinearLayout scoreContainer) {
        this.rootView = rootView;
        this.moduleIndicator = moduleIndicator;
        this.resultModuleScore = resultModuleScore;
        this.resultModuleSubject = resultModuleSubject;
        this.scoreContainer = scoreContainer;
    }

    @Override // androidx.viewbinding.ViewBinding
    public MaterialCardView getRoot() {
        return this.rootView;
    }

    public static RowResultModuleTestBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowResultModuleTestBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.row_result_module_test, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static RowResultModuleTestBinding bind(View rootView) {
        int i = R.id.module_indicator;
        View viewFindChildViewById = ViewBindings.findChildViewById(rootView, i);
        if (viewFindChildViewById != null) {
            i = R.id.result_module_score;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                i = R.id.result_module_subject;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView2 != null) {
                    i = R.id.score_container;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                    if (linearLayout != null) {
                        return new RowResultModuleTestBinding((MaterialCardView) rootView, viewFindChildViewById, textView, textView2, linearLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}