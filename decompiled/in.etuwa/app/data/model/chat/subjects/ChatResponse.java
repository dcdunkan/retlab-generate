package in.etuwa.app.data.model.chat.subjects;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ChatResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class ChatResponse {

    @SerializedName(Constants.IPC_BUNDLE_KEY_SEND_ERROR)
    @Expose
    private final String error;

    @SerializedName(FirebaseAnalytics.Event.LOGIN)
    @Expose
    private final boolean login;

    @SerializedName("subjects")
    @Expose
    private final ArrayList<Chat> subjects;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ChatResponse copy$default(ChatResponse chatResponse, boolean z, ArrayList arrayList, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = chatResponse.login;
        }
        if ((i & 2) != 0) {
            arrayList = chatResponse.subjects;
        }
        if ((i & 4) != 0) {
            str = chatResponse.error;
        }
        return chatResponse.copy(z, arrayList, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<Chat> component2() {
        return this.subjects;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getError() {
        return this.error;
    }

    public final ChatResponse copy(boolean login, ArrayList<Chat> subjects, String error) {
        Intrinsics.checkNotNullParameter(subjects, "subjects");
        Intrinsics.checkNotNullParameter(error, "error");
        return new ChatResponse(login, subjects, error);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChatResponse)) {
            return false;
        }
        ChatResponse chatResponse = (ChatResponse) other;
        return this.login == chatResponse.login && Intrinsics.areEqual(this.subjects, chatResponse.subjects) && Intrinsics.areEqual(this.error, chatResponse.error);
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
        return (((r0 * 31) + this.subjects.hashCode()) * 31) + this.error.hashCode();
    }

    public String toString() {
        return "ChatResponse(login=" + this.login + ", subjects=" + this.subjects + ", error=" + this.error + ")";
    }

    public ChatResponse(boolean z, ArrayList<Chat> subjects, String error) {
        Intrinsics.checkNotNullParameter(subjects, "subjects");
        Intrinsics.checkNotNullParameter(error, "error");
        this.login = z;
        this.subjects = subjects;
        this.error = error;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<Chat> getSubjects() {
        return this.subjects;
    }

    public final String getError() {
        return this.error;
    }
}