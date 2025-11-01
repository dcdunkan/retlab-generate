package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import in.etuwa.app.R;
import in.etuwa.app.ui.internship.apply.ApplyInternshipViewModel;

/* loaded from: classes3.dex */
public abstract class ApplyInternshipBinding extends ViewDataBinding {
    public final TextView addBtn;
    public final TextView addCompanyBtn;
    public final LinearLayout addCompanyLayout;
    public final LinearLayout applyCompanyLayout;
    public final TextView applyInternshipBtn;
    public final TextView cancelBtn;
    public final TextView closeCompanyBtn;
    public final TextInputLayout comntLayout;
    public final TextInputEditText etCompany;
    public final TextInputEditText etCompanyAddress;
    public final TextInputEditText etCompanyName;
    public final TextView internshipFromDate;
    public final TextView internshipToDate;

    @Bindable
    protected ApplyInternshipViewModel mApplyInternshipViewModel;
    public final LinearLayout otherCompanyLayout;
    public final Spinner spinnerCompanyNames;
    public final LinearLayout verifiedLayout;

    public abstract void setApplyInternshipViewModel(ApplyInternshipViewModel applyInternshipViewModel);

    protected ApplyInternshipBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView addBtn, TextView addCompanyBtn, LinearLayout addCompanyLayout, LinearLayout applyCompanyLayout, TextView applyInternshipBtn, TextView cancelBtn, TextView closeCompanyBtn, TextInputLayout comntLayout, TextInputEditText etCompany, TextInputEditText etCompanyAddress, TextInputEditText etCompanyName, TextView internshipFromDate, TextView internshipToDate, LinearLayout otherCompanyLayout, Spinner spinnerCompanyNames, LinearLayout verifiedLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.addBtn = addBtn;
        this.addCompanyBtn = addCompanyBtn;
        this.addCompanyLayout = addCompanyLayout;
        this.applyCompanyLayout = applyCompanyLayout;
        this.applyInternshipBtn = applyInternshipBtn;
        this.cancelBtn = cancelBtn;
        this.closeCompanyBtn = closeCompanyBtn;
        this.comntLayout = comntLayout;
        this.etCompany = etCompany;
        this.etCompanyAddress = etCompanyAddress;
        this.etCompanyName = etCompanyName;
        this.internshipFromDate = internshipFromDate;
        this.internshipToDate = internshipToDate;
        this.otherCompanyLayout = otherCompanyLayout;
        this.spinnerCompanyNames = spinnerCompanyNames;
        this.verifiedLayout = verifiedLayout;
    }

    public ApplyInternshipViewModel getApplyInternshipViewModel() {
        return this.mApplyInternshipViewModel;
    }

    public static ApplyInternshipBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ApplyInternshipBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (ApplyInternshipBinding) ViewDataBinding.inflateInternal(inflater, R.layout.apply_internship, root, attachToRoot, component);
    }

    public static ApplyInternshipBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ApplyInternshipBinding inflate(LayoutInflater inflater, Object component) {
        return (ApplyInternshipBinding) ViewDataBinding.inflateInternal(inflater, R.layout.apply_internship, null, false, component);
    }

    public static ApplyInternshipBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ApplyInternshipBinding bind(View view, Object component) {
        return (ApplyInternshipBinding) bind(component, view, R.layout.apply_internship);
    }
}