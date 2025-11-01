package in.etuwa.app.data.model.semregistration.list;

import androidx.core.app.NotificationCompat;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RegisterList.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lin/etuwa/app/data/model/semregistration/list/RegisterList;", "", "id", "", "semesterAppliedFrom", NotificationCompat.CATEGORY_STATUS, "date", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDate", "()Ljava/lang/String;", "getId", "getSemesterAppliedFrom", "getStatus", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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