package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import in.etuwa.app.R;
import in.etuwa.app.ui.hostel.gcekhostel.registration.viewregistration.ViewRegistrationViewModel;

/* loaded from: classes3.dex */
public abstract class DialogViewregistrationDialogBinding extends ViewDataBinding {
    public final TextView addressRe;
    public final TextView admsnNumberRe;
    public final TextView annualIncomeRe;
    public final TextView backPaperRe;
    public final TextView certificateDwnRe;
    public final TextView distanceRe;
    public final TextView hostelAppliedForRe;

    @Bindable
    protected ViewRegistrationViewModel mViewRegistrationViewModel;
    public final TextView nameRe;
    public final TextView phoneRe;
    public final TextView readmissionRe;
    public final TextView regTitle;
    public final TextView remarksRe;
    public final TextView statusRe;
    public final TextView typeRe;

    public abstract void setViewRegistrationViewModel(ViewRegistrationViewModel viewRegistrationViewModel);

    protected DialogViewregistrationDialogBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView addressRe, TextView admsnNumberRe, TextView annualIncomeRe, TextView backPaperRe, TextView certificateDwnRe, TextView distanceRe, TextView hostelAppliedForRe, TextView nameRe, TextView phoneRe, TextView readmissionRe, TextView regTitle, TextView remarksRe, TextView statusRe, TextView typeRe) {
        super(_bindingComponent, _root, _localFieldCount);
        this.addressRe = addressRe;
        this.admsnNumberRe = admsnNumberRe;
        this.annualIncomeRe = annualIncomeRe;
        this.backPaperRe = backPaperRe;
        this.certificateDwnRe = certificateDwnRe;
        this.distanceRe = distanceRe;
        this.hostelAppliedForRe = hostelAppliedForRe;
        this.nameRe = nameRe;
        this.phoneRe = phoneRe;
        this.readmissionRe = readmissionRe;
        this.regTitle = regTitle;
        this.remarksRe = remarksRe;
        this.statusRe = statusRe;
        this.typeRe = typeRe;
    }

    public ViewRegistrationViewModel getViewRegistrationViewModel() {
        return this.mViewRegistrationViewModel;
    }

    public static DialogViewregistrationDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogViewregistrationDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (DialogViewregistrationDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_viewregistration_dialog, root, attachToRoot, component);
    }

    public static DialogViewregistrationDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogViewregistrationDialogBinding inflate(LayoutInflater inflater, Object component) {
        return (DialogViewregistrationDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_viewregistration_dialog, null, false, component);
    }

    public static DialogViewregistrationDialogBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogViewregistrationDialogBinding bind(View view, Object component) {
        return (DialogViewregistrationDialogBinding) bind(component, view, R.layout.dialog_viewregistration_dialog);
    }
}