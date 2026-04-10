package in.etuwa.app.data.model.subject.coverage;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SubCoverage.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class SubCoverage {
    private final String module;
    private final float ratio;
    private final ArrayList<SubCovTopic> topic;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SubCoverage copy$default(SubCoverage subCoverage, String str, ArrayList arrayList, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            str = subCoverage.module;
        }
        if ((i & 2) != 0) {
            arrayList = subCoverage.topic;
        }
        if ((i & 4) != 0) {
            f = subCoverage.ratio;
        }
        return subCoverage.copy(str, arrayList, f);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getModule() {
        return this.module;
    }

    public final ArrayList<SubCovTopic> component2() {
        return this.topic;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final float getRatio() {
        return this.ratio;
    }

    public final SubCoverage copy(String module, ArrayList<SubCovTopic> topic, float ratio) {
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(topic, "topic");
        return new SubCoverage(module, topic, ratio);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SubCoverage)) {
            return false;
        }
        SubCoverage subCoverage = (SubCoverage) other;
        return Intrinsics.areEqual(this.module, subCoverage.module) && Intrinsics.areEqual(this.topic, subCoverage.topic) && Float.compare(this.ratio, subCoverage.ratio) == 0;
    }

    public int hashCode() {
        return (((this.module.hashCode() * 31) + this.topic.hashCode()) * 31) + Float.floatToIntBits(this.ratio);
    }

    public String toString() {
        return "SubCoverage(module=" + this.module + ", topic=" + this.topic + ", ratio=" + this.ratio + ")";
    }

    public SubCoverage(String module, ArrayList<SubCovTopic> topic, float f) {
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(topic, "topic");
        this.module = module;
        this.topic = topic;
        this.ratio = f;
    }

    public final String getModule() {
        return this.module;
    }

    public final ArrayList<SubCovTopic> getTopic() {
        return this.topic;
    }

    public final float getRatio() {
        return this.ratio;
    }
}