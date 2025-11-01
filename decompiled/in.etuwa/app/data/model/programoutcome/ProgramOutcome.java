package in.etuwa.app.data.model.programoutcome;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ProgramOutcome.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lin/etuwa/app/data/model/programoutcome/ProgramOutcome;", "", "heading", "", "content", "(Ljava/lang/String;Ljava/lang/String;)V", "getContent", "()Ljava/lang/String;", "getHeading", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ProgramOutcome {
    private final String content;
    private final String heading;

    public static /* synthetic */ ProgramOutcome copy$default(ProgramOutcome programOutcome, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = programOutcome.heading;
        }
        if ((i & 2) != 0) {
            str2 = programOutcome.content;
        }
        return programOutcome.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getHeading() {
        return this.heading;
    }

    /* renamed from: component2, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    public final ProgramOutcome copy(String heading, String content) {
        Intrinsics.checkNotNullParameter(heading, "heading");
        Intrinsics.checkNotNullParameter(content, "content");
        return new ProgramOutcome(heading, content);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ProgramOutcome)) {
            return false;
        }
        ProgramOutcome programOutcome = (ProgramOutcome) other;
        return Intrinsics.areEqual(this.heading, programOutcome.heading) && Intrinsics.areEqual(this.content, programOutcome.content);
    }

    public int hashCode() {
        return (this.heading.hashCode() * 31) + this.content.hashCode();
    }

    public String toString() {
        return "ProgramOutcome(heading=" + this.heading + ", content=" + this.content + ")";
    }

    public ProgramOutcome(String heading, String content) {
        Intrinsics.checkNotNullParameter(heading, "heading");
        Intrinsics.checkNotNullParameter(content, "content");
        this.heading = heading;
        this.content = content;
    }

    public final String getHeading() {
        return this.heading;
    }

    public final String getContent() {
        return this.content;
    }
}