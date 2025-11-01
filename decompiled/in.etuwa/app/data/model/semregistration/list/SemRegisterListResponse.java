package in.etuwa.app.data.model.semregistration.list;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SemRegisterListResponse.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\"\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Be\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003¢\u0006\u0002\u0010\u0011J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u0019\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\nHÆ\u0003J\t\u0010$\u001a\u00020\nHÆ\u0003J\t\u0010%\u001a\u00020\nHÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J}\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u0003HÆ\u0001J\u0013\u0010*\u001a\u00020\u00032\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020-HÖ\u0001J\t\u0010.\u001a\u00020\nHÖ\u0001R\u0016\u0010\u000f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u000b\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u000e\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0016\u0010\u0010\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0016\u0010\f\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R&\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015¨\u0006/"}, d2 = {"Lin/etuwa/app/data/model/semregistration/list/SemRegisterListResponse;", "", FirebaseAnalytics.Event.LOGIN, "", "registerList", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/semregistration/list/RegisterList;", "Lkotlin/collections/ArrayList;", "semRegistrationStatus", "semRegistrationStatusMessage", "", "errorMessage", "hostelDueMessage", "hostelDueStatus", "feeExemption", "dueStatus", "feePaid", "(ZLjava/util/ArrayList;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZZ)V", "getDueStatus", "()Z", "getErrorMessage", "()Ljava/lang/String;", "getFeeExemption", "getFeePaid", "getHostelDueMessage", "getHostelDueStatus", "getLogin", "getRegisterList", "()Ljava/util/ArrayList;", "getSemRegistrationStatus", "getSemRegistrationStatusMessage", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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

    /* renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    /* renamed from: component10, reason: from getter */
    public final boolean getFeePaid() {
        return this.feePaid;
    }

    public final ArrayList<RegisterList> component2() {
        return this.registerList;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getSemRegistrationStatus() {
        return this.semRegistrationStatus;
    }

    /* renamed from: component4, reason: from getter */
    public final String getSemRegistrationStatusMessage() {
        return this.semRegistrationStatusMessage;
    }

    /* renamed from: component5, reason: from getter */
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    /* renamed from: component6, reason: from getter */
    public final String getHostelDueMessage() {
        return this.hostelDueMessage;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getHostelDueStatus() {
        return this.hostelDueStatus;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getFeeExemption() {
        return this.feeExemption;
    }

    /* renamed from: component9, reason: from getter */
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
    /* JADX WARN: Type inference failed for: r2v10, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v12, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v14, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v2, types: [boolean] */
    public int hashCode() {
        boolean z = this.login;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int hashCode = ((r0 * 31) + this.registerList.hashCode()) * 31;
        ?? r2 = this.semRegistrationStatus;
        int i = r2;
        if (r2 != 0) {
            i = 1;
        }
        int hashCode2 = (((((((hashCode + i) * 31) + this.semRegistrationStatusMessage.hashCode()) * 31) + this.errorMessage.hashCode()) * 31) + this.hostelDueMessage.hashCode()) * 31;
        ?? r22 = this.hostelDueStatus;
        int i2 = r22;
        if (r22 != 0) {
            i2 = 1;
        }
        int i3 = (hashCode2 + i2) * 31;
        ?? r23 = this.feeExemption;
        int i4 = r23;
        if (r23 != 0) {
            i4 = 1;
        }
        int i5 = (i3 + i4) * 31;
        ?? r24 = this.dueStatus;
        int i6 = r24;
        if (r24 != 0) {
            i6 = 1;
        }
        int i7 = (i5 + i6) * 31;
        boolean z2 = this.feePaid;
        return i7 + (z2 ? 1 : z2 ? 1 : 0);
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