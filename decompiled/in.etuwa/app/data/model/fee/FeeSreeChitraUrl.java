package in.etuwa.app.data.model.fee;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* compiled from: FeeSreeChitraUrl.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lin/etuwa/app/data/model/fee/FeeSreeChitraUrl;", "", FirebaseAnalytics.Event.LOGIN, "", "success", "url", "", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;)V", "getLogin", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getSuccess", "getUrl", "()Ljava/lang/String;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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