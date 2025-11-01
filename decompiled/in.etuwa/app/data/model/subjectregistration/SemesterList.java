package in.etuwa.app.data.model.subjectregistration;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ViewSubjectRegistrationResponse.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u0012\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b¢\u0006\u0002\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bHÆ\u0003J\u0019\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bHÆ\u0003JQ\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b2\u0018\b\u0002\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R!\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR!\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u001c"}, d2 = {"Lin/etuwa/app/data/model/subjectregistration/SemesterList;", "", "seme_pos", "", "sgpa", "minor_subjects", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/subjectregistration/SemSubjects;", "Lkotlin/collections/ArrayList;", "mdc_subjects", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "getMdc_subjects", "()Ljava/util/ArrayList;", "getMinor_subjects", "getSeme_pos", "()Ljava/lang/String;", "getSgpa", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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

    /* renamed from: component1, reason: from getter */
    public final String getSeme_pos() {
        return this.seme_pos;
    }

    /* renamed from: component2, reason: from getter */
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