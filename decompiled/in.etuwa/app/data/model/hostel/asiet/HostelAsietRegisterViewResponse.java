package in.etuwa.app.data.model.hostel.asiet;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HostelAsietRegisterViewResponse.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bm\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00100\tj\b\u0012\u0004\u0012\u00020\u0010`\u000b¢\u0006\u0002\u0010\u0011J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\u0019\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bHÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\u0019\u0010&\u001a\u0012\u0012\u0004\u0012\u00020\u00100\tj\b\u0012\u0004\u0012\u00020\u0010`\u000bHÆ\u0003J\u0083\u0001\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\u0018\b\u0002\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00100\tj\b\u0012\u0004\u0012\u00020\u0010`\u000bHÆ\u0001J\u0013\u0010(\u001a\u00020\u00032\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020+HÖ\u0001J\t\u0010,\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R!\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R!\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00100\tj\b\u0012\u0004\u0012\u00020\u0010`\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013¨\u0006-"}, d2 = {"Lin/etuwa/app/data/model/hostel/asiet/HostelAsietRegisterViewResponse;", "", FirebaseAnalytics.Event.LOGIN, "", "admission_no", "", "full_name", "batch", "boardings", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/hostel/asiet/AsietBoarding;", "Lkotlin/collections/ArrayList;", "route_url", "declaration", "note", "history", "Lin/etuwa/app/data/model/hostel/asiet/History;", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V", "getAdmission_no", "()Ljava/lang/String;", "getBatch", "getBoardings", "()Ljava/util/ArrayList;", "getDeclaration", "getFull_name", "getHistory", "getLogin", "()Z", "getNote", "getRoute_url", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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

    /* renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAdmission_no() {
        return this.admission_no;
    }

    /* renamed from: component3, reason: from getter */
    public final String getFull_name() {
        return this.full_name;
    }

    /* renamed from: component4, reason: from getter */
    public final String getBatch() {
        return this.batch;
    }

    public final ArrayList<AsietBoarding> component5() {
        return this.boardings;
    }

    /* renamed from: component6, reason: from getter */
    public final String getRoute_url() {
        return this.route_url;
    }

    /* renamed from: component7, reason: from getter */
    public final String getDeclaration() {
        return this.declaration;
    }

    /* renamed from: component8, reason: from getter */
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