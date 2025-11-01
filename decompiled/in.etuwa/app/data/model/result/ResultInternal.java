package in.etuwa.app.data.model.result;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ResultInternal.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lin/etuwa/app/data/model/result/ResultInternal;", "", "subject", "", "maxMark", "obtainMark", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMaxMark", "()Ljava/lang/String;", "getObtainMark", "getSubject", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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