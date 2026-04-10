package in.etuwa.app.data.model.message;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MsgHandleRequest.kt */
/* loaded from: classes3.dex */
public final /* data */ class MsgHandleRequest {

    @SerializedName("id")
    @Expose
    private final String id;

    public static /* synthetic */ MsgHandleRequest copy$default(MsgHandleRequest msgHandleRequest, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = msgHandleRequest.id;
        }
        return msgHandleRequest.copy(str);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    public final MsgHandleRequest copy(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return new MsgHandleRequest(id);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof MsgHandleRequest) && Intrinsics.areEqual(this.id, ((MsgHandleRequest) other).id);
    }

    public int hashCode() {
        return this.id.hashCode();
    }

    public String toString() {
        return "MsgHandleRequest(id=" + this.id + ")";
    }

    public MsgHandleRequest(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.id = id;
    }

    public final String getId() {
        return this.id;
    }
}