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
import in.etuwa.app.ui.hostel.gcekhostel.registration.newregistration.NewRegistrationViewModel;

/* loaded from: classes3.dex */
public abstract class DialogNewRegistrationBinding extends ViewDataBinding {
    public final LinearLayout completionCard;
    public final TextView completionFileName;
    public final TextView completionSelect;
    public final TextInputEditText etAnnualIncome;
    public final TextInputEditText etDistance;
    public final TextInputEditText etNameAddress;
    public final TextInputEditText etPhone;

    @Bindable
    protected NewRegistrationViewModel mNewRegistrationViewModel;
    public final TextView progressText;
    public final CardView progressView;
    public final TextView regTitle;
    public final TextView registerBtn;
    public final Spinner spinnerCatogory;
    public final Spinner spinnerReadmission;
    public final Spinner spinnerSemesterApplied;
    public final ProgressBar uploadProgressbar;

    public abstract void setNewRegistrationViewModel(NewRegistrationViewModel newRegistrationViewModel);

    protected DialogNewRegistrationBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout completionCard, TextView completionFileName, TextView completionSelect, TextInputEditText etAnnualIncome, TextInputEditText etDistance, TextInputEditText etNameAddress, TextInputEditText etPhone, TextView progressText, CardView progressView, TextView regTitle, TextView registerBtn, Spinner spinnerCatogory, Spinner spinnerReadmission, Spinner spinnerSemesterApplied, ProgressBar uploadProgressbar) {
        super(_bindingComponent, _root, _localFieldCount);
        this.completionCard = completionCard;
        this.completionFileName = completionFileName;
        this.completionSelect = completionSelect;
        this.etAnnualIncome = etAnnualIncome;
        this.etDistance = etDistance;
        this.etNameAddress = etNameAddress;
        this.etPhone = etPhone;
        this.progressText = progressText;
        this.progressView = progressView;
        this.regTitle = regTitle;
        this.registerBtn = registerBtn;
        this.spinnerCatogory = spinnerCatogory;
        this.spinnerReadmission = spinnerReadmission;
        this.spinnerSemesterApplied = spinnerSemesterApplied;
        this.uploadProgressbar = uploadProgressbar;
    }

    public NewRegistrationViewModel getNewRegistrationViewModel() {
        return this.mNewRegistrationViewModel;
    }

    public static DialogNewRegistrationBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogNewRegistrationBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (DialogNewRegistrationBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_new_registration, root, attachToRoot, component);
    }

    public static DialogNewRegistrationBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogNewRegistrationBinding inflate(LayoutInflater inflater, Object component) {
        return (DialogNewRegistrationBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_new_registration, null, false, component);
    }

    public static DialogNewRegistrationBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogNewRegistrationBinding bind(View view, Object component) {
        return (DialogNewRegistrationBinding) bind(component, view, R.layout.dialog_new_registration);
    }
}