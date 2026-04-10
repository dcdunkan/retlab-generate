package in.etuwa.app.data.model.subjectregistration;

import androidx.core.app.NotificationCompat;
import in.etuwa.app.ui.attendance.bydaynew.attendaceday.AttendanceDayDialogKt;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SubjectRegistration.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class SubjectRegistration {
    private final String added_at;
    private final String category;
    private final String id;
    private final String semester;
    private final ArrayList<StatusList> status;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SubjectRegistration copy$default(SubjectRegistration subjectRegistration, String str, String str2, ArrayList arrayList, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = subjectRegistration.id;
        }
        if ((i & 2) != 0) {
            str2 = subjectRegistration.semester;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            arrayList = subjectRegistration.status;
        }
        ArrayList arrayList2 = arrayList;
        if ((i & 8) != 0) {
            str3 = subjectRegistration.category;
        }
        String str6 = str3;
        if ((i & 16) != 0) {
            str4 = subjectRegistration.added_at;
        }
        return subjectRegistration.copy(str, str5, arrayList2, str6, str4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSemester() {
        return this.semester;
    }

    public final ArrayList<StatusList> component3() {
        return this.status;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getCategory() {
        return this.category;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getAdded_at() {
        return this.added_at;
    }

    public final SubjectRegistration copy(String id, String semester, ArrayList<StatusList> status, String category, String added_at) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(semester, "semester");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(added_at, "added_at");
        return new SubjectRegistration(id, semester, status, category, added_at);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SubjectRegistration)) {
            return false;
        }
        SubjectRegistration subjectRegistration = (SubjectRegistration) other;
        return Intrinsics.areEqual(this.id, subjectRegistration.id) && Intrinsics.areEqual(this.semester, subjectRegistration.semester) && Intrinsics.areEqual(this.status, subjectRegistration.status) && Intrinsics.areEqual(this.category, subjectRegistration.category) && Intrinsics.areEqual(this.added_at, subjectRegistration.added_at);
    }

    public int hashCode() {
        return (((((((this.id.hashCode() * 31) + this.semester.hashCode()) * 31) + this.status.hashCode()) * 31) + this.category.hashCode()) * 31) + this.added_at.hashCode();
    }

    public String toString() {
        return "SubjectRegistration(id=" + this.id + ", semester=" + this.semester + ", status=" + this.status + ", category=" + this.category + ", added_at=" + this.added_at + ")";
    }

    public SubjectRegistration(String id, String semester, ArrayList<StatusList> status, String category, String added_at) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(semester, "semester");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(added_at, "added_at");
        this.id = id;
        this.semester = semester;
        this.status = status;
        this.category = category;
        this.added_at = added_at;
    }

    public final String getId() {
        return this.id;
    }

    public final String getSemester() {
        return this.semester;
    }

    public final ArrayList<StatusList> getStatus() {
        return this.status;
    }

    public final String getCategory() {
        return this.category;
    }

    public final String getAdded_at() {
        return this.added_at;
    }
}