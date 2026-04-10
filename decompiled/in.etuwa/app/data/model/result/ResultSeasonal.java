package in.etuwa.app.data.model.result;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ResultSeasonal.kt */
/* loaded from: classes3.dex */
public final /* data */ class ResultSeasonal {

    @SerializedName("max_mark")
    @Expose
    private final String maxMark;

    @SerializedName("obtained_mark")
    @Expose
    private final String obtainMark;
    private final String subject;

    public static /* synthetic */ ResultSeasonal copy$default(ResultSeasonal resultSeasonal, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = resultSeasonal.subject;
        }
        if ((i & 2) != 0) {
            str2 = resultSeasonal.maxMark;
        }
        if ((i & 4) != 0) {
            str3 = resultSeasonal.obtainMark;
        }
        return resultSeasonal.copy(str, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getSubject() {
        return this.subject;
    }

    /* renamed from: component2, reason: from getter */
    public final String getMaxMark() {
        return this.maxMark;
    }

    /* renamed from: component3, reason: from getter */
    public final String getObtainMark() {
        return this.obtainMark;
    }

    public final ResultSeasonal copy(String subject, String maxMark, String obtainMark) {
        Intrinsics.checkNotNullParameter(subject, "subject");
        Intrinsics.checkNotNullParameter(maxMark, "maxMark");
        Intrinsics.checkNotNullParameter(obtainMark, "obtainMark");
        return new ResultSeasonal(subject, maxMark, obtainMark);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ResultSeasonal)) {
            return false;
        }
        ResultSeasonal resultSeasonal = (ResultSeasonal) other;
        return Intrinsics.areEqual(this.subject, resultSeasonal.subject) && Intrinsics.areEqual(this.maxMark, resultSeasonal.maxMark) && Intrinsics.areEqual(this.obtainMark, resultSeasonal.obtainMark);
    }

    public int hashCode() {
        return (((this.subject.hashCode() * 31) + this.maxMark.hashCode()) * 31) + this.obtainMark.hashCode();
    }

    public String toString() {
        return "ResultSeasonal(subject=" + this.subject + ", maxMark=" + this.maxMark + ", obtainMark=" + this.obtainMark + ")";
    }

    public ResultSeasonal(String subject, String maxMark, String obtainMark) {
        Intrinsics.checkNotNullParameter(subject, "subject");
        Intrinsics.checkNotNullParameter(maxMark, "maxMark");
        Intrinsics.checkNotNullParameter(obtainMark, "obtainMark");
        this.subject = subject;
        this.maxMark = maxMark;
        this.obtainMark = obtainMark;
    }

    public final String getSubject() {
        return this.subject;
    }

    public final String getMaxMark() {
        return this.maxMark;
    }

    public final String getObtainMark() {
        return this.obtainMark;
    }
}