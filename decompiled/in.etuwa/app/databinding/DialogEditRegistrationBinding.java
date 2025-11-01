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
import in.etuwa.app.ui.hostel.gcekhostel.registration.editregistration.EditRegistrationViewModel;

/* loaded from: classes3.dex */
public abstract class DialogEditRegistrationBinding extends ViewDataBinding {
    public final LinearLayout completionCard;
    public final TextView completionFileName;
    public final TextView completionSelect;
    public final TextInputEditText etAnnualIncome;
    public final TextInputEditText etDistance;
    public final TextInputEditText etNameAddress;
    public final TextInputEditText etPhone;

    @Bindable
    protected EditRegistrationViewModel mEditRegistrationViewModel;
    public final TextView progressText;
    public final CardView progressView;
    public final TextView regTitle;
    public final TextView registerBtn;
    public final Spinner spinnerCatogory;
    public final Spinner spinnerReadmission;
    public final Spinner spinnerSemesterApplied;
    public final ProgressBar uploadProgressbar;

    public abstract void setEditRegistrationViewModel(EditRegistrationViewModel editRegistrationViewModel);

    protected DialogEditRegistrationBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout completionCard, TextView completionFileName, TextView completionSelect, TextInputEditText etAnnualIncome, TextInputEditText etDistance, TextInputEditText etNameAddress, TextInputEditText etPhone, TextView progressText, CardView progressView, TextView regTitle, TextView registerBtn, Spinner spinnerCatogory, Spinner spinnerReadmission, Spinner spinnerSemesterApplied, ProgressBar uploadProgressbar) {
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

    public EditRegistrationViewModel getEditRegistrationViewModel() {
        return this.mEditRegistrationViewModel;
    }

    public static DialogEditRegistrationBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogEditRegistrationBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (DialogEditRegistrationBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_edit_registration, root, attachToRoot, component);
    }

    public static DialogEditRegistrationBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogEditRegistrationBinding inflate(LayoutInflater inflater, Object component) {
        return (DialogEditRegistrationBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_edit_registration, null, false, component);
    }

    public static DialogEditRegistrationBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogEditRegistrationBinding bind(View view, Object component) {
        return (DialogEditRegistrationBinding) bind(component, view, R.layout.dialog_edit_registration);
    }
}