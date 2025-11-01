package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
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
public abstract class DialogProfileUpdateBinding extends ViewDataBinding {
    public final TextView Title;
    public final TextInputEditText etAadharNo;
    public final EditText etDateOfBirth;
    public final TextInputEditText etFirstName;
    public final TextInputEditText etLastName;
    public final TextInputEditText etMiddleName;
    public final TextInputEditText etPlaceBirth;
    public final Button generalDetailsArrowBtn;

    @Bindable
    protected EditRegistrationViewModel mEditRegistrationViewModel;
    public final TextView personalDetails;
    public final LinearLayout profilePersonalExpandableView;
    public final TextView progressText;
    public final CardView progressView;
    public final Spinner spinnerGender;
    public final Spinner spinnerReligion;
    public final ProgressBar uploadProgressbar;

    public abstract void setEditRegistrationViewModel(EditRegistrationViewModel editRegistrationViewModel);

    protected DialogProfileUpdateBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView Title, TextInputEditText etAadharNo, EditText etDateOfBirth, TextInputEditText etFirstName, TextInputEditText etLastName, TextInputEditText etMiddleName, TextInputEditText etPlaceBirth, Button generalDetailsArrowBtn, TextView personalDetails, LinearLayout profilePersonalExpandableView, TextView progressText, CardView progressView, Spinner spinnerGender, Spinner spinnerReligion, ProgressBar uploadProgressbar) {
        super(_bindingComponent, _root, _localFieldCount);
        this.Title = Title;
        this.etAadharNo = etAadharNo;
        this.etDateOfBirth = etDateOfBirth;
        this.etFirstName = etFirstName;
        this.etLastName = etLastName;
        this.etMiddleName = etMiddleName;
        this.etPlaceBirth = etPlaceBirth;
        this.generalDetailsArrowBtn = generalDetailsArrowBtn;
        this.personalDetails = personalDetails;
        this.profilePersonalExpandableView = profilePersonalExpandableView;
        this.progressText = progressText;
        this.progressView = progressView;
        this.spinnerGender = spinnerGender;
        this.spinnerReligion = spinnerReligion;
        this.uploadProgressbar = uploadProgressbar;
    }

    public EditRegistrationViewModel getEditRegistrationViewModel() {
        return this.mEditRegistrationViewModel;
    }

    public static DialogProfileUpdateBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogProfileUpdateBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (DialogProfileUpdateBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_profile_update, root, attachToRoot, component);
    }

    public static DialogProfileUpdateBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogProfileUpdateBinding inflate(LayoutInflater inflater, Object component) {
        return (DialogProfileUpdateBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_profile_update, null, false, component);
    }

    public static DialogProfileUpdateBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogProfileUpdateBinding bind(View view, Object component) {
        return (DialogProfileUpdateBinding) bind(component, view, R.layout.dialog_profile_update);
    }
}