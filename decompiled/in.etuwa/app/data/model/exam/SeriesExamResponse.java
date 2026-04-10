package in.etuwa.app.data.model.exam;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SeriesExamResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
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

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<Exam> component2() {
        return this.seriesExams;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
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