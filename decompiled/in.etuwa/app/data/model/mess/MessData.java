package in.etuwa.app.data.model.mess;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MessData.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lin/etuwa/app/data/model/mess/MessData;", "", "booking_date", "", "day", "day_id", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBooking_date", "()Ljava/lang/String;", "getDay", "getDay_id", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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

    /* renamed from: component1, reason: from getter */
    public final String getBooking_date() {
        return this.booking_date;
    }

    /* renamed from: component2, reason: from getter */
    public final String getDay() {
        return this.day;
    }

    /* renamed from: component3, reason: from getter */
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