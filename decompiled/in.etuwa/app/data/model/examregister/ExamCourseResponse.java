package in.etuwa.app.data.model.examregister;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import in.etuwa.app.ui.attendance.bydaynew.attendaceday.AttendanceDayDialogKt;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExamCourseResponse.kt */
/* loaded from: classes3.dex */
public final /* data */ class ExamCourseResponse {
    private final boolean abc_id_verification;
    private final String academicyear;
    private final String admission_no;
    private final String batch_id;
    private final boolean can_update;
    private final String category;
    private final boolean check_box_status;
    private final ArrayList<ExamCourse> course;
    private final String degree;
    private final String end_date;
    private final String error;
    private final String exam_year;
    private final boolean fee_status;
    private final ArrayList<FixedHeadGroup> fixedHeadGroup;
    private final boolean is_registered;
    private final boolean login;
    private final String month;
    private final String name;
    private final boolean registration_slip;
    private final String semester;
    private final String start_date;

    /* renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    /* renamed from: component10, reason: from getter */
    public final String getAcademicyear() {
        return this.academicyear;
    }

    /* renamed from: component11, reason: from getter */
    public final String getMonth() {
        return this.month;
    }

    /* renamed from: component12, reason: from getter */
    public final String getExam_year() {
        return this.exam_year;
    }

    /* renamed from: component13, reason: from getter */
    public final String getCategory() {
        return this.category;
    }

    /* renamed from: component14, reason: from getter */
    public final String getBatch_id() {
        return this.batch_id;
    }

    /* renamed from: component15, reason: from getter */
    public final String getAdmission_no() {
        return this.admission_no;
    }

    /* renamed from: component16, reason: from getter */
    public final String getError() {
        return this.error;
    }

    /* renamed from: component17, reason: from getter */
    public final boolean getAbc_id_verification() {
        return this.abc_id_verification;
    }

    /* renamed from: component18, reason: from getter */
    public final boolean getFee_status() {
        return this.fee_status;
    }

    /* renamed from: component19, reason: from getter */
    public final boolean getCheck_box_status() {
        return this.check_box_status;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIs_registered() {
        return this.is_registered;
    }

    public final ArrayList<ExamCourse> component20() {
        return this.course;
    }

    public final ArrayList<FixedHeadGroup> component21() {
        return this.fixedHeadGroup;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getCan_update() {
        return this.can_update;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getRegistration_slip() {
        return this.registration_slip;
    }

    /* renamed from: component5, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component6, reason: from getter */
    public final String getDegree() {
        return this.degree;
    }

    /* renamed from: component7, reason: from getter */
    public final String getSemester() {
        return this.semester;
    }

    /* renamed from: component8, reason: from getter */
    public final String getStart_date() {
        return this.start_date;
    }

    /* renamed from: component9, reason: from getter */
    public final String getEnd_date() {
        return this.end_date;
    }

    public final ExamCourseResponse copy(boolean login, boolean is_registered, boolean can_update, boolean registration_slip, String name, String degree, String semester, String start_date, String end_date, String academicyear, String month, String exam_year, String category, String batch_id, String admission_no, String error, boolean abc_id_verification, boolean fee_status, boolean check_box_status, ArrayList<ExamCourse> course, ArrayList<FixedHeadGroup> fixedHeadGroup) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(degree, "degree");
        Intrinsics.checkNotNullParameter(semester, "semester");
        Intrinsics.checkNotNullParameter(start_date, "start_date");
        Intrinsics.checkNotNullParameter(end_date, "end_date");
        Intrinsics.checkNotNullParameter(academicyear, "academicyear");
        Intrinsics.checkNotNullParameter(month, "month");
        Intrinsics.checkNotNullParameter(exam_year, "exam_year");
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(batch_id, "batch_id");
        Intrinsics.checkNotNullParameter(admission_no, "admission_no");
        Intrinsics.checkNotNullParameter(error, "error");
        Intrinsics.checkNotNullParameter(course, "course");
        Intrinsics.checkNotNullParameter(fixedHeadGroup, "fixedHeadGroup");
        return new ExamCourseResponse(login, is_registered, can_update, registration_slip, name, degree, semester, start_date, end_date, academicyear, month, exam_year, category, batch_id, admission_no, error, abc_id_verification, fee_status, check_box_status, course, fixedHeadGroup);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExamCourseResponse)) {
            return false;
        }
        ExamCourseResponse examCourseResponse = (ExamCourseResponse) other;
        return this.login == examCourseResponse.login && this.is_registered == examCourseResponse.is_registered && this.can_update == examCourseResponse.can_update && this.registration_slip == examCourseResponse.registration_slip && Intrinsics.areEqual(this.name, examCourseResponse.name) && Intrinsics.areEqual(this.degree, examCourseResponse.degree) && Intrinsics.areEqual(this.semester, examCourseResponse.semester) && Intrinsics.areEqual(this.start_date, examCourseResponse.start_date) && Intrinsics.areEqual(this.end_date, examCourseResponse.end_date) && Intrinsics.areEqual(this.academicyear, examCourseResponse.academicyear) && Intrinsics.areEqual(this.month, examCourseResponse.month) && Intrinsics.areEqual(this.exam_year, examCourseResponse.exam_year) && Intrinsics.areEqual(this.category, examCourseResponse.category) && Intrinsics.areEqual(this.batch_id, examCourseResponse.batch_id) && Intrinsics.areEqual(this.admission_no, examCourseResponse.admission_no) && Intrinsics.areEqual(this.error, examCourseResponse.error) && this.abc_id_verification == examCourseResponse.abc_id_verification && this.fee_status == examCourseResponse.fee_status && this.check_box_status == examCourseResponse.check_box_status && Intrinsics.areEqual(this.course, examCourseResponse.course) && Intrinsics.areEqual(this.fixedHeadGroup, examCourseResponse.fixedHeadGroup);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v42 */
    /* JADX WARN: Type inference failed for: r0v43 */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v30, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v32, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v4, types: [boolean] */
    public int hashCode() {
        boolean z = this.login;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        ?? r2 = this.is_registered;
        int i2 = r2;
        if (r2 != 0) {
            i2 = 1;
        }
        int i3 = (i + i2) * 31;
        ?? r22 = this.can_update;
        int i4 = r22;
        if (r22 != 0) {
            i4 = 1;
        }
        int i5 = (i3 + i4) * 31;
        ?? r23 = this.registration_slip;
        int i6 = r23;
        if (r23 != 0) {
            i6 = 1;
        }
        int hashCode = (((((((((((((((((((((((((i5 + i6) * 31) + this.name.hashCode()) * 31) + this.degree.hashCode()) * 31) + this.semester.hashCode()) * 31) + this.start_date.hashCode()) * 31) + this.end_date.hashCode()) * 31) + this.academicyear.hashCode()) * 31) + this.month.hashCode()) * 31) + this.exam_year.hashCode()) * 31) + this.category.hashCode()) * 31) + this.batch_id.hashCode()) * 31) + this.admission_no.hashCode()) * 31) + this.error.hashCode()) * 31;
        ?? r24 = this.abc_id_verification;
        int i7 = r24;
        if (r24 != 0) {
            i7 = 1;
        }
        int i8 = (hashCode + i7) * 31;
        ?? r25 = this.fee_status;
        int i9 = r25;
        if (r25 != 0) {
            i9 = 1;
        }
        int i10 = (i8 + i9) * 31;
        boolean z2 = this.check_box_status;
        return ((((i10 + (z2 ? 1 : z2 ? 1 : 0)) * 31) + this.course.hashCode()) * 31) + this.fixedHeadGroup.hashCode();
    }

    public String toString() {
        return "ExamCourseResponse(login=" + this.login + ", is_registered=" + this.is_registered + ", can_update=" + this.can_update + ", registration_slip=" + this.registration_slip + ", name=" + this.name + ", degree=" + this.degree + ", semester=" + this.semester + ", start_date=" + this.start_date + ", end_date=" + this.end_date + ", academicyear=" + this.academicyear + ", month=" + this.month + ", exam_year=" + this.exam_year + ", category=" + this.category + ", batch_id=" + this.batch_id + ", admission_no=" + this.admission_no + ", error=" + this.error + ", abc_id_verification=" + this.abc_id_verification + ", fee_status=" + this.fee_status + ", check_box_status=" + this.check_box_status + ", course=" + this.course + ", fixedHeadGroup=" + this.fixedHeadGroup + ")";
    }

    public ExamCourseResponse(boolean z, boolean z2, boolean z3, boolean z4, String name, String degree, String semester, String start_date, String end_date, String academicyear, String month, String exam_year, String category, String batch_id, String admission_no, String error, boolean z5, boolean z6, boolean z7, ArrayList<ExamCourse> course, ArrayList<FixedHeadGroup> fixedHeadGroup) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(degree, "degree");
        Intrinsics.checkNotNullParameter(semester, "semester");
        Intrinsics.checkNotNullParameter(start_date, "start_date");
        Intrinsics.checkNotNullParameter(end_date, "end_date");
        Intrinsics.checkNotNullParameter(academicyear, "academicyear");
        Intrinsics.checkNotNullParameter(month, "month");
        Intrinsics.checkNotNullParameter(exam_year, "exam_year");
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(batch_id, "batch_id");
        Intrinsics.checkNotNullParameter(admission_no, "admission_no");
        Intrinsics.checkNotNullParameter(error, "error");
        Intrinsics.checkNotNullParameter(course, "course");
        Intrinsics.checkNotNullParameter(fixedHeadGroup, "fixedHeadGroup");
        this.login = z;
        this.is_registered = z2;
        this.can_update = z3;
        this.registration_slip = z4;
        this.name = name;
        this.degree = degree;
        this.semester = semester;
        this.start_date = start_date;
        this.end_date = end_date;
        this.academicyear = academicyear;
        this.month = month;
        this.exam_year = exam_year;
        this.category = category;
        this.batch_id = batch_id;
        this.admission_no = admission_no;
        this.error = error;
        this.abc_id_verification = z5;
        this.fee_status = z6;
        this.check_box_status = z7;
        this.course = course;
        this.fixedHeadGroup = fixedHeadGroup;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final boolean is_registered() {
        return this.is_registered;
    }

    public final boolean getCan_update() {
        return this.can_update;
    }

    public final boolean getRegistration_slip() {
        return this.registration_slip;
    }

    public final String getName() {
        return this.name;
    }

    public final String getDegree() {
        return this.degree;
    }

    public final String getSemester() {
        return this.semester;
    }

    public final String getStart_date() {
        return this.start_date;
    }

    public final String getEnd_date() {
        return this.end_date;
    }

    public final String getAcademicyear() {
        return this.academicyear;
    }

    public final String getMonth() {
        return this.month;
    }

    public final String getExam_year() {
        return this.exam_year;
    }

    public final String getCategory() {
        return this.category;
    }

    public final String getBatch_id() {
        return this.batch_id;
    }

    public final String getAdmission_no() {
        return this.admission_no;
    }

    public final String getError() {
        return this.error;
    }

    public final boolean getAbc_id_verification() {
        return this.abc_id_verification;
    }

    public final boolean getFee_status() {
        return this.fee_status;
    }

    public final boolean getCheck_box_status() {
        return this.check_box_status;
    }

    public final ArrayList<ExamCourse> getCourse() {
        return this.course;
    }

    public final ArrayList<FixedHeadGroup> getFixedHeadGroup() {
        return this.fixedHeadGroup;
    }
}