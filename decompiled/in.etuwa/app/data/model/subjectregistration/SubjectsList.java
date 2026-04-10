package in.etuwa.app.data.model.subjectregistration;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SubjectsList.kt */
/* loaded from: classes3.dex */
public final /* data */ class SubjectsList {
    private final int id;
    private final String name;
    private final ArrayList<Subjects> subjects;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SubjectsList copy$default(SubjectsList subjectsList, ArrayList arrayList, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            arrayList = subjectsList.subjects;
        }
        if ((i2 & 2) != 0) {
            i = subjectsList.id;
        }
        if ((i2 & 4) != 0) {
            str = subjectsList.name;
        }
        return subjectsList.copy(arrayList, i, str);
    }

    public final ArrayList<Subjects> component1() {
        return this.subjects;
    }

    /* renamed from: component2, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final SubjectsList copy(ArrayList<Subjects> subjects, int id, String name) {
        Intrinsics.checkNotNullParameter(subjects, "subjects");
        Intrinsics.checkNotNullParameter(name, "name");
        return new SubjectsList(subjects, id, name);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SubjectsList)) {
            return false;
        }
        SubjectsList subjectsList = (SubjectsList) other;
        return Intrinsics.areEqual(this.subjects, subjectsList.subjects) && this.id == subjectsList.id && Intrinsics.areEqual(this.name, subjectsList.name);
    }

    public int hashCode() {
        return (((this.subjects.hashCode() * 31) + this.id) * 31) + this.name.hashCode();
    }

    public String toString() {
        return "SubjectsList(subjects=" + this.subjects + ", id=" + this.id + ", name=" + this.name + ")";
    }

    public SubjectsList(ArrayList<Subjects> subjects, int i, String name) {
        Intrinsics.checkNotNullParameter(subjects, "subjects");
        Intrinsics.checkNotNullParameter(name, "name");
        this.subjects = subjects;
        this.id = i;
        this.name = name;
    }

    public final ArrayList<Subjects> getSubjects() {
        return this.subjects;
    }

    public final int getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }
}