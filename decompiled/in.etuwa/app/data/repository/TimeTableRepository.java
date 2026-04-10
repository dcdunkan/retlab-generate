package in.etuwa.app.data.repository;

import in.etuwa.app.data.model.timetable.change.ChangeTimeTableResponse;
import in.etuwa.app.data.model.timetable.special.SpecialResponse;
import in.etuwa.app.data.network.ApiHelper;
import io.reactivex.Single;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TimeTableRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class TimeTableRepository {
    private final ApiHelper apiHelper;

    public TimeTableRepository(ApiHelper apiHelper) {
        Intrinsics.checkNotNullParameter(apiHelper, "apiHelper");
        this.apiHelper = apiHelper;
    }

    public final Single<ArrayList<ChangeTimeTableResponse>> getChangeInTimetableApiCall() {
        return this.apiHelper.getChangeInTimetableApiCall();
    }

    public final Single<ArrayList<SpecialResponse>> getSpecialClassApiCall() {
        return this.apiHelper.getSpecialClassApiCall();
    }
}