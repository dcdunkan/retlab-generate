package in.etuwa.app.data.model.subjectregistration;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ViewSubjectRegistrationResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class SemesterList {
    private final ArrayList<SemSubjects> mdc_subjects;
    private final ArrayList<SemSubjects> minor_subjects;
    private final String seme_pos;
    private final String sgpa;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SemesterList copy$default(SemesterList semesterList, String str, String str2, ArrayList arrayList, ArrayList arrayList2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = semesterList.seme_pos;
        }
        if ((i & 2) != 0) {
            str2 = semesterList.sgpa;
        }
        if ((i & 4) != 0) {
            arrayList = semesterList.minor_subjects;
        }
        if ((i & 8) != 0) {
            arrayList2 = semesterList.mdc_subjects;
        }
        return semesterList.copy(str, str2, arrayList, arrayList2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSeme_pos() {
        return this.seme_pos;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSgpa() {
        return this.sgpa;
    }

    public final ArrayList<SemSubjects> component3() {
        return this.minor_subjects;
    }

    public final ArrayList<SemSubjects> component4() {
        return this.mdc_subjects;
    }

    public final SemesterList copy(String seme_pos, String sgpa, ArrayList<SemSubjects> minor_subjects, ArrayList<SemSubjects> mdc_subjects) {
        Intrinsics.checkNotNullParameter(seme_pos, "seme_pos");
        Intrinsics.checkNotNullParameter(sgpa, "sgpa");
        Intrinsics.checkNotNullParameter(minor_subjects, "minor_subjects");
        Intrinsics.checkNotNullParameter(mdc_subjects, "mdc_subjects");
        return new SemesterList(seme_pos, sgpa, minor_subjects, mdc_subjects);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SemesterList)) {
            return false;
        }
        SemesterList semesterList = (SemesterList) other;
        return Intrinsics.areEqual(this.seme_pos, semesterList.seme_pos) && Intrinsics.areEqual(this.sgpa, semesterList.sgpa) && Intrinsics.areEqual(this.minor_subjects, semesterList.minor_subjects) && Intrinsics.areEqual(this.mdc_subjects, semesterList.mdc_subjects);
    }

    public int hashCode() {
        return (((((this.seme_pos.hashCode() * 31) + this.sgpa.hashCode()) * 31) + this.minor_subjects.hashCode()) * 31) + this.mdc_subjects.hashCode();
    }

    public String toString() {
        return "SemesterList(seme_pos=" + this.seme_pos + ", sgpa=" + this.sgpa + ", minor_subjects=" + this.minor_subjects + ", mdc_subjects=" + this.mdc_subjects + ")";
    }

    public SemesterList(String seme_pos, String sgpa, ArrayList<SemSubjects> minor_subjects, ArrayList<SemSubjects> mdc_subjects) {
        Intrinsics.checkNotNullParameter(seme_pos, "seme_pos");
        Intrinsics.checkNotNullParameter(sgpa, "sgpa");
        Intrinsics.checkNotNullParameter(minor_subjects, "minor_subjects");
        Intrinsics.checkNotNullParameter(mdc_subjects, "mdc_subjects");
        this.seme_pos = seme_pos;
        this.sgpa = sgpa;
        this.minor_subjects = minor_subjects;
        this.mdc_subjects = mdc_subjects;
    }

    public final String getSeme_pos() {
        return this.seme_pos;
    }

    public final String getSgpa() {
        return this.sgpa;
    }

    public final ArrayList<SemSubjects> getMinor_subjects() {
        return this.minor_subjects;
    }

    public final ArrayList<SemSubjects> getMdc_subjects() {
        return this.mdc_subjects;
    }
}