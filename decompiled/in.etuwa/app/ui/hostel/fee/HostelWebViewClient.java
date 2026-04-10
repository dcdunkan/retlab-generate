package in.etuwa.app.ui.hostel.fee;

import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.itextpdf.svg.SvgConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HostelPaymentActivity.kt */
/* JADX INFO: loaded from: classes5.dex */
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

    /* JADX WARN: Removed duplicated region for block: B:24:0x007c  */
    @Override // android.webkit.WebViewClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onPageFinished(android.webkit.WebView r8, java.lang.String r9) {
        /*
            r7 = this;
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9)
            java.lang.String r0 = "https://www.sbiepay.com/secure/AggregatorHostedListener#no-back-button"
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = r9.contentEquals(r0)
            r1 = 0
            if (r0 != 0) goto L7c
            r0 = r9
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            java.lang.String r2 = "https://epay.federalbank.co.in/FedPaymentsV1/Payments.ashx"
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r3 = 2
            r4 = 0
            boolean r2 = kotlin.text.StringsKt.contains$default(r0, r2, r1, r3, r4)
            if (r2 == 0) goto L1e
            goto L7c
        L1e:
            java.lang.String r2 = "https://etlab.gcek.ac.in/hostel/student"
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = kotlin.text.StringsKt.contains$default(r0, r2, r1, r3, r4)
            r5 = 1
            if (r2 != 0) goto L71
            java.lang.String r2 = "aftercollect"
            r6 = r2
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = kotlin.text.StringsKt.contains$default(r0, r6, r1, r3, r4)
            if (r6 == 0) goto L35
            goto L71
        L35:
            java.lang.String r6 = "https://gcek.etlab.in/hostel/student"
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = kotlin.text.StringsKt.contains$default(r0, r6, r1, r3, r4)
            if (r6 != 0) goto L66
            r6 = r2
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = kotlin.text.StringsKt.contains$default(r0, r6, r1, r3, r4)
            if (r6 == 0) goto L49
            goto L66
        L49:
            java.lang.String r6 = "https://mace.etlab.in/hostel/student"
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = kotlin.text.StringsKt.contains$default(r0, r6, r1, r3, r4)
            if (r6 != 0) goto L5b
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r0 = kotlin.text.StringsKt.contains$default(r0, r2, r1, r3, r4)
            if (r0 == 0) goto L89
        L5b:
            androidx.appcompat.app.AppCompatActivity r0 = r7.context
            r0.setResult(r5)
            androidx.appcompat.app.AppCompatActivity r0 = r7.context
            r0.finish()
            goto L89
        L66:
            androidx.appcompat.app.AppCompatActivity r0 = r7.context
            r0.setResult(r3)
            androidx.appcompat.app.AppCompatActivity r0 = r7.context
            r0.finish()
            goto L89
        L71:
            androidx.appcompat.app.AppCompatActivity r0 = r7.context
            r0.setResult(r5)
            androidx.appcompat.app.AppCompatActivity r0 = r7.context
            r0.finish()
            goto L89
        L7c:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            r8.setVisibility(r1)
            androidx.constraintlayout.widget.ConstraintLayout r0 = r7.progressBar
            if (r0 == 0) goto L89
            in.etuwa.app.utils.PrograssExtKt.hide(r0)
        L89:
            super.onPageFinished(r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: in.etuwa.app.ui.hostel.fee.HostelWebViewClient.onPageFinished(android.webkit.WebView, java.lang.String):void");
    }
}