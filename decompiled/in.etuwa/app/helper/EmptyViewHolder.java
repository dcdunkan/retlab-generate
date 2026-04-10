package in.etuwa.app.helper;

import android.view.View;
import in.etuwa.app.ui.base.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EmptyViewHolder.kt */
/* loaded from: classes3.dex */
public final class EmptyViewHolder extends BaseViewHolder {
    @Override // in.etuwa.app.ui.base.BaseViewHolder
    protected void clear() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmptyViewHolder(View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
    }
}