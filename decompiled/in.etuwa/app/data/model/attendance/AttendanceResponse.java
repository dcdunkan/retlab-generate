package in.etuwa.app.data.model.attendance;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AttendanceResponse.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0002\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003J\t\u0010\u0019\u001a\u00020\tHÆ\u0003JK\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\tHÖ\u0001R\u0016\u0010\u000b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R&\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000e¨\u0006 "}, d2 = {"Lin/etuwa/app/data/model/attendance/AttendanceResponse;", "", FirebaseAnalytics.Event.LOGIN, "", "subjects", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/attendance/Attendance;", "Lkotlin/collections/ArrayList;", "total_credit", "", "total_percent", Constants.IPC_BUNDLE_KEY_SEND_ERROR, "(ZLjava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getError", "()Ljava/lang/String;", "getLogin", "()Z", "getSubjects", "()Ljava/util/ArrayList;", "getTotal_credit", "getTotal_percent", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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

    /* renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<Attendance> component2() {
        return this.subjects;
    }

    /* renamed from: component3, reason: from getter */
    public final String getTotal_credit() {
        return this.total_credit;
    }

    /* renamed from: component4, reason: from getter */
    public final String getTotal_percent() {
        return this.total_percent;
    }

    /* renamed from: component5, reason: from getter */
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