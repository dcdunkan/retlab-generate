package in.etuwa.app.data.model.common;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Remarks.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class Remarks {
    private final String remark;
    private final String teacher;

    public static /* synthetic */ Remarks copy$default(Remarks remarks, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = remarks.teacher;
        }
        if ((i & 2) != 0) {
            str2 = remarks.remark;
        }
        return remarks.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTeacher() {
        return this.teacher;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getRemark() {
        return this.remark;
    }

    public final Remarks copy(String teacher, String remark) {
        Intrinsics.checkNotNullParameter(teacher, "teacher");
        Intrinsics.checkNotNullParameter(remark, "remark");
        return new Remarks(teacher, remark);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Remarks)) {
            return false;
        }
        Remarks remarks = (Remarks) other;
        return Intrinsics.areEqual(this.teacher, remarks.teacher) && Intrinsics.areEqual(this.remark, remarks.remark);
    }

    public int hashCode() {
        return (this.teacher.hashCode() * 31) + this.remark.hashCode();
    }

    public String toString() {
        return "Remarks(teacher=" + this.teacher + ", remark=" + this.remark + ")";
    }

    public Remarks(String teacher, String remark) {
        Intrinsics.checkNotNullParameter(teacher, "teacher");
        Intrinsics.checkNotNullParameter(remark, "remark");
        this.teacher = teacher;
        this.remark = remark;
    }

    public final String getTeacher() {
        return this.teacher;
    }

    public final String getRemark() {
        return this.remark;
    }
}