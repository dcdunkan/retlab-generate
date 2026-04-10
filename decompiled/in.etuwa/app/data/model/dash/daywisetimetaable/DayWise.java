package in.etuwa.app.data.model.dash.daywisetimetaable;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DayWise.kt */
/* loaded from: classes3.dex */
public final /* data */ class DayWise {
    private final String day;
    private final ArrayList<DayWiseTopicName> sub;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DayWise copy$default(DayWise dayWise, String str, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            str = dayWise.day;
        }
        if ((i & 2) != 0) {
            arrayList = dayWise.sub;
        }
        return dayWise.copy(str, arrayList);
    }

    /* renamed from: component1, reason: from getter */
    public final String getDay() {
        return this.day;
    }

    public final ArrayList<DayWiseTopicName> component2() {
        return this.sub;
    }

    public final DayWise copy(String day, ArrayList<DayWiseTopicName> sub) {
        Intrinsics.checkNotNullParameter(day, "day");
        Intrinsics.checkNotNullParameter(sub, "sub");
        return new DayWise(day, sub);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DayWise)) {
            return false;
        }
        DayWise dayWise = (DayWise) other;
        return Intrinsics.areEqual(this.day, dayWise.day) && Intrinsics.areEqual(this.sub, dayWise.sub);
    }

    public int hashCode() {
        return (this.day.hashCode() * 31) + this.sub.hashCode();
    }

    public String toString() {
        return "DayWise(day=" + this.day + ", sub=" + this.sub + ")";
    }

    public DayWise(String day, ArrayList<DayWiseTopicName> sub) {
        Intrinsics.checkNotNullParameter(day, "day");
        Intrinsics.checkNotNullParameter(sub, "sub");
        this.day = day;
        this.sub = sub;
    }

    public final String getDay() {
        return this.day;
    }

    public final ArrayList<DayWiseTopicName> getSub() {
        return this.sub;
    }
}