package in.etuwa.app.data.model.profileasiet.achievements;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AchievementsResponse.kt */
/* loaded from: classes3.dex */
public final /* data */ class AchievementsResponse {
    private final ArrayList<Achievements> achievement;
    private final boolean login;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AchievementsResponse copy$default(AchievementsResponse achievementsResponse, boolean z, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            z = achievementsResponse.login;
        }
        if ((i & 2) != 0) {
            arrayList = achievementsResponse.achievement;
        }
        return achievementsResponse.copy(z, arrayList);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<Achievements> component2() {
        return this.achievement;
    }

    public final AchievementsResponse copy(boolean login, ArrayList<Achievements> achievement) {
        Intrinsics.checkNotNullParameter(achievement, "achievement");
        return new AchievementsResponse(login, achievement);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AchievementsResponse)) {
            return false;
        }
        AchievementsResponse achievementsResponse = (AchievementsResponse) other;
        return this.login == achievementsResponse.login && Intrinsics.areEqual(this.achievement, achievementsResponse.achievement);
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
        return (r0 * 31) + this.achievement.hashCode();
    }

    public String toString() {
        return "AchievementsResponse(login=" + this.login + ", achievement=" + this.achievement + ")";
    }

    public AchievementsResponse(boolean z, ArrayList<Achievements> achievement) {
        Intrinsics.checkNotNullParameter(achievement, "achievement");
        this.login = z;
        this.achievement = achievement;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<Achievements> getAchievement() {
        return this.achievement;
    }
}