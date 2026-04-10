package in.etuwa.app.data.model.transportpalai.registration;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RegisterViewResponse.kt */
/* loaded from: classes3.dex */
public final /* data */ class RegisterViewResponse {
    private final String admission_no;
    private final String batch;
    private final ArrayList<Boardings> boardings;
    private final String full_name;
    private final ArrayList<History> history;
    private final boolean login;

    public static /* synthetic */ RegisterViewResponse copy$default(RegisterViewResponse registerViewResponse, boolean z, String str, String str2, String str3, ArrayList arrayList, ArrayList arrayList2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = registerViewResponse.login;
        }
        if ((i & 2) != 0) {
            str = registerViewResponse.admission_no;
        }
        String str4 = str;
        if ((i & 4) != 0) {
            str2 = registerViewResponse.full_name;
        }
        String str5 = str2;
        if ((i & 8) != 0) {
            str3 = registerViewResponse.batch;
        }
        String str6 = str3;
        if ((i & 16) != 0) {
            arrayList = registerViewResponse.boardings;
        }
        ArrayList arrayList3 = arrayList;
        if ((i & 32) != 0) {
            arrayList2 = registerViewResponse.history;
        }
        return registerViewResponse.copy(z, str4, str5, str6, arrayList3, arrayList2);
    }

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

    public final ArrayList<Boardings> component5() {
        return this.boardings;
    }

    public final ArrayList<History> component6() {
        return this.history;
    }

    public final RegisterViewResponse copy(boolean login, String admission_no, String full_name, String batch, ArrayList<Boardings> boardings, ArrayList<History> history) {
        Intrinsics.checkNotNullParameter(admission_no, "admission_no");
        Intrinsics.checkNotNullParameter(full_name, "full_name");
        Intrinsics.checkNotNullParameter(batch, "batch");
        Intrinsics.checkNotNullParameter(boardings, "boardings");
        Intrinsics.checkNotNullParameter(history, "history");
        return new RegisterViewResponse(login, admission_no, full_name, batch, boardings, history);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RegisterViewResponse)) {
            return false;
        }
        RegisterViewResponse registerViewResponse = (RegisterViewResponse) other;
        return this.login == registerViewResponse.login && Intrinsics.areEqual(this.admission_no, registerViewResponse.admission_no) && Intrinsics.areEqual(this.full_name, registerViewResponse.full_name) && Intrinsics.areEqual(this.batch, registerViewResponse.batch) && Intrinsics.areEqual(this.boardings, registerViewResponse.boardings) && Intrinsics.areEqual(this.history, registerViewResponse.history);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    public int hashCode() {
        boolean z = this.login;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (((((((((r0 * 31) + this.admission_no.hashCode()) * 31) + this.full_name.hashCode()) * 31) + this.batch.hashCode()) * 31) + this.boardings.hashCode()) * 31) + this.history.hashCode();
    }

    public String toString() {
        return "RegisterViewResponse(login=" + this.login + ", admission_no=" + this.admission_no + ", full_name=" + this.full_name + ", batch=" + this.batch + ", boardings=" + this.boardings + ", history=" + this.history + ")";
    }

    public RegisterViewResponse(boolean z, String admission_no, String full_name, String batch, ArrayList<Boardings> boardings, ArrayList<History> history) {
        Intrinsics.checkNotNullParameter(admission_no, "admission_no");
        Intrinsics.checkNotNullParameter(full_name, "full_name");
        Intrinsics.checkNotNullParameter(batch, "batch");
        Intrinsics.checkNotNullParameter(boardings, "boardings");
        Intrinsics.checkNotNullParameter(history, "history");
        this.login = z;
        this.admission_no = admission_no;
        this.full_name = full_name;
        this.batch = batch;
        this.boardings = boardings;
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

    public final ArrayList<Boardings> getBoardings() {
        return this.boardings;
    }

    public final ArrayList<History> getHistory() {
        return this.history;
    }
}