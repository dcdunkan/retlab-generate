package in.etuwa.app.data.model.programoutcome;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ProgramOutcome.kt */
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