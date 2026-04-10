package in.etuwa.app.ui.dashboard.dashtable;

import android.os.Parcel;
import android.os.Parcelable;
import com.itextpdf.forms.xfdf.XfdfConstants;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TimeTableMonthlyNewResponse.kt */
/* JADX INFO: loaded from: classes4.dex */
public final /* data */ class TimeTableNewResponse implements Parcelable {
    public static final Parcelable.Creator<TimeTableNewResponse> CREATOR = new Creator();
    private final String date;
    private final String day;
    private final ArrayList<PeriodsNew> sub;

    /* JADX INFO: compiled from: TimeTableMonthlyNewResponse.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<TimeTableNewResponse> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TimeTableNewResponse createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 != i; i2++) {
                arrayList.add(PeriodsNew.CREATOR.createFromParcel(parcel));
            }
            return new TimeTableNewResponse(string, string2, arrayList);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TimeTableNewResponse[] newArray(int i) {
            return new TimeTableNewResponse[i];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TimeTableNewResponse copy$default(TimeTableNewResponse timeTableNewResponse, String str, String str2, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            str = timeTableNewResponse.date;
        }
        if ((i & 2) != 0) {
            str2 = timeTableNewResponse.day;
        }
        if ((i & 4) != 0) {
            arrayList = timeTableNewResponse.sub;
        }
        return timeTableNewResponse.copy(str, str2, arrayList);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDay() {
        return this.day;
    }

    public final ArrayList<PeriodsNew> component3() {
        return this.sub;
    }

    public final TimeTableNewResponse copy(String date, String day, ArrayList<PeriodsNew> sub) {
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(day, "day");
        Intrinsics.checkNotNullParameter(sub, "sub");
        return new TimeTableNewResponse(date, day, sub);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TimeTableNewResponse)) {
            return false;
        }
        TimeTableNewResponse timeTableNewResponse = (TimeTableNewResponse) other;
        return Intrinsics.areEqual(this.date, timeTableNewResponse.date) && Intrinsics.areEqual(this.day, timeTableNewResponse.day) && Intrinsics.areEqual(this.sub, timeTableNewResponse.sub);
    }

    public int hashCode() {
        return (((this.date.hashCode() * 31) + this.day.hashCode()) * 31) + this.sub.hashCode();
    }

    public String toString() {
        return "TimeTableNewResponse(date=" + this.date + ", day=" + this.day + ", sub=" + this.sub + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.date);
        parcel.writeString(this.day);
        ArrayList<PeriodsNew> arrayList = this.sub;
        parcel.writeInt(arrayList.size());
        Iterator<PeriodsNew> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(parcel, flags);
        }
    }

    public TimeTableNewResponse(String date, String day, ArrayList<PeriodsNew> sub) {
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(day, "day");
        Intrinsics.checkNotNullParameter(sub, "sub");
        this.date = date;
        this.day = day;
        this.sub = sub;
    }

    public final String getDate() {
        return this.date;
    }

    public final String getDay() {
        return this.day;
    }

    public final ArrayList<PeriodsNew> getSub() {
        return this.sub;
    }
}