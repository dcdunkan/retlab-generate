package in.etuwa.app.data.model.quiz.submit;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SubmitRequest.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lin/etuwa/app/data/model/quiz/submit/SubmitRequest;", "", "qno", "", "option", "(Ljava/lang/String;Ljava/lang/String;)V", "getOption", "()Ljava/lang/String;", "getQno", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class SubmitRequest {
    private final String option;
    private final String qno;

    public static /* synthetic */ SubmitRequest copy$default(SubmitRequest submitRequest, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = submitRequest.qno;
        }
        if ((i & 2) != 0) {
            str2 = submitRequest.option;
        }
        return submitRequest.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getQno() {
        return this.qno;
    }

    /* renamed from: component2, reason: from getter */
    public final String getOption() {
        return this.option;
    }

    public final SubmitRequest copy(String qno, String option) {
        return new SubmitRequest(qno, option);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SubmitRequest)) {
            return false;
        }
        SubmitRequest submitRequest = (SubmitRequest) other;
        return Intrinsics.areEqual(this.qno, submitRequest.qno) && Intrinsics.areEqual(this.option, submitRequest.option);
    }

    public int hashCode() {
        String str = this.qno;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.option;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "SubmitRequest(qno=" + this.qno + ", option=" + this.option + ")";
    }

    public SubmitRequest(String str, String str2) {
        this.qno = str;
        this.option = str2;
    }

    public final String getQno() {
        return this.qno;
    }

    public final String getOption() {
        return this.option;
    }
}