package in.etuwa.app.data.model.mess;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MessData.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class MessData {
    private final String booking_date;
    private final String day;
    private final String day_id;

    public static /* synthetic */ MessData copy$default(MessData messData, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = messData.booking_date;
        }
        if ((i & 2) != 0) {
            str2 = messData.day;
        }
        if ((i & 4) != 0) {
            str3 = messData.day_id;
        }
        return messData.copy(str, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getBooking_date() {
        return this.booking_date;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDay() {
        return this.day;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDay_id() {
        return this.day_id;
    }

    public final MessData copy(String booking_date, String day, String day_id) {
        Intrinsics.checkNotNullParameter(booking_date, "booking_date");
        Intrinsics.checkNotNullParameter(day, "day");
        Intrinsics.checkNotNullParameter(day_id, "day_id");
        return new MessData(booking_date, day, day_id);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MessData)) {
            return false;
        }
        MessData messData = (MessData) other;
        return Intrinsics.areEqual(this.booking_date, messData.booking_date) && Intrinsics.areEqual(this.day, messData.day) && Intrinsics.areEqual(this.day_id, messData.day_id);
    }

    public int hashCode() {
        return (((this.booking_date.hashCode() * 31) + this.day.hashCode()) * 31) + this.day_id.hashCode();
    }

    public String toString() {
        return "MessData(booking_date=" + this.booking_date + ", day=" + this.day + ", day_id=" + this.day_id + ")";
    }

    public MessData(String booking_date, String day, String day_id) {
        Intrinsics.checkNotNullParameter(booking_date, "booking_date");
        Intrinsics.checkNotNullParameter(day, "day");
        Intrinsics.checkNotNullParameter(day_id, "day_id");
        this.booking_date = booking_date;
        this.day = day;
        this.day_id = day_id;
    }

    public final String getBooking_date() {
        return this.booking_date;
    }

    public final String getDay() {
        return this.day;
    }

    public final String getDay_id() {
        return this.day_id;
    }
}