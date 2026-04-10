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