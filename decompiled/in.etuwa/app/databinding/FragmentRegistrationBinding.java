package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import in.etuwa.app.R;
import in.etuwa.app.ui.hostel.gcekhostel.registration.RegistrationViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentRegistrationBinding extends ViewDataBinding {

    @Bindable
    protected RegistrationViewModel mRegistrationViewModel;
    public final Button newRegistrationBtn;
    public final RecyclerView rvRegistration;
    public final SwipeRefreshLayout swipeLayout;

    public abstract void setRegistrationViewModel(RegistrationViewModel registrationViewModel);

    protected FragmentRegistrationBinding(Object _bindingComponent, View _root, int _localFieldCount, Button newRegistrationBtn, RecyclerView rvRegistration, SwipeRefreshLayout swipeLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.newRegistrationBtn = newRegistrationBtn;
        this.rvRegistration = rvRegistration;
        this.swipeLayout = swipeLayout;
    }

    public RegistrationViewModel getRegistrationViewModel() {
        return this.mRegistrationViewModel;
    }

    public static FragmentRegistrationBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentRegistrationBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentRegistrationBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_registration, root, attachToRoot, component);
    }

    public static FragmentRegistrationBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentRegistrationBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentRegistrationBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_registration, null, false, component);
    }

    public static FragmentRegistrationBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentRegistrationBinding bind(View view, Object component) {
        return (FragmentRegistrationBinding) bind(component, view, R.layout.fragment_registration);
    }
}