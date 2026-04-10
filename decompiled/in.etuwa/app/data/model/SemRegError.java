package in.etuwa.app.data.model;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SemRegError.kt */
/* loaded from: classes3.dex */
public final /* data */ class SemRegError {
    private final ArrayList<String> semester_id;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SemRegError copy$default(SemRegError semRegError, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            arrayList = semRegError.semester_id;
        }
        return semRegError.copy(arrayList);
    }

    public final ArrayList<String> component1() {
        return this.semester_id;
    }

    public final SemRegError copy(ArrayList<String> semester_id) {
        Intrinsics.checkNotNullParameter(semester_id, "semester_id");
        return new SemRegError(semester_id);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof SemRegError) && Intrinsics.areEqual(this.semester_id, ((SemRegError) other).semester_id);
    }

    public int hashCode() {
        return this.semester_id.hashCode();
    }

    public String toString() {
        return "SemRegError(semester_id=" + this.semester_id + ")";
    }

    public SemRegError(ArrayList<String> semester_id) {
        Intrinsics.checkNotNullParameter(semester_id, "semester_id");
        this.semester_id = semester_id;
    }

    public final ArrayList<String> getSemester_id() {
        return this.semester_id;
    }
}