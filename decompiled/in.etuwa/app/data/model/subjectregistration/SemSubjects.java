package in.etuwa.app.data.model.subjectregistration;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ViewSubjectRegistrationResponse.kt */
/* loaded from: classes3.dex */
public final /* data */ class SemSubjects {
    private final String group;
    private final String mark;
    private final String subject_name;

    public static /* synthetic */ SemSubjects copy$default(SemSubjects semSubjects, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = semSubjects.subject_name;
        }
        if ((i & 2) != 0) {
            str2 = semSubjects.group;
        }
        if ((i & 4) != 0) {
            str3 = semSubjects.mark;
        }
        return semSubjects.copy(str, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getSubject_name() {
        return this.subject_name;
    }

    /* renamed from: component2, reason: from getter */
    public final String getGroup() {
        return this.group;
    }

    /* renamed from: component3, reason: from getter */
    public final String getMark() {
        return this.mark;
    }

    public final SemSubjects copy(String subject_name, String group, String mark) {
        Intrinsics.checkNotNullParameter(subject_name, "subject_name");
        Intrinsics.checkNotNullParameter(group, "group");
        Intrinsics.checkNotNullParameter(mark, "mark");
        return new SemSubjects(subject_name, group, mark);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SemSubjects)) {
            return false;
        }
        SemSubjects semSubjects = (SemSubjects) other;
        return Intrinsics.areEqual(this.subject_name, semSubjects.subject_name) && Intrinsics.areEqual(this.group, semSubjects.group) && Intrinsics.areEqual(this.mark, semSubjects.mark);
    }

    public int hashCode() {
        return (((this.subject_name.hashCode() * 31) + this.group.hashCode()) * 31) + this.mark.hashCode();
    }

    public String toString() {
        return "SemSubjects(subject_name=" + this.subject_name + ", group=" + this.group + ", mark=" + this.mark + ")";
    }

    public SemSubjects(String subject_name, String group, String mark) {
        Intrinsics.checkNotNullParameter(subject_name, "subject_name");
        Intrinsics.checkNotNullParameter(group, "group");
        Intrinsics.checkNotNullParameter(mark, "mark");
        this.subject_name = subject_name;
        this.group = group;
        this.mark = mark;
    }

    public final String getSubject_name() {
        return this.subject_name;
    }

    public final String getGroup() {
        return this.group;
    }

    public final String getMark() {
        return this.mark;
    }
}