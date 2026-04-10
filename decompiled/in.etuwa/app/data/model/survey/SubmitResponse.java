package in.etuwa.app.data.model.survey;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SubmitResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class SubmitResponse {
    private final String response;
    private final String status;

    public static /* synthetic */ SubmitResponse copy$default(SubmitResponse submitResponse, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = submitResponse.status;
        }
        if ((i & 2) != 0) {
            str2 = submitResponse.response;
        }
        return submitResponse.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getResponse() {
        return this.response;
    }

    public final SubmitResponse copy(String status, String response) {
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(response, "response");
        return new SubmitResponse(status, response);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SubmitResponse)) {
            return false;
        }
        SubmitResponse submitResponse = (SubmitResponse) other;
        return Intrinsics.areEqual(this.status, submitResponse.status) && Intrinsics.areEqual(this.response, submitResponse.response);
    }

    public int hashCode() {
        return (this.status.hashCode() * 31) + this.response.hashCode();
    }

    public String toString() {
        return "SubmitResponse(status=" + this.status + ", response=" + this.response + ")";
    }

    public SubmitResponse(String status, String response) {
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(response, "response");
        this.status = status;
        this.response = response;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getResponse() {
        return this.response;
    }
}