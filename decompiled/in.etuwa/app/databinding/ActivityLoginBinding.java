package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import in.etuwa.app.R;
import in.etuwa.app.ui.login.LoginViewModel;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ActivityLoginBinding extends ViewDataBinding {
    public final TextView changeBtn;
    public final SearchView clgSearchBtn;
    public final LinearLayout clgSearchView;
    public final TextView collgeName;
    public final TextView emailTv;
    public final ImageView etlab;
    public final LinearLayout helpDeskLyt;
    public final ImageView ivEye;
    public final TextView loginBtn;
    public final LinearLayout loginLyt;
    public final LinearLayout loginMainLyt;

    @Bindable
    protected LoginViewModel mLoginViewModel;
    public final EditText password;
    public final TextView phone1Tv;
    public final TextView phone2Tv;
    public final TextView registerBtn;
    public final TextView resetBtn;
    public final RecyclerView rvCollegeList;
    public final Spinner spinnerClgList;
    public final TextView tvRegister;
    public final EditText username;

    public abstract void setLoginViewModel(LoginViewModel loginViewModel);

    protected ActivityLoginBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView changeBtn, SearchView clgSearchBtn, LinearLayout clgSearchView, TextView collgeName, TextView emailTv, ImageView etlab, LinearLayout helpDeskLyt, ImageView ivEye, TextView loginBtn, LinearLayout loginLyt, LinearLayout loginMainLyt, EditText password, TextView phone1Tv, TextView phone2Tv, TextView registerBtn, TextView resetBtn, RecyclerView rvCollegeList, Spinner spinnerClgList, TextView tvRegister, EditText username) {
        super(_bindingComponent, _root, _localFieldCount);
        this.changeBtn = changeBtn;
        this.clgSearchBtn = clgSearchBtn;
        this.clgSearchView = clgSearchView;
        this.collgeName = collgeName;
        this.emailTv = emailTv;
        this.etlab = etlab;
        this.helpDeskLyt = helpDeskLyt;
        this.ivEye = ivEye;
        this.loginBtn = loginBtn;
        this.loginLyt = loginLyt;
        this.loginMainLyt = loginMainLyt;
        this.password = password;
        this.phone1Tv = phone1Tv;
        this.phone2Tv = phone2Tv;
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