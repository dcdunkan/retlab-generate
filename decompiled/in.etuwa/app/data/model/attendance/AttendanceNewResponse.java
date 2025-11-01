package in.etuwa.app.data.model.attendance;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AttendanceNewResponse.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\u0002\u0010\u0006R!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lin/etuwa/app/data/model/attendance/AttendanceNewResponse;", "", "attends", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/attendance/AttendanceNew;", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;)V", "getAttends", "()Ljava/util/ArrayList;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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