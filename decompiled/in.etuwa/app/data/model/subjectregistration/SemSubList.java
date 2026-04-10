package in.etuwa.app.data.model.subjectregistration;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SemSubList.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class SemSubList {
    private String ans;
    private final int id;
    private final String name;

    public static /* synthetic */ SemSubList copy$default(SemSubList semSubList, int i, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = semSubList.id;
        }
        if ((i2 & 2) != 0) {
            str = semSubList.name;
        }
        if ((i2 & 4) != 0) {
            str2 = semSubList.ans;
        }
        return semSubList.copy(i, str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getAns() {
        return this.ans;
    }

    public final SemSubList copy(int id, String name, String ans) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(ans, "ans");
        return new SemSubList(id, name, ans);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SemSubList)) {
            return false;
        }
        SemSubList semSubList = (SemSubList) other;
        return this.id == semSubList.id && Intrinsics.areEqual(this.name, semSubList.name) && Intrinsics.areEqual(this.ans, semSubList.ans);
    }

    public int hashCode() {
        return (((this.id * 31) + this.name.hashCode()) * 31) + this.ans.hashCode();
    }

    public String toString() {
        return "SemSubList(id=" + this.id + ", name=" + this.name + ", ans=" + this.ans + ")";
    }

    public SemSubList(int i, String name, String ans) {
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