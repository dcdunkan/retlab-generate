package in.etuwa.app.data.model.common;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TeacherResponse.kt */
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