package in.etuwa.app.data.model.dash;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import in.etuwa.app.data.model.timetable.TimeTable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DashResponse.kt */
/* loaded from: classes3.dex */
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

    /* renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    /* renamed from: component10, reason: from getter */
    public final int getVersionCodeGcek() {
        return this.versionCodeGcek;
    }

    /* renamed from: component11, reason: from getter */
    public final int getVersionCodeGcei() {
        return this.versionCodeGcei;
    }

    /* renamed from: component12, reason: from getter */
    public final int getVersionCodeGcekkd() {
        return this.versionCodeGcekkd;
    }

    /* renamed from: component13, reason: from getter */
    public final int getVersionCodeGecskp() {
        return this.versionCodeGecskp;
    }

    /* renamed from: component14, reason: from getter */
    public final int getVersionCodeGectcr() {
        return this.versionCodeGectcr;
    }

    /* renamed from: component15, reason: from getter */
    public final int getVersionCodeGecwyd() {
        return this.versionCodeGecwyd;
    }

    /* renamed from: component16, reason: from getter */
    public final int getVersionCodeJecc() {
        return this.versionCodeJecc;
    }

    /* renamed from: component17, reason: from getter */
    public final int getVersionCodeKmea() {
        return this.versionCodeKmea;
    }

    /* renamed from: component18, reason: from getter */
    public final int getVersionCodeKmeacoa() {
        return this.versionCodeKmeacoa;
    }

    /* renamed from: component19, reason: from getter */
    public final int getVersionCodeMace() {
        return this.versionCodeMace;
    }

    /* renamed from: component2, reason: from getter */
    public final String getCurnt_sem() {
        return this.curnt_sem;
    }

    /* renamed from: component20, reason: from getter */
    public final int getVersionCodeMarian() {
        return this.versionCodeMarian;
    }

    /* renamed from: component21, reason: from getter */
    public final int getVersionCodeMdit() {
        return this.versionCodeMdit;
    }

    /* renamed from: component22, reason: from getter */
    public final int getVersionCodeNssce() {
        return this.versionCodeNssce;
    }

    /* renamed from: component23, reason: from getter */
    public final int getVersionCodeSjcetPalai() {
        return this.versionCodeSjcetPalai;
    }

    /* renamed from: component24, reason: from getter */
    public final int getVersionCodeTkmce() {
        return this.versionCodeTkmce;
    }

    /* renamed from: component25, reason: from getter */
    public final int getVersionCode() {
        return this.versionCode;
    }

    /* renamed from: component26, reason: from getter */
    public final boolean getLogout_status() {
        return this.logout_status;
    }

    /* renamed from: component27, reason: from getter */
    public final boolean getSemReg() {
        return this.semReg;
    }

    /* renamed from: component28, reason: from getter */
    public final String getSemId() {
        return this.semId;
    }

    /* renamed from: component29, reason: from getter */
    public final String getStudentId() {
        return this.studentId;
    }

    /* renamed from: component3, reason: from getter */
    public final int getVersionCodeEngnr() {
        return this.versionCodeEngnr;
    }

    /* renamed from: component30, reason: from getter */
    public final int getHostel() {
        return this.hostel;
    }

    /* renamed from: component31, reason: from getter */
    public final String getHostelStatus() {
        return this.hostelStatus;
    }

    /* renamed from: component32, reason: from getter */
    public final boolean getSurveyStatus() {
        return this.surveyStatus;
    }

    /* renamed from: component33, reason: from getter */
    public final String getSurveyMessage() {
        return this.surveyMessage;
    }

    /* renamed from: component34, reason: from getter */
    public final String getBatchId() {
        return this.batchId;
    }

    /* renamed from: component35, reason: from getter */
    public final String getCourse() {
        return this.course;
    }

    /* renamed from: component36, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: component37, reason: from getter */
    public final String getUrlSign() {
        return this.urlSign;
    }

    /* renamed from: component38, reason: from getter */
    public final String getAttendance_forthemonth() {
        return this.attendance_forthemonth;
    }

    /* renamed from: component39, reason: from getter */
    public final String getAttendance_forthesem() {
        return this.attendance_forthesem;
    }

    /* renamed from: component4, reason: from getter */
    public final int getVersionCodeSctce() {
        return this.versionCodeSctce;
    }

    public final ArrayList<ArrayList<TimeTable>> component40() {
        return this.timetable;
    }

    /* renamed from: component41, reason: from getter */
    public final int getCurrentVersion() {
        return this.currentVersion;
    }

    /* renamed from: component42, reason: from getter */
    public final String getInfoMsg() {
        return this.infoMsg;
    }

    /* renamed from: component43, reason: from getter */
    public final boolean getFeeStatus() {
        return this.feeStatus;
    }

    /* renamed from: component44, reason: from getter */
    public final String getLiveTvLink() {
        return this.liveTvLink;
    }

    /* renamed from: component45, reason: from getter */
    public final String getLiveTvType() {
        return this.liveTvType;
    }

    /* renamed from: component46, reason: from getter */
    public final boolean getPasswordChanged() {
        return this.passwordChanged;
    }

    /* renamed from: component47, reason: from getter */
    public final String getError() {
        return this.error;
    }

    /* renamed from: component48, reason: from getter */
    public final String getDueNew() {
        return this.dueNew;
    }

    /* renamed from: component49, reason: from getter */
    public final String getDeptVision() {
        return this.deptVision;
    }

    /* renamed from: component5, reason: from getter */
    public final int getVersionCodeAisat() {
        return this.versionCodeAisat;
    }

    /* renamed from: component50, reason: from getter */
    public final String getDeptMission() {
        return this.deptMission;
    }

    /* renamed from: component51, reason: from getter */
    public final String getClgVision() {
        return this.clgVision;
    }

    /* renamed from: component52, reason: from getter */
    public final String getClgMission() {
        return this.clgMission;
    }

    /* renamed from: component53, reason: from getter */
    public final boolean getFeeEngnrStatus() {
        return this.feeEngnrStatus;
    }

    /* renamed from: component54, reason: from getter */
    public final String getBank_name() {
        return this.bank_name;
    }

    /* renamed from: component55, reason: from getter */
    public final String getBank_branch() {
        return this.bank_branch;
    }

    /* renamed from: component56, reason: from getter */
    public final String getBank_accno() {
        return this.bank_accno;
    }

    /* renamed from: component57, reason: from getter */
    public final String getBank_ifsc_code() {
        return this.bank_ifsc_code;
    }

    /* renamed from: component58, reason: from getter */
    public final String getUsertype() {
        return this.usertype;
    }

    public final ArrayList<NoticesDash> component59() {
        return this.notices;
    }

    /* renamed from: component6, reason: from getter */
    public final int getVersionCodeCep() {
        return this.versionCodeCep;
    }

    /* renamed from: component7, reason: from getter */
    public final int getVersionCodeCetkr() {
        return this.versionCodeCetkr;
    }

    /* renamed from: component8, reason: from getter */
    public final int getVersionCodeCoet() {
        return this.versionCodeCoet;
    }

    /* renamed from: component9, reason: from getter */
    public final int getVersionCodeCev() {
        return this.versionCodeCev;
    }

    public final DashResponse copy(boolean login, String curnt_sem, int versionCodeEngnr, int versionCodeSctce, int versionCodeAisat, int versionCodeCep, int versionCodeCetkr, int versionCodeCoet, int versionCodeCev, int versionCodeGcek, int versionCodeGcei, int versionCodeGcekkd, int versionCodeGecskp, int versionCodeGectcr, int versionCodeGecwyd, int versionCodeJecc, int versionCodeKmea, int versionCodeKmeacoa, int versionCodeMace, int versionCodeMarian, int versionCodeMdit, int versionCodeNssce, int versionCodeSjcetPalai, int versionCodeTkmce, int versionCode, boolean logout_status, boolean semReg, String semId, String studentId, int hostel, String hostelStatus, boolean surveyStatus, String surveyMessage, String batchId, String course, String url, String urlSign, String attendance_forthemonth, String attendance_forthesem, ArrayList<ArrayList<TimeTable>> timetable, int currentVersion, String infoMsg, boolean feeStatus, String liveTvLink, String liveTvType, boolean passwordChanged, String error, String dueNew, String deptVision, String deptMission, String clgVision, String clgMission, boolean feeEngnrStatus, String bank_name, String bank_branch, String bank_accno, String bank_ifsc_code, String usertype, ArrayList<NoticesDash> notices) {
        Intrinsics.checkNotNullParameter(curnt_sem, "curnt_sem");
        Intrinsics.checkNotNullParameter(semId, "semId");
        Intrinsics.checkNotNullParameter(studentId, "studentId");
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
        return new DashResponse(login, curnt_sem, versionCodeEngnr, versionCodeSctce, versionCodeAisat, versionCodeCep, versionCodeCetkr, versionCodeCoet, versionCodeCev, versionCodeGcek, versionCodeGcei, versionCodeGcekkd, versionCodeGecskp, versionCodeGectcr, versionCodeGecwyd, versionCodeJecc, versionCodeKmea, versionCodeKmeacoa, versionCodeMace, versionCodeMarian, versionCodeMdit, versionCodeNssce, versionCodeSjcetPalai, versionCodeTkmce, versionCode, logout_status, semReg, semId, studentId, hostel, hostelStatus, surveyStatus, surveyMessage, batchId, course, url, urlSign, attendance_forthemonth, attendance_forthesem, timetable, currentVersion, infoMsg, feeStatus, liveTvLink, liveTvType, passwordChanged, error, dueNew, deptVision, deptMission, clgVision, clgMission, feeEngnrStatus, bank_name, bank_branch, bank_accno, bank_ifsc_code, usertype, notices);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DashResponse)) {
            return false;
        }
        DashResponse dashResponse = (DashResponse) other;
        return this.login == dashResponse.login && Intrinsics.areEqual(this.curnt_sem, dashResponse.curnt_sem) && this.versionCodeEngnr == dashResponse.versionCodeEngnr && this.versionCodeSctce == dashResponse.versionCodeSctce && this.versionCodeAisat == dashResponse.versionCodeAisat && this.versionCodeCep == dashResponse.versionCodeCep && this.versionCodeCetkr == dashResponse.versionCodeCetkr && this.versionCodeCoet == dashResponse.versionCodeCoet && this.versionCodeCev == dashResponse.versionCodeCev && this.versionCodeGcek == dashResponse.versionCodeGcek && this.versionCodeGcei == dashResponse.versionCodeGcei && this.versionCodeGcekkd == dashResponse.versionCodeGcekkd && this.versionCodeGecskp == dashResponse.versionCodeGecskp && this.versionCodeGectcr == dashResponse.versionCodeGectcr && this.versionCodeGecwyd == dashResponse.versionCodeGecwyd && this.versionCodeJecc == dashResponse.versionCodeJecc && this.versionCodeKmea == dashResponse.versionCodeKmea && this.versionCodeKmeacoa == dashResponse.versionCodeKmeacoa && this.versionCodeMace == dashResponse.versionCodeMace && this.versionCodeMarian == dashResponse.versionCodeMarian && this.versionCodeMdit == dashResponse.versionCodeMdit && this.versionCodeNssce == dashResponse.versionCodeNssce && this.versionCodeSjcetPalai == dashResponse.versionCodeSjcetPalai && this.versionCodeTkmce == dashResponse.versionCodeTkmce && this.versionCode == dashResponse.versionCode && this.logout_status == dashResponse.logout_status && this.semReg == dashResponse.semReg && Intrinsics.areEqual(this.semId, dashResponse.semId) && Intrinsics.areEqual(this.studentId, dashResponse.studentId) && this.hostel == dashResponse.hostel && Intrinsics.areEqual(this.hostelStatus, dashResponse.hostelStatus) && this.surveyStatus == dashResponse.surveyStatus && Intrinsics.areEqual(this.surveyMessage, dashResponse.surveyMessage) && Intrinsics.areEqual(this.batchId, dashResponse.batchId) && Intrinsics.areEqual(this.course, dashResponse.course) && Intrinsics.areEqual(this.url, dashResponse.url) && Intrinsics.areEqual(this.urlSign, dashResponse.urlSign) && Intrinsics.areEqual(this.attendance_forthemonth, dashResponse.attendance_forthemonth) && Intrinsics.areEqual(this.attendance_forthesem, dashResponse.attendance_forthesem) && Intrinsics.areEqual(this.timetable, dashResponse.timetable) && this.currentVersion == dashResponse.currentVersion && Intrinsics.areEqual(this.infoMsg, dashResponse.infoMsg) && this.feeStatus == dashResponse.feeStatus && Intrinsics.areEqual(this.liveTvLink, dashResponse.liveTvLink) && Intrinsics.areEqual(this.liveTvType, dashResponse.liveTvType) && this.passwordChanged == dashResponse.passwordChanged && Intrinsics.areEqual(this.error, dashResponse.error) && Intrinsics.areEqual(this.dueNew, dashResponse.dueNew) && Intrinsics.areEqual(this.deptVision, dashResponse.deptVision) && Intrinsics.areEqual(this.deptMission, dashResponse.deptMission) && Intrinsics.areEqual(this.clgVision, dashResponse.clgVision) && Intrinsics.areEqual(this.clgMission, dashResponse.clgMission) && this.feeEngnrStatus == dashResponse.feeEngnrStatus && Intrinsics.areEqual(this.bank_name, dashResponse.bank_name) && Intrinsics.areEqual(this.bank_branch, dashResponse.bank_branch) && Intrinsics.areEqual(this.bank_accno, dashResponse.bank_accno) && Intrinsics.areEqual(this.bank_ifsc_code, dashResponse.bank_ifsc_code) && Intrinsics.areEqual(this.usertype, dashResponse.usertype) && Intrinsics.areEqual(this.notices, dashResponse.notices);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v118 */
    /* JADX WARN: Type inference failed for: r0v119 */
    /* JADX WARN: Type inference failed for: r2v25, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v27, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v36, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v57, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v63, types: [boolean] */
    public int hashCode() {
        boolean z = this.login;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int hashCode = ((((((((((((((((((((((((((((((((((((((((((((((((r0 * 31) + this.curnt_sem.hashCode()) * 31) + this.versionCodeEngnr) * 31) + this.versionCodeSctce) * 31) + this.versionCodeAisat) * 31) + this.versionCodeCep) * 31) + this.versionCodeCetkr) * 31) + this.versionCodeCoet) * 31) + this.versionCodeCev) * 31) + this.versionCodeGcek) * 31) + this.versionCodeGcei) * 31) + this.versionCodeGcekkd) * 31) + this.versionCodeGecskp) * 31) + this.versionCodeGectcr) * 31) + this.versionCodeGecwyd) * 31) + this.versionCodeJecc) * 31) + this.versionCodeKmea) * 31) + this.versionCodeKmeacoa) * 31) + this.versionCodeMace) * 31) + this.versionCodeMarian) * 31) + this.versionCodeMdit) * 31) + this.versionCodeNssce) * 31) + this.versionCodeSjcetPalai) * 31) + this.versionCodeTkmce) * 31) + this.versionCode) * 31;
        ?? r2 = this.logout_status;
        int i = r2;
        if (r2 != 0) {
            i = 1;
        }
        int i2 = (hashCode + i) * 31;
        ?? r22 = this.semReg;
        int i3 = r22;
        if (r22 != 0) {
            i3 = 1;
        }
        int hashCode2 = (((((((((i2 + i3) * 31) + this.semId.hashCode()) * 31) + this.studentId.hashCode()) * 31) + this.hostel) * 31) + this.hostelStatus.hashCode()) * 31;
        ?? r23 = this.surveyStatus;
        int i4 = r23;
        if (r23 != 0) {
            i4 = 1;
        }
        int hashCode3 = (((((((((((((((((((((hashCode2 + i4) * 31) + this.surveyMessage.hashCode()) * 31) + this.batchId.hashCode()) * 31) + this.course.hashCode()) * 31) + this.url.hashCode()) * 31) + this.urlSign.hashCode()) * 31) + this.attendance_forthemonth.hashCode()) * 31) + this.attendance_forthesem.hashCode()) * 31) + this.timetable.hashCode()) * 31) + this.currentVersion) * 31) + this.infoMsg.hashCode()) * 31;
        ?? r24 = this.feeStatus;
        int i5 = r24;
        if (r24 != 0) {
            i5 = 1;
        }
        int hashCode4 = (((((hashCode3 + i5) * 31) + this.liveTvLink.hashCode()) * 31) + this.liveTvType.hashCode()) * 31;
        ?? r25 = this.passwordChanged;
        int i6 = r25;
        if (r25 != 0) {
            i6 = 1;
        }
        int hashCode5 = (((((((((((((hashCode4 + i6) * 31) + this.error.hashCode()) * 31) + this.dueNew.hashCode()) * 31) + this.deptVision.hashCode()) * 31) + this.deptMission.hashCode()) * 31) + this.clgVision.hashCode()) * 31) + this.clgMission.hashCode()) * 31;
        boolean z2 = this.feeEngnrStatus;
        return ((((((((((((hashCode5 + (z2 ? 1 : z2 ? 1 : 0)) * 31) + this.bank_name.hashCode()) * 31) + this.bank_branch.hashCode()) * 31) + this.bank_accno.hashCode()) * 31) + this.bank_ifsc_code.hashCode()) * 31) + this.usertype.hashCode()) * 31) + this.notices.hashCode();
    }

    public String toString() {
        return "DashResponse(login=" + this.login + ", curnt_sem=" + this.curnt_sem + ", versionCodeEngnr=" + this.versionCodeEngnr + ", versionCodeSctce=" + this.versionCodeSctce + ", versionCodeAisat=" + this.versionCodeAisat + ", versionCodeCep=" + this.versionCodeCep + ", versionCodeCetkr=" + this.versionCodeCetkr + ", versionCodeCoet=" + this.versionCodeCoet + ", versionCodeCev=" + this.versionCodeCev + ", versionCodeGcek=" + this.versionCodeGcek + ", versionCodeGcei=" + this.versionCodeGcei + ", versionCodeGcekkd=" + this.versionCodeGcekkd + ", versionCodeGecskp=" + this.versionCodeGecskp + ", versionCodeGectcr=" + this.versionCodeGectcr + ", versionCodeGecwyd=" + this.versionCodeGecwyd + ", versionCodeJecc=" + this.versionCodeJecc + ", versionCodeKmea=" + this.versionCodeKmea + ", versionCodeKmeacoa=" + this.versionCodeKmeacoa + ", versionCodeMace=" + this.versionCodeMace + ", versionCodeMarian=" + this.versionCodeMarian + ", versionCodeMdit=" + this.versionCodeMdit + ", versionCodeNssce=" + this.versionCodeNssce + ", versionCodeSjcetPalai=" + this.versionCodeSjcetPalai + ", versionCodeTkmce=" + this.versionCodeTkmce + ", versionCode=" + this.versionCode + ", logout_status=" + this.logout_status + ", semReg=" + this.semReg + ", semId=" + this.semId + ", studentId=" + this.studentId + ", hostel=" + this.hostel + ", hostelStatus=" + this.hostelStatus + ", surveyStatus=" + this.surveyStatus + ", surveyMessage=" + this.surveyMessage + ", batchId=" + this.batchId + ", course=" + this.course + ", url=" + this.url + ", urlSign=" + this.urlSign + ", attendance_forthemonth=" + this.attendance_forthemonth + ", attendance_forthesem=" + this.attendance_forthesem + ", timetable=" + this.timetable + ", currentVersion=" + this.currentVersion + ", infoMsg=" + this.infoMsg + ", feeStatus=" + this.feeStatus + ", liveTvLink=" + this.liveTvLink + ", liveTvType=" + this.liveTvType + ", passwordChanged=" + this.passwordChanged + ", error=" + this.error + ", dueNew=" + this.dueNew + ", deptVision=" + this.deptVision + ", deptMission=" + this.deptMission + ", clgVision=" + this.clgVision + ", clgMission=" + this.clgMission + ", feeEngnrStatus=" + this.feeEngnrStatus + ", bank_name=" + this.bank_name + ", bank_branch=" + this.bank_branch + ", bank_accno=" + this.bank_accno + ", bank_ifsc_code=" + this.bank_ifsc_code + ", usertype=" + this.usertype + ", notices=" + this.notices + ")";
    }

    public DashResponse(boolean z, String curnt_sem, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20, int i21, int i22, int i23, boolean z2, boolean z3, String semId, String studentId, int i24, String hostelStatus, boolean z4, String surveyMessage, String batchId, String course, String url, String urlSign, String attendance_forthemonth, String attendance_forthesem, ArrayList<ArrayList<TimeTable>> timetable, int i25, String infoMsg, boolean z5, String liveTvLink, String liveTvType, boolean z6, String error, String dueNew, String deptVision, String deptMission, String clgVision, String clgMission, boolean z7, String bank_name, String bank_branch, String bank_accno, String bank_ifsc_code, String usertype, ArrayList<NoticesDash> notices) {
        Intrinsics.checkNotNullParameter(curnt_sem, "curnt_sem");
        Intrinsics.checkNotNullParameter(semId, "semId");
        Intrinsics.checkNotNullParameter(studentId, "studentId");
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
        this.feeStatus = z5;
        this.liveTvLink = liveTvLink;
        this.liveTvType = liveTvType;
        this.passwordChanged = z6;
        this.error = error;
        this.dueNew = dueNew;
        this.deptVision = deptVision;
        this.deptMission = deptMission;
        this.clgVision = clgVision;
        this.clgMission = clgMission;
        this.feeEngnrStatus = z7;
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