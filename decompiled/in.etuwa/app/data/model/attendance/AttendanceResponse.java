package in.etuwa.app.data.model.attendance;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AttendanceResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class AttendanceResponse {

    @SerializedName(Constants.IPC_BUNDLE_KEY_SEND_ERROR)
    @Expose
    private final String error;

    @SerializedName(FirebaseAnalytics.Event.LOGIN)
    @Expose
    private final boolean login;

    @SerializedName("subjects")
    @Expose
    private final ArrayList<Attendance> subjects;
    private final String total_credit;
    private final String total_percent;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AttendanceResponse copy$default(AttendanceResponse attendanceResponse, boolean z, ArrayList arrayList, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = attendanceResponse.login;
        }
        if ((i & 2) != 0) {
            arrayList = attendanceResponse.subjects;
        }
        ArrayList arrayList2 = arrayList;
        if ((i & 4) != 0) {
            str = attendanceResponse.total_credit;
        }
        String str4 = str;
        if ((i & 8) != 0) {
            str2 = attendanceResponse.total_percent;
        }
        String str5 = str2;
        if ((i & 16) != 0) {
            str3 = attendanceResponse.error;
        }
        return attendanceResponse.copy(z, arrayList2, str4, str5, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<Attendance> component2() {
        return this.subjects;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getTotal_credit() {
        return this.total_credit;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getTotal_percent() {
        return this.total_percent;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getError() {
        return this.error;
    }

    public final AttendanceResponse copy(boolean login, ArrayList<Attendance> subjects, String total_credit, String total_percent, String error) {
        Intrinsics.checkNotNullParameter(subjects, "subjects");
        Intrinsics.checkNotNullParameter(total_credit, "total_credit");
        Intrinsics.checkNotNullParameter(total_percent, "total_percent");
        Intrinsics.checkNotNullParameter(error, "error");
        return new AttendanceResponse(login, subjects, total_credit, total_percent, error);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AttendanceResponse)) {
            return false;
        }
        AttendanceResponse attendanceResponse = (AttendanceResponse) other;
        return this.login == attendanceResponse.login && Intrinsics.areEqual(this.subjects, attendanceResponse.subjects) && Intrinsics.areEqual(this.total_credit, attendanceResponse.total_credit) && Intrinsics.areEqual(this.total_percent, attendanceResponse.total_percent) && Intrinsics.areEqual(this.error, attendanceResponse.error);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    public int hashCode() {
        boolean z = this.login;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (((((((r0 * 31) + this.subjects.hashCode()) * 31) + this.total_credit.hashCode()) * 31) + this.total_percent.hashCode()) * 31) + this.error.hashCode();
    }

    public String toString() {
        return "AttendanceResponse(login=" + this.login + ", subjects=" + this.subjects + ", total_credit=" + this.total_credit + ", total_percent=" + this.total_percent + ", error=" + this.error + ")";
    }

    public AttendanceResponse(boolean z, ArrayList<Attendance> subjects, String total_credit, String total_percent, String error) {
        Intrinsics.checkNotNullParameter(subjects, "subjects");
        Intrinsics.checkNotNullParameter(total_credit, "total_credit");
        Intrinsics.checkNotNullParameter(total_percent, "total_percent");
        Intrinsics.checkNotNullParameter(error, "error");
        this.login = z;
        this.subjects = subjects;
        this.total_credit = total_credit;
        this.total_percent = total_percent;
        this.error = error;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<Attendance> getSubjects() {
        return this.subjects;
    }

    public final String getTotal_credit() {
        return this.total_credit;
    }

    public final String getTotal_percent() {
        return this.total_percent;
    }

    public final String getError() {
        return this.error;
    }
}