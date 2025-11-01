package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TableLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.etuwa.app.R;

/* loaded from: classes3.dex */
public final class FragmentAcademicFeeBinding implements ViewBinding {
    public final TableLayout feeLayout;
    private final FrameLayout rootView;

    private FragmentAcademicFeeBinding(FrameLayout rootView, TableLayout feeLayout) {
        this.rootView = rootView;
        this.feeLayout = feeLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static FragmentAcademicFeeBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentAcademicFeeBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.fragment_academic_fee, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentAcademicFeeBinding bind(View rootView) {
        int i = R.id.feeLayout;
        TableLayout tableLayout = (TableLayout) ViewBindings.findChildViewById(rootView, i);
        if (tableLayout != null) {
            return new FragmentAcademicFeeBinding((FrameLayout) rootView, tableLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}