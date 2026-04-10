package in.etuwa.app.data.model.assignment;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AssignmentResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
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
    private final boolean submit_by_link;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AssignmentResponse copy$default(AssignmentResponse assignmentResponse, boolean z, ArrayList arrayList, boolean z2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = assignmentResponse.login;
        }
        if ((i & 2) != 0) {
            arrayList = assignmentResponse.assignments;
        }
        if ((i & 4) != 0) {
            z2 = assignmentResponse.submit_by_link;
        }
        if ((i & 8) != 0) {
            str = assignmentResponse.error;
        }
        return assignmentResponse.copy(z, arrayList, z2, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<Assignment> component2() {
        return this.assignments;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getSubmit_by_link() {
        return this.submit_by_link;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getError() {
        return this.error;
    }

    public final AssignmentResponse copy(boolean login, ArrayList<Assignment> assignments, boolean submit_by_link, String error) {
        Intrinsics.checkNotNullParameter(assignments, "assignments");
        Intrinsics.checkNotNullParameter(error, "error");
        return new AssignmentResponse(login, assignments, submit_by_link, error);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AssignmentResponse)) {
            return false;
        }
        AssignmentResponse assignmentResponse = (AssignmentResponse) other;
        return this.login == assignmentResponse.login && Intrinsics.areEqual(this.assignments, assignmentResponse.assignments) && this.submit_by_link == assignmentResponse.submit_by_link && Intrinsics.areEqual(this.error, assignmentResponse.error);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    public int hashCode() {
        boolean z = this.login;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int iHashCode = ((r0 * 31) + this.assignments.hashCode()) * 31;
        boolean z2 = this.submit_by_link;
        return ((iHashCode + (z2 ? 1 : z2)) * 31) + this.error.hashCode();
    }

    public String toString() {
        return "AssignmentResponse(login=" + this.login + ", assignments=" + this.assignments + ", submit_by_link=" + this.submit_by_link + ", error=" + this.error + ")";
    }

    public AssignmentResponse(boolean z, ArrayList<Assignment> assignments, boolean z2, String error) {
        Intrinsics.checkNotNullParameter(assignments, "assignments");
        Intrinsics.checkNotNullParameter(error, "error");
        this.login = z;
        this.assignments = assignments;
        this.submit_by_link = z2;
        this.error = error;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<Assignment> getAssignments() {
        return this.assignments;
    }

    public final boolean getSubmit_by_link() {
        return this.submit_by_link;
    }

    public final String getError() {
        return this.error;
    }
}