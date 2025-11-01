package in.etuwa.app.data.model.lab;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import in.etuwa.app.ui.examregistration.examsubjects.detaildialog.ExamSubjectDetailDialogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LabDue.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003JE\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001e"}, d2 = {"Lin/etuwa/app/data/model/lab/LabDue;", "", "equipment", "", "lab", ExamSubjectDetailDialogKt.ARG_AMOUNT, "dueDate", "paidStatus", "paidDate", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAmount", "()Ljava/lang/String;", "getDueDate", "getEquipment", "getLab", "getPaidDate", "getPaidStatus", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class LabDue {
    private final String amount;

    @SerializedName("due_date")
    @Expose
    private final String dueDate;
    private final String equipment;
    private final String lab;

    @SerializedName("paid_date")
    @Expose
    private final String paidDate;

    @SerializedName("paid_status")
    @Expose
    private final String paidStatus;

    public static /* synthetic */ LabDue copy$default(LabDue labDue, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = labDue.equipment;
        }
        if ((i & 2) != 0) {
            str2 = labDue.lab;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = labDue.amount;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = labDue.dueDate;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            str5 = labDue.paidStatus;
        }
        String str10 = str5;
        if ((i & 32) != 0) {
            str6 = labDue.paidDate;
        }
        return labDue.copy(str, str7, str8, str9, str10, str6);
    }

    /* renamed from: component1, reason: from getter */
    public final String getEquipment() {
        return this.equipment;
    }

    /* renamed from: component2, reason: from getter */
    public final String getLab() {
        return this.lab;
    }

    /* renamed from: component3, reason: from getter */
    public final String getAmount() {
        return this.amount;
    }

    /* renamed from: component4, reason: from getter */
    public final String getDueDate() {
        return this.dueDate;
    }

    /* renamed from: component5, reason: from getter */
    public final String getPaidStatus() {
        return this.paidStatus;
    }

    /* renamed from: component6, reason: from getter */
    public final String getPaidDate() {
        return this.paidDate;
    }

    public final LabDue copy(String equipment, String lab, String amount, String dueDate, String paidStatus, String paidDate) {
        Intrinsics.checkNotNullParameter(equipment, "equipment");
        Intrinsics.checkNotNullParameter(lab, "lab");
        Intrinsics.checkNotNullParameter(amount, "amount");
        Intrinsics.checkNotNullParameter(dueDate, "dueDate");
        Intrinsics.checkNotNullParameter(paidStatus, "paidStatus");
        Intrinsics.checkNotNullParameter(paidDate, "paidDate");
        return new LabDue(equipment, lab, amount, dueDate, paidStatus, paidDate);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LabDue)) {
            return false;
        }
        LabDue labDue = (LabDue) other;
        return Intrinsics.areEqual(this.equipment, labDue.equipment) && Intrinsics.areEqual(this.lab, labDue.lab) && Intrinsics.areEqual(this.amount, labDue.amount) && Intrinsics.areEqual(this.dueDate, labDue.dueDate) && Intrinsics.areEqual(this.paidStatus, labDue.paidStatus) && Intrinsics.areEqual(this.paidDate, labDue.paidDate);
    }

    public int hashCode() {
        return (((((((((this.equipment.hashCode() * 31) + this.lab.hashCode()) * 31) + this.amount.hashCode()) * 31) + this.dueDate.hashCode()) * 31) + this.paidStatus.hashCode()) * 31) + this.paidDate.hashCode();
    }

    public String toString() {
        return "LabDue(equipment=" + this.equipment + ", lab=" + this.lab + ", amount=" + this.amount + ", dueDate=" + this.dueDate + ", paidStatus=" + this.paidStatus + ", paidDate=" + this.paidDate + ")";
    }

    public LabDue(String equipment, String lab, String amount, String dueDate, String paidStatus, String paidDate) {
        Intrinsics.checkNotNullParameter(equipment, "equipment");
        Intrinsics.checkNotNullParameter(lab, "lab");
        Intrinsics.checkNotNullParameter(amount, "amount");
        Intrinsics.checkNotNullParameter(dueDate, "dueDate");
        Intrinsics.checkNotNullParameter(paidStatus, "paidStatus");
        Intrinsics.checkNotNullParameter(paidDate, "paidDate");
        this.equipment = equipment;
        this.lab = lab;
        this.amount = amount;
        this.dueDate = dueDate;
        this.paidStatus = paidStatus;
        this.paidDate = paidDate;
    }

    public final String getEquipment() {
        return this.equipment;
    }

    public final String getLab() {
        return this.lab;
    }

    public final String getAmount() {
        return this.amount;
    }

    public final String getDueDate() {
        return this.dueDate;
    }

    public final String getPaidStatus() {
        return this.paidStatus;
    }

    public final String getPaidDate() {
        return this.paidDate;
    }
}