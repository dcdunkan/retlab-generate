package in.etuwa.app.data.model.dash;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AbcResponse.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u0019"}, d2 = {"Lin/etuwa/app/data/model/dash/AbcResponse;", "", FirebaseAnalytics.Event.LOGIN, "", "abc_id", "", "instructions", "video", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAbc_id", "()Ljava/lang/String;", "getInstructions", "getLogin", "()Z", "getVideo", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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

    /* renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAbc_id() {
        return this.abc_id;
    }

    /* renamed from: component3, reason: from getter */
    public final String getInstructions() {
        return this.instructions;
    }

    /* renamed from: component4, reason: from getter */
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