package in.etuwa.app.data.model.subject.co;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CoModel.kt */
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