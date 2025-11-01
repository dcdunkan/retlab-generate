package in.etuwa.app.data.model.hostel.asiet;

import in.etuwa.app.ui.examregistration.examsubjects.detaildialog.ExamSubjectDetailDialogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AsietBoarding.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lin/etuwa/app/data/model/hostel/asiet/AsietBoarding;", "", "name", "", "id", ExamSubjectDetailDialogKt.ARG_AMOUNT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAmount", "()Ljava/lang/String;", "getId", "getName", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AsietBoarding {
    private final String amount;
    private final String id;
    private final String name;

    public static /* synthetic */ AsietBoarding copy$default(AsietBoarding asietBoarding, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = asietBoarding.name;
        }
        if ((i & 2) != 0) {
            str2 = asietBoarding.id;
        }
        if ((i & 4) != 0) {
            str3 = asietBoarding.amount;
        }
        return asietBoarding.copy(str, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component2, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component3, reason: from getter */
    public final String getAmount() {
        return this.amount;
    }

    public final AsietBoarding copy(String name, String id, String amount) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(amount, "amount");
        return new AsietBoarding(name, id, amount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AsietBoarding)) {
            return false;
        }
        AsietBoarding asietBoarding = (AsietBoarding) other;
        return Intrinsics.areEqual(this.name, asietBoarding.name) && Intrinsics.areEqual(this.id, asietBoarding.id) && Intrinsics.areEqual(this.amount, asietBoarding.amount);
    }

    public int hashCode() {
        return (((this.name.hashCode() * 31) + this.id.hashCode()) * 31) + this.amount.hashCode();
    }

    public String toString() {
        return "AsietBoarding(name=" + this.name + ", id=" + this.id + ", amount=" + this.amount + ")";
    }

    public AsietBoarding(String name, String id, String amount) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(amount, "amount");
        this.name = name;
        this.id = id;
        this.amount = amount;
    }

    public final String getName() {
        return this.name;
    }

    public final String getId() {
        return this.id;
    }

    public final String getAmount() {
        return this.amount;
    }
}