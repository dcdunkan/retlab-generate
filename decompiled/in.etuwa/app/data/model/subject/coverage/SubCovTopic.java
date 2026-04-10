package in.etuwa.app.data.model.subject.coverage;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SubCovTopic.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class SubCovTopic {

    @SerializedName("is_covered")
    private final boolean isCovered;

    @SerializedName("topic_name")
    private final String topicName;

    public static /* synthetic */ SubCovTopic copy$default(SubCovTopic subCovTopic, boolean z, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = subCovTopic.isCovered;
        }
        if ((i & 2) != 0) {
            str = subCovTopic.topicName;
        }
        return subCovTopic.copy(z, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsCovered() {
        return this.isCovered;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTopicName() {
        return this.topicName;
    }

    public final SubCovTopic copy(boolean isCovered, String topicName) {
        Intrinsics.checkNotNullParameter(topicName, "topicName");
        return new SubCovTopic(isCovered, topicName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SubCovTopic)) {
            return false;
        }
        SubCovTopic subCovTopic = (SubCovTopic) other;
        return this.isCovered == subCovTopic.isCovered && Intrinsics.areEqual(this.topicName, subCovTopic.topicName);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z = this.isCovered;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (r0 * 31) + this.topicName.hashCode();
    }

    public String toString() {
        return "SubCovTopic(isCovered=" + this.isCovered + ", topicName=" + this.topicName + ")";
    }

    public SubCovTopic(boolean z, String topicName) {
        Intrinsics.checkNotNullParameter(topicName, "topicName");
        this.isCovered = z;
        this.topicName = topicName;
    }

    public final boolean isCovered() {
        return this.isCovered;
    }

    public final String getTopicName() {
        return this.topicName;
    }
}