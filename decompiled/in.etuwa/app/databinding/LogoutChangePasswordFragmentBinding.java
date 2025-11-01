package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import in.etuwa.app.R;
import in.etuwa.app.ui.changepassword.main.LogoutChangePasswordViewModel;

/* loaded from: classes3.dex */
public abstract class LogoutChangePasswordFragmentBinding extends ViewDataBinding {
    public final TextView changeBtn;
    public final TextView logoutBtn;

    @Bindable
    protected LogoutChangePasswordViewModel mLogoutChangePasswordViewModel;

    public abstract void setLogoutChangePasswordViewModel(LogoutChangePasswordViewModel logoutChangePasswordViewModel);

    protected LogoutChangePasswordFragmentBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView changeBtn, TextView logoutBtn) {
        super(_bindingComponent, _root, _localFieldCount);
        this.changeBtn = changeBtn;
        this.logoutBtn = logoutBtn;
    }

    public LogoutChangePasswordViewModel getLogoutChangePasswordViewModel() {
        return this.mLogoutChangePasswordViewModel;
    }

    public static LogoutChangePasswordFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LogoutChangePasswordFragmentBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (LogoutChangePasswordFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.logout_change_password_fragment, root, attachToRoot, component);
    }

    public static LogoutChangePasswordFragmentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LogoutChangePasswordFragmentBinding inflate(LayoutInflater inflater, Object component) {
        return (LogoutChangePasswordFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.logout_change_password_fragment, null, false, component);
    }

    public static LogoutChangePasswordFragmentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LogoutChangePasswordFragmentBinding bind(View view, Object component) {
        return (LogoutChangePasswordFragmentBinding) bind(component, view, R.layout.logout_change_password_fragment);
    }
}