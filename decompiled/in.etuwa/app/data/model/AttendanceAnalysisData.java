package in.etuwa.app.data.model;

import com.google.gson.annotations.SerializedName;
import in.etuwa.app.ui.feenewengineer.payment.feeconfirmdialog.FeeConfirmDialogKt;
import kotlin.Metadata;

/* JADX INFO: compiled from: AnalysisModels.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class AttendanceAnalysisData {

    @SerializedName("absent")
    private final int absent;

    @SerializedName("present")
    private final int present;

    @SerializedName(FeeConfirmDialogKt.ARG_TOTAL)
    private final int total;

    public static /* synthetic */ AttendanceAnalysisData copy$default(AttendanceAnalysisData attendanceAnalysisData, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = attendanceAnalysisData.present;
        }
        if ((i4 & 2) != 0) {
            i2 = attendanceAnalysisData.absent;
        }
        if ((i4 & 4) != 0) {
            i3 = attendanceAnalysisData.total;
        }
        return attendanceAnalysisData.copy(i, i2, i3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getPresent() {
        return this.present;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getAbsent() {
        return this.absent;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getTotal() {
        return this.total;
    }

    public final AttendanceAnalysisData copy(int present, int absent, int total) {
        return new AttendanceAnalysisData(present, absent, total);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AttendanceAnalysisData)) {
            return false;
        }
        AttendanceAnalysisData attendanceAnalysisData = (AttendanceAnalysisData) other;
        return this.present == attendanceAnalysisData.present && this.absent == attendanceAnalysisData.absent && this.total == attendanceAnalysisData.total;
    }

    public int hashCode() {
        return (((this.present * 31) + this.absent) * 31) + this.total;
    }

    public String toString() {
        return "AttendanceAnalysisData(present=" + this.present + ", absent=" + this.absent + ", total=" + this.total + ")";
    }

    public AttendanceAnalysisData(int i, int i2, int i3) {
        this.present = i;
        this.absent = i2;
        this.total = i3;
    }

    public final int getPresent() {
        return this.present;
    }

    public final int getAbsent() {
        return this.absent;
    }

    public final int getTotal() {
        return this.total;
    }
}