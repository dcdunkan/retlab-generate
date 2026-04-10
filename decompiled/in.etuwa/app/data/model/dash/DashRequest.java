package in.etuwa.app.data.model.dash;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DashRequest.kt */
/* loaded from: classes3.dex */
public final /* data */ class DashRequest {
    private final String hostel;

    public static /* synthetic */ DashRequest copy$default(DashRequest dashRequest, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = dashRequest.hostel;
        }
        return dashRequest.copy(str);
    }

    /* renamed from: component1, reason: from getter */
    public final String getHostel() {
        return this.hostel;
    }

    public final DashRequest copy(String hostel) {
        return new DashRequest(hostel);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof DashRequest) && Intrinsics.areEqual(this.hostel, ((DashRequest) other).hostel);
    }

    public int hashCode() {
        String str = this.hostel;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        return "DashRequest(hostel=" + this.hostel + ")";
    }

    public DashRequest(String str) {
        this.hostel = str;
    }

    public final String getHostel() {
        return this.hostel;
    }
}