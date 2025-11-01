package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import in.etuwa.app.R;

/* loaded from: classes3.dex */
public final class RowFeeListBinding implements ViewBinding {
    private final ConstraintLayout rootView;

    private RowFeeListBinding(ConstraintLayout rootView) {
        this.rootView = rootView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static RowFeeListBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowFeeListBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_fee_list, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowFeeListBinding bind(View rootView) {
        if (rootView == null) {
            throw new NullPointerException("rootView");
        }
        return new RowFeeListBinding((ConstraintLayout) rootView);
    }
}