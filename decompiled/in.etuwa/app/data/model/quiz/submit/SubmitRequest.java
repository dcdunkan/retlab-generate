package in.etuwa.app.data.model.quiz.submit;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SubmitRequest.kt */
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