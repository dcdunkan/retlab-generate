package in.etuwa.app.data.model.hostel.gcekhostel.registration;

import androidx.core.app.NotificationCompat;
import com.itextpdf.forms.xfdf.XfdfConstants;
import in.etuwa.app.ui.attendance.bydaynew.attendaceday.AttendanceDayDialogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Registration.kt */
/* loaded from: classes3.dex */
public final /* data */ class Registration {
    private final String added_at;
    private final String id;
    private final String print;
    private final String reg_type;
    private final String semester;
    private final String status;

    public static /* synthetic */ Registration copy$default(Registration registration, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = registration.id;
        }
        if ((i & 2) != 0) {
            str2 = registration.semester;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = registration.status;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = registration.reg_type;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            str5 = registration.added_at;
        }
        String str10 = str5;
        if ((i & 32) != 0) {
            str6 = registration.print;
        }
        return registration.copy(str, str7, str8, str9, str10, str6);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getSemester() {
        return this.semester;
    }

    /* renamed from: component3, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: component4, reason: from getter */
    public final String getReg_type() {
        return this.reg_type;
    }

    /* renamed from: component5, reason: from getter */
    public final String getAdded_at() {
        return this.added_at;
    }

    /* renamed from: component6, reason: from getter */
    public final String getPrint() {
        return this.print;
    }

    public final Registration copy(String id, String semester, String status, String reg_type, String added_at, String print) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(semester, "semester");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(reg_type, "reg_type");
        Intrinsics.checkNotNullParameter(added_at, "added_at");
        Intrinsics.checkNotNullParameter(print, "print");
        return new Registration(id, semester, status, reg_type, added_at, print);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Registration)) {
            return false;
        }
        Registration registration = (Registration) other;
        return Intrinsics.areEqual(this.id, registration.id) && Intrinsics.areEqual(this.semester, registration.semester) && Intrinsics.areEqual(this.status, registration.status) && Intrinsics.areEqual(this.reg_type, registration.reg_type) && Intrinsics.areEqual(this.added_at, registration.added_at) && Intrinsics.areEqual(this.print, registration.print);
    }

    public int hashCode() {
        return (((((((((this.id.hashCode() * 31) + this.semester.hashCode()) * 31) + this.status.hashCode()) * 31) + this.reg_type.hashCode()) * 31) + this.added_at.hashCode()) * 31) + this.print.hashCode();
    }

    public String toString() {
        return "Registration(id=" + this.id + ", semester=" + this.semester + ", status=" + this.status + ", reg_type=" + this.reg_type + ", added_at=" + this.added_at + ", print=" + this.print + ")";
    }

    public Registration(String id, String semester, String status, String reg_type, String added_at, String print) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(semester, "semester");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(reg_type, "reg_type");
        Intrinsics.checkNotNullParameter(added_at, "added_at");
        Intrinsics.checkNotNullParameter(print, "print");
        this.id = id;
        this.semester = semester;
        this.status = status;
        this.reg_type = reg_type;
        this.added_at = added_at;
        this.print = print;
    }

    public final String getId() {
        return this.id;
    }

    public final String getSemester() {
        return this.semester;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getReg_type() {
        return this.reg_type;
    }

    public final String getAdded_at() {
        return this.added_at;
    }

    public final String getPrint() {
        return this.print;
    }
}