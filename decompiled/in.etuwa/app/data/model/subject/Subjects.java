package in.etuwa.app.data.model.subject;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import in.etuwa.app.ui.store.storeview.StoreFragmentKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Subjects.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class Subjects {

    @SerializedName("atten_per")
    @Expose
    private String attendancePercentage;

    @SerializedName("atten_text")
    @Expose
    private String attendanceText;
    private boolean isSubGe;

    @SerializedName("sub_id")
    @Expose
    private String subId;

    @SerializedName("sub_name")
    @Expose
    private String subName;

    @SerializedName("teacher_name")
    @Expose
    private String teacher;

    public static /* synthetic */ Subjects copy$default(Subjects subjects, String str, String str2, String str3, String str4, String str5, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = subjects.subId;
        }
        if ((i & 2) != 0) {
            str2 = subjects.subName;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = subjects.teacher;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = subjects.attendanceText;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = subjects.attendancePercentage;
        }
        String str9 = str5;
        if ((i & 32) != 0) {
            z = subjects.isSubGe;
        }
        return subjects.copy(str, str6, str7, str8, str9, z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSubId() {
        return this.subId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSubName() {
        return this.subName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getTeacher() {
        return this.teacher;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getAttendanceText() {
        return this.attendanceText;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getAttendancePercentage() {
        return this.attendancePercentage;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getIsSubGe() {
        return this.isSubGe;
    }

    public final Subjects copy(String subId, String subName, String teacher, String attendanceText, String attendancePercentage, boolean isSubGe) {
        Intrinsics.checkNotNullParameter(subId, "subId");
        Intrinsics.checkNotNullParameter(subName, "subName");
        Intrinsics.checkNotNullParameter(teacher, "teacher");
        Intrinsics.checkNotNullParameter(attendanceText, "attendanceText");
        Intrinsics.checkNotNullParameter(attendancePercentage, "attendancePercentage");
        return new Subjects(subId, subName, teacher, attendanceText, attendancePercentage, isSubGe);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Subjects)) {
            return false;
        }
        Subjects subjects = (Subjects) other;
        return Intrinsics.areEqual(this.subId, subjects.subId) && Intrinsics.areEqual(this.subName, subjects.subName) && Intrinsics.areEqual(this.teacher, subjects.teacher) && Intrinsics.areEqual(this.attendanceText, subjects.attendanceText) && Intrinsics.areEqual(this.attendancePercentage, subjects.attendancePercentage) && this.isSubGe == subjects.isSubGe;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v9, types: [int] */
    public int hashCode() {
        int iHashCode = ((((((((this.subId.hashCode() * 31) + this.subName.hashCode()) * 31) + this.teacher.hashCode()) * 31) + this.attendanceText.hashCode()) * 31) + this.attendancePercentage.hashCode()) * 31;
        boolean z = this.isSubGe;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public String toString() {
        return "Subjects(subId=" + this.subId + ", subName=" + this.subName + ", teacher=" + this.teacher + ", attendanceText=" + this.attendanceText + ", attendancePercentage=" + this.attendancePercentage + ", isSubGe=" + this.isSubGe + ")";
    }

    public Subjects(String subId, String subName, String teacher, String attendanceText, String attendancePercentage, boolean z) {
        Intrinsics.checkNotNullParameter(subId, "subId");
        Intrinsics.checkNotNullParameter(subName, "subName");
        Intrinsics.checkNotNullParameter(teacher, "teacher");
        Intrinsics.checkNotNullParameter(attendanceText, "attendanceText");
        Intrinsics.checkNotNullParameter(attendancePercentage, "attendancePercentage");
        this.subId = subId;
        this.subName = subName;
        this.teacher = teacher;
        this.attendanceText = attendanceText;
        this.attendancePercentage = attendancePercentage;
        this.isSubGe = z;
    }

    public final String getSubId() {
        return this.subId;
    }

    public final void setSubId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.subId = str;
    }

    public final String getSubName() {
        return this.subName;
    }

    public final void setSubName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.subName = str;
    }

    public final String getTeacher() {
        return this.teacher;
    }

    public final void setTeacher(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.teacher = str;
    }

    public final String getAttendanceText() {
        return this.attendanceText;
    }

    public final void setAttendanceText(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.attendanceText = str;
    }

    public final String getAttendancePercentage() {
        return this.attendancePercentage;
    }

    public final void setAttendancePercentage(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.attendancePercentage = str;
    }

    public final boolean isSubGe() {
        return this.isSubGe;
    }

    public final void setSubGe(boolean z) {
        this.isSubGe = z;
    }
}