package in.etuwa.app.ui.academicfee;

import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;
import com.itextpdf.svg.SvgConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AcadamicPaymentActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AcadamicWebViewClient extends WebViewClient {
    private final AppCompatActivity context;

    public final AppCompatActivity getContext() {
        return this.context;
    }

    public AcadamicWebViewClient(AppCompatActivity context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003e  */
    @Override // android.webkit.WebViewClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onPageFinished(android.webkit.WebView r6, java.lang.String r7) {
        /*
            r5 = this;
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)
            java.lang.String r0 = "https://www.sbiepay.com/secure/AggregatorHostedListener#no-back-button"
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = r7.contentEquals(r0)
            r1 = 0
            if (r0 != 0) goto L3e
            r0 = r7
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            java.lang.String r2 = "https://epay.federalbank.co.in/FedPaymentsV1/Payments.ashx"
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r3 = 2
            r4 = 0
            boolean r2 = kotlin.text.StringsKt.contains$default(r0, r2, r1, r3, r4)
            if (r2 == 0) goto L1e
            goto L3e
        L1e:
            java.lang.String r2 = "https://etlab.gcek.ac.in/fee/student/index/"
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = kotlin.text.StringsKt.contains$default(r0, r2, r1, r3, r4)
            if (r2 != 0) goto L32
            java.lang.String r2 = "aftercollect"
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r0 = kotlin.text.StringsKt.contains$default(r0, r2, r1, r3, r4)
            if (r0 == 0) goto L44
        L32:
            androidx.appcompat.app.AppCompatActivity r0 = r5.context
            r1 = 1
            r0.setResult(r1)
            androidx.appcompat.app.AppCompatActivity r0 = r5.context
            r0.finish()
            goto L44
        L3e:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            r6.setVisibility(r1)
        L44:
            super.onPageFinished(r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: in.etuwa.app.ui.academicfee.AcadamicWebViewClient.onPageFinished(android.webkit.WebView, java.lang.String):void");
    }
}