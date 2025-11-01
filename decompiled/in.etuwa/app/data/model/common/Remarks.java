package in.etuwa.app.data.model.common;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Remarks.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lin/etuwa/app/data/model/common/Remarks;", "", "teacher", "", "remark", "(Ljava/lang/String;Ljava/lang/String;)V", "getRemark", "()Ljava/lang/String;", "getTeacher", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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

    /* renamed from: component1, reason: from getter */
    public final String getTeacher() {
        return this.teacher;
    }

    /* renamed from: component2, reason: from getter */
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