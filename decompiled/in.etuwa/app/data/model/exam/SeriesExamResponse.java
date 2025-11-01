package in.etuwa.app.data.model.exam;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SeriesExamResponse.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007HÆ\u0003J\t\u0010\u0013\u001a\u00020\tHÆ\u0003J7\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\tHÖ\u0001R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR&\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lin/etuwa/app/data/model/exam/SeriesExamResponse;", "", FirebaseAnalytics.Event.LOGIN, "", "seriesExams", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/exam/Exam;", "Lkotlin/collections/ArrayList;", Constants.IPC_BUNDLE_KEY_SEND_ERROR, "", "(ZLjava/util/ArrayList;Ljava/lang/String;)V", "getError", "()Ljava/lang/String;", "getLogin", "()Z", "getSeriesExams", "()Ljava/util/ArrayList;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class SeriesExamResponse {
    private final String error;
    private final boolean login;

    @SerializedName("series_exams")
    @Expose
    private final ArrayList<Exam> seriesExams;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SeriesExamResponse copy$default(SeriesExamResponse seriesExamResponse, boolean z, ArrayList arrayList, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = seriesExamResponse.login;
        }
        if ((i & 2) != 0) {
            arrayList = seriesExamResponse.seriesExams;
        }
        if ((i & 4) != 0) {
            str = seriesExamResponse.error;
        }
        return seriesExamResponse.copy(z, arrayList, str);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<Exam> component2() {
        return this.seriesExams;
    }

    /* renamed from: component3, reason: from getter */
    public final String getError() {
        return this.error;
    }

    public final SeriesExamResponse copy(boolean login, ArrayList<Exam> seriesExams, String error) {
        Intrinsics.checkNotNullParameter(seriesExams, "seriesExams");
        Intrinsics.checkNotNullParameter(error, "error");
        return new SeriesExamResponse(login, seriesExams, error);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SeriesExamResponse)) {
            return false;
        }
        SeriesExamResponse seriesExamResponse = (SeriesExamResponse) other;
        return this.login == seriesExamResponse.login && Intrinsics.areEqual(this.seriesExams, seriesExamResponse.seriesExams) && Intrinsics.areEqual(this.error, seriesExamResponse.error);
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
        return (((r0 * 31) + this.seriesExams.hashCode()) * 31) + this.error.hashCode();
    }

    public String toString() {
        return "SeriesExamResponse(login=" + this.login + ", seriesExams=" + this.seriesExams + ", error=" + this.error + ")";
    }

    public SeriesExamResponse(boolean z, ArrayList<Exam> seriesExams, String error) {
        Intrinsics.checkNotNullParameter(seriesExams, "seriesExams");
        Intrinsics.checkNotNullParameter(error, "error");
        this.login = z;
        this.seriesExams = seriesExams;
        this.error = error;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<Exam> getSeriesExams() {
        return this.seriesExams;
    }

    public final String getError() {
        return this.error;
    }
}