package in.etuwa.app.ui.dashboard.dashtable;

import android.os.Parcel;
import android.os.Parcelable;
import com.itextpdf.forms.xfdf.XfdfConstants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TimeTableMonthlyNewResponse.kt */
/* JADX INFO: loaded from: classes4.dex */
public final /* data */ class PeriodsNew implements Parcelable {
    public static final Parcelable.Creator<PeriodsNew> CREATOR = new Creator();
    private final String attendance_status;
    private final ArrayList<String> covered_topics;
    private final String date;
    private final String day;
    private final String dutyleave_status;
    private final int hour;
    private final String subject;
    private final String timeperiod;
    private final String type;

    /* JADX INFO: compiled from: TimeTableMonthlyNewResponse.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PeriodsNew> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PeriodsNew createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PeriodsNew(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.createStringArrayList());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PeriodsNew[] newArray(int i) {
            return new PeriodsNew[i];
        }
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDay() {
        return this.day;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getHour() {
        return this.hour;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getSubject() {
        return this.subject;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getTimeperiod() {
        return this.timeperiod;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getAttendance_status() {
        return this.attendance_status;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getDutyleave_status() {
        return this.dutyleave_status;
    }

    public final ArrayList<String> component9() {
        return this.covered_topics;
    }

    public final PeriodsNew copy(String date, String day, int hour, String type, String subject, String timeperiod, String attendance_status, String dutyleave_status, ArrayList<String> covered_topics) {
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(day, "day");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(subject, "subject");
        Intrinsics.checkNotNullParameter(timeperiod, "timeperiod");
        Intrinsics.checkNotNullParameter(attendance_status, "attendance_status");
        Intrinsics.checkNotNullParameter(dutyleave_status, "dutyleave_status");
        Intrinsics.checkNotNullParameter(covered_topics, "covered_topics");
        return new PeriodsNew(date, day, hour, type, subject, timeperiod, attendance_status, dutyleave_status, covered_topics);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PeriodsNew)) {
            return false;
        }
        PeriodsNew periodsNew = (PeriodsNew) other;
        return Intrinsics.areEqual(this.date, periodsNew.date) && Intrinsics.areEqual(this.day, periodsNew.day) && this.hour == periodsNew.hour && Intrinsics.areEqual(this.type, periodsNew.type) && Intrinsics.areEqual(this.subject, periodsNew.subject) && Intrinsics.areEqual(this.timeperiod, periodsNew.timeperiod) && Intrinsics.areEqual(this.attendance_status, periodsNew.attendance_status) && Intrinsics.areEqual(this.dutyleave_status, periodsNew.dutyleave_status) && Intrinsics.areEqual(this.covered_topics, periodsNew.covered_topics);
    }

    public int hashCode() {
        return (((((((((((((((this.date.hashCode() * 31) + this.day.hashCode()) * 31) + this.hour) * 31) + this.type.hashCode()) * 31) + this.subject.hashCode()) * 31) + this.timeperiod.hashCode()) * 31) + this.attendance_status.hashCode()) * 31) + this.dutyleave_status.hashCode()) * 31) + this.covered_topics.hashCode();
    }

    public String toString() {
        return "PeriodsNew(date=" + this.date + ", day=" + this.day + ", hour=" + this.hour + ", type=" + this.type + ", subject=" + this.subject + ", timeperiod=" + this.timeperiod + ", attendance_status=" + this.attendance_status + ", dutyleave_status=" + this.dutyleave_status + ", covered_topics=" + this.covered_topics + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.date);
        parcel.writeString(this.day);
        parcel.writeInt(this.hour);
        parcel.writeString(this.type);
        parcel.writeString(this.subject);
        parcel.writeString(this.timeperiod);
        parcel.writeString(this.attendance_status);
        parcel.writeString(this.dutyleave_status);
        parcel.writeStringList(this.covered_topics);
    }

    public PeriodsNew(String date, String day, int i, String type, String subject, String timeperiod, String attendance_status, String dutyleave_status, ArrayList<String> covered_topics) {
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(day, "day");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(subject, "subject");
        Intrinsics.checkNotNullParameter(timeperiod, "timeperiod");
        Intrinsics.checkNotNullParameter(attendance_status, "attendance_status");
        Intrinsics.checkNotNullParameter(dutyleave_status, "dutyleave_status");
        Intrinsics.checkNotNullParameter(covered_topics, "covered_topics");
        this.date = date;
        this.day = day;
        this.hour = i;
        this.type = type;
        this.subject = subject;
        this.timeperiod = timeperiod;
        this.attendance_status = attendance_status;
        this.dutyleave_status = dutyleave_status;
        this.covered_topics = covered_topics;
    }

    public final String getDate() {
        return this.date;
    }

    public final String getDay() {
        return this.day;
    }

    public final int getHour() {
        return this.hour;
    }

    public final String getType() {
        return this.type;
    }

    public final String getSubject() {
        return this.subject;
    }

    public final String getTimeperiod() {
        return this.timeperiod;
    }

    public final String getAttendance_status() {
        return this.attendance_status;
    }

    public final String getDutyleave_status() {
        return this.dutyleave_status;
    }

    public final ArrayList<String> getCovered_topics() {
        return this.covered_topics;
    }
}