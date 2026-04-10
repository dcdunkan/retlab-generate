package in.etuwa.app.data.model.result.moduletest;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ResultModuleTest.kt */
/* loaded from: classes3.dex */
public final /* data */ class ResultModuleTest {
    private final String mark;
    private final String subject;

    public static /* synthetic */ ResultModuleTest copy$default(ResultModuleTest resultModuleTest, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = resultModuleTest.subject;
        }
        if ((i & 2) != 0) {
            str2 = resultModuleTest.mark;
        }
        return resultModuleTest.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getSubject() {
        return this.subject;
    }

    /* renamed from: component2, reason: from getter */
    public final String getMark() {
        return this.mark;
    }

    public final ResultModuleTest copy(String subject, String mark) {
        Intrinsics.checkNotNullParameter(subject, "subject");
        Intrinsics.checkNotNullParameter(mark, "mark");
        return new ResultModuleTest(subject, mark);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ResultModuleTest)) {
            return false;
        }
        ResultModuleTest resultModuleTest = (ResultModuleTest) other;
        return Intrinsics.areEqual(this.subject, resultModuleTest.subject) && Intrinsics.areEqual(this.mark, resultModuleTest.mark);
    }

    public int hashCode() {
        return (this.subject.hashCode() * 31) + this.mark.hashCode();
    }

    public String toString() {
        return "ResultModuleTest(subject=" + this.subject + ", mark=" + this.mark + ")";
    }

    public ResultModuleTest(String subject, String mark) {
        Intrinsics.checkNotNullParameter(subject, "subject");
        Intrinsics.checkNotNullParameter(mark, "mark");
        this.subject = subject;
        this.mark = mark;
    }

    public final String getSubject() {
        return this.subject;
    }

    public final String getMark() {
        return this.mark;
    }
}