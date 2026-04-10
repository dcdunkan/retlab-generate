package in.etuwa.app.data.model.calendar;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Calendar.kt */
/* loaded from: classes3.dex */
public final /* data */ class Calendar {

    @SerializedName("date")
    @Expose
    private final String date;

    @SerializedName("subject")
    @Expose
    private final String subject;

    public static /* synthetic */ Calendar copy$default(Calendar calendar, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = calendar.date;
        }
        if ((i & 2) != 0) {
            str2 = calendar.subject;
        }
        return calendar.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    /* renamed from: component2, reason: from getter */
    public final String getSubject() {
        return this.subject;
    }

    public final Calendar copy(String date, String subject) {
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(subject, "subject");
        return new Calendar(date, subject);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Calendar)) {
            return false;
        }
        Calendar calendar = (Calendar) other;
        return Intrinsics.areEqual(this.date, calendar.date) && Intrinsics.areEqual(this.subject, calendar.subject);
    }

    public int hashCode() {
        return (this.date.hashCode() * 31) + this.subject.hashCode();
    }

    public String toString() {
        return "Calendar(date=" + this.date + ", subject=" + this.subject + ")";
    }

    public Calendar(String date, String subject) {
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(subject, "subject");
        this.date = date;
        this.subject = subject;
    }

    public final String getDate() {
        return this.date;
    }

    public final String getSubject() {
        return this.subject;
    }
}