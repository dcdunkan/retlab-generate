package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.etuwa.app.R;
import in.etuwa.app.utils.CustomEditText;

/* loaded from: classes3.dex */
public final class RowApplyPreferenceSubRegBinding implements ViewBinding {
    private final CardView rootView;
    public final Spinner spinnerSubjects;
    public final TextView subNameTv;
    public final CustomEditText subjectMark;

    private RowApplyPreferenceSubRegBinding(CardView rootView, Spinner spinnerSubjects, TextView subNameTv, CustomEditText subjectMark) {
        this.rootView = rootView;
        this.spinnerSubjects = spinnerSubjects;
        this.subNameTv = subNameTv;
        this.subjectMark = subjectMark;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static RowApplyPreferenceSubRegBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowApplyPreferenceSubRegBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_apply_preference_sub_reg, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowApplyPreferenceSubRegBinding bind(View rootView) {
        int i = R.id.spinner_subjects;
        Spinner spinner = (Spinner) ViewBindings.findChildViewById(rootView, i);
        if (spinner != null) {
            i = R.id.sub_name_tv;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                i = R.id.subject_mark;
                CustomEditText customEditText = (CustomEditText) ViewBindings.findChildViewById(rootView, i);
                if (customEditText != null) {
                    return new RowApplyPreferenceSubRegBinding((CardView) rootView, spinner, textView, customEditText);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}