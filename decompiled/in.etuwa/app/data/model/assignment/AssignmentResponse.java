package in.etuwa.app.data.model.assignment;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AssignmentResponse.kt */
/* loaded from: classes3.dex */
public final /* data */ class AssignmentResponse {

    @SerializedName("assignments")
    @Expose
    private final ArrayList<Assignment> assignments;

    @SerializedName(Constants.IPC_BUNDLE_KEY_SEND_ERROR)
    @Expose
    private final String error;

    @SerializedName(FirebaseAnalytics.Event.LOGIN)
    @Expose
    private final boolean login;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AssignmentResponse copy$default(AssignmentResponse assignmentResponse, boolean z, ArrayList arrayList, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = assignmentResponse.login;
        }
        if ((i & 2) != 0) {
            arrayList = assignmentResponse.assignments;
        }
        if ((i & 4) != 0) {
            str = assignmentResponse.error;
        }
        return assignmentResponse.copy(z, arrayList, str);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<Assignment> component2() {
        return this.assignments;
    }

    /* renamed from: component3, reason: from getter */
    public final String getError() {
        return this.error;
    }

    public final AssignmentResponse copy(boolean login, ArrayList<Assignment> assignments, String error) {
        Intrinsics.checkNotNullParameter(assignments, "assignments");
        Intrinsics.checkNotNullParameter(error, "error");
        return new AssignmentResponse(login, assignments, error);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AssignmentResponse)) {
            return false;
        }
        AssignmentResponse assignmentResponse = (AssignmentResponse) other;
        return this.login == assignmentResponse.login && Intrinsics.areEqual(this.assignments, assignmentResponse.assignments) && Intrinsics.areEqual(this.error, assignmentResponse.error);
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
        return (((r0 * 31) + this.assignments.hashCode()) * 31) + this.error.hashCode();
    }

    public String toString() {
        return "AssignmentResponse(login=" + this.login + ", assignments=" + this.assignments + ", error=" + this.error + ")";
    }

    public AssignmentResponse(boolean z, ArrayList<Assignment> assignments, String error) {
        Intrinsics.checkNotNullParameter(assignments, "assignments");
        Intrinsics.checkNotNullParameter(error, "error");
        this.login = z;
        this.assignments = assignments;
        this.error = error;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<Assignment> getAssignments() {
        return this.assignments;
    }

    public final String getError() {
        return this.error;
    }
}