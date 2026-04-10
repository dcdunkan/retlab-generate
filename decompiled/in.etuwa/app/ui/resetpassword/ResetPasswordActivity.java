package in.etuwa.app.ui.resetpassword;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import in.etuwa.app.R;
import in.etuwa.app.data.model.resetpassword.ResetPassword;
import in.etuwa.app.ui.base.BaseActivity;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* JADX INFO: compiled from: ResetPasswordActivity.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class ResetPasswordActivity extends BaseActivity {

    /* JADX INFO: renamed from: resetPasswordViewModel$delegate, reason: from kotlin metadata */
    private final Lazy resetPasswordViewModel;

    /* JADX INFO: compiled from: ResetPasswordActivity.kt */
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

    public ResetPasswordActivity() {
        final ResetPasswordActivity resetPasswordActivity = this;
        final ResetPasswordActivity resetPasswordActivity2 = resetPasswordActivity;
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(resetPasswordActivity);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.resetPasswordViewModel = new ViewModelLazy(Reflection.getOrCreateKotlinClass(ResetPasswordViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.resetpassword.ResetPasswordActivity$special$$inlined$viewModel$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = resetPasswordActivity.getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStore");
                return viewModelStore;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.resetpassword.ResetPasswordActivity$special$$inlined$viewModel$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory(resetPasswordActivity2, Reflection.getOrCreateKotlinClass(ResetPasswordViewModel.class), qualifier, b, null, koinScope);
            }
        });
    }

    private final ResetPasswordViewModel getResetPasswordViewModel() {
        return (ResetPasswordViewModel) this.resetPasswordViewModel.getValue();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset);
        getResetPasswordViewModel().getReset();
        setTitle("Reset Password");
        setUp();
    }

    @Override // in.etuwa.app.ui.base.BaseActivity
    protected void setUp() {
        getResetPasswordViewModel().getResponse().observe(this, new Observer() { // from class: in.etuwa.app.ui.resetpassword.ResetPasswordActivity$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ResetPasswordActivity.setUp$lambda$1(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(ResetPasswordActivity this$0, Resource resource) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            ResetPassword resetPassword = (ResetPassword) resource.getData();
            if (resetPassword != null) {
                this$0.loadResetUrl(resetPassword.getUrl());
                return;
            }
            return;
        }
        if (i == 2) {
            this$0.showProgress();
        } else if (i == 3) {
            this$0.hideProgress();
        } else {
            if (i != 4) {
                return;
            }
            this$0.hideProgress();
        }
    }

    private final void loadResetUrl(String url) {
        WebView webView = (WebView) findViewById(R.id.resetWebView);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);
        webView.getSettings().setJavaScriptEnabled(true);
    }
}