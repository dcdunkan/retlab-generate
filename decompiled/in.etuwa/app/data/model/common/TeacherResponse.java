package in.etuwa.app.data.model.common;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TeacherResponse.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\u0002\u0010\bJ\u0019\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J\u0019\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J\u0019\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003JW\u0010\u0010\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00052\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00052\u0018\b\u0002\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR!\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR!\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\n¨\u0006\u0018"}, d2 = {"Lin/etuwa/app/data/model/common/TeacherResponse;", "", "hod", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/common/Teacher;", "Lkotlin/collections/ArrayList;", "staffadvisor", "sub_teacher", "(Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "getHod", "()Ljava/util/ArrayList;", "getStaffadvisor", "getSub_teacher", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class TeacherResponse {
    private final ArrayList<Teacher> hod;
    private final ArrayList<Teacher> staffadvisor;
    private final ArrayList<Teacher> sub_teacher;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TeacherResponse copy$default(TeacherResponse teacherResponse, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, int i, Object obj) {
        if ((i & 1) != 0) {
            arrayList = teacherResponse.hod;
        }
        if ((i & 2) != 0) {
            arrayList2 = teacherResponse.staffadvisor;
        }
        if ((i & 4) != 0) {
            arrayList3 = teacherResponse.sub_teacher;
        }
        return teacherResponse.copy(arrayList, arrayList2, arrayList3);
    }

    public final ArrayList<Teacher> component1() {
        return this.hod;
    }

    public final ArrayList<Teacher> component2() {
        return this.staffadvisor;
    }

    public final ArrayList<Teacher> component3() {
        return this.sub_teacher;
    }

    public final TeacherResponse copy(ArrayList<Teacher> hod, ArrayList<Teacher> staffadvisor, ArrayList<Teacher> sub_teacher) {
        Intrinsics.checkNotNullParameter(hod, "hod");
        Intrinsics.checkNotNullParameter(staffadvisor, "staffadvisor");
        Intrinsics.checkNotNullParameter(sub_teacher, "sub_teacher");
        return new TeacherResponse(hod, staffadvisor, sub_teacher);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TeacherResponse)) {
            return false;
        }
        TeacherResponse teacherResponse = (TeacherResponse) other;
        return Intrinsics.areEqual(this.hod, teacherResponse.hod) && Intrinsics.areEqual(this.staffadvisor, teacherResponse.staffadvisor) && Intrinsics.areEqual(this.sub_teacher, teacherResponse.sub_teacher);
    }

    public int hashCode() {
        return (((this.hod.hashCode() * 31) + this.staffadvisor.hashCode()) * 31) + this.sub_teacher.hashCode();
    }

    public String toString() {
        return "TeacherResponse(hod=" + this.hod + ", staffadvisor=" + this.staffadvisor + ", sub_teacher=" + this.sub_teacher + ")";
    }

    public TeacherResponse(ArrayList<Teacher> hod, ArrayList<Teacher> staffadvisor, ArrayList<Teacher> sub_teacher) {
        Intrinsics.checkNotNullParameter(hod, "hod");
        Intrinsics.checkNotNullParameter(staffadvisor, "staffadvisor");
        Intrinsics.checkNotNullParameter(sub_teacher, "sub_teacher");
        this.hod = hod;
        this.staffadvisor = staffadvisor;
        this.sub_teacher = sub_teacher;
    }

    public final ArrayList<Teacher> getHod() {
        return this.hod;
    }

    public final ArrayList<Teacher> getStaffadvisor() {
        return this.staffadvisor;
    }

    public final ArrayList<Teacher> getSub_teacher() {
        return this.sub_teacher;
    }
}