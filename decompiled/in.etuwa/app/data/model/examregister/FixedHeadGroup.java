package in.etuwa.app.data.model.examregister;

import com.itextpdf.forms.xfdf.XfdfConstants;
import in.etuwa.app.ui.examregistration.examsubjects.detaildialog.ExamSubjectDetailDialogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExamCourseResponse.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003JE\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001e"}, d2 = {"Lin/etuwa/app/data/model/examregister/FixedHeadGroup;", "", "no", "", "fixedHeadGrpId", "", XfdfConstants.HEAD, "type", "is_eligible", ExamSubjectDetailDialogKt.ARG_AMOUNT, "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAmount", "()Ljava/lang/String;", "getFixedHeadGrpId", "getHead", "getNo", "()I", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class FixedHeadGroup {
    private final String amount;
    private final String fixedHeadGrpId;
    private final String head;
    private final String is_eligible;
    private final int no;
    private final String type;

    public static /* synthetic */ FixedHeadGroup copy$default(FixedHeadGroup fixedHeadGroup, int i, String str, String str2, String str3, String str4, String str5, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = fixedHeadGroup.no;
        }
        if ((i2 & 2) != 0) {
            str = fixedHeadGroup.fixedHeadGrpId;
        }
        String str6 = str;
        if ((i2 & 4) != 0) {
            str2 = fixedHeadGroup.head;
        }
        String str7 = str2;
        if ((i2 & 8) != 0) {
            str3 = fixedHeadGroup.type;
        }
        String str8 = str3;
        if ((i2 & 16) != 0) {
            str4 = fixedHeadGroup.is_eligible;
        }
        String str9 = str4;
        if ((i2 & 32) != 0) {
            str5 = fixedHeadGroup.amount;
        }
        return fixedHeadGroup.copy(i, str6, str7, str8, str9, str5);
    }

    /* renamed from: component1, reason: from getter */
    public final int getNo() {
        return this.no;
    }

    /* renamed from: component2, reason: from getter */
    public final String getFixedHeadGrpId() {
        return this.fixedHeadGrpId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getHead() {
        return this.head;
    }

    /* renamed from: component4, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component5, reason: from getter */
    public final String getIs_eligible() {
        return this.is_eligible;
    }

    /* renamed from: component6, reason: from getter */
    public final String getAmount() {
        return this.amount;
    }

    public final FixedHeadGroup copy(int no, String fixedHeadGrpId, String head, String type, String is_eligible, String amount) {
        Intrinsics.checkNotNullParameter(fixedHeadGrpId, "fixedHeadGrpId");
        Intrinsics.checkNotNullParameter(head, "head");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(is_eligible, "is_eligible");
        Intrinsics.checkNotNullParameter(amount, "amount");
        return new FixedHeadGroup(no, fixedHeadGrpId, head, type, is_eligible, amount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FixedHeadGroup)) {
            return false;
        }
        FixedHeadGroup fixedHeadGroup = (FixedHeadGroup) other;
        return this.no == fixedHeadGroup.no && Intrinsics.areEqual(this.fixedHeadGrpId, fixedHeadGroup.fixedHeadGrpId) && Intrinsics.areEqual(this.head, fixedHeadGroup.head) && Intrinsics.areEqual(this.type, fixedHeadGroup.type) && Intrinsics.areEqual(this.is_eligible, fixedHeadGroup.is_eligible) && Intrinsics.areEqual(this.amount, fixedHeadGroup.amount);
    }

    public int hashCode() {
        return (((((((((this.no * 31) + this.fixedHeadGrpId.hashCode()) * 31) + this.head.hashCode()) * 31) + this.type.hashCode()) * 31) + this.is_eligible.hashCode()) * 31) + this.amount.hashCode();
    }

    public String toString() {
        return "FixedHeadGroup(no=" + this.no + ", fixedHeadGrpId=" + this.fixedHeadGrpId + ", head=" + this.head + ", type=" + this.type + ", is_eligible=" + this.is_eligible + ", amount=" + this.amount + ")";
    }

    public FixedHeadGroup(int i, String fixedHeadGrpId, String head, String type, String is_eligible, String amount) {
        Intrinsics.checkNotNullParameter(fixedHeadGrpId, "fixedHeadGrpId");
        Intrinsics.checkNotNullParameter(head, "head");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(is_eligible, "is_eligible");
        Intrinsics.checkNotNullParameter(amount, "amount");
        this.no = i;
        this.fixedHeadGrpId = fixedHeadGrpId;
        this.head = head;
        this.type = type;
        this.is_eligible = is_eligible;
        this.amount = amount;
    }

    public final int getNo() {
        return this.no;
    }

    public final String getFixedHeadGrpId() {
        return this.fixedHeadGrpId;
    }

    public final String getHead() {
        return this.head;
    }

    public final String getType() {
        return this.type;
    }

    public final String is_eligible() {
        return this.is_eligible;
    }

    public final String getAmount() {
        return this.amount;
    }
}