package in.etuwa.app.data.model.subject.co;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CoModel.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lin/etuwa/app/data/model/subject/co/CoModel;", "", "coId", "", "topic", "(Ljava/lang/String;Ljava/lang/String;)V", "getCoId", "()Ljava/lang/String;", "getTopic", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class CoModel {

    @SerializedName("co_id")
    @Expose
    private final String coId;
    private final String topic;

    public static /* synthetic */ CoModel copy$default(CoModel coModel, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = coModel.coId;
        }
        if ((i & 2) != 0) {
            str2 = coModel.topic;
        }
        return coModel.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getCoId() {
        return this.coId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTopic() {
        return this.topic;
    }

    public final CoModel copy(String coId, String topic) {
        Intrinsics.checkNotNullParameter(coId, "coId");
        Intrinsics.checkNotNullParameter(topic, "topic");
        return new CoModel(coId, topic);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CoModel)) {
            return false;
        }
        CoModel coModel = (CoModel) other;
        return Intrinsics.areEqual(this.coId, coModel.coId) && Intrinsics.areEqual(this.topic, coModel.topic);
    }

    public int hashCode() {
        return (this.coId.hashCode() * 31) + this.topic.hashCode();
    }

    public String toString() {
        return "CoModel(coId=" + this.coId + ", topic=" + this.topic + ")";
    }

    public CoModel(String coId, String topic) {
        Intrinsics.checkNotNullParameter(coId, "coId");
        Intrinsics.checkNotNullParameter(topic, "topic");
        this.coId = coId;
        this.topic = topic;
    }

    public final String getCoId() {
        return this.coId;
    }

    public final String getTopic() {
        return this.topic;
    }
}