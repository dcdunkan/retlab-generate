package in.etuwa.app.data.model.activitypoint.manage;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ActivityBatchResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class ActivityBatchResponse {

    @SerializedName("activity_batch")
    private final ArrayList<ActivityBatch> activityBatch;

    @SerializedName(Constants.IPC_BUNDLE_KEY_SEND_ERROR)
    @Expose
    private final String error;
    private final boolean login;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ActivityBatchResponse copy$default(ActivityBatchResponse activityBatchResponse, boolean z, ArrayList arrayList, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = activityBatchResponse.login;
        }
        if ((i & 2) != 0) {
            arrayList = activityBatchResponse.activityBatch;
        }
        if ((i & 4) != 0) {
            str = activityBatchResponse.error;
        }
        return activityBatchResponse.copy(z, arrayList, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<ActivityBatch> component2() {
        return this.activityBatch;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getError() {
        return this.error;
    }

    public final ActivityBatchResponse copy(boolean login, ArrayList<ActivityBatch> activityBatch, String error) {
        return new ActivityBatchResponse(login, activityBatch, error);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ActivityBatchResponse)) {
            return false;
        }
        ActivityBatchResponse activityBatchResponse = (ActivityBatchResponse) other;
        return this.login == activityBatchResponse.login && Intrinsics.areEqual(this.activityBatch, activityBatchResponse.activityBatch) && Intrinsics.areEqual(this.error, activityBatchResponse.error);
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
        int i = r0 * 31;
        ArrayList<ActivityBatch> arrayList = this.activityBatch;
        int iHashCode = (i + (arrayList == null ? 0 : arrayList.hashCode())) * 31;
        String str = this.error;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "ActivityBatchResponse(login=" + this.login + ", activityBatch=" + this.activityBatch + ", error=" + this.error + ")";
    }

    public ActivityBatchResponse(boolean z, ArrayList<ActivityBatch> arrayList, String str) {
        this.login = z;
        this.activityBatch = arrayList;
        this.error = str;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<ActivityBatch> getActivityBatch() {
        return this.activityBatch;
    }

    public final String getError() {
        return this.error;
    }
}