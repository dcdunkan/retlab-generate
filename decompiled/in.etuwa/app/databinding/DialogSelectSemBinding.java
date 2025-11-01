package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TableLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.etuwa.app.R;

/* loaded from: classes3.dex */
public final class DialogSelectSemBinding implements ViewBinding {
    public final ProgressBar progressBarUniv;
    private final FrameLayout rootView;
    public final TableLayout semListUniv;

    private DialogSelectSemBinding(FrameLayout rootView, ProgressBar progressBarUniv, TableLayout semListUniv) {
        this.rootView = rootView;
        this.progressBarUniv = progressBarUniv;
        this.semListUniv = semListUniv;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static DialogSelectSemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DialogSelectSemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.dialog_select_sem, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogSelectSemBinding bind(View rootView) {
        int i = R.id.progress_bar_univ;
        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, i);
        if (progressBar != null) {
            i = R.id.sem_list_univ;
            TableLayout tableLayout = (TableLayout) ViewBindings.findChildViewById(rootView, i);
            if (tableLayout != null) {
                return new DialogSelectSemBinding((FrameLayout) rootView, progressBar, tableLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}