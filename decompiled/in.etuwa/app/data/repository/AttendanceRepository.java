package in.etuwa.app.data.repository;

import in.etuwa.app.data.model.Semester;
import in.etuwa.app.data.model.attendance.AttendanceDayRequest;
import in.etuwa.app.data.model.attendance.AttendanceDayResponse;
import in.etuwa.app.data.model.attendance.AttendanceNewResponse;
import in.etuwa.app.data.model.attendance.AttendanceRequest;
import in.etuwa.app.data.model.attendance.AttendanceRequestNew;
import in.etuwa.app.data.model.attendance.AttendanceResponse;
import in.etuwa.app.data.network.ApiHelper;
import io.reactivex.Single;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AttendanceRepository.kt */
/* loaded from: classes3.dex */
public final class AttendanceRepository {
    private final ApiHelper apiHelper;

    public AttendanceRepository(ApiHelper apiHelper) {
        Intrinsics.checkNotNullParameter(apiHelper, "apiHelper");
        this.apiHelper = apiHelper;
    }

    public final Single<ArrayList<Semester>> getSemestersApiCall() {
        return this.apiHelper.getSemestersApiCall();
    }

    public final Single<AttendanceResponse> getAttendanceBySubjectApiCall(AttendanceRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return this.apiHelper.getAttendanceBySubjectApiCall(request);
    }

    public final Single<AttendanceNewResponse> getAttendanceByDayNewApiCall(AttendanceRequestNew request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return this.apiHelper.getAttendanceByDayNewApiCall(request);
    }

    public final Single<AttendanceDayResponse> getAttendanceByDayApiCall(AttendanceDayRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return this.apiHelper.getAttendanceByDayApiCall(request);
    }
}