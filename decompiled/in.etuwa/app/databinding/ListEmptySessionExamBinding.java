package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import in.etuwa.app.R;

/* JADX INFO: loaded from: classes3.dex */
public final class ListEmptySessionExamBinding implements ViewBinding {
    private final TextView rootView;

    private ListEmptySessionExamBinding(TextView rootView) {
        this.rootView = rootView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public TextView getRoot() {
        return this.rootView;
    }

    public static ListEmptySessionExamBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ListEmptySessionExamBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.list_empty_session_exam, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ListEmptySessionExamBinding bind(View rootView) {
        if (rootView == null) {
            throw new NullPointerException("rootView");
        }
        return new ListEmptySessionExamBinding((TextView) rootView);
    }
}