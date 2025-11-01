package in.etuwa.app.data.model.lab;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Evaluation.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lin/etuwa/app/data/model/lab/Evaluation;", "", "topic", "", "output", "record", "viva", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getOutput", "()Ljava/lang/String;", "getRecord", "getTopic", "getViva", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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

    /* renamed from: component1, reason: from getter */
    public final String getTopic() {
        return this.topic;
    }

    /* renamed from: component2, reason: from getter */
    public final String getOutput() {
        return this.output;
    }

    /* renamed from: component3, reason: from getter */
    public final String getRecord() {
        return this.record;
    }

    /* renamed from: component4, reason: from getter */
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