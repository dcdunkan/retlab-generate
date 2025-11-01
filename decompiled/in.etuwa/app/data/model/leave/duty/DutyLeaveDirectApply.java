package in.etuwa.app.data.model.leave.duty;

import androidx.core.app.NotificationCompat;
import com.itextpdf.forms.xfdf.XfdfConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DutyLeaveDirectApply.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003JO\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006!"}, d2 = {"Lin/etuwa/app/data/model/leave/duty/DutyLeaveDirectApply;", "", "id", "", "reason", "from_date", "to_date", XfdfConstants.HEAD, NotificationCompat.CATEGORY_STATUS, "url", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFrom_date", "()Ljava/lang/String;", "getHead", "getId", "getReason", "getStatus", "getTo_date", "getUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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