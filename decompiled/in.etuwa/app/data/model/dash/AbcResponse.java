package in.etuwa.app.data.model.dash;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AbcResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class AbcResponse {
    private final String abc_id;
    private final String instructions;
    private final boolean login;
    private final String video;

    public static /* synthetic */ AbcResponse copy$default(AbcResponse abcResponse, boolean z, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = abcResponse.login;
        }
        if ((i & 2) != 0) {
            str = abcResponse.abc_id;
        }
        if ((i & 4) != 0) {
            str2 = abcResponse.instructions;
        }
        if ((i & 8) != 0) {
            str3 = abcResponse.video;
        }
        return abcResponse.copy(z, str, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getAbc_id() {
        return this.abc_id;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getInstructions() {
        return this.instructions;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getVideo() {
        return this.video;
    }

    public final AbcResponse copy(boolean login, String abc_id, String instructions, String video) {
        Intrinsics.checkNotNullParameter(abc_id, "abc_id");
        Intrinsics.checkNotNullParameter(instructions, "instructions");
        Intrinsics.checkNotNullParameter(video, "video");
        return new AbcResponse(login, abc_id, instructions, video);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AbcResponse)) {
            return false;
        }
        AbcResponse abcResponse = (AbcResponse) other;
        return this.login == abcResponse.login && Intrinsics.areEqual(this.abc_id, abcResponse.abc_id) && Intrinsics.areEqual(this.instructions, abcResponse.instructions) && Intrinsics.areEqual(this.video, abcResponse.video);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public int hashCode() {
        boolean z = this.login;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (((((r0 * 31) + this.abc_id.hashCode()) * 31) + this.instructions.hashCode()) * 31) + this.video.hashCode();
    }

    public String toString() {
        return "AbcResponse(login=" + this.login + ", abc_id=" + this.abc_id + ", instructions=" + this.instructions + ", video=" + this.video + ")";
    }

    public AbcResponse(boolean z, String abc_id, String instructions, String video) {
        Intrinsics.checkNotNullParameter(abc_id, "abc_id");
        Intrinsics.checkNotNullParameter(instructions, "instructions");
        Intrinsics.checkNotNullParameter(video, "video");
        this.login = z;
        this.abc_id = abc_id;
        this.instructions = instructions;
        this.video = video;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final String getAbc_id() {
        return this.abc_id;
    }

    public final String getInstructions() {
        return this.instructions;
    }

    public final String getVideo() {
        return this.video;
    }
}