package in.etuwa.app.data.repository;

import in.etuwa.app.data.model.Semester;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.materials.MaterialRequest;
import in.etuwa.app.data.model.onlineclass.OnlineClassResponse;
import in.etuwa.app.data.model.video.VideoResponse;
import in.etuwa.app.data.network.ApiHelper;
import io.reactivex.Single;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VideoClassRepository.kt */
/* loaded from: classes3.dex */
public final class VideoClassRepository {
    private final ApiHelper apiHelper;

    public VideoClassRepository(ApiHelper apiHelper) {
        Intrinsics.checkNotNullParameter(apiHelper, "apiHelper");
        this.apiHelper = apiHelper;
    }

    public final Single<ArrayList<Semester>> getSemestersApiCall() {
        return this.apiHelper.getSemestersApiCall();
    }

    public final Single<OnlineClassResponse> getOnlineClassApiCall() {
        return this.apiHelper.getOnlineClassApiCall();
    }

    public final Single<VideoResponse> getVideoClassApiCall(MaterialRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return this.apiHelper.getVideoClassApiCall(request);
    }

    public final Single<SuccessResponse> getWatchVideoApiCall(String videoId, String youtubeId) {
        Intrinsics.checkNotNullParameter(videoId, "videoId");
        Intrinsics.checkNotNullParameter(youtubeId, "youtubeId");
        return this.apiHelper.getWatchVideoApiCall(videoId, youtubeId);
    }
}