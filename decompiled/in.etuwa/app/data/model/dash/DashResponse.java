package in.etuwa.app.data.model.dash;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import in.etuwa.etlabstaff.data.model.timetable.TimeTable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DashResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class DashResponse {

    @SerializedName("attendance_forthemonth")
    @Expose
    private final String attendance_forthemonth;

    @SerializedName("attendance_forthesem")
    @Expose
    private final String attendance_forthesem;
    private final String bank_accno;
    private final String bank_branch;
    private final String bank_ifsc_code;
    private final String bank_name;

    @SerializedName("batch_id")
    @Expose
    private final String batchId;

    @SerializedName("clg_mission")
    @Expose
    private final String clgMission;

    @SerializedName("clg_vision")
    @Expose
    private final String clgVision;

    @SerializedName("course")
    @Expose
    private final String course;

    @SerializedName("curnt_sem")
    @Expose
    private final String curnt_sem;

    @SerializedName("current_version")
    @Expose
    private final int currentVersion;

    @SerializedName("dept_mission")
    @Expose
    private final String deptMission;

    @SerializedName("dept_vision")
    @Expose
    private final String deptVision;

    @SerializedName("due_new")
    @Expose
    private final String dueNew;

    @SerializedName(Constants.IPC_BUNDLE_KEY_SEND_ERROR)
    @Expose
    private final String error;

    @SerializedName("fee_engnr_status")
    @Expose
    private final boolean feeEngnrStatus;

    @SerializedName("fee_status")
    @Expose
    private final boolean feeStatus;

    @SerializedName("hostel")
    @Expose
    private final int hostel;

    @SerializedName("hostel_status")
    @Expose
    private final String hostelStatus;

    @SerializedName("info_msg")
    @Expose
    private final String infoMsg;

    @SerializedName("is_engnr")
    @Expose
    private final boolean isEngnr;

    @SerializedName("live_tv_link")
    @Expose
    private final String liveTvLink;

    @SerializedName("live_tv_type")
    @Expose
    private final String liveTvType;

    @SerializedName(FirebaseAnalytics.Event.LOGIN)
    @Expose
    private final boolean login;

    @SerializedName("logout_status")
    @Expose
    private final boolean logout_status;

    @SerializedName("notices")
    @Expose
    private final ArrayList<NoticesDash> notices;

    @SerializedName("password_changed")
    private final boolean passwordChanged;

    @SerializedName("roll_no")
    @Expose
    private final String rollNo;

    @SerializedName("sem_id")
    @Expose
    private final String semId;

    @SerializedName("semreg_default")
    @Expose
    private final boolean semReg;

    @SerializedName("student_id")
    @Expose
    private final String studentId;

    @SerializedName("survey_message")
    @Expose
    private final String surveyMessage;

    @SerializedName("survey_status")
    @Expose
    private final boolean surveyStatus;

    @SerializedName("timetable")
    @Expose
    private final ArrayList<ArrayList<TimeTable>> timetable;
    private final String url;

    @SerializedName("url_sign")
    private final String urlSign;
    private final String usertype;

    @SerializedName("version_code")
    @Expose
    private final int versionCode;

    @SerializedName("version_code_aisat")
    @Expose
    private final int versionCodeAisat;

    @SerializedName("version_code_cep")
    @Expose
    private final int versionCodeCep;

    @SerializedName("version_code_cetkr")
    @Expose
    private final int versionCodeCetkr;

    @SerializedName("version_code_cev")
    @Expose
    private final int versionCodeCev;

    @SerializedName("version_code_coet")
    @Expose
    private final int versionCodeCoet;

    @SerializedName("version_code_engnr")
    @Expose
    private final int versionCodeEngnr;

    @SerializedName("version_code_gcei")
    @Expose
    private final int versionCodeGcei;

    @SerializedName("version_code_gcek")
    @Expose
    private final int versionCodeGcek;

    @SerializedName("version_code_gcekkd")
    @Expose
    private final int versionCodeGcekkd;

    @SerializedName("version_code_gecskp")
    @Expose
    private final int versionCodeGecskp;

    @SerializedName("version_code_gectcr")
    @Expose
    private final int versionCodeGectcr;

    @SerializedName("version_code_gecwyd")
    @Expose
    private final int versionCodeGecwyd;

    @SerializedName("version_code_jecc")
    @Expose
    private final int versionCodeJecc;

    @SerializedName("version_code_kmea")
    @Expose
    private final int versionCodeKmea;

    @SerializedName("version_code_kmeacoa")
    @Expose
    private final int versionCodeKmeacoa;

    @SerializedName("version_code_mace")
    @Expose
    private final int versionCodeMace;

    @SerializedName("version_code_marian")
    @Expose
    private final int versionCodeMarian;

    @SerializedName("version_code_mdit")
    @Expose
    private final int versionCodeMdit;

    @SerializedName("version_code_nssce")
    @Expose
    private final int versionCodeNssce;

    @SerializedName("version_code_sctce")
    @Expose
    private final int versionCodeSctce;

    @SerializedName("version_code_sjcetpalai")
    @Expose
    private final int versionCodeSjcetPalai;

    @SerializedName("version_code_tkmce")
    @Expose
    private final int versionCodeTkmce;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final int getVersionCodeGcek() {
        return this.versionCodeGcek;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final int getVersionCodeGcei() {
        return this.versionCodeGcei;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final int getVersionCodeGcekkd() {
        return this.versionCodeGcekkd;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final int getVersionCodeGecskp() {
        return this.versionCodeGecskp;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final int getVersionCodeGectcr() {
        return this.versionCodeGectcr;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final int getVersionCodeGecwyd() {
        return this.versionCodeGecwyd;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final int getVersionCodeJecc() {
        return this.versionCodeJecc;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final int getVersionCodeKmea() {
        return this.versionCodeKmea;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final int getVersionCodeKmeacoa() {
        return this.versionCodeKmeacoa;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final int getVersionCodeMace() {
        return this.versionCodeMace;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCurnt_sem() {
        return this.curnt_sem;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final int getVersionCodeMarian() {
        return this.versionCodeMarian;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final int getVersionCodeMdit() {
        return this.versionCodeMdit;
    }

    /* JADX INFO: renamed from: component22, reason: from getter */
    public final int getVersionCodeNssce() {
        return this.versionCodeNssce;
    }

    /* JADX INFO: renamed from: component23, reason: from getter */
    public final int getVersionCodeSjcetPalai() {
        return this.versionCodeSjcetPalai;
    }

    /* JADX INFO: renamed from: component24, reason: from getter */
    public final int getVersionCodeTkmce() {
        return this.versionCodeTkmce;
    }

    /* JADX INFO: renamed from: component25, reason: from getter */
    public final int getVersionCode() {
        return this.versionCode;
    }

    /* JADX INFO: renamed from: component26, reason: from getter */
    public final boolean getLogout_status() {
        return this.logout_status;
    }

    /* JADX INFO: renamed from: component27, reason: from getter */
    public final boolean getSemReg() {
        return this.semReg;
    }

    /* JADX INFO: renamed from: component28, reason: from getter */
    public final String getSemId() {
        return this.semId;
    }

    /* JADX INFO: renamed from: component29, reason: from getter */
    public final String getStudentId() {
        return this.studentId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getVersionCodeEngnr() {
        return this.versionCodeEngnr;
    }

    /* JADX INFO: renamed from: component30, reason: from getter */
    public final String getRollNo() {
        return this.rollNo;
    }

    /* JADX INFO: renamed from: component31, reason: from getter */
    public final int getHostel() {
        return this.hostel;
    }

    /* JADX INFO: renamed from: component32, reason: from getter */
    public final String getHostelStatus() {
        return this.hostelStatus;
    }

    /* JADX INFO: renamed from: component33, reason: from getter */
    public final boolean getSurveyStatus() {
        return this.surveyStatus;
    }

    /* JADX INFO: renamed from: component34, reason: from getter */
    public final String getSurveyMessage() {
        return this.surveyMessage;
    }

    /* JADX INFO: renamed from: component35, reason: from getter */
    public final String getBatchId() {
        return this.batchId;
    }

    /* JADX INFO: renamed from: component36, reason: from getter */
    public final String getCourse() {
        return this.course;
    }

    /* JADX INFO: renamed from: component37, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: component38, reason: from getter */
    public final String getUrlSign() {
        return this.urlSign;
    }

    /* JADX INFO: renamed from: component39, reason: from getter */
    public final String getAttendance_forthemonth() {
        return this.attendance_forthemonth;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getVersionCodeSctce() {
        return this.versionCodeSctce;
    }

    /* JADX INFO: renamed from: component40, reason: from getter */
    public final String getAttendance_forthesem() {
        return this.attendance_forthesem;
    }

    public final ArrayList<ArrayList<TimeTable>> component41() {
        return this.timetable;
    }

    /* JADX INFO: renamed from: component42, reason: from getter */
    public final int getCurrentVersion() {
        return this.currentVersion;
    }

    /* JADX INFO: renamed from: component43, reason: from getter */
    public final String getInfoMsg() {
        return this.infoMsg;
    }

    /* JADX INFO: renamed from: component44, reason: from getter */
    public final boolean getIsEngnr() {
        return this.isEngnr;
    }

    /* JADX INFO: renamed from: component45, reason: from getter */
    public final boolean getFeeStatus() {
        return this.feeStatus;
    }

    /* JADX INFO: renamed from: component46, reason: from getter */
    public final String getLiveTvLink() {
        return this.liveTvLink;
    }

    /* JADX INFO: renamed from: component47, reason: from getter */
    public final String getLiveTvType() {
        return this.liveTvType;
    }

    /* JADX INFO: renamed from: component48, reason: from getter */
    public final boolean getPasswordChanged() {
        return this.passwordChanged;
    }

    /* JADX INFO: renamed from: component49, reason: from getter */
    public final String getError() {
        return this.error;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getVersionCodeAisat() {
        return this.versionCodeAisat;
    }

    /* JADX INFO: renamed from: component50, reason: from getter */
    public final String getDueNew() {
        return this.dueNew;
    }

    /* JADX INFO: renamed from: component51, reason: from getter */
    public final String getDeptVision() {
        return this.deptVision;
    }

    /* JADX INFO: renamed from: component52, reason: from getter */
    public final String getDeptMission() {
        return this.deptMission;
    }

    /* JADX INFO: renamed from: component53, reason: from getter */
    public final String getClgVision() {
        return this.clgVision;
    }

    /* JADX INFO: renamed from: component54, reason: from getter */
    public final String getClgMission() {
        return this.clgMission;
    }

    /* JADX INFO: renamed from: component55, reason: from getter */
    public final boolean getFeeEngnrStatus() {
        return this.feeEngnrStatus;
    }

    /* JADX INFO: renamed from: component56, reason: from getter */
    public final String getBank_name() {
        return this.bank_name;
    }

    /* JADX INFO: renamed from: component57, reason: from getter */
    public final String getBank_branch() {
        return this.bank_branch;
    }

    /* JADX INFO: renamed from: component58, reason: from getter */
    public final String getBank_accno() {
        return this.bank_accno;
    }

    /* JADX INFO: renamed from: component59, reason: from getter */
    public final String getBank_ifsc_code() {
        return this.bank_ifsc_code;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getVersionCodeCep() {
        return this.versionCodeCep;
    }

    /* JADX INFO: renamed from: component60, reason: from getter */
    public final String getUsertype() {
        return this.usertype;
    }

    public final ArrayList<NoticesDash> component61() {
        return this.notices;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getVersionCodeCetkr() {
        return this.versionCodeCetkr;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final int getVersionCodeCoet() {
        return this.versionCodeCoet;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final int getVersionCodeCev() {
        return this.versionCodeCev;
    }

    public final DashResponse copy(boolean login, String curnt_sem, int versionCodeEngnr, int versionCodeSctce, int versionCodeAisat, int versionCodeCep, int versionCodeCetkr, int versionCodeCoet, int versionCodeCev, int versionCodeGcek, int versionCodeGcei, int versionCodeGcekkd, int versionCodeGecskp, int versionCodeGectcr, int versionCodeGecwyd, int versionCodeJecc, int versionCodeKmea, int versionCodeKmeacoa, int versionCodeMace, int versionCodeMarian, int versionCodeMdit, int versionCodeNssce, int versionCodeSjcetPalai, int versionCodeTkmce, int versionCode, boolean logout_status, boolean semReg, String semId, String studentId, String rollNo, int hostel, String hostelStatus, boolean surveyStatus, String surveyMessage, String batchId, String course, String url, String urlSign, String attendance_forthemonth, String attendance_forthesem, ArrayList<ArrayList<TimeTable>> timetable, int currentVersion, String infoMsg, boolean isEngnr, boolean feeStatus, String liveTvLink, String liveTvType, boolean passwordChanged, String error, String dueNew, String deptVision, String deptMission, String clgVision, String clgMission, boolean feeEngnrStatus, String bank_name, String bank_branch, String bank_accno, String bank_ifsc_code, String usertype, ArrayList<NoticesDash> notices) {
        Intrinsics.checkNotNullParameter(curnt_sem, "curnt_sem");
        Intrinsics.checkNotNullParameter(semId, "semId");
        Intrinsics.checkNotNullParameter(studentId, "studentId");
        Intrinsics.checkNotNullParameter(rollNo, "rollNo");
        Intrinsics.checkNotNullParameter(hostelStatus, "hostelStatus");
        Intrinsics.checkNotNullParameter(surveyMessage, "surveyMessage");
        Intrinsics.checkNotNullParameter(batchId, "batchId");
        Intrinsics.checkNotNullParameter(course, "course");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(urlSign, "urlSign");
        Intrinsics.checkNotNullParameter(attendance_forthemonth, "attendance_forthemonth");
        Intrinsics.checkNotNullParameter(attendance_forthesem, "attendance_forthesem");
        Intrinsics.checkNotNullParameter(timetable, "timetable");
        Intrinsics.checkNotNullParameter(infoMsg, "infoMsg");
        Intrinsics.checkNotNullParameter(liveTvLink, "liveTvLink");
        Intrinsics.checkNotNullParameter(liveTvType, "liveTvType");
        Intrinsics.checkNotNullParameter(error, "error");
        Intrinsics.checkNotNullParameter(dueNew, "dueNew");
        Intrinsics.checkNotNullParameter(deptVision, "deptVision");
        Intrinsics.checkNotNullParameter(deptMission, "deptMission");
        Intrinsics.checkNotNullParameter(clgVision, "clgVision");
        Intrinsics.checkNotNullParameter(clgMission, "clgMission");
        Intrinsics.checkNotNullParameter(bank_name, "bank_name");
        Intrinsics.checkNotNullParameter(bank_branch, "bank_branch");
        Intrinsics.checkNotNullParameter(bank_accno, "bank_accno");
        Intrinsics.checkNotNullParameter(bank_ifsc_code, "bank_ifsc_code");
        Intrinsics.checkNotNullParameter(usertype, "usertype");
        Intrinsics.checkNotNullParameter(notices, "notices");
        return new DashResponse(login, curnt_sem, versionCodeEngnr, versionCodeSctce, versionCodeAisat, versionCodeCep, versionCodeCetkr, versionCodeCoet, versionCodeCev, versionCodeGcek, versionCodeGcei, versionCodeGcekkd, versionCodeGecskp, versionCodeGectcr, versionCodeGecwyd, versionCodeJecc, versionCodeKmea, versionCodeKmeacoa, versionCodeMace, versionCodeMarian, versionCodeMdit, versionCodeNssce, versionCodeSjcetPalai, versionCodeTkmce, versionCode, logout_status, semReg, semId, studentId, rollNo, hostel, hostelStatus, surveyStatus, surveyMessage, batchId, course, url, urlSign, attendance_forthemonth, attendance_forthesem, timetable, currentVersion, infoMsg, isEngnr, feeStatus, liveTvLink, liveTvType, passwordChanged, error, dueNew, deptVision, deptMission, clgVision, clgMission, feeEngnrStatus, bank_name, bank_branch, bank_accno, bank_ifsc_code, usertype, notices);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DashResponse)) {
            return false;
        }
        DashResponse dashResponse = (DashResponse) other;
        return this.login == dashResponse.login && Intrinsics.areEqual(this.curnt_sem, dashResponse.curnt_sem) && this.versionCodeEngnr == dashResponse.versionCodeEngnr && this.versionCodeSctce == dashResponse.versionCodeSctce && this.versionCodeAisat == dashResponse.versionCodeAisat && this.versionCodeCep == dashResponse.versionCodeCep && this.versionCodeCetkr == dashResponse.versionCodeCetkr && this.versionCodeCoet == dashResponse.versionCodeCoet && this.versionCodeCev == dashResponse.versionCodeCev && this.versionCodeGcek == dashResponse.versionCodeGcek && this.versionCodeGcei == dashResponse.versionCodeGcei && this.versionCodeGcekkd == dashResponse.versionCodeGcekkd && this.versionCodeGecskp == dashResponse.versionCodeGecskp && this.versionCodeGectcr == dashResponse.versionCodeGectcr && this.versionCodeGecwyd == dashResponse.versionCodeGecwyd && this.versionCodeJecc == dashResponse.versionCodeJecc && this.versionCodeKmea == dashResponse.versionCodeKmea && this.versionCodeKmeacoa == dashResponse.versionCodeKmeacoa && this.versionCodeMace == dashResponse.versionCodeMace && this.versionCodeMarian == dashResponse.versionCodeMarian && this.versionCodeMdit == dashResponse.versionCodeMdit && this.versionCodeNssce == dashResponse.versionCodeNssce && this.versionCodeSjcetPalai == dashResponse.versionCodeSjcetPalai && this.versionCodeTkmce == dashResponse.versionCodeTkmce && this.versionCode == dashResponse.versionCode && this.logout_status == dashResponse.logout_status && this.semReg == dashResponse.semReg && Intrinsics.areEqual(this.semId, dashResponse.semId) && Intrinsics.areEqual(this.studentId, dashResponse.studentId) && Intrinsics.areEqual(this.rollNo, dashResponse.rollNo) && this.hostel == dashResponse.hostel && Intrinsics.areEqual(this.hostelStatus, dashResponse.hostelStatus) && this.surveyStatus == dashResponse.surveyStatus && Intrinsics.areEqual(this.surveyMessage, dashResponse.surveyMessage) && Intrinsics.areEqual(this.batchId, dashResponse.batchId) && Intrinsics.areEqual(this.course, dashResponse.course) && Intrinsics.areEqual(this.url, dashResponse.url) && Intrinsics.areEqual(this.urlSign, dashResponse.urlSign) && Intrinsics.areEqual(this.attendance_forthemonth, dashResponse.attendance_forthemonth) && Intrinsics.areEqual(this.attendance_forthesem, dashResponse.attendance_forthesem) && Intrinsics.areEqual(this.timetable, dashResponse.timetable) && this.currentVersion == dashResponse.currentVersion && Intrinsics.areEqual(this.infoMsg, dashResponse.infoMsg) && this.isEngnr == dashResponse.isEngnr && this.feeStatus == dashResponse.feeStatus && Intrinsics.areEqual(this.liveTvLink, dashResponse.liveTvLink) && Intrinsics.areEqual(this.liveTvType, dashResponse.liveTvType) && this.passwordChanged == dashResponse.passwordChanged && Intrinsics.areEqual(this.error, dashResponse.error) && Intrinsics.areEqual(this.dueNew, dashResponse.dueNew) && Intrinsics.areEqual(this.deptVision, dashResponse.deptVision) && Intrinsics.areEqual(this.deptMission, dashResponse.deptMission) && Intrinsics.areEqual(this.clgVision, dashResponse.clgVision) && Intrinsics.areEqual(this.clgMission, dashResponse.clgMission) && this.feeEngnrStatus == dashResponse.feeEngnrStatus && Intrinsics.areEqual(this.bank_name, dashResponse.bank_name) && Intrinsics.areEqual(this.bank_branch, dashResponse.bank_branch) && Intrinsics.areEqual(this.bank_accno, dashResponse.bank_accno) && Intrinsics.areEqual(this.bank_ifsc_code, dashResponse.bank_ifsc_code) && Intrinsics.areEqual(this.usertype, dashResponse.usertype) && Intrinsics.areEqual(this.notices, dashResponse.notices);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v122 */
    /* JADX WARN: Type inference failed for: r0v123 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r2v26, types: [int] */
    /* JADX WARN: Type inference failed for: r2v28, types: [int] */
    /* JADX WARN: Type inference failed for: r2v39, types: [int] */
    /* JADX WARN: Type inference failed for: r2v60, types: [int] */
    /* JADX WARN: Type inference failed for: r2v62, types: [int] */
    /* JADX WARN: Type inference failed for: r2v68, types: [int] */
    /* JADX WARN: Type inference failed for: r2v82 */
    /* JADX WARN: Type inference failed for: r2v83 */
    /* JADX WARN: Type inference failed for: r2v84 */
    /* JADX WARN: Type inference failed for: r2v85 */
    /* JADX WARN: Type inference failed for: r2v86 */
    /* JADX WARN: Type inference failed for: r2v87 */
    /* JADX WARN: Type inference failed for: r2v88 */
    /* JADX WARN: Type inference failed for: r2v89 */
    /* JADX WARN: Type inference failed for: r2v90 */
    /* JADX WARN: Type inference failed for: r2v91 */
    /* JADX WARN: Type inference failed for: r2v92 */
    /* JADX WARN: Type inference failed for: r2v93 */
    public int hashCode() {
        boolean z = this.login;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int iHashCode = ((((((((((((((((((((((((((((((((((((((((((((((((r0 * 31) + this.curnt_sem.hashCode()) * 31) + this.versionCodeEngnr) * 31) + this.versionCodeSctce) * 31) + this.versionCodeAisat) * 31) + this.versionCodeCep) * 31) + this.versionCodeCetkr) * 31) + this.versionCodeCoet) * 31) + this.versionCodeCev) * 31) + this.versionCodeGcek) * 31) + this.versionCodeGcei) * 31) + this.versionCodeGcekkd) * 31) + this.versionCodeGecskp) * 31) + this.versionCodeGectcr) * 31) + this.versionCodeGecwyd) * 31) + this.versionCodeJecc) * 31) + this.versionCodeKmea) * 31) + this.versionCodeKmeacoa) * 31) + this.versionCodeMace) * 31) + this.versionCodeMarian) * 31) + this.versionCodeMdit) * 31) + this.versionCodeNssce) * 31) + this.versionCodeSjcetPalai) * 31) + this.versionCodeTkmce) * 31) + this.versionCode) * 31;
        boolean z2 = this.logout_status;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode + r2) * 31;
        boolean z3 = this.semReg;
        ?? r22 = z3;
        if (z3) {
            r22 = 1;
        }
        int iHashCode2 = (((((((((((i + r22) * 31) + this.semId.hashCode()) * 31) + this.studentId.hashCode()) * 31) + this.rollNo.hashCode()) * 31) + this.hostel) * 31) + this.hostelStatus.hashCode()) * 31;
        boolean z4 = this.surveyStatus;
        ?? r23 = z4;
        if (z4) {
            r23 = 1;
        }
        int iHashCode3 = (((((((((((((((((((((iHashCode2 + r23) * 31) + this.surveyMessage.hashCode()) * 31) + this.batchId.hashCode()) * 31) + this.course.hashCode()) * 31) + this.url.hashCode()) * 31) + this.urlSign.hashCode()) * 31) + this.attendance_forthemonth.hashCode()) * 31) + this.attendance_forthesem.hashCode()) * 31) + this.timetable.hashCode()) * 31) + this.currentVersion) * 31) + this.infoMsg.hashCode()) * 31;
        boolean z5 = this.isEngnr;
        ?? r24 = z5;
        if (z5) {
            r24 = 1;
        }
        int i2 = (iHashCode3 + r24) * 31;
        boolean z6 = this.feeStatus;
        ?? r25 = z6;
        if (z6) {
            r25 = 1;
        }
        int iHashCode4 = (((((i2 + r25) * 31) + this.liveTvLink.hashCode()) * 31) + this.liveTvType.hashCode()) * 31;
        boolean z7 = this.passwordChanged;
        ?? r26 = z7;
        if (z7) {
            r26 = 1;
        }
        int iHashCode5 = (((((((((((((iHashCode4 + r26) * 31) + this.error.hashCode()) * 31) + this.dueNew.hashCode()) * 31) + this.deptVision.hashCode()) * 31) + this.deptMission.hashCode()) * 31) + this.clgVision.hashCode()) * 31) + this.clgMission.hashCode()) * 31;
        boolean z8 = this.feeEngnrStatus;
        return ((((((((((((iHashCode5 + (z8 ? 1 : z8)) * 31) + this.bank_name.hashCode()) * 31) + this.bank_branch.hashCode()) * 31) + this.bank_accno.hashCode()) * 31) + this.bank_ifsc_code.hashCode()) * 31) + this.usertype.hashCode()) * 31) + this.notices.hashCode();
    }

    public String toString() {
        return "DashResponse(login=" + this.login + ", curnt_sem=" + this.curnt_sem + ", versionCodeEngnr=" + this.versionCodeEngnr + ", versionCodeSctce=" + this.versionCodeSctce + ", versionCodeAisat=" + this.versionCodeAisat + ", versionCodeCep=" + this.versionCodeCep + ", versionCodeCetkr=" + this.versionCodeCetkr + ", versionCodeCoet=" + this.versionCodeCoet + ", versionCodeCev=" + this.versionCodeCev + ", versionCodeGcek=" + this.versionCodeGcek + ", versionCodeGcei=" + this.versionCodeGcei + ", versionCodeGcekkd=" + this.versionCodeGcekkd + ", versionCodeGecskp=" + this.versionCodeGecskp + ", versionCodeGectcr=" + this.versionCodeGectcr + ", versionCodeGecwyd=" + this.versionCodeGecwyd + ", versionCodeJecc=" + this.versionCodeJecc + ", versionCodeKmea=" + this.versionCodeKmea + ", versionCodeKmeacoa=" + this.versionCodeKmeacoa + ", versionCodeMace=" + this.versionCodeMace + ", versionCodeMarian=" + this.versionCodeMarian + ", versionCodeMdit=" + this.versionCodeMdit + ", versionCodeNssce=" + this.versionCodeNssce + ", versionCodeSjcetPalai=" + this.versionCodeSjcetPalai + ", versionCodeTkmce=" + this.versionCodeTkmce + ", versionCode=" + this.versionCode + ", logout_status=" + this.logout_status + ", semReg=" + this.semReg + ", semId=" + this.semId + ", studentId=" + this.studentId + ", rollNo=" + this.rollNo + ", hostel=" + this.hostel + ", hostelStatus=" + this.hostelStatus + ", surveyStatus=" + this.surveyStatus + ", surveyMessage=" + this.surveyMessage + ", batchId=" + this.batchId + ", course=" + this.course + ", url=" + this.url + ", urlSign=" + this.urlSign + ", attendance_forthemonth=" + this.attendance_forthemonth + ", attendance_forthesem=" + this.attendance_forthesem + ", timetable=" + this.timetable + ", currentVersion=" + this.currentVersion + ", infoMsg=" + this.infoMsg + ", isEngnr=" + this.isEngnr + ", feeStatus=" + this.feeStatus + ", liveTvLink=" + this.liveTvLink + ", liveTvType=" + this.liveTvType + ", passwordChanged=" + this.passwordChanged + ", error=" + this.error + ", dueNew=" + this.dueNew + ", deptVision=" + this.deptVision + ", deptMission=" + this.deptMission + ", clgVision=" + this.clgVision + ", clgMission=" + this.clgMission + ", feeEngnrStatus=" + this.feeEngnrStatus + ", bank_name=" + this.bank_name + ", bank_branch=" + this.bank_branch + ", bank_accno=" + this.bank_accno + ", bank_ifsc_code=" + this.bank_ifsc_code + ", usertype=" + this.usertype + ", notices=" + this.notices + ")";
    }

    public DashResponse(boolean z, String curnt_sem, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20, int i21, int i22, int i23, boolean z2, boolean z3, String semId, String studentId, String rollNo, int i24, String hostelStatus, boolean z4, String surveyMessage, String batchId, String course, String url, String urlSign, String attendance_forthemonth, String attendance_forthesem, ArrayList<ArrayList<TimeTable>> timetable, int i25, String infoMsg, boolean z5, boolean z6, String liveTvLink, String liveTvType, boolean z7, String error, String dueNew, String deptVision, String deptMission, String clgVision, String clgMission, boolean z8, String bank_name, String bank_branch, String bank_accno, String bank_ifsc_code, String usertype, ArrayList<NoticesDash> notices) {
        Intrinsics.checkNotNullParameter(curnt_sem, "curnt_sem");
        Intrinsics.checkNotNullParameter(semId, "semId");
        Intrinsics.checkNotNullParameter(studentId, "studentId");
        Intrinsics.checkNotNullParameter(rollNo, "rollNo");
        Intrinsics.checkNotNullParameter(hostelStatus, "hostelStatus");
        Intrinsics.checkNotNullParameter(surveyMessage, "surveyMessage");
        Intrinsics.checkNotNullParameter(batchId, "batchId");
        Intrinsics.checkNotNullParameter(course, "course");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(urlSign, "urlSign");
        Intrinsics.checkNotNullParameter(attendance_forthemonth, "attendance_forthemonth");
        Intrinsics.checkNotNullParameter(attendance_forthesem, "attendance_forthesem");
        Intrinsics.checkNotNullParameter(timetable, "timetable");
        Intrinsics.checkNotNullParameter(infoMsg, "infoMsg");
        Intrinsics.checkNotNullParameter(liveTvLink, "liveTvLink");
        Intrinsics.checkNotNullParameter(liveTvType, "liveTvType");
        Intrinsics.checkNotNullParameter(error, "error");
        Intrinsics.checkNotNullParameter(dueNew, "dueNew");
        Intrinsics.checkNotNullParameter(deptVision, "deptVision");
        Intrinsics.checkNotNullParameter(deptMission, "deptMission");
        Intrinsics.checkNotNullParameter(clgVision, "clgVision");
        Intrinsics.checkNotNullParameter(clgMission, "clgMission");
        Intrinsics.checkNotNullParameter(bank_name, "bank_name");
        Intrinsics.checkNotNullParameter(bank_branch, "bank_branch");
        Intrinsics.checkNotNullParameter(bank_accno, "bank_accno");
        Intrinsics.checkNotNullParameter(bank_ifsc_code, "bank_ifsc_code");
        Intrinsics.checkNotNullParameter(usertype, "usertype");
        Intrinsics.checkNotNullParameter(notices, "notices");
        this.login = z;
        this.curnt_sem = curnt_sem;
        this.versionCodeEngnr = i;
        this.versionCodeSctce = i2;
        this.versionCodeAisat = i3;
        this.versionCodeCep = i4;
        this.versionCodeCetkr = i5;
        this.versionCodeCoet = i6;
        this.versionCodeCev = i7;
        this.versionCodeGcek = i8;
        this.versionCodeGcei = i9;
        this.versionCodeGcekkd = i10;
        this.versionCodeGecskp = i11;
        this.versionCodeGectcr = i12;
        this.versionCodeGecwyd = i13;
        this.versionCodeJecc = i14;
        this.versionCodeKmea = i15;
        this.versionCodeKmeacoa = i16;
        this.versionCodeMace = i17;
        this.versionCodeMarian = i18;
        this.versionCodeMdit = i19;
        this.versionCodeNssce = i20;
        this.versionCodeSjcetPalai = i21;
        this.versionCodeTkmce = i22;
        this.versionCode = i23;
        this.logout_status = z2;
        this.semReg = z3;
        this.semId = semId;
        this.studentId = studentId;
        this.rollNo = rollNo;
        this.hostel = i24;
        this.hostelStatus = hostelStatus;
        this.surveyStatus = z4;
        this.surveyMessage = surveyMessage;
        this.batchId = batchId;
        this.course = course;
        this.url = url;
        this.urlSign = urlSign;
        this.attendance_forthemonth = attendance_forthemonth;
        this.attendance_forthesem = attendance_forthesem;
        this.timetable = timetable;
        this.currentVersion = i25;
        this.infoMsg = infoMsg;
        this.isEngnr = z5;
        this.feeStatus = z6;
        this.liveTvLink = liveTvLink;
        this.liveTvType = liveTvType;
        this.passwordChanged = z7;
        this.error = error;
        this.dueNew = dueNew;
        this.deptVision = deptVision;
        this.deptMission = deptMission;
        this.clgVision = clgVision;
        this.clgMission = clgMission;
        this.feeEngnrStatus = z8;
        this.bank_name = bank_name;
        this.bank_branch = bank_branch;
        this.bank_accno = bank_accno;
        this.bank_ifsc_code = bank_ifsc_code;
        this.usertype = usertype;
        this.notices = notices;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final String getCurnt_sem() {
        return this.curnt_sem;
    }

    public final int getVersionCodeEngnr() {
        return this.versionCodeEngnr;
    }

    public final int getVersionCodeSctce() {
        return this.versionCodeSctce;
    }

    public final int getVersionCodeAisat() {
        return this.versionCodeAisat;
    }

    public final int getVersionCodeCep() {
        return this.versionCodeCep;
    }

    public final int getVersionCodeCetkr() {
        return this.versionCodeCetkr;
    }

    public final int getVersionCodeCoet() {
        return this.versionCodeCoet;
    }

    public final int getVersionCodeCev() {
        return this.versionCodeCev;
    }

    public final int getVersionCodeGcek() {
        return this.versionCodeGcek;
    }

    public final int getVersionCodeGcei() {
        return this.versionCodeGcei;
    }

    public final int getVersionCodeGcekkd() {
        return this.versionCodeGcekkd;
    }

    public final int getVersionCodeGecskp() {
        return this.versionCodeGecskp;
    }

    public final int getVersionCodeGectcr() {
        return this.versionCodeGectcr;
    }

    public final int getVersionCodeGecwyd() {
        return this.versionCodeGecwyd;
    }

    public final int getVersionCodeJecc() {
        return this.versionCodeJecc;
    }

    public final int getVersionCodeKmea() {
        return this.versionCodeKmea;
    }

    public final int getVersionCodeKmeacoa() {
        return this.versionCodeKmeacoa;
    }

    public final int getVersionCodeMace() {
        return this.versionCodeMace;
    }

    public final int getVersionCodeMarian() {
        return this.versionCodeMarian;
    }

    public final int getVersionCodeMdit() {
        return this.versionCodeMdit;
    }

    public final int getVersionCodeNssce() {
        return this.versionCodeNssce;
    }

    public final int getVersionCodeSjcetPalai() {
        return this.versionCodeSjcetPalai;
    }

    public final int getVersionCodeTkmce() {
        return this.versionCodeTkmce;
    }

    public final int getVersionCode() {
        return this.versionCode;
    }

    public final boolean getLogout_status() {
        return this.logout_status;
    }

    public final boolean getSemReg() {
        return this.semReg;
    }

    public final String getSemId() {
        return this.semId;
    }

    public final String getStudentId() {
        return this.studentId;
    }

    public final String getRollNo() {
        return this.rollNo;
    }

    public final int getHostel() {
        return this.hostel;
    }

    public final String getHostelStatus() {
        return this.hostelStatus;
    }

    public final boolean getSurveyStatus() {
        return this.surveyStatus;
    }

    public final String getSurveyMessage() {
        return this.surveyMessage;
    }

    public final String getBatchId() {
        return this.batchId;
    }

    public final String getCourse() {
        return this.course;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getUrlSign() {
        return this.urlSign;
    }

    public final String getAttendance_forthemonth() {
        return this.attendance_forthemonth;
    }

    public final String getAttendance_forthesem() {
        return this.attendance_forthesem;
    }

    public final ArrayList<ArrayList<TimeTable>> getTimetable() {
        return this.timetable;
    }

    public final int getCurrentVersion() {
        return this.currentVersion;
    }

    public final String getInfoMsg() {
        return this.infoMsg;
    }

    public final boolean isEngnr() {
        return this.isEngnr;
    }

    public final boolean getFeeStatus() {
        return this.feeStatus;
    }

    public final String getLiveTvLink() {
        return this.liveTvLink;
    }

    public final String getLiveTvType() {
        return this.liveTvType;
    }

    public final boolean getPasswordChanged() {
        return this.passwordChanged;
    }

    public final String getError() {
        return this.error;
    }

    public final String getDueNew() {
        return this.dueNew;
    }

    public final String getDeptVision() {
        return this.deptVision;
    }

    public final String getDeptMission() {
        return this.deptMission;
    }

    public final String getClgVision() {
        return this.clgVision;
    }

    public final String getClgMission() {
        return this.clgMission;
    }

    public final boolean getFeeEngnrStatus() {
        return this.feeEngnrStatus;
    }

    public final String getBank_name() {
        return this.bank_name;
    }

    public final String getBank_branch() {
        return this.bank_branch;
    }

    public final String getBank_accno() {
        return this.bank_accno;
    }

    public final String getBank_ifsc_code() {
        return this.bank_ifsc_code;
    }

    public final String getUsertype() {
        return this.usertype;
    }

    public final ArrayList<NoticesDash> getNotices() {
        return this.notices;
    }
}