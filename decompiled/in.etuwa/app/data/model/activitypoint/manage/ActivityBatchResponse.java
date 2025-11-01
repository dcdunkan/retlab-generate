package in.etuwa.app.data.model.activitypoint.manage;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ActivityBatchResponse.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u001a\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\tHÆ\u0003J=\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u001c\b\u0002\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\tHÖ\u0001R*\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lin/etuwa/app/data/model/activitypoint/manage/ActivityBatchResponse;", "", FirebaseAnalytics.Event.LOGIN, "", "activityBatch", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/activitypoint/manage/ActivityBatch;", "Lkotlin/collections/ArrayList;", Constants.IPC_BUNDLE_KEY_SEND_ERROR, "", "(ZLjava/util/ArrayList;Ljava/lang/String;)V", "getActivityBatch", "()Ljava/util/ArrayList;", "getError", "()Ljava/lang/String;", "getLogin", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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

    /* renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<ActivityBatch> component2() {
        return this.activityBatch;
    }

    /* renamed from: component3, reason: from getter */
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
        int hashCode = (i + (arrayList == null ? 0 : arrayList.hashCode())) * 31;
        String str = this.error;
        return hashCode + (str != null ? str.hashCode() : 0);
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