package in.etuwa.app.data.model.fee;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: compiled from: FeeSreeChitraUrl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class FeeSreeChitraUrl {

    @SerializedName(FirebaseAnalytics.Event.LOGIN)
    private final Boolean login;

    @SerializedName("success")
    private final Boolean success;

    @SerializedName("url")
    private final String url;

    public FeeSreeChitraUrl(Boolean bool, Boolean bool2, String str) {
        this.login = bool;
        this.success = bool2;
        this.url = str;
    }

    public final Boolean getLogin() {
        return this.login;
    }

    public final Boolean getSuccess() {
        return this.success;
    }

    public final String getUrl() {
        return this.url;
    }
}