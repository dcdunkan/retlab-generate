package in.etuwa.app.data.model.subjectregistration;

import androidx.core.app.NotificationCompat;
import in.etuwa.app.ui.attendance.bydaynew.attendaceday.AttendanceDayDialogKt;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SubjectRegistration.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bHÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003JK\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR!\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Lin/etuwa/app/data/model/subjectregistration/SubjectRegistration;", "", "id", "", AttendanceDayDialogKt.ARG_SEM, NotificationCompat.CATEGORY_STATUS, "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/subjectregistration/StatusList;", "Lkotlin/collections/ArrayList;", "category", "added_at", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;)V", "getAdded_at", "()Ljava/lang/String;", "getCategory", "getId", "getSemester", "getStatus", "()Ljava/util/ArrayList;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class SubjectRegistration {
    private final String added_at;
    private final String category;
    private final String id;
    private final String semester;
    private final ArrayList<StatusList> status;

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

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getSemester() {
        return this.semester;
    }

    public final ArrayList<StatusList> component3() {
        return this.status;
    }

    /* renamed from: component4, reason: from getter */
    public final String getCategory() {
        return this.category;
    }

    /* renamed from: component5, reason: from getter */
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