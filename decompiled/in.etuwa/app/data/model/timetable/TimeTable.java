package in.etuwa.app.data.model.timetable;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.itextpdf.forms.xfdf.XfdfConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TimeTable.kt */
/* loaded from: classes3.dex */
public final /* data */ class TimeTable implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @SerializedName("subject")
    @Expose
    private final String subject;

    @SerializedName("timeperiod")
    @Expose
    private final String timeperiod;

    @SerializedName("type")
    @Expose
    private final String type;

    public static /* synthetic */ TimeTable copy$default(TimeTable timeTable, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = timeTable.subject;
        }
        if ((i & 2) != 0) {
            str2 = timeTable.type;
        }
        if ((i & 4) != 0) {
            str3 = timeTable.timeperiod;
        }
        return timeTable.copy(str, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getSubject() {
        return this.subject;
    }

    /* renamed from: component2, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component3, reason: from getter */
    public final String getTimeperiod() {
        return this.timeperiod;
    }

    public final TimeTable copy(String subject, String type, String timeperiod) {
        return new TimeTable(subject, type, timeperiod);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TimeTable)) {
            return false;
        }
        TimeTable timeTable = (TimeTable) other;
        return Intrinsics.areEqual(this.subject, timeTable.subject) && Intrinsics.areEqual(this.type, timeTable.type) && Intrinsics.areEqual(this.timeperiod, timeTable.timeperiod);
    }

    public int hashCode() {
        String str = this.subject;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.type;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.timeperiod;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "TimeTable(subject=" + this.subject + ", type=" + this.type + ", timeperiod=" + this.timeperiod + ")";
    }

    public TimeTable(String str, String str2, String str3) {
        this.subject = str;
        this.type = str2;
        this.timeperiod = str3;
    }

    public final String getSubject() {
        return this.subject;
    }

    public final String getType() {
        return this.type;
    }

    public final String getTimeperiod() {
        return this.timeperiod;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TimeTable(Parcel parcel) {
        this(parcel.readString(), parcel.readString(), parcel.readString());
        Intrinsics.checkNotNullParameter(parcel, "parcel");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.subject);
        parcel.writeString(this.type);
        parcel.writeString(this.timeperiod);
    }

    /* compiled from: TimeTable.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lin/etuwa/app/data/model/timetable/TimeTable$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lin/etuwa/app/data/model/timetable/TimeTable;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lin/etuwa/app/data/model/timetable/TimeTable;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* renamed from: in.etuwa.app.data.model.timetable.TimeTable$CREATOR, reason: from kotlin metadata */
    public static final class Companion implements Parcelable.Creator<TimeTable> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TimeTable createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new TimeTable(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TimeTable[] newArray(int size) {
            return new TimeTable[size];
        }
    }
}