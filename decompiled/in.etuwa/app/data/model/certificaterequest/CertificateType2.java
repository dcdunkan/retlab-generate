package in.etuwa.app.data.model.certificaterequest;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CertificateType2.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class CertificateType2 {
    private final String name;

    public static /* synthetic */ CertificateType2 copy$default(CertificateType2 certificateType2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = certificateType2.name;
        }
        return certificateType2.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final CertificateType2 copy(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new CertificateType2(name);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof CertificateType2) && Intrinsics.areEqual(this.name, ((CertificateType2) other).name);
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    public String toString() {
        return "CertificateType2(name=" + this.name + ")";
    }

    public CertificateType2(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
    }

    public final String getName() {
        return this.name;
    }
}