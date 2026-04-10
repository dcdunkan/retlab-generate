package in.etuwa.app.data.model.subjectregistration;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Subjects.kt */
/* loaded from: classes3.dex */
public final /* data */ class Subjects {
    private String ans;
    private final int id;
    private final String name;

    public static /* synthetic */ Subjects copy$default(Subjects subjects, int i, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = subjects.id;
        }
        if ((i2 & 2) != 0) {
            str = subjects.name;
        }
        if ((i2 & 4) != 0) {
            str2 = subjects.ans;
        }
        return subjects.copy(i, str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final String getAns() {
        return this.ans;
    }

    public final Subjects copy(int id, String name, String ans) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(ans, "ans");
        return new Subjects(id, name, ans);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Subjects)) {
            return false;
        }
        Subjects subjects = (Subjects) other;
        return this.id == subjects.id && Intrinsics.areEqual(this.name, subjects.name) && Intrinsics.areEqual(this.ans, subjects.ans);
    }

    public int hashCode() {
        return (((this.id * 31) + this.name.hashCode()) * 31) + this.ans.hashCode();
    }

    public String toString() {
        return "Subjects(id=" + this.id + ", name=" + this.name + ", ans=" + this.ans + ")";
    }

    public Subjects(int i, String name, String ans) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(ans, "ans");
        this.id = i;
        this.name = name;
        this.ans = ans;
    }

    public final int getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getAns() {
        return this.ans;
    }

    public final void setAns(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.ans = str;
    }
}