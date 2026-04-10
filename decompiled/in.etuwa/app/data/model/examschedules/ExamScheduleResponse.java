package in.etuwa.app.data.model.examschedules;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExamScheduleResponse.kt */
/* loaded from: classes3.dex */
public final /* data */ class ExamScheduleResponse {
    private final ArrayList<ExamSchedule> schedules;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ExamScheduleResponse copy$default(ExamScheduleResponse examScheduleResponse, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            arrayList = examScheduleResponse.schedules;
        }
        return examScheduleResponse.copy(arrayList);
    }

    public final ArrayList<ExamSchedule> component1() {
        return this.schedules;
    }

    public final ExamScheduleResponse copy(ArrayList<ExamSchedule> schedules) {
        Intrinsics.checkNotNullParameter(schedules, "schedules");
        return new ExamScheduleResponse(schedules);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ExamScheduleResponse) && Intrinsics.areEqual(this.schedules, ((ExamScheduleResponse) other).schedules);
    }

    public int hashCode() {
        return this.schedules.hashCode();
    }

    public String toString() {
        return "ExamScheduleResponse(schedules=" + this.schedules + ")";
    }

    public ExamScheduleResponse(ArrayList<ExamSchedule> schedules) {
        Intrinsics.checkNotNullParameter(schedules, "schedules");
        this.schedules = schedules;
    }

    public final ArrayList<ExamSchedule> getSchedules() {
        return this.schedules;
    }
}