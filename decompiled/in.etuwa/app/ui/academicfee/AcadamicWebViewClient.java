package in.etuwa.app.ui.academicfee;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;
import com.itextpdf.svg.SvgConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: AcadamicPaymentActivity.kt */
/* loaded from: classes4.dex */
public final class AcadamicWebViewClient extends WebViewClient {
    private final AppCompatActivity context;

    public final AppCompatActivity getContext() {
        return this.context;
    }

    public AcadamicWebViewClient(AppCompatActivity context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView view, String url) {
        Intrinsics.checkNotNull(url);
        if (!url.contentEquals("https://www.sbiepay.com/secure/AggregatorHostedListener#no-back-button")) {
            String str = url;
            if (!StringsKt.contains$default((CharSequence) str, (CharSequence) "https://epay.federalbank.co.in/FedPaymentsV1/Payments.ashx", false, 2, (Object) null)) {
                if (StringsKt.contains$default((CharSequence) str, (CharSequence) "https://etlab.gcek.ac.in/fee/student/index/", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, (CharSequence) "aftercollect", false, 2, (Object) null)) {
                    this.context.setResult(1);
                    this.context.finish();
                }
                super.onPageFinished(view, url);
            }
        }
        Intrinsics.checkNotNull(view);
        view.setVisibility(0);
        super.onPageFinished(view, url);
    }
}