package in.etuwa.app.data.model.attendance;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AttendanceDayResponse.kt */
/* loaded from: classes3.dex */
public final /* data */ class AttendanceDayResponse {
    private final ArrayList<AttendanceDay> attends;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AttendanceDayResponse copy$default(AttendanceDayResponse attendanceDayResponse, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            arrayList = attendanceDayResponse.attends;
        }
        return attendanceDayResponse.copy(arrayList);
    }

    public final ArrayList<AttendanceDay> component1() {
        return this.attends;
    }

    public final AttendanceDayResponse copy(ArrayList<AttendanceDay> attends) {
        Intrinsics.checkNotNullParameter(attends, "attends");
        return new AttendanceDayResponse(attends);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof AttendanceDayResponse) && Intrinsics.areEqual(this.attends, ((AttendanceDayResponse) other).attends);
    }

    public int hashCode() {
        return this.attends.hashCode();
    }

    public String toString() {
        return "AttendanceDayResponse(attends=" + this.attends + ")";
    }

    public AttendanceDayResponse(ArrayList<AttendanceDay> attends) {
        Intrinsics.checkNotNullParameter(attends, "attends");
        this.attends = attends;
    }

    public final ArrayList<AttendanceDay> getAttends() {
        return this.attends;
    }
}