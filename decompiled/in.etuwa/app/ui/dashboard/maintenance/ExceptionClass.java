package in.etuwa.app.ui.dashboard.maintenance;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ExceptionClass.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ExceptionClass extends Exception {
    private final int errorCode;

    public /* synthetic */ ExceptionClass(int i, String str, Throwable th, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : th);
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public ExceptionClass(int i, String str, Throwable th) {
        super(str, th);
        this.errorCode = i;
    }
}