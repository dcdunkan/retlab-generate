package in.etuwa.app.data.model.hostel.asiet;

import in.etuwa.app.ui.examregistration.examsubjects.detaildialog.ExamSubjectDetailDialogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AsietBoarding.kt */
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