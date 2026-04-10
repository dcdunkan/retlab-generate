package in.etuwa.app.data.model.attendance;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AttendanceNewResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AttendanceNewResponse {
    private final ArrayList<AttendanceNew> attends;

    public AttendanceNewResponse(ArrayList<AttendanceNew> attends) {
        Intrinsics.checkNotNullParameter(attends, "attends");
        this.attends = attends;
    }

    public final ArrayList<AttendanceNew> getAttends() {
        return this.attends;
    }
}