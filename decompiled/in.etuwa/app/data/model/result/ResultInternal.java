package in.etuwa.app.data.model.result;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ResultInternal.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class ResultInternal {

    @SerializedName("max_mark")
    @Expose
    private final String maxMark;

    @SerializedName("obtained_mark")
    @Expose
    private final String obtainMark;
    private final String subject;

    public static /* synthetic */ ResultInternal copy$default(ResultInternal resultInternal, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = resultInternal.subject;
        }
        if ((i & 2) != 0) {
            str2 = resultInternal.maxMark;
        }
        if ((i & 4) != 0) {
            str3 = resultInternal.obtainMark;
        }
        return resultInternal.copy(str, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSubject() {
        return this.subject;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getMaxMark() {
        return this.maxMark;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getObtainMark() {
        return this.obtainMark;
    }

    public final ResultInternal copy(String subject, String maxMark, String obtainMark) {
        Intrinsics.checkNotNullParameter(subject, "subject");
        Intrinsics.checkNotNullParameter(maxMark, "maxMark");
        Intrinsics.checkNotNullParameter(obtainMark, "obtainMark");
        return new ResultInternal(subject, maxMark, obtainMark);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ResultInternal)) {
            return false;
        }
        ResultInternal resultInternal = (ResultInternal) other;
        return Intrinsics.areEqual(this.subject, resultInternal.subject) && Intrinsics.areEqual(this.maxMark, resultInternal.maxMark) && Intrinsics.areEqual(this.obtainMark, resultInternal.obtainMark);
    }

    public int hashCode() {
        return (((this.subject.hashCode() * 31) + this.maxMark.hashCode()) * 31) + this.obtainMark.hashCode();
    }

    public String toString() {
        return "ResultInternal(subject=" + this.subject + ", maxMark=" + this.maxMark + ", obtainMark=" + this.obtainMark + ")";
    }

    public ResultInternal(String subject, String maxMark, String obtainMark) {
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