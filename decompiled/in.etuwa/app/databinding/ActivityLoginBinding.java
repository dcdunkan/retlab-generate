package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.textfield.TextInputEditText;
import in.etuwa.app.R;
import in.etuwa.app.ui.login.LoginViewModel;

/* loaded from: classes3.dex */
public abstract class ActivityLoginBinding extends ViewDataBinding {
    public final TextView changeBtn;
    public final SearchView clgSearchBtn;
    public final LinearLayout clgSearchView;
    public final TextView collgeName;
    public final TextView etlab;
    public final TextView loginBtn;
    public final LinearLayout loginLyt;
    public final LinearLayout loginMainLyt;

    @Bindable
    protected LoginViewModel mLoginViewModel;
    public final TextInputEditText password;
    public final TextView registerBtn;
    public final TextView resetBtn;
    public final RecyclerView rvCollegeList;
    public final Spinner spinnerClgList;
    public final TextView tvRegister;
    public final TextInputEditText username;

    public abstract void setLoginViewModel(LoginViewModel loginViewModel);

    protected ActivityLoginBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView changeBtn, SearchView clgSearchBtn, LinearLayout clgSearchView, TextView collgeName, TextView etlab, TextView loginBtn, LinearLayout loginLyt, LinearLayout loginMainLyt, TextInputEditText password, TextView registerBtn, TextView resetBtn, RecyclerView rvCollegeList, Spinner spinnerClgList, TextView tvRegister, TextInputEditText username) {
        super(_bindingComponent, _root, _localFieldCount);
        this.changeBtn = changeBtn;
        this.clgSearchBtn = clgSearchBtn;
        this.clgSearchView = clgSearchView;
        this.collgeName = collgeName;
        this.etlab = etlab;
        this.loginBtn = loginBtn;
        this.loginLyt = loginLyt;
        this.loginMainLyt = loginMainLyt;
        this.password = password;
        this.registerBtn = registerBtn;
        this.resetBtn = resetBtn;
        this.rvCollegeList = rvCollegeList;
        this.spinnerClgList = spinnerClgList;
        this.tvRegister = tvRegister;
        this.username = username;
    }

    public LoginViewModel getLoginViewModel() {
        return this.mLoginViewModel;
    }

    public static ActivityLoginBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityLoginBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (ActivityLoginBinding) ViewDataBinding.inflateInternal(inflater, R.layout.activity_login, root, attachToRoot, component);
    }

    public static ActivityLoginBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityLoginBinding inflate(LayoutInflater inflater, Object component) {
        return (ActivityLoginBinding) ViewDataBinding.inflateInternal(inflater, R.layout.activity_login, null, false, component);
    }

    public static ActivityLoginBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityLoginBinding bind(View view, Object component) {
        return (ActivityLoginBinding) bind(component, view, R.layout.activity_login);
    }
}