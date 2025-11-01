package in.etuwa.app.data.model.university;

import in.etuwa.app.ui.attendance.bydaynew.attendaceday.AttendanceDayDialogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UniversityResult.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003Jm\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000f¨\u0006*"}, d2 = {"Lin/etuwa/app/data/model/university/UniversityResult;", "", "name", "", "branch", "program", AttendanceDayDialogKt.ARG_SEM, "code", "grade", "credit", "month_year", "reg_no", "pass_status", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBranch", "()Ljava/lang/String;", "getCode", "getCredit", "getGrade", "getMonth_year", "getName", "getPass_status", "getProgram", "getReg_no", "getSemester", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component10, reason: from getter */
    public final String getPass_status() {
        return this.pass_status;
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
    public final String getCode() {
        return this.code;
    }

    /* renamed from: component6, reason: from getter */
    public final String getGrade() {
        return this.grade;
    }

    /* renamed from: component7, reason: from getter */
    public final String getCredit() {
        return this.credit;
    }

    /* renamed from: component8, reason: from getter */
    public final String getMonth_year() {
        return this.month_year;
    }

    /* renamed from: component9, reason: from getter */
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