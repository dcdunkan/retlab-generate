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
import com.google.android.material.textfield.TextInputEditText;
import in.etuwa.app.R;
import in.etuwa.app.ui.hostel.gcekhostel.registration.reregistration.ReRegistrationViewModel;

/* loaded from: classes3.dex */
public abstract class DialogReRegistrationBinding extends ViewDataBinding {
    public final LinearLayout completionCard;
    public final TextView completionFileName;
    public final TextView completionSelect;
    public final TextInputEditText etAnnualIncome;
    public final TextInputEditText etDistance;
    public final TextInputEditText etDueDetails;
    public final TextInputEditText etFineDetails;
    public final TextInputEditText etHostelDetails;
    public final TextInputEditText etNameAddress;
    public final TextInputEditText etPhone;

    @Bindable
    protected ReRegistrationViewModel mReRegistrationViewModel;
    public final TextView progressText;
    public final CardView progressView;
    public final TextView regTitle;
    public final TextView registerBtn;
    public final Spinner spinnerBehaviour;
    public final Spinner spinnerCatogory;
    public final Spinner spinnerDefaulter;
    public final Spinner spinnerNoOfYear;
    public final Spinner spinnerPresentHostel;
    public final Spinner spinnerSemesterApplied;
    public final ProgressBar uploadProgressbar;

    public abstract void setReRegistrationViewModel(ReRegistrationViewModel reRegistrationViewModel);

    protected DialogReRegistrationBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout completionCard, TextView completionFileName, TextView completionSelect, TextInputEditText etAnnualIncome, TextInputEditText etDistance, TextInputEditText etDueDetails, TextInputEditText etFineDetails, TextInputEditText etHostelDetails, TextInputEditText etNameAddress, TextInputEditText etPhone, TextView progressText, CardView progressView, TextView regTitle, TextView registerBtn, Spinner spinnerBehaviour, Spinner spinnerCatogory, Spinner spinnerDefaulter, Spinner spinnerNoOfYear, Spinner spinnerPresentHostel, Spinner spinnerSemesterApplied, ProgressBar uploadProgressbar) {
        super(_bindingComponent, _root, _localFieldCount);
        this.completionCard = completionCard;
        this.completionFileName = completionFileName;
        this.completionSelect = completionSelect;
        this.etAnnualIncome = etAnnualIncome;
        this.etDistance = etDistance;
        this.etDueDetails = etDueDetails;
        this.etFineDetails = etFineDetails;
        this.etHostelDetails = etHostelDetails;
        this.etNameAddress = etNameAddress;
        this.etPhone = etPhone;
        this.progressText = progressText;
        this.progressView = progressView;
        this.regTitle = regTitle;
        this.registerBtn = registerBtn;
        this.spinnerBehaviour = spinnerBehaviour;
        this.spinnerCatogory = spinnerCatogory;
        this.spinnerDefaulter = spinnerDefaulter;
        this.spinnerNoOfYear = spinnerNoOfYear;
        this.spinnerPresentHostel = spinnerPresentHostel;
        this.spinnerSemesterApplied = spinnerSemesterApplied;
        this.uploadProgressbar = uploadProgressbar;
    }

    public ReRegistrationViewModel getReRegistrationViewModel() {
        return this.mReRegistrationViewModel;
    }

    public static DialogReRegistrationBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogReRegistrationBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (DialogReRegistrationBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_re_registration, root, attachToRoot, component);
    }

    public static DialogReRegistrationBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogReRegistrationBinding inflate(LayoutInflater inflater, Object component) {
        return (DialogReRegistrationBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_re_registration, null, false, component);
    }

    public static DialogReRegistrationBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogReRegistrationBinding bind(View view, Object component) {
        return (DialogReRegistrationBinding) bind(component, view, R.layout.dialog_re_registration);
    }
}