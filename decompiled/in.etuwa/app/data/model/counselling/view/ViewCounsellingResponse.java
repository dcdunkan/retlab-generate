package in.etuwa.app.data.model.counselling.view;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ViewCounsellingResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ViewCounsellingResponse {
    private final ArrayList<Actions2> actions;

    @SerializedName("cell_members")
    private final ArrayList<String> cellMembers;
    private final boolean login;
    private final ViewCounselling requests;

    public ViewCounsellingResponse(boolean z, ViewCounselling requests, ArrayList<String> cellMembers, ArrayList<Actions2> actions) {
        Intrinsics.checkNotNullParameter(requests, "requests");
        Intrinsics.checkNotNullParameter(cellMembers, "cellMembers");
        Intrinsics.checkNotNullParameter(actions, "actions");
        this.login = z;
        this.requests = requests;
        this.cellMembers = cellMembers;
        this.actions = actions;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final ViewCounselling getRequests() {
        return this.requests;
    }

    public final ArrayList<String> getCellMembers() {
        return this.cellMembers;
    }

    public final ArrayList<Actions2> getActions() {
        return this.actions;
    }
}