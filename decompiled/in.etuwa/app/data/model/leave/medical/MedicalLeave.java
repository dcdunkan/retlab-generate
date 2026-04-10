package in.etuwa.app.data.model.leave.medical;

import androidx.core.app.NotificationCompat;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MedicalLeave.kt */
/* loaded from: classes3.dex */
public final /* data */ class MedicalLeave {

    @SerializedName("datefrom")
    @Expose
    private final String dFrom;

    @SerializedName("dateto")
    @Expose
    private final String dTo;
    private final String reason;
    private final String remark;
    private final String status;

    public static /* synthetic */ MedicalLeave copy$default(MedicalLeave medicalLeave, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = medicalLeave.reason;
        }
        if ((i & 2) != 0) {
            str2 = medicalLeave.dFrom;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = medicalLeave.dTo;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = medicalLeave.status;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = medicalLeave.remark;
        }
        return medicalLeave.copy(str, str6, str7, str8, str5);
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

    /* renamed from: component4, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: component5, reason: from getter */
    public final String getRemark() {
        return this.remark;
    }

    public final MedicalLeave copy(String reason, String dFrom, String dTo, String status, String remark) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        Intrinsics.checkNotNullParameter(dFrom, "dFrom");
        Intrinsics.checkNotNullParameter(dTo, "dTo");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(remark, "remark");
        return new MedicalLeave(reason, dFrom, dTo, status, remark);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MedicalLeave)) {
            return false;
        }
        MedicalLeave medicalLeave = (MedicalLeave) other;
        return Intrinsics.areEqual(this.reason, medicalLeave.reason) && Intrinsics.areEqual(this.dFrom, medicalLeave.dFrom) && Intrinsics.areEqual(this.dTo, medicalLeave.dTo) && Intrinsics.areEqual(this.status, medicalLeave.status) && Intrinsics.areEqual(this.remark, medicalLeave.remark);
    }

    public int hashCode() {
        return (((((((this.reason.hashCode() * 31) + this.dFrom.hashCode()) * 31) + this.dTo.hashCode()) * 31) + this.status.hashCode()) * 31) + this.remark.hashCode();
    }

    public String toString() {
        return "MedicalLeave(reason=" + this.reason + ", dFrom=" + this.dFrom + ", dTo=" + this.dTo + ", status=" + this.status + ", remark=" + this.remark + ")";
    }

    public MedicalLeave(String reason, String dFrom, String dTo, String status, String remark) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        Intrinsics.checkNotNullParameter(dFrom, "dFrom");
        Intrinsics.checkNotNullParameter(dTo, "dTo");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(remark, "remark");
        this.reason = reason;
        this.dFrom = dFrom;
        this.dTo = dTo;
        this.status = status;
        this.remark = remark;
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

    public final String getStatus() {
        return this.status;
    }

    public final String getRemark() {
        return this.remark;
    }
}