package in.etuwa.app.data.model.timetable.newtimetable;

import android.os.Parcel;
import android.os.Parcelable;
import com.itextpdf.forms.xfdf.XfdfConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TimeTableNew.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class TimeTableSub implements Parcelable {

    /* JADX INFO: renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String attendance_status;
    private final String covered_topics;
    private final String date;
    private final String day;
    private final int hour;
    private final String subject;
    private final String timeperiod;
    private final String type;

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
    public final String getCovered_topics() {
        return this.covered_topics;
    }

    public final TimeTableSub copy(String date, String day, int hour, String type, String subject, String timeperiod, String attendance_status, String covered_topics) {
        return new TimeTableSub(date, day, hour, type, subject, timeperiod, attendance_status, covered_topics);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TimeTableSub)) {
            return false;
        }
        TimeTableSub timeTableSub = (TimeTableSub) other;
        return Intrinsics.areEqual(this.date, timeTableSub.date) && Intrinsics.areEqual(this.day, timeTableSub.day) && this.hour == timeTableSub.hour && Intrinsics.areEqual(this.type, timeTableSub.type) && Intrinsics.areEqual(this.subject, timeTableSub.subject) && Intrinsics.areEqual(this.timeperiod, timeTableSub.timeperiod) && Intrinsics.areEqual(this.attendance_status, timeTableSub.attendance_status) && Intrinsics.areEqual(this.covered_topics, timeTableSub.covered_topics);
    }

    public int hashCode() {
        String str = this.date;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.day;
        int iHashCode2 = (((iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + this.hour) * 31;
        String str3 = this.type;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.subject;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.timeperiod;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.attendance_status;
        int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.covered_topics;
        return iHashCode6 + (str7 != null ? str7.hashCode() : 0);
    }

    public String toString() {
        return "TimeTableSub(date=" + this.date + ", day=" + this.day + ", hour=" + this.hour + ", type=" + this.type + ", subject=" + this.subject + ", timeperiod=" + this.timeperiod + ", attendance_status=" + this.attendance_status + ", covered_topics=" + this.covered_topics + ")";
    }

    public TimeTableSub(String str, String str2, int i, String str3, String str4, String str5, String str6, String str7) {
        this.date = str;
        this.day = str2;
        this.hour = i;
        this.type = str3;
        this.subject = str4;
        this.timeperiod = str5;
        this.attendance_status = str6;
        this.covered_topics = str7;
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

    public final String getCovered_topics() {
        return this.covered_topics;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TimeTableSub(Parcel parcel) {
        this(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        Intrinsics.checkNotNullParameter(parcel, "parcel");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.type);
        parcel.writeString(this.day);
        parcel.writeInt(this.hour);
        parcel.writeString(this.type);
        parcel.writeString(this.subject);
        parcel.writeString(this.timeperiod);
        parcel.writeString(this.attendance_status);
        parcel.writeString(this.covered_topics);
    }

    /* JADX INFO: renamed from: in.etuwa.app.data.model.timetable.newtimetable.TimeTableSub$CREATOR, reason: from kotlin metadata */
    /* JADX INFO: compiled from: TimeTableNew.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0017J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lin/etuwa/app/data/model/timetable/newtimetable/TimeTableSub$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lin/etuwa/app/data/model/timetable/newtimetable/TimeTableSub;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lin/etuwa/app/data/model/timetable/newtimetable/TimeTableSub;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion implements Parcelable.Creator<TimeTableSub> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TimeTableSub createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new TimeTableSub(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TimeTableSub[] newArray(int size) {
            return new TimeTableSub[size];
        }
    }
}