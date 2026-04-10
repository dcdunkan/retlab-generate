package in.etuwa.app.data.model.leave.duty;

import androidx.core.app.NotificationCompat;
import com.itextpdf.forms.xfdf.XfdfConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DutyLeaveDirectApply.kt */
/* loaded from: classes3.dex */
public final /* data */ class DutyLeaveDirectApply {
    private final String from_date;
    private final String head;
    private final String id;
    private final String reason;
    private final String status;
    private final String to_date;
    private final String url;

    public static /* synthetic */ DutyLeaveDirectApply copy$default(DutyLeaveDirectApply dutyLeaveDirectApply, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
        if ((i & 1) != 0) {
            str = dutyLeaveDirectApply.id;
        }
        if ((i & 2) != 0) {
            str2 = dutyLeaveDirectApply.reason;
        }
        String str8 = str2;
        if ((i & 4) != 0) {
            str3 = dutyLeaveDirectApply.from_date;
        }
        String str9 = str3;
        if ((i & 8) != 0) {
            str4 = dutyLeaveDirectApply.to_date;
        }
        String str10 = str4;
        if ((i & 16) != 0) {
            str5 = dutyLeaveDirectApply.head;
        }
        String str11 = str5;
        if ((i & 32) != 0) {
            str6 = dutyLeaveDirectApply.status;
        }
        String str12 = str6;
        if ((i & 64) != 0) {
            str7 = dutyLeaveDirectApply.url;
        }
        return dutyLeaveDirectApply.copy(str, str8, str9, str10, str11, str12, str7);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getReason() {
        return this.reason;
    }

    /* renamed from: component3, reason: from getter */
    public final String getFrom_date() {
        return this.from_date;
    }

    /* renamed from: component4, reason: from getter */
    public final String getTo_date() {
        return this.to_date;
    }

    /* renamed from: component5, reason: from getter */
    public final String getHead() {
        return this.head;
    }

    /* renamed from: component6, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: component7, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public final DutyLeaveDirectApply copy(String id, String reason, String from_date, String to_date, String head, String status, String url) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(reason, "reason");
        Intrinsics.checkNotNullParameter(from_date, "from_date");
        Intrinsics.checkNotNullParameter(to_date, "to_date");
        Intrinsics.checkNotNullParameter(head, "head");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(url, "url");
        return new DutyLeaveDirectApply(id, reason, from_date, to_date, head, status, url);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DutyLeaveDirectApply)) {
            return false;
        }
        DutyLeaveDirectApply dutyLeaveDirectApply = (DutyLeaveDirectApply) other;
        return Intrinsics.areEqual(this.id, dutyLeaveDirectApply.id) && Intrinsics.areEqual(this.reason, dutyLeaveDirectApply.reason) && Intrinsics.areEqual(this.from_date, dutyLeaveDirectApply.from_date) && Intrinsics.areEqual(this.to_date, dutyLeaveDirectApply.to_date) && Intrinsics.areEqual(this.head, dutyLeaveDirectApply.head) && Intrinsics.areEqual(this.status, dutyLeaveDirectApply.status) && Intrinsics.areEqual(this.url, dutyLeaveDirectApply.url);
    }

    public int hashCode() {
        return (((((((((((this.id.hashCode() * 31) + this.reason.hashCode()) * 31) + this.from_date.hashCode()) * 31) + this.to_date.hashCode()) * 31) + this.head.hashCode()) * 31) + this.status.hashCode()) * 31) + this.url.hashCode();
    }

    public String toString() {
        return "DutyLeaveDirectApply(id=" + this.id + ", reason=" + this.reason + ", from_date=" + this.from_date + ", to_date=" + this.to_date + ", head=" + this.head + ", status=" + this.status + ", url=" + this.url + ")";
    }

    public DutyLeaveDirectApply(String id, String reason, String from_date, String to_date, String head, String status, String url) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(reason, "reason");
        Intrinsics.checkNotNullParameter(from_date, "from_date");
        Intrinsics.checkNotNullParameter(to_date, "to_date");
        Intrinsics.checkNotNullParameter(head, "head");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(url, "url");
        this.id = id;
        this.reason = reason;
        this.from_date = from_date;
        this.to_date = to_date;
        this.head = head;
        this.status = status;
        this.url = url;
    }

    public final String getId() {
        return this.id;
    }

    public final String getReason() {
        return this.reason;
    }

    public final String getFrom_date() {
        return this.from_date;
    }

    public final String getTo_date() {
        return this.to_date;
    }

    public final String getHead() {
        return this.head;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getUrl() {
        return this.url;
    }
}