package in.etuwa.app.data.model.university;

import in.etuwa.app.ui.attendance.bydaynew.attendaceday.AttendanceDayDialogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UniversityResult.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class UniversityResult {
    private final String branch;
    private final String code;
    private final String credit;
    private final String grade;
    private final String month_year;
    private final String name;
    private final String pass_status;
    private final String program;
    private final String reg_no;
    private final String semester;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getPass_status() {
        return this.pass_status;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getBranch() {
        return this.branch;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getProgram() {
        return this.program;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getSemester() {
        return this.semester;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getGrade() {
        return this.grade;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getCredit() {
        return this.credit;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getMonth_year() {
        return this.month_year;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getReg_no() {
        return this.reg_no;
    }

    public final UniversityResult copy(String name, String branch, String program, String semester, String code, String grade, String credit, String month_year, String reg_no, String pass_status) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(branch, "branch");
        Intrinsics.checkNotNullParameter(program, "program");
        Intrinsics.checkNotNullParameter(semester, "semester");
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(grade, "grade");
        Intrinsics.checkNotNullParameter(credit, "credit");
        Intrinsics.checkNotNullParameter(month_year, "month_year");
        Intrinsics.checkNotNullParameter(reg_no, "reg_no");
        Intrinsics.checkNotNullParameter(pass_status, "pass_status");
        return new UniversityResult(name, branch, program, semester, code, grade, credit, month_year, reg_no, pass_status);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UniversityResult)) {
            return false;
        }
        UniversityResult universityResult = (UniversityResult) other;
        return Intrinsics.areEqual(this.name, universityResult.name) && Intrinsics.areEqual(this.branch, universityResult.branch) && Intrinsics.areEqual(this.program, universityResult.program) && Intrinsics.areEqual(this.semester, universityResult.semester) && Intrinsics.areEqual(this.code, universityResult.code) && Intrinsics.areEqual(this.grade, universityResult.grade) && Intrinsics.areEqual(this.credit, universityResult.credit) && Intrinsics.areEqual(this.month_year, universityResult.month_year) && Intrinsics.areEqual(this.reg_no, universityResult.reg_no) && Intrinsics.areEqual(this.pass_status, universityResult.pass_status);
    }

    public int hashCode() {
        return (((((((((((((((((this.name.hashCode() * 31) + this.branch.hashCode()) * 31) + this.program.hashCode()) * 31) + this.semester.hashCode()) * 31) + this.code.hashCode()) * 31) + this.grade.hashCode()) * 31) + this.credit.hashCode()) * 31) + this.month_year.hashCode()) * 31) + this.reg_no.hashCode()) * 31) + this.pass_status.hashCode();
    }

    public String toString() {
        return "UniversityResult(name=" + this.name + ", branch=" + this.branch + ", program=" + this.program + ", semester=" + this.semester + ", code=" + this.code + ", grade=" + this.grade + ", credit=" + this.credit + ", month_year=" + this.month_year + ", reg_no=" + this.reg_no + ", pass_status=" + this.pass_status + ")";
    }

    public UniversityResult(String name, String branch, String program, String semester, String code, String grade, String credit, String month_year, String reg_no, String pass_status) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(branch, "branch");
        Intrinsics.checkNotNullParameter(program, "program");
        Intrinsics.checkNotNullParameter(semester, "semester");
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(grade, "grade");
        Intrinsics.checkNotNullParameter(credit, "credit");
        Intrinsics.checkNotNullParameter(month_year, "month_year");
        Intrinsics.checkNotNullParameter(reg_no, "reg_no");
        Intrinsics.checkNotNullParameter(pass_status, "pass_status");
        this.name = name;
        this.branch = branch;
        this.program = program;
        this.semester = semester;
        this.code = code;
        this.grade = grade;
        this.credit = credit;
        this.month_year = month_year;
        this.reg_no = reg_no;
        this.pass_status = pass_status;
    }

    public final String getName() {
        return this.name;
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

    public final String getCode() {
        return this.code;
    }

    public final String getGrade() {
        return this.grade;
    }

    public final String getCredit() {
        return this.credit;
    }

    public final String getMonth_year() {
        return this.month_year;
    }

    public final String getReg_no() {
        return this.reg_no;
    }

    public final String getPass_status() {
        return this.pass_status;
    }
}