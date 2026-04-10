package in.etuwa.app.data.model.exam;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ModuleTestResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class ModuleTestResponse {
    private final String error;
    private final boolean login;

    @SerializedName("module_test")
    @Expose
    private final ArrayList<Exam> moduleTest;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ModuleTestResponse copy$default(ModuleTestResponse moduleTestResponse, boolean z, ArrayList arrayList, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = moduleTestResponse.login;
        }
        if ((i & 2) != 0) {
            arrayList = moduleTestResponse.moduleTest;
        }
        if ((i & 4) != 0) {
            str = moduleTestResponse.error;
        }
        return moduleTestResponse.copy(z, arrayList, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<Exam> component2() {
        return this.moduleTest;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getError() {
        return this.error;
    }

    public final ModuleTestResponse copy(boolean login, ArrayList<Exam> moduleTest, String error) {
        Intrinsics.checkNotNullParameter(moduleTest, "moduleTest");
        Intrinsics.checkNotNullParameter(error, "error");
        return new ModuleTestResponse(login, moduleTest, error);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModuleTestResponse)) {
            return false;
        }
        ModuleTestResponse moduleTestResponse = (ModuleTestResponse) other;
        return this.login == moduleTestResponse.login && Intrinsics.areEqual(this.moduleTest, moduleTestResponse.moduleTest) && Intrinsics.areEqual(this.error, moduleTestResponse.error);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z = this.login;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (((r0 * 31) + this.moduleTest.hashCode()) * 31) + this.error.hashCode();
    }

    public String toString() {
        return "ModuleTestResponse(login=" + this.login + ", moduleTest=" + this.moduleTest + ", error=" + this.error + ")";
    }

    public ModuleTestResponse(boolean z, ArrayList<Exam> moduleTest, String error) {
        Intrinsics.checkNotNullParameter(moduleTest, "moduleTest");
        Intrinsics.checkNotNullParameter(error, "error");
        this.login = z;
        this.moduleTest = moduleTest;
        this.error = error;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<Exam> getModuleTest() {
        return this.moduleTest;
    }

    public final String getError() {
        return this.error;
    }
}