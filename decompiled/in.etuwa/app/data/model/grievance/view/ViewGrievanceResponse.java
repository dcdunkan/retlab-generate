package in.etuwa.app.data.model.grievance.view;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ViewGrievanceResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ViewGrievanceResponse {
    private final ArrayList<Actions> actions;

    @SerializedName("cellmembers")
    private final ArrayList<String> cellMembers;
    private final ViewGrievance grievance;
    private final boolean login;

    public ViewGrievanceResponse(boolean z, ViewGrievance grievance, ArrayList<String> cellMembers, ArrayList<Actions> actions) {
        Intrinsics.checkNotNullParameter(grievance, "grievance");
        Intrinsics.checkNotNullParameter(cellMembers, "cellMembers");
        Intrinsics.checkNotNullParameter(actions, "actions");
        this.login = z;
        this.grievance = grievance;
        this.cellMembers = cellMembers;
        this.actions = actions;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final ViewGrievance getGrievance() {
        return this.grievance;
    }

    public final ArrayList<String> getCellMembers() {
        return this.cellMembers;
    }

    public final ArrayList<Actions> getActions() {
        return this.actions;
    }
}