package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Spinner;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.etuwa.app.R;

/* loaded from: classes3.dex */
public final class FragmentSearchDialogBinding implements ViewBinding {
    public final Spinner monSpin;
    private final FrameLayout rootView;
    public final Button searchBtn;
    public final Spinner semSpin;
    public final Spinner yearSpin;

    private FragmentSearchDialogBinding(FrameLayout rootView, Spinner monSpin, Button searchBtn, Spinner semSpin, Spinner yearSpin) {
        this.rootView = rootView;
        this.monSpin = monSpin;
        this.searchBtn = searchBtn;
        this.semSpin = semSpin;
        this.yearSpin = yearSpin;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static FragmentSearchDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentSearchDialogBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.fragment_search_dialog, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentSearchDialogBinding bind(View rootView) {
        int i = R.id.monSpin;
        Spinner spinner = (Spinner) ViewBindings.findChildViewById(rootView, i);
        if (spinner != null) {
            i = R.id.search_btn;
            Button button = (Button) ViewBindings.findChildViewById(rootView, i);
            if (button != null) {
                i = R.id.semSpin;
                Spinner spinner2 = (Spinner) ViewBindings.findChildViewById(rootView, i);
                if (spinner2 != null) {
                    i = R.id.yearSpin;
                    Spinner spinner3 = (Spinner) ViewBindings.findChildViewById(rootView, i);
                    if (spinner3 != null) {
                        return new FragmentSearchDialogBinding((FrameLayout) rootView, spinner, button, spinner2, spinner3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}