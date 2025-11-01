package in.etuwa.app.data.model.tutorial;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TutorialResponse.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007HÆ\u0003J\t\u0010\u0013\u001a\u00020\tHÆ\u0003J7\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\tHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR&\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lin/etuwa/app/data/model/tutorial/TutorialResponse;", "", FirebaseAnalytics.Event.LOGIN, "", "tutorials", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/tutorial/Tutorial;", "Lkotlin/collections/ArrayList;", "message", "", "(ZLjava/util/ArrayList;Ljava/lang/String;)V", "getLogin", "()Z", "getMessage", "()Ljava/lang/String;", "getTutorials", "()Ljava/util/ArrayList;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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

    /* renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<Tutorial> component2() {
        return this.tutorials;
    }

    /* renamed from: component3, reason: from getter */
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