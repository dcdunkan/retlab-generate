package in.etuwa.app.ui.hostel.fee;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.utils.PrograssExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: HostelPaymentActivity.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001c\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0011"}, d2 = {"Lin/etuwa/app/ui/hostel/fee/HostelWebViewClient;", "Landroid/webkit/WebViewClient;", "context", "Landroidx/appcompat/app/AppCompatActivity;", "progressBar", "Landroidx/constraintlayout/widget/ConstraintLayout;", "(Landroidx/appcompat/app/AppCompatActivity;Landroidx/constraintlayout/widget/ConstraintLayout;)V", "getContext", "()Landroidx/appcompat/app/AppCompatActivity;", "getProgressBar", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "onPageFinished", "", SvgConstants.Tags.VIEW, "Landroid/webkit/WebView;", "url", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HostelWebViewClient extends WebViewClient {
    private final AppCompatActivity context;
    private final ConstraintLayout progressBar;

    public final AppCompatActivity getContext() {
        return this.context;
    }

    public final ConstraintLayout getProgressBar() {
        return this.progressBar;
    }

    public HostelWebViewClient(AppCompatActivity context, ConstraintLayout progressBar) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(progressBar, "progressBar");
        this.context = context;
        this.progressBar = progressBar;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView view, String url) {
        Intrinsics.checkNotNull(url);
        if (!url.contentEquals("https://www.sbiepay.com/secure/AggregatorHostedListener#no-back-button")) {
            String str = url;
            if (!StringsKt.contains$default((CharSequence) str, (CharSequence) "https://epay.federalbank.co.in/FedPaymentsV1/Payments.ashx", false, 2, (Object) null)) {
                if (StringsKt.contains$default((CharSequence) str, (CharSequence) "https://etlab.gcek.ac.in/hostel/student", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, (CharSequence) "aftercollect", false, 2, (Object) null)) {
                    this.context.setResult(1);
                    this.context.finish();
                } else if (StringsKt.contains$default((CharSequence) str, (CharSequence) "https://gcek.etlab.in/hostel/student", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, (CharSequence) "aftercollect", false, 2, (Object) null)) {
                    this.context.setResult(2);
                    this.context.finish();
                } else if (StringsKt.contains$default((CharSequence) str, (CharSequence) "https://mace.etlab.in/hostel/student", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, (CharSequence) "aftercollect", false, 2, (Object) null)) {
                    this.context.setResult(1);
                    this.context.finish();
                }
                super.onPageFinished(view, url);
            }
        }
        Intrinsics.checkNotNull(view);
        view.setVisibility(0);
        ConstraintLayout constraintLayout = this.progressBar;
        if (constraintLayout != null) {
            PrograssExtKt.hide(constraintLayout);
        }
        super.onPageFinished(view, url);
    }
}