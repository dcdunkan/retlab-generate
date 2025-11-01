package in.etuwa.app.data.model.leave.medical;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MedicalRequest.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lin/etuwa/app/data/model/leave/medical/MedicalRequest;", "", "reason", "", "dFrom", "dTo", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDFrom", "()Ljava/lang/String;", "getDTo", "getReason", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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

    /* renamed from: component1, reason: from getter */
    public final String getReason() {
        return this.reason;
    }

    /* renamed from: component2, reason: from getter */
    public final String getDFrom() {
        return this.dFrom;
    }

    /* renamed from: component3, reason: from getter */
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