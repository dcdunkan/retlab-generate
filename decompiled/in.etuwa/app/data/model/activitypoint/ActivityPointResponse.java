package in.etuwa.app.data.model.activitypoint;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ActivityPointResponse.kt */
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