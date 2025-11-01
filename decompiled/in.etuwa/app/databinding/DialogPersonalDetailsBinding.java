package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import in.etuwa.app.R;
import in.etuwa.app.ui.profile.personaldetails.PersonalDetailsViewModel;

/* loaded from: classes3.dex */
public abstract class DialogPersonalDetailsBinding extends ViewDataBinding {
    public final TextView aadharNo;
    public final TextView abcId;
    public final TextView admissionNo;
    public final TextView bloodGroup;
    public final TextView dob;
    public final TextView gender;

    @Bindable
    protected PersonalDetailsViewModel mPersonalDetailsViewModel;
    public final TextView regNo;

    public abstract void setPersonalDetailsViewModel(PersonalDetailsViewModel personalDetailsViewModel);

    protected DialogPersonalDetailsBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView aadharNo, TextView abcId, TextView admissionNo, TextView bloodGroup, TextView dob, TextView gender, TextView regNo) {
        super(_bindingComponent, _root, _localFieldCount);
        this.aadharNo = aadharNo;
        this.abcId = abcId;
        this.admissionNo = admissionNo;
        this.bloodGroup = bloodGroup;
        this.dob = dob;
        this.gender = gender;
        this.regNo = regNo;
    }

    public PersonalDetailsViewModel getPersonalDetailsViewModel() {
        return this.mPersonalDetailsViewModel;
    }

    public static DialogPersonalDetailsBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogPersonalDetailsBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (DialogPersonalDetailsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_personal_details, root, attachToRoot, component);
    }

    public static DialogPersonalDetailsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogPersonalDetailsBinding inflate(LayoutInflater inflater, Object component) {
        return (DialogPersonalDetailsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_personal_details, null, false, component);
    }

    public static DialogPersonalDetailsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogPersonalDetailsBinding bind(View view, Object component) {
        return (DialogPersonalDetailsBinding) bind(component, view, R.layout.dialog_personal_details);
    }
}