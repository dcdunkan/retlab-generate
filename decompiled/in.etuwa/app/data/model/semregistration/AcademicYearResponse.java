package in.etuwa.app.data.model.semregistration;

import com.google.firebase.analytics.FirebaseAnalytics;
import in.etuwa.app.ui.attendance.bydaynew.attendaceday.AttendanceDayDialogKt;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AcademicYearResponse.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u00ad\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n\u0012\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n\u0012\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n\u0012\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n\u0012\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n\u0012\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n¢\u0006\u0002\u0010\u0010J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\u0019\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nHÆ\u0003J\u0019\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nHÆ\u0003J\u0019\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nHÆ\u0003J\u0019\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nHÆ\u0003J\u0019\u0010$\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nHÆ\u0003J\u0019\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nHÆ\u0003JÃ\u0001\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u0018\b\u0002\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n2\u0018\b\u0002\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n2\u0018\b\u0002\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n2\u0018\b\u0002\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n2\u0018\b\u0002\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n2\u0018\b\u0002\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nHÆ\u0001J\u0013\u0010'\u001a\u00020\u00032\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\t\u0010+\u001a\u00020\u0005HÖ\u0001R!\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R!\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R!\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R!\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R!\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R!\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001b¨\u0006,"}, d2 = {"Lin/etuwa/app/data/model/semregistration/AcademicYearResponse;", "", FirebaseAnalytics.Event.LOGIN, "", AttendanceDayDialogKt.ARG_SEM, "", "semester_id", "honours", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/semregistration/AcademicYear;", "Lkotlin/collections/ArrayList;", "minors", "electives", "globalelectives", "additional_electives", "program_electives", "(ZLjava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "getAdditional_electives", "()Ljava/util/ArrayList;", "getElectives", "getGlobalelectives", "getHonours", "getLogin", "()Z", "getMinors", "getProgram_electives", "getSemester", "()Ljava/lang/String;", "getSemester_id", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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