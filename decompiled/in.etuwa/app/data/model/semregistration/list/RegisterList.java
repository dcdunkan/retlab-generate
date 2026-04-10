package in.etuwa.app.data.model.semregistration.list;

import androidx.core.app.NotificationCompat;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RegisterList.kt */
/* loaded from: classes3.dex */
public final /* data */ class RegisterList {

    @SerializedName("date")
    private final String date;

    @SerializedName("id")
    private final String id;

    @SerializedName("semester_applied_from")
    private final String semesterAppliedFrom;

    @SerializedName(NotificationCompat.CATEGORY_STATUS)
    private final String status;

    public static /* synthetic */ RegisterList copy$default(RegisterList registerList, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = registerList.id;
        }
        if ((i & 2) != 0) {
            str2 = registerList.semesterAppliedFrom;
        }
        if ((i & 4) != 0) {
            str3 = registerList.status;
        }
        if ((i & 8) != 0) {
            str4 = registerList.date;
        }
        return registerList.copy(str, str2, str3, str4);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getSemesterAppliedFrom() {
        return this.semesterAppliedFrom;
    }

    /* renamed from: component3, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: component4, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    public final RegisterList copy(String id, String semesterAppliedFrom, String status, String date) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(semesterAppliedFrom, "semesterAppliedFrom");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(date, "date");
        return new RegisterList(id, semesterAppliedFrom, status, date);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RegisterList)) {
            return false;
        }
        RegisterList registerList = (RegisterList) other;
        return Intrinsics.areEqual(this.id, registerList.id) && Intrinsics.areEqual(this.semesterAppliedFrom, registerList.semesterAppliedFrom) && Intrinsics.areEqual(this.status, registerList.status) && Intrinsics.areEqual(this.date, registerList.date);
    }

    public int hashCode() {
        return (((((this.id.hashCode() * 31) + this.semesterAppliedFrom.hashCode()) * 31) + this.status.hashCode()) * 31) + this.date.hashCode();
    }

    public String toString() {
        return "RegisterList(id=" + this.id + ", semesterAppliedFrom=" + this.semesterAppliedFrom + ", status=" + this.status + ", date=" + this.date + ")";
    }

    public RegisterList(String id, String semesterAppliedFrom, String status, String date) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(semesterAppliedFrom, "semesterAppliedFrom");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(date, "date");
        this.id = id;
        this.semesterAppliedFrom = semesterAppliedFrom;
        this.status = status;
        this.date = date;
    }

    public final String getId() {
        return this.id;
    }

    public final String getSemesterAppliedFrom() {
        return this.semesterAppliedFrom;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getDate() {
        return this.date;
    }
}