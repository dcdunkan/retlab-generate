package in.etuwa.app.data.model.institutions;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Colleges.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class Colleges {

    @SerializedName("base_url")
    @Expose
    private final String baseUrl;

    @SerializedName("clgId")
    @Expose
    private final String clgId;

    @SerializedName("clgName")
    @Expose
    private final String clgName;

    @SerializedName("regUrl")
    @Expose
    private final String regUrl;

    public static /* synthetic */ Colleges copy$default(Colleges colleges, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = colleges.clgId;
        }
        if ((i & 2) != 0) {
            str2 = colleges.baseUrl;
        }
        if ((i & 4) != 0) {
            str3 = colleges.regUrl;
        }
        if ((i & 8) != 0) {
            str4 = colleges.clgName;
        }
        return colleges.copy(str, str2, str3, str4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getClgId() {
        return this.clgId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getBaseUrl() {
        return this.baseUrl;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getRegUrl() {
        return this.regUrl;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getClgName() {
        return this.clgName;
    }

    public final Colleges copy(String clgId, String baseUrl, String regUrl, String clgName) {
        Intrinsics.checkNotNullParameter(clgId, "clgId");
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        Intrinsics.checkNotNullParameter(regUrl, "regUrl");
        Intrinsics.checkNotNullParameter(clgName, "clgName");
        return new Colleges(clgId, baseUrl, regUrl, clgName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Colleges)) {
            return false;
        }
        Colleges colleges = (Colleges) other;
        return Intrinsics.areEqual(this.clgId, colleges.clgId) && Intrinsics.areEqual(this.baseUrl, colleges.baseUrl) && Intrinsics.areEqual(this.regUrl, colleges.regUrl) && Intrinsics.areEqual(this.clgName, colleges.clgName);
    }

    public int hashCode() {
        return (((((this.clgId.hashCode() * 31) + this.baseUrl.hashCode()) * 31) + this.regUrl.hashCode()) * 31) + this.clgName.hashCode();
    }

    public Colleges(String clgId, String baseUrl, String regUrl, String clgName) {
        Intrinsics.checkNotNullParameter(clgId, "clgId");
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        Intrinsics.checkNotNullParameter(regUrl, "regUrl");
        Intrinsics.checkNotNullParameter(clgName, "clgName");
        this.clgId = clgId;
        this.baseUrl = baseUrl;
        this.regUrl = regUrl;
        this.clgName = clgName;
    }

    public final String getClgId() {
        return this.clgId;
    }

    public final String getBaseUrl() {
        return this.baseUrl;
    }

    public final String getRegUrl() {
        return this.regUrl;
    }

    public final String getClgName() {
        return this.clgName;
    }

    public String toString() {
        return this.clgName;
    }
}