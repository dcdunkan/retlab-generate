package in.etuwa.app.data.model.calendar;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CalendarResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class Birthday {
    private final String day;
    private final String dob;
    private final String month;
    private final String name;

    public static /* synthetic */ Birthday copy$default(Birthday birthday, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = birthday.name;
        }
        if ((i & 2) != 0) {
            str2 = birthday.dob;
        }
        if ((i & 4) != 0) {
            str3 = birthday.day;
        }
        if ((i & 8) != 0) {
            str4 = birthday.month;
        }
        return birthday.copy(str, str2, str3, str4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDob() {
        return this.dob;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDay() {
        return this.day;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getMonth() {
        return this.month;
    }

    public final Birthday copy(String name, String dob, String day, String month) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(dob, "dob");
        Intrinsics.checkNotNullParameter(day, "day");
        Intrinsics.checkNotNullParameter(month, "month");
        return new Birthday(name, dob, day, month);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Birthday)) {
            return false;
        }
        Birthday birthday = (Birthday) other;
        return Intrinsics.areEqual(this.name, birthday.name) && Intrinsics.areEqual(this.dob, birthday.dob) && Intrinsics.areEqual(this.day, birthday.day) && Intrinsics.areEqual(this.month, birthday.month);
    }

    public int hashCode() {
        return (((((this.name.hashCode() * 31) + this.dob.hashCode()) * 31) + this.day.hashCode()) * 31) + this.month.hashCode();
    }

    public String toString() {
        return "Birthday(name=" + this.name + ", dob=" + this.dob + ", day=" + this.day + ", month=" + this.month + ")";
    }

    public Birthday(String name, String dob, String day, String month) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(dob, "dob");
        Intrinsics.checkNotNullParameter(day, "day");
        Intrinsics.checkNotNullParameter(month, "month");
        this.name = name;
        this.dob = dob;
        this.day = day;
        this.month = month;
    }

    public final String getName() {
        return this.name;
    }

    public final String getDob() {
        return this.dob;
    }

    public final String getDay() {
        return this.day;
    }

    public final String getMonth() {
        return this.month;
    }
}