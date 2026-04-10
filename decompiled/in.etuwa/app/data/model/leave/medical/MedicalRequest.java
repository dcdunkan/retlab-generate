package in.etuwa.app.data.model.leave.medical;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MedicalRequest.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class MedicalRequest {

    @SerializedName("from_date")
    @Expose
    private final String dFrom;

    @SerializedName("to_date")
    @Expose
    private final String dTo;
    private final String reason;

    public static /* synthetic */ MedicalRequest copy$default(MedicalRequest medicalRequest, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = medicalRequest.reason;
        }
        if ((i & 2) != 0) {
            str2 = medicalRequest.dFrom;
        }
        if ((i & 4) != 0) {
            str3 = medicalRequest.dTo;
        }
        return medicalRequest.copy(str, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getReason() {
        return this.reason;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDFrom() {
        return this.dFrom;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDTo() {
        return this.dTo;
    }

    public final MedicalRequest copy(String reason, String dFrom, String dTo) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        Intrinsics.checkNotNullParameter(dFrom, "dFrom");
        Intrinsics.checkNotNullParameter(dTo, "dTo");
        return new MedicalRequest(reason, dFrom, dTo);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MedicalRequest)) {
            return false;
        }
        MedicalRequest medicalRequest = (MedicalRequest) other;
        return Intrinsics.areEqual(this.reason, medicalRequest.reason) && Intrinsics.areEqual(this.dFrom, medicalRequest.dFrom) && Intrinsics.areEqual(this.dTo, medicalRequest.dTo);
    }

    public int hashCode() {
        return (((this.reason.hashCode() * 31) + this.dFrom.hashCode()) * 31) + this.dTo.hashCode();
    }

    public String toString() {
        return "MedicalRequest(reason=" + this.reason + ", dFrom=" + this.dFrom + ", dTo=" + this.dTo + ")";
    }

    public MedicalRequest(String reason, String dFrom, String dTo) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        Intrinsics.checkNotNullParameter(dFrom, "dFrom");
        Intrinsics.checkNotNullParameter(dTo, "dTo");
        this.reason = reason;
        this.dFrom = dFrom;
        this.dTo = dTo;
    }

    public final String getReason() {
        return this.reason;
    }

    public final String getDFrom() {
        return this.dFrom;
    }

    public final String getDTo() {
        return this.dTo;
    }
}