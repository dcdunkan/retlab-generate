package in.etuwa.app.data.model.result.moduletest;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ResultModuleTestResponse.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\u0002\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR&\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lin/etuwa/app/data/model/result/moduletest/ResultModuleTestResponse;", "", FirebaseAnalytics.Event.LOGIN, "", "moduleTest", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/result/moduletest/ResultModuleTest;", "Lkotlin/collections/ArrayList;", "(ZLjava/util/ArrayList;)V", "getLogin", "()Z", "getModuleTest", "()Ljava/util/ArrayList;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ResultModuleTestResponse {
    private final boolean login;

    @SerializedName("module_test")
    @Expose
    private final ArrayList<ResultModuleTest> moduleTest;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ResultModuleTestResponse copy$default(ResultModuleTestResponse resultModuleTestResponse, boolean z, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            z = resultModuleTestResponse.login;
        }
        if ((i & 2) != 0) {
            arrayList = resultModuleTestResponse.moduleTest;
        }
        return resultModuleTestResponse.copy(z, arrayList);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<ResultModuleTest> component2() {
        return this.moduleTest;
    }

    public final ResultModuleTestResponse copy(boolean login, ArrayList<ResultModuleTest> moduleTest) {
        Intrinsics.checkNotNullParameter(moduleTest, "moduleTest");
        return new ResultModuleTestResponse(login, moduleTest);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ResultModuleTestResponse)) {
            return false;
        }
        ResultModuleTestResponse resultModuleTestResponse = (ResultModuleTestResponse) other;
        return this.login == resultModuleTestResponse.login && Intrinsics.areEqual(this.moduleTest, resultModuleTestResponse.moduleTest);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z = this.login;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (r0 * 31) + this.moduleTest.hashCode();
    }

    public String toString() {
        return "ResultModuleTestResponse(login=" + this.login + ", moduleTest=" + this.moduleTest + ")";
    }

    public ResultModuleTestResponse(boolean z, ArrayList<ResultModuleTest> moduleTest) {
        Intrinsics.checkNotNullParameter(moduleTest, "moduleTest");
        this.login = z;
        this.moduleTest = moduleTest;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<ResultModuleTest> getModuleTest() {
        return this.moduleTest;
    }
}