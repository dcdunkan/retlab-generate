package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import in.etuwa.app.R;
import in.etuwa.app.ui.internship.apply.addcompany.AddCompanyViewModel;

/* loaded from: classes3.dex */
public abstract class AddCompanyDialogBinding extends ViewDataBinding {
    public final TextView addBtn;
    public final LinearLayout addCompanyLayout;
    public final TextView cancelBtn;
    public final TextInputLayout comntLayout;
    public final TextInputEditText etCompanyAddress;
    public final TextInputEditText etCompanyName;

    @Bindable
    protected AddCompanyViewModel mAddCompanyDialogViewModel;
    public final LinearLayout verifiedLayout;

    public abstract void setAddCompanyDialogViewModel(AddCompanyViewModel addCompanyDialogViewModel);

    protected AddCompanyDialogBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView addBtn, LinearLayout addCompanyLayout, TextView cancelBtn, TextInputLayout comntLayout, TextInputEditText etCompanyAddress, TextInputEditText etCompanyName, LinearLayout verifiedLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.addBtn = addBtn;
        this.addCompanyLayout = addCompanyLayout;
        this.cancelBtn = cancelBtn;
        this.comntLayout = comntLayout;
        this.etCompanyAddress = etCompanyAddress;
        this.etCompanyName = etCompanyName;
        this.verifiedLayout = verifiedLayout;
    }

    public AddCompanyViewModel getAddCompanyDialogViewModel() {
        return this.mAddCompanyDialogViewModel;
    }

    public static AddCompanyDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AddCompanyDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (AddCompanyDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.add_company_dialog, root, attachToRoot, component);
    }

    public static AddCompanyDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AddCompanyDialogBinding inflate(LayoutInflater inflater, Object component) {
        return (AddCompanyDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.add_company_dialog, null, false, component);
    }

    public static AddCompanyDialogBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AddCompanyDialogBinding bind(View view, Object component) {
        return (AddCompanyDialogBinding) bind(component, view, R.layout.add_company_dialog);
    }
}