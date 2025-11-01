package in.etuwa.app.data.model.mess;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MessTypeResponse.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007\u0012\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0005j\b\u0012\u0004\u0012\u00020\t`\u0007¢\u0006\u0002\u0010\nJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007HÆ\u0003J\u0019\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0005j\b\u0012\u0004\u0012\u00020\t`\u0007HÆ\u0003JG\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0005j\b\u0012\u0004\u0012\u00020\t`\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR!\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0005j\b\u0012\u0004\u0012\u00020\t`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\f¨\u0006\u001a"}, d2 = {"Lin/etuwa/app/data/model/mess/MessTypeResponse;", "", FirebaseAnalytics.Event.LOGIN, "", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/mess/MessData;", "Lkotlin/collections/ArrayList;", "type", "Lin/etuwa/app/data/model/mess/MessType;", "(ZLjava/util/ArrayList;Ljava/util/ArrayList;)V", "getData", "()Ljava/util/ArrayList;", "getLogin", "()Z", "getType", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class MessTypeResponse {
    private final ArrayList<MessData> data;
    private final boolean login;
    private final ArrayList<MessType> type;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MessTypeResponse copy$default(MessTypeResponse messTypeResponse, boolean z, ArrayList arrayList, ArrayList arrayList2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = messTypeResponse.login;
        }
        if ((i & 2) != 0) {
            arrayList = messTypeResponse.data;
        }
        if ((i & 4) != 0) {
            arrayList2 = messTypeResponse.type;
        }
        return messTypeResponse.copy(z, arrayList, arrayList2);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<MessData> component2() {
        return this.data;
    }

    public final ArrayList<MessType> component3() {
        return this.type;
    }

    public final MessTypeResponse copy(boolean login, ArrayList<MessData> data, ArrayList<MessType> type) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(type, "type");
        return new MessTypeResponse(login, data, type);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MessTypeResponse)) {
            return false;
        }
        MessTypeResponse messTypeResponse = (MessTypeResponse) other;
        return this.login == messTypeResponse.login && Intrinsics.areEqual(this.data, messTypeResponse.data) && Intrinsics.areEqual(this.type, messTypeResponse.type);
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
        return (((r0 * 31) + this.data.hashCode()) * 31) + this.type.hashCode();
    }

    public String toString() {
        return "MessTypeResponse(login=" + this.login + ", data=" + this.data + ", type=" + this.type + ")";
    }

    public MessTypeResponse(boolean z, ArrayList<MessData> data, ArrayList<MessType> type) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(type, "type");
        this.login = z;
        this.data = data;
        this.type = type;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<MessData> getData() {
        return this.data;
    }

    public final ArrayList<MessType> getType() {
        return this.type;
    }
}