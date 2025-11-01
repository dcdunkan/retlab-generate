package in.etuwa.app.data.model.result.moduletest;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ResultModuleTest.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lin/etuwa/app/data/model/result/moduletest/ResultModuleTest;", "", "subject", "", "mark", "(Ljava/lang/String;Ljava/lang/String;)V", "getMark", "()Ljava/lang/String;", "getSubject", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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