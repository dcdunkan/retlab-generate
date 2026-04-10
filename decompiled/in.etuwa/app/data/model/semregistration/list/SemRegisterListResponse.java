package in.etuwa.app.data.model.semregistration.list;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SemRegisterListResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class SemRegisterListResponse {

    @SerializedName("due_status")
    private final boolean dueStatus;

    @SerializedName("sem_registration_error")
    private final String errorMessage;

    @SerializedName("fee_exemption")
    private final boolean feeExemption;

    @SerializedName("fee_paid")
    private final boolean feePaid;

    @SerializedName("hostel_due_message")
    private final String hostelDueMessage;

    @SerializedName("hostel_due_status")
    private final boolean hostelDueStatus;
    private final boolean login;

    @SerializedName("register_list")
    private final ArrayList<RegisterList> registerList;

    @SerializedName("sem_registration_status")
    private final boolean semRegistrationStatus;

    @SerializedName("sem_registration_status_message")
    private final String semRegistrationStatusMessage;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final boolean getFeePaid() {
        return this.feePaid;
    }

    public final ArrayList<RegisterList> component2() {
        return this.registerList;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getSemRegistrationStatus() {
        return this.semRegistrationStatus;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getSemRegistrationStatusMessage() {
        return this.semRegistrationStatusMessage;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getHostelDueMessage() {
        return this.hostelDueMessage;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getHostelDueStatus() {
        return this.hostelDueStatus;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getFeeExemption() {
        return this.feeExemption;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getDueStatus() {
        return this.dueStatus;
    }

    public final SemRegisterListResponse copy(boolean login, ArrayList<RegisterList> registerList, boolean semRegistrationStatus, String semRegistrationStatusMessage, String errorMessage, String hostelDueMessage, boolean hostelDueStatus, boolean feeExemption, boolean dueStatus, boolean feePaid) {
        Intrinsics.checkNotNullParameter(registerList, "registerList");
        Intrinsics.checkNotNullParameter(semRegistrationStatusMessage, "semRegistrationStatusMessage");
        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        Intrinsics.checkNotNullParameter(hostelDueMessage, "hostelDueMessage");
        return new SemRegisterListResponse(login, registerList, semRegistrationStatus, semRegistrationStatusMessage, errorMessage, hostelDueMessage, hostelDueStatus, feeExemption, dueStatus, feePaid);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SemRegisterListResponse)) {
            return false;
        }
        SemRegisterListResponse semRegisterListResponse = (SemRegisterListResponse) other;
        return this.login == semRegisterListResponse.login && Intrinsics.areEqual(this.registerList, semRegisterListResponse.registerList) && this.semRegistrationStatus == semRegisterListResponse.semRegistrationStatus && Intrinsics.areEqual(this.semRegistrationStatusMessage, semRegisterListResponse.semRegistrationStatusMessage) && Intrinsics.areEqual(this.errorMessage, semRegisterListResponse.errorMessage) && Intrinsics.areEqual(this.hostelDueMessage, semRegisterListResponse.hostelDueMessage) && this.hostelDueStatus == semRegisterListResponse.hostelDueStatus && this.feeExemption == semRegisterListResponse.feeExemption && this.dueStatus == semRegisterListResponse.dueStatus && this.feePaid == semRegisterListResponse.feePaid;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v11, types: [int] */
    /* JADX WARN: Type inference failed for: r2v13, types: [int] */
    /* JADX WARN: Type inference failed for: r2v15, types: [int] */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    public int hashCode() {
        boolean z = this.login;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int iHashCode = ((r0 * 31) + this.registerList.hashCode()) * 31;
        boolean z2 = this.semRegistrationStatus;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int iHashCode2 = (((((((iHashCode + r2) * 31) + this.semRegistrationStatusMessage.hashCode()) * 31) + this.errorMessage.hashCode()) * 31) + this.hostelDueMessage.hashCode()) * 31;
        boolean z3 = this.hostelDueStatus;
        ?? r22 = z3;
        if (z3) {
            r22 = 1;
        }
        int i = (iHashCode2 + r22) * 31;
        boolean z4 = this.feeExemption;
        ?? r23 = z4;
        if (z4) {
            r23 = 1;
        }
        int i2 = (i + r23) * 31;
        boolean z5 = this.dueStatus;
        ?? r24 = z5;
        if (z5) {
            r24 = 1;
        }
        int i3 = (i2 + r24) * 31;
        boolean z6 = this.feePaid;
        return i3 + (z6 ? 1 : z6);
    }

    public String toString() {
        return "SemRegisterListResponse(login=" + this.login + ", registerList=" + this.registerList + ", semRegistrationStatus=" + this.semRegistrationStatus + ", semRegistrationStatusMessage=" + this.semRegistrationStatusMessage + ", errorMessage=" + this.errorMessage + ", hostelDueMessage=" + this.hostelDueMessage + ", hostelDueStatus=" + this.hostelDueStatus + ", feeExemption=" + this.feeExemption + ", dueStatus=" + this.dueStatus + ", feePaid=" + this.feePaid + ")";
    }

    public SemRegisterListResponse(boolean z, ArrayList<RegisterList> registerList, boolean z2, String semRegistrationStatusMessage, String errorMessage, String hostelDueMessage, boolean z3, boolean z4, boolean z5, boolean z6) {
        Intrinsics.checkNotNullParameter(registerList, "registerList");
        Intrinsics.checkNotNullParameter(semRegistrationStatusMessage, "semRegistrationStatusMessage");
        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        Intrinsics.checkNotNullParameter(hostelDueMessage, "hostelDueMessage");
        this.login = z;
        this.registerList = registerList;
        this.semRegistrationStatus = z2;
        this.semRegistrationStatusMessage = semRegistrationStatusMessage;
        this.errorMessage = errorMessage;
        this.hostelDueMessage = hostelDueMessage;
        this.hostelDueStatus = z3;
        this.feeExemption = z4;
        this.dueStatus = z5;
        this.feePaid = z6;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<RegisterList> getRegisterList() {
        return this.registerList;
    }

    public final boolean getSemRegistrationStatus() {
        return this.semRegistrationStatus;
    }

    public final String getSemRegistrationStatusMessage() {
        return this.semRegistrationStatusMessage;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final String getHostelDueMessage() {
        return this.hostelDueMessage;
    }

    public final boolean getHostelDueStatus() {
        return this.hostelDueStatus;
    }

    public final boolean getFeeExemption() {
        return this.feeExemption;
    }

    public final boolean getDueStatus() {
        return this.dueStatus;
    }

    public final boolean getFeePaid() {
        return this.feePaid;
    }
}