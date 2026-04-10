package in.etuwa.app.data.model.counselling;

import androidx.core.app.NotificationCompat;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Counselling.kt */
/* loaded from: classes3.dex */
public final /* data */ class Counselling {

    @SerializedName("counselling_no")
    private final String councellingNo;

    @SerializedName("counselling_type")
    private final String councellingType;
    private final String date;
    private final String id;
    private final String reminder;
    private final String status;

    public static /* synthetic */ Counselling copy$default(Counselling counselling, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = counselling.id;
        }
        if ((i & 2) != 0) {
            str2 = counselling.councellingNo;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = counselling.councellingType;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = counselling.date;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            str5 = counselling.status;
        }
        String str10 = str5;
        if ((i & 32) != 0) {
            str6 = counselling.reminder;
        }
        return counselling.copy(str, str7, str8, str9, str10, str6);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getCouncellingNo() {
        return this.councellingNo;
    }

    /* renamed from: component3, reason: from getter */
    public final String getCouncellingType() {
        return this.councellingType;
    }

    /* renamed from: component4, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    /* renamed from: component5, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: component6, reason: from getter */
    public final String getReminder() {
        return this.reminder;
    }

    public final Counselling copy(String id, String councellingNo, String councellingType, String date, String status, String reminder) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(councellingNo, "councellingNo");
        Intrinsics.checkNotNullParameter(councellingType, "councellingType");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(reminder, "reminder");
        return new Counselling(id, councellingNo, councellingType, date, status, reminder);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Counselling)) {
            return false;
        }
        Counselling counselling = (Counselling) other;
        return Intrinsics.areEqual(this.id, counselling.id) && Intrinsics.areEqual(this.councellingNo, counselling.councellingNo) && Intrinsics.areEqual(this.councellingType, counselling.councellingType) && Intrinsics.areEqual(this.date, counselling.date) && Intrinsics.areEqual(this.status, counselling.status) && Intrinsics.areEqual(this.reminder, counselling.reminder);
    }

    public int hashCode() {
        return (((((((((this.id.hashCode() * 31) + this.councellingNo.hashCode()) * 31) + this.councellingType.hashCode()) * 31) + this.date.hashCode()) * 31) + this.status.hashCode()) * 31) + this.reminder.hashCode();
    }

    public String toString() {
        return "Counselling(id=" + this.id + ", councellingNo=" + this.councellingNo + ", councellingType=" + this.councellingType + ", date=" + this.date + ", status=" + this.status + ", reminder=" + this.reminder + ")";
    }

    public Counselling(String id, String councellingNo, String councellingType, String date, String status, String reminder) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(councellingNo, "councellingNo");
        Intrinsics.checkNotNullParameter(councellingType, "councellingType");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(reminder, "reminder");
        this.id = id;
        this.councellingNo = councellingNo;
        this.councellingType = councellingType;
        this.date = date;
        this.status = status;
        this.reminder = reminder;
    }

    public final String getId() {
        return this.id;
    }

    public final String getCouncellingNo() {
        return this.councellingNo;
    }

    public final String getCouncellingType() {
        return this.councellingType;
    }

    public final String getDate() {
        return this.date;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getReminder() {
        return this.reminder;
    }
}