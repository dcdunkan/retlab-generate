package in.etuwa.app.data.model.subjectregistration;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SubjectSpinner.kt */
/* loaded from: classes3.dex */
public final /* data */ class SubjectSpinner {
    private final int id;
    private final String name;

    public static /* synthetic */ SubjectSpinner copy$default(SubjectSpinner subjectSpinner, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = subjectSpinner.id;
        }
        if ((i2 & 2) != 0) {
            str = subjectSpinner.name;
        }
        return subjectSpinner.copy(i, str);
    }

    /* renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final SubjectSpinner copy(int id, String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new SubjectSpinner(id, name);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SubjectSpinner)) {
            return false;
        }
        SubjectSpinner subjectSpinner = (SubjectSpinner) other;
        return this.id == subjectSpinner.id && Intrinsics.areEqual(this.name, subjectSpinner.name);
    }

    public int hashCode() {
        return (this.id * 31) + this.name.hashCode();
    }

    public String toString() {
        return "SubjectSpinner(id=" + this.id + ", name=" + this.name + ")";
    }

    public SubjectSpinner(int i, String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.id = i;
        this.name = name;
    }

    public final int getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }
}