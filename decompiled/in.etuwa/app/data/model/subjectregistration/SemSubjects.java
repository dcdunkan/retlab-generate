package in.etuwa.app.data.model.subjectregistration;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ViewSubjectRegistrationResponse.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lin/etuwa/app/data/model/subjectregistration/SemSubjects;", "", "subject_name", "", "group", "mark", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getGroup", "()Ljava/lang/String;", "getMark", "getSubject_name", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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