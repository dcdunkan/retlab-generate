package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.etuwa.app.R;

/* loaded from: classes3.dex */
public final class RowViewSemSubHistoryBinding implements ViewBinding {
    public final LinearLayout container;
    public final LinearLayout mdcSubjectsContainer;
    public final LinearLayout minorSubjectsContainer;
    private final LinearLayout rootView;
    public final TextView semesterTv;
    public final TextView sgpaTv;

    private RowViewSemSubHistoryBinding(LinearLayout rootView, LinearLayout container, LinearLayout mdcSubjectsContainer, LinearLayout minorSubjectsContainer, TextView semesterTv, TextView sgpaTv) {
        this.rootView = rootView;
        this.container = container;
        this.mdcSubjectsContainer = mdcSubjectsContainer;
        this.minorSubjectsContainer = minorSubjectsContainer;
        this.semesterTv = semesterTv;
        this.sgpaTv = sgpaTv;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static RowViewSemSubHistoryBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowViewSemSubHistoryBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_view_sem_sub_history, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowViewSemSubHistoryBinding bind(View rootView) {
        LinearLayout linearLayout = (LinearLayout) rootView;
        int i = R.id.mdc_subjects_container;
        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
        if (linearLayout2 != null) {
            i = R.id.minor_subjects_container;
            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
            if (linearLayout3 != null) {
                i = R.id.semester_tv;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView != null) {
                    i = R.id.sgpa_tv;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView2 != null) {
                        return new RowViewSemSubHistoryBinding(linearLayout, linearLayout, linearLayout2, linearLayout3, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}