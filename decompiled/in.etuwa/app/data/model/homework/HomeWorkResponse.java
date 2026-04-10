package in.etuwa.app.data.model.homework;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HomeWorkResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class HomeWorkResponse {
    private final ArrayList<HomeWork> homeworks;
    private final boolean login;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HomeWorkResponse copy$default(HomeWorkResponse homeWorkResponse, boolean z, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            z = homeWorkResponse.login;
        }
        if ((i & 2) != 0) {
            arrayList = homeWorkResponse.homeworks;
        }
        return homeWorkResponse.copy(z, arrayList);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<HomeWork> component2() {
        return this.homeworks;
    }

    public final HomeWorkResponse copy(boolean login, ArrayList<HomeWork> homeworks) {
        Intrinsics.checkNotNullParameter(homeworks, "homeworks");
        return new HomeWorkResponse(login, homeworks);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HomeWorkResponse)) {
            return false;
        }
        HomeWorkResponse homeWorkResponse = (HomeWorkResponse) other;
        return this.login == homeWorkResponse.login && Intrinsics.areEqual(this.homeworks, homeWorkResponse.homeworks);
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
        return (r0 * 31) + this.homeworks.hashCode();
    }

    public String toString() {
        return "HomeWorkResponse(login=" + this.login + ", homeworks=" + this.homeworks + ")";
    }

    public HomeWorkResponse(boolean z, ArrayList<HomeWork> homeworks) {
        Intrinsics.checkNotNullParameter(homeworks, "homeworks");
        this.login = z;
        this.homeworks = homeworks;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<HomeWork> getHomeworks() {
        return this.homeworks;
    }
}