package in.etuwa.app.data.model.institutions;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Colleges.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\b\u0010\u0017\u001a\u00020\u0003H\u0016R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lin/etuwa/app/data/model/institutions/Colleges;", "", "clgId", "", "baseUrl", "regUrl", "clgName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBaseUrl", "()Ljava/lang/String;", "getClgId", "getClgName", "getRegUrl", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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

    /* renamed from: component1, reason: from getter */
    public final String getClgId() {
        return this.clgId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getBaseUrl() {
        return this.baseUrl;
    }

    /* renamed from: component3, reason: from getter */
    public final String getRegUrl() {
        return this.regUrl;
    }

    /* renamed from: component4, reason: from getter */
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