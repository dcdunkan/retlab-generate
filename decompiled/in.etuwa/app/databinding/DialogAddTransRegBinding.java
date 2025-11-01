package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import in.etuwa.app.R;
import in.etuwa.app.ui.transport.registration.register.TransportRegistrationViewModel;

/* loaded from: classes3.dex */
public abstract class DialogAddTransRegBinding extends ViewDataBinding {
    public final LinearLayout applyCompanyLayout;
    public final EditText etDate;
    public final TextView etDate2;

    @Bindable
    protected TransportRegistrationViewModel mTransportRegistrationViewModel;
    public final TextView registerBtn;
    public final Spinner spinnerBoarding;

    public abstract void setTransportRegistrationViewModel(TransportRegistrationViewModel transportRegistrationViewModel);

    protected DialogAddTransRegBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout applyCompanyLayout, EditText etDate, TextView etDate2, TextView registerBtn, Spinner spinnerBoarding) {
        super(_bindingComponent, _root, _localFieldCount);
        this.applyCompanyLayout = applyCompanyLayout;
        this.etDate = etDate;
        this.etDate2 = etDate2;
        this.registerBtn = registerBtn;
        this.spinnerBoarding = spinnerBoarding;
    }

    public TransportRegistrationViewModel getTransportRegistrationViewModel() {
        return this.mTransportRegistrationViewModel;
    }

    public static DialogAddTransRegBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogAddTransRegBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (DialogAddTransRegBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_add_trans_reg, root, attachToRoot, component);
    }

    public static DialogAddTransRegBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogAddTransRegBinding inflate(LayoutInflater inflater, Object component) {
        return (DialogAddTransRegBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_add_trans_reg, null, false, component);
    }

    public static DialogAddTransRegBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogAddTransRegBinding bind(View view, Object component) {
        return (DialogAddTransRegBinding) bind(component, view, R.layout.dialog_add_trans_reg);
    }
}