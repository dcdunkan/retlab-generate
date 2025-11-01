package in.etuwa.app.ui.login;

import android.content.ComponentCallbacks;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.SearchView;
import androidx.core.content.res.ResourcesCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.analytics.FirebaseAnalytics;
import in.etuwa.app.R;
import in.etuwa.app.data.model.institutions.Colleges;
import in.etuwa.app.data.model.login.LoginResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.ActivityLoginBinding;
import in.etuwa.app.helper.ValidChecker;
import in.etuwa.app.ui.base.BaseActivity;
import in.etuwa.app.ui.login.CollegeListAdapter;
import in.etuwa.app.ui.registration.RegistrationActivity;
import in.etuwa.app.ui.resetpassword.ResetPasswordActivity;
import in.etuwa.app.utils.ActivityMediator;
import in.etuwa.app.utils.AppConstant;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.parameter.ParametersHolderKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: LoginActivity.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010 \u001a\u00020!H\u0002J(\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020%2\u0006\u0010(\u001a\u00020%H\u0016J\b\u0010)\u001a\u00020#H\u0014J\b\u0010*\u001a\u00020#H\u0002J\b\u0010+\u001a\u00020#H\u0002J\u0012\u0010,\u001a\u00020#2\b\u0010-\u001a\u0004\u0018\u00010.H\u0014J\b\u0010/\u001a\u00020#H\u0014J\b\u00100\u001a\u00020#H\u0014J\b\u00101\u001a\u00020#H\u0014J\b\u00102\u001a\u00020#H\u0014J\b\u00103\u001a\u00020#H\u0014J \u00104\u001a\u00020#2\u0016\u00105\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000fH\u0002J\u0010\u00106\u001a\u00020#2\u0006\u00107\u001a\u00020%H\u0002J\b\u00108\u001a\u00020#H\u0014J\b\u00109\u001a\u00020#H\u0002J\b\u0010:\u001a\u00020#H\u0014R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\t\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\t\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\t\u001a\u0004\b\u001d\u0010\u001e¨\u0006;"}, d2 = {"Lin/etuwa/app/ui/login/LoginActivity;", "Lin/etuwa/app/ui/base/BaseActivity;", "Lin/etuwa/app/ui/login/CollegeListAdapter$CallBack;", "()V", "adapter", "Lin/etuwa/app/ui/login/CollegeListAdapter;", "getAdapter", "()Lin/etuwa/app/ui/login/CollegeListAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "binding", "Lin/etuwa/app/databinding/ActivityLoginBinding;", "filteredList", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/institutions/Colleges;", "Lkotlin/collections/ArrayList;", "loginViewModel", "Lin/etuwa/app/ui/login/LoginViewModel;", "getLoginViewModel", "()Lin/etuwa/app/ui/login/LoginViewModel;", "loginViewModel$delegate", "originalList", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", "spinnerAdapter", "Lin/etuwa/app/ui/login/CollegeSpinnerAdapter;", "getSpinnerAdapter", "()Lin/etuwa/app/ui/login/CollegeSpinnerAdapter;", "spinnerAdapter$delegate", "checkNetworkAvailability", "", "collegeSelected", "", "clgId", "", "baseUrl", "regUrl", "clgName", "hideProgress", "listenLoginResponse", "loadRefreshDialog", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onStart", "onStop", "renderList", "users", FirebaseAnalytics.Event.SEARCH, SearchIntents.EXTRA_QUERY, "setUp", "setupClgSpinner", "showProgress", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LoginActivity extends BaseActivity implements CollegeListAdapter.CallBack {

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;
    private ActivityLoginBinding binding;
    private ArrayList<Colleges> filteredList;

    /* renamed from: loginViewModel$delegate, reason: from kotlin metadata */
    private final Lazy loginViewModel;
    private ArrayList<Colleges> originalList;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;

    /* renamed from: spinnerAdapter$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdapter;

    /* compiled from: LoginActivity.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Status.values().length];
            try {
                iArr[Status.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Status.LOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Status.ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Status.EXCEPTION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // in.etuwa.app.ui.base.BaseActivity
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseActivity
    protected void showProgress() {
    }

    public LoginActivity() {
        final LoginActivity loginActivity = this;
        final LoginActivity loginActivity2 = loginActivity;
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(loginActivity);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.loginViewModel = new ViewModelLazy(Reflection.getOrCreateKotlinClass(LoginViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.login.LoginActivity$special$$inlined$viewModel$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = ComponentActivity.this.getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStore");
                return viewModelStore;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.login.LoginActivity$special$$inlined$viewModel$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory(ViewModelStoreOwner.this, Reflection.getOrCreateKotlinClass(LoginViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final LoginActivity loginActivity3 = this;
        final Function0<ParametersHolder> function0 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.login.LoginActivity$spinnerAdapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(LoginActivity.this);
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        this.spinnerAdapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<CollegeSpinnerAdapter>() { // from class: in.etuwa.app.ui.login.LoginActivity$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.login.CollegeSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final CollegeSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = loginActivity3;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(CollegeSpinnerAdapter.class), b2, function0);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b3 = 0 == true ? 1 : 0;
        final byte b4 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.login.LoginActivity$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = loginActivity3;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b3, b4);
            }
        });
        this.originalList = new ArrayList<>();
        this.filteredList = new ArrayList<>();
        LazyThreadSafetyMode lazyThreadSafetyMode3 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b5 = 0 == true ? 1 : 0;
        final byte b6 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode3, (Function0) new Function0<CollegeListAdapter>() { // from class: in.etuwa.app.ui.login.LoginActivity$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.login.CollegeListAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final CollegeListAdapter invoke() {
                ComponentCallbacks componentCallbacks = loginActivity3;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(CollegeListAdapter.class), b5, b6);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LoginViewModel getLoginViewModel() {
        return (LoginViewModel) this.loginViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CollegeSpinnerAdapter getSpinnerAdapter() {
        return (CollegeSpinnerAdapter) this.spinnerAdapter.getValue();
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    private final CollegeListAdapter getAdapter() {
        return (CollegeListAdapter) this.adapter.getValue();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.hide();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.hide();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.hide();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        getPreference().setNewLogin(true);
        if (getPreference().getLoginStatus()) {
            ActivityMediator.INSTANCE.startMainActivity(this);
            finish();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewDataBinding contentView = DataBindingUtil.setContentView(this, R.layout.activity_login);
        Intrinsics.checkNotNullExpressionValue(contentView, "setContentView(this, R.layout.activity_login)");
        ActivityLoginBinding activityLoginBinding = (ActivityLoginBinding) contentView;
        this.binding = activityLoginBinding;
        ActivityLoginBinding activityLoginBinding2 = null;
        if (activityLoginBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityLoginBinding = null;
        }
        activityLoginBinding.setLoginViewModel(getLoginViewModel());
        ActivityLoginBinding activityLoginBinding3 = this.binding;
        if (activityLoginBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityLoginBinding2 = activityLoginBinding3;
        }
        activityLoginBinding2.setLifecycleOwner(this);
        setUp();
    }

    @Override // in.etuwa.app.ui.base.BaseActivity
    protected void setUp() {
        ActivityLoginBinding activityLoginBinding = this.binding;
        ActivityLoginBinding activityLoginBinding2 = null;
        if (activityLoginBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityLoginBinding = null;
        }
        activityLoginBinding.rvCollegeList.setAdapter(getAdapter());
        getAdapter().setCallBack(this);
        ResourcesCompat.getFont(this, R.font.bellerose);
        getWindow().setSoftInputMode(32);
        if (checkNetworkAvailability()) {
            if (Intrinsics.areEqual(getPreference().getBaseUrl(), AppConstant.COLLEGE_LIST_BASE_URL)) {
                System.out.println((Object) getPreference().getBaseUrl());
                getLoginViewModel().fetchColleges();
            }
        } else {
            loadRefreshDialog();
        }
        ActivityLoginBinding activityLoginBinding3 = this.binding;
        if (activityLoginBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityLoginBinding3 = null;
        }
        activityLoginBinding3.spinnerClgList.setAdapter((SpinnerAdapter) getSpinnerAdapter());
        setupClgSpinner();
        listenLoginResponse();
        ActivityLoginBinding activityLoginBinding4 = this.binding;
        if (activityLoginBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityLoginBinding4 = null;
        }
        activityLoginBinding4.spinnerClgList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.login.LoginActivity$setUp$1
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> parent) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                CollegeSpinnerAdapter spinnerAdapter;
                LoginViewModel loginViewModel;
                spinnerAdapter = LoginActivity.this.getSpinnerAdapter();
                Colleges college = spinnerAdapter.getCollege(position);
                loginViewModel = LoginActivity.this.getLoginViewModel();
                loginViewModel.setCollege(college);
            }
        });
        ActivityLoginBinding activityLoginBinding5 = this.binding;
        if (activityLoginBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityLoginBinding5 = null;
        }
        activityLoginBinding5.clgSearchBtn.setOnQueryTextListener(new SearchView.OnQueryTextListener() { // from class: in.etuwa.app.ui.login.LoginActivity$setUp$2
            @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
            public boolean onQueryTextSubmit(String query) {
                ActivityLoginBinding activityLoginBinding6;
                ActivityLoginBinding activityLoginBinding7;
                Intrinsics.checkNotNullParameter(query, "query");
                ActivityLoginBinding activityLoginBinding8 = null;
                if (!Intrinsics.areEqual(query, "")) {
                    activityLoginBinding7 = LoginActivity.this.binding;
                    if (activityLoginBinding7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        activityLoginBinding8 = activityLoginBinding7;
                    }
                    activityLoginBinding8.rvCollegeList.setVisibility(0);
                } else {
                    activityLoginBinding6 = LoginActivity.this.binding;
                    if (activityLoginBinding6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        activityLoginBinding8 = activityLoginBinding6;
                    }
                    activityLoginBinding8.rvCollegeList.setVisibility(8);
                }
                LoginActivity.this.search(query);
                return true;
            }

            @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
            public boolean onQueryTextChange(String newText) {
                ActivityLoginBinding activityLoginBinding6;
                ActivityLoginBinding activityLoginBinding7;
                Intrinsics.checkNotNullParameter(newText, "newText");
                ActivityLoginBinding activityLoginBinding8 = null;
                if (!Intrinsics.areEqual(newText, "")) {
                    activityLoginBinding7 = LoginActivity.this.binding;
                    if (activityLoginBinding7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        activityLoginBinding8 = activityLoginBinding7;
                    }
                    activityLoginBinding8.rvCollegeList.setVisibility(0);
                } else {
                    activityLoginBinding6 = LoginActivity.this.binding;
                    if (activityLoginBinding6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        activityLoginBinding8 = activityLoginBinding6;
                    }
                    activityLoginBinding8.rvCollegeList.setVisibility(8);
                }
                LoginActivity.this.search(newText);
                return true;
            }
        });
        ActivityLoginBinding activityLoginBinding6 = this.binding;
        if (activityLoginBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityLoginBinding6 = null;
        }
        activityLoginBinding6.changeBtn.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.login.LoginActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoginActivity.setUp$lambda$0(LoginActivity.this, view);
            }
        });
        ActivityLoginBinding activityLoginBinding7 = this.binding;
        if (activityLoginBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityLoginBinding7 = null;
        }
        activityLoginBinding7.registerBtn.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.login.LoginActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoginActivity.setUp$lambda$1(LoginActivity.this, view);
            }
        });
        ActivityLoginBinding activityLoginBinding8 = this.binding;
        if (activityLoginBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityLoginBinding8 = null;
        }
        activityLoginBinding8.loginBtn.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.login.LoginActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoginActivity.setUp$lambda$2(LoginActivity.this, view);
            }
        });
        ActivityLoginBinding activityLoginBinding9 = this.binding;
        if (activityLoginBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityLoginBinding2 = activityLoginBinding9;
        }
        activityLoginBinding2.resetBtn.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.login.LoginActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoginActivity.setUp$lambda$3(LoginActivity.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$0(LoginActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ActivityLoginBinding activityLoginBinding = this$0.binding;
        ActivityLoginBinding activityLoginBinding2 = null;
        if (activityLoginBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityLoginBinding = null;
        }
        activityLoginBinding.rvCollegeList.setVisibility(0);
        ActivityLoginBinding activityLoginBinding3 = this$0.binding;
        if (activityLoginBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityLoginBinding3 = null;
        }
        activityLoginBinding3.clgSearchBtn.setVisibility(0);
        ActivityLoginBinding activityLoginBinding4 = this$0.binding;
        if (activityLoginBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityLoginBinding4 = null;
        }
        activityLoginBinding4.changeBtn.setVisibility(4);
        ActivityLoginBinding activityLoginBinding5 = this$0.binding;
        if (activityLoginBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityLoginBinding5 = null;
        }
        activityLoginBinding5.collgeName.setVisibility(8);
        ActivityLoginBinding activityLoginBinding6 = this$0.binding;
        if (activityLoginBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityLoginBinding6 = null;
        }
        activityLoginBinding6.changeBtn.setText("");
        ActivityLoginBinding activityLoginBinding7 = this$0.binding;
        if (activityLoginBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityLoginBinding7 = null;
        }
        activityLoginBinding7.clgSearchView.setVisibility(0);
        ActivityLoginBinding activityLoginBinding8 = this$0.binding;
        if (activityLoginBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityLoginBinding2 = activityLoginBinding8;
        }
        activityLoginBinding2.loginMainLyt.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(LoginActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ActivityLoginBinding activityLoginBinding = this$0.binding;
        ActivityLoginBinding activityLoginBinding2 = null;
        if (activityLoginBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityLoginBinding = null;
        }
        if (StringsKt.contains$default((CharSequence) activityLoginBinding.registerBtn.getText().toString(), (CharSequence) "Not a user? Register!!", false, 2, (Object) null)) {
            ActivityLoginBinding activityLoginBinding3 = this$0.binding;
            if (activityLoginBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityLoginBinding3 = null;
            }
            TextView textView = activityLoginBinding3.registerBtn;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.registerBtn");
            ToastExtKt.showInfoToast(textView, "Please choose your preferred college and proceed with registration. Cheers to new beginnings!");
            ActivityLoginBinding activityLoginBinding4 = this$0.binding;
            if (activityLoginBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityLoginBinding4 = null;
            }
            activityLoginBinding4.registerBtn.setText("Already a user? Login!!");
            ActivityLoginBinding activityLoginBinding5 = this$0.binding;
            if (activityLoginBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityLoginBinding5 = null;
            }
            activityLoginBinding5.loginLyt.setVisibility(8);
            ActivityLoginBinding activityLoginBinding6 = this$0.binding;
            if (activityLoginBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityLoginBinding6 = null;
            }
            activityLoginBinding6.loginBtn.setText("Register");
            ActivityLoginBinding activityLoginBinding7 = this$0.binding;
            if (activityLoginBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityLoginBinding2 = activityLoginBinding7;
            }
            activityLoginBinding2.resetBtn.setVisibility(8);
            return;
        }
        ActivityLoginBinding activityLoginBinding8 = this$0.binding;
        if (activityLoginBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityLoginBinding8 = null;
        }
        activityLoginBinding8.registerBtn.setText("Not a user? Register!!");
        ActivityLoginBinding activityLoginBinding9 = this$0.binding;
        if (activityLoginBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityLoginBinding9 = null;
        }
        activityLoginBinding9.loginLyt.setVisibility(0);
        ActivityLoginBinding activityLoginBinding10 = this$0.binding;
        if (activityLoginBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityLoginBinding10 = null;
        }
        activityLoginBinding10.loginBtn.setText("Login");
        ActivityLoginBinding activityLoginBinding11 = this$0.binding;
        if (activityLoginBinding11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityLoginBinding2 = activityLoginBinding11;
        }
        activityLoginBinding2.resetBtn.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$2(LoginActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ActivityLoginBinding activityLoginBinding = this$0.binding;
        ActivityLoginBinding activityLoginBinding2 = null;
        if (activityLoginBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityLoginBinding = null;
        }
        if (StringsKt.contains$default((CharSequence) activityLoginBinding.loginBtn.getText().toString(), (CharSequence) "Register", false, 2, (Object) null)) {
            this$0.startActivity(new Intent(this$0.getApplicationContext(), (Class<?>) RegistrationActivity.class));
            return;
        }
        if (this$0.checkNetworkAvailability()) {
            ActivityLoginBinding activityLoginBinding3 = this$0.binding;
            if (activityLoginBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityLoginBinding3 = null;
            }
            String valueOf = String.valueOf(activityLoginBinding3.username.getText());
            if (valueOf == null || valueOf.length() == 0) {
                ActivityLoginBinding activityLoginBinding4 = this$0.binding;
                if (activityLoginBinding4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    activityLoginBinding2 = activityLoginBinding4;
                }
                TextInputEditText textInputEditText = activityLoginBinding2.username;
                Intrinsics.checkNotNullExpressionValue(textInputEditText, "binding.username");
                String string = this$0.getString(R.string.error_username);
                Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.error_username)");
                ToastExtKt.showInfoToast(textInputEditText, string);
                return;
            }
            ActivityLoginBinding activityLoginBinding5 = this$0.binding;
            if (activityLoginBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityLoginBinding5 = null;
            }
            String valueOf2 = String.valueOf(activityLoginBinding5.password.getText());
            if (valueOf2 == null || valueOf2.length() == 0) {
                ActivityLoginBinding activityLoginBinding6 = this$0.binding;
                if (activityLoginBinding6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    activityLoginBinding2 = activityLoginBinding6;
                }
                TextInputEditText textInputEditText2 = activityLoginBinding2.password;
                Intrinsics.checkNotNullExpressionValue(textInputEditText2, "binding.password");
                String string2 = this$0.getString(R.string.error_password);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.error_password)");
                ToastExtKt.showInfoToast(textInputEditText2, string2);
                return;
            }
            String str = Intrinsics.areEqual(this$0.getPreference().getBaseUrl(), "https://nssce.etlab.in/androidapp/mobile/") ? "99" : null;
            LoginViewModel loginViewModel = this$0.getLoginViewModel();
            ActivityLoginBinding activityLoginBinding7 = this$0.binding;
            if (activityLoginBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityLoginBinding7 = null;
            }
            String obj = StringsKt.trim((CharSequence) String.valueOf(activityLoginBinding7.username.getText())).toString();
            ActivityLoginBinding activityLoginBinding8 = this$0.binding;
            if (activityLoginBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityLoginBinding2 = activityLoginBinding8;
            }
            loginViewModel.validateCredentials(obj, StringsKt.trim((CharSequence) String.valueOf(activityLoginBinding2.password.getText())).toString(), str);
            return;
        }
        this$0.loadRefreshDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$3(LoginActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.startActivity(new Intent(this$0.getApplicationContext(), (Class<?>) ResetPasswordActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void search(String query) {
        ArrayList<Colleges> arrayList = this.originalList;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            Colleges colleges = (Colleges) obj;
            String str = query;
            boolean z = true;
            if (!StringsKt.contains((CharSequence) colleges.getClgName(), (CharSequence) str, true) && !StringsKt.contains((CharSequence) colleges.getBaseUrl(), (CharSequence) str, true)) {
                z = false;
            }
            if (z) {
                arrayList2.add(obj);
            }
        }
        this.filteredList = arrayList2;
        getAdapter().addItems(this.filteredList);
    }

    private final void loadRefreshDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage(getString(R.string.turn_on_internet_connection));
        builder.setPositiveButton(getString(R.string.refresh), new DialogInterface.OnClickListener() { // from class: in.etuwa.app.ui.login.LoginActivity$$ExternalSyntheticLambda6
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                LoginActivity.loadRefreshDialog$lambda$5(LoginActivity.this, dialogInterface, i);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadRefreshDialog$lambda$5(LoginActivity this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.setUp();
    }

    private final boolean checkNetworkAvailability() {
        LoginActivity loginActivity = this;
        if (new ValidChecker(loginActivity).isNetworkAvailable()) {
            return true;
        }
        new ValidChecker(loginActivity).vibrate(this, 500L);
        return false;
    }

    private final void listenLoginResponse() {
        getLoginViewModel().getResponse().observe(this, new Observer() { // from class: in.etuwa.app.ui.login.LoginActivity$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LoginActivity.listenLoginResponse$lambda$7(LoginActivity.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenLoginResponse$lambda$7(LoginActivity this$0, Resource resource) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        ActivityLoginBinding activityLoginBinding = null;
        if (i == 1) {
            this$0.hideProgress();
            LoginResponse loginResponse = (LoginResponse) resource.getData();
            if (loginResponse != null) {
                if (loginResponse.getLogin()) {
                    if (this$0.getLoginViewModel().storeUserDetails(loginResponse)) {
                        ActivityMediator.INSTANCE.startMainActivity(this$0);
                        this$0.finish();
                        return;
                    }
                    return;
                }
                ActivityLoginBinding activityLoginBinding2 = this$0.binding;
                if (activityLoginBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    activityLoginBinding = activityLoginBinding2;
                }
                TextView textView = activityLoginBinding.loginBtn;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.loginBtn");
                ToastExtKt.showErrorToast(textView, loginResponse.getError());
                return;
            }
            return;
        }
        if (i == 2) {
            this$0.showProgress();
            return;
        }
        if (i == 3) {
            this$0.hideProgress();
            return;
        }
        if (i != 4) {
            return;
        }
        this$0.hideProgress();
        ActivityLoginBinding activityLoginBinding3 = this$0.binding;
        if (activityLoginBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityLoginBinding = activityLoginBinding3;
        }
        TextView textView2 = activityLoginBinding.loginBtn;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.loginBtn");
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(textView2, message);
    }

    private final void setupClgSpinner() {
        getLoginViewModel().getColleges().observe(this, new Observer() { // from class: in.etuwa.app.ui.login.LoginActivity$$ExternalSyntheticLambda5
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LoginActivity.setupClgSpinner$lambda$9(LoginActivity.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupClgSpinner$lambda$9(LoginActivity this$0, Resource resource) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            ArrayList<Colleges> arrayList = (ArrayList) resource.getData();
            if (arrayList != null) {
                this$0.renderList(arrayList);
                return;
            }
            return;
        }
        if (i == 2) {
            this$0.showProgress();
            return;
        }
        if (i == 3) {
            this$0.hideProgress();
            return;
        }
        if (i != 4) {
            return;
        }
        this$0.hideProgress();
        ActivityLoginBinding activityLoginBinding = this$0.binding;
        if (activityLoginBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityLoginBinding = null;
        }
        TextView textView = activityLoginBinding.loginBtn;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.loginBtn");
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(textView, message);
    }

    private final void renderList(ArrayList<Colleges> users) {
        getSpinnerAdapter().addItems(users);
        this.originalList = users;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override // in.etuwa.app.ui.login.CollegeListAdapter.CallBack
    public void collegeSelected(String clgId, String baseUrl, String regUrl, String clgName) {
        Intrinsics.checkNotNullParameter(clgId, "clgId");
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        Intrinsics.checkNotNullParameter(regUrl, "regUrl");
        Intrinsics.checkNotNullParameter(clgName, "clgName");
        ActivityLoginBinding activityLoginBinding = this.binding;
        ActivityLoginBinding activityLoginBinding2 = null;
        if (activityLoginBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityLoginBinding = null;
        }
        activityLoginBinding.rvCollegeList.setVisibility(8);
        ActivityLoginBinding activityLoginBinding3 = this.binding;
        if (activityLoginBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityLoginBinding3 = null;
        }
        activityLoginBinding3.clgSearchBtn.setVisibility(8);
        ActivityLoginBinding activityLoginBinding4 = this.binding;
        if (activityLoginBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityLoginBinding4 = null;
        }
        activityLoginBinding4.clgSearchView.setVisibility(8);
        ActivityLoginBinding activityLoginBinding5 = this.binding;
        if (activityLoginBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityLoginBinding5 = null;
        }
        activityLoginBinding5.collgeName.setVisibility(0);
        ActivityLoginBinding activityLoginBinding6 = this.binding;
        if (activityLoginBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityLoginBinding6 = null;
        }
        activityLoginBinding6.loginMainLyt.setVisibility(0);
        ActivityLoginBinding activityLoginBinding7 = this.binding;
        if (activityLoginBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityLoginBinding7 = null;
        }
        activityLoginBinding7.collgeName.setText(clgName);
        ActivityLoginBinding activityLoginBinding8 = this.binding;
        if (activityLoginBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityLoginBinding8 = null;
        }
        activityLoginBinding8.changeBtn.setText("Change College?");
        ActivityLoginBinding activityLoginBinding9 = this.binding;
        if (activityLoginBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityLoginBinding2 = activityLoginBinding9;
        }
        activityLoginBinding2.changeBtn.setVisibility(0);
        getLoginViewModel().setCollege(new Colleges(clgId, baseUrl, regUrl, clgName));
    }
}