package in.etuwa.app.ui.internship;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;
import in.etuwa.app.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VerifiedCertificateActivity.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lin/etuwa/app/ui/internship/VerifiedCertificateActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "videoLink", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class VerifiedCertificateActivity extends AppCompatActivity {
    private String videoLink = "";

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_verified_certificate);
            Bundle extras = getIntent().getExtras();
            Intrinsics.checkNotNull(extras);
            String string = extras.getString("url");
            if (string == null) {
                string = "";
            }
            this.videoLink = string;
            System.out.println((Object) ("==================" + string));
            getIntent().getStringExtra("url");
            WebView webView = (WebView) findViewById(R.id.verified_certificate_WV);
            webView.setWebViewClient(new WebViewClient());
            if (Intrinsics.areEqual(this.videoLink, "")) {
                return;
            }
            String str = this.videoLink;
            if (str != null) {
                webView.loadUrl(str);
            }
            webView.getSettings().setJavaScriptEnabled(true);
        } catch (NullPointerException unused) {
        }
    }
}