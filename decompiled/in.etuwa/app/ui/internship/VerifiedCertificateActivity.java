package in.etuwa.app.ui.internship;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;
import in.etuwa.app.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VerifiedCertificateActivity.kt */
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