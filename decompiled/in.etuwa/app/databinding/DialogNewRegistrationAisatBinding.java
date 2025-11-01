package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import in.etuwa.app.R;
import in.etuwa.app.ui.hostel.gcekhostel.registration.reregistration.ReRegistrationViewModel;

/* loaded from: classes3.dex */
public abstract class DialogNewRegistrationAisatBinding extends ViewDataBinding {
    public final TextView completionFileName;
    public final TextView completionSelect;

    @Bindable
    protected ReRegistrationViewModel mReRegistrationViewModel;
    public final TextView progressText;
    public final CardView progressView;
    public final LinearLayout receiptCard;
    public final TextView regTitle;
    public final TextView registerBtn;
    public final Spinner spinnerCatogory;
    public final Spinner spinnerPr;
    public final Spinner spinnerPre;
    public final Spinner spinnerPresentHostel;
    public final Spinner spinnerSemesterApplied;
    public final ProgressBar uploadProgressbar;

    public abstract void setReRegistrationViewModel(ReRegistrationViewModel reRegistrationViewModel);

    protected DialogNewRegistrationAisatBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView completionFileName, TextView completionSelect, TextView progressText, CardView progressView, LinearLayout receiptCard, TextView regTitle, TextView registerBtn, Spinner spinnerCatogory, Spinner spinnerPr, Spinner spinnerPre, Spinner spinnerPresentHostel, Spinner spinnerSemesterApplied, ProgressBar uploadProgressbar) {
        super(_bindingComponent, _root, _localFieldCount);
        this.completionFileName = completionFileName;
        this.completionSelect = completionSelect;
        this.progressText = progressText;
        this.progressView = progressView;
        this.receiptCard = receiptCard;
        this.regTitle = regTitle;
        this.registerBtn = registerBtn;
        this.spinnerCatogory = spinnerCatogory;
        this.spinnerPr = spinnerPr;
        this.spinnerPre = spinnerPre;
        this.spinnerPresentHostel = spinnerPresentHostel;
        this.spinnerSemesterApplied = spinnerSemesterApplied;
        this.uploadProgressbar = uploadProgressbar;
    }

    public ReRegistrationViewModel getReRegistrationViewModel() {
        return this.mReRegistrationViewModel;
    }

    public static DialogNewRegistrationAisatBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogNewRegistrationAisatBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (DialogNewRegistrationAisatBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_new_registration_aisat, root, attachToRoot, component);
    }

    public static DialogNewRegistrationAisatBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogNewRegistrationAisatBinding inflate(LayoutInflater inflater, Object component) {
        return (DialogNewRegistrationAisatBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_new_registration_aisat, null, false, component);
    }

    public static DialogNewRegistrationAisatBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogNewRegistrationAisatBinding bind(View view, Object component) {
        return (DialogNewRegistrationAisatBinding) bind(component, view, R.layout.dialog_new_registration_aisat);
    }
}