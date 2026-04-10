package in.etuwa.app.data.model.subjectregistration;

import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SubjectRegistrationResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
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

    /* JADX INFO: renamed from: component1, reason: from getter */
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