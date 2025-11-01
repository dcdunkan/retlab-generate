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
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tJ\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00062\u0006\u0010\b\u001a\u00020\fJ\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00062\u0006\u0010\b\u001a\u00020\u000fJ\u001c\u0010\u0010\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u00130\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lin/etuwa/app/data/repository/AttendanceRepository;", "", "apiHelper", "Lin/etuwa/app/data/network/ApiHelper;", "(Lin/etuwa/app/data/network/ApiHelper;)V", "getAttendanceByDayApiCall", "Lio/reactivex/Single;", "Lin/etuwa/app/data/model/attendance/AttendanceDayResponse;", "request", "Lin/etuwa/app/data/model/attendance/AttendanceDayRequest;", "getAttendanceByDayNewApiCall", "Lin/etuwa/app/data/model/attendance/AttendanceNewResponse;", "Lin/etuwa/app/data/model/attendance/AttendanceRequestNew;", "getAttendanceBySubjectApiCall", "Lin/etuwa/app/data/model/attendance/AttendanceResponse;", "Lin/etuwa/app/data/model/attendance/AttendanceRequest;", "getSemestersApiCall", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/Semester;", "Lkotlin/collections/ArrayList;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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