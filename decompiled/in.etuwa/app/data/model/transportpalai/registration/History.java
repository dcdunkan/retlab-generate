package in.etuwa.app.data.model.transportpalai.registration;

import androidx.core.app.NotificationCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: History.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003JE\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001e"}, d2 = {"Lin/etuwa/app/data/model/transportpalai/registration/History;", "", "id", "", "year", "name", FirebaseAnalytics.Param.START_DATE, "reg_date", NotificationCompat.CATEGORY_STATUS, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "getReg_date", "getStart_date", "getStatus", "getYear", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class History {
    private final String id;
    private final String name;
    private final String reg_date;
    private final String start_date;
    private final String status;
    private final String year;

    public static /* synthetic */ History copy$default(History history, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = history.id;
        }
        if ((i & 2) != 0) {
            str2 = history.year;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = history.name;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = history.start_date;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            str5 = history.reg_date;
        }
        String str10 = str5;
        if ((i & 32) != 0) {
            str6 = history.status;
        }
        return history.copy(str, str7, str8, str9, str10, str6);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getYear() {
        return this.year;
    }

    /* renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component4, reason: from getter */
    public final String getStart_date() {
        return this.start_date;
    }

    /* renamed from: component5, reason: from getter */
    public final String getReg_date() {
        return this.reg_date;
    }

    /* renamed from: component6, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    public final History copy(String id, String year, String name, String start_date, String reg_date, String status) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(year, "year");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(start_date, "start_date");
        Intrinsics.checkNotNullParameter(reg_date, "reg_date");
        Intrinsics.checkNotNullParameter(status, "status");
        return new History(id, year, name, start_date, reg_date, status);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof History)) {
            return false;
        }
        History history = (History) other;
        return Intrinsics.areEqual(this.id, history.id) && Intrinsics.areEqual(this.year, history.year) && Intrinsics.areEqual(this.name, history.name) && Intrinsics.areEqual(this.start_date, history.start_date) && Intrinsics.areEqual(this.reg_date, history.reg_date) && Intrinsics.areEqual(this.status, history.status);
    }

    public int hashCode() {
        return (((((((((this.id.hashCode() * 31) + this.year.hashCode()) * 31) + this.name.hashCode()) * 31) + this.start_date.hashCode()) * 31) + this.reg_date.hashCode()) * 31) + this.status.hashCode();
    }

    public String toString() {
        return "History(id=" + this.id + ", year=" + this.year + ", name=" + this.name + ", start_date=" + this.start_date + ", reg_date=" + this.reg_date + ", status=" + this.status + ")";
    }

    public History(String id, String year, String name, String start_date, String reg_date, String status) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(year, "year");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(start_date, "start_date");
        Intrinsics.checkNotNullParameter(reg_date, "reg_date");
        Intrinsics.checkNotNullParameter(status, "status");
        this.id = id;
        this.year = year;
        this.name = name;
        this.start_date = start_date;
        this.reg_date = reg_date;
        this.status = status;
    }

    public final String getId() {
        return this.id;
    }

    public final String getYear() {
        return this.year;
    }

    public final String getName() {
        return this.name;
    }

    public final String getStart_date() {
        return this.start_date;
    }

    public final String getReg_date() {
        return this.reg_date;
    }

    public final String getStatus() {
        return this.status;
    }
}