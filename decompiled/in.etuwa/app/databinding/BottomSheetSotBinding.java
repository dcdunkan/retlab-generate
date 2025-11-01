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
public final class BottomSheetSotBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final RadioButton sortAll;
    public final RadioGroup sortBtn;
    public final RadioButton sortNew;
    public final RadioButton sortOld;

    private BottomSheetSotBinding(LinearLayout rootView, RadioButton sortAll, RadioGroup sortBtn, RadioButton sortNew, RadioButton sortOld) {
        this.rootView = rootView;
        this.sortAll = sortAll;
        this.sortBtn = sortBtn;
        this.sortNew = sortNew;
        this.sortOld = sortOld;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BottomSheetSotBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BottomSheetSotBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.bottom_sheet_sot, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static BottomSheetSotBinding bind(View rootView) {
        int i = R.id.sort_all;
        RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(rootView, i);
        if (radioButton != null) {
            i = R.id.sortBtn;
            RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(rootView, i);
            if (radioGroup != null) {
                i = R.id.sort_new;
                RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(rootView, i);
                if (radioButton2 != null) {
                    i = R.id.sort_old;
                    RadioButton radioButton3 = (RadioButton) ViewBindings.findChildViewById(rootView, i);
                    if (radioButton3 != null) {
                        return new BottomSheetSotBinding((LinearLayout) rootView, radioButton, radioGroup, radioButton2, radioButton3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}