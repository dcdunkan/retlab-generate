package in.etuwa.app.data.model.fee;

import com.google.gson.annotations.SerializedName;
import in.etuwa.app.ui.examregistration.examsubjects.detaildialog.ExamSubjectDetailDialogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FeeGroups.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class FeeGroups {
    private final String amount;
    private final String balance;

    @SerializedName("feegroup_id")
    private final String feeGroupId;

    @SerializedName("feeheadgroup_id")
    private final String feeHeadGroupId;

    @SerializedName("fee_head_id")
    private final String feeHeadId;

    @SerializedName("feetype_id")
    private final String feeTypeId;
    private final String name;
    private final String paid;
    private final String scholarship;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getFeeHeadId() {
        return this.feeHeadId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getFeeHeadGroupId() {
        return this.feeHeadGroupId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getFeeGroupId() {
        return this.feeGroupId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getFeeTypeId() {
        return this.feeTypeId;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getAmount() {
        return this.amount;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getScholarship() {
        return this.scholarship;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getPaid() {
        return this.paid;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getBalance() {
        return this.balance;
    }

    public final FeeGroups copy(String feeHeadId, String feeHeadGroupId, String feeGroupId, String feeTypeId, String name, String amount, String scholarship, String paid, String balance) {
        Intrinsics.checkNotNullParameter(feeHeadId, "feeHeadId");
        Intrinsics.checkNotNullParameter(feeHeadGroupId, "feeHeadGroupId");
        Intrinsics.checkNotNullParameter(feeGroupId, "feeGroupId");
        Intrinsics.checkNotNullParameter(feeTypeId, "feeTypeId");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(amount, "amount");
        Intrinsics.checkNotNullParameter(scholarship, "scholarship");
        Intrinsics.checkNotNullParameter(paid, "paid");
        Intrinsics.checkNotNullParameter(balance, "balance");
        return new FeeGroups(feeHeadId, feeHeadGroupId, feeGroupId, feeTypeId, name, amount, scholarship, paid, balance);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FeeGroups)) {
            return false;
        }
        FeeGroups feeGroups = (FeeGroups) other;
        return Intrinsics.areEqual(this.feeHeadId, feeGroups.feeHeadId) && Intrinsics.areEqual(this.feeHeadGroupId, feeGroups.feeHeadGroupId) && Intrinsics.areEqual(this.feeGroupId, feeGroups.feeGroupId) && Intrinsics.areEqual(this.feeTypeId, feeGroups.feeTypeId) && Intrinsics.areEqual(this.name, feeGroups.name) && Intrinsics.areEqual(this.amount, feeGroups.amount) && Intrinsics.areEqual(this.scholarship, feeGroups.scholarship) && Intrinsics.areEqual(this.paid, feeGroups.paid) && Intrinsics.areEqual(this.balance, feeGroups.balance);
    }

    public int hashCode() {
        return (((((((((((((((this.feeHeadId.hashCode() * 31) + this.feeHeadGroupId.hashCode()) * 31) + this.feeGroupId.hashCode()) * 31) + this.feeTypeId.hashCode()) * 31) + this.name.hashCode()) * 31) + this.amount.hashCode()) * 31) + this.scholarship.hashCode()) * 31) + this.paid.hashCode()) * 31) + this.balance.hashCode();
    }

    public String toString() {
        return "FeeGroups(feeHeadId=" + this.feeHeadId + ", feeHeadGroupId=" + this.feeHeadGroupId + ", feeGroupId=" + this.feeGroupId + ", feeTypeId=" + this.feeTypeId + ", name=" + this.name + ", amount=" + this.amount + ", scholarship=" + this.scholarship + ", paid=" + this.paid + ", balance=" + this.balance + ")";
    }

    public FeeGroups(String feeHeadId, String feeHeadGroupId, String feeGroupId, String feeTypeId, String name, String amount, String scholarship, String paid, String balance) {
        Intrinsics.checkNotNullParameter(feeHeadId, "feeHeadId");
        Intrinsics.checkNotNullParameter(feeHeadGroupId, "feeHeadGroupId");
        Intrinsics.checkNotNullParameter(feeGroupId, "feeGroupId");
        Intrinsics.checkNotNullParameter(feeTypeId, "feeTypeId");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(amount, "amount");
        Intrinsics.checkNotNullParameter(scholarship, "scholarship");
        Intrinsics.checkNotNullParameter(paid, "paid");
        Intrinsics.checkNotNullParameter(balance, "balance");
        this.feeHeadId = feeHeadId;
        this.feeHeadGroupId = feeHeadGroupId;
        this.feeGroupId = feeGroupId;
        this.feeTypeId = feeTypeId;
        this.name = name;
        this.amount = amount;
        this.scholarship = scholarship;
        this.paid = paid;
        this.balance = balance;
    }

    public final String getFeeHeadId() {
        return this.feeHeadId;
    }

    public final String getFeeHeadGroupId() {
        return this.feeHeadGroupId;
    }

    public final String getFeeGroupId() {
        return this.feeGroupId;
    }

    public final String getFeeTypeId() {
        return this.feeTypeId;
    }

    public final String getName() {
        return this.name;
    }

    public final String getAmount() {
        return this.amount;
    }

    public final String getScholarship() {
        return this.scholarship;
    }

    public final String getPaid() {
        return this.paid;
    }

    public final String getBalance() {
        return this.balance;
    }
}