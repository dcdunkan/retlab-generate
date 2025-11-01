package in.etuwa.app.data.model.activitypoint;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ActivityPointResponse.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001d\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\tHÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003JI\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u001c\b\u0002\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R*\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000f¨\u0006\u001d"}, d2 = {"Lin/etuwa/app/data/model/activitypoint/ActivityPointResponse;", "", FirebaseAnalytics.Event.LOGIN, "", "totalActivityPoint", "", "activityPoints", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/activitypoint/ActivityPoints;", "Lkotlin/collections/ArrayList;", Constants.IPC_BUNDLE_KEY_SEND_ERROR, "(ZLjava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;)V", "getActivityPoints", "()Ljava/util/ArrayList;", "getError", "()Ljava/lang/String;", "getLogin", "()Z", "getTotalActivityPoint", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ActivityPointResponse {

    @SerializedName("activity_points")
    @Expose
    private final ArrayList<ActivityPoints> activityPoints;

    @SerializedName(Constants.IPC_BUNDLE_KEY_SEND_ERROR)
    @Expose
    private final String error;

    @SerializedName(FirebaseAnalytics.Event.LOGIN)
    @Expose
    private final boolean login;

    @SerializedName("total_activity_point")
    private final String totalActivityPoint;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ActivityPointResponse copy$default(ActivityPointResponse activityPointResponse, boolean z, String str, ArrayList arrayList, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = activityPointResponse.login;
        }
        if ((i & 2) != 0) {
            str = activityPointResponse.totalActivityPoint;
        }
        if ((i & 4) != 0) {
            arrayList = activityPointResponse.activityPoints;
        }
        if ((i & 8) != 0) {
            str2 = activityPointResponse.error;
        }
        return activityPointResponse.copy(z, str, arrayList, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTotalActivityPoint() {
        return this.totalActivityPoint;
    }

    public final ArrayList<ActivityPoints> component3() {
        return this.activityPoints;
    }

    /* renamed from: component4, reason: from getter */
    public final String getError() {
        return this.error;
    }

    public final ActivityPointResponse copy(boolean login, String totalActivityPoint, ArrayList<ActivityPoints> activityPoints, String error) {
        return new ActivityPointResponse(login, totalActivityPoint, activityPoints, error);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ActivityPointResponse)) {
            return false;
        }
        ActivityPointResponse activityPointResponse = (ActivityPointResponse) other;
        return this.login == activityPointResponse.login && Intrinsics.areEqual(this.totalActivityPoint, activityPointResponse.totalActivityPoint) && Intrinsics.areEqual(this.activityPoints, activityPointResponse.activityPoints) && Intrinsics.areEqual(this.error, activityPointResponse.error);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public int hashCode() {
        boolean z = this.login;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        String str = this.totalActivityPoint;
        int hashCode = (i + (str == null ? 0 : str.hashCode())) * 31;
        ArrayList<ActivityPoints> arrayList = this.activityPoints;
        int hashCode2 = (hashCode + (arrayList == null ? 0 : arrayList.hashCode())) * 31;
        String str2 = this.error;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "ActivityPointResponse(login=" + this.login + ", totalActivityPoint=" + this.totalActivityPoint + ", activityPoints=" + this.activityPoints + ", error=" + this.error + ")";
    }

    public ActivityPointResponse(boolean z, String str, ArrayList<ActivityPoints> arrayList, String str2) {
        this.login = z;
        this.totalActivityPoint = str;
        this.activityPoints = arrayList;
        this.error = str2;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final String getTotalActivityPoint() {
        return this.totalActivityPoint;
    }

    public final ArrayList<ActivityPoints> getActivityPoints() {
        return this.activityPoints;
    }

    public final String getError() {
        return this.error;
    }
}