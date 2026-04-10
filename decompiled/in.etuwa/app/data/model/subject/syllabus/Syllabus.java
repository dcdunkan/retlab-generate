package in.etuwa.app.data.model.subject.syllabus;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Syllabus.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class Syllabus {
    private final String module;
    private final ArrayList<Topic> topics;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Syllabus copy$default(Syllabus syllabus, String str, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            str = syllabus.module;
        }
        if ((i & 2) != 0) {
            arrayList = syllabus.topics;
        }
        return syllabus.copy(str, arrayList);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getModule() {
        return this.module;
    }

    public final ArrayList<Topic> component2() {
        return this.topics;
    }

    public final Syllabus copy(String module, ArrayList<Topic> topics) {
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(topics, "topics");
        return new Syllabus(module, topics);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Syllabus)) {
            return false;
        }
        Syllabus syllabus = (Syllabus) other;
        return Intrinsics.areEqual(this.module, syllabus.module) && Intrinsics.areEqual(this.topics, syllabus.topics);
    }

    public int hashCode() {
        return (this.module.hashCode() * 31) + this.topics.hashCode();
    }

    public String toString() {
        return "Syllabus(module=" + this.module + ", topics=" + this.topics + ")";
    }

    public Syllabus(String module, ArrayList<Topic> topics) {
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(topics, "topics");
        this.module = module;
        this.topics = topics;
    }

    public final String getModule() {
        return this.module;
    }

    public final ArrayList<Topic> getTopics() {
        return this.topics;
    }
}