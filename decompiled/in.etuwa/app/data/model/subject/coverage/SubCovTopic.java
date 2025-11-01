package in.etuwa.app.data.model.subject.coverage;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SubCovTopic.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0007R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0012"}, d2 = {"Lin/etuwa/app/data/model/subject/coverage/SubCovTopic;", "", "isCovered", "", "topicName", "", "(ZLjava/lang/String;)V", "()Z", "getTopicName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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

    /* renamed from: component1, reason: from getter */
    public final boolean getIsCovered() {
        return this.isCovered;
    }

    /* renamed from: component2, reason: from getter */
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