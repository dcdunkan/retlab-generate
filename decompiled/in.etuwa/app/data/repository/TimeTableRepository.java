package in.etuwa.app.data.repository;

import in.etuwa.app.data.model.timetable.TimetableResponse;
import in.etuwa.app.data.model.timetable.change.ChangeTimeTableResponse;
import in.etuwa.app.data.model.timetable.special.SpecialResponse;
import in.etuwa.app.data.network.ApiHelper;
import io.reactivex.Single;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TimeTableRepository.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t0\u0006J\u001c\u0010\n\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000b0\u0007j\b\u0012\u0004\u0012\u00020\u000b`\t0\u0006J\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lin/etuwa/app/data/repository/TimeTableRepository;", "", "apiHelper", "Lin/etuwa/app/data/network/ApiHelper;", "(Lin/etuwa/app/data/network/ApiHelper;)V", "getChangeInTimetableApiCall", "Lio/reactivex/Single;", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/timetable/change/ChangeTimeTableResponse;", "Lkotlin/collections/ArrayList;", "getSpecialClassApiCall", "Lin/etuwa/app/data/model/timetable/special/SpecialResponse;", "getTimetableApiCall", "Lin/etuwa/app/data/model/timetable/TimetableResponse;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TimeTableRepository {
    private final ApiHelper apiHelper;

    public TimeTableRepository(ApiHelper apiHelper) {
        Intrinsics.checkNotNullParameter(apiHelper, "apiHelper");
        this.apiHelper = apiHelper;
    }

    public final Single<TimetableResponse> getTimetableApiCall() {
        return this.apiHelper.getTimetableApiCall();
    }

    public final Single<ArrayList<ChangeTimeTableResponse>> getChangeInTimetableApiCall() {
        return this.apiHelper.getChangeInTimetableApiCall();
    }

    public final Single<ArrayList<SpecialResponse>> getSpecialClassApiCall() {
        return this.apiHelper.getSpecialClassApiCall();
    }
}