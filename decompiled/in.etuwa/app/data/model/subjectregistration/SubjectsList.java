package in.etuwa.app.data.model.subjectregistration;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SubjectsList.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0019\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0013\u001a\u00020\tHÆ\u0003J7\u0010\u0014\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0019\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lin/etuwa/app/data/model/subjectregistration/SubjectsList;", "", "subjects", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/subjectregistration/Subjects;", "Lkotlin/collections/ArrayList;", "id", "", "name", "", "(Ljava/util/ArrayList;ILjava/lang/String;)V", "getId", "()I", "getName", "()Ljava/lang/String;", "getSubjects", "()Ljava/util/ArrayList;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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