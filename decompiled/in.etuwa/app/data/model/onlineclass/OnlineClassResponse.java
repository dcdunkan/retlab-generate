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
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b\u0012\u0006\u0010\f\u001a\u00020\u0005¢\u0006\u0002\u0010\rJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\u0019\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bHÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003JU\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b2\b\b\u0002\u0010\f\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0016\u0010\f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R&\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000f¨\u0006#"}, d2 = {"Lin/etuwa/app/data/model/onlineclass/OnlineClassResponse;", "", FirebaseAnalytics.Event.LOGIN, "", "batch", "", AttendanceDayDialogKt.ARG_SEM, "batchVideoUrl", "onlineClass", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/onlineclass/OnlineClass;", "Lkotlin/collections/ArrayList;", Constants.IPC_BUNDLE_KEY_SEND_ERROR, "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;)V", "getBatch", "()Ljava/lang/String;", "getBatchVideoUrl", "getError", "getLogin", "()Z", "getOnlineClass", "()Ljava/util/ArrayList;", "getSemester", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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