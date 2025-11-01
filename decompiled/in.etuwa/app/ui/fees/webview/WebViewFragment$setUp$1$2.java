package in.etuwa.app.ui.fees.webview;

import android.os.Handler;
import android.os.Looper;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.databinding.FragmentWebviewBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: WebViewFragment.kt */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"in/etuwa/app/ui/fees/webview/WebViewFragment$setUp$1$2", "Landroid/webkit/WebViewClient;", "onPageFinished", "", SvgConstants.Tags.VIEW, "Landroid/webkit/WebView;", "url", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class WebViewFragment$setUp$1$2 extends WebViewClient {
    final /* synthetic */ WebView $this_apply;
    final /* synthetic */ WebViewFragment this$0;

    WebViewFragment$setUp$1$2(WebViewFragment webViewFragment, WebView webView) {
        this.this$0 = webViewFragment;
        this.$this_apply = webView;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView view, String url) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        super.onPageFinished(view, url);
        final String str10 = "javascript:(function() {\n    const btns = document.getElementsByClassName('btn-outline');\n    for (let i = 0; i < btns.length; i++) {\n        if (btns[i].innerText.trim() === 'Spot booking') {\n            btns[i].click();\n            console.log(\"✅ Spot booking clicked\");\n            break;\n        }\n    }\n})();";
        final String str11 = "javascript:(function() {\n    const closeBtn = document.querySelector('button.btn-spot.btn.btn-primary');\n    if (closeBtn) {\n        closeBtn.click();\n        console.log(\"✅ Dialog closed\");\n    } else {\n        console.log(\"❌ Dialog close button not found\");\n    }\n})();";
        str = this.this$0.mobileNumber;
        final String trimIndent = StringsKt.trimIndent("\n                    javascript:(function() {\n                        if (window.__otpTimerStarted__) return;\n                        window.__otpTimerStarted__ = true;\n                \n                        const targetHour = 17;\n                        const targetMinute = 10;\n                        const targetSecond = 0;\n                        const targetMillisecond = 200;\n                                var mobileField = document.getElementById('mobile') || document.getElementsByName('mobile')[0];\n                                var otpBtn = document.querySelector('button.btn-default.btn.btn-primary');\n                                mobileField.focus();\n                                    Object.getOwnPropertyDescriptor(window.HTMLInputElement.prototype, 'value').set.call(mobileField, '" + str + "');\n                                    mobileField.dispatchEvent(new Event('input', { bubbles: true }));\n                                    mobileField.dispatchEvent(new Event('change', { bubbles: true }));\n                                    mobileField.blur();\n                                    const interval = setInterval(() => {\n                            const now = new Date();\n                            if (now.getHours() === targetHour &&\n                                now.getMinutes() === targetMinute &&\n                                now.getSeconds() === targetSecond &&\n                                now.getMilliseconds() >= targetMillisecond) {\n                                \n                                clearInterval(interval);\n                \n                                \n                \n                                if (mobileField && otpBtn) {\n                                    \n                \n                                    otpBtn.click();\n                                    console.log(\"📲 OTP button clicked at 11:30:00 AM\");\n                                } else {\n                                    console.log(\"❌ Mobile field or OTP button not found at 11:30:01 AM\");\n                                }\n                            }\n                        }, 200); // Check every 200ms\n                    })();\n                ");
        final String str12 = "javascript:(function waitAndCloseOtpSentModal() {\n    if (window.__otpSentClosed__) {\n        console.log(\"⚠️ 'OTP Sent' modal already closed.\");\n        return;\n    }\n    const modal = document.querySelector('div.success-modal');\n    const message = modal?.querySelector('p')?.innerText?.trim();\n    const closeBtn = modal?.querySelector('button.btn-close');\n\n    if (message && message.includes(\"OTP sent successfully\") && closeBtn) {\n        closeBtn.click();\n        window.__otpSentClosed__ = true;\n        console.log(\"✅ 'OTP Sent Successfully' modal closed.\");\n    } else {\n        console.log(\"❌ 'OTP Sent' modal not ready yet.\");\n        setTimeout(waitAndCloseOtpSentModal, 500);\n    }\n})();";
        final String str13 = "javascript:(function waitForOTPAndClickVerify() {\n    if (window.__verifyClicked__) return; // prevent re-entry\n    window.__verifyClicked__ = false;\n\n    function allOtpFilled() {\n        const otpInputs = document.querySelectorAll('input.inputStyle');\n        return otpInputs.length === 6 && Array.from(otpInputs).every(input => input.value.trim().length === 1);\n    }\n\n    function tryClick() {\n        if (window.__verifyClicked__) return;\n\n        if (allOtpFilled()) {\n            const verifyBtn = document.querySelector('button.btn-default.w-70.btn.btn-primary');\n            if (verifyBtn) {\n                console.log(\"✅ All OTP fields filled. Clicking verify after 500ms...\");\n                window.__verifyClicked__ = true;\n                setTimeout(() => {\n                    verifyBtn.click();\n                    console.log(\"✅ 'Verify and Register' clicked\");\n                }, 500);\n            } else {\n                console.log(\"❌ Verify button not found\");\n                setTimeout(tryClick, 500);\n            }\n        } else {\n            console.log(\"⏳ Waiting for OTP...\");\n            setTimeout(tryClick, 500);\n        }\n    }\n\n    tryClick();\n})();";
        final String str14 = "javascript:(function waitAndCloseOtpVerifiedModal() {\n    if (window.__otpVerifiedClosed__) {\n        console.log(\"⚠️ 'OTP Verified' modal already closed.\");\n        return;\n    }\n    const modal = document.querySelector('div.success-modal');\n    const message = modal?.querySelector('p')?.innerText?.trim();\n    const closeBtn = modal?.querySelector('button.btn-close');\n\n    if (message && message.includes(\"OTP verified successfully\") && closeBtn) {\n        closeBtn.click();\n        window.__otpVerifiedClosed__ = true;\n        console.log(\"✅ 'OTP Verified Successfully' modal closed.\");\n    } else {\n        console.log(\"❌ 'OTP Verified' modal not ready yet.\");\n        setTimeout(waitAndCloseOtpVerifiedModal, 500);\n    }\n})();";
        final String str15 = "javascript:(function waitAndClick() {\n        if (window.__spotRegClicked__) {\n            console.log(\"⚠️ 'Spot Registration' button already clicked. Skipping.\");\n            return;\n        }\n    const button = document.querySelector('button.add-new-btn.btn.btn-primary');\n    if (button && button.innerText.trim() === 'Spot Registration') {\n        window.__spotRegClicked__ = true;\n        button.click();\n        console.log(\"✅ 'Spot Registration' button clicked\");\n    } else {\n        console.log(\"⏳ Waiting for 'Spot Registration' button...\");\n        setTimeout(waitAndClick, 1000);\n    }\n})();";
        str2 = this.this$0.name;
        str3 = this.this$0.number;
        str4 = this.this$0.place;
        str5 = this.this$0.distance;
        str6 = this.this$0.port;
        str7 = this.this$0.zone;
        str8 = this.this$0.ton;
        str9 = this.this$0.type;
        final String trimIndent2 = StringsKt.trimIndent("\n                    javascript:(function waitAndFillForm() {\n                        if (window.__formFilled__) {\n                            console.log(\"⚠️ Form already filled. Skipping.\");\n                            return;\n                        }\n                \n                        const nameField = document.getElementById('name');\n                        const aadharField = document.getElementById('aadharNo');\n                        const unloadingField = document.getElementById('unloadingPlace');\n                        const distanceField = document.getElementById('distance');\n                \n                        const portSelect = document.querySelector('select[name=\"port\"]');\n                        const preferredZoneSelect = document.querySelector('select[name=\"preferredZone\"]');\n                        const vehicleTypeSelect = document.querySelector('select[name=\"vehicleType\"]');\n                        const tonNeededSelect = document.querySelector('select[name=\"tonNeeded\"]');\n                \n                        if (nameField && aadharField && unloadingField && distanceField &&\n                            portSelect && preferredZoneSelect && vehicleTypeSelect && tonNeededSelect) {\n                \n                            window.__formFilled__ = true;\n                \n                            function fillInput(input, value) {\n                                input.focus();\n                                Object.getOwnPropertyDescriptor(window.HTMLInputElement.prototype, 'value').set.call(input, value);\n                                input.dispatchEvent(new Event('input', { bubbles: true }));\n                                input.dispatchEvent(new Event('change', { bubbles: true }));\n                                input.blur();\n                            }\n                \n                            function selectOption(select, value) {\n                                select.value = value;\n                                select.dispatchEvent(new Event('change', { bubbles: true }));\n                            }\n                \n                            fillInput(nameField, \"" + str2 + "\");\n                            fillInput(aadharField, \"" + str3 + "\");\n                            fillInput(unloadingField, \"" + str4 + "\");\n                            fillInput(distanceField, \"" + str5 + "\");\n                \n                            // Fill port first\n                selectOption(portSelect, \"" + str6 + "\");\n                \n                // Try to fill Preferred Zone and other fields, retrying if needed\n                function tryFillPreferredZone(retries = 5) {\n                    const updatedZoneSelect = document.querySelector('select[name=\"preferredZone\"]');\n                    const tonNeededSelect = document.querySelector('select[name=\"tonNeeded\"]');\n                    const vehicleTypeSelect = document.querySelector('select[name=\"vehicleType\"]');\n                    const registerButton = document.querySelector('button[type=\"submit\"].btn-primary');\n                \n                    if (updatedZoneSelect && updatedZoneSelect.options.length > 1) {\n                        // Fill all dropdowns\n                        selectOption(updatedZoneSelect, \"" + str7 + "\");\n                       \n                     setTimeout(() => {\n                        selectOption(tonNeededSelect, \"" + str8 + "\");\n                        console.log(\"✅ Ton Needed selected.\");\n            \n                        // Fill vehicle type immediately after ton\n                        selectOption(vehicleTypeSelect, \"" + str9 + "\");\n                        console.log(\"✅ Vehicle Type selected.\");\n                        \n                                    // Delay another 500ms and then click Register\n                                    setTimeout(() => {\n                                        if (registerButton) {\n                                            registerButton.click();\n                                            console.log(\"🚀 Form submitted!\");\n                                        } else {\n                                            console.error(\"❌ Register button not found.\");\n                                        }\n                                    }, 500);\n                        \n                    }, 500);\n                \n                        // No more retries needed — we're done\n                        return;\n                    }\n                \n                    // Retry logic\n                    if (retries > 0) {\n                        console.warn(`⚠️ Preferred Zone not ready. Retrying in 500ms...  attempts left)`);\n                        setTimeout(() => tryFillPreferredZone(retries - 1), 500);\n                    } else {\n                        console.error(\"❌ Failed to fill Preferred Zone after multiple attempts.\");\n                    }\n                }\n                \n                // Start after slight initial delay\n                setTimeout(() => {\n                    tryFillPreferredZone(); // Start retry attempts\n                }, 800);\n\n\n        } else {\n            console.log(\"⏳ Waiting for all form elements to load...\");\n            setTimeout(waitAndFillForm, 1000);\n        }\n    })();\n");
        Handler handler = new Handler(Looper.getMainLooper());
        final WebView webView = this.$this_apply;
        final WebViewFragment webViewFragment = this.this$0;
        handler.postDelayed(new Runnable() { // from class: in.etuwa.app.ui.fees.webview.WebViewFragment$setUp$1$2$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                WebViewFragment$setUp$1$2.onPageFinished$lambda$7(webView, str10, str11, trimIndent, str12, str13, str14, str15, webViewFragment, trimIndent2);
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onPageFinished$lambda$7(final WebView this_apply, String clickSpotBooking, final String closeDialog, final String loopClickOtpAtSpecificTime, final String closeOtpSentModal, final String waitForOtpAndClickVerify, final String closeOtpVerifiedModal, final String clickSpotRegistrationButton, final WebViewFragment this$0, final String fillFormJS) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(clickSpotBooking, "$clickSpotBooking");
        Intrinsics.checkNotNullParameter(closeDialog, "$closeDialog");
        Intrinsics.checkNotNullParameter(loopClickOtpAtSpecificTime, "$loopClickOtpAtSpecificTime");
        Intrinsics.checkNotNullParameter(closeOtpSentModal, "$closeOtpSentModal");
        Intrinsics.checkNotNullParameter(waitForOtpAndClickVerify, "$waitForOtpAndClickVerify");
        Intrinsics.checkNotNullParameter(closeOtpVerifiedModal, "$closeOtpVerifiedModal");
        Intrinsics.checkNotNullParameter(clickSpotRegistrationButton, "$clickSpotRegistrationButton");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(fillFormJS, "$fillFormJS");
        this_apply.evaluateJavascript(clickSpotBooking, null);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.etuwa.app.ui.fees.webview.WebViewFragment$setUp$1$2$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                WebViewFragment$setUp$1$2.onPageFinished$lambda$7$lambda$6(this_apply, closeDialog, loopClickOtpAtSpecificTime, closeOtpSentModal, waitForOtpAndClickVerify, closeOtpVerifiedModal, clickSpotRegistrationButton, this$0, fillFormJS);
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onPageFinished$lambda$7$lambda$6(final WebView this_apply, String closeDialog, final String loopClickOtpAtSpecificTime, final String closeOtpSentModal, final String waitForOtpAndClickVerify, final String closeOtpVerifiedModal, final String clickSpotRegistrationButton, final WebViewFragment this$0, final String fillFormJS) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(closeDialog, "$closeDialog");
        Intrinsics.checkNotNullParameter(loopClickOtpAtSpecificTime, "$loopClickOtpAtSpecificTime");
        Intrinsics.checkNotNullParameter(closeOtpSentModal, "$closeOtpSentModal");
        Intrinsics.checkNotNullParameter(waitForOtpAndClickVerify, "$waitForOtpAndClickVerify");
        Intrinsics.checkNotNullParameter(closeOtpVerifiedModal, "$closeOtpVerifiedModal");
        Intrinsics.checkNotNullParameter(clickSpotRegistrationButton, "$clickSpotRegistrationButton");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(fillFormJS, "$fillFormJS");
        this_apply.evaluateJavascript(closeDialog, null);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.etuwa.app.ui.fees.webview.WebViewFragment$setUp$1$2$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                WebViewFragment$setUp$1$2.onPageFinished$lambda$7$lambda$6$lambda$5(this_apply, loopClickOtpAtSpecificTime, closeOtpSentModal, waitForOtpAndClickVerify, closeOtpVerifiedModal, clickSpotRegistrationButton, this$0, fillFormJS);
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onPageFinished$lambda$7$lambda$6$lambda$5(final WebView this_apply, String loopClickOtpAtSpecificTime, final String closeOtpSentModal, final String waitForOtpAndClickVerify, final String closeOtpVerifiedModal, final String clickSpotRegistrationButton, final WebViewFragment this$0, final String fillFormJS) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(loopClickOtpAtSpecificTime, "$loopClickOtpAtSpecificTime");
        Intrinsics.checkNotNullParameter(closeOtpSentModal, "$closeOtpSentModal");
        Intrinsics.checkNotNullParameter(waitForOtpAndClickVerify, "$waitForOtpAndClickVerify");
        Intrinsics.checkNotNullParameter(closeOtpVerifiedModal, "$closeOtpVerifiedModal");
        Intrinsics.checkNotNullParameter(clickSpotRegistrationButton, "$clickSpotRegistrationButton");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(fillFormJS, "$fillFormJS");
        this_apply.evaluateJavascript(loopClickOtpAtSpecificTime, null);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.etuwa.app.ui.fees.webview.WebViewFragment$setUp$1$2$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                WebViewFragment$setUp$1$2.onPageFinished$lambda$7$lambda$6$lambda$5$lambda$4(this_apply, closeOtpSentModal, waitForOtpAndClickVerify, closeOtpVerifiedModal, clickSpotRegistrationButton, this$0, fillFormJS);
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onPageFinished$lambda$7$lambda$6$lambda$5$lambda$4(final WebView this_apply, String closeOtpSentModal, final String waitForOtpAndClickVerify, final String closeOtpVerifiedModal, final String clickSpotRegistrationButton, final WebViewFragment this$0, final String fillFormJS) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(closeOtpSentModal, "$closeOtpSentModal");
        Intrinsics.checkNotNullParameter(waitForOtpAndClickVerify, "$waitForOtpAndClickVerify");
        Intrinsics.checkNotNullParameter(closeOtpVerifiedModal, "$closeOtpVerifiedModal");
        Intrinsics.checkNotNullParameter(clickSpotRegistrationButton, "$clickSpotRegistrationButton");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(fillFormJS, "$fillFormJS");
        this_apply.evaluateJavascript(closeOtpSentModal, null);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.etuwa.app.ui.fees.webview.WebViewFragment$setUp$1$2$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                WebViewFragment$setUp$1$2.onPageFinished$lambda$7$lambda$6$lambda$5$lambda$4$lambda$3(this_apply, waitForOtpAndClickVerify, closeOtpVerifiedModal, clickSpotRegistrationButton, this$0, fillFormJS);
            }
        }, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onPageFinished$lambda$7$lambda$6$lambda$5$lambda$4$lambda$3(final WebView this_apply, String waitForOtpAndClickVerify, final String closeOtpVerifiedModal, final String clickSpotRegistrationButton, final WebViewFragment this$0, final String fillFormJS) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(waitForOtpAndClickVerify, "$waitForOtpAndClickVerify");
        Intrinsics.checkNotNullParameter(closeOtpVerifiedModal, "$closeOtpVerifiedModal");
        Intrinsics.checkNotNullParameter(clickSpotRegistrationButton, "$clickSpotRegistrationButton");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(fillFormJS, "$fillFormJS");
        this_apply.evaluateJavascript(waitForOtpAndClickVerify, null);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.etuwa.app.ui.fees.webview.WebViewFragment$setUp$1$2$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                WebViewFragment$setUp$1$2.onPageFinished$lambda$7$lambda$6$lambda$5$lambda$4$lambda$3$lambda$2(this_apply, closeOtpVerifiedModal, clickSpotRegistrationButton, this$0, fillFormJS);
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onPageFinished$lambda$7$lambda$6$lambda$5$lambda$4$lambda$3$lambda$2(final WebView this_apply, String closeOtpVerifiedModal, final String clickSpotRegistrationButton, final WebViewFragment this$0, final String fillFormJS) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(closeOtpVerifiedModal, "$closeOtpVerifiedModal");
        Intrinsics.checkNotNullParameter(clickSpotRegistrationButton, "$clickSpotRegistrationButton");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(fillFormJS, "$fillFormJS");
        this_apply.evaluateJavascript(closeOtpVerifiedModal, null);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.etuwa.app.ui.fees.webview.WebViewFragment$setUp$1$2$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                WebViewFragment$setUp$1$2.onPageFinished$lambda$7$lambda$6$lambda$5$lambda$4$lambda$3$lambda$2$lambda$1(this_apply, clickSpotRegistrationButton, this$0, fillFormJS);
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onPageFinished$lambda$7$lambda$6$lambda$5$lambda$4$lambda$3$lambda$2$lambda$1(WebView this_apply, String clickSpotRegistrationButton, final WebViewFragment this$0, final String fillFormJS) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(clickSpotRegistrationButton, "$clickSpotRegistrationButton");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(fillFormJS, "$fillFormJS");
        this_apply.evaluateJavascript(clickSpotRegistrationButton, null);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: in.etuwa.app.ui.fees.webview.WebViewFragment$setUp$1$2$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                WebViewFragment$setUp$1$2.onPageFinished$lambda$7$lambda$6$lambda$5$lambda$4$lambda$3$lambda$2$lambda$1$lambda$0(WebViewFragment.this, fillFormJS);
            }
        }, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onPageFinished$lambda$7$lambda$6$lambda$5$lambda$4$lambda$3$lambda$2$lambda$1$lambda$0(WebViewFragment this$0, String fillFormJS) {
        FragmentWebviewBinding fragmentWebviewBinding;
        WebView webView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(fillFormJS, "$fillFormJS");
        fragmentWebviewBinding = this$0.get_binding();
        if (fragmentWebviewBinding == null || (webView = fragmentWebviewBinding.webView) == null) {
            return;
        }
        webView.evaluateJavascript(fillFormJS, null);
    }
}