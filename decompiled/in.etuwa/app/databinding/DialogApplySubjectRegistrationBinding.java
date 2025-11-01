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
import in.etuwa.app.ui.subjectregistration.apply.ApplySubjectRegistrationViewModel;

/* loaded from: classes3.dex */
public abstract class DialogApplySubjectRegistrationBinding extends ViewDataBinding {
    public final LinearLayout additionalElective1Lyt;
    public final LinearLayout additionalElective2Lyt;
    public final LinearLayout additionalElective3Lyt;
    public final LinearLayout aec1Lyt;
    public final LinearLayout aec2Lyt;
    public final LinearLayout aec3Lyt;
    public final LinearLayout dsc1Lyt;
    public final LinearLayout dsc2Lyt;
    public final LinearLayout dsc3Lyt;
    public final LinearLayout elective1Lyt;
    public final LinearLayout elective2Lyt;
    public final LinearLayout elective3Lyt;
    public final LinearLayout globalElectiveLyt;
    public final LinearLayout honourLyt;

    @Bindable
    protected ApplySubjectRegistrationViewModel mApplySubjectRegistrationViewModel;
    public final LinearLayout mdc1Lyt;
    public final LinearLayout mdc2Lyt;
    public final LinearLayout mdc3Lyt;
    public final LinearLayout minor2Lyt;
    public final LinearLayout minor3Lyt;
    public final LinearLayout minorLyt;
    public final TextView progressText;
    public final CardView progressView;
    public final TextView registerBtn;
    public final LinearLayout semesterLyt;
    public final TextView semesterTv;
    public final Spinner spinnerAdditionalElective1;
    public final Spinner spinnerAdditionalElective2;
    public final Spinner spinnerAdditionalElective3;
    public final Spinner spinnerAec1;
    public final Spinner spinnerAec2;
    public final Spinner spinnerAec3;
    public final Spinner spinnerDsc1;
    public final Spinner spinnerDsc2;
    public final Spinner spinnerDsc3;
    public final Spinner spinnerElective1;
    public final Spinner spinnerElective2;
    public final Spinner spinnerElective3;
    public final Spinner spinnerGlobalElective;
    public final Spinner spinnerHonour;
    public final Spinner spinnerMdc1;
    public final Spinner spinnerMdc2;
    public final Spinner spinnerMdc3;
    public final Spinner spinnerMinor;
    public final Spinner spinnerMinor2;
    public final Spinner spinnerMinor3;
    public final Spinner spinnerSemesterLastAttended;
    public final ProgressBar uploadProgressbar;

    public abstract void setApplySubjectRegistrationViewModel(ApplySubjectRegistrationViewModel applySubjectRegistrationViewModel);

    protected DialogApplySubjectRegistrationBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout additionalElective1Lyt, LinearLayout additionalElective2Lyt, LinearLayout additionalElective3Lyt, LinearLayout aec1Lyt, LinearLayout aec2Lyt, LinearLayout aec3Lyt, LinearLayout dsc1Lyt, LinearLayout dsc2Lyt, LinearLayout dsc3Lyt, LinearLayout elective1Lyt, LinearLayout elective2Lyt, LinearLayout elective3Lyt, LinearLayout globalElectiveLyt, LinearLayout honourLyt, LinearLayout mdc1Lyt, LinearLayout mdc2Lyt, LinearLayout mdc3Lyt, LinearLayout minor2Lyt, LinearLayout minor3Lyt, LinearLayout minorLyt, TextView progressText, CardView progressView, TextView registerBtn, LinearLayout semesterLyt, TextView semesterTv, Spinner spinnerAdditionalElective1, Spinner spinnerAdditionalElective2, Spinner spinnerAdditionalElective3, Spinner spinnerAec1, Spinner spinnerAec2, Spinner spinnerAec3, Spinner spinnerDsc1, Spinner spinnerDsc2, Spinner spinnerDsc3, Spinner spinnerElective1, Spinner spinnerElective2, Spinner spinnerElective3, Spinner spinnerGlobalElective, Spinner spinnerHonour, Spinner spinnerMdc1, Spinner spinnerMdc2, Spinner spinnerMdc3, Spinner spinnerMinor, Spinner spinnerMinor2, Spinner spinnerMinor3, Spinner spinnerSemesterLastAttended, ProgressBar uploadProgressbar) {
        super(_bindingComponent, _root, _localFieldCount);
        this.additionalElective1Lyt = additionalElective1Lyt;
        this.additionalElective2Lyt = additionalElective2Lyt;
        this.additionalElective3Lyt = additionalElective3Lyt;
        this.aec1Lyt = aec1Lyt;
        this.aec2Lyt = aec2Lyt;
        this.aec3Lyt = aec3Lyt;
        this.dsc1Lyt = dsc1Lyt;
        this.dsc2Lyt = dsc2Lyt;
        this.dsc3Lyt = dsc3Lyt;
        this.elective1Lyt = elective1Lyt;
        this.elective2Lyt = elective2Lyt;
        this.elective3Lyt = elective3Lyt;
        this.globalElectiveLyt = globalElectiveLyt;
        this.honourLyt = honourLyt;
        this.mdc1Lyt = mdc1Lyt;
        this.mdc2Lyt = mdc2Lyt;
        this.mdc3Lyt = mdc3Lyt;
        this.minor2Lyt = minor2Lyt;
        this.minor3Lyt = minor3Lyt;
        this.minorLyt = minorLyt;
        this.progressText = progressText;
        this.progressView = progressView;
        this.registerBtn = registerBtn;
        this.semesterLyt = semesterLyt;
        this.semesterTv = semesterTv;
        this.spinnerAdditionalElective1 = spinnerAdditionalElective1;
        this.spinnerAdditionalElective2 = spinnerAdditionalElective2;
        this.spinnerAdditionalElective3 = spinnerAdditionalElective3;
        this.spinnerAec1 = spinnerAec1;
        this.spinnerAec2 = spinnerAec2;
        this.spinnerAec3 = spinnerAec3;
        this.spinnerDsc1 = spinnerDsc1;
        this.spinnerDsc2 = spinnerDsc2;
        this.spinnerDsc3 = spinnerDsc3;
        this.spinnerElective1 = spinnerElective1;
        this.spinnerElective2 = spinnerElective2;
        this.spinnerElective3 = spinnerElective3;
        this.spinnerGlobalElective = spinnerGlobalElective;
        this.spinnerHonour = spinnerHonour;
        this.spinnerMdc1 = spinnerMdc1;
        this.spinnerMdc2 = spinnerMdc2;
        this.spinnerMdc3 = spinnerMdc3;
        this.spinnerMinor = spinnerMinor;
        this.spinnerMinor2 = spinnerMinor2;
        this.spinnerMinor3 = spinnerMinor3;
        this.spinnerSemesterLastAttended = spinnerSemesterLastAttended;
        this.uploadProgressbar = uploadProgressbar;
    }

    public ApplySubjectRegistrationViewModel getApplySubjectRegistrationViewModel() {
        return this.mApplySubjectRegistrationViewModel;
    }

    public static DialogApplySubjectRegistrationBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogApplySubjectRegistrationBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (DialogApplySubjectRegistrationBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_apply_subject_registration, root, attachToRoot, component);
    }

    public static DialogApplySubjectRegistrationBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogApplySubjectRegistrationBinding inflate(LayoutInflater inflater, Object component) {
        return (DialogApplySubjectRegistrationBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_apply_subject_registration, null, false, component);
    }

    public static DialogApplySubjectRegistrationBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogApplySubjectRegistrationBinding bind(View view, Object component) {
        return (DialogApplySubjectRegistrationBinding) bind(component, view, R.layout.dialog_apply_subject_registration);
    }
}