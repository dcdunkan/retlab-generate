package in.etuwa.app.data.model.fee;

import com.google.gson.annotations.SerializedName;
import in.etuwa.app.ui.examregistration.examsubjects.detaildialog.ExamSubjectDetailDialogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FeeGroups.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003Jc\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000e¨\u0006'"}, d2 = {"Lin/etuwa/app/data/model/fee/FeeGroups;", "", "feeHeadId", "", "feeHeadGroupId", "feeGroupId", "feeTypeId", "name", ExamSubjectDetailDialogKt.ARG_AMOUNT, "scholarship", "paid", "balance", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAmount", "()Ljava/lang/String;", "getBalance", "getFeeGroupId", "getFeeHeadGroupId", "getFeeHeadId", "getFeeTypeId", "getName", "getPaid", "getScholarship", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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

    /* renamed from: component1, reason: from getter */
    public final String getFeeHeadId() {
        return this.feeHeadId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getFeeHeadGroupId() {
        return this.feeHeadGroupId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getFeeGroupId() {
        return this.feeGroupId;
    }

    /* renamed from: component4, reason: from getter */
    public final String getFeeTypeId() {
        return this.feeTypeId;
    }

    /* renamed from: component5, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component6, reason: from getter */
    public final String getAmount() {
        return this.amount;
    }

    /* renamed from: component7, reason: from getter */
    public final String getScholarship() {
        return this.scholarship;
    }

    /* renamed from: component8, reason: from getter */
    public final String getPaid() {
        return this.paid;
    }

    /* renamed from: component9, reason: from getter */
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