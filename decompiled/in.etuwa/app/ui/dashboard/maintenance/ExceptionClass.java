package in.etuwa.app.ui.dashboard.maintenance;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ExceptionClass.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lin/etuwa/app/ui/dashboard/maintenance/ExceptionClass;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "errorCode", "", "message", "", "cause", "", "(ILjava/lang/String;Ljava/lang/Throwable;)V", "getErrorCode", "()I", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
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