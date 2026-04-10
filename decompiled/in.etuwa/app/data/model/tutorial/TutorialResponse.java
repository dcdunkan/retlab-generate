package in.etuwa.app.data.model.tutorial;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TutorialResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class TutorialResponse {

    @SerializedName(FirebaseAnalytics.Event.LOGIN)
    @Expose
    private final boolean login;

    @SerializedName("message")
    @Expose
    private final String message;

    @SerializedName("tutorials")
    @Expose
    private final ArrayList<Tutorial> tutorials;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TutorialResponse copy$default(TutorialResponse tutorialResponse, boolean z, ArrayList arrayList, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = tutorialResponse.login;
        }
        if ((i & 2) != 0) {
            arrayList = tutorialResponse.tutorials;
        }
        if ((i & 4) != 0) {
            str = tutorialResponse.message;
        }
        return tutorialResponse.copy(z, arrayList, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<Tutorial> component2() {
        return this.tutorials;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    public final TutorialResponse copy(boolean login, ArrayList<Tutorial> tutorials, String message) {
        Intrinsics.checkNotNullParameter(tutorials, "tutorials");
        Intrinsics.checkNotNullParameter(message, "message");
        return new TutorialResponse(login, tutorials, message);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TutorialResponse)) {
            return false;
        }
        TutorialResponse tutorialResponse = (TutorialResponse) other;
        return this.login == tutorialResponse.login && Intrinsics.areEqual(this.tutorials, tutorialResponse.tutorials) && Intrinsics.areEqual(this.message, tutorialResponse.message);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z = this.login;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (((r0 * 31) + this.tutorials.hashCode()) * 31) + this.message.hashCode();
    }

    public String toString() {
        return "TutorialResponse(login=" + this.login + ", tutorials=" + this.tutorials + ", message=" + this.message + ")";
    }

    public TutorialResponse(boolean z, ArrayList<Tutorial> tutorials, String message) {
        Intrinsics.checkNotNullParameter(tutorials, "tutorials");
        Intrinsics.checkNotNullParameter(message, "message");
        this.login = z;
        this.tutorials = tutorials;
        this.message = message;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<Tutorial> getTutorials() {
        return this.tutorials;
    }

    public final String getMessage() {
        return this.message;
    }
}