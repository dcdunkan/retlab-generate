package in.etuwa.app.data.model.result;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ResultAssignment.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lin/etuwa/app/data/model/result/ResultAssignment;", "", "subject", "", "name", "maxMark", "obtainMark", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMaxMark", "()Ljava/lang/String;", "getName", "getObtainMark", "getSubject", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ResultAssignment {

    @SerializedName("max_mark")
    @Expose
    private final String maxMark;
    private final String name;

    @SerializedName("obtained_mark")
    @Expose
    private final String obtainMark;
    private final String subject;

    public static /* synthetic */ ResultAssignment copy$default(ResultAssignment resultAssignment, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = resultAssignment.subject;
        }
        if ((i & 2) != 0) {
            str2 = resultAssignment.name;
        }
        if ((i & 4) != 0) {
            str3 = resultAssignment.maxMark;
        }
        if ((i & 8) != 0) {
            str4 = resultAssignment.obtainMark;
        }
        return resultAssignment.copy(str, str2, str3, str4);
    }

    /* renamed from: component1, reason: from getter */
    public final String getSubject() {
        return this.subject;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final String getMaxMark() {
        return this.maxMark;
    }

    /* renamed from: component4, reason: from getter */
    public final String getObtainMark() {
        return this.obtainMark;
    }

    public final ResultAssignment copy(String subject, String name, String maxMark, String obtainMark) {
        Intrinsics.checkNotNullParameter(subject, "subject");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(maxMark, "maxMark");
        Intrinsics.checkNotNullParameter(obtainMark, "obtainMark");
        return new ResultAssignment(subject, name, maxMark, obtainMark);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ResultAssignment)) {
            return false;
        }
        ResultAssignment resultAssignment = (ResultAssignment) other;
        return Intrinsics.areEqual(this.subject, resultAssignment.subject) && Intrinsics.areEqual(this.name, resultAssignment.name) && Intrinsics.areEqual(this.maxMark, resultAssignment.maxMark) && Intrinsics.areEqual(this.obtainMark, resultAssignment.obtainMark);
    }

    public int hashCode() {
        return (((((this.subject.hashCode() * 31) + this.name.hashCode()) * 31) + this.maxMark.hashCode()) * 31) + this.obtainMark.hashCode();
    }

    public String toString() {
        return "ResultAssignment(subject=" + this.subject + ", name=" + this.name + ", maxMark=" + this.maxMark + ", obtainMark=" + this.obtainMark + ")";
    }

    public ResultAssignment(String subject, String name, String maxMark, String obtainMark) {
        Intrinsics.checkNotNullParameter(subject, "subject");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(maxMark, "maxMark");
        Intrinsics.checkNotNullParameter(obtainMark, "obtainMark");
        this.subject = subject;
        this.name = name;
        this.maxMark = maxMark;
        this.obtainMark = obtainMark;
    }

    public final String getSubject() {
        return this.subject;
    }

    public final String getName() {
        return this.name;
    }

    public final String getMaxMark() {
        return this.maxMark;
    }

    public final String getObtainMark() {
        return this.obtainMark;
    }
}