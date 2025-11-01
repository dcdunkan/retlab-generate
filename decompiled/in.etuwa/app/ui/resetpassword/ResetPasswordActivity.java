package in.etuwa.app.ui.resetpassword;

import android.content.ComponentCallbacks;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import in.etuwa.app.R;
import in.etuwa.app.data.model.resetpassword.ResetPassword;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.ui.base.BaseActivity;
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
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: ResetPasswordActivity.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0014J\u0012\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\b\u0010\u0017\u001a\u00020\u0013H\u0014J\b\u0010\u0018\u001a\u00020\u0013H\u0014J\b\u0010\u0019\u001a\u00020\u0013H\u0002R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lin/etuwa/app/ui/resetpassword/ResetPasswordActivity;", "Lin/etuwa/app/ui/base/BaseActivity;", "()V", "list", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/resetpassword/ResetPassword;", "Lkotlin/collections/ArrayList;", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", "Lkotlin/Lazy;", "resetPasswordViewModel", "Lin/etuwa/app/ui/resetpassword/ResetPasswordViewModel;", "getResetPasswordViewModel", "()Lin/etuwa/app/ui/resetpassword/ResetPasswordViewModel;", "resetPasswordViewModel$delegate", "hideProgress", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setUp", "showProgress", "webViewSetup", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ResetPasswordActivity extends BaseActivity {
    private ArrayList<ResetPassword> list;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;

    /* renamed from: resetPasswordViewModel$delegate, reason: from kotlin metadata */
    private final Lazy resetPasswordViewModel;

    @Override // in.etuwa.app.ui.base.BaseActivity
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseActivity
    protected void setUp() {
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
                ViewModelStore viewModelStore = ComponentActivity.this.getViewModelStore();
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
                return GetViewModelFactoryKt.getViewModelFactory(ViewModelStoreOwner.this, Reflection.getOrCreateKotlinClass(ResetPasswordViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final ResetPasswordActivity resetPasswordActivity3 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.resetpassword.ResetPasswordActivity$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = resetPasswordActivity3;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b2, b3);
            }
        });
        this.list = new ArrayList<>();
    }

    private final ResetPasswordViewModel getResetPasswordViewModel() {
        return (ResetPasswordViewModel) this.resetPasswordViewModel.getValue();
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset);
        setTitle("Reset Password");
        webViewSetup();
    }

    private final void webViewSetup() {
        WebView webView = (WebView) findViewById(R.id.resetWebView);
        webView.setWebViewClient(new WebViewClient());
        if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "engnr.etlab.in", false, 2, (Object) null)) {
            webView.loadUrl("https://engnr.etlab.in/user/resetpassword");
            webView.getSettings().setJavaScriptEnabled(true);
            return;
        }
        if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "gecwyd.etlab.in", false, 2, (Object) null)) {
            webView.loadUrl("https://gecwyd.etlab.in/user/resetpassword");
            webView.getSettings().setJavaScriptEnabled(true);
            return;
        }
        if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "cep.etlab.in", false, 2, (Object) null)) {
            webView.loadUrl("https://cep.etlab.in/user/resetpassword");
            webView.getSettings().setJavaScriptEnabled(true);
            return;
        }
        if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "chinarts.etlab.in", false, 2, (Object) null)) {
            webView.loadUrl("https://chinarts.etlab.in/user/resetpassword");
            webView.getSettings().setJavaScriptEnabled(true);
            return;
        }
        if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "cetkr.etlab.in", false, 2, (Object) null)) {
            webView.loadUrl("https://cetkr.etlab.in/user/resetpassword");
            webView.getSettings().setJavaScriptEnabled(true);
            return;
        }
        if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "coet.etlab.in", false, 2, (Object) null)) {
            webView.loadUrl("https://coet.etlab.in/user/resetpassword");
            webView.getSettings().setJavaScriptEnabled(true);
            return;
        }
        if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "cev.etlab.in/", false, 2, (Object) null)) {
            webView.loadUrl("https://cev.etlab.in/user/resetpassword");
            webView.getSettings().setJavaScriptEnabled(true);
            return;
        }
        if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "geci.etlab.in", false, 2, (Object) null)) {
            webView.loadUrl("https://geci.etlab.in/user/resetpassword");
            webView.getSettings().setJavaScriptEnabled(true);
            return;
        }
        if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "geckkd.etlab.in", false, 2, (Object) null)) {
            webView.loadUrl("https://geckkd.etlab.in/user/resetpassword");
            webView.getSettings().setJavaScriptEnabled(true);
            return;
        }
        if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "gecskp.etlab.in", false, 2, (Object) null)) {
            webView.loadUrl("https://gecskp.etlab.in/user/resetpassword");
            webView.getSettings().setJavaScriptEnabled(true);
            return;
        }
        if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "gectcr.etlab.in", false, 2, (Object) null)) {
            webView.loadUrl("https://gectcr.etlab.in/user/resetpassword");
            webView.getSettings().setJavaScriptEnabled(true);
            return;
        }
        if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "kmea.etlab.in", false, 2, (Object) null)) {
            webView.loadUrl("https://kmea.etlab.in/user/resetpassword");
            webView.getSettings().setJavaScriptEnabled(true);
            return;
        }
        if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "kmeaarts.etlab.in", false, 2, (Object) null)) {
            webView.loadUrl("https://kmeaarts.etlab.in/user/resetpassword");
            webView.getSettings().setJavaScriptEnabled(true);
            return;
        }
        if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "kmeacoa.etlab.in", false, 2, (Object) null)) {
            webView.loadUrl("https://kmeacoa.etlab.in/user/resetpassword");
            webView.getSettings().setJavaScriptEnabled(true);
            return;
        }
        if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "mace.etlab.in", false, 2, (Object) null)) {
            webView.loadUrl("https://mace.etlab.in/user/resetpassword");
            webView.getSettings().setJavaScriptEnabled(true);
            return;
        }
        if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "mcet.etlab.in", false, 2, (Object) null)) {
            webView.loadUrl("https://mcet.etlab.in/user/resetpassword");
            webView.getSettings().setJavaScriptEnabled(true);
            return;
        }
        if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "mgc.etlab.in", false, 2, (Object) null)) {
            webView.loadUrl("https://mgc.etlab.in/user/resetpassword");
            webView.getSettings().setJavaScriptEnabled(true);
            return;
        }
        if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "cmc.etlab.in", false, 2, (Object) null)) {
            webView.loadUrl("https://cmc.etlab.in/user/resetpassword");
            webView.getSettings().setJavaScriptEnabled(true);
            return;
        }
        if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "etlab.mitkannur.ac.in", false, 2, (Object) null)) {
            webView.loadUrl("https://etlab.mitkannur.ac.in/user/resetpassword");
            webView.getSettings().setJavaScriptEnabled(true);
            return;
        }
        if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "mdit.etlab.in", false, 2, (Object) null)) {
            webView.loadUrl("https://mdit.etlab.in/user/resetpassword");
            webView.getSettings().setJavaScriptEnabled(true);
            return;
        }
        if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "mditpoly.etlab.in", false, 2, (Object) null)) {
            webView.loadUrl("https://mditpoly.etlab.in/user/resetpassword");
            webView.getSettings().setJavaScriptEnabled(true);
            return;
        }
        if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "naher.etlab.in", false, 2, (Object) null)) {
            webView.loadUrl("https://naher.etlab.in/user/resetpassword");
            webView.getSettings().setJavaScriptEnabled(true);
            return;
        }
        if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "nssce.etlab.in", false, 2, (Object) null)) {
            webView.loadUrl("https://nssce.etlab.in/user/resetpassword");
            webView.getSettings().setJavaScriptEnabled(true);
            return;
        }
        if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "sadiya.etlab.in", false, 2, (Object) null)) {
            webView.loadUrl("https://sadiya.etlab.in/user/resetpassword");
            webView.getSettings().setJavaScriptEnabled(true);
            return;
        }
        if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "sctce.etlab.in", false, 2, (Object) null)) {
            webView.loadUrl("https://sctce.etlab.in/user/resetpassword");
            webView.getSettings().setJavaScriptEnabled(true);
            return;
        }
        if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "sjcp.etlab.in", false, 2, (Object) null)) {
            webView.loadUrl("https://sjcp.etlab.in/user/resetpassword");
            webView.getSettings().setJavaScriptEnabled(true);
            return;
        }
        if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "snckannur.etlab.in", false, 2, (Object) null)) {
            webView.loadUrl("https://snckannur.etlab.in/user/resetpassword");
            webView.getSettings().setJavaScriptEnabled(true);
            return;
        }
        if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "tkmce.etlab.in", false, 2, (Object) null)) {
            webView.loadUrl("https://tkmce.etlab.in/user/resetpassword");
            webView.getSettings().setJavaScriptEnabled(true);
            return;
        }
        if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "tkmsa.etlab.in", false, 2, (Object) null)) {
            webView.loadUrl("https://tkmsa.etlab.in/user/resetpassword");
            webView.getSettings().setJavaScriptEnabled(true);
            return;
        }
        if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "mea.etlab.in", false, 2, (Object) null)) {
            webView.loadUrl("https://mea.etlab.in/user/resetpassword");
            webView.getSettings().setJavaScriptEnabled(true);
            return;
        }
        if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "q1101.etlab.in", false, 2, (Object) null)) {
            webView.loadUrl("https://q1101.etlab.in/user/resetpassword");
            webView.getSettings().setJavaScriptEnabled(true);
        } else if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "etlab.gcek.ac.in", false, 2, (Object) null)) {
            webView.loadUrl("https://etlab.gcek.ac.in/user/resetpassword");
            webView.getSettings().setJavaScriptEnabled(true);
        } else if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "gcek.etlab.in", false, 2, (Object) null)) {
            webView.loadUrl("https://gcek.etlab.in/user/resetpassword");
            webView.getSettings().setJavaScriptEnabled(true);
        }
    }
}