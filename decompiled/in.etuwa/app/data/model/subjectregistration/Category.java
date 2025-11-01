package in.etuwa.app.data.model.subjectregistration;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ViewSubjectRegistrationResponse.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\u0002\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lin/etuwa/app/data/model/subjectregistration/Category;", "", "name", "", "subjects", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/subjectregistration/Subject;", "Lkotlin/collections/ArrayList;", "(Ljava/lang/String;Ljava/util/ArrayList;)V", "getName", "()Ljava/lang/String;", "getSubjects", "()Ljava/util/ArrayList;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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

    /* renamed from: component1, reason: from getter */
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