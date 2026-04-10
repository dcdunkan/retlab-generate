package in.etuwa.app.ui.academicfee;

import android.content.ComponentCallbacks;
import android.os.Bundle;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.appcompat.app.AppCompatActivity;
import in.etuwa.app.R;
import in.etuwa.app.data.network.ApiEndPoints;
import in.etuwa.app.data.preference.SharedPrefManager;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.Charsets;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.core.qualifier.Qualifier;

/* JADX INFO: compiled from: AcadamicPaymentActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AcadamicPaymentActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;
    public WebView webView;

    public AcadamicPaymentActivity() {
        final AcadamicPaymentActivity acadamicPaymentActivity = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.academicfee.AcadamicPaymentActivity$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = acadamicPaymentActivity;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), qualifier, b);
            }
        });
    }

    public final WebView getWebView() {
        WebView webView = this.webView;
        if (webView != null) {
            return webView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("webView");
        return null;
    }

    public final void setWebView(WebView webView) {
        Intrinsics.checkNotNullParameter(webView, "<set-?>");
        this.webView = webView;
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acadamic_payment);
        setTitle(getString(R.string.payment));
        View viewFindViewById = findViewById(R.id.acadamicWeb);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(R.id.acadamicWeb)");
        setWebView((WebView) viewFindViewById);
        String str = null;
        CookieManager.getInstance().removeAllCookies(null);
        CookieManager.getInstance().removeSessionCookies(null);
        CookieManager.getInstance().flush();
        getWebView().clearCache(true);
        getWebView().clearHistory();
        Bundle extras = getIntent().getExtras();
        String string = extras != null ? extras.getString("url") : null;
        WebSettings settings = getWebView().getSettings();
        Intrinsics.checkNotNullExpressionValue(settings, "webView.settings");
        settings.setJavaScriptEnabled(true);
        getWebView().setVisibility(4);
        try {
            str = "LoginForm[username]=" + URLEncoder.encode(getPreference().getUserName(), "UTF-8") + "&LoginForm[password]=" + URLEncoder.encode(getPreference().getPassword(), "UTF-8") + "&url=" + URLEncoder.encode(string, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        WebView webView = getWebView();
        String str2 = getPreference().getBaseUrl() + ApiEndPoints.PAY_LOGIN_URL;
        Intrinsics.checkNotNull(str);
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        webView.postUrl(str2, bytes);
        getWebView().setWebViewClient(new AcadamicWebViewClient(this));
    }
}