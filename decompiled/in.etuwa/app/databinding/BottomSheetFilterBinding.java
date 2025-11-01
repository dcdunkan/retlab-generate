package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.etuwa.app.R;

/* loaded from: classes3.dex */
public final class BottomSheetFilterBinding implements ViewBinding {
    public final RadioButton filterAll;
    public final RadioGroup filterGroup;
    public final RadioButton filterNotsubmited;
    public final RadioButton filterSubmited;
    private final LinearLayout rootView;

    private BottomSheetFilterBinding(LinearLayout rootView, RadioButton filterAll, RadioGroup filterGroup, RadioButton filterNotsubmited, RadioButton filterSubmited) {
        this.rootView = rootView;
        this.filterAll = filterAll;
        this.filterGroup = filterGroup;
        this.filterNotsubmited = filterNotsubmited;
        this.filterSubmited = filterSubmited;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BottomSheetFilterBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BottomSheetFilterBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.bottom_sheet_filter, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static BottomSheetFilterBinding bind(View rootView) {
        int i = R.id.filter_all;
        RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(rootView, i);
        if (radioButton != null) {
            i = R.id.filter_group;
            RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(rootView, i);
            if (radioGroup != null) {
                i = R.id.filter_notsubmited;
                RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(rootView, i);
                if (radioButton2 != null) {
                    i = R.id.filter_submited;
                    RadioButton radioButton3 = (RadioButton) ViewBindings.findChildViewById(rootView, i);
                    if (radioButton3 != null) {
                        return new BottomSheetFilterBinding((LinearLayout) rootView, radioButton, radioGroup, radioButton2, radioButton3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}