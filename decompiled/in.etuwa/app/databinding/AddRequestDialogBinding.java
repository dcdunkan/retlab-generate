package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.textfield.TextInputEditText;
import in.etuwa.app.R;
import in.etuwa.app.ui.certificate_request.add_request_dialog.AddRequestDialogViewModel;

/* loaded from: classes3.dex */
public abstract class AddRequestDialogBinding extends ViewDataBinding {
    public final LinearLayout assiCard;
    public final TextInputEditText bankAdressText;
    public final TextInputEditText bankNameText;
    public final TextInputEditText cgpaExamEt;
    public final LinearLayout cgpaLyt;
    public final LinearLayout commonLayout;
    public final LinearLayout completionCard;
    public final TextView completionFileName;
    public final TextView completionSelect;
    public final TextInputEditText districtItr;
    public final LinearLayout feeLyt;
    public final TextInputEditText houseNameItr;
    public final TextView isHostlerTv;
    public final LinearLayout itrLyt;
    public final ProgressBar loader;

    @Bindable
    protected AddRequestDialogViewModel mAddRequestDialogViewModel;
    public final TextInputEditText monthYearCgpaEt;
    public final TextInputEditText nameOfParentItr;
    public final LinearLayout originalCertLyt;
    public final TextInputEditText pinCodeItr;
    public final TextInputEditText postOfficeItr;
    public final TextView progressText;
    public final LinearLayout progressView;
    public final TextInputEditText reasonCgpaEt;
    public final TextInputEditText reasonText;
    public final TextInputEditText sgpaEt;
    public final Spinner spinnerCertificateList;
    public final Spinner spinnerHostler;
    public final Spinner spinnerOriginalCert;
    public final Spinner spinnerRequestOpted;
    public final Spinner spinnerSemester2;
    public final TextInputEditText stateItr;
    public final TextInputEditText streetItr;
    public final TextView submitBtn;
    public final TextView textViewId;
    public final ProgressBar uploadProgressbar;

    public abstract void setAddRequestDialogViewModel(AddRequestDialogViewModel addRequestDialogViewModel);

    protected AddRequestDialogBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout assiCard, TextInputEditText bankAdressText, TextInputEditText bankNameText, TextInputEditText cgpaExamEt, LinearLayout cgpaLyt, LinearLayout commonLayout, LinearLayout completionCard, TextView completionFileName, TextView completionSelect, TextInputEditText districtItr, LinearLayout feeLyt, TextInputEditText houseNameItr, TextView isHostlerTv, LinearLayout itrLyt, ProgressBar loader, TextInputEditText monthYearCgpaEt, TextInputEditText nameOfParentItr, LinearLayout originalCertLyt, TextInputEditText pinCodeItr, TextInputEditText postOfficeItr, TextView progressText, LinearLayout progressView, TextInputEditText reasonCgpaEt, TextInputEditText reasonText, TextInputEditText sgpaEt, Spinner spinnerCertificateList, Spinner spinnerHostler, Spinner spinnerOriginalCert, Spinner spinnerRequestOpted, Spinner spinnerSemester2, TextInputEditText stateItr, TextInputEditText streetItr, TextView submitBtn, TextView textViewId, ProgressBar uploadProgressbar) {
        super(_bindingComponent, _root, _localFieldCount);
        this.assiCard = assiCard;
        this.bankAdressText = bankAdressText;
        this.bankNameText = bankNameText;
        this.cgpaExamEt = cgpaExamEt;
        this.cgpaLyt = cgpaLyt;
        this.commonLayout = commonLayout;
        this.completionCard = completionCard;
        this.completionFileName = completionFileName;
        this.completionSelect = completionSelect;
        this.districtItr = districtItr;
        this.feeLyt = feeLyt;
        this.houseNameItr = houseNameItr;
        this.isHostlerTv = isHostlerTv;
        this.itrLyt = itrLyt;
        this.loader = loader;
        this.monthYearCgpaEt = monthYearCgpaEt;
        this.nameOfParentItr = nameOfParentItr;
        this.originalCertLyt = originalCertLyt;
        this.pinCodeItr = pinCodeItr;
        this.postOfficeItr = postOfficeItr;
        this.progressText = progressText;
        this.progressView = progressView;
        this.reasonCgpaEt = reasonCgpaEt;
        this.reasonText = reasonText;
        this.sgpaEt = sgpaEt;
        this.spinnerCertificateList = spinnerCertificateList;
        this.spinnerHostler = spinnerHostler;
        this.spinnerOriginalCert = spinnerOriginalCert;
        this.spinnerRequestOpted = spinnerRequestOpted;
        this.spinnerSemester2 = spinnerSemester2;
        this.stateItr = stateItr;
        this.streetItr = streetItr;
        this.submitBtn = submitBtn;
        this.textViewId = textViewId;
        this.uploadProgressbar = uploadProgressbar;
    }

    public AddRequestDialogViewModel getAddRequestDialogViewModel() {
        return this.mAddRequestDialogViewModel;
    }

    public static AddRequestDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AddRequestDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (AddRequestDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.add_request_dialog, root, attachToRoot, component);
    }

    public static AddRequestDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AddRequestDialogBinding inflate(LayoutInflater inflater, Object component) {
        return (AddRequestDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.add_request_dialog, null, false, component);
    }

    public static AddRequestDialogBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AddRequestDialogBinding bind(View view, Object component) {
        return (AddRequestDialogBinding) bind(component, view, R.layout.add_request_dialog);
    }
}