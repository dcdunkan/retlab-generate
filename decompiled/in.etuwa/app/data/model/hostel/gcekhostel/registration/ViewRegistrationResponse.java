package in.etuwa.app.data.model.hostel.gcekhostel.registration;

import androidx.core.app.NotificationCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import in.etuwa.app.ui.attendance.bydaynew.attendaceday.AttendanceDayDialogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ViewRegistrationResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class ViewRegistrationResponse {
    private final String admission_no;
    private final String admsn_type;
    private final String annual_income;
    private final String blood_group;
    private final String caste;
    private final String category;
    private final String distance;
    private final String full_name;
    private final String guardian_address;
    private final String incomeFile;
    private final boolean login;
    private final String phone_guardian;
    private final String phone_no;
    private final String punishment;
    private final String readmission;
    private final String religion;
    private final String remarks;
    private final String semester;
    private final String status;
    private final String type;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getCategory() {
        return this.category;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getPhone_no() {
        return this.phone_no;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getBlood_group() {
        return this.blood_group;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getReligion() {
        return this.religion;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getCaste() {
        return this.caste;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getGuardian_address() {
        return this.guardian_address;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final String getPhone_guardian() {
        return this.phone_guardian;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final String getDistance() {
        return this.distance;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final String getPunishment() {
        return this.punishment;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final String getIncomeFile() {
        return this.incomeFile;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getAdmission_no() {
        return this.admission_no;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final String getAnnual_income() {
        return this.annual_income;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getFull_name() {
        return this.full_name;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getSemester() {
        return this.semester;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getReadmission() {
        return this.readmission;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getRemarks() {
        return this.remarks;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getAdmsn_type() {
        return this.admsn_type;
    }

    public final ViewRegistrationResponse copy(boolean login, String admission_no, String full_name, String semester, String readmission, String status, String remarks, String type, String admsn_type, String category, String phone_no, String blood_group, String religion, String caste, String guardian_address, String phone_guardian, String distance, String punishment, String incomeFile, String annual_income) {
        Intrinsics.checkNotNullParameter(admission_no, "admission_no");
        Intrinsics.checkNotNullParameter(full_name, "full_name");
        Intrinsics.checkNotNullParameter(semester, "semester");
        Intrinsics.checkNotNullParameter(readmission, "readmission");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(remarks, "remarks");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(admsn_type, "admsn_type");
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(phone_no, "phone_no");
        Intrinsics.checkNotNullParameter(blood_group, "blood_group");
        Intrinsics.checkNotNullParameter(religion, "religion");
        Intrinsics.checkNotNullParameter(caste, "caste");
        Intrinsics.checkNotNullParameter(guardian_address, "guardian_address");
        Intrinsics.checkNotNullParameter(phone_guardian, "phone_guardian");
        Intrinsics.checkNotNullParameter(distance, "distance");
        Intrinsics.checkNotNullParameter(punishment, "punishment");
        Intrinsics.checkNotNullParameter(incomeFile, "incomeFile");
        Intrinsics.checkNotNullParameter(annual_income, "annual_income");
        return new ViewRegistrationResponse(login, admission_no, full_name, semester, readmission, status, remarks, type, admsn_type, category, phone_no, blood_group, religion, caste, guardian_address, phone_guardian, distance, punishment, incomeFile, annual_income);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ViewRegistrationResponse)) {
            return false;
        }
        ViewRegistrationResponse viewRegistrationResponse = (ViewRegistrationResponse) other;
        return this.login == viewRegistrationResponse.login && Intrinsics.areEqual(this.admission_no, viewRegistrationResponse.admission_no) && Intrinsics.areEqual(this.full_name, viewRegistrationResponse.full_name) && Intrinsics.areEqual(this.semester, viewRegistrationResponse.semester) && Intrinsics.areEqual(this.readmission, viewRegistrationResponse.readmission) && Intrinsics.areEqual(this.status, viewRegistrationResponse.status) && Intrinsics.areEqual(this.remarks, viewRegistrationResponse.remarks) && Intrinsics.areEqual(this.type, viewRegistrationResponse.type) && Intrinsics.areEqual(this.admsn_type, viewRegistrationResponse.admsn_type) && Intrinsics.areEqual(this.category, viewRegistrationResponse.category) && Intrinsics.areEqual(this.phone_no, viewRegistrationResponse.phone_no) && Intrinsics.areEqual(this.blood_group, viewRegistrationResponse.blood_group) && Intrinsics.areEqual(this.religion, viewRegistrationResponse.religion) && Intrinsics.areEqual(this.caste, viewRegistrationResponse.caste) && Intrinsics.areEqual(this.guardian_address, viewRegistrationResponse.guardian_address) && Intrinsics.areEqual(this.phone_guardian, viewRegistrationResponse.phone_guardian) && Intrinsics.areEqual(this.distance, viewRegistrationResponse.distance) && Intrinsics.areEqual(this.punishment, viewRegistrationResponse.punishment) && Intrinsics.areEqual(this.incomeFile, viewRegistrationResponse.incomeFile) && Intrinsics.areEqual(this.annual_income, viewRegistrationResponse.annual_income);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v40 */
    /* JADX WARN: Type inference failed for: r0v41 */
    public int hashCode() {
        boolean z = this.login;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (((((((((((((((((((((((((((((((((((((r0 * 31) + this.admission_no.hashCode()) * 31) + this.full_name.hashCode()) * 31) + this.semester.hashCode()) * 31) + this.readmission.hashCode()) * 31) + this.status.hashCode()) * 31) + this.remarks.hashCode()) * 31) + this.type.hashCode()) * 31) + this.admsn_type.hashCode()) * 31) + this.category.hashCode()) * 31) + this.phone_no.hashCode()) * 31) + this.blood_group.hashCode()) * 31) + this.religion.hashCode()) * 31) + this.caste.hashCode()) * 31) + this.guardian_address.hashCode()) * 31) + this.phone_guardian.hashCode()) * 31) + this.distance.hashCode()) * 31) + this.punishment.hashCode()) * 31) + this.incomeFile.hashCode()) * 31) + this.annual_income.hashCode();
    }

    public String toString() {
        return "ViewRegistrationResponse(login=" + this.login + ", admission_no=" + this.admission_no + ", full_name=" + this.full_name + ", semester=" + this.semester + ", readmission=" + this.readmission + ", status=" + this.status + ", remarks=" + this.remarks + ", type=" + this.type + ", admsn_type=" + this.admsn_type + ", category=" + this.category + ", phone_no=" + this.phone_no + ", blood_group=" + this.blood_group + ", religion=" + this.religion + ", caste=" + this.caste + ", guardian_address=" + this.guardian_address + ", phone_guardian=" + this.phone_guardian + ", distance=" + this.distance + ", punishment=" + this.punishment + ", incomeFile=" + this.incomeFile + ", annual_income=" + this.annual_income + ")";
    }

    public ViewRegistrationResponse(boolean z, String admission_no, String full_name, String semester, String readmission, String status, String remarks, String type, String admsn_type, String category, String phone_no, String blood_group, String religion, String caste, String guardian_address, String phone_guardian, String distance, String punishment, String incomeFile, String annual_income) {
        Intrinsics.checkNotNullParameter(admission_no, "admission_no");
        Intrinsics.checkNotNullParameter(full_name, "full_name");
        Intrinsics.checkNotNullParameter(semester, "semester");
        Intrinsics.checkNotNullParameter(readmission, "readmission");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(remarks, "remarks");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(admsn_type, "admsn_type");
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(phone_no, "phone_no");
        Intrinsics.checkNotNullParameter(blood_group, "blood_group");
        Intrinsics.checkNotNullParameter(religion, "religion");
        Intrinsics.checkNotNullParameter(caste, "caste");
        Intrinsics.checkNotNullParameter(guardian_address, "guardian_address");
        Intrinsics.checkNotNullParameter(phone_guardian, "phone_guardian");
        Intrinsics.checkNotNullParameter(distance, "distance");
        Intrinsics.checkNotNullParameter(punishment, "punishment");
        Intrinsics.checkNotNullParameter(incomeFile, "incomeFile");
        Intrinsics.checkNotNullParameter(annual_income, "annual_income");
        this.login = z;
        this.admission_no = admission_no;
        this.full_name = full_name;
        this.semester = semester;
        this.readmission = readmission;
        this.status = status;
        this.remarks = remarks;
        this.type = type;
        this.admsn_type = admsn_type;
        this.category = category;
        this.phone_no = phone_no;
        this.blood_group = blood_group;
        this.religion = religion;
        this.caste = caste;
        this.guardian_address = guardian_address;
        this.phone_guardian = phone_guardian;
        this.distance = distance;
        this.punishment = punishment;
        this.incomeFile = incomeFile;
        this.annual_income = annual_income;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final String getAdmission_no() {
        return this.admission_no;
    }

    public final String getFull_name() {
        return this.full_name;
    }

    public final String getSemester() {
        return this.semester;
    }

    public final String getReadmission() {
        return this.readmission;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getRemarks() {
        return this.remarks;
    }

    public final String getType() {
        return this.type;
    }

    public final String getAdmsn_type() {
        return this.admsn_type;
    }

    public final String getCategory() {
        return this.category;
    }

    public final String getPhone_no() {
        return this.phone_no;
    }

    public final String getBlood_group() {
        return this.blood_group;
    }

    public final String getReligion() {
        return this.religion;
    }

    public final String getCaste() {
        return this.caste;
    }

    public final String getGuardian_address() {
        return this.guardian_address;
    }

    public final String getPhone_guardian() {
        return this.phone_guardian;
    }

    public final String getDistance() {
        return this.distance;
    }

    public final String getPunishment() {
        return this.punishment;
    }

    public final String getIncomeFile() {
        return this.incomeFile;
    }

    public final String getAnnual_income() {
        return this.annual_income;
    }
}