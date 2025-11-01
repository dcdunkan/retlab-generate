package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import in.etuwa.app.R;
import in.etuwa.app.ui.transport.registration.asiet.registration.AsietTransRegViewModel;

/* loaded from: classes3.dex */
public abstract class DialogAsietTransportRegistrationBinding extends ViewDataBinding {
    public final LinearLayout applyCompanyLayout;
    public final TextView busDetailsBtn;
    public final CheckBox checkBox;
    public final TextInputEditText etAmount;
    public final EditText etDate;
    public final TextView etDate2;
    public final TextInputEditText etExactBoardingPoint;

    @Bindable
    protected AsietTransRegViewModel mAsietTransRegViewModel;
    public final TextInputLayout mtAmount;
    public final TextInputLayout mtExactBoardingPoint;
    public final TextView registerBtn;
    public final Spinner spinnerBoarding;

    public abstract void setAsietTransRegViewModel(AsietTransRegViewModel asietTransRegViewModel);

    protected DialogAsietTransportRegistrationBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout applyCompanyLayout, TextView busDetailsBtn, CheckBox checkBox, TextInputEditText etAmount, EditText etDate, TextView etDate2, TextInputEditText etExactBoardingPoint, TextInputLayout mtAmount, TextInputLayout mtExactBoardingPoint, TextView registerBtn, Spinner spinnerBoarding) {
        super(_bindingComponent, _root, _localFieldCount);
        this.applyCompanyLayout = applyCompanyLayout;
        this.busDetailsBtn = busDetailsBtn;
        this.checkBox = checkBox;
        this.etAmount = etAmount;
        this.etDate = etDate;
        this.etDate2 = etDate2;
        this.etExactBoardingPoint = etExactBoardingPoint;
        this.mtAmount = mtAmount;
        this.mtExactBoardingPoint = mtExactBoardingPoint;
        this.registerBtn = registerBtn;
        this.spinnerBoarding = spinnerBoarding;
    }

    public AsietTransRegViewModel getAsietTransRegViewModel() {
        return this.mAsietTransRegViewModel;
    }

    public static DialogAsietTransportRegistrationBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogAsietTransportRegistrationBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (DialogAsietTransportRegistrationBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_asiet_transport_registration, root, attachToRoot, component);
    }

    public static DialogAsietTransportRegistrationBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogAsietTransportRegistrationBinding inflate(LayoutInflater inflater, Object component) {
        return (DialogAsietTransportRegistrationBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_asiet_transport_registration, null, false, component);
    }

    public static DialogAsietTransportRegistrationBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogAsietTransportRegistrationBinding bind(View view, Object component) {
        return (DialogAsietTransportRegistrationBinding) bind(component, view, R.layout.dialog_asiet_transport_registration);
    }
}