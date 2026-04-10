package in.etuwa.app.data.model.semregistration;

import androidx.core.app.NotificationCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import in.etuwa.app.data.model.Semester;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SemRegViewResponse.kt */
/* loaded from: classes3.dex */
public final /* data */ class SemRegViewResponse {

    @SerializedName("academic_due")
    private final String academicDue;

    @SerializedName("academic_due_details")
    private final String academicDueDetails;

    @SerializedName("accounts_due")
    private final String accountsDue;

    @SerializedName("accounts_due_details")
    private final String accountsDueDetails;

    @SerializedName("admission_no")
    private final String admissionNo;

    @SerializedName("amount_paid")
    private final String amountPaid;

    @SerializedName("backpaper")
    private final String backPaper;

    @SerializedName("backlogs_count")
    private final String backPaperCount;

    @SerializedName("bank_name")
    private final String bankName;

    @SerializedName("bus_due")
    private final String busDue;

    @SerializedName("bus_due_details")
    private final String busDueDetails;

    @SerializedName("can_edit")
    private final boolean canEdit;

    @SerializedName("can_edit_message")
    private final String canEditMessage;

    @SerializedName("classteacher_remarks")
    private final String classTeacherRemark;

    @SerializedName("department_due")
    private final String departmentDue;

    @SerializedName("department_due_details")
    private final String departmentDueDetails;

    @SerializedName("earned_credits")
    private final String earnedCredits;
    private final String email;

    @SerializedName("exam_appear")
    private final String examAppear;

    @SerializedName("exam_month_year")
    private final String examMonthYear;

    @SerializedName("fee_concession")
    private final String feeConcession;

    @SerializedName("fee_concession_category")
    private final String feeConcessionCategory;

    @SerializedName("fee_exemption")
    private final boolean feeExemption;

    @SerializedName("fee_paid")
    private final String feePaid;

    @SerializedName("feereceipt_file")
    private final String feeReceiptFile;
    private final String gender;

    @SerializedName("hod_remarks")
    private final String hodRemarks;

    @SerializedName("hostel_due")
    private final String hostelDue;

    @SerializedName("hostel_due_details")
    private final String hostelDueDetails;

    @SerializedName("is_applied")
    private final boolean isApplied;

    @SerializedName("last_attended_sem")
    private final String lastAttendedSem;

    @SerializedName("last_attended_sem_text")
    private final String lastAttendedSemText;

    @SerializedName("library_due")
    private final String libraryDue;

    @SerializedName("librarary_due_details")
    private final String libraryDueDetails;
    private final boolean login;
    private final String name;

    @SerializedName("payment_date")
    private final String paymentDate;

    @SerializedName("payment_mode")
    private final String paymentMode;

    @SerializedName("payment_reference_no")
    private final String paymentReferenceNo;
    private final String phone;

    @SerializedName("regslip_file")
    private final String regSlipFile;

    @SerializedName("sem_applied_for")
    private final String semAppliedFor;

    @SerializedName("sem_list")
    private final ArrayList<Semester> semList;

    @SerializedName("sem_registration_status")
    private final boolean semRegistrationStatus;

    @SerializedName("sem_registration_status_message")
    private final String semRegistrationStatusMessage;
    private final String status;

    @SerializedName("unireg_no")
    private final String uniRegNo;
    private final boolean update_btn;

    /* renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    /* renamed from: component10, reason: from getter */
    public final String getUniRegNo() {
        return this.uniRegNo;
    }

    /* renamed from: component11, reason: from getter */
    public final String getExamMonthYear() {
        return this.examMonthYear;
    }

    /* renamed from: component12, reason: from getter */
    public final String getBackPaper() {
        return this.backPaper;
    }

    /* renamed from: component13, reason: from getter */
    public final String getBackPaperCount() {
        return this.backPaperCount;
    }

    /* renamed from: component14, reason: from getter */
    public final String getEarnedCredits() {
        return this.earnedCredits;
    }

    /* renamed from: component15, reason: from getter */
    public final String getFeePaid() {
        return this.feePaid;
    }

    /* renamed from: component16, reason: from getter */
    public final String getBankName() {
        return this.bankName;
    }

    /* renamed from: component17, reason: from getter */
    public final String getAmountPaid() {
        return this.amountPaid;
    }

    /* renamed from: component18, reason: from getter */
    public final String getPaymentDate() {
        return this.paymentDate;
    }

    /* renamed from: component19, reason: from getter */
    public final String getPaymentReferenceNo() {
        return this.paymentReferenceNo;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAdmissionNo() {
        return this.admissionNo;
    }

    /* renamed from: component20, reason: from getter */
    public final String getPaymentMode() {
        return this.paymentMode;
    }

    /* renamed from: component21, reason: from getter */
    public final String getFeeReceiptFile() {
        return this.feeReceiptFile;
    }

    /* renamed from: component22, reason: from getter */
    public final String getRegSlipFile() {
        return this.regSlipFile;
    }

    /* renamed from: component23, reason: from getter */
    public final String getFeeConcession() {
        return this.feeConcession;
    }

    /* renamed from: component24, reason: from getter */
    public final String getFeeConcessionCategory() {
        return this.feeConcessionCategory;
    }

    /* renamed from: component25, reason: from getter */
    public final String getDepartmentDue() {
        return this.departmentDue;
    }

    /* renamed from: component26, reason: from getter */
    public final String getDepartmentDueDetails() {
        return this.departmentDueDetails;
    }

    /* renamed from: component27, reason: from getter */
    public final String getLibraryDue() {
        return this.libraryDue;
    }

    /* renamed from: component28, reason: from getter */
    public final String getLibraryDueDetails() {
        return this.libraryDueDetails;
    }

    /* renamed from: component29, reason: from getter */
    public final String getAccountsDue() {
        return this.accountsDue;
    }

    /* renamed from: component3, reason: from getter */
    public final String getSemAppliedFor() {
        return this.semAppliedFor;
    }

    /* renamed from: component30, reason: from getter */
    public final String getAccountsDueDetails() {
        return this.accountsDueDetails;
    }

    /* renamed from: component31, reason: from getter */
    public final String getAcademicDue() {
        return this.academicDue;
    }

    /* renamed from: component32, reason: from getter */
    public final String getAcademicDueDetails() {
        return this.academicDueDetails;
    }

    /* renamed from: component33, reason: from getter */
    public final String getHostelDue() {
        return this.hostelDue;
    }

    /* renamed from: component34, reason: from getter */
    public final String getHostelDueDetails() {
        return this.hostelDueDetails;
    }

    /* renamed from: component35, reason: from getter */
    public final String getBusDue() {
        return this.busDue;
    }

    /* renamed from: component36, reason: from getter */
    public final String getBusDueDetails() {
        return this.busDueDetails;
    }

    /* renamed from: component37, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: component38, reason: from getter */
    public final boolean getIsApplied() {
        return this.isApplied;
    }

    /* renamed from: component39, reason: from getter */
    public final boolean getCanEdit() {
        return this.canEdit;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getUpdate_btn() {
        return this.update_btn;
    }

    /* renamed from: component40, reason: from getter */
    public final String getCanEditMessage() {
        return this.canEditMessage;
    }

    /* renamed from: component41, reason: from getter */
    public final boolean getSemRegistrationStatus() {
        return this.semRegistrationStatus;
    }

    /* renamed from: component42, reason: from getter */
    public final String getSemRegistrationStatusMessage() {
        return this.semRegistrationStatusMessage;
    }

    /* renamed from: component43, reason: from getter */
    public final boolean getFeeExemption() {
        return this.feeExemption;
    }

    /* renamed from: component44, reason: from getter */
    public final String getClassTeacherRemark() {
        return this.classTeacherRemark;
    }

    /* renamed from: component45, reason: from getter */
    public final String getHodRemarks() {
        return this.hodRemarks;
    }

    /* renamed from: component46, reason: from getter */
    public final String getLastAttendedSem() {
        return this.lastAttendedSem;
    }

    /* renamed from: component47, reason: from getter */
    public final String getLastAttendedSemText() {
        return this.lastAttendedSemText;
    }

    public final ArrayList<Semester> component48() {
        return this.semList;
    }

    /* renamed from: component5, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component6, reason: from getter */
    public final String getGender() {
        return this.gender;
    }

    /* renamed from: component7, reason: from getter */
    public final String getPhone() {
        return this.phone;
    }

    /* renamed from: component8, reason: from getter */
    public final String getEmail() {
        return this.email;
    }

    /* renamed from: component9, reason: from getter */
    public final String getExamAppear() {
        return this.examAppear;
    }

    public final SemRegViewResponse copy(boolean login, String admissionNo, String semAppliedFor, boolean update_btn, String name, String gender, String phone, String email, String examAppear, String uniRegNo, String examMonthYear, String backPaper, String backPaperCount, String earnedCredits, String feePaid, String bankName, String amountPaid, String paymentDate, String paymentReferenceNo, String paymentMode, String feeReceiptFile, String regSlipFile, String feeConcession, String feeConcessionCategory, String departmentDue, String departmentDueDetails, String libraryDue, String libraryDueDetails, String accountsDue, String accountsDueDetails, String academicDue, String academicDueDetails, String hostelDue, String hostelDueDetails, String busDue, String busDueDetails, String status, boolean isApplied, boolean canEdit, String canEditMessage, boolean semRegistrationStatus, String semRegistrationStatusMessage, boolean feeExemption, String classTeacherRemark, String hodRemarks, String lastAttendedSem, String lastAttendedSemText, ArrayList<Semester> semList) {
        Intrinsics.checkNotNullParameter(admissionNo, "admissionNo");
        Intrinsics.checkNotNullParameter(semAppliedFor, "semAppliedFor");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(gender, "gender");
        Intrinsics.checkNotNullParameter(phone, "phone");
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(examAppear, "examAppear");
        Intrinsics.checkNotNullParameter(uniRegNo, "uniRegNo");
        Intrinsics.checkNotNullParameter(examMonthYear, "examMonthYear");
        Intrinsics.checkNotNullParameter(backPaper, "backPaper");
        Intrinsics.checkNotNullParameter(backPaperCount, "backPaperCount");
        Intrinsics.checkNotNullParameter(earnedCredits, "earnedCredits");
        Intrinsics.checkNotNullParameter(feePaid, "feePaid");
        Intrinsics.checkNotNullParameter(bankName, "bankName");
        Intrinsics.checkNotNullParameter(amountPaid, "amountPaid");
        Intrinsics.checkNotNullParameter(paymentDate, "paymentDate");
        Intrinsics.checkNotNullParameter(paymentReferenceNo, "paymentReferenceNo");
        Intrinsics.checkNotNullParameter(paymentMode, "paymentMode");
        Intrinsics.checkNotNullParameter(feeReceiptFile, "feeReceiptFile");
        Intrinsics.checkNotNullParameter(regSlipFile, "regSlipFile");
        Intrinsics.checkNotNullParameter(feeConcession, "feeConcession");
        Intrinsics.checkNotNullParameter(feeConcessionCategory, "feeConcessionCategory");
        Intrinsics.checkNotNullParameter(departmentDue, "departmentDue");
        Intrinsics.checkNotNullParameter(departmentDueDetails, "departmentDueDetails");
        Intrinsics.checkNotNullParameter(libraryDue, "libraryDue");
        Intrinsics.checkNotNullParameter(libraryDueDetails, "libraryDueDetails");
        Intrinsics.checkNotNullParameter(accountsDue, "accountsDue");
        Intrinsics.checkNotNullParameter(accountsDueDetails, "accountsDueDetails");
        Intrinsics.checkNotNullParameter(academicDue, "academicDue");
        Intrinsics.checkNotNullParameter(academicDueDetails, "academicDueDetails");
        Intrinsics.checkNotNullParameter(hostelDue, "hostelDue");
        Intrinsics.checkNotNullParameter(hostelDueDetails, "hostelDueDetails");
        Intrinsics.checkNotNullParameter(busDue, "busDue");
        Intrinsics.checkNotNullParameter(busDueDetails, "busDueDetails");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(canEditMessage, "canEditMessage");
        Intrinsics.checkNotNullParameter(semRegistrationStatusMessage, "semRegistrationStatusMessage");
        Intrinsics.checkNotNullParameter(classTeacherRemark, "classTeacherRemark");
        Intrinsics.checkNotNullParameter(hodRemarks, "hodRemarks");
        Intrinsics.checkNotNullParameter(lastAttendedSem, "lastAttendedSem");
        Intrinsics.checkNotNullParameter(lastAttendedSemText, "lastAttendedSemText");
        Intrinsics.checkNotNullParameter(semList, "semList");
        return new SemRegViewResponse(login, admissionNo, semAppliedFor, update_btn, name, gender, phone, email, examAppear, uniRegNo, examMonthYear, backPaper, backPaperCount, earnedCredits, feePaid, bankName, amountPaid, paymentDate, paymentReferenceNo, paymentMode, feeReceiptFile, regSlipFile, feeConcession, feeConcessionCategory, departmentDue, departmentDueDetails, libraryDue, libraryDueDetails, accountsDue, accountsDueDetails, academicDue, academicDueDetails, hostelDue, hostelDueDetails, busDue, busDueDetails, status, isApplied, canEdit, canEditMessage, semRegistrationStatus, semRegistrationStatusMessage, feeExemption, classTeacherRemark, hodRemarks, lastAttendedSem, lastAttendedSemText, semList);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SemRegViewResponse)) {
            return false;
        }
        SemRegViewResponse semRegViewResponse = (SemRegViewResponse) other;
        return this.login == semRegViewResponse.login && Intrinsics.areEqual(this.admissionNo, semRegViewResponse.admissionNo) && Intrinsics.areEqual(this.semAppliedFor, semRegViewResponse.semAppliedFor) && this.update_btn == semRegViewResponse.update_btn && Intrinsics.areEqual(this.name, semRegViewResponse.name) && Intrinsics.areEqual(this.gender, semRegViewResponse.gender) && Intrinsics.areEqual(this.phone, semRegViewResponse.phone) && Intrinsics.areEqual(this.email, semRegViewResponse.email) && Intrinsics.areEqual(this.examAppear, semRegViewResponse.examAppear) && Intrinsics.areEqual(this.uniRegNo, semRegViewResponse.uniRegNo) && Intrinsics.areEqual(this.examMonthYear, semRegViewResponse.examMonthYear) && Intrinsics.areEqual(this.backPaper, semRegViewResponse.backPaper) && Intrinsics.areEqual(this.backPaperCount, semRegViewResponse.backPaperCount) && Intrinsics.areEqual(this.earnedCredits, semRegViewResponse.earnedCredits) && Intrinsics.areEqual(this.feePaid, semRegViewResponse.feePaid) && Intrinsics.areEqual(this.bankName, semRegViewResponse.bankName) && Intrinsics.areEqual(this.amountPaid, semRegViewResponse.amountPaid) && Intrinsics.areEqual(this.paymentDate, semRegViewResponse.paymentDate) && Intrinsics.areEqual(this.paymentReferenceNo, semRegViewResponse.paymentReferenceNo) && Intrinsics.areEqual(this.paymentMode, semRegViewResponse.paymentMode) && Intrinsics.areEqual(this.feeReceiptFile, semRegViewResponse.feeReceiptFile) && Intrinsics.areEqual(this.regSlipFile, semRegViewResponse.regSlipFile) && Intrinsics.areEqual(this.feeConcession, semRegViewResponse.feeConcession) && Intrinsics.areEqual(this.feeConcessionCategory, semRegViewResponse.feeConcessionCategory) && Intrinsics.areEqual(this.departmentDue, semRegViewResponse.departmentDue) && Intrinsics.areEqual(this.departmentDueDetails, semRegViewResponse.departmentDueDetails) && Intrinsics.areEqual(this.libraryDue, semRegViewResponse.libraryDue) && Intrinsics.areEqual(this.libraryDueDetails, semRegViewResponse.libraryDueDetails) && Intrinsics.areEqual(this.accountsDue, semRegViewResponse.accountsDue) && Intrinsics.areEqual(this.accountsDueDetails, semRegViewResponse.accountsDueDetails) && Intrinsics.areEqual(this.academicDue, semRegViewResponse.academicDue) && Intrinsics.areEqual(this.academicDueDetails, semRegViewResponse.academicDueDetails) && Intrinsics.areEqual(this.hostelDue, semRegViewResponse.hostelDue) && Intrinsics.areEqual(this.hostelDueDetails, semRegViewResponse.hostelDueDetails) && Intrinsics.areEqual(this.busDue, semRegViewResponse.busDue) && Intrinsics.areEqual(this.busDueDetails, semRegViewResponse.busDueDetails) && Intrinsics.areEqual(this.status, semRegViewResponse.status) && this.isApplied == semRegViewResponse.isApplied && this.canEdit == semRegViewResponse.canEdit && Intrinsics.areEqual(this.canEditMessage, semRegViewResponse.canEditMessage) && this.semRegistrationStatus == semRegViewResponse.semRegistrationStatus && Intrinsics.areEqual(this.semRegistrationStatusMessage, semRegViewResponse.semRegistrationStatusMessage) && this.feeExemption == semRegViewResponse.feeExemption && Intrinsics.areEqual(this.classTeacherRemark, semRegViewResponse.classTeacherRemark) && Intrinsics.areEqual(this.hodRemarks, semRegViewResponse.hodRemarks) && Intrinsics.areEqual(this.lastAttendedSem, semRegViewResponse.lastAttendedSem) && Intrinsics.areEqual(this.lastAttendedSemText, semRegViewResponse.lastAttendedSemText) && Intrinsics.areEqual(this.semList, semRegViewResponse.semList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v96 */
    /* JADX WARN: Type inference failed for: r0v97 */
    /* JADX WARN: Type inference failed for: r2v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v72, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v74, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v78, types: [boolean] */
    public int hashCode() {
        boolean z = this.login;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int hashCode = ((((r0 * 31) + this.admissionNo.hashCode()) * 31) + this.semAppliedFor.hashCode()) * 31;
        ?? r2 = this.update_btn;
        int i = r2;
        if (r2 != 0) {
            i = 1;
        }
        int hashCode2 = (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((hashCode + i) * 31) + this.name.hashCode()) * 31) + this.gender.hashCode()) * 31) + this.phone.hashCode()) * 31) + this.email.hashCode()) * 31) + this.examAppear.hashCode()) * 31) + this.uniRegNo.hashCode()) * 31) + this.examMonthYear.hashCode()) * 31) + this.backPaper.hashCode()) * 31) + this.backPaperCount.hashCode()) * 31) + this.earnedCredits.hashCode()) * 31) + this.feePaid.hashCode()) * 31) + this.bankName.hashCode()) * 31) + this.amountPaid.hashCode()) * 31) + this.paymentDate.hashCode()) * 31) + this.paymentReferenceNo.hashCode()) * 31) + this.paymentMode.hashCode()) * 31) + this.feeReceiptFile.hashCode()) * 31) + this.regSlipFile.hashCode()) * 31) + this.feeConcession.hashCode()) * 31) + this.feeConcessionCategory.hashCode()) * 31) + this.departmentDue.hashCode()) * 31) + this.departmentDueDetails.hashCode()) * 31) + this.libraryDue.hashCode()) * 31) + this.libraryDueDetails.hashCode()) * 31) + this.accountsDue.hashCode()) * 31) + this.accountsDueDetails.hashCode()) * 31) + this.academicDue.hashCode()) * 31) + this.academicDueDetails.hashCode()) * 31) + this.hostelDue.hashCode()) * 31) + this.hostelDueDetails.hashCode()) * 31) + this.busDue.hashCode()) * 31) + this.busDueDetails.hashCode()) * 31) + this.status.hashCode()) * 31;
        ?? r22 = this.isApplied;
        int i2 = r22;
        if (r22 != 0) {
            i2 = 1;
        }
        int i3 = (hashCode2 + i2) * 31;
        ?? r23 = this.canEdit;
        int i4 = r23;
        if (r23 != 0) {
            i4 = 1;
        }
        int hashCode3 = (((i3 + i4) * 31) + this.canEditMessage.hashCode()) * 31;
        ?? r24 = this.semRegistrationStatus;
        int i5 = r24;
        if (r24 != 0) {
            i5 = 1;
        }
        int hashCode4 = (((hashCode3 + i5) * 31) + this.semRegistrationStatusMessage.hashCode()) * 31;
        boolean z2 = this.feeExemption;
        return ((((((((((hashCode4 + (z2 ? 1 : z2 ? 1 : 0)) * 31) + this.classTeacherRemark.hashCode()) * 31) + this.hodRemarks.hashCode()) * 31) + this.lastAttendedSem.hashCode()) * 31) + this.lastAttendedSemText.hashCode()) * 31) + this.semList.hashCode();
    }

    public String toString() {
        return "SemRegViewResponse(login=" + this.login + ", admissionNo=" + this.admissionNo + ", semAppliedFor=" + this.semAppliedFor + ", update_btn=" + this.update_btn + ", name=" + this.name + ", gender=" + this.gender + ", phone=" + this.phone + ", email=" + this.email + ", examAppear=" + this.examAppear + ", uniRegNo=" + this.uniRegNo + ", examMonthYear=" + this.examMonthYear + ", backPaper=" + this.backPaper + ", backPaperCount=" + this.backPaperCount + ", earnedCredits=" + this.earnedCredits + ", feePaid=" + this.feePaid + ", bankName=" + this.bankName + ", amountPaid=" + this.amountPaid + ", paymentDate=" + this.paymentDate + ", paymentReferenceNo=" + this.paymentReferenceNo + ", paymentMode=" + this.paymentMode + ", feeReceiptFile=" + this.feeReceiptFile + ", regSlipFile=" + this.regSlipFile + ", feeConcession=" + this.feeConcession + ", feeConcessionCategory=" + this.feeConcessionCategory + ", departmentDue=" + this.departmentDue + ", departmentDueDetails=" + this.departmentDueDetails + ", libraryDue=" + this.libraryDue + ", libraryDueDetails=" + this.libraryDueDetails + ", accountsDue=" + this.accountsDue + ", accountsDueDetails=" + this.accountsDueDetails + ", academicDue=" + this.academicDue + ", academicDueDetails=" + this.academicDueDetails + ", hostelDue=" + this.hostelDue + ", hostelDueDetails=" + this.hostelDueDetails + ", busDue=" + this.busDue + ", busDueDetails=" + this.busDueDetails + ", status=" + this.status + ", isApplied=" + this.isApplied + ", canEdit=" + this.canEdit + ", canEditMessage=" + this.canEditMessage + ", semRegistrationStatus=" + this.semRegistrationStatus + ", semRegistrationStatusMessage=" + this.semRegistrationStatusMessage + ", feeExemption=" + this.feeExemption + ", classTeacherRemark=" + this.classTeacherRemark + ", hodRemarks=" + this.hodRemarks + ", lastAttendedSem=" + this.lastAttendedSem + ", lastAttendedSemText=" + this.lastAttendedSemText + ", semList=" + this.semList + ")";
    }

    public SemRegViewResponse(boolean z, String admissionNo, String semAppliedFor, boolean z2, String name, String gender, String phone, String email, String examAppear, String uniRegNo, String examMonthYear, String backPaper, String backPaperCount, String earnedCredits, String feePaid, String bankName, String amountPaid, String paymentDate, String paymentReferenceNo, String paymentMode, String feeReceiptFile, String regSlipFile, String feeConcession, String feeConcessionCategory, String departmentDue, String departmentDueDetails, String libraryDue, String libraryDueDetails, String accountsDue, String accountsDueDetails, String academicDue, String academicDueDetails, String hostelDue, String hostelDueDetails, String busDue, String busDueDetails, String status, boolean z3, boolean z4, String canEditMessage, boolean z5, String semRegistrationStatusMessage, boolean z6, String classTeacherRemark, String hodRemarks, String lastAttendedSem, String lastAttendedSemText, ArrayList<Semester> semList) {
        Intrinsics.checkNotNullParameter(admissionNo, "admissionNo");
        Intrinsics.checkNotNullParameter(semAppliedFor, "semAppliedFor");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(gender, "gender");
        Intrinsics.checkNotNullParameter(phone, "phone");
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(examAppear, "examAppear");
        Intrinsics.checkNotNullParameter(uniRegNo, "uniRegNo");
        Intrinsics.checkNotNullParameter(examMonthYear, "examMonthYear");
        Intrinsics.checkNotNullParameter(backPaper, "backPaper");
        Intrinsics.checkNotNullParameter(backPaperCount, "backPaperCount");
        Intrinsics.checkNotNullParameter(earnedCredits, "earnedCredits");
        Intrinsics.checkNotNullParameter(feePaid, "feePaid");
        Intrinsics.checkNotNullParameter(bankName, "bankName");
        Intrinsics.checkNotNullParameter(amountPaid, "amountPaid");
        Intrinsics.checkNotNullParameter(paymentDate, "paymentDate");
        Intrinsics.checkNotNullParameter(paymentReferenceNo, "paymentReferenceNo");
        Intrinsics.checkNotNullParameter(paymentMode, "paymentMode");
        Intrinsics.checkNotNullParameter(feeReceiptFile, "feeReceiptFile");
        Intrinsics.checkNotNullParameter(regSlipFile, "regSlipFile");
        Intrinsics.checkNotNullParameter(feeConcession, "feeConcession");
        Intrinsics.checkNotNullParameter(feeConcessionCategory, "feeConcessionCategory");
        Intrinsics.checkNotNullParameter(departmentDue, "departmentDue");
        Intrinsics.checkNotNullParameter(departmentDueDetails, "departmentDueDetails");
        Intrinsics.checkNotNullParameter(libraryDue, "libraryDue");
        Intrinsics.checkNotNullParameter(libraryDueDetails, "libraryDueDetails");
        Intrinsics.checkNotNullParameter(accountsDue, "accountsDue");
        Intrinsics.checkNotNullParameter(accountsDueDetails, "accountsDueDetails");
        Intrinsics.checkNotNullParameter(academicDue, "academicDue");
        Intrinsics.checkNotNullParameter(academicDueDetails, "academicDueDetails");
        Intrinsics.checkNotNullParameter(hostelDue, "hostelDue");
        Intrinsics.checkNotNullParameter(hostelDueDetails, "hostelDueDetails");
        Intrinsics.checkNotNullParameter(busDue, "busDue");
        Intrinsics.checkNotNullParameter(busDueDetails, "busDueDetails");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(canEditMessage, "canEditMessage");
        Intrinsics.checkNotNullParameter(semRegistrationStatusMessage, "semRegistrationStatusMessage");
        Intrinsics.checkNotNullParameter(classTeacherRemark, "classTeacherRemark");
        Intrinsics.checkNotNullParameter(hodRemarks, "hodRemarks");
        Intrinsics.checkNotNullParameter(lastAttendedSem, "lastAttendedSem");
        Intrinsics.checkNotNullParameter(lastAttendedSemText, "lastAttendedSemText");
        Intrinsics.checkNotNullParameter(semList, "semList");
        this.login = z;
        this.admissionNo = admissionNo;
        this.semAppliedFor = semAppliedFor;
        this.update_btn = z2;
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.examAppear = examAppear;
        this.uniRegNo = uniRegNo;
        this.examMonthYear = examMonthYear;
        this.backPaper = backPaper;
        this.backPaperCount = backPaperCount;
        this.earnedCredits = earnedCredits;
        this.feePaid = feePaid;
        this.bankName = bankName;
        this.amountPaid = amountPaid;
        this.paymentDate = paymentDate;
        this.paymentReferenceNo = paymentReferenceNo;
        this.paymentMode = paymentMode;
        this.feeReceiptFile = feeReceiptFile;
        this.regSlipFile = regSlipFile;
        this.feeConcession = feeConcession;
        this.feeConcessionCategory = feeConcessionCategory;
        this.departmentDue = departmentDue;
        this.departmentDueDetails = departmentDueDetails;
        this.libraryDue = libraryDue;
        this.libraryDueDetails = libraryDueDetails;
        this.accountsDue = accountsDue;
        this.accountsDueDetails = accountsDueDetails;
        this.academicDue = academicDue;
        this.academicDueDetails = academicDueDetails;
        this.hostelDue = hostelDue;
        this.hostelDueDetails = hostelDueDetails;
        this.busDue = busDue;
        this.busDueDetails = busDueDetails;
        this.status = status;
        this.isApplied = z3;
        this.canEdit = z4;
        this.canEditMessage = canEditMessage;
        this.semRegistrationStatus = z5;
        this.semRegistrationStatusMessage = semRegistrationStatusMessage;
        this.feeExemption = z6;
        this.classTeacherRemark = classTeacherRemark;
        this.hodRemarks = hodRemarks;
        this.lastAttendedSem = lastAttendedSem;
        this.lastAttendedSemText = lastAttendedSemText;
        this.semList = semList;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final String getAdmissionNo() {
        return this.admissionNo;
    }

    public final String getSemAppliedFor() {
        return this.semAppliedFor;
    }

    public final boolean getUpdate_btn() {
        return this.update_btn;
    }

    public final String getName() {
        return this.name;
    }

    public final String getGender() {
        return this.gender;
    }

    public final String getPhone() {
        return this.phone;
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getExamAppear() {
        return this.examAppear;
    }

    public final String getUniRegNo() {
        return this.uniRegNo;
    }

    public final String getExamMonthYear() {
        return this.examMonthYear;
    }

    public final String getBackPaper() {
        return this.backPaper;
    }

    public final String getBackPaperCount() {
        return this.backPaperCount;
    }

    public final String getEarnedCredits() {
        return this.earnedCredits;
    }

    public final String getFeePaid() {
        return this.feePaid;
    }

    public final String getBankName() {
        return this.bankName;
    }

    public final String getAmountPaid() {
        return this.amountPaid;
    }

    public final String getPaymentDate() {
        return this.paymentDate;
    }

    public final String getPaymentReferenceNo() {
        return this.paymentReferenceNo;
    }

    public final String getPaymentMode() {
        return this.paymentMode;
    }

    public final String getFeeReceiptFile() {
        return this.feeReceiptFile;
    }

    public final String getRegSlipFile() {
        return this.regSlipFile;
    }

    public final String getFeeConcession() {
        return this.feeConcession;
    }

    public final String getFeeConcessionCategory() {
        return this.feeConcessionCategory;
    }

    public final String getDepartmentDue() {
        return this.departmentDue;
    }

    public final String getDepartmentDueDetails() {
        return this.departmentDueDetails;
    }

    public final String getLibraryDue() {
        return this.libraryDue;
    }

    public final String getLibraryDueDetails() {
        return this.libraryDueDetails;
    }

    public final String getAccountsDue() {
        return this.accountsDue;
    }

    public final String getAccountsDueDetails() {
        return this.accountsDueDetails;
    }

    public final String getAcademicDue() {
        return this.academicDue;
    }

    public final String getAcademicDueDetails() {
        return this.academicDueDetails;
    }

    public final String getHostelDue() {
        return this.hostelDue;
    }

    public final String getHostelDueDetails() {
        return this.hostelDueDetails;
    }

    public final String getBusDue() {
        return this.busDue;
    }

    public final String getBusDueDetails() {
        return this.busDueDetails;
    }

    public final String getStatus() {
        return this.status;
    }

    public final boolean isApplied() {
        return this.isApplied;
    }

    public final boolean getCanEdit() {
        return this.canEdit;
    }

    public final String getCanEditMessage() {
        return this.canEditMessage;
    }

    public final boolean getSemRegistrationStatus() {
        return this.semRegistrationStatus;
    }

    public final String getSemRegistrationStatusMessage() {
        return this.semRegistrationStatusMessage;
    }

    public final boolean getFeeExemption() {
        return this.feeExemption;
    }

    public final String getClassTeacherRemark() {
        return this.classTeacherRemark;
    }

    public final String getHodRemarks() {
        return this.hodRemarks;
    }

    public final String getLastAttendedSem() {
        return this.lastAttendedSem;
    }

    public final String getLastAttendedSemText() {
        return this.lastAttendedSemText;
    }

    public final ArrayList<Semester> getSemList() {
        return this.semList;
    }
}