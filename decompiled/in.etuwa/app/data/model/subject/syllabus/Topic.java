package in.etuwa.app.data.model.subject.syllabus;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Topic.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class Topic {
    private final String topic;

    public static /* synthetic */ Topic copy$default(Topic topic, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = topic.topic;
        }
        return topic.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTopic() {
        return this.topic;
    }

    public final Topic copy(String topic) {
        Intrinsics.checkNotNullParameter(topic, "topic");
        return new Topic(topic);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof Topic) && Intrinsics.areEqual(this.topic, ((Topic) other).topic);
    }

    public int hashCode() {
        return this.topic.hashCode();
    }

    public String toString() {
        return "Topic(topic=" + this.topic + ")";
    }

    public Topic(String topic) {
        Intrinsics.checkNotNullParameter(topic, "topic");
        this.topic = topic;
    }

    public final String getTopic() {
        return this.topic;
    }
}