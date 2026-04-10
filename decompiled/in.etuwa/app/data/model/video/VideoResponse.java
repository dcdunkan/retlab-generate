package in.etuwa.app.data.model.video;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VideoResponse.kt */
/* loaded from: classes3.dex */
public final /* data */ class VideoResponse {

    @SerializedName(Constants.IPC_BUNDLE_KEY_SEND_ERROR)
    @Expose
    private final String error;

    @SerializedName(FirebaseAnalytics.Event.LOGIN)
    @Expose
    private final boolean login;

    @SerializedName("videos")
    @Expose
    private final ArrayList<Videos> videos;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ VideoResponse copy$default(VideoResponse videoResponse, boolean z, ArrayList arrayList, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = videoResponse.login;
        }
        if ((i & 2) != 0) {
            arrayList = videoResponse.videos;
        }
        if ((i & 4) != 0) {
            str = videoResponse.error;
        }
        return videoResponse.copy(z, arrayList, str);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<Videos> component2() {
        return this.videos;
    }

    /* renamed from: component3, reason: from getter */
    public final String getError() {
        return this.error;
    }

    public final VideoResponse copy(boolean login, ArrayList<Videos> videos, String error) {
        Intrinsics.checkNotNullParameter(videos, "videos");
        Intrinsics.checkNotNullParameter(error, "error");
        return new VideoResponse(login, videos, error);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VideoResponse)) {
            return false;
        }
        VideoResponse videoResponse = (VideoResponse) other;
        return this.login == videoResponse.login && Intrinsics.areEqual(this.videos, videoResponse.videos) && Intrinsics.areEqual(this.error, videoResponse.error);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z = this.login;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (((r0 * 31) + this.videos.hashCode()) * 31) + this.error.hashCode();
    }

    public String toString() {
        return "VideoResponse(login=" + this.login + ", videos=" + this.videos + ", error=" + this.error + ")";
    }

    public VideoResponse(boolean z, ArrayList<Videos> videos, String error) {
        Intrinsics.checkNotNullParameter(videos, "videos");
        Intrinsics.checkNotNullParameter(error, "error");
        this.login = z;
        this.videos = videos;
        this.error = error;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<Videos> getVideos() {
        return this.videos;
    }

    public final String getError() {
        return this.error;
    }
}