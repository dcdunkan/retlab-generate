package in.etuwa.app.data.model.university;

import com.google.firebase.messaging.Constants;
import in.etuwa.app.ui.attendance.bydaynew.attendaceday.AttendanceDayDialogKt;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UniversityResultResponse.kt */
/* loaded from: classes3.dex */
public final /* data */ class UniversityResultResponse {
    private final String branch;
    private final String earned_credit;
    private final String error;
    private final String program;
    private final String reg_no;
    private final ArrayList<UniversityResult> result;
    private final String semester;
    private final String sgpa;

    /* renamed from: component1, reason: from getter */
    public final String getReg_no() {
        return this.reg_no;
    }

    /* renamed from: component2, reason: from getter */
    public final String getBranch() {
        return this.branch;
    }

    /* renamed from: component3, reason: from getter */
    public final String getProgram() {
        return this.program;
    }

    /* renamed from: component4, reason: from getter */
    public final String getSemester() {
        return this.semester;
    }

    /* renamed from: component5, reason: from getter */
    public final String getEarned_credit() {
        return this.earned_credit;
    }

    /* renamed from: component6, reason: from getter */
    public final String getSgpa() {
        return this.sgpa;
    }

    public final ArrayList<UniversityResult> component7() {
        return this.result;
    }

    /* renamed from: component8, reason: from getter */
    public final String getError() {
        return this.error;
    }

    public final UniversityResultResponse copy(String reg_no, String branch, String program, String semester, String earned_credit, String sgpa, ArrayList<UniversityResult> result, String error) {
        Intrinsics.checkNotNullParameter(reg_no, "reg_no");
        Intrinsics.checkNotNullParameter(branch, "branch");
        Intrinsics.checkNotNullParameter(program, "program");
        Intrinsics.checkNotNullParameter(semester, "semester");
        Intrinsics.checkNotNullParameter(earned_credit, "earned_credit");
        Intrinsics.checkNotNullParameter(sgpa, "sgpa");
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(error, "error");
        return new UniversityResultResponse(reg_no, branch, program, semester, earned_credit, sgpa, result, error);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UniversityResultResponse)) {
            return false;
        }
        UniversityResultResponse universityResultResponse = (UniversityResultResponse) other;
        return Intrinsics.areEqual(this.reg_no, universityResultResponse.reg_no) && Intrinsics.areEqual(this.branch, universityResultResponse.branch) && Intrinsics.areEqual(this.program, universityResultResponse.program) && Intrinsics.areEqual(this.semester, universityResultResponse.semester) && Intrinsics.areEqual(this.earned_credit, universityResultResponse.earned_credit) && Intrinsics.areEqual(this.sgpa, universityResultResponse.sgpa) && Intrinsics.areEqual(this.result, universityResultResponse.result) && Intrinsics.areEqual(this.error, universityResultResponse.error);
    }

    public int hashCode() {
        return (((((((((((((this.reg_no.hashCode() * 31) + this.branch.hashCode()) * 31) + this.program.hashCode()) * 31) + this.semester.hashCode()) * 31) + this.earned_credit.hashCode()) * 31) + this.sgpa.hashCode()) * 31) + this.result.hashCode()) * 31) + this.error.hashCode();
    }

    public String toString() {
        return "UniversityResultResponse(reg_no=" + this.reg_no + ", branch=" + this.branch + ", program=" + this.program + ", semester=" + this.semester + ", earned_credit=" + this.earned_credit + ", sgpa=" + this.sgpa + ", result=" + this.result + ", error=" + this.error + ")";
    }

    public UniversityResultResponse(String reg_no, String branch, String program, String semester, String earned_credit, String sgpa, ArrayList<UniversityResult> result, String error) {
        Intrinsics.checkNotNullParameter(reg_no, "reg_no");
        Intrinsics.checkNotNullParameter(branch, "branch");
        Intrinsics.checkNotNullParameter(program, "program");
        Intrinsics.checkNotNullParameter(semester, "semester");
        Intrinsics.checkNotNullParameter(earned_credit, "earned_credit");
        Intrinsics.checkNotNullParameter(sgpa, "sgpa");
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(error, "error");
        this.reg_no = reg_no;
        this.branch = branch;
        this.program = program;
        this.semester = semester;
        this.earned_credit = earned_credit;
        this.sgpa = sgpa;
        this.result = result;
        this.error = error;
    }

    public final String getReg_no() {
        return this.reg_no;
    }

    public final String getBranch() {
        return this.branch;
    }

    public final String getProgram() {
        return this.program;
    }

    public final String getSemester() {
        return this.semester;
    }

    public final String getEarned_credit() {
        return this.earned_credit;
    }

    public final String getSgpa() {
        return this.sgpa;
    }

    public final ArrayList<UniversityResult> getResult() {
        return this.result;
    }

    public final String getError() {
        return this.error;
    }
}