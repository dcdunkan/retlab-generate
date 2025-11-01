package in.etuwa.app.data.model.transportpalai.registration;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RegisterViewResponse.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b\u0012\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\r0\tj\b\u0012\u0004\u0012\u00020\r`\u000b¢\u0006\u0002\u0010\u000eJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\u0019\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bHÆ\u0003J\u0019\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\r0\tj\b\u0012\u0004\u0012\u00020\r`\u000bHÆ\u0003Je\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b2\u0018\b\u0002\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\r0\tj\b\u0012\u0004\u0012\u00020\r`\u000bHÆ\u0001J\u0013\u0010\u001f\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R!\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R!\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\r0\tj\b\u0012\u0004\u0012\u00020\r`\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006$"}, d2 = {"Lin/etuwa/app/data/model/transportpalai/registration/RegisterViewResponse;", "", FirebaseAnalytics.Event.LOGIN, "", "admission_no", "", "full_name", "batch", "boardings", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/transportpalai/registration/Boardings;", "Lkotlin/collections/ArrayList;", "history", "Lin/etuwa/app/data/model/transportpalai/registration/History;", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "getAdmission_no", "()Ljava/lang/String;", "getBatch", "getBoardings", "()Ljava/util/ArrayList;", "getFull_name", "getHistory", "getLogin", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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