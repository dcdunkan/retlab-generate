package in.etuwa.app.data.model.survey;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SubmitResponse.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lin/etuwa/app/data/model/survey/SubmitResponse;", "", NotificationCompat.CATEGORY_STATUS, "", "response", "(Ljava/lang/String;Ljava/lang/String;)V", "getResponse", "()Ljava/lang/String;", "getStatus", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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

    /* renamed from: component1, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: component2, reason: from getter */
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