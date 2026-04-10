package in.etuwa.app.data.model.subject.syllabus;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SyllabusResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class SyllabusResponse {
    private final ArrayList<Syllabus> syllabus;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SyllabusResponse copy$default(SyllabusResponse syllabusResponse, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            arrayList = syllabusResponse.syllabus;
        }
        return syllabusResponse.copy(arrayList);
    }

    public final ArrayList<Syllabus> component1() {
        return this.syllabus;
    }

    public final SyllabusResponse copy(ArrayList<Syllabus> syllabus) {
        Intrinsics.checkNotNullParameter(syllabus, "syllabus");
        return new SyllabusResponse(syllabus);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof SyllabusResponse) && Intrinsics.areEqual(this.syllabus, ((SyllabusResponse) other).syllabus);
    }

    public int hashCode() {
        return this.syllabus.hashCode();
    }

    public String toString() {
        return "SyllabusResponse(syllabus=" + this.syllabus + ")";
    }

    public SyllabusResponse(ArrayList<Syllabus> syllabus) {
        Intrinsics.checkNotNullParameter(syllabus, "syllabus");
        this.syllabus = syllabus;
    }

    public final ArrayList<Syllabus> getSyllabus() {
        return this.syllabus;
    }
}