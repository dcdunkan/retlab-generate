package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import in.etuwa.app.R;

/* JADX INFO: loaded from: classes3.dex */
public final class RowSessionSemListBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final MaterialButton sessionSem;

    private RowSessionSemListBinding(LinearLayout rootView, MaterialButton sessionSem) {
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
        View viewInflate = inflater.inflate(R.layout.row_session_sem_list, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static RowSessionSemListBinding bind(View rootView) {
        int i = R.id.session_sem;
        MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(rootView, i);
        if (materialButton != null) {
            return new RowSessionSemListBinding((LinearLayout) rootView, materialButton);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}