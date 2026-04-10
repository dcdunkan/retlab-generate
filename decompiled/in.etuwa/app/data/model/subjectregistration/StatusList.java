package in.etuwa.app.data.model.subjectregistration;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StatusList.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class StatusList {
    private final String name;
    private final String status;

    public static /* synthetic */ StatusList copy$default(StatusList statusList, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = statusList.name;
        }
        if ((i & 2) != 0) {
            str2 = statusList.status;
        }
        return statusList.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    public final StatusList copy(String name, String status) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(status, "status");
        return new StatusList(name, status);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StatusList)) {
            return false;
        }
        StatusList statusList = (StatusList) other;
        return Intrinsics.areEqual(this.name, statusList.name) && Intrinsics.areEqual(this.status, statusList.status);
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + this.status.hashCode();
    }

    public String toString() {
        return "StatusList(name=" + this.name + ", status=" + this.status + ")";
    }

    public StatusList(String name, String status) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(status, "status");
        this.name = name;
        this.status = status;
    }

    public final String getName() {
        return this.name;
    }

    public final String getStatus() {
        return this.status;
    }
}