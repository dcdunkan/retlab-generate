package in.etuwa.app.data.model.profileasiet.mooccourse;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MoocCourseResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class MoocCourseResponse {
    private final boolean login;
    private final ArrayList<MoocCourse> mooc;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MoocCourseResponse copy$default(MoocCourseResponse moocCourseResponse, boolean z, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            z = moocCourseResponse.login;
        }
        if ((i & 2) != 0) {
            arrayList = moocCourseResponse.mooc;
        }
        return moocCourseResponse.copy(z, arrayList);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<MoocCourse> component2() {
        return this.mooc;
    }

    public final MoocCourseResponse copy(boolean login, ArrayList<MoocCourse> mooc) {
        Intrinsics.checkNotNullParameter(mooc, "mooc");
        return new MoocCourseResponse(login, mooc);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MoocCourseResponse)) {
            return false;
        }
        MoocCourseResponse moocCourseResponse = (MoocCourseResponse) other;
        return this.login == moocCourseResponse.login && Intrinsics.areEqual(this.mooc, moocCourseResponse.mooc);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z = this.login;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (r0 * 31) + this.mooc.hashCode();
    }

    public String toString() {
        return "MoocCourseResponse(login=" + this.login + ", mooc=" + this.mooc + ")";
    }

    public MoocCourseResponse(boolean z, ArrayList<MoocCourse> mooc) {
        Intrinsics.checkNotNullParameter(mooc, "mooc");
        this.login = z;
        this.mooc = mooc;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<MoocCourse> getMooc() {
        return this.mooc;
    }
}