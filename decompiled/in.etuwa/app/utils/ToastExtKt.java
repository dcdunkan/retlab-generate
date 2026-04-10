package in.etuwa.app.utils;

import android.view.View;
import android.widget.Toast;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ToastExt.kt */
/* loaded from: classes5.dex */
public final class ToastExtKt {
    public static final void showInfoToast(View view, String messageRes) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(messageRes, "messageRes");
        Toast.makeText(view.getContext(), messageRes, 0).show();
    }

    public static final void showSuccessToast(View view, String messageRes) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(messageRes, "messageRes");
        Toast.makeText(view.getContext(), messageRes, 0).show();
    }

    public static final void showErrorToast(View view, String messageRes) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(messageRes, "messageRes");
        Toast.makeText(view.getContext(), messageRes, 0).show();
    }

    public static final void showWarningToast(View view, String messageRes) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(messageRes, "messageRes");
        Toast.makeText(view.getContext(), messageRes, 0).show();
    }
}