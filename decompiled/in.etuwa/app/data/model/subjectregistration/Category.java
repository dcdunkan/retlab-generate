package in.etuwa.app.data.model.subjectregistration;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ViewSubjectRegistrationResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class Category {
    private final String name;
    private final ArrayList<Subject> subjects;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Category copy$default(Category category, String str, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            str = category.name;
        }
        if ((i & 2) != 0) {
            arrayList = category.subjects;
        }
        return category.copy(str, arrayList);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final ArrayList<Subject> component2() {
        return this.subjects;
    }

    public final Category copy(String name, ArrayList<Subject> subjects) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(subjects, "subjects");
        return new Category(name, subjects);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Category)) {
            return false;
        }
        Category category = (Category) other;
        return Intrinsics.areEqual(this.name, category.name) && Intrinsics.areEqual(this.subjects, category.subjects);
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + this.subjects.hashCode();
    }

    public String toString() {
        return "Category(name=" + this.name + ", subjects=" + this.subjects + ")";
    }

    public Category(String name, ArrayList<Subject> subjects) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(subjects, "subjects");
        this.name = name;
        this.subjects = subjects;
    }

    public final String getName() {
        return this.name;
    }

    public final ArrayList<Subject> getSubjects() {
        return this.subjects;
    }
}