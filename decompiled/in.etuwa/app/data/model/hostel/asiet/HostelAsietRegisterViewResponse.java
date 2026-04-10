package in.etuwa.app.data.model.hostel.asiet;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HostelAsietRegisterViewResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class HostelAsietRegisterViewResponse {
    private final String admission_no;
    private final String batch;
    private final ArrayList<AsietBoarding> boardings;
    private final String declaration;
    private final String full_name;
    private final ArrayList<History> history;
    private final boolean login;
    private final String note;
    private final String route_url;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getAdmission_no() {
        return this.admission_no;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getFull_name() {
        return this.full_name;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getBatch() {
        return this.batch;
    }

    public final ArrayList<AsietBoarding> component5() {
        return this.boardings;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getRoute_url() {
        return this.route_url;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getDeclaration() {
        return this.declaration;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getNote() {
        return this.note;
    }

    public final ArrayList<History> component9() {
        return this.history;
    }

    public final HostelAsietRegisterViewResponse copy(boolean login, String admission_no, String full_name, String batch, ArrayList<AsietBoarding> boardings, String route_url, String declaration, String note, ArrayList<History> history) {
        Intrinsics.checkNotNullParameter(admission_no, "admission_no");
        Intrinsics.checkNotNullParameter(full_name, "full_name");
        Intrinsics.checkNotNullParameter(batch, "batch");
        Intrinsics.checkNotNullParameter(boardings, "boardings");
        Intrinsics.checkNotNullParameter(route_url, "route_url");
        Intrinsics.checkNotNullParameter(declaration, "declaration");
        Intrinsics.checkNotNullParameter(note, "note");
        Intrinsics.checkNotNullParameter(history, "history");
        return new HostelAsietRegisterViewResponse(login, admission_no, full_name, batch, boardings, route_url, declaration, note, history);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HostelAsietRegisterViewResponse)) {
            return false;
        }
        HostelAsietRegisterViewResponse hostelAsietRegisterViewResponse = (HostelAsietRegisterViewResponse) other;
        return this.login == hostelAsietRegisterViewResponse.login && Intrinsics.areEqual(this.admission_no, hostelAsietRegisterViewResponse.admission_no) && Intrinsics.areEqual(this.full_name, hostelAsietRegisterViewResponse.full_name) && Intrinsics.areEqual(this.batch, hostelAsietRegisterViewResponse.batch) && Intrinsics.areEqual(this.boardings, hostelAsietRegisterViewResponse.boardings) && Intrinsics.areEqual(this.route_url, hostelAsietRegisterViewResponse.route_url) && Intrinsics.areEqual(this.declaration, hostelAsietRegisterViewResponse.declaration) && Intrinsics.areEqual(this.note, hostelAsietRegisterViewResponse.note) && Intrinsics.areEqual(this.history, hostelAsietRegisterViewResponse.history);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    public int hashCode() {
        boolean z = this.login;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (((((((((((((((r0 * 31) + this.admission_no.hashCode()) * 31) + this.full_name.hashCode()) * 31) + this.batch.hashCode()) * 31) + this.boardings.hashCode()) * 31) + this.route_url.hashCode()) * 31) + this.declaration.hashCode()) * 31) + this.note.hashCode()) * 31) + this.history.hashCode();
    }

    public String toString() {
        return "HostelAsietRegisterViewResponse(login=" + this.login + ", admission_no=" + this.admission_no + ", full_name=" + this.full_name + ", batch=" + this.batch + ", boardings=" + this.boardings + ", route_url=" + this.route_url + ", declaration=" + this.declaration + ", note=" + this.note + ", history=" + this.history + ")";
    }

    public HostelAsietRegisterViewResponse(boolean z, String admission_no, String full_name, String batch, ArrayList<AsietBoarding> boardings, String route_url, String declaration, String note, ArrayList<History> history) {
        Intrinsics.checkNotNullParameter(admission_no, "admission_no");
        Intrinsics.checkNotNullParameter(full_name, "full_name");
        Intrinsics.checkNotNullParameter(batch, "batch");
        Intrinsics.checkNotNullParameter(boardings, "boardings");
        Intrinsics.checkNotNullParameter(route_url, "route_url");
        Intrinsics.checkNotNullParameter(declaration, "declaration");
        Intrinsics.checkNotNullParameter(note, "note");
        Intrinsics.checkNotNullParameter(history, "history");
        this.login = z;
        this.admission_no = admission_no;
        this.full_name = full_name;
        this.batch = batch;
        this.boardings = boardings;
        this.route_url = route_url;
        this.declaration = declaration;
        this.note = note;
        this.history = history;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final String getAdmission_no() {
        return this.admission_no;
    }

    public final String getFull_name() {
        return this.full_name;
    }

    public final String getBatch() {
        return this.batch;
    }

    public final ArrayList<AsietBoarding> getBoardings() {
        return this.boardings;
    }

    public final String getRoute_url() {
        return this.route_url;
    }

    public final String getDeclaration() {
        return this.declaration;
    }

    public final String getNote() {
        return this.note;
    }

    public final ArrayList<History> getHistory() {
        return this.history;
    }
}