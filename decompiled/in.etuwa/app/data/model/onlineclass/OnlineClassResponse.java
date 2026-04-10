package in.etuwa.app.data.model.onlineclass;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import in.etuwa.app.ui.attendance.bydaynew.attendaceday.AttendanceDayDialogKt;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OnlineClassResponse.kt */
/* loaded from: classes3.dex */
public final /* data */ class OnlineClassResponse {

    @SerializedName("batch")
    @Expose
    private final String batch;

    @SerializedName("batchvideourl")
    @Expose
    private final String batchVideoUrl;

    @SerializedName(Constants.IPC_BUNDLE_KEY_SEND_ERROR)
    @Expose
    private final String error;

    @SerializedName(FirebaseAnalytics.Event.LOGIN)
    @Expose
    private final boolean login;

    @SerializedName("subjects")
    @Expose
    private final ArrayList<OnlineClass> onlineClass;

    @SerializedName(AttendanceDayDialogKt.ARG_SEM)
    @Expose
    private final String semester;

    public static /* synthetic */ OnlineClassResponse copy$default(OnlineClassResponse onlineClassResponse, boolean z, String str, String str2, String str3, ArrayList arrayList, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            z = onlineClassResponse.login;
        }
        if ((i & 2) != 0) {
            str = onlineClassResponse.batch;
        }
        String str5 = str;
        if ((i & 4) != 0) {
            str2 = onlineClassResponse.semester;
        }
        String str6 = str2;
        if ((i & 8) != 0) {
            str3 = onlineClassResponse.batchVideoUrl;
        }
        String str7 = str3;
        if ((i & 16) != 0) {
            arrayList = onlineClassResponse.onlineClass;
        }
        ArrayList arrayList2 = arrayList;
        if ((i & 32) != 0) {
            str4 = onlineClassResponse.error;
        }
        return onlineClassResponse.copy(z, str5, str6, str7, arrayList2, str4);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    /* renamed from: component2, reason: from getter */
    public final String getBatch() {
        return this.batch;
    }

    /* renamed from: component3, reason: from getter */
    public final String getSemester() {
        return this.semester;
    }

    /* renamed from: component4, reason: from getter */
    public final String getBatchVideoUrl() {
        return this.batchVideoUrl;
    }

    public final ArrayList<OnlineClass> component5() {
        return this.onlineClass;
    }

    /* renamed from: component6, reason: from getter */
    public final String getError() {
        return this.error;
    }

    public final OnlineClassResponse copy(boolean login, String batch, String semester, String batchVideoUrl, ArrayList<OnlineClass> onlineClass, String error) {
        Intrinsics.checkNotNullParameter(batch, "batch");
        Intrinsics.checkNotNullParameter(semester, "semester");
        Intrinsics.checkNotNullParameter(batchVideoUrl, "batchVideoUrl");
        Intrinsics.checkNotNullParameter(onlineClass, "onlineClass");
        Intrinsics.checkNotNullParameter(error, "error");
        return new OnlineClassResponse(login, batch, semester, batchVideoUrl, onlineClass, error);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OnlineClassResponse)) {
            return false;
        }
        OnlineClassResponse onlineClassResponse = (OnlineClassResponse) other;
        return this.login == onlineClassResponse.login && Intrinsics.areEqual(this.batch, onlineClassResponse.batch) && Intrinsics.areEqual(this.semester, onlineClassResponse.semester) && Intrinsics.areEqual(this.batchVideoUrl, onlineClassResponse.batchVideoUrl) && Intrinsics.areEqual(this.onlineClass, onlineClassResponse.onlineClass) && Intrinsics.areEqual(this.error, onlineClassResponse.error);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    public int hashCode() {
        boolean z = this.login;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (((((((((r0 * 31) + this.batch.hashCode()) * 31) + this.semester.hashCode()) * 31) + this.batchVideoUrl.hashCode()) * 31) + this.onlineClass.hashCode()) * 31) + this.error.hashCode();
    }

    public String toString() {
        return "OnlineClassResponse(login=" + this.login + ", batch=" + this.batch + ", semester=" + this.semester + ", batchVideoUrl=" + this.batchVideoUrl + ", onlineClass=" + this.onlineClass + ", error=" + this.error + ")";
    }

    public OnlineClassResponse(boolean z, String batch, String semester, String batchVideoUrl, ArrayList<OnlineClass> onlineClass, String error) {
        Intrinsics.checkNotNullParameter(batch, "batch");
        Intrinsics.checkNotNullParameter(semester, "semester");
        Intrinsics.checkNotNullParameter(batchVideoUrl, "batchVideoUrl");
        Intrinsics.checkNotNullParameter(onlineClass, "onlineClass");
        Intrinsics.checkNotNullParameter(error, "error");
        this.login = z;
        this.batch = batch;
        this.semester = semester;
        this.batchVideoUrl = batchVideoUrl;
        this.onlineClass = onlineClass;
        this.error = error;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final String getBatch() {
        return this.batch;
    }

    public final String getSemester() {
        return this.semester;
    }

    public final String getBatchVideoUrl() {
        return this.batchVideoUrl;
    }

    public final ArrayList<OnlineClass> getOnlineClass() {
        return this.onlineClass;
    }

    public final String getError() {
        return this.error;
    }
}