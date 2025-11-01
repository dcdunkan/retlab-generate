package in.etuwa.app.data.model.subjectregistration;

import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SubjectRegistrationResponse.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\u0002\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lin/etuwa/app/data/model/subjectregistration/SubjectRegistrationResponse;", "", Constants.IPC_BUNDLE_KEY_SEND_ERROR, "", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/subjectregistration/SubjectRegistration;", "Lkotlin/collections/ArrayList;", "(Ljava/lang/String;Ljava/util/ArrayList;)V", "getData", "()Ljava/util/ArrayList;", "getError", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class SubjectRegistrationResponse {
    private final ArrayList<SubjectRegistration> data;
    private final String error;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SubjectRegistrationResponse copy$default(SubjectRegistrationResponse subjectRegistrationResponse, String str, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            str = subjectRegistrationResponse.error;
        }
        if ((i & 2) != 0) {
            arrayList = subjectRegistrationResponse.data;
        }
        return subjectRegistrationResponse.copy(str, arrayList);
    }

    /* renamed from: component1, reason: from getter */
    public final String getError() {
        return this.error;
    }

    public final ArrayList<SubjectRegistration> component2() {
        return this.data;
    }

    public final SubjectRegistrationResponse copy(String error, ArrayList<SubjectRegistration> data) {
        Intrinsics.checkNotNullParameter(error, "error");
        Intrinsics.checkNotNullParameter(data, "data");
        return new SubjectRegistrationResponse(error, data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SubjectRegistrationResponse)) {
            return false;
        }
        SubjectRegistrationResponse subjectRegistrationResponse = (SubjectRegistrationResponse) other;
        return Intrinsics.areEqual(this.error, subjectRegistrationResponse.error) && Intrinsics.areEqual(this.data, subjectRegistrationResponse.data);
    }

    public int hashCode() {
        return (this.error.hashCode() * 31) + this.data.hashCode();
    }

    public String toString() {
        return "SubjectRegistrationResponse(error=" + this.error + ", data=" + this.data + ")";
    }

    public SubjectRegistrationResponse(String error, ArrayList<SubjectRegistration> data) {
        Intrinsics.checkNotNullParameter(error, "error");
        Intrinsics.checkNotNullParameter(data, "data");
        this.error = error;
        this.data = data;
    }

    public final String getError() {
        return this.error;
    }

    public final ArrayList<SubjectRegistration> getData() {
        return this.data;
    }
}