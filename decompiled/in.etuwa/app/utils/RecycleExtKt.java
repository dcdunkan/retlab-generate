package in.etuwa.app.utils;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RecycleExt.kt */
/* loaded from: classes5.dex */
public final class RecycleExtKt {
    public static final void show(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "<this>");
        recyclerView.setVisibility(0);
    }

    public static final void hide(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "<this>");
        recyclerView.setVisibility(8);
    }
}