package in.etuwa.app.utils;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PrograssExt.kt */
/* loaded from: classes5.dex */
public final class PrograssExtKt {
    public static final void show(ConstraintLayout constraintLayout) {
        Intrinsics.checkNotNullParameter(constraintLayout, "<this>");
        constraintLayout.setVisibility(0);
    }

    public static final void hide(ConstraintLayout constraintLayout) {
        Intrinsics.checkNotNullParameter(constraintLayout, "<this>");
        constraintLayout.setVisibility(8);
    }
}