package in.etuwa.app.data.model.grievance;

import androidx.core.app.NotificationCompat;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Grievance.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003JO\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006!"}, d2 = {"Lin/etuwa/app/data/model/grievance/Grievance;", "", "id", "", "grievanceNo", "grievanceType", "date", "subject", NotificationCompat.CATEGORY_STATUS, NotificationCompat.CATEGORY_REMINDER, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDate", "()Ljava/lang/String;", "getGrievanceNo", "getGrievanceType", "getId", "getReminder", "getStatus", "getSubject", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class Grievance {
    private final String date;

    @SerializedName("grievance_no")
    private final String grievanceNo;

    @SerializedName("grievance_type")
    private final String grievanceType;
    private final String id;
    private final String reminder;
    private final String status;
    private final String subject;

    public static /* synthetic */ Grievance copy$default(Grievance grievance, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
        if ((i & 1) != 0) {
            str = grievance.id;
        }
        if ((i & 2) != 0) {
            str2 = grievance.grievanceNo;
        }
        String str8 = str2;
        if ((i & 4) != 0) {
            str3 = grievance.grievanceType;
        }
        String str9 = str3;
        if ((i & 8) != 0) {
            str4 = grievance.date;
        }
        String str10 = str4;
        if ((i & 16) != 0) {
            str5 = grievance.subject;
        }
        String str11 = str5;
        if ((i & 32) != 0) {
            str6 = grievance.status;
        }
        String str12 = str6;
        if ((i & 64) != 0) {
            str7 = grievance.reminder;
        }
        return grievance.copy(str, str8, str9, str10, str11, str12, str7);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getGrievanceNo() {
        return this.grievanceNo;
    }

    /* renamed from: component3, reason: from getter */
    public final String getGrievanceType() {
        return this.grievanceType;
    }

    /* renamed from: component4, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    /* renamed from: component5, reason: from getter */
    public final String getSubject() {
        return this.subject;
    }

    /* renamed from: component6, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: component7, reason: from getter */
    public final String getReminder() {
        return this.reminder;
    }

    public final Grievance copy(String id, String grievanceNo, String grievanceType, String date, String subject, String status, String reminder) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(grievanceNo, "grievanceNo");
        Intrinsics.checkNotNullParameter(grievanceType, "grievanceType");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(subject, "subject");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(reminder, "reminder");
        return new Grievance(id, grievanceNo, grievanceType, date, subject, status, reminder);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Grievance)) {
            return false;
        }
        Grievance grievance = (Grievance) other;
        return Intrinsics.areEqual(this.id, grievance.id) && Intrinsics.areEqual(this.grievanceNo, grievance.grievanceNo) && Intrinsics.areEqual(this.grievanceType, grievance.grievanceType) && Intrinsics.areEqual(this.date, grievance.date) && Intrinsics.areEqual(this.subject, grievance.subject) && Intrinsics.areEqual(this.status, grievance.status) && Intrinsics.areEqual(this.reminder, grievance.reminder);
    }

    public int hashCode() {
        return (((((((((((this.id.hashCode() * 31) + this.grievanceNo.hashCode()) * 31) + this.grievanceType.hashCode()) * 31) + this.date.hashCode()) * 31) + this.subject.hashCode()) * 31) + this.status.hashCode()) * 31) + this.reminder.hashCode();
    }

    public String toString() {
        return "Grievance(id=" + this.id + ", grievanceNo=" + this.grievanceNo + ", grievanceType=" + this.grievanceType + ", date=" + this.date + ", subject=" + this.subject + ", status=" + this.status + ", reminder=" + this.reminder + ")";
    }

    public Grievance(String id, String grievanceNo, String grievanceType, String date, String subject, String status, String reminder) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(grievanceNo, "grievanceNo");
        Intrinsics.checkNotNullParameter(grievanceType, "grievanceType");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(subject, "subject");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(reminder, "reminder");
        this.id = id;
        this.grievanceNo = grievanceNo;
        this.grievanceType = grievanceType;
        this.date = date;
        this.subject = subject;
        this.status = status;
        this.reminder = reminder;
    }

    public final String getId() {
        return this.id;
    }

    public final String getGrievanceNo() {
        return this.grievanceNo;
    }

    public final String getGrievanceType() {
        return this.grievanceType;
    }

    public final String getDate() {
        return this.date;
    }

    public final String getSubject() {
        return this.subject;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getReminder() {
        return this.reminder;
    }
}