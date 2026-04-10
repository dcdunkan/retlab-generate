package in.etuwa.app.data.model.result.tutorial;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TutorialResultResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class TutorialResultResponse {

    @SerializedName(Constants.IPC_BUNDLE_KEY_SEND_ERROR)
    @Expose
    private final String error;

    @SerializedName(FirebaseAnalytics.Event.LOGIN)
    @Expose
    private final boolean login;

    @SerializedName("tutorials")
    @Expose
    private final ArrayList<TutorialResult> tutorials;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TutorialResultResponse copy$default(TutorialResultResponse tutorialResultResponse, boolean z, ArrayList arrayList, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = tutorialResultResponse.login;
        }
        if ((i & 2) != 0) {
            arrayList = tutorialResultResponse.tutorials;
        }
        if ((i & 4) != 0) {
            str = tutorialResultResponse.error;
        }
        return tutorialResultResponse.copy(z, arrayList, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<TutorialResult> component2() {
        return this.tutorials;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getError() {
        return this.error;
    }

    public final TutorialResultResponse copy(boolean login, ArrayList<TutorialResult> tutorials, String error) {
        Intrinsics.checkNotNullParameter(tutorials, "tutorials");
        Intrinsics.checkNotNullParameter(error, "error");
        return new TutorialResultResponse(login, tutorials, error);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TutorialResultResponse)) {
            return false;
        }
        TutorialResultResponse tutorialResultResponse = (TutorialResultResponse) other;
        return this.login == tutorialResultResponse.login && Intrinsics.areEqual(this.tutorials, tutorialResultResponse.tutorials) && Intrinsics.areEqual(this.error, tutorialResultResponse.error);
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
        return (((r0 * 31) + this.tutorials.hashCode()) * 31) + this.error.hashCode();
    }

    public String toString() {
        return "TutorialResultResponse(login=" + this.login + ", tutorials=" + this.tutorials + ", error=" + this.error + ")";
    }

    public TutorialResultResponse(boolean z, ArrayList<TutorialResult> tutorials, String error) {
        Intrinsics.checkNotNullParameter(tutorials, "tutorials");
        Intrinsics.checkNotNullParameter(error, "error");
        this.login = z;
        this.tutorials = tutorials;
        this.error = error;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<TutorialResult> getTutorials() {
        return this.tutorials;
    }

    public final String getError() {
        return this.error;
    }
}