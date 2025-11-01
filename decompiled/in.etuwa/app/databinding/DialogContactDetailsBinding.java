package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import in.etuwa.app.R;
import in.etuwa.app.ui.profile.contactdetails.ContactDetailsViewModel;

/* loaded from: classes3.dex */
public abstract class DialogContactDetailsBinding extends ViewDataBinding {
    public final TextView address;
    public final TextView district;

    @Bindable
    protected ContactDetailsViewModel mContactDetailsViewModel;
    public final TextView number;
    public final TextView pin;
    public final TextView state;

    public abstract void setContactDetailsViewModel(ContactDetailsViewModel contactDetailsViewModel);

    protected DialogContactDetailsBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView address, TextView district, TextView number, TextView pin, TextView state) {
        super(_bindingComponent, _root, _localFieldCount);
        this.address = address;
        this.district = district;
        this.number = number;
        this.pin = pin;
        this.state = state;
    }

    public ContactDetailsViewModel getContactDetailsViewModel() {
        return this.mContactDetailsViewModel;
    }

    public static DialogContactDetailsBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogContactDetailsBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (DialogContactDetailsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_contact_details, root, attachToRoot, component);
    }

    public static DialogContactDetailsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogContactDetailsBinding inflate(LayoutInflater inflater, Object component) {
        return (DialogContactDetailsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_contact_details, null, false, component);
    }

    public static DialogContactDetailsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogContactDetailsBinding bind(View view, Object component) {
        return (DialogContactDetailsBinding) bind(component, view, R.layout.dialog_contact_details);
    }
}