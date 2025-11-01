package in.etuwa.app.utils;

import android.view.View;
import android.widget.Toast;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ToastExt.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\u0007\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\b"}, d2 = {"showErrorToast", "", "Landroid/view/View;", "messageRes", "", "showInfoToast", "showSuccessToast", "showWarningToast", "app_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
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