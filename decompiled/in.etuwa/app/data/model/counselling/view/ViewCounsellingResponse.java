package in.etuwa.app.data.model.counselling.view;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ViewCounsellingResponse.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t\u0012\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u0007j\b\u0012\u0004\u0012\u00020\u000b`\t¢\u0006\u0002\u0010\fR!\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u0007j\b\u0012\u0004\u0012\u00020\u000b`\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR&\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lin/etuwa/app/data/model/counselling/view/ViewCounsellingResponse;", "", FirebaseAnalytics.Event.LOGIN, "", "requests", "Lin/etuwa/app/data/model/counselling/view/ViewCounselling;", "cellMembers", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "actions", "Lin/etuwa/app/data/model/counselling/view/Actions2;", "(ZLin/etuwa/app/data/model/counselling/view/ViewCounselling;Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "getActions", "()Ljava/util/ArrayList;", "getCellMembers", "getLogin", "()Z", "getRequests", "()Lin/etuwa/app/data/model/counselling/view/ViewCounselling;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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