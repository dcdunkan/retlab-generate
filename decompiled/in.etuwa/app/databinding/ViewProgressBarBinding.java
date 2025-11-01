package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import in.etuwa.app.R;

/* loaded from: classes3.dex */
public final class ViewProgressBarBinding implements ViewBinding {
    public final ConstraintLayout progressBar;
    private final ConstraintLayout rootView;

    private ViewProgressBarBinding(ConstraintLayout rootView, ConstraintLayout progressBar) {
        this.rootView = rootView;
        this.progressBar = progressBar;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewProgressBarBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ViewProgressBarBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.view_progress_bar, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewProgressBarBinding bind(View rootView) {
        if (rootView == null) {
            throw new NullPointerException("rootView");
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
        return new ViewProgressBarBinding(constraintLayout, constraintLayout);
    }
}