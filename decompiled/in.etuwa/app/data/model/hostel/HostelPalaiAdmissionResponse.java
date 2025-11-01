package in.etuwa.app.data.model.hostel;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HostelPalaiAdmissionResponse.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007\u0012\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0005j\b\u0012\u0004\u0012\u00020\t`\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b¢\u0006\u0002\u0010\u000eJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007HÆ\u0003J\u0019\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0005j\b\u0012\u0004\u0012\u00020\t`\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\u000bHÆ\u0003J\t\u0010\u001c\u001a\u00020\u000bHÆ\u0003J\t\u0010\u001d\u001a\u00020\u000bHÆ\u0003Je\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0005j\b\u0012\u0004\u0012\u00020\t`\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001f\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u000bHÖ\u0001R\u0011\u0010\r\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R!\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0005j\b\u0012\u0004\u0012\u00020\t`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013¨\u0006$"}, d2 = {"Lin/etuwa/app/data/model/hostel/HostelPalaiAdmissionResponse;", "", FirebaseAnalytics.Event.LOGIN, "", "types", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/hostel/HostelFeeTypes;", "Lkotlin/collections/ArrayList;", "hostel", "Lin/etuwa/app/data/model/hostel/HostelPalaiAdmission;", "fine", "", FirebaseAnalytics.Param.METHOD, "date", "(ZLjava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDate", "()Ljava/lang/String;", "getFine", "getHostel", "()Ljava/util/ArrayList;", "getLogin", "()Z", "getMethod", "getTypes", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class HostelPalaiAdmissionResponse {
    private final String date;
    private final String fine;
    private final ArrayList<HostelPalaiAdmission> hostel;
    private final boolean login;
    private final String method;
    private final ArrayList<HostelFeeTypes> types;

    public static /* synthetic */ HostelPalaiAdmissionResponse copy$default(HostelPalaiAdmissionResponse hostelPalaiAdmissionResponse, boolean z, ArrayList arrayList, ArrayList arrayList2, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = hostelPalaiAdmissionResponse.login;
        }
        if ((i & 2) != 0) {
            arrayList = hostelPalaiAdmissionResponse.types;
        }
        ArrayList arrayList3 = arrayList;
        if ((i & 4) != 0) {
            arrayList2 = hostelPalaiAdmissionResponse.hostel;
        }
        ArrayList arrayList4 = arrayList2;
        if ((i & 8) != 0) {
            str = hostelPalaiAdmissionResponse.fine;
        }
        String str4 = str;
        if ((i & 16) != 0) {
            str2 = hostelPalaiAdmissionResponse.method;
        }
        String str5 = str2;
        if ((i & 32) != 0) {
            str3 = hostelPalaiAdmissionResponse.date;
        }
        return hostelPalaiAdmissionResponse.copy(z, arrayList3, arrayList4, str4, str5, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<HostelFeeTypes> component2() {
        return this.types;
    }

    public final ArrayList<HostelPalaiAdmission> component3() {
        return this.hostel;
    }

    /* renamed from: component4, reason: from getter */
    public final String getFine() {
        return this.fine;
    }

    /* renamed from: component5, reason: from getter */
    public final String getMethod() {
        return this.method;
    }

    /* renamed from: component6, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    public final HostelPalaiAdmissionResponse copy(boolean login, ArrayList<HostelFeeTypes> types, ArrayList<HostelPalaiAdmission> hostel, String fine, String method, String date) {
        Intrinsics.checkNotNullParameter(types, "types");
        Intrinsics.checkNotNullParameter(hostel, "hostel");
        Intrinsics.checkNotNullParameter(fine, "fine");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(date, "date");
        return new HostelPalaiAdmissionResponse(login, types, hostel, fine, method, date);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HostelPalaiAdmissionResponse)) {
            return false;
        }
        HostelPalaiAdmissionResponse hostelPalaiAdmissionResponse = (HostelPalaiAdmissionResponse) other;
        return this.login == hostelPalaiAdmissionResponse.login && Intrinsics.areEqual(this.types, hostelPalaiAdmissionResponse.types) && Intrinsics.areEqual(this.hostel, hostelPalaiAdmissionResponse.hostel) && Intrinsics.areEqual(this.fine, hostelPalaiAdmissionResponse.fine) && Intrinsics.areEqual(this.method, hostelPalaiAdmissionResponse.method) && Intrinsics.areEqual(this.date, hostelPalaiAdmissionResponse.date);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    public int hashCode() {
        boolean z = this.login;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (((((((((r0 * 31) + this.types.hashCode()) * 31) + this.hostel.hashCode()) * 31) + this.fine.hashCode()) * 31) + this.method.hashCode()) * 31) + this.date.hashCode();
    }

    public String toString() {
        return "HostelPalaiAdmissionResponse(login=" + this.login + ", types=" + this.types + ", hostel=" + this.hostel + ", fine=" + this.fine + ", method=" + this.method + ", date=" + this.date + ")";
    }

    public HostelPalaiAdmissionResponse(boolean z, ArrayList<HostelFeeTypes> types, ArrayList<HostelPalaiAdmission> hostel, String fine, String method, String date) {
        Intrinsics.checkNotNullParameter(types, "types");
        Intrinsics.checkNotNullParameter(hostel, "hostel");
        Intrinsics.checkNotNullParameter(fine, "fine");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(date, "date");
        this.login = z;
        this.types = types;
        this.hostel = hostel;
        this.fine = fine;
        this.method = method;
        this.date = date;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<HostelFeeTypes> getTypes() {
        return this.types;
    }

    public final ArrayList<HostelPalaiAdmission> getHostel() {
        return this.hostel;
    }

    public final String getFine() {
        return this.fine;
    }

    public final String getMethod() {
        return this.method;
    }

    public final String getDate() {
        return this.date;
    }
}