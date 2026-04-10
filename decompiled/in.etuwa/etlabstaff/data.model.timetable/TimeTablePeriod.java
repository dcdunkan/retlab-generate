package in.etuwa.etlabstaff.data.model.timetable;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.app.NotificationCompat;
import com.itextpdf.forms.xfdf.XfdfConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TimeTablePeriod.kt */
/* JADX INFO: loaded from: classes5.dex */
public final /* data */ class TimeTablePeriod implements Parcelable {
    public static final Parcelable.Creator<TimeTablePeriod> CREATOR = new Creator();
    private final String attendance_status;
    private final String batch;
    private final String batch_id;
    private final String date;
    private final String dutyleave_status;
    private final String link;
    private final Boolean status;
    private final String sub_id;
    private final String subject;
    private final String timeperiod;
    private final String type;

    /* JADX INFO: compiled from: TimeTablePeriod.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<TimeTablePeriod> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TimeTablePeriod createFromParcel(Parcel parcel) {
            Boolean boolValueOf;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            String string3 = parcel.readString();
            String string4 = parcel.readString();
            String string5 = parcel.readString();
            String string6 = parcel.readString();
            String string7 = parcel.readString();
            String string8 = parcel.readString();
            if (parcel.readInt() == 0) {
                boolValueOf = null;
            } else {
                boolValueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new TimeTablePeriod(string, string2, string3, string4, string5, string6, string7, string8, boolValueOf, parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TimeTablePeriod[] newArray(int i) {
            return new TimeTablePeriod[i];
        }
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getAttendance_status() {
        return this.attendance_status;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getDutyleave_status() {
        return this.dutyleave_status;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSubject() {
        return this.subject;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getBatch() {
        return this.batch;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getTimeperiod() {
        return this.timeperiod;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getLink() {
        return this.link;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getSub_id() {
        return this.sub_id;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getBatch_id() {
        return this.batch_id;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Boolean getStatus() {
        return this.status;
    }

    public final TimeTablePeriod copy(String type, String subject, String batch, String timeperiod, String link, String sub_id, String batch_id, String date, Boolean status, String attendance_status, String dutyleave_status) {
        return new TimeTablePeriod(type, subject, batch, timeperiod, link, sub_id, batch_id, date, status, attendance_status, dutyleave_status);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TimeTablePeriod)) {
            return false;
        }
        TimeTablePeriod timeTablePeriod = (TimeTablePeriod) other;
        return Intrinsics.areEqual(this.type, timeTablePeriod.type) && Intrinsics.areEqual(this.subject, timeTablePeriod.subject) && Intrinsics.areEqual(this.batch, timeTablePeriod.batch) && Intrinsics.areEqual(this.timeperiod, timeTablePeriod.timeperiod) && Intrinsics.areEqual(this.link, timeTablePeriod.link) && Intrinsics.areEqual(this.sub_id, timeTablePeriod.sub_id) && Intrinsics.areEqual(this.batch_id, timeTablePeriod.batch_id) && Intrinsics.areEqual(this.date, timeTablePeriod.date) && Intrinsics.areEqual(this.status, timeTablePeriod.status) && Intrinsics.areEqual(this.attendance_status, timeTablePeriod.attendance_status) && Intrinsics.areEqual(this.dutyleave_status, timeTablePeriod.dutyleave_status);
    }

    public int hashCode() {
        String str = this.type;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.subject;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.batch;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.timeperiod;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.link;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.sub_id;
        int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.batch_id;
        int iHashCode7 = (iHashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.date;
        int iHashCode8 = (iHashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        Boolean bool = this.status;
        int iHashCode9 = (iHashCode8 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str9 = this.attendance_status;
        int iHashCode10 = (iHashCode9 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.dutyleave_status;
        return iHashCode10 + (str10 != null ? str10.hashCode() : 0);
    }

    public String toString() {
        return "TimeTablePeriod(type=" + this.type + ", subject=" + this.subject + ", batch=" + this.batch + ", timeperiod=" + this.timeperiod + ", link=" + this.link + ", sub_id=" + this.sub_id + ", batch_id=" + this.batch_id + ", date=" + this.date + ", status=" + this.status + ", attendance_status=" + this.attendance_status + ", dutyleave_status=" + this.dutyleave_status + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.os.Parcel, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v12, types: [int] */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        ?? BooleanValue;
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.type);
        parcel.writeString(this.subject);
        parcel.writeString(this.batch);
        parcel.writeString(this.timeperiod);
        parcel.writeString(this.link);
        parcel.writeString(this.sub_id);
        parcel.writeString(this.batch_id);
        parcel.writeString(this.date);
        Boolean bool = this.status;
        if (bool == null) {
            BooleanValue = 0;
        } else {
            parcel.writeInt(1);
            BooleanValue = bool.booleanValue();
        }
        parcel.writeInt(BooleanValue);
        parcel.writeString(this.attendance_status);
        parcel.writeString(this.dutyleave_status);
    }

    public TimeTablePeriod(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Boolean bool, String str9, String str10) {
        this.type = str;
        this.subject = str2;
        this.batch = str3;
        this.timeperiod = str4;
        this.link = str5;
        this.sub_id = str6;
        this.batch_id = str7;
        this.date = str8;
        this.status = bool;
        this.attendance_status = str9;
        this.dutyleave_status = str10;
    }

    public final String getType() {
        return this.type;
    }

    public final String getSubject() {
        return this.subject;
    }

    public final String getBatch() {
        return this.batch;
    }

    public final String getTimeperiod() {
        return this.timeperiod;
    }

    public final String getLink() {
        return this.link;
    }

    public final String getSub_id() {
        return this.sub_id;
    }

    public final String getBatch_id() {
        return this.batch_id;
    }

    public final String getDate() {
        return this.date;
    }

    public final Boolean getStatus() {
        return this.status;
    }

    public final String getAttendance_status() {
        return this.attendance_status;
    }

    public final String getDutyleave_status() {
        return this.dutyleave_status;
    }
}