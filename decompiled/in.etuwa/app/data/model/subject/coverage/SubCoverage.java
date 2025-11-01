package in.etuwa.app.data.model.subject.coverage;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SubCoverage.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007HÆ\u0003J\t\u0010\u0013\u001a\u00020\tHÆ\u0003J7\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lin/etuwa/app/data/model/subject/coverage/SubCoverage;", "", "module", "", "topic", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/subject/coverage/SubCovTopic;", "Lkotlin/collections/ArrayList;", "ratio", "", "(Ljava/lang/String;Ljava/util/ArrayList;F)V", "getModule", "()Ljava/lang/String;", "getRatio", "()F", "getTopic", "()Ljava/util/ArrayList;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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

    /* renamed from: component1, reason: from getter */
    public final String getModule() {
        return this.module;
    }

    public final ArrayList<SubCovTopic> component2() {
        return this.topic;
    }

    /* renamed from: component3, reason: from getter */
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