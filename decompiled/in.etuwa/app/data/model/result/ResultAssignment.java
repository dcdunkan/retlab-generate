package in.etuwa.app.data.model.result;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ResultAssignment.kt */
/* JADX INFO: loaded from: classes3.dex */
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

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSubject() {
        return this.subject;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getMaxMark() {
        return this.maxMark;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
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