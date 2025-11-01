package in.etuwa.app.ui.academicfee;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;
import com.itextpdf.svg.SvgConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: AcadamicPaymentActivity.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Lin/etuwa/app/ui/academicfee/AcadamicWebViewClient;", "Landroid/webkit/WebViewClient;", "context", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "getContext", "()Landroidx/appcompat/app/AppCompatActivity;", "onPageFinished", "", SvgConstants.Tags.VIEW, "Landroid/webkit/WebView;", "url", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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