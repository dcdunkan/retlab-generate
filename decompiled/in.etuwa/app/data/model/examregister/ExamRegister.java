package in.etuwa.app.data.model.examregister;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExamRegister.kt */
/* loaded from: classes3.dex */
public final /* data */ class ExamRegister {
    private final String id;
    private final String name;

    public static /* synthetic */ ExamRegister copy$default(ExamRegister examRegister, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = examRegister.id;
        }
        if ((i & 2) != 0) {
            str2 = examRegister.name;
        }
        return examRegister.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final ExamRegister copy(String id, String name) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        return new ExamRegister(id, name);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExamRegister)) {
            return false;
        }
        ExamRegister examRegister = (ExamRegister) other;
        return Intrinsics.areEqual(this.id, examRegister.id) && Intrinsics.areEqual(this.name, examRegister.name);
    }

    public int hashCode() {
        return (this.id.hashCode() * 31) + this.name.hashCode();
    }

    public String toString() {
        return "ExamRegister(id=" + this.id + ", name=" + this.name + ")";
    }

    public ExamRegister(String id, String name) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        this.id = id;
        this.name = name;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }
}