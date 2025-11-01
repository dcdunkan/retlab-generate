package in.etuwa.app.data.model.examregister;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import in.etuwa.app.ui.attendance.bydaynew.attendaceday.AttendanceDayDialogKt;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExamCourseResponse.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u009d\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\b\u0012\u0006\u0010\u0012\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\b\u0012\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00160\u0015j\b\u0012\u0004\u0012\u00020\u0016`\u0017¢\u0006\u0002\u0010\u0018J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\bHÆ\u0003J\t\u0010.\u001a\u00020\bHÆ\u0003J\t\u0010/\u001a\u00020\bHÆ\u0003J\t\u00100\u001a\u00020\bHÆ\u0003J\t\u00101\u001a\u00020\bHÆ\u0003J\t\u00102\u001a\u00020\bHÆ\u0003J\t\u00103\u001a\u00020\bHÆ\u0003J\u0019\u00104\u001a\u0012\u0012\u0004\u0012\u00020\u00160\u0015j\b\u0012\u0004\u0012\u00020\u0016`\u0017HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\bHÆ\u0003J\t\u00109\u001a\u00020\bHÆ\u0003J\t\u0010:\u001a\u00020\bHÆ\u0003J\t\u0010;\u001a\u00020\bHÆ\u0003J\t\u0010<\u001a\u00020\bHÆ\u0003JÃ\u0001\u0010=\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\b2\u0018\b\u0002\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00160\u0015j\b\u0012\u0004\u0012\u00020\u0016`\u0017HÆ\u0001J\u0013\u0010>\u001a\u00020\u00032\b\u0010?\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010@\u001a\u00020AHÖ\u0001J\t\u0010B\u001a\u00020\bHÖ\u0001R\u0011\u0010\r\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0012\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0011\u0010\u0011\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0010\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001aR!\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00160\u0015j\b\u0012\u0004\u0012\u00020\u0016`\u0017¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001aR\u0011\u0010\f\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001aR\u0011\u0010\u0013\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001aR\u0011\u0010\u000f\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u001eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001eR\u0011\u0010\u000e\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001aR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001aR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001eR\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001aR\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001a¨\u0006C"}, d2 = {"Lin/etuwa/app/data/model/examregister/ExamCourseResponse;", "", FirebaseAnalytics.Event.LOGIN, "", "is_registered", "can_update", "registration_slip", "name", "", "degree", AttendanceDayDialogKt.ARG_SEM, FirebaseAnalytics.Param.START_DATE, FirebaseAnalytics.Param.END_DATE, "academicyear", "month", "exam_year", "category", "batch_id", "admission_no", Constants.IPC_BUNDLE_KEY_SEND_ERROR, "course", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/examregister/ExamCourse;", "Lkotlin/collections/ArrayList;", "(ZZZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V", "getAcademicyear", "()Ljava/lang/String;", "getAdmission_no", "getBatch_id", "getCan_update", "()Z", "getCategory", "getCourse", "()Ljava/util/ArrayList;", "getDegree", "getEnd_date", "getError", "getExam_year", "getLogin", "getMonth", "getName", "getRegistration_slip", "getSemester", "getStart_date", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ExamCourseResponse {
    private final String academicyear;
    private final String admission_no;
    private final String batch_id;
    private final boolean can_update;
    private final String category;
    private final ArrayList<ExamCourse> course;
    private final String degree;
    private final String end_date;
    private final String error;
    private final String exam_year;
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

    public final ArrayList<ExamCourse> component17() {
        return this.course;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIs_registered() {
        return this.is_registered;
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

    public final ExamCourseResponse copy(boolean login, boolean is_registered, boolean can_update, boolean registration_slip, String name, String degree, String semester, String start_date, String end_date, String academicyear, String month, String exam_year, String category, String batch_id, String admission_no, String error, ArrayList<ExamCourse> course) {
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
        return new ExamCourseResponse(login, is_registered, can_update, registration_slip, name, degree, semester, start_date, end_date, academicyear, month, exam_year, category, batch_id, admission_no, error, course);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExamCourseResponse)) {
            return false;
        }
        ExamCourseResponse examCourseResponse = (ExamCourseResponse) other;
        return this.login == examCourseResponse.login && this.is_registered == examCourseResponse.is_registered && this.can_update == examCourseResponse.can_update && this.registration_slip == examCourseResponse.registration_slip && Intrinsics.areEqual(this.name, examCourseResponse.name) && Intrinsics.areEqual(this.degree, examCourseResponse.degree) && Intrinsics.areEqual(this.semester, examCourseResponse.semester) && Intrinsics.areEqual(this.start_date, examCourseResponse.start_date) && Intrinsics.areEqual(this.end_date, examCourseResponse.end_date) && Intrinsics.areEqual(this.academicyear, examCourseResponse.academicyear) && Intrinsics.areEqual(this.month, examCourseResponse.month) && Intrinsics.areEqual(this.exam_year, examCourseResponse.exam_year) && Intrinsics.areEqual(this.category, examCourseResponse.category) && Intrinsics.areEqual(this.batch_id, examCourseResponse.batch_id) && Intrinsics.areEqual(this.admission_no, examCourseResponse.admission_no) && Intrinsics.areEqual(this.error, examCourseResponse.error) && Intrinsics.areEqual(this.course, examCourseResponse.course);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v34 */
    /* JADX WARN: Type inference failed for: r0v35 */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v2, types: [boolean] */
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
        boolean z2 = this.registration_slip;
        return ((((((((((((((((((((((((((i5 + (z2 ? 1 : z2 ? 1 : 0)) * 31) + this.name.hashCode()) * 31) + this.degree.hashCode()) * 31) + this.semester.hashCode()) * 31) + this.start_date.hashCode()) * 31) + this.end_date.hashCode()) * 31) + this.academicyear.hashCode()) * 31) + this.month.hashCode()) * 31) + this.exam_year.hashCode()) * 31) + this.category.hashCode()) * 31) + this.batch_id.hashCode()) * 31) + this.admission_no.hashCode()) * 31) + this.error.hashCode()) * 31) + this.course.hashCode();
    }

    public String toString() {
        return "ExamCourseResponse(login=" + this.login + ", is_registered=" + this.is_registered + ", can_update=" + this.can_update + ", registration_slip=" + this.registration_slip + ", name=" + this.name + ", degree=" + this.degree + ", semester=" + this.semester + ", start_date=" + this.start_date + ", end_date=" + this.end_date + ", academicyear=" + this.academicyear + ", month=" + this.month + ", exam_year=" + this.exam_year + ", category=" + this.category + ", batch_id=" + this.batch_id + ", admission_no=" + this.admission_no + ", error=" + this.error + ", course=" + this.course + ")";
    }

    public ExamCourseResponse(boolean z, boolean z2, boolean z3, boolean z4, String name, String degree, String semester, String start_date, String end_date, String academicyear, String month, String exam_year, String category, String batch_id, String admission_no, String error, ArrayList<ExamCourse> course) {
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
        this.course = course;
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

    public final ArrayList<ExamCourse> getCourse() {
        return this.course;
    }
}