package in.etuwa.app.data.model.subject;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import in.etuwa.app.ui.store.storeview.StoreFragmentKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Subjects.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003JE\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010!\u001a\u00020\t2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\f\"\u0004\b\u0015\u0010\u000eR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\f\"\u0004\b\u0019\u0010\u000e¨\u0006&"}, d2 = {"Lin/etuwa/app/data/model/subject/Subjects;", "", StoreFragmentKt.SUB_ID, "", "subName", "teacher", "attendanceText", "attendancePercentage", "isSubGe", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getAttendancePercentage", "()Ljava/lang/String;", "setAttendancePercentage", "(Ljava/lang/String;)V", "getAttendanceText", "setAttendanceText", "()Z", "setSubGe", "(Z)V", "getSubId", "setSubId", "getSubName", "setSubName", "getTeacher", "setTeacher", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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

    /* renamed from: component1, reason: from getter */
    public final String getSubId() {
        return this.subId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getSubName() {
        return this.subName;
    }

    /* renamed from: component3, reason: from getter */
    public final String getTeacher() {
        return this.teacher;
    }

    /* renamed from: component4, reason: from getter */
    public final String getAttendanceText() {
        return this.attendanceText;
    }

    /* renamed from: component5, reason: from getter */
    public final String getAttendancePercentage() {
        return this.attendancePercentage;
    }

    /* renamed from: component6, reason: from getter */
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
    public int hashCode() {
        int hashCode = ((((((((this.subId.hashCode() * 31) + this.subName.hashCode()) * 31) + this.teacher.hashCode()) * 31) + this.attendanceText.hashCode()) * 31) + this.attendancePercentage.hashCode()) * 31;
        boolean z = this.isSubGe;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return hashCode + i;
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