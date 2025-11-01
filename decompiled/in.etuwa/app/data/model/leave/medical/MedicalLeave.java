package in.etuwa.app.data.model.leave.medical;

import androidx.core.app.NotificationCompat;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MedicalLeave.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J;\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Lin/etuwa/app/data/model/leave/medical/MedicalLeave;", "", "reason", "", "dFrom", "dTo", NotificationCompat.CATEGORY_STATUS, "remark", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDFrom", "()Ljava/lang/String;", "getDTo", "getReason", "getRemark", "getStatus", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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