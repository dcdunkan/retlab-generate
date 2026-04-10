package in.etuwa.app.data.model.lab;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Evaluation.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class Evaluation {
    private final String output;
    private final String record;
    private final String topic;
    private final String viva;

    public static /* synthetic */ Evaluation copy$default(Evaluation evaluation, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = evaluation.topic;
        }
        if ((i & 2) != 0) {
            str2 = evaluation.output;
        }
        if ((i & 4) != 0) {
            str3 = evaluation.record;
        }
        if ((i & 8) != 0) {
            str4 = evaluation.viva;
        }
        return evaluation.copy(str, str2, str3, str4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTopic() {
        return this.topic;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getOutput() {
        return this.output;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getRecord() {
        return this.record;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getViva() {
        return this.viva;
    }

    public final Evaluation copy(String topic, String output, String record, String viva) {
        Intrinsics.checkNotNullParameter(topic, "topic");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(record, "record");
        Intrinsics.checkNotNullParameter(viva, "viva");
        return new Evaluation(topic, output, record, viva);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Evaluation)) {
            return false;
        }
        Evaluation evaluation = (Evaluation) other;
        return Intrinsics.areEqual(this.topic, evaluation.topic) && Intrinsics.areEqual(this.output, evaluation.output) && Intrinsics.areEqual(this.record, evaluation.record) && Intrinsics.areEqual(this.viva, evaluation.viva);
    }

    public int hashCode() {
        return (((((this.topic.hashCode() * 31) + this.output.hashCode()) * 31) + this.record.hashCode()) * 31) + this.viva.hashCode();
    }

    public String toString() {
        return "Evaluation(topic=" + this.topic + ", output=" + this.output + ", record=" + this.record + ", viva=" + this.viva + ")";
    }

    public Evaluation(String topic, String output, String record, String viva) {
        Intrinsics.checkNotNullParameter(topic, "topic");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(record, "record");
        Intrinsics.checkNotNullParameter(viva, "viva");
        this.topic = topic;
        this.output = output;
        this.record = record;
        this.viva = viva;
    }

    public final String getTopic() {
        return this.topic;
    }

    public final String getOutput() {
        return this.output;
    }

    public final String getRecord() {
        return this.record;
    }

    public final String getViva() {
        return this.viva;
    }
}