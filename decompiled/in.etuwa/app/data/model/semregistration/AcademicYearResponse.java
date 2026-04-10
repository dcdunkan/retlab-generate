package in.etuwa.app.data.model.semregistration;

import com.google.firebase.analytics.FirebaseAnalytics;
import in.etuwa.app.ui.attendance.bydaynew.attendaceday.AttendanceDayDialogKt;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AcademicYearResponse.kt */
/* loaded from: classes3.dex */
public final /* data */ class AcademicYearResponse {
    private final ArrayList<AcademicYear> additional_electives;
    private final ArrayList<AcademicYear> electives;
    private final ArrayList<AcademicYear> globalelectives;
    private final ArrayList<AcademicYear> honours;
    private final boolean login;
    private final ArrayList<AcademicYear> minors;
    private final ArrayList<AcademicYear> program_electives;
    private final String semester;
    private final String semester_id;

    /* renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    /* renamed from: component2, reason: from getter */
    public final String getSemester() {
        return this.semester;
    }

    /* renamed from: component3, reason: from getter */
    public final String getSemester_id() {
        return this.semester_id;
    }

    public final ArrayList<AcademicYear> component4() {
        return this.honours;
    }

    public final ArrayList<AcademicYear> component5() {
        return this.minors;
    }

    public final ArrayList<AcademicYear> component6() {
        return this.electives;
    }

    public final ArrayList<AcademicYear> component7() {
        return this.globalelectives;
    }

    public final ArrayList<AcademicYear> component8() {
        return this.additional_electives;
    }

    public final ArrayList<AcademicYear> component9() {
        return this.program_electives;
    }

    public final AcademicYearResponse copy(boolean login, String semester, String semester_id, ArrayList<AcademicYear> honours, ArrayList<AcademicYear> minors, ArrayList<AcademicYear> electives, ArrayList<AcademicYear> globalelectives, ArrayList<AcademicYear> additional_electives, ArrayList<AcademicYear> program_electives) {
        Intrinsics.checkNotNullParameter(semester, "semester");
        Intrinsics.checkNotNullParameter(semester_id, "semester_id");
        Intrinsics.checkNotNullParameter(honours, "honours");
        Intrinsics.checkNotNullParameter(minors, "minors");
        Intrinsics.checkNotNullParameter(electives, "electives");
        Intrinsics.checkNotNullParameter(globalelectives, "globalelectives");
        Intrinsics.checkNotNullParameter(additional_electives, "additional_electives");
        Intrinsics.checkNotNullParameter(program_electives, "program_electives");
        return new AcademicYearResponse(login, semester, semester_id, honours, minors, electives, globalelectives, additional_electives, program_electives);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AcademicYearResponse)) {
            return false;
        }
        AcademicYearResponse academicYearResponse = (AcademicYearResponse) other;
        return this.login == academicYearResponse.login && Intrinsics.areEqual(this.semester, academicYearResponse.semester) && Intrinsics.areEqual(this.semester_id, academicYearResponse.semester_id) && Intrinsics.areEqual(this.honours, academicYearResponse.honours) && Intrinsics.areEqual(this.minors, academicYearResponse.minors) && Intrinsics.areEqual(this.electives, academicYearResponse.electives) && Intrinsics.areEqual(this.globalelectives, academicYearResponse.globalelectives) && Intrinsics.areEqual(this.additional_electives, academicYearResponse.additional_electives) && Intrinsics.areEqual(this.program_electives, academicYearResponse.program_electives);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    public int hashCode() {
        boolean z = this.login;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (((((((((((((((r0 * 31) + this.semester.hashCode()) * 31) + this.semester_id.hashCode()) * 31) + this.honours.hashCode()) * 31) + this.minors.hashCode()) * 31) + this.electives.hashCode()) * 31) + this.globalelectives.hashCode()) * 31) + this.additional_electives.hashCode()) * 31) + this.program_electives.hashCode();
    }

    public String toString() {
        return "AcademicYearResponse(login=" + this.login + ", semester=" + this.semester + ", semester_id=" + this.semester_id + ", honours=" + this.honours + ", minors=" + this.minors + ", electives=" + this.electives + ", globalelectives=" + this.globalelectives + ", additional_electives=" + this.additional_electives + ", program_electives=" + this.program_electives + ")";
    }

    public AcademicYearResponse(boolean z, String semester, String semester_id, ArrayList<AcademicYear> honours, ArrayList<AcademicYear> minors, ArrayList<AcademicYear> electives, ArrayList<AcademicYear> globalelectives, ArrayList<AcademicYear> additional_electives, ArrayList<AcademicYear> program_electives) {
        Intrinsics.checkNotNullParameter(semester, "semester");
        Intrinsics.checkNotNullParameter(semester_id, "semester_id");
        Intrinsics.checkNotNullParameter(honours, "honours");
        Intrinsics.checkNotNullParameter(minors, "minors");
        Intrinsics.checkNotNullParameter(electives, "electives");
        Intrinsics.checkNotNullParameter(globalelectives, "globalelectives");
        Intrinsics.checkNotNullParameter(additional_electives, "additional_electives");
        Intrinsics.checkNotNullParameter(program_electives, "program_electives");
        this.login = z;
        this.semester = semester;
        this.semester_id = semester_id;
        this.honours = honours;
        this.minors = minors;
        this.electives = electives;
        this.globalelectives = globalelectives;
        this.additional_electives = additional_electives;
        this.program_electives = program_electives;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final String getSemester() {
        return this.semester;
    }

    public final String getSemester_id() {
        return this.semester_id;
    }

    public final ArrayList<AcademicYear> getHonours() {
        return this.honours;
    }

    public final ArrayList<AcademicYear> getMinors() {
        return this.minors;
    }

    public final ArrayList<AcademicYear> getElectives() {
        return this.electives;
    }

    public final ArrayList<AcademicYear> getGlobalelectives() {
        return this.globalelectives;
    }

    public final ArrayList<AcademicYear> getAdditional_electives() {
        return this.additional_electives;
    }

    public final ArrayList<AcademicYear> getProgram_electives() {
        return this.program_electives;
    }
}